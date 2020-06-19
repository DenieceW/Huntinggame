package com.miniopdrachtenqien;

import java.util.Random;

public class Player {
    private Random random = new Random();
    int HP = 100;
    int damage;
    int coins = 10;
    private int potion;


    Player(){
    }

    int setCoins(){
        return this.coins = random.nextInt(1) + 14;
    }

    int decreaseCoins(int coins){
        return this.coins-=coins;
    }

    int getCoins(){
        return this.coins;
    }

    int getHP(){ //check status van health van speler
        return this.HP +=this.potion;
    }
    int potionHP(){
        return this.potion = random.nextInt(10) + 20;
    }

    int resetPotion(){
        return this.potion = 0;
    }

    int setDamageForce() { //
      return this.damage += random.nextInt(10) + 40; //the players damage to an enemy's HP is always between 10 and 40;
    }

    int resetDamageForce(){
       return this.damage = 0;
    }

    int getDamage(){
       return this.damage;
    }

    void decreaseHP(int number){
        this.HP-=number;
    }


    @Override
    public String toString() {
        if(this.HP <= 0){
            return "You dead";
        }else
        return "Your current HP is " + this.HP + " and your damagelevel is " + this.damage +
                ". You have " + this.coins + " amount of coins.";
    }
}
