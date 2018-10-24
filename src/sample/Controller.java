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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.calculation.Calculator;
import sample.lexer.Lexer;
import sample.lexer.LexicalException;
import sample.lexer.Token;
import sample.parser.Parser;
import sample.parser.SyntaxException;

import java.awt.*;
import java.util.List;
import java.util.ResourceBundle;
import java.net.URL;

public class Controller implements Initializable {
    //int length=0;
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

    ActionEvent e;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        gridPane.prefWidthProperty().bind(mainContainer.widthProperty());

        mainText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(mainText.getText().length()>=18) {
                    mainText.setFont(new Font("Arial Bold", 20.0));
                }
                else{
                    mainText.setFont(new Font("Arial Bold", 30.0));
                }
            }
        });

    }

    @FXML
    private void onNum0Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "0");
        }
    }

    @FXML
    private void onNum1Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "1");
        }
    }

    @FXML
    private void onNum2Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "2");
        }
    }

    @FXML
    private void onNum3Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "3");
        }
    }

    @FXML
    private void onNum4Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "4");
        }
    }

    @FXML
    private void onNum5Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "5");
        }
    }

    @FXML
    private void onNum6Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "6");
        }
    }

    @FXML
    private void onNum7Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "7");
        }
    }

    @FXML
    private void onNum8Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "8");
        }
    }

    @FXML
    private void onNum9Clicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "9");
        }
    }

    @FXML
    private void onBtnDotClicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + ".");
        }
    }

    @FXML
    private void onBtnDivideClicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "/");
        }
    }

    @FXML
    private void onBtnPlusClicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "+");
        }
    }

    @FXML
    private void onBtnMinusClicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "-");
        }
    }

    @FXML
    private void onBtnMultiplyClicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "*");
        }
    }

    @FXML
    private void onBtnLeftBracClicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + "(");
        }
    }

    @FXML
    private void onBtnRightBracClicked(ActionEvent event){
        if(isExpressionLegal()){
            mainText.setText(mainText.getText() + ")");
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
        }
    }

    @FXML
    private void onBtnClearClicked(ActionEvent event){
        mainText.setText("");
    }

    @FXML
    private void onKeyPressed(KeyEvent event){
        if(event.getCode()==KeyCode.DIGIT0||event.getCode()==KeyCode.NUMPAD0 ){onNum0Clicked(new ActionEvent());}
        if(event.getCode()==KeyCode.DIGIT1||event.getCode()==KeyCode.NUMPAD1){onNum1Clicked(e);}
        if(event.getCode()==KeyCode.DIGIT2||event.getCode()==KeyCode.NUMPAD2){onNum2Clicked(new ActionEvent());}
        if(event.getCode()==KeyCode.DIGIT3||event.getCode()==KeyCode.NUMPAD3){onNum3Clicked(new ActionEvent());}
        if(event.getCode()==KeyCode.DIGIT4||event.getCode()==KeyCode.NUMPAD4){onNum4Clicked(new ActionEvent());}
        if(event.getCode()==KeyCode.DIGIT5||event.getCode()==KeyCode.NUMPAD5){onNum5Clicked(new ActionEvent());}
        if(event.getCode()==KeyCode.DIGIT6||event.getCode()==KeyCode.NUMPAD6){onNum6Clicked(new ActionEvent());}
        if(event.getCode()==KeyCode.DIGIT7||event.getCode()==KeyCode.NUMPAD7){onNum7Clicked(new ActionEvent());}
        if(event.getCode()==KeyCode.DIGIT9||event.getCode()==KeyCode.NUMPAD9){onNum9Clicked(new ActionEvent());}
        if(event.getCode()==KeyCode.MINUS||event.getCode()==KeyCode.SUBTRACT){onBtnMinusClicked(new ActionEvent());}
        if(event.getCode()==KeyCode.DIVIDE||event.getCode()==KeyCode.SLASH){onBtnDivideClicked(new ActionEvent());}
        if(event.getCode()==KeyCode.PERIOD||event.getCode()==KeyCode.DECIMAL){onBtnDotClicked(new ActionEvent());}
        if(event.getCode()==KeyCode.BACK_SPACE){onBtnDeleteClicked(new ActionEvent());}
        if(event.getCode()==KeyCode.ENTER){onBtnEqualClicked(new ActionEvent());}

    }

    @FXML
    private void onKeyTyped(KeyEvent event){
        if(event.getCharacter().equals("+")){
            onBtnPlusClicked(new ActionEvent());
        }
        if(event.getCharacter().equals("*")){
            onBtnMultiplyClicked(new ActionEvent());
        }
        if(event.getCharacter().equals("8")){
            ActionEvent e = new ActionEvent();
            onNum8Clicked(new ActionEvent());
        }
        if(event.getCharacter().equals("=")){
            onBtnEqualClicked(new ActionEvent());
        }
        if(event.getCharacter().equals("(")){
            onBtnLeftBracClicked(new ActionEvent());
        }
        if(event.getCharacter().equals(")")){
            onBtnRightBracClicked(new ActionEvent());
        }
    }


    private boolean isExpressionLegal(){

        return true;
    }



}
