package com.abp.crm.srvc.booking.services;

import com.abp.crm.srvc.booking.commands.BookingForm;
import com.abp.crm.srvc.booking.domain.Booking;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface BookingService {

    List<Booking> listAll();

    Booking getById(Long id);

    Booking saveOrUpdate(Booking booking);

    void delete(Long id);

    Booking saveOrUpdateBookingForm(BookingForm bookingForm);
}
