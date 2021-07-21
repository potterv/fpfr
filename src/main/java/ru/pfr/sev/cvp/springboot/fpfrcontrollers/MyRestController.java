package ru.pfr.sev.cvp.springboot.fpfrcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pfr.sev.cvp.fpfr.db.entity.Employeer;
import ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Apendix;
import ru.pfr.sev.cvp.service.*;


import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
//@Deprecated
public class MyRestController {
    @Autowired
    private EmployeerService employerService;
    @Autowired
    private ApendixService apendixService;
//        @CrossOrigin(origins = "*")
    @GetMapping(value = "/employeers")
    public List<Employeer> showAllEmployers() {
        List<Employeer> allEmployeers = employerService.getAllEmployeers();
        return allEmployeers;
    }

    //    @CrossOrigin(origins = "*")
    @GetMapping("/employeers/{id}")
    public Employeer getEmployeer(@PathVariable int id) {
        Employeer employeer = employerService.getEmployeer(id);
        return employeer;
    }

    //    @CrossOrigin(origins = "*")
    @PostMapping(value = "/employeers")
    public Employeer addNewEmployeer(@RequestBody Employeer employeer) {
        employerService.saveEmployeer(employeer);
        return employeer;
    }


    //    @CrossOrigin(origins = "*")
    @PutMapping(value = "/employeers")
    public Employeer updateEmployeer(@RequestBody Employeer employeer) {
        employerService.saveEmployeer(employeer);
        return employeer;
    }
    @PutMapping(value = "/apendixs")
    public Apendix updateApendix(@RequestBody Apendix apendix) {
        apendixService.saveApendix(apendix);
        return apendix;
    }

    @GetMapping("/apendix/{id}")
    public Apendix getApendix(@PathVariable int id) {
        Apendix apendix = apendixService.getApendix(id);
        return apendix;
    }


    //    @CrossOrigin(origins = "*")
    @DeleteMapping("/employeers/{id}")
    public void deleteEmployeer(@PathVariable int id) {
        employerService.deleteEmployeer(id);

    }


}
