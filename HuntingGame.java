package com.miniopdrachtenqien;

import java.util.Scanner;

public class HuntingGame {
    Scanner scanner = new Scanner(System.in);
    Player player = new Player();
    Enemy enemy = new Enemy();
    int maxPotions = 0;
    //to do:
    //wanneer setupenemy = banker, krijg dan 3 goudstukken als bonus.



    void startHunting(){
        printGameRules();
        setupEnemy(); //setting up the HP, damagelevel and name of the first enemy
        while (true){
            setStatsPlayer(); //setting up the HP and damagelevel of the player, the damagelevel changes each iteration in the while loop
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
                if(maxPotions >= 3){
                    System.out.println("You're all out of potions, you have to wait for a Merchant to stop by!");
                }else
                takePotion();
            }
            if(playerInput.equals("x")){
                System.out.println("Your current HP is " + player.HP + " and your damagelevel is " + player.getDamage() +
                 ". You have " + player.getCoins() + " coins left");
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
        System.out.println("[3] You can choose to take a potion, but beware, you only get 3");
        System.out.println("You may encounter a Merchant, they will give you a potion for 2 coins");
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
                buyPotion();

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
        player.setCoins();
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
        maxPotions++;
    }

    private void buyPotion(){
        System.out.println("You have encountered a Merchant. You can buy a potion for 2 coins");
        player.decreaseCoins();
        System.out.println("You bought a potion of " + player.potionHP() + " HP.");
        System.out.println("Your health is now " + player.getHP() +" and you have " + player.getCoins() + " coins left" );
    }
}
