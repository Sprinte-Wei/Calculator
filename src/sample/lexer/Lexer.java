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

    public List<Token> getTokens(){
        while (currentCharPosition != input.length()){
            try{
                nextToken();
            }
            catch (LexicalException e){
                System.out.println(e.getMessage());
            }
        }
        return tokens;
    }

    private void nextToken() throws LexicalException {
        if(input.charAt(currentCharPosition) == ' ' || input.charAt(currentCharPosition) == '\t'){
            currentCharPosition++;
        }
        else if(input.charAt(currentCharPosition) == '('){
            tokens.add(new Token(TokenType.LEFT_PARENTHESIS, "("));
            currentCharPosition++;
        }
        else if(input.charAt(currentCharPosition) == ')'){
            tokens.add(new Token(TokenType.RIGHT_PARENTHESIS, ")"));
            currentCharPosition++;
        }
        else if(input.charAt(currentCharPosition) == '+'){
            tokens.add(new Token(TokenType.PLUS, "+"));
            currentCharPosition++;
        }
        else if(input.charAt(currentCharPosition) == '-'){
            tokens.add(new Token(TokenType.MINUS, "-"));
            currentCharPosition++;
        }
        else if(input.charAt(currentCharPosition) == '/'){
            tokens.add(new Token(TokenType.DIVIDE, "/"));
            currentCharPosition++;
        }
        else if(input.charAt(currentCharPosition) == '*'){
            tokens.add(new Token(TokenType.MULTIPLY, "*"));
            currentCharPosition++;
        }
        else {
            tokens.add(readNumber());
        }
    }

    private Token readNumber() throws LexicalException{
        StringBuilder s = new StringBuilder();
        s.append(input.charAt(currentCharPosition++));
        int location = currentCharPosition;
        while (true){
            if(currentCharPosition == input.length() || !isLegalCharInNum(input.charAt(currentCharPosition))){
                if(isLegalNum(s.toString())){
                    return new Token(TokenType.NUMBER, s.toString());
                }
                else {
                    throw new LexicalException(location);
                }
            }
            else {
                s.append(input.charAt(currentCharPosition++));
            }
        }
    }

    private boolean isLegalCharInNum(char c){
        return (c >= '0' && c <= '9') || c == '.';
    }

    private boolean isLegalNum(String s){
        String regex1 = "[1-9]([0-9]*\\.{0,1}[0-9]+){0,1}"; //匹配整数64616  浮点数8161.15
        String regex2 = "0(\\.[0-9]+){0,1}"; //匹配0   浮点数0.53215  及0.0
        if(s.matches(regex1) || s.matches(regex2)){
            return true;
        }
        return false;
    }

}
