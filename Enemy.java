package com.miniopdrachtenqien;

import java.util.Random;

public class Enemy {
    private Random random = new Random();
    int HP;
    int damage;
    String name;

    String setName(){ //creating a random enemy by using a random number between 1 and 8 and adding an enemy to that number.
         int number = random.nextInt(7) + 1;
         if(number == 1){
             return this.name = "Demon";
         }else if (number == 2){
             return this.name = "Assassin";
         }else if(number == 3){
             return this.name = "Dragon";
         }else if(number == 4) {
             return this.name = "Healer";
         }else if(number == 5){
             return this.name = "Banker";
         }else if (number == 6){
             return this.name = "Robber";
         }else
             return this.name = "Hunter";
    }

    String getName(){
        return this.name;
    }

    int setAttackDamage(){
       return this.damage = (random.nextInt(10) + 40); //the damage of an enemy attack is always between 10 and 40
    }

    int setHP(){
        return this.HP = (random.nextInt(60) + 60); //HP of enemy is always between 60 and 120 hp.
    }

    void decreaseHP(int number){
        this.HP-=number;
    }

    int getHP(){
        return this.HP;
    }

    int getDamage(){
        return this.damage;
    }
    @Override
    public String toString() {
        if(this.HP <= 0){
            return "You have defeated the " + this.name;
        }else
        return "The current HP is of the " + this.name + " is " + this.HP + " and the damagelevel is " + this.damage;
    }


}
