/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.rapidscrum;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author gilmario
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CrosFilter implements Filter {

    private static final Logger logger = Logger.getLogger(CrosFilter.class.getName());

    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "*";
    private static final String ACCESS_CONTROL_ALLOW_METHODS = "POST,GET,OPTIONS,DELETE,PUT";
    private static final String ACCESS_CONTROL_MAX_AGE = "3600";
    private static final String ACCESS_CONTROL_ALLOW_HEADERS = "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN";

    @Override
    public void init(FilterConfig fc) throws ServletException {
        logger.info("True Pedido | SimpleCORSFilter loaded");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN);
        response.setHeader("Access-Control-Allow-Methods", ACCESS_CONTROL_ALLOW_METHODS);
        response.setHeader("Access-Control-Max-Age", ACCESS_CONTROL_MAX_AGE);
        response.setHeader("Access-Control-Allow-Headers", ACCESS_CONTROL_ALLOW_HEADERS);

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, resp);
        }

    }

    @Override
    public void destroy() {
    }

}
