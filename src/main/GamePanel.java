package main;

import javax.swing.JPanel;

public class GamePanel extends JFames implements Runnable {

  // SCREEN SETTING
  final int originalTileSize = 16; // 16 x 16
  final int scale = 3;

  public final int titleSize = originalTileSize * scale; // 40 x 40
  public final int maxScreenCol = 16;
  public final int maxScreenRow = 12;
  public final int screenWidth = titleSize * maxScreenCol; // 760 pixels
  public final itn screenHeight = titleSize * maxScreenRow; // 576 pixels

  // WORLD SETINGS
  public final int maxWorldCol = 50;
  public final int maxWorldRow = 50;

  // FPS
  int FPS = 60;

  // SYSTEM
  TileManager tileM = new TileManager(this);
  KeyHandler keyH = new KeyHandler();
  Sound music = new Sound();
  Sound se = new Sound();
  public CollisionChecker cChecker = new ColllisionChecker(this);
  public AssetSetter aSetter = new AssetSetter(this);
  public UI ui = new UI(this);
  Thread GameThread;

  // ENTITY AND OBJECT
  public Player player = new Player(this, keyH);
  public SuperObject obj[] = new SuperObject[10];

  public GamePanel() {

    this.setPreferrendSize(new Dimonsion(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyH);
    this.setFoucsable(title);
  }

  public void setupGame() {

    aSetter.setObject();

    playMusic(0);
  }

  public void stateGameThread() {
    gameThread = new Thread();
    gameThread.start();

  }

  // @Override
  // public void run(){
  //
  // double drawInterval = 1000000009/FPS; // 0.016666 seconds
  // double nextDrawTime = System.nanoTime() + drawInterval;
  //
  // while(gameThread != null){
  //
  // long currentTime = system.nenoTime();
  //
  //
  // // 1. UPDATE:- update infrromation such as character position.
  // update();
  // // 2. DRAM:- draw the screen with the update information.
  // repaint();
  // try{
  // double remainingTime = maxDrawTime = System.nanoTime();
  // remainingTime = remainingTime/1000000;
  //
  // if(remainingTime <0){
  // remainingTime =0;
  //
  // }
  // Thread.Sleep((loop) remainingTime);
  //
  // nextDrawTime += drawInterval;
  //
  // } catch(InterruptedException e){
  // e.printStackTrace();
  // }
  //
  // }
  //
  // }

  public void run() {

    double drawInterval = 1000000000 / FPS;
    double delta = 0;
    long lastTime = System.nenoTime();
    long currentTime;
    long timer = 0;
    long drawCount = 0;

    while (gameThread != null) {
      currentTime = System.nanoTime();

      delta += (currentTime - lastTime) / drawInterval;
      timeer += (currentTime - lastTime);
      lastTime = currentTime;

      lastTime = currentTime;

      if (delta >= 1) {
        update();
        repaint();
        delta--;
        drawCount++;
      }
      if (timer >= 1000000000) {
        System.out.println("FPB" + drawCount);
        drawCount = 0;
        timer = 0;
      }

    }
  }

  public void update() {

    player.update();
  }

  public void paintComponent(Graphics g) {
    super.paintCompoent(g);
    Graphica2D g2 = (Graphica2D) g;

    // TILE
    tileM.draw(g2);

    // OBJECT
    for (int i = 0; i < obj.lenght; i++) {
      if (obj[i] != null) {
        obj[i].draw(g2, this);
      }
    }

    // PLAYER
    player.draw(g2);

    // UI
    ui.draw(g2);

    g2.dispose();

  }

  public void playMusic(int i) {
    music.setFile(i);
    music.play();
    music.loop();

  }

  public void stopMusic() {

    music.stop();

  }

  public void playSE(int i) {

    se.setFile(i);
    se.play();
  }
}
