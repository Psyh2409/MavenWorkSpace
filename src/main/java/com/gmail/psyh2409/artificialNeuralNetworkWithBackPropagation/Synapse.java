package com.gmail.psyh2409.artificialNeuralNetworkWithBackPropagation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class Synapse implements Passer{
    private Passer inNeuroneus;
    private double justice;
    private Passer outNeuroneus;
    private double inDouble;

    public Synapse() {
        super();
        do {
            justice = Math.random();
        }while (justice == 0);
    }

    public Synapse(Passer inNeuroneus, Passer outNeuroneus) {
        super();
        do {
            justice = Math.random();
        }while (justice == 0);
        this.inNeuroneus = inNeuroneus;
        this.outNeuroneus = outNeuroneus;
    }

    public Double weighting(Double in){
        return in * justice;
    }

    @Override
    public Double forwardLifeCircle() {
        inDouble = inNeuroneus.forwardLifeCircle();
        return weighting(inDouble);
    }
}
