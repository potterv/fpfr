package ru.pfr.sev.cvp.fpfr.db.entity.integration;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.pfr.sev.cvp.fpfr.db.entity.Employeer;
import ru.pfr.sev.cvp.fpfr.db.entity.onetomany.Intelligence;
import ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Apendix;
import ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Notices;
import ru.pfr.sev.cvp.springdatejpa.ApendixRepository;
import ru.pfr.sev.cvp.springdatejpa.EmployeerRepository;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class TestOperationDataJpaTestSpringBoot {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeerRepository employeerRepository;

    @Autowired
    private ApendixRepository apendixRepository;

    @Test
    public void testCrud(){

          Employeer employeer = new Employeer();
          Apendix apendix = new Apendix();
          entityManager.persist(employeer);
          entityManager.flush();
    }


    @Test
    public void testReadData() {
        Employeer employeer = new Employeer("09200015664","ip alex");
        entityManager.persist(employeer);
        entityManager.flush();
        Employeer found = employeerRepository.findById(1).get();
        assertThat(found.getName()).isEqualTo(employeer.getName());
    }

    @Test
    public void testOneToOne(){
        Employeer employeer = new Employeer("00000000000","xxxx");

        Notices notices = new Notices(LocalDate.parse("2021-04-16"),
                LocalDate.parse("2021-04-16"),"2021-04-16",
                LocalDate.parse("2021-04-16"));
        employeer.setEmpNotices(notices);

        Apendix apendix = new Apendix(
                "2021-04-16",
                "2021-04-16",
                "-",
                "-");
        employeer.setEmpApendix(apendix);
        entityManager.persist(employeer);
        entityManager.flush();

        Employeer found = employeerRepository.findById(1).get();
        assertThat(found.getName()).isEqualTo(employeer.getName());
    }

    @Test
    public void testOneToMany(){
        Employeer employeer = new Employeer("00000000009","ooo pppp");
        Notices notices = new Notices(LocalDate.parse("2021-04-16"),
                LocalDate.parse("2021-04-16"),"2021-04-16",
                LocalDate.parse("2021-04-16"));
        employeer.setEmpNotices(notices);
        Apendix apendix = new Apendix("2021-04-16",
                "2021-04-16",
                "-",
                "-");
        employeer.setEmpApendix(apendix);
        employeer.addIntaligence(new Intelligence("5","1","7","18"));
        employeer.addIntaligence(new Intelligence("7","8","7","14"));

        entityManager.persist(employeer);
        entityManager.flush();

        Employeer found = employeerRepository.findById(1).get();
        assertThat(found.getName()).isEqualTo(employeer.getName());

    }


}
