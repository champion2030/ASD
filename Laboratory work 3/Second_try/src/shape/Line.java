package shape;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class Line {


    private static final Color UI_DEFAULT_COLOR = Color.rgb(99, 99, 99);

    private static final Color HIGHLIGHT_COLOR = Color.rgb(49, 116, 222);

    // The circle attributes
    private Point2D point, point2;
    private Color color;

    public Line() {
        this.color = UI_DEFAULT_COLOR;
    }


    public Line(Point2D point, Point2D point2) {
        this.point = point;
        this.point2 = point;
        this.color = UI_DEFAULT_COLOR;
    }

    public void draw(GraphicsContext gc) {
        //	g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gc.setLineWidth(4); // Sets the width of the lines

        // Fill the line
        gc.setStroke(color);
        gc.strokeLine(point.getX(), point.getY(), point2.getX(), point2.getY());
    }

    public Point2D getPoint() {
        return point;
    }

    public void setPoint(Point2D point, Point2D point2) {
        this.point = point;
        this.point2 = point2;
    }


    public Point2D getPoint2() {
        return point2;
    }


    public void setHighlighter(boolean highlight) {
        if (highlight) {
            this.color = HIGHLIGHT_COLOR;
        } else {
            this.color = UI_DEFAULT_COLOR;
        }
    }

    @Override
    public String toString() {

        return " (x,y) = ("  + point.getX() + ", " + point.getY() + ")"
                +  " (x,y) = ("  + point2.getX() + ", " + point2.getY()+ ")";
    }
}