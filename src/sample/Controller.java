package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.lexer.Lexer;
import sample.lexer.LexicalException;
import sample.lexer.Token;

import java.awt.*;
import java.util.ResourceBundle;
import java.net.URL;

public class Controller implements Initializable {
    int length=0;
    @FXML
    private Pane mainContainer;
    @FXML
    private GridPane gridPane;
    @FXML
    private JFXButton num0;
    @FXML
    private JFXButton num1;
    @FXML
    private JFXButton num2;
    @FXML
    private JFXButton num3;
    @FXML
    private JFXButton num4;
    @FXML
    private JFXButton num5;
    @FXML
    private JFXButton num6;
    @FXML
    private JFXButton num7;
    @FXML
    private JFXButton num8;
    @FXML
    private JFXButton num9;
    @FXML
    private JFXButton btnMinus;
    @FXML
    private JFXButton btnEqual;
    @FXML
    private JFXButton btnClear;
    @FXML
    private JFXButton btnLeftBrac;
    @FXML
    private JFXButton btnRightBrac;
    @FXML
    private JFXButton btnSqrt;
    @FXML
    private JFXButton btnPlus;
    @FXML
    private JFXButton btnDivide;
    @FXML
    private JFXButton btnMultiply;
    @FXML
    private JFXButton btnDot;
    @FXML
    private JFXTextField mainText;
    @FXML
    private JFXTextField resultText;

    private StringBuilder currentExpression;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        gridPane.prefWidthProperty().bind(mainContainer.widthProperty());

        mainText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(mainText.getText().length()>=18) {
                    mainText.setFont(new Font("Arial Bold", 15.0));
                }
            }
        });

        /*mainText.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //System.out.println(KeyCode.DIGIT1);
                String s = event.getCharacter();
                System.out.println(s);
            }
        });*/

    }

    @FXML
    private void onNum0Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "0");
            length++;
        }
    }

    @FXML
    private void onNum1Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "1");
            length++;
        }
    }

    @FXML
    private void onNum2Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "2");
            length++;
        }
    }

    @FXML
    private void onNum3Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "3");
            length++;
        }
    }

    @FXML
    private void onNum4Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "4");
            length++;
        }
    }

    @FXML
    private void onNum5Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "5");
            length++;
        }
    }

    @FXML
    private void onNum6Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "6");
            length++;
        }
    }

    @FXML
    private void onNum7Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "7");
            length++;
        }
    }

    @FXML
    private void onNum8Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "8");
            length++;
        }
    }

    @FXML
    private void onNum9Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "9");
            length++;
        }
    }

    @FXML
    private void onBtnDotClicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + ".");
            length++;
        }
    }

    @FXML
    private void onBtnDivideClicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "/");
            length++;
        }
    }

    @FXML
    private void onBtnPlusClicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "+");
            length++;
        }
    }

    @FXML
    private void onBtnMinusClicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "-");
            length++;
        }
    }

    @FXML
    private void onBtnMultiplyClicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "*");
            length++;
        }
    }

    @FXML
    private void onBtnLeftBracClicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "(");
            length++;
        }
    }

    @FXML
    private void onBtnRightBracClicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + ")");
            length++;
        }
    }

    @FXML
    private void onBtnEqualClicked(ActionEvent event){
        double result=0;

        resultText.setText(result+"");

    }

    @FXML
    private void onBtnDeleteClicked(ActionEvent event){
        if(mainText.getText().length() != 0){
            mainText.setText(mainText.getText().substring(0, mainText.getText().length() - 1));
            length--;
        }
    }

    @FXML
    private void onBtnClearClicked(ActionEvent event){
        mainText.setText("");
        length=0;
    }

    @FXML
    private void onKeyPressed(KeyEvent event){
        if(event.getCode()==KeyCode.DIGIT0){onNum0Clicked(new ActionEvent());}
    }


    private boolean isExpressionLegal(){
        /*if(mainText.getText().length() != 0){
            Lexer l = new Lexer(mainText.getText());
            try {
                for(Token t : l.getTokens()){
                    System.out.println(t);
                }
            }
            catch(LexicalException e){
                return false;
            }
        }*/
        return true;
    }



}
