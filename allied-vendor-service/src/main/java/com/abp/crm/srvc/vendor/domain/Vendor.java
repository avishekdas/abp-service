package com.abp.crm.srvc.vendor.domain;


import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "abpm_allied_vendor")
public class Vendor {

    @Id
    @GeneratedValue
    private Long _id;
    private String name;
    private String vendorcode;
    private String gstno;
    private String pan;
    private BigDecimal securitydeposit;
    private String category;

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendorcode() {
        return vendorcode;
    }

    public void setVendorcode(String vendorcode) {
        this.vendorcode = vendorcode;
    }

    public String getGstno() {
        return gstno;
    }

    public void setGstno(String gstno) {
        this.gstno = gstno;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public BigDecimal getSecuritydeposit() {
        return securitydeposit;
    }

    public void setSecuritydeposit(BigDecimal securitydeposit) {
        this.securitydeposit = securitydeposit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
