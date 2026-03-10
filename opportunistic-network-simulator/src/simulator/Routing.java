package simulator;

public class Routing {

    public static void exchange(Node a, Node b) {
        for(Message m : a.buffer){
            boolean exists = b.buffer.stream().anyMatch(x -> x.id == m.id);

            if(!exists){
                b.buffer.add(m);
                System.out.println("Message " + m.id + " transferred from " + a.id + " to " + b.id);
            }
        }

        for(Message m : b.buffer){
            boolean exists = b.buffer.stream().anyMatch(x -> x.id == m.id);

            if(!exists){
                a.buffer.add(m);
                System.out.println("Message " + m.id + " transferred from " + a.id + " to " + b.id);
            }
        }
    }
}
