import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    public static boolean menuState=true,windowState=false;
    public static Thread mainThread;
    public static boolean isSecondPlayer=false;
    public static Window wnd;
    public static MainMenu Menu;
    public static int numberOfGames;
    public static String title;
    public static PrintWriter write=null;
    public static  int leftScore,rightScore;
    public static void main(String[] args) {
        try{
            write = new PrintWriter(new FileWriter("History of the match.txt"));

        }catch(IOException e){}

        Menu= new MainMenu();
        mainThread = new Thread(Menu);
        mainThread.start();

    }
    public static void changeState(boolean menu,boolean window,boolean isSecond) {
        menuState=menu;
        isSecondPlayer=isSecond;
        windowState=window;
        //turning on window with gameplay
        if(!menuState&&windowState){
            Menu.stop();
            Menu.dispose();
            wnd = new Window();
            Thread th = new Thread(wnd);
            th.start();
            numberOfGames++;

            rightScore=0;
            leftScore=0;
            title="History of game number:"+numberOfGames;
            write.println(title);
        }
        //turning on Menu
        if(menuState&&!windowState){
            wnd.stop();
            wnd.dispose();
            Menu= new MainMenu();
            mainThread = new Thread(Menu);
            mainThread.start();
        }
        //closing the program
        if(!menuState&&!windowState){
            Menu.stop();
            Menu.dispose();
            if(write!=null)write.close();
            try {
                HistoryOfMatch.readFromFile();
            }catch(IOException e){}
        }
    }
}
