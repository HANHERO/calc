package model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MainModel {
    private boolean isCommaClicked = false;
    private BigDecimal a = new BigDecimal(BigInteger.ZERO);
    private BigDecimal b = new BigDecimal(BigInteger.ZERO);
    private BigDecimal d = new BigDecimal("0.1");

    public void initB(int clickedNumericButton) {
        if (!isCommaClicked) {
            b = b.multiply(new BigDecimal(10)).add(new BigDecimal(clickedNumericButton));
        } else {
            b = b.add(new BigDecimal(clickedNumericButton).multiply(d));
            d = d.multiply(new BigDecimal("0.1"));
        }
        System.out.println(b);
    }
    public void commaClicked(){
        isCommaClicked = true;
    }
    public void ceClicked(){
        b = new BigDecimal(BigInteger.ZERO);
        System.out.println(b);
        d = new BigDecimal("0.1");
        isCommaClicked = false;
    }

    public void cClicked() {
        a = new BigDecimal(BigInteger.ZERO);
        b = new BigDecimal(BigInteger.ZERO);
        d = new BigDecimal("0.1");
        isCommaClicked = false;
    }

    public void squareClicked() {
        b = b.multiply(b);
        System.out.println(b);
    }

    public void root() {
    }
}
