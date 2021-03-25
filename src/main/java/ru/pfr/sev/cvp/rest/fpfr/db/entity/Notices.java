package ru.pfr.sev.cvp.rest.fpfr.db.entity;

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
}
