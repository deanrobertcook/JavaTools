package org.theronin.javatools.neuralnetworks;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.junit.Test;
import org.theronin.javatools.neuralnetworks.Perceptron.FunctionTrainer;
import org.theronin.javatools.testutility.JavaFXRunner;
import org.theronin.javatools.testutility.TestMethods;
import org.theronin.javatools.utility.Util;

public class PerceptronTest extends TestMethods {

    @Test
    public void perceptronPlayground() throws InterruptedException {
        Perceptron perceptron = new Perceptron(3);

        int numTrainingPoints = 200;
        int numDataPoints = 1000;

        float minXY = -10f;
        float maxXY = 10f;

        float[][] points = randomCartesianCoordinates(numDataPoints, minXY, maxXY);
        float bias = 1f;

        int[] results = new int[points.length];

        FunctionTrainer trainer = new FunctionTrainer(numTrainingPoints, minXY, maxXY);
        trainer.trainPerceptron(perceptron);

        Util.printArray(perceptron.getWeights());


        for (int i = 0; i < points.length; i++) {
            float[] input = new float[points[i].length + 1];
            for (int j = 0; j < points[i].length; j++) {
                input[j] = points[i][j];
            }
            input[input.length - 1] = bias;
            results[i] = perceptron.feedForward(input);
        }

        Application application = new Application() {
            @Override
            public void start(Stage primaryStage) throws Exception {
                NumberAxis xAxis = new NumberAxis("x", -10, 10, 1);
                NumberAxis yAxis = new NumberAxis("y", -10, 10, 1);
                ScatterChart<Number, Number> chart = new ScatterChart<Number, Number>(xAxis, yAxis);

                Series<Number, Number> series = new Series<>();
                series.setName("Randomly plotted points");
                for (int i = 0; i < points.length; i++) {
                    Data<Number, Number> dataPoint = new Data<>(points[i][0], points[i][1]);
                    Label label = new Label("" + results[i]);
                    label.setFont(new Font(10));
                    if (results[i] > 0) {
                        label.setStyle("-fx-background-color: blue;");
                    } else {
                        label.setStyle("-fx-background-color: red;");
                    }
                    label.setPadding(new Insets(2, 4, 2, 4));
                    dataPoint.setNode(label);

                    series.getData().add(dataPoint);
                }

                chart.getData().add(series);


                primaryStage.setScene(new Scene(chart, 1000, 1000));
                primaryStage.show();
            }
        };

        new JavaFXRunner(application).showGraph();
    }
}