package sample;

//  Imports from JavaFX
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;

public class Piece {
    private double X;
    private double Y;
    private double radius;
    private Image image;
    private Circle circle;

    public Piece(double X, double Y, double radius, Circle circle){
        this.X = X;
        this.Y = Y;
        this.radius = radius;
        this.circle = circle;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public void setColor(Color color){ circle.setStroke(color); }

    public void setRadius(double radius1){ radius = radius1; }

    public void setImage(Image image){
        circle.setFill(new ImagePattern(image));
    }

    public void place(){
        circle.setRadius(radius);
        circle.setTranslateX(X);
        circle.setTranslateY(Y);
    }
}
