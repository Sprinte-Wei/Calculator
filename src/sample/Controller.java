package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import sample.lexer.Lexer;
import sample.lexer.LexicalException;
import sample.lexer.Token;

import java.awt.*;
import java.util.ResourceBundle;
import java.net.URL;

public class Controller implements Initializable {

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
    private JFXTextArea mainText;

    private StringBuilder currentExpression;



    @Override
    public void initialize(URL url, ResourceBundle rb){

        gridPane.prefWidthProperty().bind(mainContainer.widthProperty());

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
