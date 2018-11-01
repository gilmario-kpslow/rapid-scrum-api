package br.com.rapidscrum.rapidscrum.status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "status")
public class StatusResource {

    @GetMapping
    public Status status() {
        return new Status();
    }
}
