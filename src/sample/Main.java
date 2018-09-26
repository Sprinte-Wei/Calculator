package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.lexer.Lexer;
import sample.lexer.LexicalException;
import sample.lexer.Token;
import sample.parser.Parser;
import sample.parser.ParserException;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 360, 680));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        //launch(args);

        //Added by 魏春光
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                //词法分析
                Lexer l = new Lexer(sc.nextLine());
                for (Token t : l.getTokens()) {
                    System.out.println(t);
                }

                //语法分析
                Parser p = new Parser();
                p.readString(l.getTokens());
                System.out.println("输入句子形式正确");
            }
            catch (LexicalException e)
            {
                e.printStackTrace();
            }
            catch (ParserException e)
            {
                e.printStackTrace();
            }

        }

    }
}
