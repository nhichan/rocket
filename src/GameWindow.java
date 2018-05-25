import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    //để mở cửa sổ window
    GameCanvas gameCanvas;
    long lastTime = 0;


    public GameWindow(){
        this.setSize(1024, 600);
        this.setupGameCanvas();
        this.event();

        this.setVisible(true);
    }


    private void event(){
        this.keyboardEvent();
        this.windowEvent();
    }


    private void setupGameCanvas(){
        this.gameCanvas = new GameCanvas();//để giấy và cửa sổ trùng nhau
        this.add(this.gameCanvas);//gán giá trị mới tạo ra vào cửa sổ của mình

    }


    private void keyboardEvent(){
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //bao gồm cả ấn và thả
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println("keyTyped");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //keypress đc gọi khi ng dùng ấn 1 nút nào đấy
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    //đẻ biết ng dùng ấn nút gì thì phải getKeyCode
                    //keyEvent chứa VK_LEFT: mã nút trái
                    gameCanvas.positonXplayer -= 3;
                    if ((gameCanvas.positonXplayer >= 1024) || (gameCanvas.positonXplayer <= 0)) {
                        if (gameCanvas.positonXplayer >= 1024) {gameCanvas.positonXplayer = 0;}
                        else gameCanvas.positonXplayer = 1024;
                    }
                }
                if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                    gameCanvas.positonXplayer +=3;
                    if ((gameCanvas.positonXplayer >= 1024) || (gameCanvas.positonXplayer <= 0)) {
                        if (gameCanvas.positonXplayer >= 1024) gameCanvas.positonXplayer = 0;
                        else gameCanvas.positonXplayer = 1024;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //đc gọi khi ng dùng thả 1 nút nào đấy
            }
        });
    }


    private void windowEvent(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                //để chương trình dừng lại:
                System.exit(1);
            }
        });

    }


    public void gameLoop(){
        while (true){
            //nanoTime là thời gian hiện tại
            long currentTime = System.nanoTime();

            if (currentTime -this.lastTime >= 17_000_000) {
                //17_000_000 là 17 triệu nano giây
                this.gameCanvas.runAll();
                //vẽ lại ra màn hình
                //this.gameCanvas.repaint();
                //vì bỏ repaint r nên đổi thành renderall
                this.gameCanvas.renderALL();
                //phải xét lasttiem băng current time nó mới chạy lại
                this.lastTime = currentTime;
            }


        }
    }
}
