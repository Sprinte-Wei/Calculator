package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.lexer.Lexer;
import sample.lexer.Token;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

        //Added by 魏春光
        /*Scanner sc=new Scanner(System.in);
        while (true){
            Lexer l = new Lexer(sc.next());
            for(Token t : l.getTokens()){
                System.out.println(t);
            }
        }*/
        //将注释去掉再将第一行注释即可测试词法分析
    }
}
