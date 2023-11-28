package com.javamemorystack.javamemorystack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    private final Font headerFont = new Font(20);
    private final Font subHeaderFont = new Font(16);
    private final Insets defaultPadding = new Insets(15, 30, 30, 30);

    private final MemoryStackManager memoryStackManager = new MemoryStackManager(this);

    private ScrollPane functionScrollPane;

    private static boolean programRunning = false;
    private static TextArea exampleProgramOutput;
    static Button studentExampleButton;
    static Button fibonacciExampleButton;


    private VBox createTopLeft() {
        Label memoryHeader = new Label("Java Stack Memory");
        memoryHeader.setFont(headerFont);

        functionScrollPane = new ScrollPane(buildFunctions());
        functionScrollPane.fitToWidthProperty().set(true);
        functionScrollPane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
        functionScrollPane.setStyle("-fx-background-color:transparent;");
        functionScrollPane.setPadding(new Insets(5, 5, 5, 5));

        VBox topLeftVBox = new VBox(memoryHeader, functionScrollPane);
        topLeftVBox.setPadding(defaultPadding);
        topLeftVBox.setSpacing(5);

        return topLeftVBox;
    }

    private VBox createTopRight() {
        Label examplesHeader = new Label("Program Examples");
        examplesHeader.setFont(headerFont);

        studentExampleButton = new Button("Student Example");
        studentExampleButton.setOnAction((click) -> runProgram("student"));
        fibonacciExampleButton = new Button("Fibonacci Example");
        fibonacciExampleButton.setOnAction((click) -> runProgram("fibonacci"));

        VBox topRightVBox = new VBox(examplesHeader, studentExampleButton, fibonacciExampleButton);
        topRightVBox.setPadding(defaultPadding);
        topRightVBox.setSpacing(5);

        return topRightVBox;
    }

    private SplitPane createTop() {
        return new SplitPane(createTopLeft(), createTopRight());
    }

    private VBox createBottom() {
        // Creates the bottom container with the function log and the browser load checkbox
        Label bottomHeader = new Label("Example Program Output");
        bottomHeader.setFont(headerFont);

        exampleProgramOutput = new TextArea();

        VBox bottomVBox = new VBox(bottomHeader, exampleProgramOutput);
        bottomVBox.setPadding(defaultPadding);
        bottomVBox.setSpacing(5);
        return bottomVBox;
    }

    private VBox buildFunctions() {
        VBox functionVBox = new VBox();
        functionVBox.setSpacing(5);

        for (int i = 0; i < memoryStackManager.getSize(); i++) {
            FunctionCall function = memoryStackManager.getItemAtIndex(i);
            functionVBox.getChildren().add(createFunctionDisplay(function));
        }

        return functionVBox;
    }

    private VBox createFunctionDisplay(FunctionCall function) {
        Label titleLabel = new Label(function.getName());
        titleLabel.setFont(new Font(18));
        titleLabel.setTextFill(Color.web("#3D67CD"));

        VBox display = new VBox(titleLabel);
        display.setPrefWidth(400);
        display.setSpacing(5);
        display.setPadding(new Insets(15, 15, 15, 15));
        display.setStyle("-fx-background-color: #EEEEEE; -fx-border-style: solid inside; -fx-border-color: #E0E0E0; -fx-border-radius: 5;");

        if (function.getSize() != 0) {
            Label objectLabel = new Label("Objects:");
            objectLabel.setTextFill(Color.web("#3D67CD"));
            objectLabel.setFont(subHeaderFont);
            display.getChildren().add(objectLabel);
            for (int i = 0; i < function.getSize(); i++) {
                display.getChildren().add(new Label(function.getItemAtIndex(i)));
            }
        }

        return display;
    }

    public void refreshFunctionScrollPane() {
        functionScrollPane.setContent(buildFunctions());
    }

    public static void updateExampleProgramOutput(String text) {
        exampleProgramOutput.appendText("\n" + text);
    }

    public static void updateExampleButtons() {
        if (programRunning) {
            studentExampleButton.setDisable(false);
            fibonacciExampleButton.setDisable(false);
            programRunning = false;
        } else {
            studentExampleButton.setDisable(true);
            fibonacciExampleButton.setDisable(true);
            programRunning = true;
        }
    }

    public void runProgram(String program) {
        if (program.equals("student")) {
            memoryStackManager.clearMemory();
            exampleProgramOutput.setText("");
            StudentExample.main(memoryStackManager);
            updateExampleButtons();
        } else if (program.equals("fibonacci")) {
            memoryStackManager.clearMemory();
            exampleProgramOutput.setText("");
            FibonacciExample.main(memoryStackManager);
            updateExampleButtons();
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Scene Setup
        Scene scene = new Scene(new VBox(createTop(), createBottom()), 1400, 800);
        stage.setTitle("Java Stack Memory Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}