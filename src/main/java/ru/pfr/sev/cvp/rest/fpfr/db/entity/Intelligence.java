package ru.pfr.sev.cvp.rest.fpfr.db.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "intelligence")
public class Intelligence {

    @Id
    @Column(name ="id_i")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
    private int id;

    @Column(name = "i_type")
    private String type;

    @Column(name = "i_month")
    private String month;

    @Column(name = "i_year")
    private String i_year;

    @Column(name = "kolzl")
    private int kolzl;

    @ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JoinColumn(name = "id_e")
    @Column(name = "e_id")
    private List<Employer> employer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getI_year() {
        return i_year;
    }

    public void setI_year(String i_year) {
        this.i_year = i_year;
    }

    public int getKolzl() {
        return kolzl;
    }

    public void setKolzl(int kolzl) {
        this.kolzl = kolzl;
    }



    public Intelligence() {
    }




}
