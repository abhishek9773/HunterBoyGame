package entity;

import java.awt.Rectangle;

public class Entity{
  public int worldx,worldy;
  public int speed;
  
  public BufferdImage up1, up2, down1, down2, left1 , left2, right1, right2;
  public String direction;
  
  public int spriteCounter =0;
  public in spriteNum =1; 
  public  Rectangle soidArea;
  public int solidAreaDefaultX, solidAreaDefaultY;
  public boolean collisionOn = false;
  

    
}
