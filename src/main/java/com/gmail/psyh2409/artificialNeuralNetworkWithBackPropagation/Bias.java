package com.gmail.psyh2409.artificialNeuralNetworkWithBackPropagation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class Bias extends Neuroneus implements Passer{
    private List<Double> ins;
    private double sum;
    private final double out = 1;
    private List<Synapse> outs;

    public Bias() {
        ins = new ArrayList<>();
        outs = new ArrayList<>();
    }

    private double summer(List<Double> ins) {
        sum = ins.stream().reduce(0.0, (a, b) -> a + b);
        return sum;
    }

    private double activationSigmoid(double in) {
        return out;
    }

    public double forwardLifeCircle() {
        return out;

    }
}
