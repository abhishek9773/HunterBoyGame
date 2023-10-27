package main;

import javax.swing.JFrame;

public class Main{

  public static void main(String args[]){

    JFrame window = new JFrame();
    windnow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("2D Adventrue");

    GamePanel gamepanel = new GamePanel();
    window.add(gamepanel);
    
    window.setLocationRelativeTo(null);
    window.setVisible(true);

    gamePanel.setupGame();
    gamePanel.startGameThread();
    
    
  }
}
