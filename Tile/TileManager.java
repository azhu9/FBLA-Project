/*package tile;
public class Tilemanager{
  GamePanel gp;
  Tile[] tile;

  public TileManager(GamePanel gp){
    this.gp = gp;
    tile = new Tile[10]; //number of different tiles
  }
  public void getTileImage(){
    try{
      tile[0] = new Tile();
      tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass2.png"));//one tile
      
      tile[1]=new Tile();
      tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water2.png"));
    }catch(IOException e){
      e.printStackTrace();
    }

  }
  public void draw(Graphics2D g2){
    g2.drawImage(tile[0].image,0,0,gp.tileSize, gp.tileSize, null);
  }
}*/