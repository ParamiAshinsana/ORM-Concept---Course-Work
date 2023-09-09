package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("/view/student_login_form.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Login Form");
//        stage.setScene(scene);
//        stage.show();

        Parent root = FXMLLoader.load(getClass().getResource("/view/loading_form.fxml"));
        stage.centerOnScreen();
        Scene scene = new Scene(root,600,400, Color.TRANSPARENT);
        root.setStyle("-fx-background-color: transparent");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
}
