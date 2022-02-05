package ru.pfr.sev.cvp.springdatejpa;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.pfr.sev.cvp.fpfr.db.entity.Employeer;
@Repository
@Transactional
public interface EmployeerRepository extends JpaRepository <Employeer,Integer>{


}
