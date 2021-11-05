import java.util.Random;

public class U1 extends Rocket {
    private static int rocketCountU1;
    private static final int cost = 100000000;

    public U1() {
        this(0);
    }

    public U1(int lastWght) {
        int maxWeight = 8000;
        setMaxWeight(maxWeight);
        setCost(cost);
        int weight = 10000;
        setWeight(weight);
        setCurWeight(lastWght);
        rocketCountU1++;
        System.out.println("___________________________");
    }

    public static int getRocketCountU1() {
        return rocketCountU1;
    }
    public static void setRocketCountU1(int rocketCountU1) {
        U1.rocketCountU1 = rocketCountU1;
    }
    @Override
    public boolean launch() {
        System.out.println("\n " + " ^^^ LAUNCH ^^^");
        double randomNr = new Random().nextDouble();
        // double random = randomNr.nextDouble();
        double launchExp = 0.05 * (getTotalWgt() / getMaxWeight());
        System.out.println("CARGO : " + getCurWeight());
        if (launchExp >= randomNr) {
            System.out.println("EXPLODE U1 !!! " + "\n" + "... SEND NEW ROCKET, BECAUSE U1 EXPLODED ... ");
            return false;
        } else {
            System.out.println("SUCCESSFUL START U1");
            return true;
        }
    }
    @Override
    public boolean land() {
        System.out.println("\n" + "___ LANDING ___");
        double randomNr = new Random().nextDouble();
        // double random = randomNr.nextDouble();
        double landCrash = 0.01 * (getTotalWgt() / getMaxWeight());
        if (landCrash >= randomNr) {
            System.out.println("CRASHED U1 !!! " + "\n" +  "... SEND NEW ROCKET, BECAUSE U1 EXPLODED ... ");
            return false;
        } else {
            System.out.println("SUCCESSFUL LAND U1");
            return true;
        }
    }
    public static long getTotalCost() {
        return (long) getRocketCountU1() * cost;
    }
}
