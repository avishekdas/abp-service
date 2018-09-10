package com.abp.crm.srvc.vendor.converters;

import com.abp.crm.srvc.vendor.commands.VendorForm;
import com.abp.crm.srvc.vendor.domain.Vendor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class VendorFormToVendor implements Converter<VendorForm, Vendor> {

    @Override
    public Vendor convert(VendorForm vendorForm) {
        Vendor vendor = new Vendor();
        if (vendorForm.getId() != null  && !StringUtils.isEmpty(vendorForm.getId())) {
            vendor.setId(new Long(vendorForm.getId()));
        }
        vendor.setGstno(vendorForm.getGstno());
        vendor.setName(vendorForm.getName());
        vendor.setPan(vendorForm.getPan());
        vendor.setSecuritydeposit(vendorForm.getSecuritydeposit());
        vendor.setVendorcode(vendorForm.getVendorcode());
        vendor.setCategory(vendorForm.getCategory());
        return vendor;
    }
}
