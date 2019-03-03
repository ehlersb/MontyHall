import java.util.Random;

/**
 * Created by Benjamin Ehlers on 3/2/2019.
 */
public class MontyHall {

    private int numSimulations;
    private int numDoors;
    private int switchPercentage; // 100 means you always switch

    public MontyHall(int numSimulations, int switchPercentage, int numDoors) {
        this.numSimulations = numSimulations;
        this.switchPercentage = switchPercentage;
        this.numDoors = numDoors;

    }

    public MontyHall(int numSimulations, int switchPercentage) {
        this.numSimulations = numSimulations;
        this.switchPercentage = switchPercentage;
        this.numDoors = 3;
    }

    public MontyHall(int numSimulations) {
        this.numSimulations = numSimulations;
        this.switchPercentage = 0;
        this.numDoors = 3;

    }

    public MontyHall() {
        this.numSimulations = 1000;
        this.switchPercentage = 0;
        this.numDoors = 3;

    }


    public void runSimulation() {
        Random rand = new Random();
        int numLosses = 0;
        int numWins = 0;
        long numSwitchSims = Math.round(numSimulations * (switchPercentage / 100.0));
        long numNotSwitchSims = numSimulations - numSwitchSims;
        for(long i = 0; i < numSwitchSims; i++) {
            int winningDoor = rand.nextInt(numDoors) + 1;
            int pickedDoor = rand.nextInt(numDoors) + 1;
            pickedDoor = switchDoor(winningDoor, pickedDoor);

        }
        for(long i = 0; i < numNotSwitchSims; i++) {
            int winningDoor = rand.nextInt(3) + 1;
            int pickedDoor = rand.nextInt(3) + 1;

        }
    }
    private int switchDoor(int winningDoor, int pickedDoor) {
        Random rand = new Random();
        int doorToSwitchTo = rand.nextInt(numDoors) + 1;
        while((doorToSwitchTo = rand.nextInt(numDoors) + 1) == winningDoor ||
                (doorToSwitchTo = rand.nextInt(numDoors) + 1) == pickedDoor);
        return doorToSwitchTo;
    }
}
