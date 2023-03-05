package cz.upce.nnpia.cv01;

import org.springframework.web.bind.annotation.*;

@RestController
/*
    @Controller - starší verze anotace, automaticky vrací název pohledu, který je překladačem vygenerován jako
    konečný HTML pohled. Pokud pak chceme vracet JSON nebo XML, musíme ke každé metodě přidávat anotaci @ResponseBody.
    @RestController - novější verze anotace, přidává automaticky anotaci @ResponseBody ke všem metodám,
    anotace @ResponseBody, @RestController je tedy kombinací anotací @Controller a @ResponseBody
 */
//@RequestMapping("/api/v1")
/*
    XML - objekty a parametry jsou zadávány pomocí tagů, obdobně jako v HTML
    YAML - objekty a jejich parametry jsou rozlišovýny pomocí tabulátorů
    JSON - objekty jsou uvozeny složenými závorkami, názvy parametrů pak jsou v uvozovkách následovanými dvojtečkou,
    za kterou je hodnota parametru, pole jsou zde reprezentovány hranatými závorami
 */
public class HelloController {
    @GetMapping("")
    public String helloWorld() {
        return "Hello world from Spring Boot application.";
    }

    @GetMapping("/{name}")
    public String helloName(@PathVariable String name){
        return String.format("Hello %s from Spring Boot application.",name);
    }

    @GetMapping("/param")
    public String helloParam(@RequestParam("param") String param){
        return String.format("Hello from Spring Boot application, you type this param: %s",param);
    }

    @PostMapping("")
    public String helloPost(@RequestBody HelloDto helloDto){
        return String.format("Hello %s %s from Spring Boot application, you are %d y.o.",helloDto.getFirstName(), helloDto.getLastName(),helloDto.getAge());
    }
}
