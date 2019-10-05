
// Assignment #1
// Author: Peter V Johnston

// Description: In this assignment, we will be making a program to populate a
// game board with pieces and to move those pieces around on the board. Use
// the files Assignment.java, *GameBoard.java*, and GamePiece.java.

public class GameBoard {

    // GameBoard contains a 2-dimensional array called "board" of GamePiece
    // objects as its instance variable.
    GamePiece board[][];

    // constructs a gameboard of user specified size.
    public GameBoard(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            rows = 3;
            cols = 3;
            System.out.println("Negative or zero sized boards don't exist in this space.");
            System.out.println("We've assigned a default board size of 3x3. \nLet the games begin!");
        }
        // instantiate 2D array "board" of size rows by cols.
        board = new GamePiece[rows][cols];
        // iterates through the rows of the new board object.
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            // iterates through the colmns of the new board object.
            for (int colIndex = 0; colIndex < cols; colIndex++) {
                // instantiates a new default GamePiece to each element of board
                // as the iterations are carried out.
                board[rowIndex][colIndex] = new GamePiece();
            }
        }
    }
    // returns a GamePiece at the specified row and col.
    public GamePiece getPiece(int row, int col) {
        return this.board[row][col];
    }
    // check to see if the space is valid, used for moving and adding pieces.
    public boolean isSpaceValid(int row, int col) {
        // check if row is valid.
        if (row >= 0 && row < this.board.length) {
            // check if col is valid.
            if (col >=0 && col < this.board[0].length) {
                // if row and col are valid return true.
                return true;
            }
        }
        // if row and col are not valid, return false.
        return false;
    }
    // adds pieces according to the users input.
    public boolean addPiece(int row, int col, GamePiece piece) {
        // validate the row and column.
        if (isSpaceValid(row, col)) {
            // check if the space is occupied or not.
            if (this.board[row][col].getLabel().equals("---")) {
                // assign a new GamePiece according to the parameters.
                this.board[row][col] = piece;
                // return true.
                return true;
            }
        }
        // if above not carried out, return false.
        return false;
    }
    // moves pieces according to the users input.
    public boolean movePiece(int srcRow, int srcCol, int destRow, int destCol) {
        if (isSpaceValid(srcRow, srcCol)) {
            // dest row and col validation.
            if (isSpaceValid(destRow, destCol)) {
                // check if the space is occupied or not.
                if (this.board[destRow][destCol].getLabel().equals("---")) {
                    // over write src GamePiece to dest GamePiece array element.
                    board[destRow][destCol] = this.board[srcRow][srcCol];
                    // replace src with new default GamePiece.
                    this.board[srcRow][srcCol] = new GamePiece();
                    // return true.
                    return true;
                }
            }
        }
        // if above not carried out, return false.
        return false;
    }

    public String toString() {
        // make some variables for the elements of "The Gameboard" String output
        String headerChar = "-";
        String header = headerChar.repeat(20);
        String outString = "";
        // iterate over the rows in the 2D array.
        for (int rowIndex = 0; rowIndex < this.board.length; rowIndex++) {
            // iterate over the cols in the 2D array.
            for (int colIndex = 0; colIndex < this.board[0].length; colIndex++) {
                // concatenate each GamePiece into a String and put a space
                // between each column element.
                outString += this.board[rowIndex][colIndex] + " ";
            }
            // at the end of each row start a new line in the output string
            outString += "\n";
        }
        // print "The Gameboard and the 20 dashes with the
        return "\nThe Gameboard\n" + header + "\n" + outString;
    }
}
