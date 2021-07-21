package ru.pfr.sev.cvp.service;


import ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Apendix;

public interface ApendixService {

   public void saveApendix(Apendix apendix);
   public Apendix getApendix(int id);


}
