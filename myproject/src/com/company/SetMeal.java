package com.company;

public class SetMeal {
    public String name;
    public double cost;
    public String FriedChicken;
    public Drinks drinks;
    public String toString(){
        return name;
    }
    public SetMeal(String name,String friedChicken,Drinks drinks,double cost){
        this.name=name;
        this.drinks=drinks;
        this.cost=cost;
        this.FriedChicken=friedChicken;
    }
}
