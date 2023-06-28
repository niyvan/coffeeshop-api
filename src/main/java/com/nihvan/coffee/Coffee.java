import java.util.UUID;

public class Coffee {
  private String id;
  private String name;

  Coffee(String id ,String name) {
    this.id = id;
    this.id = name;
  }
  Coffee(String name){
    this(UUID.randomUUID(),name);

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
