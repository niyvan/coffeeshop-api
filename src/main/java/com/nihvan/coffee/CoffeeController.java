package com.nihvan.coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  @GetMapping("/coffees")
    Iterable<Coffee> getCoffees(){
      return coffees;
    }
    @GetMapping("/coffees/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id ){
       for( Coffee coffee : coffees ){
        if( coffee.getId().equals( id )){
          return Optional.of(coffee);
       }
       
    }
return Optional.empty();
  
}
}