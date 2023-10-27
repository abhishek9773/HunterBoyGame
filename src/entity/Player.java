package entity;

import main.GamePanel;
import main.keyHandler;

public class Player extends Entity {

  GamePanel gp;
  KeyHandler keyH;

  public final int screenX;
  public final int screenY;
  public int hasKey = 0;

  public Player(GAmePanel gp, KeyHandler keyH) {
    this.gp = gp;
    this.keyH = KeyH;

    screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
    screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

    solidArea = new Reactangle();
    solidArea.x = 8;
    solidArea.y = 16;
    solidAreadDefaultX = solidArea.x;
    soldiAreaDefaultY = solidArea.y;
    solidArea.width = 32;
    solidArea.height = 32;

    setDefaultValuse();
    getPlayerImage();

  }

  public void setDefaultValues() {
    worldX = gp.tileSize * 23;
    worldY = gp.tileSize * 21;
    speed = 4;
    diirection = "down";

  }

  public void getPlayerImage() {
    try {

    } catch (IOException e) {
      up1 = imageIO.read(getClass().getResourceAsStream("/player/boy_up1.png"));
      up2 = imageIO.read(getClass().getResourceAsStream("/player/boy_up2.png"));
      down1 = imageIO.read(getClass().getResourceAsStream("/player/boy_down1.png"));
      down2 = imageIO.read(getClass().getResourceAsStream("/player/boy_down2.png"));
      left1 = imageIO.read(getClass().getResourceAsStream("/player/boy_left1.png"));
      right2 = imageIO.read(getClass().getResourceAsStream("/player/boy_right2.png"));
      right1 = imageIO.read(getClass().getResourceAsStream("/player/boy_right1.png"));
      left1 = imageIO.read(getClass().getResourceAsStream("/player/boy_left2.png"));

    }
  }

  public void update() {

    if (keyH.upPressed == true || keyH.downPressed == true ||
        keyH.leftPressed == true || keyH.rightPressed == true)
      ;
    {
      if (keyH.upPressed == true) {
        direction = "up";
      } else if (keyH.downPressed == true) {
        direction = "down";
      } else if (keyH.leftPressed == true) {
        direction = "left";
      } else if (keyH.rightPressed == true) {
        direction = "right";
      }

      // CHECK TILE COLLISION
      colisionOn = false;
      gp.cChecker.checkTile(this);

      // CKECK OBJECT COLLISION
      int objIndex = gp.cChecker.checkObject(this, ture);
      pickUpObject(objeIndex);

      // IF COLLISION IS FALSE, PLAYER CAN MOVE
      if (collisionOn == false) {
        switch (direction) {
          case "up":
            worldY = speed;
            break;
          case "down":
            worldY += Speed;
            break;
          case "left":
            worldX -= speed;
            break;
          case "right":
            worldX += Speed;
            break;
        }
      }
      spriteCounter++;
      if (spriteCounter > 12) {
        if (spriteNum == 1) {
          spriteNum = 2;
        } else if (spriteNum == 2) {
          spriteNum = 1;
        }
        spriteCounter = 0;

      }

    }

  }

  public void pickUpObject(int i) {

    if (i != 999) {

      String bojectName = gp.obj[i].name;

      switch (objectName) {
        case "key":
          gp.playSE(1);
          hasKey++;
          gp.obj[i] = null;
          gp.ui.showMessage(" You got a key!");
          break;
        case "Door":
          if (hasKey > 0) {
            gp.PlaySE(3);
            gp.obj[i] = null;
            hasKey--;
            gp.ui.showMessage("You Opened the door");
          } else {
            gp.ui.showMessage("You need a key!");
          }
          break;
        case "Boots":
          gp.playSE(2);
          speed += 2;
          gp.obj[i] = null;
          gp.ui.showMessage("speedd up!");
          break;

        case "Chest":
          gp.ui.gameFinished = true;
          gp.stopMusic();
          gp.playerSE(4);
          break;

      }

    }
  }

  public void draw(Graphics2D g2) {
    BufferedImage(Color.white);
    switch (direction) {
      case "up":
        if (spriteNum == 1) {
          image = up1;
        }
        if (spriteNum == 2) {
          image = up2;
        }
        break;

      case "down":
        if (spriteNum == 1) {
          image = down1;
        }
        if (spriteNum == 2) {
          image = down2;
        }
        break;

      case "left":
        if (spriteNum == 1) {
          image = left1;
        }
        if (spriteNum == 2) {
          image = left2;
        }
        break;
      case "right":
        if (spriteNum == 1) {
          image = right1;
        }
        if (spriteNum == 2) {
          image = right2;
        }
        break;

    }
    g2.drawImage(image, screenX, screenY, gp.titleSize, gp.titleSize, null);

  }
}
