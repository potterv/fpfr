package ru.pfr.sev.cvp.springdatejpa;



import org.springframework.data.jpa.repository.JpaRepository;
import ru.pfr.sev.cvp.fpfr.db.entity.Employeer;

import java.util.List;

public interface EmployeerRepository extends JpaRepository <Employeer,Integer>{

}
