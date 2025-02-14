import java.awt.Graphics;

/*
 * any objects that can be drawn on the screen using graphics
 * context implements this interface
 */

 public interface Displayable {
    // @param g is the graphic context
    void draw(Graphics g);
 }