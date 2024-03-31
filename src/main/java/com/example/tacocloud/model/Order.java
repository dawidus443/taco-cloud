package com.example.tacocloud.model;

import lombok.Data;

@Data
public class Order {
    private String name;
    private String lastName;
    private String city;
    private String Street;
    private String homeNumber;
    private String zipCode;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

}
