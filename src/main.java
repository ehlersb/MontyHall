import java.util.Scanner;

/**
 * Created by Benjamin Ehlers on 3/2/2019.
 */
public class main {

    public static void main(String[] args) {
        String input;
        System.out.println("Enter the number of simulations, the switch percentage (0-100), and the number of doors. Defaults are 1000, 100, 3, respectively.");
        System.out.println("Enter '!' to quit.");
        while(true) {
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine();
            if(input.equals("!")) break;
            Scanner lineScan = new Scanner(input);
            int numSimulations = 1000;
            int switchPercentage = 100;
            int numDoors = 3;
            if(lineScan.hasNext()) numSimulations = Integer.parseInt(lineScan.next());
            if(lineScan.hasNext()) switchPercentage = Integer.parseInt(lineScan.next());
            if(lineScan.hasNext()) numDoors = Integer.parseInt(lineScan.next());
            MontyHall mh = new MontyHall(numSimulations, switchPercentage, numDoors);
            mh.runSimulation();
        }
    }
}
