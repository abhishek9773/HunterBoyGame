package object;

import java.io.IOException;
import javaX.image.io.ImageIO;

public class OBJ_Door {

public class OBJ_Door extends SuperObject{
    
  public OBJ_Door(){

    name = "Door";

    try{
      image = imageIO.read(getClass().getResourceAsStream("/object/Door.png"));

    } catch(IOException e){
      e.printStackTrace();
    }
    collision =true;

  }
  
  }
