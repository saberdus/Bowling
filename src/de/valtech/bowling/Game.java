package de.valtech.bowling;


import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static final int MAX_BOWLERS = 6;
    private static final int MAX_FRAMES = 10;
    private ArrayList<Bowler> bowlers;

    private Game() {
        bowlers = new ArrayList<>();
    }

    // Add bowler with specific name to ArrayList<> bowlers
    // Maximum six bowlers
    private void addBowler(String bowlerName) {
        if (bowlers.size() < MAX_BOWLERS) {
            Bowler bowler = new Bowler();
            bowler.setBowlerName(bowlerName);
            bowlers.add(bowler);
        } else {
            System.out.println("!!! Sorry, maximum 6 bowlers per game");
        }
    }

    private void printBowlerNames() {
        System.out.println("------- BOWLERS LIST -------");
        for(Bowler b: bowlers) {
            System.out.println(b.getBowlerName());
        }
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        Game game = new Game();

        Scanner input = new Scanner(System.in);
        System.out.println("################ Bowling Game ##################");
        System.out.println("Enter name of first bowler: ");
        game.addBowler(input.next());
        System.out.println("Enter name of second bowler: ");
        game.addBowler(input.next());

        game.printBowlerNames();

        //Add additional players
        System.out.println("Add an additional bowler?");
        System.out.println("Please enter yes or no");
        String answer = input.next();
        if(answer.equalsIgnoreCase("yes")) {
            System.out.println("You can add maximum 4 additional bowlers");
            System.out.println("Enter the number of bowlers to add:");
            int bowlersToAdd = input.nextInt();
            for(int i = 0; i < bowlersToAdd; i++) {
                System.out.println("Enter name of first bowler: ");
                game.addBowler(input.next());
            }
            game.printBowlerNames();
        }

        //Start bowling game
        for (int frameIndex = 1; frameIndex <= MAX_FRAMES; frameIndex++) {
            System.out.println("------------ FRAME "+ frameIndex +" ------------");

            for (Bowler b : game.getBowlers()) {
                if (frameIndex < 10) {
                    System.out.println(b.getBowlerName() +": enter your first roll: ");
                    int firstRoll = input.nextInt();
                    if (firstRoll == 10) {
                        System.out.println(b.getBowlerName() +" rolled a STRIKE");
                        b.playStrikeFrame();
                        b.roll(firstRoll);
                        System.out.println("------------------------------------");
                        System.out.println(b.getBowlerName() +" HAS CURRENT SCORE: "+ b.currentScore());
                    } else {
                        System.out.println(b.getBowlerName() +": enter your second roll: ");
                        int secondRoll = input.nextInt();
                        b.playFrame(firstRoll, secondRoll);

                        if (firstRoll + secondRoll == 10) {
                            System.out.println(b.getBowlerName() +": rolled a SPARE");
                        }

                        b.roll(firstRoll);
                        b.roll(secondRoll);
                        System.out.println("------------------------------------");
                        System.out.println(b.getBowlerName() +" HAS CURRENT SCORE: "+ b.currentScore());
                    }
                } else {
                    System.out.println("----------- LAST FRAME ----------");

                    System.out.println(b.getBowlerName() +": enter your first roll: ");
                    int firstRoll = input.nextInt();
                    if (firstRoll == 10) {
                        System.out.println(b.getBowlerName() +" rolled a STRIKE");
                    }

                    System.out.println(b.getBowlerName() +": enter your second roll: ");
                    int secondRoll = input.nextInt();
                    if (firstRoll + secondRoll == 10) {
                        System.out.println(b.getBowlerName() +" rolled a SPARE");
                    }

                    int thirdRoll = 0;
                    //Strike or Spare in last frame
                    if ( (firstRoll == 10) || (firstRoll + secondRoll == 10) ) {
                        System.out.println(b.getBowlerName() +": enter your third roll: ");
                        thirdRoll = input.nextInt();
                    }
                    b.playLastFrame(firstRoll, secondRoll, thirdRoll);

                    b.roll(firstRoll);
                    b.roll(secondRoll);
                    b.roll(thirdRoll);
                    System.out.println("------------------------------------");
                    System.out.println(b.getBowlerName() +" HAS CURRENT SCORE: "+ b.currentScore());
                }
                System.out.println("------------------------------------");
            }
        }

        for (Bowler b : game.getBowlers()) {
            System.out.println("----- Score of each frame by Bowler: "+ b.getBowlerName() +" ---------------------");
            System.out.println("----- Total Score of bowler "+ b.getBowlerName() +": "+ b.calculateBowlerScore());
            System.out.println("----------------------------------------------------------");
        }

    }

    private ArrayList<Bowler> getBowlers() {
        return bowlers;
    }
}
