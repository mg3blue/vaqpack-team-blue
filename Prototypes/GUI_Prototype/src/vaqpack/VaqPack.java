package vaqpack;

import java.util.Iterator;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Orientation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class VaqPack extends Application {

    private Pagination pagination;
    private final double height = 700;
    private final double width = 700;
    private HBox hbox, topLeft, topRight, mainPane, bottomLeft;
    private TextArea leftText;
    final String[] leftPaneText = new String[]{
        "Welcome",
        "Security",
        "Information",
        "Selection",
        "Resume",
        "Business Card",
        "Cover Letter",
        "Recipients",
        "Agreement",
        "Completed"
    };

    final GridPane[] pages = new GridPane[10];

    public void initPages(){
        //create pages here 
        for (int i = 0; i < pages.length; i++) {
            pages[i] = new GridPane();
        }
        
         Button a = new Button("testing");
        pages[0].getChildren().addAll(a);

    }
    
    private void setTextOnLeftPane(int index){
       leftText.setText("");
       for(int i = 0 ; i <= index; i++)
           leftText.setText( leftText.getText() + leftPaneText[i] + "\n");
    }
    
    public HBox createPage(int pageIndex) {
        HBox box = new HBox(5);
        box.getChildren().add(pages[pageIndex]);
        return box;
    }

    @Override
    public void start(Stage stage) {

        stage.setHeight(height);
        stage.setWidth(width);
        
        initPages();
        
        pagination = new Pagination(10, 0);
        pagination.setPageFactory((Integer pageIndex) -> {
            if (pageIndex >= pages.length) 
                return null;
            return createPage(pageIndex);
        });
      pagination.addEventHandler(EventType.ROOT, (Event event) -> {
          setTextOnLeftPane( pagination.getCurrentPageIndex() );
        });
        //no idea
        hbox = new HBox(0);
        hbox.setTranslateX(0);
        hbox.setTranslateY(0);
        
        SplitPane horizontalSplit = new SplitPane();
        horizontalSplit.setOrientation(Orientation.HORIZONTAL);
        horizontalSplit.setStyle("-fx-box-border: transparent;");
        horizontalSplit.setPrefHeight(height);

        SplitPane verticalSplitRight = new SplitPane();
        verticalSplitRight.setOrientation(Orientation.VERTICAL);
        verticalSplitRight.setPrefWidth(4 * width / 5);
        verticalSplitRight.setStyle("-fx-box-border: transparent;");
        verticalSplitRight.setMinWidth(4 * width / 5);

        SplitPane verticalSplitLeft = new SplitPane();
        verticalSplitLeft.setOrientation(Orientation.VERTICAL);
        verticalSplitLeft.setPrefWidth(width / 5);
        verticalSplitLeft.setStyle("-fx-box-border: transparent;");
        verticalSplitLeft.setMaxWidth(width / 5);
        
        // top left panel
        topLeft = new HBox();
        ImageView imgViewer = new ImageView(new Image(VaqPack.class.getResourceAsStream("b.png")));
        imgViewer.setFitHeight(3 * height / 20);
        imgViewer.setFitWidth(width / 5);
        topLeft.getChildren().addAll(imgViewer);
        topLeft.setPrefWidth(width / 5);
        topLeft.setMaxWidth(width / 5);
        topLeft.setStyle("-fx-background-color: #ffffff;");
        topLeft.setMaxHeight(3 * height/20);

        //bottom left panel
        bottomLeft = new HBox();
        leftText = new TextArea();
        leftText.setEditable(false);
        leftText.setVisible(true);
        leftText.setPrefWidth(width / 5);
        leftText.setMaxWidth(width / 5);
        bottomLeft.getChildren().addAll(leftText);
        bottomLeft.setPrefWidth(width / 5);
        bottomLeft.setMaxWidth(width / 5);
        bottomLeft.setStyle("-fx-background-color: #ffffff;");
        bottomLeft.setMaxHeight(17 * height / 20);
        
        //top right
        topRight = new HBox();
        topRight.setPrefHeight(3 * height / 20);
        topRight.setMaxHeight(3 * height / 20);
        topRight.setStyle("-fx-background-color: #007030;");

        //main
        mainPane = new HBox();
        mainPane.setPrefHeight(17 * height / 20);
        mainPane.setMaxHeight(17 * height / 20);
        mainPane.setStyle("-fx-background-color: #fedcba;");
        mainPane.getChildren().add(pagination);

        
        verticalSplitLeft.getItems().addAll(topLeft, bottomLeft);
        verticalSplitRight.getItems().addAll(topRight, mainPane);
        horizontalSplit.getItems().addAll(verticalSplitLeft, verticalSplitRight);
        hbox.getChildren().add(horizontalSplit);
        Scene scene = new Scene(new Group(hbox), width, height);
        scene.setFill(Color.GHOSTWHITE);
        stage.setScene(scene);
        stage.setTitle("BackPack");

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        stage.setX((bounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((bounds.getHeight() - stage.getHeight()) / 2);
        
        setTextOnLeftPane(0);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
