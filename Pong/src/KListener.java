import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KListener implements KeyListener {
    private final boolean []KeyPressed= new boolean[128];
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {KeyPressed[e.getKeyCode()]=true;}

    @Override
    public void keyReleased(KeyEvent e) {
        KeyPressed[e.getKeyCode()]=false;
    }
    public boolean isKeyPressed(int keyCode){
        return KeyPressed[keyCode];
    }
}
