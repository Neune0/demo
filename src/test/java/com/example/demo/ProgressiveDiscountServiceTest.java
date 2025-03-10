package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
@ImportAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class ProgressiveDiscountServiceTest {

    private final DiscountService discountService = new ProgressiveDiscountService(); // Usiamo l'implementazione reale

    @Test
    void testProgressiveDiscountBelow100() {
        double result = discountService.applyDiscount(80); // 5% di sconto su 80 → 76.0
        assertEquals(76.0, result);
    }

    @Test
    void testProgressiveDiscountAbove100() {
        double result = discountService.applyDiscount(200); // 15% di sconto su 200 → 170.0
        assertEquals(170.0, result);
    }
}