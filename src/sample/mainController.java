package sample;

//  Imports from JavaFX
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;

public class mainController {
    @FXML
    Pane gridPane;

    @FXML
    TextField nameText;

    @FXML
    TextField healthText;

    @FXML
    Button loadImage;

    @FXML
    BorderPane borderPane;

    @FXML
    TextField nameLabel;

    @FXML
    TextField healthLabel;

//  Grid variables
    private int gridSize = 450;
    private int tiles = 10;
    private int tileSize = gridSize/tiles;

//  Information variables
    private String name;
    private String health;
    private Image picture;
    private Player selectedPlayer;

//  Table values
    private ArrayList<Player> players = new ArrayList<>();

//  Create grid
    @FXML
    public void initialize(){
        for (int i = 0; i < gridSize; i+=tileSize){
            for (int u = 0; u < gridSize; u+=tileSize){
                Rectangle r = new Rectangle(i, u,tileSize,tileSize);
                r.setFill(Color.WHITE);
                r.setStroke(Color.BLACK);
                gridPane.getChildren().add(r);
            }
        }
    }

//  Create player pieces
    @FXML
    public void createPiece(ActionEvent e){

//      Creating the character piece
        Circle circle = new Circle();
        circle.setFill(Color.BLUE);
        circle.setStroke(Color.DARKBLUE);
        circle.setStrokeWidth(3);
        double radius = tileSize/2;
        double x = tileSize/2 + tileSize;
        Player p = new Player(x, tileSize/2, radius, circle);

//      Adding the data
        name = nameText.getText();
        health = healthText.getText();
        p.setName(name);
        p.setHealth(health);
        healthText.setText(null);
        nameText.setText(null);
        if (picture != null){
            p.setImage(picture);
            picture = null;
        }
        players.add(p);

//      Assigning functions
        circle.setOnMousePressed(event -> piecePressed(event, p));
        circle.setOnMouseDragged(event -> pieceDragged(event, p));
        circle.setOnMouseReleased(event -> pieceReleased(event, p));

        gridPane.getChildren().add(circle);
        p.place();
    }

//  Piece interactions with mouse
    public void piecePressed(MouseEvent event, Player p){
        p.setColor(Color.DARKRED);
        healthLabel.setText(p.getHealth());
        nameLabel.setText(p.getName());
        selectedPlayer = p;
    }
    public void pieceDragged(MouseEvent event, Player p){
        p.setX(p.getX() + event.getX());
        p.setY(p.getY() + event.getY());
        p.place();
    }
    public void pieceReleased(MouseEvent event, Player p){
        int gridx = (int)p.getX() / tileSize;
        int gridy = (int)p.getY() / tileSize;
        p.setX(tileSize/2+tileSize*gridx);
        p.setY(tileSize/2+tileSize*gridy);
        p.setColor(Color.DARKBLUE);
        p.place();
    }

//   Image loader
    @FXML
    public void pickImage(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) borderPane.getScene().getWindow();
        File openedFile = fileChooser.showOpenDialog(stage);
        if (openedFile != null) {
            picture = new Image(openedFile.toURI().toString());
        }
    }

//  Update pieces
    @FXML
    public void updatePlayer(ActionEvent e){
        selectedPlayer.setHealth(healthLabel.getText());
        selectedPlayer.setName(nameLabel.getText());
    }
}
