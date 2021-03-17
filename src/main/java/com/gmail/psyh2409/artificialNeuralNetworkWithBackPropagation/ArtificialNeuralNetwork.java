package com.gmail.psyh2409.artificialNeuralNetworkWithBackPropagation;

import java.util.ArrayList;
import java.util.List;

public class ArtificialNeuralNetwork {
    private final static int ins = 107*72;
    private final static int hiddenLayer = 10;
    private final static int hLCount = 5;
    private final static int outs = 10;


    public static void main(String[] args) {

        Neuroneus[][] nLayer = new Neuroneus[hLCount + 2][];
        for (int i = 0; i < hLCount + 2; i++) {
            int capacity = ins;
            if (i > 0) capacity = hiddenLayer;
            if (i == hLCount + 1) capacity = outs;
            nLayer[i] = new Neuroneus[capacity];
            for (int j = 0; j < capacity; j++) {
                nLayer[i][j] = new Neuroneus();
            }
        }

        Synapse[][] wLayer = new Synapse[nLayer.length - 1][];
        for (int i = 0; i < nLayer.length - 1; i++) {
            int capacity = nLayer[i].length * nLayer[i + 1].length;
            wLayer[i] = new Synapse[capacity];
            int w = 0;
            for (Neuroneus before : nLayer[i]) {
                for (Neuroneus after : nLayer[i + 1]) {
                    wLayer[i][w] = new Synapse(before, after);
                    wLayer[i][w].setOutNeuroneus(after);
                    before.getOuts().add(wLayer[i][w]);
                    w++;
                }
            }
        }

        System.out.println("=============================================================================================================================");

        for (int x = 9191; x < 9203; x++) {
            Neuroneus[] neuroneuses = nLayer[0];
            int[] temp = new int[neuroneuses.length];
            for (int z = neuroneuses.length-1, b = 0 ; z >= 0 && b < neuroneuses.length; z--, b++) {
                double d = (x-(x % (Math.pow(10, z))))/(Math.pow(10, z));
                temp[b] = (int) d;
                double v = d;
                System.out.printf(" %.0f \t",d);
            }
            System.out.println();
            for (int i = 0; i < wLayer.length; i++) {
                Synapse[] synapses = wLayer[i];
                for (int j = 0; j < synapses.length; j++) {
                    Synapse synaps = synapses[j];
                    synaps.forwardLifeCircle();
                    System.out.print("|" + String.format("%.2f", synaps.getInDouble()) + "*" + String.format("%.2f", synaps.getJustice()));
                }
                System.out.println();
            }
            System.out.print(x + " => ");
            int y = 0;
            for (Neuroneus n : nLayer[nLayer.length - 1]) {
                System.out.printf("\t" + ++y + ": %.2f \t", n.forwardLifeCircle());
            }
            System.out.println();
        }


    }
}




