/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.seguranca;

import br.com.rapidscrum.seguranca.jwt.JWTUtil;
import br.com.rapidscrum.seguranca.jwt.RequestUtil;
import io.undertow.security.api.SecurityContext;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author gilmario
 */
@Component
public class SecurityRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jWTUtil;
    @Autowired
    private RequestUtil requestUtil;
    @Autowired
    private UsuarioDetalhesService detalhesService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        final String tokenHeader = requestUtil.getTokenFromHeader(request);

        String username = null;
        String token = null;

        if (Objects.nonNull(tokenHeader) && !"".equals(tokenHeader)) {
            token = tokenHeader;
            username = jWTUtil.getUsernameFromToken(tokenHeader);
        }

        if (Objects.nonNull(username) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {

            UsuarioDetalhes detalhes = detalhesService.loadUserByUsername(username);
            if (jWTUtil.validateToken(token, detalhes)) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(detalhes, null, detalhes.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

        }
        chain.doFilter(request, response);
    }

}
