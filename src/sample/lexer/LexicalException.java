package sample.lexer;

public class LexicalException extends Exception {

    private int location;
    public LexicalException(int location){
        super("Invalid Number Input At " + location + "!");
    }

}

