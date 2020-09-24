package GraphicsTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Shape;

public class ShapeItem {
    private Shape shape;
    private Color color;
	private static final Color DEFAULT_COLOR = Color.BLUE;
	private static final Shape DEFAULT_SHAPE = new Rectangle2D.Double(0,0,1,1);

	public ShapeItem(Shape shape, Color color) {
        super();
        this.shape = shape;
        this.color = color;
    }
	
	public ShapeItem() {
        super();
        this.shape = DEFAULT_SHAPE;
        this.color = DEFAULT_COLOR;
    }
	public ShapeItem(Shape shape) {
        super();
        this.shape = shape;
        this.color = DEFAULT_COLOR;
    }
	
	public ShapeItem(Color color) {
        super();
        this.shape = DEFAULT_SHAPE;
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
