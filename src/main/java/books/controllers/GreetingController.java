package books.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller("/")
public class GreetingController {

    @GetMapping("")
    public String sayHello(){
        return "Hello World";
    }
}
