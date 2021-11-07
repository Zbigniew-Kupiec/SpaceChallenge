import java.util.Random;

public class U2 extends Rocket {
    private static int rocketCountU2;
    private static final int cost = 120000000;

    public U2() {
        this(0);
    }
    @SuppressWarnings("SpellCheckingInspection")
    public U2(int lastWght) {
        int maxWeight = 11000;
        setMaxWeight(maxWeight);
        setCost(cost);
        int weight = 18000;
        setWeight(weight);
        setCurWeight(lastWght);
        rocketCountU2++;
        System.out.println("_____________________________________________");
    }
    public static int getRocketCountU2() {
        return rocketCountU2;
    }
    public static void setRocketCountU2(int rocketCountU2) {
        U2.rocketCountU2 = rocketCountU2;
    }
    @Override
    public boolean launch() {
        System.out.println("\n " + " ^^^ LAUNCH ^^^");
        double randomNr = new Random().nextDouble();
        double launchExp = 0.04 * (getTotalWgt() / getMaxWeight());
        System.out.println("CARGO : " + getCurWeight());
        if (launchExp >= randomNr) {
            System.out.println("EXPLODE U2 !!! " + "\n" + "... SEND NEW ROCKET, BECAUSE U2 EXPLODED ... ");
            return true;
        } else {
            System.out.println("SUCCESSFUL START U2");
            return false;
        }
    }
    @Override
    public boolean land() {
        System.out.println("\n" + "___ LANDING ___");
        double randomNr = new Random().nextDouble();
        double landCrash = 0.02 * (getTotalWgt() / getMaxWeight());
        if (landCrash >= randomNr) {
            System.out.println("CRASHED U2 !!! " + "\n" +  "... SEND NEW ROCKET, BECAUSE U2 EXPLODED ... ");
            return false;
        } else {
            System.out.println("SUCCESSFUL LAND U2");
            return true;
        }
    }
    public static long getTotalCost() {
        return (long) getRocketCountU2() * cost;
    }
}
