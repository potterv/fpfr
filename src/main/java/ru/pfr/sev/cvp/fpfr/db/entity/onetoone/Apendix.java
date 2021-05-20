package ru.pfr.sev.cvp.fpfr.db.entity.onetoone;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Apendix")
public class Apendix {

    @Id
    @Column(name = "id_a")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
    private int id;

//    @Column(name = "reg_num_a")
//    private String regNumApendix;

    @Column(name = "date_fact")
    private Date dateFact;

    @Column(name = "date_act")
    private Date dateAct;

    @Column(name = "primechanie")
    private String primechanie;

    @Column(name = "")
    private String protockol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getRegNumApendix() {
//        return regNumApendix;
//    }
//
//    public void setRegNumApendix(String regNumApendix) {
//        this.regNumApendix = regNumApendix;
//    }

    public Date getDateFact() {
        return dateFact;
    }

    public void setDateFact(Date dateFact) {
        this.dateFact = dateFact;
    }

    public Date getDateAct() {
        return dateAct;
    }

    public void setDateAct(Date dateAct) {
        this.dateAct = dateAct;
    }

    public String getPrimechanie() {
        return primechanie;
    }

    public void setPrimechanie(String primechanie) {
        this.primechanie = primechanie;
    }

    public String getProtockol() {
        return protockol;
    }

    public void setProtockol(String protockol) {
        this.protockol = protockol;
    }

    public Apendix() {
    }

    public Apendix( Date dateFact, Date dateAct, String primechanie, String protockol) {
//        this.regNumApendix = regNumApendix;
        this.dateFact = dateFact;
        this.dateAct = dateAct;
        this.primechanie = primechanie;
        this.protockol = protockol;
    }

    @Override
    public String toString() {
        return "Apendix{" +
                "id=" + id +
//                ", regNumApendix='" + regNumApendix + '\'' +
                ", dateFact=" + dateFact +
                ", dateAct=" + dateAct +
                ", primechanie='" + primechanie + '\'' +
                ", protockol='" + protockol + '\'' +
                '}';
    }
}
