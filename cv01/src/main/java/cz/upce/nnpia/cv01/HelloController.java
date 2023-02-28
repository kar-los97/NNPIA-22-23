package cz.upce.nnpia.cv01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
    @Controller - starší verze anotace, automaticky vrací název pohledu, který je překladačem vygenerován jako
    konečný HTML pohled. Pokud pak chceme vracet JSON nebo XML, musíme ke každé metodě přidávat anotaci @ResponseBody.
    @RestController - novější verze anotace, přidává automaticky anotaci @ResponseBody ke všem metodám,
    anotace @ResponseBody, @RestController je tedy kombinací anotací @Controller a @ResponseBody
 */
@RequestMapping("/api/v1")
public class HelloController {
    @GetMapping
    public String helloWorld() {
        return "Hello world from Spring Boot application.";
    }
}
