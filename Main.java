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
    static void towerOfHanoi(final int nOfDisks, final int STARTPEG,
                             final int ENDPEG) {

        // This function calculates where the disks should be placed in
        final int PEG_NUMBER = 6;  //Use the sum of the rods (6) to calc new STARTPEG  and ENDPEG
        if (nOfDisks == 1){
            System.out.println("Move disk 1 from peg " + STARTPEG + " to peg "
                               + ENDPEG);
        } else {

           towerOfHanoi(nOfDisks - 1, STARTPEG, PEG_NUMBER - STARTPEG - ENDPEG);
           System.out.println("Move disk " + nOfDisks + " from peg "
                               + STARTPEG + " to peg " + ENDPEG);
           towerOfHanoi(nOfDisks - 1, PEG_NUMBER - STARTPEG - ENDPEG, ENDPEG);
        }
    }
    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
       final int STARTPEG = 1;      //constants changed to capitals
        final int ENDPEG = 3;

        System.out.println("Tower of Hanoi");

        // input
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nHow many disks do you want?: ");

        try {
            int nOfDisks = userInput.nextInt();
            System.out.println();
            if (nOfDisks > 0) {
                // process
                towerOfHanoi(nOfDisks, STARTPEG, ENDPEG);
            } else {
                System.out.println("\nPlease enter a positive integer");
            }
        } catch (Exception ex) {
            System.err.print("\nThis is not an integer");
        }

        System.out.println("\nDone.");
    }
}
