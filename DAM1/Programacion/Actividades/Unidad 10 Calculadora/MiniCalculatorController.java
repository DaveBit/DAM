/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author David
 */
public class MiniCalculatorController implements Initializable {
    double num1 = 0.0d;
    double num2 = 0.0d;
    int operation = -1;
    double result;
    double cambio;
    int plusclick, minusclick, multiclick, divclick, decimalclick;
    
    @FXML
    private TextField display;
    
    @FXML
    private Button seven;

    @FXML
    private Button eight;

    @FXML
    private Button nine;

    @FXML
    private Button plus;

    @FXML
    private Button four;

    @FXML
    private Button five;

    @FXML
    private Button six;

    @FXML
    private Button minus;

    @FXML
    private Button one;

    @FXML
    private Button three;

    @FXML
    private Button two;

    @FXML
    private Button multiplication;

    @FXML
    private Button zero;

    @FXML
    private Button equal;

    @FXML
    private Button clear;

    @FXML
    private Button division;
    
    @FXML
    private Button inverter;
    
    @FXML
    private Button dot;
    
    

    @FXML
    void handleButtonAction(ActionEvent event) {
           if(event.getSource() == one)
           {
               display.setText(display.getText() + one.getText());
           }
           else if(event.getSource()== two)
           {
               display.setText(display.getText() + two.getText());
           }
           else if(event.getSource()== three)
           {
               display.setText(display.getText() + three.getText());
           }
           else if(event.getSource()== four)
           {
               display.setText(display.getText() + four.getText());
           }
           else if(event.getSource()== five)
           {
               display.setText(display.getText() + five.getText());
           }
           else if(event.getSource()== six)
           {
               display.setText(display.getText() + six.getText());
           }
           else if(event.getSource()== seven)
           {
               display.setText(display.getText() + seven.getText());
           }
           else if(event.getSource()== eight)
           {
               display.setText(display.getText() + eight.getText());
           }
           else if(event.getSource()== nine)
           {
               display.setText(display.getText() + nine.getText());
           }
           else if(event.getSource()== zero)
           {
               display.setText(display.getText() + zero.getText());
           }
           else if(event.getSource()== dot)
           {
               if(decimalclick==0)
               {
               display.setText(display.getText() + dot.getText());
               decimalclick = 1;
               }
               
           }
           else if(event.getSource()== clear)
           {
               display.setText("");
               decimalclick = 0;
           }
           else if(event.getSource()== inverter)
           {
               cambio = Double.parseDouble(String.valueOf(display.getText()));
               cambio = cambio * (-1);
               display.setText(String.valueOf(cambio));
           }
           else if(event.getSource()== plus)
           {
               num1 =Double.parseDouble(String.valueOf(display.getText()));
               plusclick = 1; //Addition operation
               display.setText("");
               decimalclick = 0;
           
           }
           else if(event.getSource()== minus)
           {
               num1 = Double.parseDouble (String.valueOf(display.getText()));
               minusclick = 1; //substraction operation
               display.setText(""); 
               decimalclick = 0;
           }
           else if(event.getSource()== multiplication)
           {
               num1 =Double.parseDouble(String.valueOf(display.getText()));
               multiclick = 1; //Multiplication operation
               display.setText("");
               decimalclick = 0;
           }
           else if(event.getSource()== division)
           {
               num1 = Double.parseDouble(String.valueOf(display.getText()));
               divclick = 1; //division operation
               display.setText("");
               decimalclick = 0;
           }
           else if(event.getSource()== equal)
           {
               //data =Integer.parseInt(display.getText());
               
               num2 = Double.parseDouble(String.valueOf(display.getText()));
               if(plusclick>0)
               {
                   result = num1 + num2;
                   Math.round(result);
                   display.setText(String.valueOf(result));
                   plusclick = 0;
                   num1 = 0;
                   num2 = 0;
               }
               if(minusclick>0)
               {
                   result = num1 - num2;
                   display.setText(String.valueOf(result));
                   minusclick = 0;
                   num1 = 0;
                   num2 = 0;
               }
              if(multiclick>0)
               {
                   result = num1 * num2;
                   display.setText(String.valueOf(result));
                   multiclick = 0;
                   num1 = 0;
                   num2 = 0;
               }
              if(divclick>0)
               {
                   result = num1 / num2;
                   display.setText(String.valueOf(result));
                   divclick = 0;
                   num1 = 0;
                   num2 = 0;
               }
            }
               
              
           
           
           
           
           
    }
     
    /**
     * Initializes  the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
