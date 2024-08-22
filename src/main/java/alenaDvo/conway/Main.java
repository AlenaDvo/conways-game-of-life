package alenaDvo.conway;

import java.util.Scanner;

/*
Conway's Game of Life
Wikipedia: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
Instructions:
- Use the seed shown below the rules.

          X
         XX
          XX
- Draw the state on the screen, using X for alive cells and space for dead ones.
- Wait for the enter-key and draw the next state.
- Terminate the program upon pressing C.
*/

public class Main {
    public static void main(String[] args) {
//        create a grid with seed
        Grid grid = new Grid(10, 10);

//        print grid
        System.out.println("First grid: ");
        grid.print();

//        read user input (enter) and show next state
        Scanner scanner = new Scanner(System.in);
        String readString = scanner.nextLine();
        while (readString != null) {
            if (readString.isEmpty()) {
                grid = grid.getNextState();
                System.out.println("Next state: ");
                grid.print();
            }
            if (readString.equals("C")) {
                break;
            }
            readString = scanner.nextLine();
        }
    }
}