package ru.pfr.sev.cvp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.pfr.sev.cvp.fpfr.db.entity.Employeer;
import ru.pfr.sev.cvp.springdatejpa.EmployeerRepository;


import java.util.List;
import java.util.Optional;
//@Deprecated
@Service
public class EmployeerServiceImpl implements EmployeerService {
    @Autowired
    private EmployeerRepository employeerRepository;

    @Override
    public List<Employeer> getAllEmployeers(){return employeerRepository.findAll();}


    @Override
    public void saveEmployeer(Employeer employer) {
        employeerRepository.save(employer);
    }

    @Override
    public Employeer getEmployeer(int id) {
        Employeer employeer =null;
        Optional<Employeer> optionl = employeerRepository.findById(id);
        if (optionl.isPresent()){
            employeer = optionl.get();
        }
        return employeer;
    }

    @Override
    public void deleteEmployeer(int id) {
       employeerRepository.deleteById(id);
    }




}
