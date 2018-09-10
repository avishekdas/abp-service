package com.abp.crm.srvc.booking.services;

import com.abp.crm.srvc.booking.commands.BookingForm;
import com.abp.crm.srvc.booking.converters.BookingFormToBooking;
import com.abp.crm.srvc.booking.domain.Booking;
import com.abp.crm.srvc.booking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    private BookingFormToBooking bookingFormToBooking;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, BookingFormToBooking bookingFormToBooking) {
        this.bookingRepository = bookingRepository;
        this.bookingFormToBooking = bookingFormToBooking;
    }


    @Override
    public List<Booking> listAll() {
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(bookings::add); //fun with Java 8
        return bookings;
    }

    @Override
    public Booking getById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking saveOrUpdate(Booking booking) {
        bookingRepository.save(booking);
        return booking;
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);

    }

    @Override
    public Booking saveOrUpdateBookingForm(BookingForm bookingForm) {
        Booking savedBooking = saveOrUpdate(bookingFormToBooking.convert(bookingForm));

        System.out.println("Saved Booking Id: " + savedBooking.getId());
        return savedBooking;
    }
}
