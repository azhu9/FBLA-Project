package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;

    public BufferedImage forward1, forward2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}