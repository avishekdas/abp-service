package com.abp.crm.srvc.booking.controllers;

import com.abp.crm.srvc.booking.commands.BookingForm;
import com.abp.crm.srvc.booking.domain.Booking;
import com.abp.crm.srvc.booking.converters.BookingToBookingForm;
import com.abp.crm.srvc.booking.services.BookingService;
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
public class BookingController {
    private BookingService bookingService;

    private BookingToBookingForm bookingToBookingForm;

    @Autowired
    public void setBookingToBookingForm(BookingToBookingForm bookingToBookingForm) {
        this.bookingToBookingForm = bookingToBookingForm;
    }

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/booking/list";
    }

    @RequestMapping({"/booking/list", "/booking"})
    public String listBookings(Model model){
        model.addAttribute("bookings", bookingService.listAll());
        return "booking/list";
    }

    @RequestMapping("/booking/show/{id}")
    public String getBooking(@PathVariable String id, Model model){
        model.addAttribute("booking", bookingService.getById(Long.valueOf(id)));
        return "booking/show";
    }

    @RequestMapping("booking/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Booking booking = bookingService.getById(Long.valueOf(id));
        BookingForm bookingForm = bookingToBookingForm.convert(booking);

        model.addAttribute("bookingForm", bookingForm);
        return "booking/bookingform";
    }

    @RequestMapping("/booking/new")
    public String newBooking(Model model){
        model.addAttribute("bookingForm", new BookingForm());
        return "booking/bookingform";
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public String saveOrUpdateBooking(@Valid BookingForm bookingForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "booking/bookingform";
        }

        Booking savedBooking = bookingService.saveOrUpdateBookingForm(bookingForm);

        return "redirect:/booking/show/" + savedBooking.getId();
    }

    @RequestMapping("/booking/delete/{id}")
    public String delete(@PathVariable String id){
        bookingService.delete(Long.valueOf(id));
        return "redirect:/booking/list";
    }
}
