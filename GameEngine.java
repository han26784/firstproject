import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


// for keyboard inputs
public class GameEngine implements Engine, KeyListener, Observer {
    private final DynamicSprite hero;

    public GameEngine(DynamicSprite hero) {
        // constructor
        this.hero = hero;
    }

    // @Override
    // public void update() {

    // }

    @Override
    public void keyPressed(KeyEvent e) { //the direction the hero goes
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> hero.setDirection(Direction.NORTH);
            case KeyEvent.VK_DOWN -> hero.setDirection(Direction.SOUTH);
            case KeyEvent.VK_LEFT -> hero.setDirection(Direction.WEST);
            case KeyEvent.VK_RIGHT -> hero.setDirection(Direction.EAST);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    } 
    public void keyTyped(KeyEvent e) {

    }

    // the observer interface methods

    @Override
    public void update() {
        // method called when the subject not observers
        System.out.println("GameEngine detected hero moved.");
        System.out.println("New hero position = (" + hero.getX() + ", " + hero.getY() + ")");
    }
}
