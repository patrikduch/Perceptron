//---------------------------------------------------------------------------------
// <copyright file="Perceptron.java" website="Patrikduch.com">
//     Copyright 2019 (c) Patrikduch.com
// </copyright>
// <author>Patrik Duch</author>
//--------------------------------------------------------------------------------
package com.patrikduch.neuro.perceptron.helpers.perceptron;

/**
 *  Perceptron model representation
 */
public class Perceptron {
    /**
     * Weights representation
     */
    private float [] weights;

    /**
     * Inputs representation
     */
    private float [][] input;

    /**
     * Output representation
     */
    private float [] output;

    /**
     * Weight count
     */
    private int numOfWeights;

    /**
     * Error storage
     */
    private StringBuilder statuStringBuilder;
    String newLine = System.getProperty("line.separator");

    public Perceptron() {
        // Initialization of error storage
        this.statuStringBuilder = new StringBuilder();
    }

    public Perceptron(float[][] input, float[] output) {

        this.input = input;
        this.output = output;
        this.numOfWeights = input[0].length; // First row of tested data
        this.weights = new float[numOfWeights];

        /// Initialization of error storage
        this.statuStringBuilder = new StringBuilder();
    }

    /**
     *  Weight initialization
     */
    public void initializatiWeight() {

        for(int i = 0; i< numOfWeights; ++i) {
            weights[i] = 0;
        }
    }

    /**
     * Train algorithm
     * @param learningRate coefficient of learning
     * @param epochs number of iterations
     */
    public void train(float  learningRate, int epochs) {

        // Prediction that at the starting point is 100% error
        float totalError = 1;

        int counter = 0;

        while(totalError > 0) {

            if(counter> epochs) {

                this.statuStringBuilder.append("One layer network cannot resolve this task.");
                return;
            }

            totalError = 0;

            for(int i =0; i< output.length; i++) {

                float calculatedOutput = calculateOutput(input[i]);
                float error = Math.abs(output[i] - calculatedOutput); // Rozdil mezi aktualnim  a trenovacimi datz

                totalError += error;

                for(int j =0; j<numOfWeights; j++) {
                    this.statuStringBuilder.append("Weight update: "+weights[j]);
                    weights[j] = weights[j] + learningRate * input[i][j] * error;
                    this.statuStringBuilder.append("-->: "+weights[j]);
                    this.statuStringBuilder.append(newLine);
                }
            }

            if(totalError!= 0) {

            }
            this.statuStringBuilder.append("Learning process is not complete. Error state is: " + totalError);
            this.statuStringBuilder.append(newLine);


            counter++;

        }

        this.statuStringBuilder.append("Network learning is complete.");
        this.statuStringBuilder.append(newLine);
    }

    /** Calculate output with SUM function and inner potential
     * @param input value for input
     * @return result of sum a inner potential
     */
    public float calculateOutput(float[] input) {

        float sum = 0f;

        for(int i = 0; i< input.length; ++i) {

            sum = sum + weights[i] * input[i];
        }

        return ActivationFunction.stepFunction(sum);
    }

    /** Getter for input value
     * @return current input value
     */
    public float[][] getInput() {
        return input;
    }

    /**
     *  new value that will be assigned to input property
     * @param input
     */
    public void setInput(float[][] input) {
        this.input = input;
    }

    /** Getter for output
     * @return current output value
     */
    public float[] getOutput() {
        return output;
    }

    /** Setter for output
     * @param output new value that will be assigned to output property
     */
    public void setOutput(float[] output) {
        this.output = output;
    }


    /**
     *  Get status info
     * @return comple status string representation
     */
    public StringBuilder getStatuStringBuilder() {
        return statuStringBuilder;
    }
}
