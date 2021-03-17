package com.gmail.psyh2409.artificialNeuralNetworkWithBackPropagation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@ToString
public class Neuroneus implements Passer {

    private List<Double> ins;
    private double sum;
    private double out;
    private List<Synapse> outs;

    public Neuroneus() {
        ins = new ArrayList<>();
        outs = new ArrayList<>();
    }

    private Double summer(List<Double> ins) {
        sum = ins.stream().reduce(0.0, (a, b) -> a + b);
        return sum;
    }

    private Double activationSigmoid(Double in) {
        double flatness = 1;
        out = 1 / (1 + Math.pow(Math.E, (in * (-1 * flatness))));
        return out;
    }

    public Double forwardLifeCircle() {
        return activationSigmoid(summer(ins));

    }
}
