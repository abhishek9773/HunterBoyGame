import object;

public class OBJ_Chest extends SuperObject {

  public OBJ_Door(){

    name = "Chest";

    try{
      image = imageIO.read(getClass().getResourceAsStream("/object/chest.png"));

    } catch(IOException e){
      e.printStackTrace();
    }

  }

}
