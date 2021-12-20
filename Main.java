/*
* The "Template" program is a template
*
* @author  Darien R-H
* @version 1.0
* @since   2021-12-18
*/

import java.util.Scanner;

/**
* This is a program that blanks.
*/
final class Main {

    /**
    * Constant.
    */
    public static final double CONSTANT = 1;

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private Main() {
        throw new IllegalStateException("Cannot be instantiated");
    }
    static void towerOfHanoi(final int nOfDisks, final int startPeg,
                             final int endPeg) {

        // This function calculates where the disks should be placed in
        final int pegNumber = 6;  //Use the sum of the rods (6) to calc new startPeg  and endPeg
        if (nOfDisks == 1){
            System.out.println("Move disk 1 from peg " + startPeg + " to peg "
                               + endPeg);
        } else {

           towerOfHanoi(nOfDisks - 1, startPeg, pegNumber - startPeg - endPeg);
           System.out.println("Move disk " + nOfDisks + " from peg "
                               + startPeg + " to peg " + endPeg);
           towerOfHanoi(nOfDisks - 1, pegNumber - startPeg - endPeg, endPeg);
        }
    }
    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
       final int startPeg = 1;      //constants changed to capitals
        final int endPeg = 3;

        System.out.println("Tower of Hanoi");

        // input
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nHow many disks do you want?: ");

        try {
            int nOfDisks = userInput.nextInt();
            System.out.println();
            if (nOfDisks > 0) {
                // process
                towerOfHanoi(nOfDisks, startPeg, endPeg);
            } else {
                System.out.println("\nPlease enter a positive integer");
            }
        } catch (Exception ex) {
            System.err.print("\nThis is not an integer");
        }

        System.out.println("\nDone.");
    }
}
