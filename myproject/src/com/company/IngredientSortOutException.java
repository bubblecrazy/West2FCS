package com.company;

public class IngredientSortOutException extends RuntimeException{
    private String errormessage;
    public IngredientSortOutException(String s){
        this.errormessage=s+"售完";
    }
    public String getErrormessage(){
        return errormessage;
    }
}
