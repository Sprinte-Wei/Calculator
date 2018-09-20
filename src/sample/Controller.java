package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ResourceBundle;
import java.net.URL;

public class Controller implements Initializable {

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
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnSquare;
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


    @Override
    public void initialize(URL url, ResourceBundle rb){
        num0.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        num1.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        num2.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        num3.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        num4.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        num5.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        num6.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        num7.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        num8.setBackground(new Background(new BackgroundFill(Color.rgb(250, 250, 250),null,null)));
        num9.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        btnMinus.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        btnPlus.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        btnDivide.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        btnMultiply.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        btnEqual.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        btnDelete.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        btnSqrt.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        btnClear.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        btnDot.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
        btnSquare.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null,null)));
    }

}
