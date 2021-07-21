package ru.pfr.sev.cvp.fpfr.db.entity.onetomany;

import javax.persistence.*;

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

//    private  int e_id;
//     @Column(name = "e_id")
//    public int getE_id() {
//        return e_id;
//    }
//
//    public void setE_id(int e_id) {
//        this.e_id = e_id;
//    }

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

    public Intelligence(String type, String month, String i_year, int kolzl) {
        this.type = type;
        this.month = month;
        this.i_year = i_year;
        this.kolzl = kolzl;
    }


    @Override
    public String toString() {
        return "Intelligence{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", month='" + month + '\'' +
                ", i_year='" + i_year + '\'' +
                ", kolzl=" + kolzl +

                '}';
    }
}
