package com.example.tacocloud.controller;

import com.example.tacocloud.model.Ingredient;
import com.example.tacocloud.model.Ingredient.Type;
import com.example.tacocloud.model.Taco;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "wheat", Ingredient.Type.WRAP),
                new Ingredient("COTO", "corn", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "pork", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "tomato", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "cheddar", Ingredient.Type.CHEESE),
                new Ingredient("MOZZ", "mozzarella", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "creme", Ingredient.Type.SAUCE)
        );
        Type[] types = Ingredient.Type.values();
        for (Type type : types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("taco",  new Taco());
        //model.addAttribute("name", ""); // Dodanie pustego pola "name"
        return "design";
    }
    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(@Valid Taco taco, Errors errors){
        if (errors.hasErrors()){
            return "design";
        }
        log.info("Taco project processing: " + taco);
        return "redirect:/orders/current";
    }

}
