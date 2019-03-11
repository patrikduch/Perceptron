//---------------------------------------------------------------------------------
// <copyright file="ActivationFunction.java" website="Patrikduch.com">
//     Copyright 2019 (c) Patrikduch.com
// </copyright>
// <author>Patrik Duch</author>
//--------------------------------------------------------------------------------

package com.patrikduch.neuro.perceptron.helpers.perceptron;

/**
 * Activation function for Perceptron model
 */
public class ActivationFunction {

    /**
     * As activation function is used step function
     * @param activation
     * @return activation status
     */
    public static int stepFunction(float activation) {

        int threshold = 1; //  Threshold for neuron activation

        if(activation >= threshold) {

            return 1; // Neuron activation
        }

        return 0; // Neuron is not activated
    }
}
