import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


/*
 * this class draws all the displayable objects
 * the update calls the repaint method which calls paint()
 */
public class RenderEngine extends JPanel implements Engine {
    // the list of items we are rendering
    private List<Displayable> renderList = new ArrayList<>();

    public RenderEngine() {
        // default constructor
        super();
    }

    @Override // g is the graphic context
    public void paint(Graphics g) {
        super.paint(g);

        for (Displayable d: renderList) {
            // draw the displayable
            d.draw(g);

        }
    }

    public void addToRenderList(Displayable displayable) {
        // add displayable obj to list we want to draw 
        renderList.add(displayable);
    }

    public void setRenderList(List<Displayable> newList) {
        // if we want to replace the list
        this.renderList = newList;
    }

    @Override
    public void update() {
        // calling paint
        repaint();
    }
}