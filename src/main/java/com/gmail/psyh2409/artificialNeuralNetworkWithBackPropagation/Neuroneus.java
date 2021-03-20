package com.gmail.psyh2409.artificialNeuralNetworkWithBackPropagation;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class Neuroneus implements Passer {

    private List<Double> ins; // TODO Map
    private double sum;
    private double backSum; // delta reActivate
    private double notBadTwice_NotU; // local delta = father's delta * accordance synapse's justice(weight)
    private double out;
    private List<Synapse> outs; // ? TODO Map ?

    public Neuroneus() {
        ins = new ArrayList<>();
        outs = new ArrayList<>();
    }

    private double summer(List<Double> ins) {
        sum = ins.stream().reduce(0.0, (a, b) -> a + b);
        return sum;
    }

    private double activationSigmoid(double in) {
        double flatness = 1;
        out = 1 / (1 + Math.pow(Math.E, (in * (-1 * flatness))));
        return out;
    }

    private double reSigmoid(double out) {
        backSum = out*(1-out);
        return backSum;
    }

    //private

    public double forwardLifeCircle() {
        return activationSigmoid(summer(ins));

    }

    @Override
    public double backwardLifeCircle() {
        return 0;
    }
}
