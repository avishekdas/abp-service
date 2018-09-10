package com.abp.crm.srvc.vendor.converters;

import com.abp.crm.srvc.vendor.commands.VendorForm;
import com.abp.crm.srvc.vendor.domain.Vendor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class VendorToVendorForm implements Converter<Vendor, VendorForm> {
    @Override
    public VendorForm convert(Vendor vendor) {
        VendorForm vendorForm = new VendorForm();
        vendorForm.setId(vendor.getId());
        vendorForm.setGstno(vendor.getGstno());
        vendorForm.setSecuritydeposit(vendor.getSecuritydeposit());
        vendorForm.setVendorcode(vendor.getVendorcode());
        vendorForm.setPan(vendor.getPan());
        vendorForm.setName(vendor.getName());
        vendorForm.setCategory(vendor.getCategory());
        return vendorForm;
    }
}
