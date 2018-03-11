package me.drenny.designapp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    private FlowPane background = new FlowPane();
    private FlowPane inner_background = new FlowPane();
    private GridPane layout = new GridPane();
    private BorderPane border_layout = new BorderPane();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        mainStage.setTitle("Login Application Test");

        ImageView backgroundImage = new ImageView("images/background-image 2.jpg");
        backgroundImage.setEffect(blurEffect());
        backgroundImage.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        backgroundImage.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        background.getChildren().add(backgroundImage);

        inner_background.setAlignment(Pos.CENTER);
        ImageView inner_image = new ImageView("images/inner_background2.jpg");
        inner_image.setFitWidth(352);
        inner_image.setFitHeight(198);
        Rectangle clip = new Rectangle(inner_image.getFitWidth(), inner_image.getFitHeight());
        clip.setArcHeight(20);
        clip.setArcWidth(20);
        inner_image.setClip(clip);
        inner_background.getChildren().add(inner_image);

        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);

        TextField USERNAME = new TextField("Username");
        USERNAME.setAlignment(Pos.CENTER);
        USERNAME.setPrefColumnCount(25);
        layout.add(USERNAME, 0, 1);

        PasswordField PASSWORD = new PasswordField();
        PASSWORD.setText("Password");
        PASSWORD.setAlignment(Pos.CENTER);
        PASSWORD.setPrefColumnCount(25);
        layout.add(PASSWORD, 0 ,2);

        Button BTN_LOGIN = new Button("Login");
        BTN_LOGIN.setPrefWidth(304);
        layout.add(BTN_LOGIN, 0, 3);

        Button BTN_CREATE = new Button("Create an Account");
        Button BTN_FORGOT = new Button("Forgot Password?");

        HBox HBOX_FORGOT_CREATE = new HBox(80);
        HBOX_FORGOT_CREATE.setAlignment(Pos.BOTTOM_LEFT);
        HBOX_FORGOT_CREATE.getChildren().addAll(BTN_CREATE, BTN_FORGOT);
        layout.add(HBOX_FORGOT_CREATE, 0, 4);

//        mainStage.initStyle(StageStyle.TRANSPARENT);
        mainStage.setScene(new Scene(new StackPane(background, border_layout, inner_background, layout), 1280, 720));
        mainStage.show();
    }

    public BoxBlur blurEffect() {
        return new BoxBlur(60, 60, 3);
    }
}
