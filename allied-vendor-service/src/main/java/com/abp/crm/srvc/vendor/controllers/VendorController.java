package com.abp.crm.srvc.vendor.controllers;

import com.abp.crm.srvc.vendor.commands.VendorForm;
import com.abp.crm.srvc.vendor.domain.Vendor;
import com.abp.crm.srvc.vendor.converters.VendorToVendorForm;
import com.abp.crm.srvc.vendor.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class VendorController {
    private VendorService vendorService;

    private VendorToVendorForm vendorToVendorForm;

    @Autowired
    public void setVendorToVendorForm(VendorToVendorForm vendorToVendorForm) {
        this.vendorToVendorForm = vendorToVendorForm;
    }

    @Autowired
    public void setVendorService(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/vendor/list";
    }

    @RequestMapping({"/vendor/list", "/vendor"})
    public String listVendorss(Model model){
        model.addAttribute("vendors", vendorService.listAll());
        return "vendor/list";
    }

    @RequestMapping("/vendor/show/{id}")
    public String getVendor(@PathVariable String id, Model model){
        model.addAttribute("vendor", vendorService.getById(Long.valueOf(id)));
        return "vendor/show";
    }

    @RequestMapping("vendor/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Vendor vendor = vendorService.getById(Long.valueOf(id));
        VendorForm vendorForm = vendorToVendorForm.convert(vendor);

        model.addAttribute("vendorForm", vendorForm);
        return "vendor/vendorform";
    }

    @RequestMapping("/vendor/new")
    public String newVendor(Model model){
        model.addAttribute("vendorForm", new VendorForm());
        return "vendor/vendorform";
    }

    @RequestMapping(value = "/vendor", method = RequestMethod.POST)
    public String saveOrUpdateVendor(@Valid VendorForm vendorForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "vendor/vendorform";
        }

        Vendor savedVendor = vendorService.saveOrUpdateVendorForm(vendorForm);

        return "redirect:/vendor/show/" + savedVendor.getId();
    }

    @RequestMapping("/vendor/delete/{id}")
    public String delete(@PathVariable String id){
        vendorService.delete(Long.valueOf(id));
        return "redirect:/vendor/list";
    }
}
