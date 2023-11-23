package com.day3.snakeAndLadder;

import java.util.*;

public class SnakeAndLadderGame {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game!");

        // Initialize player position and die throws
        int playerPosition = 0;
        int dieThrows = 0;

        // Continue the game until the player reaches the winning position (100)
        while (playerPosition < 100) {
            // Roll the dice
            int dieRoll = rollDie();
            dieThrows++;

            System.out.println("Die throw " + dieThrows + ": Player rolled a " + dieRoll);

            // Check the option: No play, Ladder, or Snake
            int option = checkOption();

            // Update player position based on the option
            playerPosition = updatePosition(playerPosition, dieRoll, option);

            // Ensure the player gets to the exact winning position of 100
            if (playerPosition > 100) {
                playerPosition -= dieRoll; // Move the player back to the previous position
                System.out.println("Player overshoots! Moves back to the previous position.");
            }

            // Display the current position
            System.out.println("Player's current position: " + playerPosition);
        }

        System.out.println("Congratulations! Player reached the winning position 100 in " + dieThrows + " die throws. Game Over!");
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
                break;
            case 2: // Snake
                System.out.println("Snake! Player moves behind by " + dieRoll + " positions.");
                position = Math.max(0, position - dieRoll);
                break;
        }
        return position;
    }
}