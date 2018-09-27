package sample.lexer;

import sample.parser.State;

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
                tokens.add(readNumber());
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
        else if(isTheStartOfNumber(input.charAt(currentCharPosition))){
            tokens.add(readNumber());
        }
        else {
            throw new LexicalException(currentCharPosition+1);
        }
    }

    private Token readNumber() throws LexicalException{
        StringBuilder s = new StringBuilder();
        char startChar = input.charAt(currentCharPosition++);
        s.append(startChar);
        int location = currentCharPosition;
        while (true){
            if(startChar == '0'){

            }
            //if(isLegalCharInNum(input.charAt()))
            //if(isLegalCharInNum(input))
            if(currentCharPosition == input.length() || !isLegalCharInNum(input.charAt(currentCharPosition))){
                return new Token(TokenType.NUMBER, s.toString(), location);
                /*if(isLegalNum(s.toString())){
                    return new Token(TokenType.NUMBER, s.toString(), location);
                }
                else {
                    throw new LexicalException(location);
                }*/
            }
            else {
                s.append(input.charAt(currentCharPosition++));
                if(!isLegalNum(s.toString())){
                    throw new LexicalException(currentCharPosition);
                }
            }
        }
    }

    private boolean isLegalCharInNum(char c){
        return (c >= '0' && c <= '9') || c == '.';
    }

    private boolean isTheStartOfNumber(char c){
        return (c >= '0' && c <= '9');
    }

    private boolean isLegalNum(String s){
        String regex1 = "-{0,1}[1-9]([0-9]*\\.{0,1}[0-9]+){0,1}"; //匹配整数64616  浮点数8161.15
        String regex2 = "-{0,1}0(\\.[0-9]+){0,1}"; //匹配0   浮点数0.53215  及0.0
        if(s.matches(regex1) || s.matches(regex2)){
            return true;
        }
        return false;
    }

}
