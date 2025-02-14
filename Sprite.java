import java.awt.Graphics;
import java.awt.Image;


/*
 * this is the visual interface 
 * image, position x,y, size width height
 * we are using displayable for rendering
 */

 public class Sprite implements Displayable {
    protected Image image; // the image object we are drawing
    protected double x;
    protected double y;
    protected double width;
    protected double height;


    public Sprite(double x, double y, 
    Image image, double width, double height) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, (int)x, (int)y, (int)width, (int)height, null);
    }


    public double getX() { 
        return x;
    }
    public double getY() {
        return y;
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public Image getImage() { 
        return image; 
    }
 }