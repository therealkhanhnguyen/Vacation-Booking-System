package com.khanhnguyend288.khanhnguyend288.controllers;

import com.khanhnguyend288.khanhnguyend288.services.CheckoutService;
import com.khanhnguyend288.khanhnguyend288.services.Purchase;
import com.khanhnguyend288.khanhnguyend288.services.PurchaseResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody @Valid Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
}
