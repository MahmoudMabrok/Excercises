import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FanSpin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vPane  = new VBox();
        vPane.setPadding(new Insets(20));
        vPane.setSpacing(18);
        vPane.setAlignment(Pos.CENTER);

        fanPane f = new fanPane(100 , 100 , 60 ) ;

        HBox   hBu = new HBox(25) ;
        Button bPause = new Button("Pause") ;
        Button bResume = new Button("Resume") ;
        Button bReverse = new Button("Reverse") ;

        HBox hrate = new HBox(15) ;
        hrate.setAlignment(Pos.CENTER);
        Button bUp = new Button("UP") ;
        Button bDo = new Button("DOWN") ;
        hrate.getChildren().addAll(bUp , bDo);


         EventHandler<ActionEvent> handler = e->{
            f.updateStart();
        };

        Timeline t = new Timeline(new KeyFrame(javafx.util.Duration.millis(100),handler ))   ;
        t.setCycleCount(Timeline.INDEFINITE);
        t.setRate(5);
        t.play();
        Label lRate = new Label(( ""+(int)t.getRate())) ;

        bPause.setOnAction(e->{
            t.pause();
        });
        bResume.setOnAction(e->{
            t.play();
        });
        bReverse.setOnAction(e->{
            t.pause();
            f.r *= -1 ;
            t.play();
        });
        bUp.setOnAction(e->{
            if(t.getStatus() != Animation.Status.PAUSED){
            t.setRate( t.getRate() >= 0 ? t.getRate() + 2 :0 );
            lRate.setText("" +(int)t.getRate());}
        });
        bDo.setOnAction(e->{
            if(t.getStatus() != Animation.Status.PAUSED) {
                t.setRate(t.getRate() <= 1 ? 0 : t.getRate() - 2);
                lRate.setText("" + (int) t.getRate());
            }
        });

        hBu.getChildren().addAll(bPause , bResume,bReverse) ;

        vPane.getChildren().addAll( lRate,f , hBu ,hrate) ;

        Scene s =new Scene( vPane) ;
        primaryStage.setResizable(false);
        primaryStage.setScene(s);
        primaryStage.setTitle("");
        primaryStage.show();

    }
}
class fanPane extends Pane {
    Arc a, b, c;
    int r =1 ;
    int length = 65;
    int s1 = 720, s2 = 120, s3 = 240;

    public fanPane(int x, int y, int rad) {

        Circle cir = new Circle(x, y, rad);
        cir.setFill(Color.WHITE);
        cir.setStroke(Color.BLACK);
        a = new Arc(x, y, rad - 10, rad - 10, s1, length);
        a.setType(ArcType.ROUND);

        b = new Arc(x, y, rad - 10, rad - 10, s2, length);
        b.setType(ArcType.ROUND);

        c = new Arc(x, y, rad - 10, rad - 10, s3, length);
        c.setType(ArcType.ROUND);
        getChildren().addAll(cir, a, b, c);
    }

    public void updateStart()
    {
        if(r  >-1)

        {

            a.setStartAngle(a.getStartAngle() + 5);
            b.setStartAngle(b.getStartAngle() + 5);
            c.setStartAngle(c.getStartAngle() + 5);

        }
        else
        {
            a.setStartAngle(a.getStartAngle() - 5);
            b.setStartAngle(b.getStartAngle() - 5);
            c.setStartAngle(c.getStartAngle() - 5);

        }
    }




   }



