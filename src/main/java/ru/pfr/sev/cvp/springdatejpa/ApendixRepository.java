package ru.pfr.sev.cvp.springdatejpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Apendix;

public interface   ApendixRepository extends JpaRepository<Apendix, Integer> {

}
