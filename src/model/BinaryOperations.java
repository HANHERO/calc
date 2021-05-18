package model;

public enum BinaryOperations{
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("×"),
    DIVIDE("÷");

    public String sign;
    BinaryOperations(String sign){
        this.sign = sign;
    }

}
