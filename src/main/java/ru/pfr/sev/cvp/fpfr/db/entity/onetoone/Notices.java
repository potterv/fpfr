package ru.pfr.sev.cvp.fpfr.db.entity.onetoone;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;
import java.util.Formatter;

@Entity
@Table(name = "notices")
public class Notices {

    @Id
    @Column(name = "id_n")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
    private int id;
    @Column(name = "date_n")
    private LocalDate dateNotices;
    @Column(name = "date_n_transfer")
    private LocalDate dateNoticesTransfer;
    @Column(name = "date_n_in")
    private String dateNoticesIn;
    @Column(name = "control_date")
    private LocalDate controlDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateNotices() throws ParseException {
       return this.dateNotices;
    }

    public void setDateNotices(LocalDate dateNotices) {
        this.dateNotices = dateNotices;
    }

    public LocalDate getDateNoticesTransfer() {
        return dateNoticesTransfer;
    }

    public void setDateNoticesTransfer(LocalDate dateNoticesTransfer) {
        this.dateNoticesTransfer = dateNoticesTransfer;
    }

    public String getDateNoticesIn() {
        return dateNoticesIn;
    }

    public void setDateNoticesIn(String dateNoticesIn) {
        this.dateNoticesIn = dateNoticesIn;
    }

    public LocalDate getControlDate() {
        return controlDate;
    }

    public void setControlDate(LocalDate controlDate) {
        this.controlDate = controlDate;
    }

    public Notices() {
    }

    public Notices(LocalDate dateNotices, LocalDate dateNoticesTransfer, String dateNoticesIn, LocalDate controlDate) {
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
