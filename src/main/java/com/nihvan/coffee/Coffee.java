package com.nihvan.coffee;


import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Coffee {
  private String id;
  private String name;

  Coffee(String id ,String name) {
    this.id = id;
    this.name= name;
  }
  public Coffee(String name) {
		this(UUID.randomUUID().toString(), name);
	}

  
  String getId(){
    return id;
  }
  String getName(){
    return name;
  }
  void setName( String name) {
    this.name = name;
  }

}
