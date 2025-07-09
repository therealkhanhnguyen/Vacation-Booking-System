package com.khanhnguyend288.khanhnguyend288.services;

import com.khanhnguyend288.khanhnguyend288.entities.Cart;
import com.khanhnguyend288.khanhnguyend288.entities.CartItem;
import com.khanhnguyend288.khanhnguyend288.entities.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
