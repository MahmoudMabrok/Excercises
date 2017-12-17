import  javafx.application.Application ;
import javafx.geometry.Insets;
import  javafx.stage.Stage ;
import javafx.scene.Scene ;
import javafx.scene.layout.Pane ;
import javafx.scene.shape.Circle ;

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

        Scene sc = new Scene(root ,400,400 ) ;
        stage.setScene(sc);
        stage.setTitle("MoveCircleWithKey");
        stage.show();

        cr.requestFocus(); //must invoked after stage.show()  to request foucus
                           //from keyboard

    }
}
