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
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long id;

    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "division_id")
    private Long division_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id", nullable = false, insertable = false, updatable = false)
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts = new HashSet<>();

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    public void add(Cart cart){
        if(cart != null){
            if(carts == null){
                carts = new HashSet<>();

            }
            carts.add(cart);
            cart.setCustomer((this));
        }
    }

    public void setDivision(Division division) {
        setDivision_id(division.getId());
        this.division = division;


    }
}


