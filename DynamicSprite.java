import java.awt.Image;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

// hardest challenge 
//most comp one so far
// implements moving characters 
public class DynamicSprite extends SolidSprite implements Observable {


    private boolean isWalking = true;

    private double speed = 5.0;

    private final int spriteSheetNumberOfColumn = 10;

    private int timeBetweenFrame = 200;

    private Direction direction = Direction.NORTH;

    // The observer patterns fields 

    private List<Observer> observers = new ArrayList<>();


    public DynamicSprite(double x, double y, Image image, double width,
    double height) {
        super(x, y, image, width, height);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    @Override
    public void draw(Graphics g) {
        long currentTime = System.currentTimeMillis();

        // # of cols
        int index = (int) ((currentTime / timeBetweenFrame) % spriteSheetNumberOfColumn);

        int attitude = direction.getFrameLineNumber();

        // index *width = right col
        // attitude  ehgith = right row

        int srcX1 = index * (int) width; // begin of h part
        int srcY1 = attitude * (int) height; // begin of v part
        int srcX2 = srcX1 + (int)width; // end of h part
        int srcY2 = srcY1 + (int) height; // end of v part

        g.drawImage(image, (int)x, (int)y, (int)x + (int)width, (int)y + (int)height,
        srcX1, srcY1, srcX2, srcY2, null);
        }

        public void moveIfPossible(java.util.List<Sprite> environment) {
            if (isMovingPossible(environment)) {
                move();
            }
        }

        private boolean isMovingPossible(java.util.List<Sprite> environment) {
            double futureX = x;
            double futureY = y;

            switch (direction) {
                case NORTH -> futureY = y - speed;
                case SOUTH -> futureY = y + speed;
                case WEST -> futureX = x - speed;
                case EAST -> futureX = x + speed;
            }


            Rectangle2D.Double hitBox = new Rectangle2D.Double(futureX, futureY, width, height);
            

            //checking collisions
            for (Sprite sprite: environment) {
                if (sprite instanceof SolidSprite && sprite != this) {// not itself and not solid
                Rectangle2D.Double obstacleBox = new Rectangle2D.Double(sprite.x, sprite.y, sprite.width, 
                    sprite.height);
                    if (hitBox.intersects(obstacleBox)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void move() {
            switch (direction) {
                case NORTH -> y -= speed;
                case SOUTH -> y += speed;
                case WEST -> x -= speed;
                case EAST -> x += speed;
            }
            System.out.println("hero moved !");
            notifyObserver(); // notify after movement (obs pattern)
        }

        // the observer pattern implementations 

        @Override
        public void addObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }
        
        @Override
        public void notifyObserver() {
            for (Observer obs : observers) {
                obs.update();
            }
        }

        public void setWalking(boolean walking) {
            this.isWalking = walking;
        }

        public boolean isWalking() {
            return isWalking;
        }
        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public double getSpeed() {
            return speed;
        }

        public void setTimeBetweenFrame(int timebetweenFrame) {
            this.timeBetweenFrame = timebetweenFrame;
        }
        public int getTimeBetweenFrame() {
            return timeBetweenFrame;
        }
    }
