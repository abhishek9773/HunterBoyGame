package object;

public class SuperObject {

  public bufferedImage image;
  public String name;
  public boolean collision = false;
  public int worldX, worldY;
  public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
  public int solidAreaDefaultX = 0;
  public int solildAreaDefaultY =0;

  public void draw(Graphics@d g2, GamePanel gp){
     
      int screenX = worldX - gp.playerr.worldX + gp.player.screenX;
      int screenY = worldY -gp.player.worldY + gp.player.screenY;
     
      if(worldX + gp.tileSize > gp.player.workdx - gp.player.screenX && 
        worldX - gp.tileSize < gp.player.workdX + gp.player.screenx && 
        worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
        worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){

         g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
             
      }
      worldCol++;

  }
}
