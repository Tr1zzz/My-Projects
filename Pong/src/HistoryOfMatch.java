import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalTime;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
public class HistoryOfMatch {
    public static String textToFile;


    public static void writingHistory() {
        String time=getTime();

        if(Ball.leftPoint){
            Main.leftScore++;
            textToFile="Left Player get point when time was: "+time+". Score was: "+Main.leftScore+":"+Main.rightScore+".";
            Ball.leftPoint=false;

            writeToFile();
        } else if (Ball.rightPoint) {
            Main.rightScore++;
            textToFile="Right Player get point when time was: "+time+". Score was: "+Main.leftScore+":"+Main.rightScore+".";
            Ball.rightPoint=false;

            writeToFile();
        }
    }

    public static String getTime(){
        long hours,minutes,seconds;

        LocalTime time = LocalTime.now();
        LocalTime zero = LocalTime.of(00,00,00);


        hours=ChronoUnit.HOURS.between(zero,time);
        minutes=ChronoUnit.MINUTES.between(zero,time)-hours*60;
        seconds=ChronoUnit.SECONDS.between(zero,time)-(hours*3600+minutes*60);

        return hours+":"+minutes+":"+seconds;
    }

    public static void writeToFile(){
            Main.write.println(textToFile);
    }

    public static void readFromFile() throws IOException{//input/output exception
        String text;
        BufferedReader read =null;
        try {
            read = new BufferedReader(new FileReader("History of the match.txt"));
            while ((text = read.readLine()) != null) {
                System.out.println(text);
            }
        }
        finally{
            if(read!=null)read.close();
        }
    }
}
