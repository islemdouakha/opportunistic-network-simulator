package simulator;

public class Routing {

    public static void exchange(Node a, Node b, Simulator sim) {
        for(Message m : a.buffer){
            boolean exists = b.buffer.stream().anyMatch(x -> x.id == m.id);

            if(!exists){
                b.buffer.add(m);

                sim.transmissions++;

                System.out.println("Message " + m.id + " transferred from " + a.id + " to " + b.id);
            }
        }

        for(Message m : b.buffer){
            boolean exists = a.buffer.stream().anyMatch(x -> x.id == m.id);

            if(!exists){
                a.buffer.add(m);

                sim.transmissions++;

                System.out.println("Message " + m.id + " transferred from " + a.id + " to " + b.id);
            }
        }
    }
}
