package ru.pfr.sev.cvp.springmvc.conrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Conrtoller {

    @RequestMapping("/fpfr")
    public String  showFirstView(){

        return "first-view";
    }

}
