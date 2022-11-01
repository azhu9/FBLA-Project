package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "forward";
    }
    public void getPlayerImage(){
      try{
        forward1 = ImageIO.read(getClass().getResourceAsStream("./../res/player/Among1.png"));
        forward2 = ImageIO.read(getClass().getResourceAsStream("./../res/player/Among2.png"));

      }catch(IOException e){
        e.printStackTrace();
      }
    }

    public void update(){
        if(y < gp.screenHeight - gp.tileSize){
            if(keyH.downPressed == true){
              direction = "down";
              y += speed;
            }
          }
          if(y > 0){
            if(keyH.upPressed == true){
              direction = "up";
              y -= speed;
            }
          }
          
          if(x < gp.screenWidth - gp.tileSize){
            if(keyH.rightPressed == true){
              direction = "right";
              x += speed;
            }
            }
          if(x > 0){
            if(keyH.leftPressed == true){
              direction = "left";
              x -= speed;
          } 
        }
    }

    public void draw(Graphics2D g2){
        // g2.setColor(Color.white); // sets color to white

        // g2.fillRect(x, y, gp.tileSize, gp.tileSize); //make a rectangle of tileSize x tileSize and (100,100)

        BufferedImage image = null;

        switch(direction){
          case "forward":
            image = forward1;
            break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
