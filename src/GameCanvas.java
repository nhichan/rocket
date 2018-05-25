import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {

    GameCanvas gameCanvas;
    BufferedImage enemyImage;
    BufferedImage playerImage;

    //để vẽ nhiều tranh trước
    BufferedImage backBuffered;
    Graphics graphics;
    List<Star> stars;
    List<Enemy> enemies;
    private Random random = new Random();
    private int countStar = 0;
    private int countEnemy = 0;

//    public int positionXenemy = 300;
//    public int positionYenemy = 300;

    public int positonXplayer = 200;
    public int positionYplayer = 100;

    public GameCanvas() {
        //kích thước giấy trùng kích thước cửa số
        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.setupCharacter();
        this.setVisible(true);

    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        //câu lệnh để lấy graphic để vẽ backBuffered
        this.graphics = this.backBuffered.getGraphics();

    }

    private void setupCharacter() {

        this.enemyImage = this.loadImage("resources/images/circle.png");
        this.playerImage = this.loadImage("resources/images/circle.png");
        this.setupStar();
        this.setupEnemy();
    }

    private void setupStar() {
        this.stars = new ArrayList<>();
    }

    private void setupEnemy() {
        this.enemies = new ArrayList<>();
    }

    //override nghĩa là ghi đè lên phương thức đang có.
    @Override //vẽ trong gamecomponent
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderALL() {
        this.renderBackground();

        this.stars.forEach(star -> star.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));

//        this.graphics.drawImage(this.enemyImage, this.positionXenemy, this.positionYenemy, 20, 20, null);
        this.graphics.drawImage(this.playerImage, this.positonXplayer, this.positionYplayer, 40, 40, null);
        this.repaint();
    }

    private void renderBackground() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);
    }

    public void runAll() {
        creatStar();
        this.stars.forEach(star -> star.run());
//        this.positionYenemy += 2;

        creatEnemy();
        this.enemies.forEach(enemy -> enemy.run());
    }

    private void creatStar() {
        if (this.countStar == 30) {
            Star star = new Star(this.loadImage("resources/images/star.png"),
                    1024, this.random.nextInt(600),
                    5,
                    5,
                    -this.random.nextInt(3) + 1,
                    0
            );
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }

    }

    private void creatEnemy() {
        if (this.countEnemy == 300) {
            int vx = 1;
            int vy = 1;
            while ((vx == 1) && (vy == 1)) {
                vx = -this.random.nextInt(3) + 1;
                vy = -this.random.nextInt(3) + 1;
            }
            Enemy enemy = new Enemy(this.loadImage("resources/images/circle.png"),
                    this.random.nextInt(1024), this.random.nextInt(600),
                    20,
                    20,
                    vx,
                    vy
            );
            this.enemies.add(enemy);
            this.countEnemy= 0;
        } else {
            this.countEnemy += 1;
        }

    }


    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}




