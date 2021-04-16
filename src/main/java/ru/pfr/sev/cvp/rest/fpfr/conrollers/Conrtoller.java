package ru.pfr.sev.cvp.rest.fpfr.conrollers;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class Conrtoller {
    @GetMapping("/employees")
    public String  say(){

        return "Привет всем";
    }

}
