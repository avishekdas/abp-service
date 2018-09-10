package com.abp.crm.srvc.booking.repositories;

import com.abp.crm.srvc.booking.domain.Booking;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface BookingRepository extends CrudRepository<Booking, Long> {
}
