package sample.lexer;

public class LexicalException extends Exception {

    public int location;

    public LexicalException(int location){
        super("Invalid Number Input At " + location + "!(LexicalException)");
        this.location = location;
    }

}

