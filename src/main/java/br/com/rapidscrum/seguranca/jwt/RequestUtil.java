/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.seguranca.jwt;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 *
 * @author gilmario
 */
@Component
public class RequestUtil {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    public String getTokenFromHeader(HttpServletRequest request) {
        return request.getHeader(AUTHORIZATION_HEADER);
    }

}
