package ru.pfr.sev.cvp.springboot.fpfrcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pfr.sev.cvp.fpfr.db.entity.Employeer;
import ru.pfr.sev.cvp.service.*;



import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequestMapping("/api")
@Deprecated
public class MyRestController {
@Autowired
    private EmployeerService employerService;
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/employeers")
    public List<Employeer> showAllEmployers(){
        List<Employeer> allEmployeers = employerService.getAllEmployeers();
        return allEmployeers;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/employeers/{id}")
    public Employeer getEmployeer(@PathVariable int id){
        Employeer employeer = employerService.getEmployeer(id);
        return employeer;
     }

    @CrossOrigin(origins = "*")
    @PostMapping(value ="/employeers")
     public  Employeer addNewEmployeer (@RequestBody Employeer employeer){
        employerService.saveEmployeer(employeer);
        return employeer;
    }
    @CrossOrigin(origins = "*")
    @PutMapping(value ="/employeers")
    public Employeer updateEmployeer(@RequestBody Employeer employeer){
        employerService.saveEmployeer(employeer);
        return employeer;
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/employeers/{id}")
    public void deleteEmployeer (@PathVariable int id){
        employerService.deleteEmployeer(id);

    }

}
