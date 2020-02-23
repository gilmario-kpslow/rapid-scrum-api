/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.seguranca;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 *
 * @author gilmario
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Bean
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public @interface UsuarioLogadoProducer {

}
