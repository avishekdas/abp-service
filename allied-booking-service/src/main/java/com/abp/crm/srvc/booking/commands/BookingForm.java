package com.abp.crm.srvc.booking.commands;


import java.sql.Timestamp;

/**
 * Created by jt on 1/10/17.
 */
public class BookingForm {
    private Long id;
    private Long bookedbymgrid;
    private Long assignedmgrid;
    private Long vendorid;
    private String startdate;
    private String enddate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
}
