package lk.ijse.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadingFormController implements Initializable {

    public AnchorPane loadingFormRoot;
    public ImageView loadingImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadingImageView.setImage(new Image("/img/loading.png"));
        loadingImageView.setCache(true);

        Timeline timeline = new Timeline();
        //KeyFrame keyFrame = new KeyFrame(Duration.millis(10000), actionEvent -> {
        KeyFrame keyFrame = new KeyFrame(Duration.millis(8000), actionEvent -> {
            System.out.println("Initializing...");

            Session session = null;
            try {
                session = FactoryConfiguration.getInstance().getSession();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Transaction transaction = session.beginTransaction();
            transaction.commit();
            session.close();
        });

        timeline.getKeyFrames().addAll(keyFrame);
        timeline.playFromStart();

        timeline.setOnFinished(actionEvent -> {
            try{
                loadingFormRoot.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("/view/student_login_form.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        });
    }
}
