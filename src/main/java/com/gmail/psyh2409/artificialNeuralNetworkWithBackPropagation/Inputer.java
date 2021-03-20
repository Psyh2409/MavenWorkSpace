package com.gmail.psyh2409.artificialNeuralNetworkWithBackPropagation;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Inputer extends Synapse{
    private double in;

    @Override
    public double forwardLifeCircle() {
        return in;
    }

    @Override
    public double backwardLifeCircle() {
        return 0;
    }
}
