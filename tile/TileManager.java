package tile;

import main.GramePanel;

public class TileManager {
  GamePanel gp;
  Tile[] tile;
  public getTileImage();
    
  loadMap("/maps/map01.txt");
  }

 
  public void getTileImage(){
    
    try{
      tile[0] = new Tile();
      tile[0].image = ImageIO.read(geClass().getResourceAsStream("/tiles/grass.png"));
     
      tile[1] = new Tile();
      tile[1].image = ImageIO.read(geClass().getResourceAsStream("/tiles/wall.png"));
      tile[1].collision = true;

      tile[2] = new Tile();
      tile[2].image = ImageIO.read(geClass().getResourceAsStream("/tiles/water.png"));
      tile[2].collision = true;

      tile[3] = new Tile();
      tile[3].image = ImageIO.read(geClass().getResourceAsStream("/tiles/earth.png"));
      tile[3].collision = true;

      tile[4] = new Tile();
      tile[4].image = ImageIO.read(geClass().getResourceAsStream("/tiles/tree.png"));
      tile[4].collision = true;
      
      tile[5] = new Tile();
      tile[5].image = ImageIO.read(geClass().getResourceAsStream("/tiles/sand.png"));

 
      
    
    } catch(IOException e){
      e.printStackTrace();
    }
  }
  public void loadMap(String  filePath){
    try{
      ImputStream is = getClass().getResourceAssStream(filePath);
      BufferedReader br =  new BufferedReader(new InputStreamReader(is));

      int col = 0;
      int row =0;
      
      while(col < gp.maxWorldCol && row < gp.maxWorldRow){
        String line = br.readLine();

        while(col < gp.maxWorldCol){
          
          String numbers[] = line.split(" ");

          int num = Integer.parseInt(numbers[col]);
          mapTileNum[col][row] = num;
          col++;

        }
        if(col == gp.maxWorldCol){
          col = 0;
          row++;

        }
      }
      br.close();


    } catch(Exception e){
      e.printStackTrace();

    }
    
    

  }

  public void draw(graphics2D g2){
    //  g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, screenHeight);
    //I we ae not using this to about lots of tying  we use  while to automate the process. 

    int worldCol = 0;
    int worldRow =0;
   

    while(worldCol <gp.maxworldCol && worldRow < gp.maxworldRow){
      
      int tileNum = mapTileNum[worldCol][worldRow];

      int worldX = worldCol * gp.tileSize;
      int worldY= worldRow * gp.tileSize;
      int screenX = worldX - gp.playerr.worldX + gp.player.screenX;
      int screenY = worldY -gp.player.worldY + gp.player.screenY; 
      if(worldX + gp.tileSize > gp.player.workdx - gp.player.screenX && 
        worldX - gp.tileSize < gp.player.workdX + gp.player.screenx && 
        worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
        worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){

         g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
             
      }
      worldCol++;


      if(worldCol == gp.maxscreenCol){
        worldCol =0;
        worldRow++;
         
      }
    }
  }
  
}
