package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.calculation.Calculator;
import sample.lexer.Lexer;
import sample.lexer.LexicalException;
import sample.lexer.Token;
import sample.parser.Parser;
import sample.parser.SyntaxException;

import java.util.List;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root, 360, 680));
//        Parent root = FXMLLoader.load(getClass().getResource("debug.fxml"));
//        primaryStage.setTitle("Calculator Debug");
//        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

        //Added by 魏春光
        /*Scanner sc = new Scanner(System.in);
        while (true){
            try {
                //词法分析
                Lexer l = new Lexer(sc.nextLine());
                List<Token> tokens = l.getTokens();
                for (Token t : tokens) {
                    System.out.println(t);
                }
                //语法分析
                Parser p = new Parser();

                p.readString(tokens);

                System.out.println("This is a legal statement.");

                Calculator c = new Calculator();

                double outcome = c.calculate(tokens);

                if((int)outcome == outcome){
                    System.out.println("Outcome: " + (int)outcome);
                }
                else {
                    System.out.println("Outcome: " + outcome);
                }


            }
            catch (LexicalException e) {
                System.out.println(e.getMessage());
            }
            catch (SyntaxException e) {
                System.out.println(e.getMessage());
            }

        }*/

    }
}
