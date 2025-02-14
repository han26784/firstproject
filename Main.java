import javax.swing.JFrame;
import javax.swing.Timer;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.List;


public class Main {
    JFrame displayZoneFrame;

    RenderEngine renderEngine;
    GameEngine gameEngine;
    PhysicEngine physicEngine;

    public Main() throws Exception {
        displayZoneFrame = new JFrame("java labs");
        displayZoneFrame.setSize(400,600);
        displayZoneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        DynamicSprite hero = new DynamicSprite(200,300,
        ImageIO.read(new File("./img/heroTileSheetLowRes.png")),48,50);


        renderEngine = new RenderEngine();
        physicEngine = new PhysicEngine();
        gameEngine = new GameEngine(hero);

        Timer renderTimer = new Timer(50,(time)-> renderEngine.update());
        
        Timer gameTimer = new Timer(50,(time)-> gameEngine.update()); //keyboard

        Timer physicTimer = new Timer(50, (time) -> physicEngine.update());// for collisions  movement


        renderTimer.start();
        gameTimer.start();
        physicTimer.start();

        displayZoneFrame.getContentPane().add(renderEngine); // add renderEnginer to main framce

        displayZoneFrame.addKeyListener(gameEngine); // set up the keyboard inputs

        Playground playground = new Playground("./level1.txt"); // load the level
    
        for (Displayable d : playground.getSpriteList()) {
            renderEngine.addToRenderList(d); // add sprites
        }

        List<Sprite> solidSpritesFromPlayground = playground.getSolidSpriteList();

        renderEngine.addToRenderList(hero);
        physicEngine.addToMovingSpriteList(hero);

        physicEngine.setEnvironment(solidSpritesFromPlayground); // see solid for collision

        displayZoneFrame.setVisible(true);
    }

    public static void main (String[] args) throws Exception {
        Main main = new Main();
    }
}