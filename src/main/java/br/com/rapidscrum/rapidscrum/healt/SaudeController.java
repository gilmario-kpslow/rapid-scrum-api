/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.rapidscrum.healt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gilmario
 */
@RestController(value = "")
public class SaudeController {

    @GetMapping
    public String getStatus() {
        return "O Servidor est'a ok";
    }
}
