package com.miniopdrachtenqien;

import java.util.Scanner;

public class HuntingGame {
    Scanner scanner = new Scanner(System.in);
    Player player = new Player();
    Enemy enemy = new Enemy();
    //to do:
    //wanneer setupenemy = merchant, krijg dan optie om een potion te kopen voor extra health, kost 2 goudstukken)
    //wanneer setupenemy = banker, krijg dan 3 goudstukken als bonus.
    //speler heeft bij start maar 3 potions, moet afnemen wanneer speler een potion inneemt.
    //speler heeft goudstukken 10
   

    void startHunting(){
        printGameRules();
        setupEnemy(); //setting up the HP, damagelevel and name of the first enemy
        while (true){
            setStatsPlayer(); //setting up the HP and damagelevel of the player, changes each iteration in the while loop
            printOptionsPlayer();
            String playerInput = scanner.nextLine();
            if(playerInput.equals("1")){
                attackEnemy();
                if(enemy.getHP() < 0){ //if enemy's HP is less or equal to 0, a new enemy will appear
                    setupEnemy();
                }else
                attackPlayer();
                if(player.getHP() <=0){ //if player's HP is less or equal to 0, game over
                    break;
                }

            }
            if(playerInput.equals("2")){
                flee();
            }
            if(playerInput.equals("3")){
                takePotion();
            }
            if(playerInput.equals("x")){
                System.out.println(player);
            }
            if(playerInput.equals("q")){
                System.out.println("Thank you for playing, Goodbye:-)");
                break;
            }
            player.resetDamageForce();//resetting the damagelevel  of the player to 0, so that the damage per attack differs each time the player attacks.
            player.resetPotion();//resetting the potion to 0, so each potion differs after each iteration.

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

    private void printOptionsPlayer(){
        System.out.println("        [1]: attack");
        System.out.println("        [2]: run away");
        System.out.println("        [3]: take potion");
        System.out.println("        [x]: check your stats");
        System.out.println("        [q]: quit");
    }

    private void setupEnemy(){ //de random stats genereren
        enemy.setAttackDamage();
        enemy.setHP();
        enemy.setName();
        System.out.println(" ");
            if(!enemy.name.equals("Merchant")){
                System.out.println("Time for a new Enemy to defeat!");
                System.out.println("You have encountered a " + enemy.getName() + ". What will you do?");
                System.out.println("******" + enemy + "******");
            }else
        System.out.println("You have encountered a Merchant. You can buy a potion for 2 coins");
    }

    private void flee(){
        System.out.println("      You have chosen to flee... ");
        System.out.println("              run...             ");
        System.out.println("           run faster!           ");
        System.out.println("   the " + enemy.getName() + " is still chasing you!");
        System.out.println("          you are almost save... ");
        System.out.println("           just a bit more...    ");
        System.out.println("                ...              ");
        System.out.println("...unfortunately, there is a new Enemy around the corner!");
        setupEnemy();
    }

    private void setStatsPlayer(){ //
        player.setDamageForce();
    }

    private void attackEnemy(){
        System.out.println("++++++" + player + "+++++");
        System.out.println("");
        System.out.println("You have attacked the " + enemy.getName() + "!");
        System.out.println("");
        enemy.decreaseHP(player.damage);
        System.out.println("******" + enemy + "******");
    }

    private void attackPlayer(){
        System.out.println("");
        System.out.println(enemy.getName() + " did a counterattack !");
        System.out.println("");
        player.decreaseHP(enemy.damage);
        System.out.println("******" + player + "******");

    }

    private void takePotion(){
        System.out.println("You took a potion of " + player.potionHP() + " HP.");
        System.out.println("Your health is now " + player.getHP());
    }
}
