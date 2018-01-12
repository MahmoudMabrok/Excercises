import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Spliter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane p = new Pane();

        int x = 0x10 ;

        System.out.println(Integer.toBinaryString(x).charAt(0));
        Scene s = new Scene(p);
        primaryStage.setScene(s);
        primaryStage.setTitle(" Spliter");
        primaryStage.show();

    }
}
