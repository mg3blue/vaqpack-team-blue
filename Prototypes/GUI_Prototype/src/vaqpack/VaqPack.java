package vaqpack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class VaqPack extends Application {

    private final double height = 700;
    private final double width = 700;

    @Override
    public void start(Stage stage) {

        stage.setHeight(height);
        stage.setWidth(width);
        //no idea
        HBox hbox = new HBox(0);
        hbox.setTranslateX(0);
        hbox.setTranslateY(0);

        SplitPane horizontalSplit = new SplitPane();
        horizontalSplit.setOrientation(Orientation.HORIZONTAL);
        horizontalSplit.setStyle("-fx-box-border: transparent;");
        horizontalSplit.setPrefHeight(height);

        SplitPane verticalSplit = new SplitPane();
        verticalSplit.setOrientation(Orientation.VERTICAL);
        verticalSplit.setPrefWidth(4 * width / 5);
        verticalSplit.setStyle("-fx-box-border: transparent;");

        // left panel
        HBox left = new HBox();
        ImageView imgViewer = new ImageView(new Image(VaqPack.class.getResourceAsStream("b.png")));
        imgViewer.setFitHeight(3 * height / 20);
        imgViewer.setFitWidth(width / 5);
        left.getChildren().add(imgViewer);
        left.setPrefWidth(width / 5);
        left.setMaxWidth(width / 5);
        left.setStyle("-fx-background-color: #abcdef;");

        
        //top right
        HBox top = new HBox();
        top.setPrefHeight(3 * height / 20);
        top.setMaxHeight(3 * height / 20);
        top.setStyle("-fx-background-color: #abcdef;");

        //center right
        HBox center = new HBox();
        center.setPrefHeight(3 * height / 4);
        center.setMaxHeight(3 * height / 4);
        center.setStyle("-fx-background-color: #fedcba;");

        //bottom right
        HBox bottom = new HBox();
        bottom.setPrefHeight(height / 10);
        bottom.setMaxHeight(height / 10);
        bottom.setStyle("-fx-background-color: #abcdef;");

        //buttons
        Button btnCancel = new Button("Cancel");
        btnCancel.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
        
        Button btnBack = new Button("Back");
        btnBack.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
        
        Button btnNext = new Button("Next");
        btnNext.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
        
        Button btnFinish = new Button("Finish");
        btnFinish.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
        
        btnCancel.setPrefWidth(width/10);
        btnBack.setPrefWidth(width/10);
        btnNext.setPrefWidth(width/10);
        btnFinish.setPrefWidth(width/10);

        bottom.getChildren().addAll(btnCancel,btnNext);
        
        
        
        
        final Button r = new Button("This should be on the bottom");
        r.setPrefHeight(height / 10);

        verticalSplit.getItems().addAll(top, center, bottom);
        horizontalSplit.getItems().addAll(left, verticalSplit);

        hbox.getChildren().add(horizontalSplit);
        Scene scene = new Scene(new Group(hbox), width, height);
        scene.setFill(Color.GHOSTWHITE);
        stage.setScene(scene);
        stage.setTitle("VaqPack");

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        stage.setX((bounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((bounds.getHeight() - stage.getHeight()) / 2);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
