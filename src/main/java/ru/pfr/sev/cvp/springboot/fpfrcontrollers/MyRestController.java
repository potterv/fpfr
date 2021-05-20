package ru.pfr.sev.cvp.springboot.fpfrcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pfr.sev.cvp.fpfr.db.entity.Employeer;
import ru.pfr.sev.cvp.service.*;



import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
@Autowired
    private EmployeerService employerService;
    
    @GetMapping("/employers")
    public List<Employeer> showAllEmployers(){
        List<Employeer> allEmployeers = employerService.getAllEmployeers();
//        List<Employer>  allEmployers = null;
        return allEmployeers;
    }
}
