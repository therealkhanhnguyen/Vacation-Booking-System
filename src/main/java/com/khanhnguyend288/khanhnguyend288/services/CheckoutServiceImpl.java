package com.khanhnguyend288.khanhnguyend288.services;

import com.khanhnguyend288.khanhnguyend288.dao.CustomerRepository;
import com.khanhnguyend288.khanhnguyend288.entities.Cart;
import com.khanhnguyend288.khanhnguyend288.entities.CartItem;
import com.khanhnguyend288.khanhnguyend288.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve cart
        Cart cart = purchase.getCart();

        //prevent ID = 0 problem
        cart.setId(null);

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //populate cart item to cart
        Set<CartItem> cartItems = purchase.getCartItems();
        // link cartItem to cart:
        for (CartItem item : cartItems) {
//            item.setId(null); // each cart is new. hopefully.
            item.setCart(cart);

            // add each item to the cart’s collection
            cart.getCartItems().add(item);
        }
        //populate customer with order
        Customer customer = purchase.getCustomer();

        //  Default empty postal code
        if (customer.getPostalCode() == null || customer.getPostalCode().isBlank()) {
            customer.setPostalCode("12345");
        }

        // Link cart to customer
        cart.setCustomer(customer);
        // Attach cart to customer
        customer.getCarts().add(cart);

        //save to the database:
        customerRepository.save(customer);

        //return a response:
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
