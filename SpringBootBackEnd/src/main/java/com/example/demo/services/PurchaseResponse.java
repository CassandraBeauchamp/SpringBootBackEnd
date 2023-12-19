package com.example.demo.services;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PurchaseResponse {

    private String orderTrackingNumber;

    public PurchaseResponse(String orderTrackingNumber){
        this.orderTrackingNumber = orderTrackingNumber;
    }





}
