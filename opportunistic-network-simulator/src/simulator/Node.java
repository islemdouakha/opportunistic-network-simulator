package simulator;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int id;
    double x;
    double y;

    List<Message> buffer = new ArrayList<>();

    public Node(int id,double x,double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public void move() {

        double dx = (Math.random() - 0.5) * 10;
        double dy = (Math.random() - 0.5) * 10;

        x += dx;
        y += dy;
    }
}
