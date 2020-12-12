package com.company;

import java.util.ArrayList;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    public double money;
    public ArrayList<Beer>beerArrayList;
    public ArrayList<Juice>juiceArrayList;
    static{
        ArrayList<SetMeal>setMealArrayList=new ArrayList<>();
    }
    public West2FriedChickenRestaurant(double money,ArrayList<Beer>beerArrayList,ArrayList<Juice>juiceArrayList,ArrayList<SetMeal>setMealArrayList){
        this.beerArrayList=beerArrayList;
        this.juiceArrayList=juiceArrayList;
        this.money=money;
    }
    private void use(Juice juice) throws IngredientSortOutException{
        if (juiceArrayList.isEmpty()){
            throw new IngredientSortOutException("果汁");
        }else {
            juiceArrayList.remove(juice);
        }
    }
    private void use(Beer beer) throws IngredientSortOutException{
        if (beerArrayList.isEmpty()){
            throw new IngredientSortOutException("啤酒");
        }else{
            beerArrayList.remove(beer);
        }
    }
    private void imports(Drinks drink) throws OverdraftBalanceException{
        if (money<drink.chengben){
            throw new OverdraftBalanceException();
        }else{

            if(drink instanceof Juice){
                juiceArrayList.add((Juice) drink);
            }else{
                beerArrayList.add((Beer) drink);
            }
            money-=drink.chengben;
        }
    }
    @Override
    public void sellmeal(SetMeal setMeal) {
        if(setMeal.drinks instanceof Juice){
            try{
                use((Juice) setMeal.drinks);
            }catch (IngredientSortOutException e){
                System.out.println(e.getErrormessage());
            }
        }else{
            try{
                use((Beer) setMeal.drinks);
           }catch (IngredientSortOutException e){
                System.out.println(e.getErrormessage());
           }
        }
        money+=setMeal.cost;
    }

    @Override
    public void importgoods(Drinks... drinks) {
        for (Drinks drink:drinks){
            try{
                imports(drink);
            }catch (OverdraftBalanceException e){
                System.out.println(e.getErrormessage());
            }
        }
    }
}
