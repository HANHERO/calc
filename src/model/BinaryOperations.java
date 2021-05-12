package model;

public enum BinaryOperations implements Operation{
    PLUS(" + "),
    MINUS(" - "),
    MULTIPLY(" × "),
    DIVIDE(" ÷ ");

    public String sign;
    BinaryOperations(String sign){
        this.sign = sign;
    }

}
