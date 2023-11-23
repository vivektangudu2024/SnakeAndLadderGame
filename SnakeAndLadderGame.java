package com.day3.snakeAndLadder;

import java.util.*;

public class SnakeAndLadderGame {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game!");

        // Initialize player positions and die throws
        int player1Position = 0;
        int player2Position = 0;
        int dieThrows = 0;

        // Continue the game until one of the players reaches the winning position (100)
        while (player1Position < 100 && player2Position < 100) {
            // Determine the current player
            int currentPlayer = (dieThrows % 2 == 0) ? 1 : 2;

            // Roll the dice
            int dieRoll = rollDie();
            dieThrows++;

            System.out.println("Die throw " + dieThrows + " (Player " + currentPlayer + "): Player rolled a " + dieRoll);

            // Check the option: No play, Ladder, or Snake
            int option = checkOption();

            // Update player position based on the option
            if (currentPlayer == 1) {
                player1Position = updatePosition(player1Position, dieRoll, option);
            } else {
                player2Position = updatePosition(player2Position, dieRoll, option);
            }

            // Ensure the player gets to the exact winning position of 100
            if (currentPlayer == 1 && player1Position > 100) {
                player1Position -= dieRoll; // Move the player back to the previous position
                System.out.println("Player 1 overshoots! Moves back to the previous position.");
            } else if (currentPlayer == 2 && player2Position > 100) {
                player2Position -= dieRoll; // Move the player back to the previous position
                System.out.println("Player 2 overshoots! Moves back to the previous position.");
            }

            // Display the current positions
            System.out.println("Player 1's current position: " + player1Position);
            System.out.println("Player 2's current position: " + player2Position);
        }

        // Determine the winner
        if (player1Position >= 100) {
            System.out.println("Player 1 wins! Player 1 reached the winning position 100 in " + dieThrows/2 + " die throws.");
        } else {
            System.out.println("Player 2 wins! Player 2 reached the winning position 100 in " + dieThrows/2 + " die throws.");
        }
    }

    /*
     * @Desc : Simulating dice roll
     * @Params: none
     * @returns: value between 1 to 6
     */
    private static int rollDie() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    /*
     * @Desc : check the option: No play, Ladder, or Snake
     * @Params: none
     * @returns: 0 for No play, 1 for Ladder, 2 for Snake
     */
    private static int checkOption() {
        Random random = new Random();
        return random.nextInt(3);
    }

    /*
     * @Desc : update player position based on the die roll and option
     * @Params: position, dieRoll, option
     * @returns: updated player position
     */
    private static int updatePosition(int position, int dieRoll, int option) {
        switch (option) {
            case 0: // No play
                System.out.println("No play! Player stays in the current position.");
                break;
            case 1: // Ladder
                System.out.println("Ladder! Player moves ahead by " + dieRoll + " positions.");
                position += dieRoll;
                //if(position>100)position-=dieRoll;
                break;
            case 2: // Snake
                System.out.println("Snake! Player moves behind by " + dieRoll + " positions.");
                position = Math.max(0, position - dieRoll);
                break;
        }
        return position;
    }
}