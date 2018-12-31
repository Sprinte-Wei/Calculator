package sample.calculation;

import sample.lexer.Token;
import sample.lexer.TokenType;

import java.math.BigDecimal;
import java.util.*;

public class Calculator {

    //计算后缀式结果
    public double calculate(List<Token> tokens){
        ArrayList<String> postfix = transferToPostfix(tokens);
        Stack<Double> operand = new Stack<>();
        Iterator<String> it = postfix.iterator();
        while (it.hasNext()){
            String currentOperand = it.next();
            if(isOperator(currentOperand)){
                operand.push(calculate(operand.pop(), operand.pop(), currentOperand));
            }
            else {
                operand.push(Double.parseDouble(currentOperand));
            }
        }
        BigDecimal b1 = new BigDecimal(Double.toString(operand.pop()));
        return b1.doubleValue();
    }

    //中缀转后缀
    public ArrayList<String> transferToPostfix(List<Token> tokens){
        ArrayList<String> postfix = new ArrayList<>();
        Stack<String> operators = new Stack<>();
        for(int i = 0; i < tokens.size(); i++){
            Token t = tokens.get(i);
            if(t.getType() == TokenType.NUMBER){
                postfix.add(t.getValue());
            }
            else if(t.getType() == TokenType.RIGHT_PARENTHESIS){
                while (!operators.peek().equals("(")){
                    postfix.add(operators.pop());
                }
                operators.pop();
            }
            else if(t.getType() == TokenType.LEFT_PARENTHESIS){
                operators.push("(");
            }
            else {
                if(t.getType() == TokenType.MINUS && (i == 0 || tokens.get(i-1).getType() != TokenType.NUMBER)){
                    postfix.add("0");
                }
                while (!operators.empty() && priority(operators.peek()) >= priority(t.getValue())){
                    postfix.add(operators.pop());
                }
                operators.push(t.getValue());
            }
        }
        while (!operators.empty()){
            postfix.add(operators.pop());
        }
        return postfix;
    }

    //优先级问题，左括号和右括号特殊对待
    private int priority(String s){
        switch (s) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default :
                return 0;
        }
    }

    private double calculate(double num1,double num2,String operator){
        switch (operator){
            case "+":
                return new BigDecimal(Double.toString(num1)).add(new BigDecimal(Double.toString(num2))).doubleValue();
                //return num1+num2;
            case "-":
                return new BigDecimal(Double.toString(num2)).subtract(new BigDecimal(Double.toString(num1))).doubleValue();
                //return num2-num1;
            case "*":
                return new BigDecimal(Double.toString(num1)).multiply(new BigDecimal(Double.toString(num2))).doubleValue();
            //return num1*num2;
            case "/":
                return new BigDecimal(Double.toString(num2)).divide(new BigDecimal(Double.toString(num1)), 10, BigDecimal.ROUND_HALF_UP).doubleValue();

            //return num2/num1;
            default :
                return 0;
        }
    }

    private static boolean isOperator(String s){
        switch (s){
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            default:
                return false;
        }
    }

}