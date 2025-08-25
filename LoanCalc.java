package application;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class LoanCalc extends Application{
	public void start(Stage primaryStage) {
		
	// gridpane initialized and modified
	GridPane root = new GridPane();
	
	root.setStyle("-fx-background-color:LightGrey; -fx-border-color:Purple; -fx-paneborder-width:25"); 	
	
	
	// makes the sections easier to differentiate

	
	//formatting for my rows & columns
	ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(50);  
    
  //textfields vars with diff names to differentiate them
  	TextField investAmount1 = new TextField();
  	TextField numYears1 = new TextField();
  	TextField annualRate1 = new TextField();
  	
  	TextField [] userInput = {investAmount1,numYears1,annualRate1};
  	// label that will print the future value of the investment
  	Label futureValue1 = new Label(" ");
  	
  	Button submit = new Button("Submit");
     
    //for loops initializing the spacing for the rows and columns
    
    for(int i = 0; i < 6; i++) {// will equally divide the rows into 6
    	RowConstraints row = new RowConstraints();
    	row.setPercentHeight(100.0/6);
    	root.getRowConstraints().add(row);
    }
    
    for(int i = 0; i <2; i++) {// equally divind the columns into 2
    	ColumnConstraints col = new ColumnConstraints();
    	col.setPercentWidth(100.0/2);
    	root.getColumnConstraints().add(col);
    	
    }
    
    // labels that go on the left side of grid showing what each input is
    Label investAmount = new Label("Invest Amount");
    Label numYears = new Label("Number of Years");
    Label interestRate = new Label("Annual Interest Rate");
    Label futureValue = new Label("Future Amount");
    
    //puts labels into array 
    Label [] labels = {investAmount,numYears,interestRate,futureValue};
    
    
    for(int i = 0; i<4; i++) {
    	root.add(labels[i],0,1+ i);
    	
    }
    
    for(int i = 0;i<3; i++){// adds my text fields to the right side
    	root.add(userInput[i], 1, 1+ i);
    }
    
    root.add(futureValue1, 1, 4);
    root.add(submit, 1, 5);
    
    submit.setOnAction(e -> {
        try {
            double inAmount = Double.parseDouble(investAmount1.getText());
            int years = Integer.parseInt(numYears1.getText());
            double interest = Double.parseDouble(annualRate1.getText());

            double monthlyRate = interest / 12 / 100;

            double future = inAmount * Math.pow(1 + monthlyRate, years * 12);

            futureValue1.setText(String.format("%.2f", future));

        } catch (NumberFormatException ex) {
            futureValue1.setText("Please only enter numbers");
        }
    });

    
    
	
	
	Scene scene = new Scene(root, 400, 300);
    primaryStage.setTitle("Loan Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();

	}
	
	



public static void main(String [] args) {
	Application.launch(args);
	}
}