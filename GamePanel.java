import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable{
  final int originalTileSize = 16; // 16x16
  final int scale = 3;

  final int tileSize = originalTileSize * scale; // scale up to 48x48
  final int maxScreenCol = 16;
  final int maxScreenRow = 12;
  final int screenWidth = tileSize * maxScreenCol; //768px
  final int screenHeight = tileSize * maxScreenRow; //576px

    int fps = 60;

  
  KeyHandler keyH = new KeyHandler();
  Thread gameThread; //game clock, also it immedietly calls run method

    int playerX = 100;//default position
    int playerY = 100;
    int playerSpeed = 6;
  
  public GamePanel(){
    this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //set screen width and height
    this.setBackground(Color.blue);
    this.setDoubleBuffered(true); //renders stuff off screen (faster)
    this.addKeyListener(keyH);
    this.setFocusable(true);
  }

  public void startGameThread(){
    gameThread = new Thread(this);
    gameThread.start();
  }

  
  @Override
  public void run(){

    double drawInterval = 1000000000/fps;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    
    while(gameThread != null){ //game loop, repeats until exit
      currentTime = System.nanoTime();

      delta += (currentTime - lastTime) / drawInterval;

      lastTime = currentTime;

      if(delta >= 1){
        update(); //update(character position)

        repaint(); //draw
        delta--;
      }

    }
  }

  public void update(){
    if(keyH.upPressed == true){
      playerY -= playerSpeed;
    }
    if(keyH.downPressed == true){
      playerY += playerSpeed;
    }
    if(keyH.leftPressed == true){
      playerX -= playerSpeed;
    }
    if(keyH.rightPressed == true){
      playerX += playerSpeed;
    }
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g; //cast g to graphics2d which has more methods

    g2.setColor(Color.white); // sets color to white

    g2.fillRect(playerX, playerY, tileSize, tileSize); //make a rectangle of tileSize x tileSize and (100,100)

    g2.dispose(); //closes class, garbage 

    
  }
}
