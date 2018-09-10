package com.abp.crm.srvc.booking.domain;


import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "abpm_allied_booking")
public class Booking {

    @Id
    @GeneratedValue
    private Long _id;
    private Long bookedbymgrid;
    private Long assignedmgrid;
    private Long vendorid;
    private Timestamp startdate;
    private Timestamp enddate;


    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        this._id = id;
    }

    public Long getBookedbymgrid() {
        return bookedbymgrid;
    }

    public void setBookedbymgrid(Long bookedbymgrid) {
        this.bookedbymgrid = bookedbymgrid;
    }

    public Long getAssignedmgrid() {
        return assignedmgrid;
    }

    public void setAssignedmgrid(Long assignedmgrid) {
        this.assignedmgrid = assignedmgrid;
    }

    public Long getVendorid() {
        return vendorid;
    }

    public void setVendorid(Long vendorid) {
        this.vendorid = vendorid;
    }

    public Timestamp getStartdate() {
        return startdate;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    public Timestamp getEnddate() {
        return enddate;
    }

    public void setEnddate(Timestamp enddate) {
        this.enddate = enddate;
    }
}
