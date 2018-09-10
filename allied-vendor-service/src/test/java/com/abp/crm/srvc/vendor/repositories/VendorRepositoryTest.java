package com.abp.crm.srvc.vendor.repositories;

import com.abp.crm.srvc.vendor.domain.Vendor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VendorRepositoryTest {

    private static final BigDecimal BIG_DECIMAL_100 = BigDecimal.valueOf(100.00);
    private static final String VENDOR_NAME = "VENDORNAME";
    private static final String VENDOR_CODE = "12345";
    private static final String CATEGORY_VENUE = "VENUE";

    @Autowired
    private VendorRepository vendorRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistence() {
        //given
        Vendor vendor = new Vendor();
        vendor.setName(VENDOR_NAME);
        vendor.setVendorcode(VENDOR_CODE);
        vendor.setSecuritydeposit(BIG_DECIMAL_100);
        vendor.setCategory(CATEGORY_VENUE);

        //when
        vendorRepository.save(vendor);

        //then
        Assert.assertNotNull(vendor.getId());
        Vendor newVendor = vendorRepository.findById(vendor.getId()).orElse(null);
        Assert.assertEquals((Long) 1L, newVendor.getId());
        Assert.assertEquals(VENDOR_NAME, newVendor.getName());
        Assert.assertEquals(BIG_DECIMAL_100.compareTo(newVendor.getSecuritydeposit()), 0);
        Assert.assertEquals(VENDOR_CODE, newVendor.getVendorcode());
        Assert.assertEquals(CATEGORY_VENUE, newVendor.getCategory());
    }
}