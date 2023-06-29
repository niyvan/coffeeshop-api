package com.nihvan.coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController {
  private List<Coffee> coffees = new ArrayList<>();

  public CoffeeController() {
    coffees.addAll(List.of(new Coffee("Café Cereza"),
				new Coffee("Café Ganador"),
				new Coffee("Café Lareño"),
				new Coffee("Café Três Pontas")));
  }
    //Get all coffees
    @GetMapping("/coffees")
    Iterable<Coffee> getCoffees(){
      return coffees;
    }
    //Get a coffee
    @GetMapping("/coffees/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id ){
       for( Coffee coffee : coffees ){
        if( coffee.getId().equals( id )){
          return Optional.of(coffee);
       }
       
    }
    return Optional.empty();
    }
  //Post a coffee
    @PostMapping("/coffees")
    Coffee postCoffee(@RequestBody Coffee coffee){
      coffees.add(coffee);
      return coffee;
    }
    //Update a coffee
    @PutMapping("/coffees/{id}")
      Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee){
        int coffeeIndex = -1;
        for(Coffee c : coffees){
          if(c.getId().equals(id)){
            coffeeIndex = coffees.indexOf(c);
            coffees.set(coffeeIndex, coffee);
          }
        }
        return (coffeeIndex == -1) ? postCoffee(coffee) : coffee;
    }

    @DeleteMapping("Coffees/{id}")
    void deleteCoffee(@PathVariable String id) {
      coffees.removeIf(c->c.getId().equals(id));
    }
}