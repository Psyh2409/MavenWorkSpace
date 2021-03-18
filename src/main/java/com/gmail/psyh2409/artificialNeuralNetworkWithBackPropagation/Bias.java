package com.gmail.psyh2409.artificialNeuralNetworkWithBackPropagation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Bias implements Passer{
    private static final int out = 1;

    @Override
    public double forwardLifeCircle() {
        return 0;
    }
}
