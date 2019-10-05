
// Assignment #1
// Author: ASU CSE 240 Spring 2019
// Testing program provided by instructional team.

// Description: In this assignment, we will be making a program to populate a
// game board with pieces and to move those pieces around on the board. Use
// the files *Assignment.java*, GameBoard.java, and GamePiece.java.

import java.util.Scanner;

public class Assignment {

    /**
     * main method for the assignment.
     *
     * This method takes input from the user to allow testing various scenarios
     * for the GameBoard and GamePiece classes.
     */
    public static void main(String[] args) {
        // declare local variables
        int row;
        int col;
        int destRow;
        int destCol;
        int rowNum;
        int colNum;
        GameBoard board;
        GamePiece piece;
        Scanner input = new Scanner(System.in);
        String inputString;

        // obtain board size from the user
        System.out.println("Please enter the number of rows.");
        rowNum = input.nextInt();

        System.out.println("Please enter the number of columns.");
        colNum = input.nextInt();

        board = new GameBoard(rowNum, colNum);

        // obtain a label for the next piece from the user
        System.out.println("Please enter a label for a new piece. Enter \"Q\" when done.");
        inputString = input.next();

        // continue until the user indicates they are done
        while (!inputString.equalsIgnoreCase("Q")) {
            // create a new GamePiece from the user input
            piece = new GamePiece(inputString);

            // obtain a row and column to place the new piece
            System.out.println("Please enter a row for the piece.");
            row = input.nextInt();

            System.out.println("Please enter a column for the piece.");
            col = input.nextInt();

            // validate the space is valid
            if (board.isSpaceValid(row, col)) {
                // add the piece
                if (board.addPiece(row, col, piece)) {
                    System.out.println("New piece \"" + piece.getLabel() + "\" added.");
                }
                else {
                    System.out.println("A piece is already at that space.");
                    System.out.println("New piece \"" + piece.getLabel() + "\" not added.");
                }
            }
            else {
                System.out.println("Invalid row or column.");
                System.out.println("New piece \"" + piece.getLabel() + "\" not added.");
            }

            // obtain a label for the next piece from the user
            System.out.println("Please enter a label for a new piece. Enter \"Q\" when done.");
            inputString = input.next();
        }

        // check if the user wants to move a piece
        System.out.println(board.toString());
        System.out.println("Would you like to move a piece? Enter \"Y\" to move a piece");
        inputString = input.next();

        while (inputString.equalsIgnoreCase("Y")) {
            // obtain the piece's location from the user
            System.out.println("Please enter the piece's row.");
            row = input.nextInt();

            System.out.println("Please enter the piece's column.");
            col = input.nextInt();

            // obtain the piece's destination from the user
            System.out.println("Please enter the piece's new row.");
            destRow = input.nextInt();

            System.out.println("Please enter the piece's new column.");
            destCol = input.nextInt();

            // validate that both spaces are valid
            if (board.isSpaceValid(row, col) && board.isSpaceValid(destRow, destCol)) {
                // move the piece
                if (board.movePiece(row, col, destRow, destCol)) {
                    System.out.println("Piece moved to new space.");
                }
                else {
                    System.out.println("A piece is already in that space.");
                }
            }
            else {
                System.out.println("A row or column is invalid. No piece moved.");
            }

            // print the current state of the board and prompt the user to continue
            System.out.println(board.toString());
            System.out.println("Would you like to move a piece? Enter \"Y\" to move a piece");
            inputString = input.next();
        }

        input.close();
    }

}
