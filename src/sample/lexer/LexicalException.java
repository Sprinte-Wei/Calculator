package sample.lexer;

public class LexicalException extends Exception {

    public LexicalException(int location){
        super("Invalid Number Input At " + location + "!(LexicalException)");
    }

}

