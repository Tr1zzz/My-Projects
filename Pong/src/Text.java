import java.awt.*;

public class Text {
    public String Text;
    public Font Font;
    public double x,y, widthOne,widthTwo,widthExit,height;
    public Color color;

    public Text(String text,Font font,double x, double y,Color color){
        this.Text=text;
        this.Font=font;
        this.x=x;
        this.y=y;
        //receive width by multiplying size of font by some times
        this.widthOne =font.getSize()*4.5;
        this.widthTwo =font.getSize()*5;
        this.widthExit =font.getSize()*1.7;
        this.height=font.getSize();
        this.color=color;
    }
    public Text(int text,Font font,double x, double y){
        this.Text=Integer.toString(text);
        this.Font=font;
        this.x=x;
        this.y=y;
    }

    public void drawText(Graphics2D g){
        g.setColor(color);
        g.setFont(Font);
        //rendering of some text
        g.drawString(Text,(float)x,(float)y);
    }
    public void drawNumber(Graphics2D g){
        g.setColor(Color.WHITE);
        g.setFont(Font);
        //rendering of some number (score)
        g.drawString(Text,(float)x,(float)y);
    }
}
