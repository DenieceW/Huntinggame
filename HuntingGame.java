package com.miniopdrachtenqien;

import java.util.Scanner;

public class HuntingGame {
    Scanner scanner = new Scanner(System.in);
    Player player = new Player();
    Enemy enemy = new Enemy();

    void startHunting(){
       // printGameRules();
        setStatsEnemy(); //setting up the HP, damagelevel and name of the first enemy
        while (true){
            setStatsPlayer(); //setting up the HP and damagelevel of the player, changes each iteration
            optionsPlayer();
            String playerInput = scanner.nextLine();
            if(playerInput.equals("1")){
                attackEnemy();
                if(enemy.getHP() < 0){
                   setStatsEnemy();
                }
            }
            if(playerInput.equals("3")){
                takePotion();
            }
            if(playerInput.equals("q")){
                break;
            }
            player.resetDamageForce();
            player.resetPotion();
            //resetting the damagelevel of the player to 0, so that the damage per attack differs each time the player attacks.
        }
    }

    private void printGameRules(){
        System.out.println("**********Welcome to the Hunting Game**********");
        System.out.println("During this game you will confront various enemies");
        System.out.println("Some of them will be stronger than you, some will be weaker");
        System.out.println("It will be up to you if you will fight for your life, or flee");
        System.out.println("To see your current status of your health(HP), and Attackdamage, press 'x'");
        System.out.println("When you confront the enemy, you have three choices:");
        System.out.println("[1] You can choose to attack");
        System.out.println("[2] You can choose to run");
        System.out.println("[3] You can choose to take a potion, if needed and then attack");
        System.out.println("Good luck and may the Gods be in your favour, Let the Hunting Games begin!");
        System.out.println("**************************************************************************");
    }

    private void optionsPlayer(){
        System.out.println("        [1]: attack");
        System.out.println("        [2]: run away");
        System.out.println("        [3]: take potion");
    }

    private void setStatsEnemy(){ //de random stats genereren
        enemy.setAttackDamage();
        enemy.setHP();
        enemy.setName();
        System.out.println(" ");
        System.out.println("Time for a new Enemy to defeat!");
        System.out.println("You have encountered a " + enemy.getName() + ". What will you do?");
    }

    private void setStatsPlayer(){ //
        player.setDamageForce();
    }

    private void attackEnemy(){
        System.out.println("++++++" + player + "+++++");
        System.out.println("******" + enemy + "******");
        System.out.println("");
        System.out.println("You have attacked the " + enemy.getName() + "!");
        System.out.println("");
        enemy.decreaseHP(player.damage);
        System.out.println("******" + enemy + "******");
    }

    private void takePotion(){
        System.out.println("You took a potion of " + player.potionHP() + " HP.");
        System.out.println("Your health is now " + player.getHP());
    }
}
