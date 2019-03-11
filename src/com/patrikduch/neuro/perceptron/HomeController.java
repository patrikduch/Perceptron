//---------------------------------------------------------------------------------
// <copyright file="HomeController.java" website="Patrikduch.com">
//     Copyright 2019 (c) Patrikduch.com
// </copyright>
// <author>Patrik Duch</author>
//--------------------------------------------------------------------------------

package com.patrikduch.neuro.perceptron;
import com.patrikduch.neuro.perceptron.helpers.perceptron.Perceptron;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import java.util.Arrays;


/**
 * Controller for introduction view
 */
public class HomeController {

    /**
     * Area where results will be injected Information about type of logic gate
     */
    @FXML
    TextArea resultArea;

    /**
     * Information about type of logic gate
     */
    @FXML
    Text resultText, infoResultText;

    /**
     * Reference to the FXML layout
     */
    @FXML
    BorderPane mainLayout;

    @FXML
    Button outputBtnFour, outputBtnTwo, outputBtnThree, outputBtnOne;
    String newLine = System.getProperty("line.separator");

    /**
     * Perceptron algorithm
     */
    Perceptron perceptron;

    /** Initialization of boolean value for input and output
     * @param event event listener to target selected button
     */
    public void onButtonClicked(ActionEvent event) {

        Button button = (Button) event.getSource();

        if (button.getText().equals("1")) {
            button.setText("0");
        } else {
            button.setText("1");
        }
    }


    /** Get type of gate
     * @param input  sequence of numbers
     * @return string representation of logic gate
     */
    private String getGate(float[] input) {

        if (Arrays.equals(input, new float[]{0, 1, 1, 1})) {

            return "OR";
        }

        if (Arrays.equals(input, new float[]{0, 0, 0, 1})) {

            return "AND";
        }

        return "N/A";
    }


    /**
     *  Reset functionality
     */
    public void onRemovalButtonClicked() {

        outputBtnOne.setText("0");
        outputBtnTwo.setText("0");
        outputBtnThree.setText("0");
        outputBtnFour.setText("0");

        resultArea.setText("");
        resultText.setText("");
    }

    /** Event for button click
     * @param event Event listener
     */
    public void onSubmitClicked(ActionEvent event) {


        float[] output = {
                Integer.parseInt(outputBtnOne.getText()),
                Integer.parseInt(outputBtnTwo.getText()),
                Integer.parseInt(outputBtnThree.getText()),
                Integer.parseInt(outputBtnFour.getText()),
        };

        float[][] input = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

        // Perceptron call
        Perceptron perceptron = new Perceptron(input, output);
        perceptron.initializatiWeight();
        perceptron.train(0.1f, 2000);

        resultArea.setText(perceptron.getStatuStringBuilder().toString());


        float[] result = perceptron.getOutput();

        int counter = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(newLine);
        sb.append(newLine);
        sb.append(newLine);
        sb.append(newLine);
        for (float i : result) {

            sb.append(counter + ") " + i);
            sb.append(newLine);

            counter++;

        }
        this.resultText.setText(sb.toString() + newLine + "Gate: " + getGate(result));
    }
}
