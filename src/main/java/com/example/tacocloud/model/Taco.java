package com.example.tacocloud.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Taco {

    @NotNull
    @Size(min = 5, message = "Providing your name is mandatory.")
    private String name;
    @Size(min = 1, message = "You have choose at least 1 ingredient.")
    private List<String> ingredients;
}
