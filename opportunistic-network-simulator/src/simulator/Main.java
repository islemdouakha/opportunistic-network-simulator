package simulator;

import javafx.application.Application;

public class Main {

     static void main(String[] args){



        Simulator sim = new Simulator(30);

        Visualizer.simulator = sim;

        Application.launch(Visualizer.class);
        for (int i = 0; i < 1000; i++){

            sim.step();

        }
        System.out.println("Simulation finished");
         double deliveryRatio = (double) sim.deliveredMessages / sim.totalMessages;

         double avgLatency = sim.deliveredMessages > 0 ? (double) sim.totalLatency / sim.deliveredMessages : 0;

         System.out.println("Delivery ratio: " + deliveryRatio);
         System.out.println("Average latency: " + avgLatency);
         System.out.println("Delivery ratio: " + deliveryRatio);
         System.out.println("Delivered messages: " + sim.deliveredMessages);
         System.out.println("transmissions :"+ sim.transmissions);
     }
}
