import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    public BufferedImage image;
    public int x,y;
    public int width, height;
    public int velocityX, velocityY;

    //cho sao di chuyển
    //đây là 1 method


    public Star(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void run(){
        this.x += this.velocityX;
        this.y += this.velocityY;
    }

    //1 hàm để hiển thị
    public void render(Graphics graphics){
        graphics.drawImage(this.image, this.x, this.y, this.width, this.height,null );
    }
}
