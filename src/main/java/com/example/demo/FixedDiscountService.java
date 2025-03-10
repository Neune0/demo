package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class FixedDiscountService implements DiscountService {
    
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.9;
    }
    
}
