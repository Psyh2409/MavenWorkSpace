package com.gmail.psyh2409.artificialNeuralNetworkWithBackPropagation;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Bias extends Neuroneus {
    private final double out = 1;

    @Override
    public double forwardLifeCircle() {
        return 1;
    }
}
