package simulator;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Visualizer extends Application {

    static Simulator simulator;

    List<Circle> nodeCircles = new ArrayList<>();

    @Override
    public void start(Stage stage) {

        Pane root = new Pane();

        for(Node node : simulator.nodes){

            Circle c = new Circle(node.x, node.y, 5);

            nodeCircles.add(c);

            root.getChildren().add(c);

        }

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {

                simulator.step();

                for(int i = 0; i < simulator.nodes.size(); i++) {

                    Node n = simulator.nodes.get(i);

                    Circle c = nodeCircles.get(i);

                    c.setCenterX(n.x);
                    c.setCenterY(n.y);

                }

            }
        };
        timer.start();

        Scene scene = new Scene(root, 600, 600);

        stage.setTitle("DTN Simulator");
        stage.setScene(scene);
        stage.show();

    }

}
