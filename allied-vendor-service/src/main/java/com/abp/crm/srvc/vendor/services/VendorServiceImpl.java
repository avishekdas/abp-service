package com.abp.crm.srvc.vendor.services;

import com.abp.crm.srvc.vendor.commands.VendorForm;
import com.abp.crm.srvc.vendor.converters.VendorFormToVendor;
import com.abp.crm.srvc.vendor.domain.Vendor;
import com.abp.crm.srvc.vendor.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class VendorServiceImpl implements VendorService {

    private VendorRepository vendorRepository;
    private VendorFormToVendor vendorFormToVendor;

    @Autowired
    public VendorServiceImpl(VendorRepository vendorRepository, VendorFormToVendor vendorFormToVendor) {
        this.vendorRepository = vendorRepository;
        this.vendorFormToVendor = vendorFormToVendor;
    }


    @Override
    public List<Vendor> listAll() {
        List<Vendor> vendors = new ArrayList<>();
        vendorRepository.findAll().forEach(vendors::add); //fun with Java 8
        return vendors;
    }

    @Override
    public Vendor getById(Long id) {
        return vendorRepository.findById(id).orElse(null);
    }

    @Override
    public Vendor saveOrUpdate(Vendor vendor) {
        vendorRepository.save(vendor);
        return vendor;
    }

    @Override
    public void delete(Long id) {
        vendorRepository.deleteById(id);

    }

    @Override
    public Vendor saveOrUpdateVendorForm(VendorForm vendorForm) {
        Vendor savedVendor = saveOrUpdate(vendorFormToVendor.convert(vendorForm));

        System.out.println("Saved Vendor Id: " + savedVendor.getId());
        return savedVendor;
    }
}
