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
        this.switchPercentage = 100;
        this.numDoors = 3;

    }

    public MontyHall() {
        this.numSimulations = 1000;
        this.switchPercentage = 100;
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
            pickedDoor = switchDoor(pickedDoor, winningDoor);
            if(pickedDoor == winningDoor) numWins++;
            else numLosses++;
        }
        for(long i = 0; i < numNotSwitchSims; i++) {
            int winningDoor = rand.nextInt(numDoors) + 1;
            int pickedDoor = rand.nextInt(numDoors) + 1;
            if(pickedDoor == winningDoor) numWins++;
            else numLosses++;
        }
        double percentageWins = (numWins + 0.0) / (numSimulations + 0.0) * 100.0;
        System.out.println("Win percentage: " + percentageWins + "%");
    }
    private int switchDoor(int pickedDoor, int winningDoor) {
        Random rand = new Random();
        int doorToSwitchTo = (rand.nextInt(numDoors) + 1);
        int doorToReveal = (rand.nextInt(numDoors) + 1);
        while(doorToReveal == pickedDoor || doorToReveal == winningDoor)
            doorToReveal = (rand.nextInt(numDoors) + 1);
        while(doorToSwitchTo  == pickedDoor || doorToSwitchTo == doorToReveal)
            doorToSwitchTo = (rand.nextInt(numDoors) + 1);
        return doorToSwitchTo;
    }
}
