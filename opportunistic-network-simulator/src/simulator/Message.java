package simulator;

public class Message {

    int id;
    int source;
    int destination;
    int creationTime;

    boolean delivered = false;

    public Message(int id, int source, int destination, int creationTime){

        this.id = id;
        this.source = source;
        this.destination = destination;
        this.creationTime = creationTime;
    }
}
