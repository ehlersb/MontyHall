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
        for(int i = 0; i < numSimulations; i++) {

        }
    }
}
