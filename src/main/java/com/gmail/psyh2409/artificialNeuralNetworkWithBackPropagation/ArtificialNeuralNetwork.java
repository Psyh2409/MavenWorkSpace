package com.gmail.psyh2409.artificialNeuralNetworkWithBackPropagation;

public class ArtificialNeuralNetwork {
    private final static int ins = 3;
    private final static int hiddenLayer = 4;
    private final static int hLCount = 3;
    private final static int outs = 1;

    private static int[] toDigitArrayWithFixedCapacity(int someNumber) {
        int log10 = someNumber == 0 ? 0 : (int) (Math.log10(someNumber));
        int[] result = new int[ins];
        for (int f = 0, e = result.length - 1; f < log10 + 1; f++, e--) {
            result[e] = someNumber % 10;
            someNumber = someNumber / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Neuroneus[][] nLayer = nInitializer();
        Synapse[][] wLayer = wInitializer(nLayer);
        lifeCircle(nLayer, wLayer, 123, 321);
    }

    public static void lifeCircle(Neuroneus[][] nLayer, Synapse[][] wLayer, int from, int to) {
        for (int x = from; x < to+1; x++) {
            Neuroneus[] neuroneuses = nLayer[0];
            int[] arrOfDigits = toDigitArrayWithFixedCapacity(x);
            for (int i = 0; i < neuroneuses.length; i++) {
                neuroneuses[i].getIns().add((double) arrOfDigits[i]);
                System.out.print(arrOfDigits[i] + "\t");
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

    public static Synapse[][] wInitializer(Neuroneus[][] nLayer) {
        Synapse[][] wLayer = new Synapse[nLayer.length - 1][];
        for (int i = 0; i < nLayer.length - 1; i++) {
            int capacity = nLayer[i].length * nLayer[i + 1].length;
            wLayer[i] = new Synapse[capacity];
            int w = 0;
            for (Neuroneus before : nLayer[i]) {
                for (Neuroneus after : nLayer[i + 1]) {
                    if (after instanceof Bias) {
                        wLayer[i][w] = new UnSynapse(before, after);
                    } else {
                        wLayer[i][w] = new Synapse(before, after);
                    }
                    wLayer[i][w].setOutNeuroneus(after);
                    before.getOuts().add(wLayer[i][w]);
                    w++;
                }
            }
        }
        return wLayer;
    }

    public static Neuroneus[][] nInitializer() {
        Neuroneus[][] nLayer = new Neuroneus[hLCount + 2][];
        for (int i = 0; i < hLCount + 2; i++) {// + ins and outs
            int capacity = ins;
            if (i > 0) capacity = hiddenLayer + 1; //+ bias
            if (i == hLCount + 1) capacity = outs;
            nLayer[i] = new Neuroneus[capacity];
            for (int j = 0; j < capacity; j++) {
                if (i != 0 && i != hLCount + 1 && j == 0) {
                    nLayer[i][j] = new Bias();
                } else {
                    nLayer[i][j] = new Neuroneus();
                }
            }
        }
        return nLayer;
    }
}




