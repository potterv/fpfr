package ru.pfr.sev.cvp.fpfr.db.entity.onetoone;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notices")
public class Notices {

    @Id
    @Column(name = "id_n")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
    private int id;
    @Column(name = "date_n")
    private Date dateNotices;
    @Column(name = "date_n_transfer")
    private Date dateNoticesTransfer;
    @Column(name = "date_n_in")
    private String dateNoticesIn;
    @Column(name = "control_date")
    private Date controlDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateNotices() {
        return dateNotices;
    }

    public void setDateNotices(Date dateNotices) {
        this.dateNotices = dateNotices;
    }

    public Date getDateNoticesTransfer() {
        return dateNoticesTransfer;
    }

    public void setDateNoticesTransfer(Date dateNoticesTransfer) {
        this.dateNoticesTransfer = dateNoticesTransfer;
    }

    public String getDateNoticesIn() {
        return dateNoticesIn;
    }

    public void setDateNoticesIn(String dateNoticesIn) {
        this.dateNoticesIn = dateNoticesIn;
    }

    public Date getControlDate() {
        return controlDate;
    }

    public void setControlDate(Date controlDate) {
        this.controlDate = controlDate;
    }

    public Notices() {
    }

    public Notices(Date dateNotices, Date dateNoticesTransfer, String dateNoticesIn, Date controlDate) {
        this.dateNotices = dateNotices;
        this.dateNoticesTransfer = dateNoticesTransfer;
        this.dateNoticesIn = dateNoticesIn;
        this.controlDate = controlDate;
    }

    @Override
    public String toString() {
        return "Notices{" +
                "id=" + id +
                ", dateNotices=" + dateNotices +
                ", dateNoticesTransfer=" + dateNoticesTransfer +
                ", dateNoticesIn='" + dateNoticesIn + '\'' +
                ", controlDate=" + controlDate +
                '}';
    }
}
