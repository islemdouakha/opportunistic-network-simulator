package simulator;

public class Main {

     static void main(String[] args){

        Simulator sim = new Simulator(30);

        for (int i = 0; i < 1000; i++){

            sim.step();

        }
        System.out.println("Simulation finished");
    }
}
