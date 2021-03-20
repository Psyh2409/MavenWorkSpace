package com.gmail.psyh2409.artificialNeuralNetworkWithBackPropagation;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class Neuroneus implements Passer {

    private List<Synapse> ins; // TODO Map || List<Synapse> ? dreams : reality;
    private double sum;
    private double backSum; // delta reActivate
    private double notBadTwice_NotU; // local delta = father's delta * accordance synapse's justice(weight)
    private double out;
    private List<Synapse> outs; // ? TODO Map ?

    public Neuroneus() {
        ins = new ArrayList<>();
        outs = new ArrayList<>();
    }

    private double summer(List<Synapse> ins) {
//      sum = ins.stream().map(x -> x.getProduct()).reduce(0.0, (a, b) -> {return a + b;});
        sum = ins.stream().map(Synapse::getProduct).reduce(0.0, Double::sum);
        return sum;
    }

    private double activationSigmoid(double in) {
        double flatness = 1;
        out = 1 / (1 + Math.pow(Math.E, (in * (-1 * flatness))));
        return out;
    }

    private double reSigmoid(double out) {
        backSum = out * (1 - out);
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
