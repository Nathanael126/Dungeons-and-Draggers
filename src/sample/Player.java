package sample;

//  Imports from JavaFX
import javafx.scene.shape.Circle;

public class Player extends Piece{

    private String name;
    private String health;

    public Player(double X, double Y, double radius, Circle circle) {
        super(X, Y, radius, circle);
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(name);
    }

    public void setHealth(String health){ this.health = health;}

    public String getName(){return name;};

    public String getHealth(){return health;};
}
