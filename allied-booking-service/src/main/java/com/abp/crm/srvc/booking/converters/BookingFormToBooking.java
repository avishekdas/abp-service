package com.abp.crm.srvc.booking.converters;

import com.abp.crm.srvc.booking.commands.BookingForm;
import com.abp.crm.srvc.booking.domain.Booking;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class BookingFormToBooking implements Converter<BookingForm, Booking> {

    @Override
    public Booking convert(BookingForm bookingForm) {
        Booking booking = new Booking();
        if (bookingForm.getId() != null  && !StringUtils.isEmpty(bookingForm.getId())) {
            booking.setId(new Long(bookingForm.getId()));
        }
        booking.setAssignedmgrid(bookingForm.getAssignedmgrid());
        booking.setBookedbymgrid(bookingForm.getBookedbymgrid());
        booking.setVendorid(bookingForm.getVendorid());
        booking.setStartdate(getTime(bookingForm.getStartdate()));
        booking.setEnddate(getTime(bookingForm.getEnddate()));
        return booking;
    }

    private Timestamp getTime(String dateStr) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            date = new Date();
        }
        long time = date.getTime();
        return new Timestamp(time);
    }
}
