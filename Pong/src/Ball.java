public class Ball {
    public Text leftScore,rightScore;
    public Rect rectOfBall,firstTrackedRect,secondTrackedRect;
    public double xVelocity=-10;
    public double yVelocity=1;

    public static boolean rightPoint,leftPoint;
    public Ball(Rect ball,Rect firstPlayer,Rect secondPlayer,Text leftScore, Text rightScore ){
        this.leftScore=leftScore;
        this.rightScore=rightScore;
        this.rectOfBall=ball;
        this.firstTrackedRect=firstPlayer;
        this.secondTrackedRect=secondPlayer;
    }
    public void updateBall() {
        if (this.rectOfBall.y < Constants.WINDOW_TOOLBAR_TOP||this.rectOfBall.y +this.rectOfBall.height > Constants.WINDOW_TOOLBAR_BOTTOM) {
            this.yVelocity*=-1;
        } else {if (xVelocity < 0) {
                if (this.rectOfBall.x <= this.firstTrackedRect.x + this.firstTrackedRect.width &&
                        this.rectOfBall.y + this.rectOfBall.height >= this.firstTrackedRect.y && this.rectOfBall.y <= this.firstTrackedRect.y + this.firstTrackedRect.height) {

                    firstBallLogic();

                } else if (this.rectOfBall.x+this.rectOfBall.width < this.firstTrackedRect.x+this.firstTrackedRect.width) {
                    int rightNumber=Integer.parseInt(rightScore.Text);
                    rightNumber++;
                    if(rightNumber>Constants.END_SCORE){
                        Main.changeState(true,false,false);
                    }
                    rightScore.Text=Integer.toString(rightNumber);

                    rightPoint=true;

                    //setting all objects to start position
                    rectOfBall.x=Constants.WINDOW_WIDTH/2-5;
                    rectOfBall.y=Constants.WINDOW_HEIGHT/2;
                    firstTrackedRect.x=Constants.PADDLE1_LOCATION_X;
                    firstTrackedRect.y=Constants.PADDLE_LOCATION_Y;
                    secondTrackedRect.x=Constants.PADDLE2_LOCATION_X;
                    secondTrackedRect.y=Constants.PADDLE_LOCATION_Y;

                    //throwing ball in left side
                    xVelocity=-10;
                    yVelocity=0;
                    Constants.isScored=true;
                    //Writing score to the text document
                    HistoryOfMatch.writingHistory();
                }
            } else if (xVelocity > 0) {
            if (this.rectOfBall.x + this.rectOfBall.width >= this.secondTrackedRect.x &&
                        this.rectOfBall.y + this.rectOfBall.height >= this.secondTrackedRect.y && this.rectOfBall.y <= this.secondTrackedRect.y + this.secondTrackedRect.height) {

                secondBallLogic();

                } else if (this.rectOfBall.x > this.secondTrackedRect.x) {

                int leftNumber=Integer.parseInt(leftScore.Text);
                leftNumber++;
                if(leftNumber>Constants.END_SCORE){
                    Main.changeState(true,false,false);
                }
                leftScore.Text=Integer.toString(leftNumber);

                leftPoint=true;

                //setting all objects to start position
                rectOfBall.x=Constants.WINDOW_WIDTH/2-5;
                rectOfBall.y=Constants.WINDOW_HEIGHT/2;
                firstTrackedRect.x=Constants.PADDLE1_LOCATION_X;
                firstTrackedRect.y=Constants.PADDLE_LOCATION_Y;
                secondTrackedRect.x=Constants.PADDLE2_LOCATION_X;
                secondTrackedRect.y=Constants.PADDLE_LOCATION_Y;

                //throwing ball in right side
                xVelocity=10;
                yVelocity=0;
                Constants.isScored=true;

                //Writing score to the text document
                HistoryOfMatch.writingHistory();
            }
            }
        }
        //moving the ball
        this.rectOfBall.x +=xVelocity;
        this.rectOfBall.y +=yVelocity;
    }
    // ball logic for second Player
    public void secondBallLogic(){
        if (yVelocity >= 0) {//+
            if (this.rectOfBall.y + this.rectOfBall.height >= this.secondTrackedRect.y && this.rectOfBall.y + this.rectOfBall.height<= this.secondTrackedRect.y + Constants.PADDLE_PART6) {
                this.xVelocity *= -1;
                this.yVelocity = -9;
            } else if (this.rectOfBall.y + this.rectOfBall.height >= this.secondTrackedRect.y + Constants.PADDLE_PART6 && this.rectOfBall.y <= this.secondTrackedRect.y + Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = 8;
            } else if (this.rectOfBall.y >= this.secondTrackedRect.y + Constants.PADDLE_PART && this.rectOfBall.y <= this.secondTrackedRect.y + 2 * Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = 5;
            } else if (this.rectOfBall.y >= this.secondTrackedRect.y + 2 * Constants.PADDLE_PART && this.rectOfBall.y <= this.secondTrackedRect.y + 3 * Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = 3;
            } else if (this.rectOfBall.y >= this.secondTrackedRect.y + 3 * Constants.PADDLE_PART && this.rectOfBall.y <= this.secondTrackedRect.y + 4 * Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = 5;
            } else if (this.rectOfBall.y >= secondTrackedRect.y + 4 * Constants.PADDLE_PART && this.rectOfBall.y <= this.secondTrackedRect.y + this.secondTrackedRect.height) {
                this.xVelocity *= -1;
                this.yVelocity = 8;
            }
        } else if (yVelocity <= 0) {//-
            if (this.rectOfBall.y + this.rectOfBall.height >= this.secondTrackedRect.y && this.rectOfBall.y <= this.secondTrackedRect.y + Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = -8;
            } else if (this.rectOfBall.y >= this.secondTrackedRect.y + Constants.PADDLE_PART && this.rectOfBall.y <= this.secondTrackedRect.y + 2 * Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = -5;
            } else if (this.rectOfBall.y >= this.secondTrackedRect.y + 2 * Constants.PADDLE_PART && this.rectOfBall.y <= this.secondTrackedRect.y + 3 * Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = -3;
            } else if (this.rectOfBall.y >= this.secondTrackedRect.y + 3 * Constants.PADDLE_PART && this.rectOfBall.y <= this.secondTrackedRect.y + 4 * Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = -5;
            } else if (this.rectOfBall.y >= this.secondTrackedRect.y + 4 * Constants.PADDLE_PART && this.rectOfBall.y <=(this.secondTrackedRect.y + this.secondTrackedRect.height)-Constants.PADDLE_PART6) {
                this.xVelocity *= -1;
                this.yVelocity = -8;
            }else if (this.rectOfBall.y >= (this.secondTrackedRect.y + this.secondTrackedRect.height)-Constants.PADDLE_PART6 && this.rectOfBall.y <= this.secondTrackedRect.y + this.secondTrackedRect.height) {
                this.xVelocity *= -1;
                this.yVelocity = 9;
            }
        }
    }
    // ball logic for first Player
    public void firstBallLogic() {
        if (yVelocity >= 0) {//+
            if (this.rectOfBall.y + this.rectOfBall.height >= this.firstTrackedRect.y && this.rectOfBall.y + this.rectOfBall.height <= this.firstTrackedRect.y + Constants.PADDLE_PART6) {
                this.xVelocity *= -1;
                this.yVelocity = -9;
            } else if (this.rectOfBall.y + this.rectOfBall.height >= this.firstTrackedRect.y + Constants.PADDLE_PART6 && this.rectOfBall.y <= this.firstTrackedRect.y + Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = 8;
            } else if (this.rectOfBall.y >= this.firstTrackedRect.y + Constants.PADDLE_PART && this.rectOfBall.y <= this.firstTrackedRect.y + 2 * Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = 5;
            } else if (this.rectOfBall.y >= this.firstTrackedRect.y + 2 * Constants.PADDLE_PART && this.rectOfBall.y <= this.firstTrackedRect.y + 3 * Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = 3;
            } else if (this.rectOfBall.y >= this.firstTrackedRect.y + 3 * Constants.PADDLE_PART && this.rectOfBall.y <= this.firstTrackedRect.y + 4 * Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = 5;
            } else if (this.rectOfBall.y >= firstTrackedRect.y + 4 * Constants.PADDLE_PART && this.rectOfBall.y <= this.firstTrackedRect.y + this.firstTrackedRect.height) {
                this.xVelocity *= -1;
                this.yVelocity = 8;
            }
        } else if (yVelocity <= 0) {//-
            if (this.rectOfBall.y + this.rectOfBall.height >= this.firstTrackedRect.y && this.rectOfBall.y <= this.firstTrackedRect.y + Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = -8;
            } else if (this.rectOfBall.y >= this.firstTrackedRect.y + Constants.PADDLE_PART && this.rectOfBall.y <= this.firstTrackedRect.y + 2 * Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = -5;
            } else if (this.rectOfBall.y >= this.firstTrackedRect.y + 2 * Constants.PADDLE_PART && this.rectOfBall.y <= this.firstTrackedRect.y + 3 * Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = -3;
            } else if (this.rectOfBall.y >= this.firstTrackedRect.y + 3 * Constants.PADDLE_PART && this.rectOfBall.y <= this.firstTrackedRect.y + 4 * Constants.PADDLE_PART) {
                this.xVelocity *= -1;
                this.yVelocity = -5;
            } else if (this.rectOfBall.y >= this.firstTrackedRect.y + 4 * Constants.PADDLE_PART && this.rectOfBall.y <= (this.firstTrackedRect.y + this.firstTrackedRect.height) - Constants.PADDLE_PART6) {
                this.xVelocity *= -1;
                this.yVelocity = -8;
            } else if (this.rectOfBall.y >= (this.firstTrackedRect.y + this.firstTrackedRect.height) - Constants.PADDLE_PART6 && this.rectOfBall.y <= this.firstTrackedRect.y + this.firstTrackedRect.height) {
                this.xVelocity *= -1;
                this.yVelocity = 9;
            }
        }
    }
}
