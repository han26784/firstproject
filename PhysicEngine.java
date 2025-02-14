import java.util.ArrayList;
import java.util.List;


// has all the solid sprites and all the moving sprites

public class PhysicEngine implements Engine {

    // the moving sprites 
    private final List<DynamicSprite> movingSpritesList = new ArrayList<>();


    private List<Sprite> environment = new ArrayList<>(); // the solid sprites

    public void addToMovingSpriteList(DynamicSprite sprite) {
        // getter
        movingSpritesList.add(sprite);
    }
    public void setEnvironment(List<Sprite> environment) {
        // setter
        this.environment = environment;
    }

    @Override
    public void update() { // update the game to know if able to move
        for (DynamicSprite dynamic: movingSpritesList) {
            dynamic.moveIfPossible(environment);
        }
    }
}
