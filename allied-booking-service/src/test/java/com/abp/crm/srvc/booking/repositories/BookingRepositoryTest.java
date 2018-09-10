package com.abp.crm.srvc.booking.repositories;

import com.abp.crm.srvc.booking.domain.Booking;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookingRepositoryTest {

    private static final Long BOOKING_MGR_ID = 1L;
    private static final Long ASSIGNED_MGR_ID = 1L;
    private static final Long VENDOR_ID = 1L;
    private static final Timestamp START_DATE = getTime("05/04/2018");
    private static final Timestamp END_DATE = getTime("04/04/2018");

    @Autowired
    private BookingRepository bookingRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistence() {
        //given
        Booking booking = new Booking();
        booking.setBookedbymgrid(BOOKING_MGR_ID);
        booking.setAssignedmgrid(ASSIGNED_MGR_ID);
        booking.setVendorid(VENDOR_ID);
        booking.setStartdate(START_DATE);
        booking.setEnddate(END_DATE);

        //when
        bookingRepository.save(booking);

        //then
        Assert.assertNotNull(booking.getId());
        Booking newBooking = bookingRepository.findById(booking.getId()).orElse(null);
        Assert.assertEquals((Long) 1L, newBooking.getId());
        Assert.assertEquals(BOOKING_MGR_ID, newBooking.getBookedbymgrid());
        Assert.assertEquals(ASSIGNED_MGR_ID.compareTo(newBooking.getAssignedmgrid()), 0);
        Assert.assertEquals(VENDOR_ID, newBooking.getVendorid());
        Assert.assertEquals(START_DATE, newBooking.getStartdate());
        Assert.assertEquals(END_DATE, newBooking.getEnddate());
    }

    private static Timestamp getTime(String dateStr) {
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