import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("app-view.fxml"));
            Scene scene = new Scene(root,600,350);
            scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
            stage.setTitle("Password Generator");
            stage.setScene(scene);
            stage.show();
          //  stage.setResizable(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openApp(){
        launch();
    }
}
