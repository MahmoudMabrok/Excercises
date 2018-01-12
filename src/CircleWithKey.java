import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import  javafx.application.Application ;
import javafx.geometry.Insets;
import  javafx.stage.Stage ;
import javafx.scene.Scene ;
import javafx.scene.layout.Pane ;
import javafx.scene.shape.Circle ;
import javafx.util.Duration;


public class CircleWithKey  extends Application  {

    @Override
    public void start (Stage stage ){

        Circle cr = new Circle(25) ;
        Pane root = new Pane(cr); //create Pane and add Circle to it

        //palce circle at(200 , 200 )
        cr.setLayoutX(200);
        cr.setLayoutY(200);

        cr.setOnKeyPressed(e->{
            double x = cr.getCenterX();
            double y = cr.getCenterY();
            switch (e.getCode()){

                case  UP:
                    cr.setCenterY(y - 15);
                    break;
                case  DOWN :
                    cr.setCenterY(y + 15);
                    break;
                case RIGHT:
                    cr.setCenterX(x + 15);
                    break;
                case  LEFT:
                    cr.setCenterX(x - 15);
                    break;
            }

        });

        Timeline tl = new Timeline() ;
        KeyFrame kx = new   KeyFrame(Duration.seconds(1) ,
                e->cr.setCenterX(cr.getCenterX() + 10 )) ;
        KeyFrame ky = new   KeyFrame(Duration.seconds(1) ,
                e->cr.setCenterY(cr.getCenterY() + 10 )) ;

        tl.getKeyFrames().addAll(kx ,ky) ;
        tl.setCycleCount(4);
        tl.play();


        Scene sc = new Scene(root ,400,400 ) ;
        stage.setScene(sc);
        stage.setTitle("MoveCircleWithKey");
        stage.show();

        cr.requestFocus(); //must invoked after stage.show()  to request foucus
                           //from keyboard

    }
}
