package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {


    private CartRepository cartRepository;
    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CartRepository cartRepository, CustomerRepository customerRepository){
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase){
        //retrieve the order info from dto
        cartRepository.save(purchase.getCart());
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> {

                    Vacation vacation = item.getVacation();
                    Set<Excursion> excursions = item.getExcursions();
                     for (Excursion excursion : excursions) {
                         excursion.setVacation(vacation);};
                    item.setVacation_id(item.getVacation().getId());
                    item.setCart_id(purchase.getCart().getId());
                    cart.add(item);

                });
        cart.setStatus(StatusType.ordered);

        cart.setCustomer(customer);
        customer.add(cart);

        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }
    private String generateOrderTrackingNumber(){
        // generate a random UUID
        return UUID.randomUUID().toString();
    }

}
