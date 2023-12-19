package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date; //might have to change this to sql
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
@Setter
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "party_size")
    private int party_size;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Column(name = "package_price")
    private BigDecimal package_price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column(name = "customer_id")
    private long customer_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, insertable = false, updatable = false)
    private Customer customer;

    public void add(CartItem cartItem) {
        if (cartItem != null) {
            if (cartItems == null) {
                cartItems = new HashSet<>();

            }
            cartItems.add(cartItem);
            cartItem.setCart((this));
        }
    }
        public void setCustomer(Customer customers){
            setCustomer_id(customers.getId());
            this.customer = customers;
        }


    }


