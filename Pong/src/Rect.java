import java.awt.Graphics2D;
import java.awt.Color;
public class Rect {
    public int x, y,width,height;
    public Color color;

    public Rect(int x,int y,int width,int height, Color color){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.color=color;
    }
    public void drawRect(Graphics2D g){
        g.setColor(color);
        g.fillRect(x, y,width,height);
    }
}
