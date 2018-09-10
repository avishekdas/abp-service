package com.abp.crm.srvc.booking.converters;

import com.abp.crm.srvc.booking.commands.BookingForm;
import com.abp.crm.srvc.booking.domain.Booking;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class BookingToBookingForm implements Converter<Booking, BookingForm> {
    @Override
    public BookingForm convert(Booking booking) {
        BookingForm bookingForm = new BookingForm();
        bookingForm.setId(booking.getId());
        bookingForm.setAssignedmgrid(booking.getAssignedmgrid());
        bookingForm.setBookedbymgrid(booking.getBookedbymgrid());
        bookingForm.setVendorid(booking.getVendorid());
        bookingForm.setStartdate(getTimeStr(booking.getStartdate()));
        bookingForm.setEnddate(getTimeStr(booking.getEnddate()));
        return bookingForm;
    }

    private String getTimeStr(Timestamp time) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date=new Date(time.getTime());
        return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);
    }
}
