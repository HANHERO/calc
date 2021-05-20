package model;

public enum UnaryOperations{
    SQUARE("sqr"),
    SQRT("√"),
    ONE_DIVIDED_X("1/"),
    NEGATIVE("negate");

    public String sign;
    UnaryOperations(String sign){
        this.sign = sign;
    }


}
