package com.day3.snakeAndLadder;

import java.util.*;

public class SnakeAndLadderGame {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game!");

        // Initialize player position
        int playerPosition = 0;

        // Roll the dice
        int dieRoll = rollDie();

        System.out.println("Player rolled a " + dieRoll);
    }

    /*
     * @Desc : Simulating dice roll
     * @Params: none
     * @returns: value btwn 1 to 6
     */
    private static int rollDie() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

}