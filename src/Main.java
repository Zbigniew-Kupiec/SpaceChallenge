import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final int phaseOne = 1;
        final int phaseTwo = 2;

        long costU1;
        long costU2;
        int rocketPhaseOne;
        int rocketPhaseTwo;
        ArrayList<Item> itemPhaseOne;
        ArrayList<Item> itemPhaseTwo;
        Simulation simulate = new Simulation();
        System.out.println("... LOAD ...");
        itemPhaseOne = simulate.loadItems(phaseOne);
        itemPhaseTwo = simulate.loadItems(phaseTwo);

        System.out.println("START SIMULATE FOR ROCKET U1" + "\n");
        System.out.println("--- SIMULATE PHASE 1 ---");
        simulate.runSimulation(simulate.loadU1(itemPhaseOne),1);
        System.out.println("--- SIMULATE COMPLETE ---" + "\n");
        rocketPhaseOne = U1.getRocketCountU1();
        System.out.println("ROCKET USED - PHASE 1 : " + rocketPhaseOne);
        System.out.println("--- SIMULATE PHASE 2 ---");
        simulate.runSimulation(simulate.loadU1(itemPhaseTwo),1);
        System.out.println("--- SIMULATE COMPLETE ---" + "\n");
        rocketPhaseTwo = U1.getRocketCountU1() - rocketPhaseOne;
        System.out.println("ROCKET USED - PHASE 2 : " + rocketPhaseTwo + "\n");
        System.out.println("TOTAL OF ROCKED USED : " + U1.getRocketCountU1());
        costU1 = totalCost(1);

        System.out.println("START SIMULATE FOR ROCKET U2" + "\n");
        System.out.println("--- SIMULATE PHASE 1 ---");
        simulate.runSimulation(simulate.loadU2(itemPhaseOne),2);
        System.out.println("--- SIMULATE COMPLETE ---" + "\n");
        rocketPhaseOne = U2.getRocketCountU2();
        System.out.println("ROCKET USED - PHASE 1 : " + rocketPhaseOne);
        System.out.println("--- SIMULATE PHASE 2 ---");
        simulate.runSimulation(simulate.loadU1(itemPhaseTwo),2);
        System.out.println("--- SIMULATE COMPLETE ---" + "\n");
        rocketPhaseTwo = U2.getRocketCountU2() - rocketPhaseOne;
        System.out.println("ROCKET USED - PHASE 2 : " + rocketPhaseTwo + "\n");
        System.out.println("TOTAL OF ROCKED USED : " + U2.getRocketCountU2());
        costU2 = totalCost(2);

        System.out.println("\n" + "TOTAL BUDGET FOR ROCKET U1 : " + costU1);
        System.out.println("TOTAL BUDGET FOR ROCKET U2 : " + costU2);

        System.out.println(costU1 > costU2 ? "USING ROCKET U2 IN THIS SIMULATE IS CHEAPER" : "USING ROCKET U1 IN THIS SIMULATE IS CHEAPER");

    }
    public static long totalCost(int i) {
        return (i == 1) ? U1.getTotalCost() : U2.getTotalCost();
    }
    
}
