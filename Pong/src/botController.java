public class botController {
    public Rect ball;
    public Controllers bot;

    public botController(Rect ball, Controllers bot) {
        this.bot = bot;
        this.ball = ball;
    }

    public void updateBot() {
        if ((ball.y + ball.height / 2) < (bot.rect.y + bot.rect.height / 2)) {
            bot.moveUpFirst();
        }
        if ((ball.y + ball.height / 2) > (bot.rect.y + bot.rect.height / 2)) {
            bot.moveDownFirst();
        }
    }
}
