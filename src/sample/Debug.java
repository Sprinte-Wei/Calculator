package sample;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.calculation.Calculator;
import sample.lexer.Lexer;
import sample.lexer.LexicalException;
import sample.lexer.Token;
import sample.parser.Parser;
import sample.parser.SyntaxException;

import java.util.List;

public class Debug {

    @FXML
    private JFXTextField input;
    @FXML
    private JFXTextArea output;
    @FXML
    private void onTestClicked(ActionEvent event){
        output.setText("");
        if(input.getText().equals("")){
            return;
        }
        try {
            Lexer l = new Lexer(input.getText());
            List<Token> tokens = l.getTokens();
            for (Token t : tokens) {
                output.setText(output.getText() + t + "\n");
            }
            Parser p = new Parser();
            p.readString(tokens);
            output.setText(output.getText() + "This is a legal statement.\n");
            Calculator c = new Calculator();
            double outcome = c.calculate(tokens);
            output.setText(output.getText() + "Outcome: " + outcome + "\n");
        }
        catch (LexicalException e) {
            output.setText(output.getText() + e.getMessage() + "\n");
        }
        catch (SyntaxException e) {
            output.setText(output.getText() + e.getMessage() + "\n");
        }
    }
}
