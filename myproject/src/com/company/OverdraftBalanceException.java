package com.company;

public class OverdraftBalanceException extends RuntimeException{
    private String errormessage;
    public OverdraftBalanceException(){
        this.errormessage="进货费用超出拥有余额";
    }
    public String getErrormessage(){
        return errormessage;
    }
}
