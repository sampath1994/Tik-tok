package application;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
 
public class Main  extends Application {
	 private static double xOffset = 0;
	    private static double yOffset = 0;
    
  
    @Override
    public void start(Stage primaryStage) {
        try {
            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass()
                    .getResource("/application/TimerUI.fxml"));
 
            primaryStage.initStyle(StageStyle.UNDECORATED);
            //primaryStage.
            
            primaryStage.setAlwaysOnTop(true);
            primaryStage.setTitle("Tik-tok");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = primaryStage.getX() - event.getScreenX();
                    yOffset = primaryStage.getY() - event.getScreenY();
                }
            });
            
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setX(event.getScreenX() + xOffset);
                    primaryStage.setY(event.getScreenY() + yOffset);
                }
            });
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}