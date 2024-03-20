import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class MainMenu extends JFrame implements Runnable {
    public ML mouseListener= new ML();
    public Graphics2D g2;
    public KListener kl =new KListener();
    public Text onePlayer,twoPlayers,exitGame,Pong;
    public boolean isRunning=true;


    public MainMenu(){
        this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.setTitle(Constants.WINDOW_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(Constants.WINDOW_LOCATION_X,Constants.WINDOW_LOCATION_Y);
        //add key listener to receive signals from keyboard
        this.addKeyListener(kl);
        //add mouse listener to receive signals from mouse
        this.addMouseListener(mouseListener);
        //add mouse motion listener to receive movements signals from mouse
        this.addMouseMotionListener(mouseListener);
        g2 = (Graphics2D)getGraphics();

        onePlayer = new Text("One Player",new Font("Times New Roman",Font.PLAIN,40),Constants.WINDOW_WIDTH/2.0-95.0,Constants.WINDOW_HEIGHT/2.0,Color.WHITE);
        twoPlayers = new Text("Two Players",new Font("Times New Roman",Font.PLAIN,40),Constants.WINDOW_WIDTH/2.0-100.0,Constants.WINDOW_HEIGHT/2.0+45,Color.WHITE);
        exitGame = new Text("Exit",new Font("Times New Roman",Font.PLAIN,40),Constants.WINDOW_WIDTH/2.0-40,Constants.WINDOW_HEIGHT/2.0+90,Color.WHITE);
        Pong = new Text("Pong",new Font("Times New Roman",Font.PLAIN,120),Constants.WINDOW_WIDTH/2.0-130,Constants.WINDOW_HEIGHT/2.0-80,Color.WHITE);

    }
    public void update(){
        Image dbImage = createImage(getWidth(),getHeight());
        Graphics dbg = dbImage.getGraphics();
        draw(dbg);
        g2.drawImage(dbImage,0,0,this);

        trackOnePlayer();
        trackTwoPlayer();
        trackExit();
    }
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        Pong.drawText(g2);
        twoPlayers.drawText(g2);
        onePlayer.drawText(g2);
        exitGame.drawText(g2);
    }

    public void stop(){
        isRunning=false;
    }

    public void run() {
        try {
            while(isRunning) {
                Thread.sleep(30);
                update();
            }
        } catch (Exception e) {

        }
    }
    public void trackOnePlayer(){
        if(mouseListener.getMouseX()> onePlayer.x && mouseListener.getMouseX()< onePlayer.x+ onePlayer.widthOne &&
                mouseListener.getMouseY()> onePlayer.y- onePlayer.height && mouseListener.getMouseY()< onePlayer.y){

            onePlayer.color= new Color(180, 180, 180);

            if(mouseListener.isMousePressed()){
                Main.changeState(false,true,false);
            }
        }else{
            onePlayer.color=Color.WHITE;
        }
    }
    public void trackTwoPlayer(){
        if(mouseListener.getMouseX()> twoPlayers.x && mouseListener.getMouseX()< twoPlayers.x+ twoPlayers.widthTwo &&
                mouseListener.getMouseY()> twoPlayers.y- twoPlayers.height && mouseListener.getMouseY()< twoPlayers.y){

            twoPlayers.color= new Color(180, 180, 180);

            if(mouseListener.isMousePressed()){
                Main.changeState(false,true,true);
            }
        }else{
            twoPlayers.color=Color.WHITE;
        }
    }
    public void trackExit(){
        if(mouseListener.getMouseX()>exitGame.x && mouseListener.getMouseX()<exitGame.x+exitGame.widthExit &&
                mouseListener.getMouseY()>exitGame.y-exitGame.height && mouseListener.getMouseY()<exitGame.y){
            exitGame.color= new Color(180, 180, 180);
            if(mouseListener.isMousePressed()){
                Main.changeState(false,false,false);
            }
        }else{
            exitGame.color=Color.WHITE;
        }
    }
}
