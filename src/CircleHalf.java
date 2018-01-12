import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;


public class CircleHalf extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Arc a = new Arc() ;
        a.setRadiusX(50);
        a.setRadiusY(50);
        a.setCenterX(50);
        a.setCenterY(50);
        a.setStartAngle(0);
        a.setLength(360);

        a.setType(ArcType.ROUND);
        a.setOnMousePressed(e->{
            if (a.getLength() == 360)
                a.setLength(180);
            else
                a.setLength(360);

        });
        Pane p = new Pane(a);

        Scene s = new Scene(p);
        primaryStage.setScene(s);
        primaryStage.setTitle(" CircleHalf");
        primaryStage.show();

    }
}
