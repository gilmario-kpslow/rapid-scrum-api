/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.rapidscrum;

import java.util.logging.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author gilmario
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private Logger logger = Logger.getLogger(WebConfig.class.getName());

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("Iniciando Configuração---------------------------------------------------------------------------");
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
