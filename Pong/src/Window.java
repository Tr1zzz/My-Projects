import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;

public class Window extends JFrame implements Runnable {
    public Graphics2D g2;
    public KListener kl =new KListener();
    public Rect ballRect,playerOne,playerTwo;
    public Ball ball;
    public Controllers controllersOne, controllersTwo,menuControl;
    public botController Bot;
    public Text leftScore,rightScore;
    public boolean isRunning=true;
    public Window(){
    this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
    this.setTitle(Constants.WINDOW_TITLE);
    this.setResizable(false);
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocation(Constants.WINDOW_LOCATION_X,Constants.WINDOW_LOCATION_Y);
    this.addKeyListener(kl);
    g2 = (Graphics2D)getGraphics();

    menuControl=new Controllers(kl);

        leftScore=new Text(0,new Font("Times New Roman",Font.PLAIN,90),10,100);
        rightScore=new Text(0,new Font("Times New Roman",Font.PLAIN,90),500,100);

    playerOne=new Rect(Constants.PADDLE1_LOCATION_X,Constants.PADDLE_LOCATION_Y,
            Constants.PADDLE_WIDTH,Constants.PADDLE_HEIGHT,Constants.PADDLE_COLOR);

    controllersOne = new Controllers(playerOne,kl);

   playerTwo = new Rect(Constants.PADDLE2_LOCATION_X,Constants.PADDLE_LOCATION_Y,
           Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);

   controllersTwo = new Controllers(playerTwo,kl);

    ballRect = new Rect(Constants.WINDOW_WIDTH/2-5,Constants.WINDOW_HEIGHT/2,
            Constants.BALL_SIZE,Constants.BALL_SIZE,Constants.PADDLE_COLOR);

    Bot=new botController(ballRect,new Controllers(playerTwo));

    ball=new Ball(ballRect,playerOne,playerTwo,leftScore,rightScore);
    }
    public void update(){
        Image dbImage = createImage(getWidth(),getHeight());

        Graphics dbg = dbImage.getGraphics();
        draw(dbg);
        g2.drawImage(dbImage,0,0,this);

        //waiting after scoring the point
        if(Constants.isScored) {
            try {
                Thread.sleep(300);
                Constants.isScored=false;
            }catch (Exception e ){}
        }

        menuControl.exitControl();
        controllersOne.updateFirstController();

        //checking whether the player decide to play with bot or with friend
        if(Main.isSecondPlayer) {
            controllersTwo.updateSecondController();
        } else {
            Bot.updateBot();
        }
        //updating ball movement
        ball.updateBall();
    }
    public void draw(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

            //drawing score
            leftScore.drawNumber(g2);
            rightScore.drawNumber(g2);

            //drawing players and ball
            playerOne.drawRect(g2);
            playerTwo.drawRect(g2);
            ballRect.drawRect(g2);
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
}
