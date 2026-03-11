package simulator;

import java.util.ArrayList;
import java.util.List;


public class Simulator {
    List<Node> nodes = new ArrayList<>();

    List<Message> messages = new ArrayList<>();




    int deliveredMessages = 0;

    int totalLatency = 0;

    int transmissions = 0;

    int time = 0;

    int COMM_RANGE = 20;

    int numberOfMessages = 10;

    int totalMessages = numberOfMessages;

    public Simulator(int n) {
        for (int i = 0; i < n; i++) {

            nodes.add(new Node(i, Math.random() * 100,Math.random() * 100));

        }



        for(int i=0; i < numberOfMessages;i++){
            int source = (int) (Math.random() * nodes.size());
            int destination = (int) (Math.random() * nodes.size());

            while(destination == source){
                destination = (int) (Math.random() * nodes.size());
            }

            Message m = new Message(i, source, destination, 0);

            messages.add(m);

            nodes.get(source).buffer.add(m);
        }

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

                    Routing.exchange(a,b,this);
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

        for (Message message : messages) {


            Node destination = nodes.get(message.destination);


            boolean hasMessage = destination.buffer.stream().allMatch(m -> m.id == message.id);

            if (hasMessage && !message.delivered) {
                message.delivered = true;

                deliveredMessages++;

                System.out.println("Message delivered at time :" + time);

                int latency = time - message.creationTime;

                totalLatency += latency;

                System.out.println("latency :" + latency);
            }
        }
    }
}
