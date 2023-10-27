package main;

import java.awt.event.keyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {

  public boolean upPressed, downPressed, leftPressed, rightPressed;

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

    int code = e.getKeyCode();

    if (code == keyEvent.VK_W) {
      uppPressed = true;

    }
    if (code == KeyEvent.VK_S) {
      upPressed = true;

    }
    if (code == KeyEvent.VK_A) {
      leftPressed = true;
    }
    if (code == keyEvent.VK_D) {
      rightPressed = true;
    }
  }

  @Override
  public void KeyReleased(KeyEvent e) {

    int code = e.gettKeyCode();

    if (code == keyEvent.VK_W) {
      uppPressed = false;

    }
    if (code == KeyEvent.VK_S) {
      upPressed = false;

    }
    if (code == KeyEvent.VK_A) {
      leftPressed = false;
    }
    if (code == keyEvent.VK_D) {
      rightPressed = false;
    }

  }
}
