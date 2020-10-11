package shape;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public final class Circle {

    final Font font =  Font.font("Cooper Black", FontWeight.BOLD, 16);

    public static final int RADIUS = 26;

    private final Integer searchKey;

    // The circle attributes
    private Point2D point;
    private Color backgroundColor;
    private Color borderColor;
    private Color fontColor;

    public Circle(Integer searchKey) {
        this.searchKey = searchKey;
        this.backgroundColor = Color.web("#FCFCFC");
    }

    public Circle(Integer searchKey, Point2D point) {
        this.searchKey = searchKey;
        this.point = point;
        this.backgroundColor = Color.rgb(49, 116, 222);
        this.setBorderColor(Color.rgb(99, 99, 99));
        this.fontColor = Color.web("#FCFCFC");

    }


    public void draw(GraphicsContext gc) {
        gc.setLineWidth(3); // Sets the width of the lines

        // Create a circle
        gc.setFill(backgroundColor);
        gc.fillOval(point.getX() - RADIUS, point.getY() - RADIUS, 2 * RADIUS, 2 * RADIUS);

        // Outline the circle border
        gc.setStroke(borderColor);
        gc.strokeOval(point.getX() - RADIUS, point.getY() - RADIUS, 2 * RADIUS, 2 * RADIUS);

        // Draw the id number inside the circle
        gc.setFont(font);
        gc.setFill(getFontColor());
        gc.fillText(getKey(),point.getX() - 10, point.getY()+ 10);
    }

    private String getKey() {
        return Integer.toString(getSearchKey());
    }

    public Integer getSearchKey() {
        return this.searchKey;
    }

    public Color getBorderColor() {
        return borderColor;
    }


    private void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }


    public Point2D getPoint() {
        return point;
    }

    public void setPoint(Point2D point) {
        this.point = point;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    private void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    public int getRadius() {
        return RADIUS;
    }

    public Color getFontColor() {
        return this.fontColor;
    }

    private void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public void setHighlighter(boolean highlight) {
        if (highlight) {
            setFontColor(Color.rgb(49, 116, 222));
            setBackgroundColor(Color.rgb(155, 244, 167));
            setBorderColor(Color.rgb(49, 116, 222));

        } else {
            setFontColor(Color.web("#FCFCFC"));
            setBackgroundColor(Color.rgb(49, 116, 222));
            setBorderColor(Color.rgb(99, 99, 99));
        }
    }

    @Override
    public String toString() {

        return "Search Key# " + searchKey  +
                " (x,y) = ("  + point.getX() + ", " + point.getY() + ")";
    }
}