package sample.parser;

public class SyntaxException extends Exception {

    public int location;

    public SyntaxException(int location) {
        super("Syntax Error At " + location + "!(SyntaxException)");
        this.location = location;
    }

}
