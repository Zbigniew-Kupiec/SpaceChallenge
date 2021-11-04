public class U1 extends Rocket {
    private static int rocketCountU1;
    private static final int cost = 100000000;
    private final int weight = 10000;
    private final int maxWeight = 8000;
    private double launchExp;
    private double landCrash;

    public U1() {
        this(0);
    }

    public U1(int lastWght) {
        setMaxWeight(maxWeight);
        setCost(cost);
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
}
