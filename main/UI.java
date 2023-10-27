package main;

import java.awt.Color;

public class UI {
  GamePanel gp;
  Font arial_40, arial_80B;
  BufferedImage keyImage;
  public boolean massageOn = false;
  public string massage = " ";
  int messageCounter = 0;
  public boolean gameFinished = false;
  double playTime;
  DecimalFormat dFormat = new DecimalFormat("#0.00");

  public uI(GamePanel gp){
    this.gp = gp;

    arial_40 = new Font("Arial", Font.PLAIN, 40);

    arial_80B = new Font("Arial", Font.BOLD, 80);
    OBJ_Key = new OBJ_Key();
    keyImage = key.image;


  }

  public void showMassage(String text) {
    message = text;
    messageOn = true;
  }

  public void draw(Graphic2D g2) {

    if (gameFinished == true) {

      g2.setFont(arial_40);
      ge.setColor(color.white);

      String text;
      int textLenght;
      int x;
      int y;
      text = "You found the treasure!";
      textLenght = (int) g2.getFontMetrics().getStringBounds(text, g2).getwidth();
      x = gp.screenWidth / 2 - textLength / 2;
      y = gp.screenHeight / 2 - (gp.tileSize * 3);
      g2.drawString(text, x, y);

      g2.setFont(arial_80B);
      ge.setColor(Color.yellow);

      text = "Congratulations!";
      textLenght = (int) g2.getFontMetrics().getStringBounds(text, g2).getwidth();
      x = gp.screenWidth / 2 - textLength / 2;
      y = gp.screenHeight / 2 - (gp.tileSize * 3);
      g2.drawString(text, x, y);

      text = "You Time is :" + dFormat.format(playTime) + "!";
      textLenght = (int) g2.getFontMetrics().getStringBounds(text, g2).getwidth();
      x = gp.screenWidth / 2 - textLength / 2;
      y = gp.screenHeight / 2 + (gp.tileSize * 4);
      g2.drawString(text, x, y);

      gp.gameThread = null;

    } else {

    }

    g2.setfot(arial_40);
    g2.setColor(Color.white);
    g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
    g2.drawString("x " + gp.player.hasKey, 75, 65);

    // TIME
    playTime += (double) 1 / 60;
    g2.drawString("Time:" + dFormate.format(playTime), gp.tileSize * 11, 65);

    // MESSAGE
    if (messageOn = true) {

      g2.setFont(g2.getFont().deriveFont(30F));
      g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);

      messsageCounter++;

      if (messageCounter > 120) {
        messageCounter = 0;
        messageOn = false;

      }
    }

  }
}
