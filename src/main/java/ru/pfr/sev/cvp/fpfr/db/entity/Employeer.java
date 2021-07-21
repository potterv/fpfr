package ru.pfr.sev.cvp.fpfr.db.entity;

import ru.pfr.sev.cvp.fpfr.db.entity.onetomany.Intelligence;
import ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Apendix;
import ru.pfr.sev.cvp.fpfr.db.entity.onetoone.Notices;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "employeer")
public class Employeer {
    @Id
    @Column(name = "id_e")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
    private int id;

    @Column(name ="e_regnum")
    private String regNum; 

    @Column(name= "e_name")
    private String name;

//    @OneToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "n_id")
    private Notices empNotices;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "a_id")
    private Apendix empApendix;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "e_id")
    private List<Intelligence> empIntelligence;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Notices getEmpNotices() {
        return empNotices;
    }

    public void setEmpNotices(Notices empNotices) {
        this.empNotices = empNotices;
    }

    public Employeer() {

    }

    public Employeer(String regNum, String name) {

        this.regNum = regNum;
        this.name = name;
    }

    public void addIntaligence(Intelligence intelligence){
        if (empIntelligence==null){
            empIntelligence = new ArrayList<>();
        }
            empIntelligence.add(intelligence);

    }

    public Apendix getEmpApendix() {
        return empApendix;
    }

    public void setEmpApendix(Apendix empApendix) {
        this.empApendix = empApendix;
    }

    public List<Intelligence> getEmpIntelligence() {
        return empIntelligence;
    }

    public void setEmpIntelligence(List<Intelligence> empIntelligence) {
        this.empIntelligence = empIntelligence;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", regNum='" + regNum + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
