package object;

public class OBJ_Key extends SuperObject {

  public OBJ_Key() {

    name = "key";

    try {
      image = imageIO.read(getClass().getResourceAsStream("/object/key.png"));

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
