package ru.pfr.sev.cvp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Apendix;
import ru.pfr.sev.cvp.springdatejpa.ApendixRepository;

import java.util.Optional;

//@Deprecated
@Service
public class ApendixServiceImpl implements ApendixService {
    @Autowired
    private ApendixRepository apendixRepository;

    @Override
    public void saveApendix(Apendix apendix) {
        apendixRepository.save(apendix);
    }

    @Override
    public Apendix getApendix(int id) {
        Apendix apendix =null;
        Optional<Apendix> optionl = apendixRepository.findById(id);
        if (optionl.isPresent()){
            apendix = optionl.get();
        }
        return apendix;
    }



}
