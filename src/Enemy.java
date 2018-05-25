import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy {
    public BufferedImage image;
    public int x, y;
    public int width, height;
    public int velocityX, velocityY;
    Random random;

    public Enemy(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.random = new Random();
    }

    public void run(){
        this.x += this.velocityX;
        if ((this.x >= 1024) || (this.x <= 0)) {
            if (this.x >= 1024) this.x = 0;
            else this.x = 1024;
            this.y = this.random.nextInt(600);
        }
        this.y += this.velocityY;
        if ((this.y >= 600) || (this.y <= 0)) {
            if (this.y >= 600) this.y = 0;
            else this.y = 600;
            this.x = this.random.nextInt(1024);
        }
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image, this.x, this.y, this.width, this.height,null );
    }
}
