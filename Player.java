package com.miniopdrachtenqien;

import java.util.Random;

public class Player {
    private Random random = new Random();
    int HP = 150;
    int damage;
    private int potion;


    Player(){
    }

    int getHP(){ //check status van health van speler
        return this.HP +=this.potion;
    }
    int potionHP(){
        return this.potion = random.nextInt(15);
    }

    int resetPotion(){
        return this.potion = 0;
    }

    int setDamageForce() { //random getal tot 60 waarbij de speler schade kan brengen aan vijand
      return this.damage += random.nextInt(60);
    }

    int resetDamageForce(){
       return this.damage = 0;
    }

    int getDamage(){
       return this.damage;
    }

    @Override
    public String toString() {
        return "Your current HP is " + this.HP + " and your damagelevel is " + this.damage;
    }
}
