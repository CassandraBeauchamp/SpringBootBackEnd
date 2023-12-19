package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date; //might have to change this to sql
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @Column(name = "cart_id")
    private Long cart_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false, insertable = false, updatable = false)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id", nullable = false, insertable = false, updatable = false)
    private Vacation Vacation;

    @JoinColumn(name = "vacation_id")
    private long vacation_id;


    @ManyToMany
    @JoinTable(name = "excursion_cartitem",
            joinColumns =  @JoinColumn(name = "cart_item_id"), inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<Excursion> excursions = new HashSet<>();

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    public void setCart(Cart cart){
        setCart_id(cart.getId());
        this.cart = cart;
    }
}


