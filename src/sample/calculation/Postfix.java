package sample.calculation;

import sample.lexer.Token;
import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Postfix {
    //用于记录操作符
    private static LinkedList<Token> operators=new LinkedList<>();
    //用于记录输出
    private static LinkedList<Token> output=new LinkedList<>();
    //用于展示后缀表达式
    private static StringBuilder sb=new StringBuilder();

    //中缀表达式转为后缀表达式
    private static void transferToPostfix(LinkedList<Token> list){
        Iterator<Token> it=list.iterator();
        while (it.hasNext()) {
            Token s = it.next();
            if (isOperator(s.getValue())) {
                if (operators.isEmpty()) {
                    operators.push(s);
                }
                else {
                    //如果读入的操作符为非")"且优先级比栈顶元素的优先级高或一样，则将操作符压入栈
                    if (priority(operators.peek().getValue())<=priority(s.getValue())&&!s.equals(")")) {
                        operators.push(s);
                    }
                    else if(!s.equals(")")&&priority(operators.peek().getValue())>priority(s.getValue())){
                        while (operators.size()!=0&&priority(operators.peek().getValue())>=priority(s.getValue())
                                &&!operators.peek().equals("(")) {
                            if (!operators.peek().equals("(")) {
                                Token operator = operators.pop();
                                sb.append(operator).append(" ");
                                output.push(operator);
                            }
                        }
                        operators.push(s);
                    }
                    //如果读入的操作符是")"，则弹出从栈顶开始第一个"("及其之前的所有操作符
                    else if (s.equals(")")) {
                        while (!operators.peek().equals("(")) {
                            Token operator=operators.pop();
                            sb.append(operator).append(" ");
                            output.push(operator);
                        }
                        //弹出"("
                        operators.pop();
                    }
                }
            }
            //读入的为非操作符
            else {
                sb.append(s).append(" ");
                output.push(s);
            }
        }
        if (!operators.isEmpty()) {
            Iterator<Token> iterator=operators.iterator();
            while (iterator.hasNext()) {
                Token operator=iterator.next();
                sb.append(operator).append(" ");
                output.push(operator);
                iterator.remove();
            }
        }
        System.out.println("后缀： "+sb);
        calculate();
        //Collections.reverse(output);
    }

    //根据后缀表达式计算结果
    private static void calculate(){
        LinkedList<String> mList=new LinkedList<>();
        String[] postStr=sb.toString().split(" ");
        for (String s:postStr) {
            if (isOperator(s)){
                if (!mList.isEmpty()){
                    int num1=Integer.valueOf(mList.pop());
                    int num2=Integer.valueOf(mList.pop());
                    if (s.equals("/")&&num1==0){
                        System.out.println("除数不能为0");
                        return;
                    }
                    int newNum=cal(num2,num1,s);
                    mList.push(String.valueOf(newNum));
                }
            }
            else {
                //数字则压入栈中
                mList.push(s);
            }
        }
        if (!mList.isEmpty()){
            System.out.println("result: "+mList.pop());
        }
    }

    //判断是否操作符
    private static boolean isOperator(String oper){
        if (oper.equals("+")||oper.equals("-")||oper.equals("/")||oper.equals("*")
                ||oper.equals("(")||oper.equals(")")) {
            return true;
        }
        return false;
    }
    //计算操作符的优先级
    private static int priority(String s){
        switch (s) {
            case "+":return 1;
            case "-":return 1;
            case "*":return 2;
            case "/":return 2;
            case "(":return 3;
            case ")":return 3;
            default :return 0;
        }
    }

    private static int cal(int num1,int num2,String operator){
        switch (operator){
            case "+":return num1+num2;
            case "-":return num1-num2;
            case "*":return num1*num2;
            case "/":return num1/num2;
            default :return 0;
        }
    }

}