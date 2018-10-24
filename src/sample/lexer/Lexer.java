package sample.lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private List<Token> tokens;
    private String input;
    private int currentCharPosition;

    public Lexer(String input){
        this.input = input;
        tokens = new ArrayList<>();
        currentCharPosition = 0;
    }

    public List<Token> getTokens() throws LexicalException{
        while (currentCharPosition != input.length()){
            nextToken();
        }
        return tokens;
    }

    private void nextToken() throws LexicalException {
        if(input.charAt(currentCharPosition) == ' ' || input.charAt(currentCharPosition) == '\t'){
            throw new LexicalException(currentCharPosition+1);
        }
        else if(input.charAt(currentCharPosition) == '('){
            tokens.add(new Token(TokenType.LEFT_PARENTHESIS, "(", ++currentCharPosition));
        }
        else if(input.charAt(currentCharPosition) == ')'){
            tokens.add(new Token(TokenType.RIGHT_PARENTHESIS, ")", ++currentCharPosition));
        }
        else if(input.charAt(currentCharPosition) == '+'){
            tokens.add(new Token(TokenType.PLUS, "+", ++currentCharPosition));
        }
        else if(input.charAt(currentCharPosition) == '-'){
            if(currentCharPosition==0 || input.charAt(currentCharPosition-1) == '('){
                if(currentCharPosition+1 != input.length() && isDigit(input.charAt(currentCharPosition+1))){
                    tokens.add(readNumber());
                }
                else {
                    tokens.add(new Token(TokenType.MINUS, "-", ++currentCharPosition));
                }
            }
            else {
                tokens.add(new Token(TokenType.MINUS, "-", ++currentCharPosition));
            }
        }
        else if(input.charAt(currentCharPosition) == '/'){
            tokens.add(new Token(TokenType.DIVIDE, "/", ++currentCharPosition));
        }
        else if(input.charAt(currentCharPosition) == '*'){
            tokens.add(new Token(TokenType.MULTIPLY, "*", ++currentCharPosition));
        }
        else if(isDigit(input.charAt(currentCharPosition))){
            tokens.add(readNumber());
        }
        else {
            throw new LexicalException(currentCharPosition+1);
        }
    }

    private Token readNumber() throws LexicalException{
        StringBuilder s = new StringBuilder();
        char startChar = input.charAt(currentCharPosition++);
        /*if(startChar == '-'){
            char nextChar = input.charAt(currentCharPosition);
            if(!isDigit(nextChar)){
                throw new LexicalException(currentCharPosition+1);
            }
        }*/
        s.append(startChar);
        int location = currentCharPosition;
        while (true){
            /*if(currentCharPosition == input.length()){
                if(isLegalNum(s.toString())){
                    return new Token(TokenType.NUMBER, s.toString(), location);
                }
                throw new LexicalException(currentCharPosition+1);
            }*/
            if((currentCharPosition == input.length() || !isLegalCharInNum(input.charAt(currentCharPosition))) && isLegalNum(s.toString())){
                return new Token(TokenType.NUMBER, s.toString(), location);
            }
            else if(!s.toString().equals("-") && !isLegalNum(s.toString()) && !isRightStepOfNum(s.toString())){
                throw new LexicalException(currentCharPosition);
            }
            else if(currentCharPosition == input.length()){
                throw new LexicalException(currentCharPosition+1);
            }
            else {
                s.append(input.charAt(currentCharPosition++));
            }
            /*if(!isLegalNum(s.toString())){
                throw new LexicalException(currentCharPosition);
            }
            else if(isOperator(input.charAt(currentCharPosition))){
                return new Token(TokenType.NUMBER, s.toString(), location);
            }
            else {
                s.append(input.charAt(currentCharPosition++));
            }
            /*if(currentCharPosition == input.length() || !isLegalCharInNum(input.charAt(currentCharPosition))){
                return new Token(TokenType.NUMBER, s.toString(), location);
            }
            else {
                s.append(input.charAt(currentCharPosition++));
                if(!isLegalNum(s.toString())){
                    throw new LexicalException(currentCharPosition);
                }
            }*/
        }
    }

    private boolean isLegalCharInNum(char c){
        return (c >= '0' && c <= '9') || c == '.';
    }

    private boolean isDigit(char c){
        return (c >= '0' && c <= '9');
    }

    private boolean isOperator(char c){
        switch (c){
            case '+':
            case '-':
            case '*':
            case '/':
            case '(':
            case ')':
                return true;
            default:
                return false;
        }
    }

    private boolean isLegalNum(String s){
        String regex1 = "-{0,1}[1-9]([0-9]*\\.{0,1}[0-9]+){0,1}"; //匹配整数64616  浮点数8161.15
        String regex2 = "-{0,1}0(\\.[0-9]+){0,1}"; //匹配0   浮点数0.53215  及0.0
        if(s.matches(regex1) || s.matches(regex2)){
            return true;
        }
        return false;
    }

    private boolean isRightStepOfNum(String s){
        String regex1 = "-{0,1}[1-9][0-9]*\\."; //匹配整数64616  浮点数8161.15
        String regex2 = "-{0,1}0\\."; //匹配0   浮点数0.53215  及0.0
        if(s.matches(regex1) || s.matches(regex2)){
            return true;
        }
        return false;
    }

}
