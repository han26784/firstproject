import java.awt.Image;

/*
 * sprite that cannot be passed through by dynamicSprite
 * 
 */

 public class SolidSprite extends Sprite {
    // parameters x,y, image, width, height


    public SolidSprite(double x, double y, Image image, double width,
    double height) { // constructor equal sprite class so we call super
        super(x, y, image, width, height);
    }
 }