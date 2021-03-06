package com.miniopdrachtenqien;

import java.util.Scanner;

public class HuntingGame {
    Scanner scanner = new Scanner(System.in);
    Player player = new Player();
    Enemy enemy = new Enemy();
    int maxPotions = 0;

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
                if(maxPotions > 3){
                    System.out.println("You're all out of potions, you have to wait for a Healer to stop by or buy a potion from a Merchant!");
                }else
                    takePotion();
            }
            if(playerInput.equals("4")){
                buyPotion();
            }
            if(playerInput.equals("x")){
                System.out.println("Your current HP is " + player.getHP() + " and your damagelevel is " + player.getDamage() +
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
        System.out.println("To see your current status of your health(HP), and damagelevel, press 'x'");
        System.out.println("When you confront the enemy, you have 4 choices:");
        System.out.println("[1] You can choose to attack");
        System.out.println("[2] You can choose to run");
        System.out.println("[3] You can choose to take a potion, but beware, you only get 3");
        System.out.println("[4] You can choose to buy a potion, this will cost you 2 coins");
        System.out.println("You may encounter a Healer, they will give you a potion for free");
        System.out.println("You may encounter a Banker, they will give a random number of coins");
        System.out.println("You may encounter a Robber, they will rob you and you will lose all your coins");
        System.out.println("Good luck and may the Gods be in your favour, Let the Hunting Games begin!");
        System.out.println("**************************************************************************");
    }

    private void printOptionsPlayer(){
        System.out.println("        [1]: attack");
        System.out.println("        [2]: run away");
        System.out.println("        [3]: take potion");
        System.out.println("        [4]: buy potion");
        System.out.println("        [x]: check your stats");
        System.out.println("        [q]: quit");
    }

    private void setupEnemy(){ //de random stats genereren
        enemy.setAttackDamage();
        enemy.setHP();
        enemy.setName();
        System.out.println(" ");
        switch (enemy.name) {
            case "Healer":
                getPotion();
                break;
            case "Banker":
                increaseCoins();
                break;
            case "Robber":
                getRobbed();

                break;
            default:
                System.out.println("Time for a new Enemy to defeat!" +
                        "\n" + "You have encountered a " + enemy.getName() + ". What will you do?" +
                        "\n*****" + enemy + "*****");
                break;
        }
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
        player.addPotionToHP();
        System.out.println("Your health is now " + player.getHP());
        maxPotions++; //if maxpotions = 3, the player cannot access this method anymore.
    }

    private void buyPotion(){
        if(player.getCoins() <= 1){
            System.out.println("You dont have enough coins!");
        }else if (player.getCoins() > 0) {
            player.decreaseCoins(2); //amount of coins decreases by 2;
            System.out.println("You have encountered a Merchant and bought a potion for 2 coins of " + player.potionHP() + " HP.");
            player.addPotionToHP();
            System.out.println("Your health is now " + player.getHP() + " and you have " + player.getCoins() + " coins left");
        }
    }

    private void getPotion(){
        System.out.println("You have encountered a Healer and got a potion of " + player.potionHP() + " HP.");
        player.addPotionToHP();
        System.out.println("Your health is now " + player.getHP() +" and you have " + player.getCoins() + " coins left" );
    }

    private void increaseCoins(){
        System.out.println("You have encountered a Banker and your coins have increased!");
        player.increaseCoins();
        System.out.println("You now have " + player.getCoins() + " coins.");
    }

    private void getRobbed(){
        System.out.println("You have encountered a Robber and have been robbed of all your coins");
        player.coins = 0;
    }
}
