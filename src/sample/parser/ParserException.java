package sample.parser;

public class ParserException extends Exception {

    public ParserException(int location)
    {
        super("Parser Error At " + location + "!");
    }

    public ParserException(){}

}
