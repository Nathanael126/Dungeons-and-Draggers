package sample;

//  Imports from JavaFX
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;


public class Main extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
//      Create root
        Parent root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
        Scene scene = new Scene(root);

//      Set stage
        Image icon = new Image("Dungeons and Draggers Logo.png");
        stage.getIcons().add(icon);
        stage.setTitle("Dungeons and Draggers");
        stage.setResizable(false);

//      Show stage and scene
        stage.setScene(scene);
        stage.show();
    }
}
