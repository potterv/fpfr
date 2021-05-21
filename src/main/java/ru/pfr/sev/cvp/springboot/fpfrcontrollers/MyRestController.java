package ru.pfr.sev.cvp.springboot.fpfrcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pfr.sev.cvp.fpfr.db.entity.Employeer;
import ru.pfr.sev.cvp.service.*;



import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
@Autowired
    private EmployeerService employerService;
    
    @GetMapping("/employeers")
    public List<Employeer> showAllEmployers(){
        List<Employeer> allEmployeers = employerService.getAllEmployeers();
        return allEmployeers;
    }
    
    @GetMapping("/employeers/{id}")
    public Employeer getEmployeer(@PathVariable int id){
        Employeer employeer = employerService.getEmployeer(id);
        return employeer;
     }


     @PostMapping("/employeers")
     public  Employeer addNewEmployeer (@RequestBody Employeer employeer){
        employerService.saveEmployeer(employeer);
        return employeer;
    }
    @PutMapping("/employeers")
    public Employeer updateEmployeer(@RequestBody Employeer employeer){
        employerService.saveEmployeer(employeer);
        return employeer;
    }

    @DeleteMapping("/employeers/{id}")
    public void deleteEmployeer (@PathVariable int id){
        employerService.deleteEmployeer(id);

    }

}
