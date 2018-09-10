package com.abp.crm.srvc.vendor.services;

import com.abp.crm.srvc.vendor.commands.VendorForm;
import com.abp.crm.srvc.vendor.domain.Vendor;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface VendorService {

    List<Vendor> listAll();

    Vendor getById(Long id);

    Vendor saveOrUpdate(Vendor vendor);

    void delete(Long id);

    Vendor saveOrUpdateVendorForm(VendorForm vendorForm);
}
