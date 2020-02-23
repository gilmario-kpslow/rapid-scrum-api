/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.seguranca.jwt;

import br.com.rapidscrum.seguranca.UsuarioDetalhes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author gilmario
 */
@Component
public class JWTUtil {

    @Value("${jwt-token-validade}")
    private String validadeToken;

    @Value("${jwt-token-secret}")
    private String tokenSecret;

    @Autowired
    private RequestUtil requestUtil;

    @Autowired
    private HttpServletRequest request;

    public String getUsernameFromToken() {
        return getUsernameFromToken(request);
    }

    public String getUsernameFromToken(HttpServletRequest request) {
        return getUsernameFromToken(requestUtil.getTokenFromHeader(request));
    }

    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token, Claims::getSubject);
    }

    public LocalDateTime getExpirationFromToken(String token) {
        return LocalDateTime.ofInstant(getClaimsFromToken(token, Claims::getExpiration).toInstant(), ZoneId.systemDefault());
    }

    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token) {
        final LocalDateTime expiration = getExpirationFromToken(token);
        return expiration.isBefore(LocalDateTime.now());
    }

    public String generateToken(UsuarioDetalhes usuarioDetalhes) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerate(claims, usuarioDetalhes.getUsername());
    }

    private String doGenerate(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(validadeToken) * 1000))
                .signWith(SignatureAlgorithm.HS512, tokenSecret)
                .compact();
    }

    public boolean validateToken(String token, UsuarioDetalhes usuarioDetalhes) {
        final String username = getUsernameFromToken(token);
        return (username.equals(usuarioDetalhes.getUsername()) && !isTokenExpired(token));
    }

}
