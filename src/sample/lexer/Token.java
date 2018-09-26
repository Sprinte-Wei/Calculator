package sample.lexer;

public class Token {

    private TokenType type;
    private String value;
    private int location;

    public Token(TokenType type, String value, int location) {
        this.type = type;
        this.value = value;
        this.location = location;
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public int getLocation(){
        return location;
    }

    @Override
    public String toString() {
        return type + " " + value;
    }

}
