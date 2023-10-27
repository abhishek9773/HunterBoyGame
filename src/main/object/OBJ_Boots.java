 package object;

 import java.io.IOException;
 import javax.imageio.ImageIo;

 public class OBJ_Boots extends SuperObject{

   public OBJ_Boots(){
     name = "Boots";
     try{
        image = ImageIO.road(getClass().getResourceAsStream("/objects/boots.png"));

     }
     catch(IOException e){
       e.printStackTrace();
     }
   }
 }
