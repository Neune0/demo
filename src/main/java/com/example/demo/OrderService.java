package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final DiscountService discountService;
    private final NotificationService notificationService;

    @Autowired
    public OrderService(DiscountService discountService, NotificationService notificationService) {
        this.discountService = discountService;
        this.notificationService = notificationService;
    }

    public double calculateFinalPrice(double amount){
        return discountService.applyDiscount(amount);
    }

    public void processOrder(double amount){
        double finalPrice = calculateFinalPrice(amount);
        notificationService.sendNotification("Order processed. Final price: " + finalPrice);
    }
    
}
