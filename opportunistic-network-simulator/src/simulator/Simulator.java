package simulator;

import java.util.ArrayList;
import java.util.List;


public class Simulator {
    List<Node> nodes = new ArrayList<>();

    int time = 0;

    int COMM_RANGE = 20;

    Message message;

    public Simulator(int n) {
        for (int i = 0; i < n; i++) {

            nodes.add(new Node(i, Math.random() * 100,Math.random() * 100));

        }

        message = new Message(1,0,n-1,0);

        nodes.get(0).buffer.add(message);
    }

    public void step() {

        moveNodes();

        detectContacts();

        checkDelivery();

        time++;
    }

    private void moveNodes() {
        for(Node n : nodes){

            n.move();

        }
    }

    private void detectContacts() {

        for(int i=0; i < nodes.size(); i++){
            for(int j = i+1; j < nodes.size(); j++){
                Node a = nodes.get(i);
                Node b = nodes.get(j);

                double distance = distance(a,b);

                if (distance < COMM_RANGE){
                    System.out.println("Contact between " + a.id + " and " + b.id);
                    Routing.exchange(a,b);
                }

            }
        }
    }

    private double distance(Node a, Node b){

        return Math.sqrt(
                Math.pow(a.x - b.x, 2) +
                Math.pow(a.y - b.y, 2)
        );
    }

    private void checkDelivery() {

        Node destination = nodes.get(message.destination);

        boolean hasMessage = destination.buffer.stream().allMatch(m -> m.id == message.id);

        if(hasMessage && !message.delivered){
            message.delivered = true;

            System.out.println("Message delivered at time :"+ time);

            int latency = time - message.creationTime;

            System.out.println("latency :"+ latency);
        }
    }
}
