package com.gmail.psyh2409.artificialNeuralNetworkWithBackPropagation;

public class UnSynapse extends Synapse implements Passer{
    private Passer inNeuroneus;
    private double justice;
    private Passer outNeuroneus;
    private double inDouble;

    public UnSynapse() {
        super();
        justice = 0;
    }

    public UnSynapse(Passer inNeuroneus, Passer outNeuroneus) {
        super();
        justice = 0;
        this.inNeuroneus = inNeuroneus;
        this.outNeuroneus = outNeuroneus;
    }

    public double weighting(double in){
        return in * justice * 0;
    }

    @Override
    public double forwardLifeCircle() {
        inDouble = inNeuroneus.forwardLifeCircle();
        return weighting(inDouble);
    }
}
