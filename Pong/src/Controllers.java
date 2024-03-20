import java.awt.event.KeyEvent;

public class Controllers {
    public Rect rect;
    public KListener keylistener;
    public Controllers(Rect rect, KListener keylistener){
        this.rect = rect;
        this.keylistener=keylistener;
    }
    public Controllers( KListener keylistener){
        this.keylistener=keylistener;
    }
    public Controllers(Rect rect){
        this.rect=rect;
        this.keylistener=null;
    }
    public void updateFirstController(){

            if (keylistener.isKeyPressed(KeyEvent.VK_S)) {
                moveDownFirst();
            } else if (keylistener.isKeyPressed(KeyEvent.VK_W)) {
                moveUpFirst();

        }
    }
    //exit to menu
    public void exitControl(){
        if(keylistener.isKeyPressed(KeyEvent.VK_ESCAPE)){
            Main.changeState(true,false,false);
        }
    }
    public void updateSecondController() {
        if (keylistener.isKeyPressed(KeyEvent.VK_DOWN)){
            moveDownSecond();
        } else
        if (keylistener.isKeyPressed(KeyEvent.VK_UP)) {
            moveUpSecond();
        }
    }

    //moving first paddle down
    public void moveDownFirst(){
        if(this.rect.y +this.rect.height<Constants.WINDOW_TOOLBAR_BOTTOM){
            this.rect.y +=Constants.PADDLE_SPEED;
        }
    }

    //moving first paddle up
    public void moveUpFirst(){
        if(this.rect.y >Constants.WINDOW_TOOLBAR_TOP){
            this.rect.y -=Constants.PADDLE_SPEED;
        }
    }

    //moving second paddle down
    public void moveDownSecond(){
        if(this.rect.y +this.rect.height<Constants.WINDOW_TOOLBAR_BOTTOM){
            this.rect.y +=Constants.PADDLE_SPEED;
        }
    }

    //moving second paddle up
    public void moveUpSecond(){
        if(this.rect.y >Constants.WINDOW_TOOLBAR_TOP){
            this.rect.y -=Constants.PADDLE_SPEED;
        }
    }
}
