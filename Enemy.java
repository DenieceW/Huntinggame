package com.miniopdrachtenqien;

import java.util.Random;

public class Enemy {
    private Random random = new Random();
    int HP;
    int attackDamage;
    String name;

    Enemy(){

    }

    String setName(){ //random een vijand creeren d.m.v een naam geven met behulp van een random nummer.
         int number = random.nextInt(3) + 1;
         if(number == 1){
             return this.name = "Demon";
         }else if (number == 2){
             return this.name = "Assassin";
         }else return this.name = "Hunter";
    }

    String getName(){
        return this.name;
    }

    int setAttackDamage(){
       return this.attackDamage = (random.nextInt(40) + 60);
    }

    int setHP(){
        return this.HP = (random.nextInt(60) + 80);
    }

    void decreaseHP(int number){
        this.HP-=number;
    }

    int getHP(){
        return this.HP;
    }

    int getAttackDamage(){
        return this.attackDamage;
    }
    @Override
    public String toString() {
        if(this.HP <= 0){
            return "You have defeated the " + this.name;
        }else
        return "The current HP is of the " + this.name + " is " + this.HP + " and the damagelevel is " + this.attackDamage;
    }


}
