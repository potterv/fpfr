package ru.pfr.sev.cvp.rest.fpfr.db.entity;

import javax.persistence.*;


@Entity
@Table(name = "employers")
public class Employer {
    @Id
    @Column(name = "id_e")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
    private int id;

    @Column(name ="e_regnum")
    private String regNum;

    @Column(name= "e_name")
    private String name;

//    @OneToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JoinColumn(name = "id_n")
    @Column(name="n_id")
    private int notices_id;

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

    public int getNotices_id() {
        return notices_id;
    }

    public void setNotices_id(int notices_id) {
        this.notices_id = notices_id;
    }

    public Employer() {

    }

    public Employer(String regNum, String name, int notices_id) {
        this.regNum = regNum;
        this.name = name;
        this.notices_id = notices_id;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", regNum='" + regNum + '\'' +
                ", name='" + name + '\'' +
                ", notices_id='" + notices_id + '\'' +
                '}';
    }
}
