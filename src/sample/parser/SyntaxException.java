package sample.parser;

public class SyntaxException extends Exception {

    public SyntaxException(int location) {
        super("Syntax Error At " + location + "!(SyntaxException)");
    }

}
