package objects;

public enum Keys {
    ONE ("1"),
    TWO("2"),
    THREE ("3"),
    FOUR ("4"),
    FIVE ("5"),
    SIX ("6"),
    SEVEN ("7"),
    EIGHT ("8"),
    NINE ("9"),
    ZERO ("0"),
    ADD ("+"),
    SUBSTRACT ("-"),
    MULTIPLY ("x"),
    DIVIDE ("/"),
    DOT ("."),
    CLEAN ("C"),
    EQUAL ("=");

    private final String text;

    Keys (final String text){
        this.text = text;
    }

    @Override
    public String toString (){
        return text;
    }

}
