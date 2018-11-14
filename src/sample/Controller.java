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

import javax.swing.text.html.ImageView;
import java.util.List;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.regex.Pattern;

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
    @FXML
    private ImageView imageView;

    private StringBuilder currentExpression;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        mainText.setText("0");

        gridPane.prefWidthProperty().bind(mainContainer.widthProperty());

        mainText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(mainText.getText().length()>=18) {
                    mainText.setFont(new Font("Arial Bold", 15.0));
                }
                else{
                    mainText.setFont(new Font("Arial Bold", 30.0));
                }
            }
        });

    }

    @FXML
    private void onImageClicked(ActionEvent event){

    }
    @FXML
    private void onNum0Clicked(ActionEvent event){
        if(mainText.getText().equals("0")){
            mainText.setText("");
        }
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('0');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onNum1Clicked(ActionEvent event){
        if(mainText.getText().equals("0")){
            mainText.setText("");
        }
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('1');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onNum2Clicked(ActionEvent event){
        if(mainText.getText().equals("0")){
            mainText.setText("");
        }
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('2');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onNum3Clicked(ActionEvent event){
        if(mainText.getText().equals("0")){
            mainText.setText("");
        }
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('3');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onNum4Clicked(ActionEvent event){
        if(mainText.getText().equals("0")){
            mainText.setText("");
        }
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('4');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onNum5Clicked(ActionEvent event){
        if(mainText.getText().equals("0")){
            mainText.setText("");
        }
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('5');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onNum6Clicked(ActionEvent event){
        if(mainText.getText().equals("0")){
            mainText.setText("");
        }
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('6');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onNum7Clicked(ActionEvent event){
        if(mainText.getText().equals("0")){
            mainText.setText("");
        }
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('7');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onNum8Clicked(ActionEvent event){
        if(mainText.getText().equals("0")){
            mainText.setText("");
        }
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('8');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onNum9Clicked(ActionEvent event){
        if(mainText.getText().equals("0")){
            mainText.setText("");
        }
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('9');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onBtnDotClicked(ActionEvent event){
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('.');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onBtnDivideClicked(ActionEvent event){
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('/');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onBtnPlusClicked(ActionEvent event){
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('+');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onBtnMinusClicked(ActionEvent event){

        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('-');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onBtnMultiplyClicked(ActionEvent event){
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('*');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onBtnLeftBracClicked(ActionEvent event){
        if(mainText.getText().equals("0")){
            mainText.setText("");
        }
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append('(');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }

    @FXML
    private void onBtnRightBracClicked(ActionEvent event){
//        if(mainText.getText().equals("0")){
//            mainText.setText("");
//        }
        StringBuilder s = new StringBuilder(mainText.getText());
        s.append(')');
        if(isExpressionLegal(s.toString())){
            mainText.setText(s.toString());
        }
    }




    @FXML
    private void onBtnEqualClicked(ActionEvent event){

        if(canCalculate(mainText.getText())){
            Calculator c = new Calculator();

            double outcome = c.calculate(tokens);

            if((int)outcome == outcome){
                System.out.println("Outcome: " + (int)outcome);
            }
            else {
                System.out.println("Outcome: " + outcome);
            }
            if(resultText.getText().length()>=10) {
                resultText.setFont(new Font("Arial Bold", 30.0));
            }
            resultText.setText(outcome+"");
            mainText.setText("0");
        }

    }

    @FXML
    private void onBtnDeleteClicked(ActionEvent event){
        if(mainText.getText().length() == 1){
            mainText.setText("0");
            return;
        }
        if(mainText.getText().length() != 0){
            mainText.setText(mainText.getText().substring(0, mainText.getText().length() - 1));
            length--;
        }
    }

    @FXML
    private void onBtnClearClicked(ActionEvent event){
        mainText.setText("0");
        resultText.setText("0");
        length=0;
    }

    @FXML
    private void onKeyPressed(KeyEvent event){
        if(event.getCode()==KeyCode.DIGIT0||event.getCode()==KeyCode.NUMPAD0 ){onNum0Clicked(new ActionEvent());}
        if(event.getCode()==KeyCode.DIGIT1||event.getCode()==KeyCode.NUMPAD1){onNum1Clicked(new ActionEvent());}
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
        if(mainText.getText().length() != 0){
            Lexer l = new Lexer(mainText.getText());
            try {
                for(Token t : l.getTokens()){
                    System.out.println(t);
                }
            }
            catch(LexicalException e){
                return false;
            }
        }
        return true;
    }

    private boolean isExpressionLegal(String s){
        if(s == null || s.equals("")){
            return false;
        }
        try{
            Lexer l = new Lexer(s);
            tokens = l.getTokens();
            Parser p = new Parser();
            p.readString(tokens);
        }
        catch(LexicalException e){
            if(e.location == s.length() + 1){
                return true;
            }
            return false;
        }
        catch (SyntaxException e){
            if(e.location == s.length() + 1){
                return true;
            }
            return false;

        }
        return true;
    }

    List<Token> tokens;
    private boolean canCalculate(String s){
        if(s == null || s.equals("")){
            return false;
        }
        try{
            Lexer l = new Lexer(s);
            tokens = l.getTokens();
            Parser p = new Parser();
            p.readString(tokens);
        }
        catch(LexicalException e){
            return false;
        }
        catch (SyntaxException e){
            return false;

        }
        return true;
    }



}
