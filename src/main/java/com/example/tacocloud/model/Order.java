package com.example.tacocloud.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

@Data
public class Order {
    @NotBlank(message = "Providing your name is mandatory.")
    private String name;
    @NotBlank(message = "Providing your last name is mandatory.")
    private String lastName;
    @NotBlank(message = "Providing city is mandatory.")
    private String city;
    @NotBlank(message = "Providing street name is mandatory.")
    private String street;
    @NotBlank(message = "Providing home number is mandatory.")
    private String homeNumber;
    @NotBlank(message = "Providing zip code is mandatory.")
    private String zipCode;
    @CreditCardNumber(message = "Credit card number is not correct")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]1[0-2])([\\/])([0-9][0-9])$",
    message = "Input must be in MM/RR format")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "CCV number is not correct.")
    private String ccCVV;

}
