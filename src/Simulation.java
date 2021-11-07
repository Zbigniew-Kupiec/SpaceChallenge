import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Simulation {
    public ArrayList<Item> item;
    public ArrayList<Rocket> rocketsU1;
    public ArrayList<Rocket> rocketsU2;
    public boolean hasLand = true;
    public File phaseOneFile = new File("src\\phase-1.txt");
    public File phaseTwoFile = new File("src\\phase-2.txt");

    public ArrayList<Item> loadItems(int start) throws FileNotFoundException {
        switch (start) {
            case 1 -> {
                System.out.println("PHASE 1 LOAD...");
                loadItemsPhases(phaseOneFile);
                System.out.println("PHASE 1 COMPLETED");
            }
            case 2 -> {
                System.out.println("PHASE 2 LOAD...");
                loadItemsPhases(phaseTwoFile);
                System.out.println("PHASE 2 COMPLETED" + "\n");
            }
        }
        return item;
    }

    @SuppressWarnings("ConditionalBreakInInfiniteLoop")
    private void loadItemsPhases(File file) throws FileNotFoundException {
        item = new ArrayList<>();
        Scanner scanFile = new Scanner(file);
        while (true) {
            if (!scanFile.hasNextLine()) break;
            String s = scanFile.nextLine();
            String[] separateStrings = s.split("=");
            Item itemOne = new Item(separateStrings[0], Integer.parseInt(separateStrings[1]));
            item.add(itemOne);
        }
    }

    public ArrayList<Rocket> loadU1(List<Item> itemU1) {
        System.out.println("U1 LOAD...");
        rocketsU1 = new ArrayList<>();
        Rocket rocket = new U1();
        Iterator<Item> iterator = itemU1.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (rocket.canCarry(item)) {
                rocketsU1.add(rocket);
                rocket = new U1();
                System.out.println("ROCKET U1 CREATED");
            }
            rocket.carry(item);
            if(!iterator.hasNext())
                rocketsU1.add(rocket);
        }
        return rocketsU1;
    }
    public ArrayList<Rocket> loadU2(List<Item> itemU2) {
        System.out.println("U2 LOAD...");
        rocketsU2 = new ArrayList<>();
        Rocket rocket = new U2();
        Iterator<Item> iterator = itemU2.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (rocket.canCarry(item)) {
                rocketsU2.add(rocket);
                rocket = new U2();
                System.out.println("ROCKET U2 CREATED");
            }
            rocket.carry(item);
            if(!iterator.hasNext())
                rocketsU2.add(rocket);
        }
        return rocketsU2;
    }
    public void runSimulation(@NotNull ArrayList<Rocket> rocketTo, int i) {
        rocketTo.forEach(rocket -> {
            while (rocket.launch()) launchSimulate(i);
            while (!rocket.land()) {
                while (rocket.launch()) {
                    launchSimulate(i);
                }
                landSimulate(i);
            }
        });
    }

    private void landSimulate(int i) {
        switch (i) {
            case 1 -> {
                int count = U1.getRocketCountU1();
                count++;
                U1.setRocketCountU1(count);
            }
            case 2 -> {
                int count = U2.getRocketCountU2();
                count++;
                U2.setRocketCountU2(count);
            }
        }
        hasLand = false;
    }

    private void launchSimulate(int i) {
        if(i == 1) {
            int countOne = U1.getRocketCountU1();
            countOne++;
            U1.setRocketCountU1(countOne);
        } else {
            int countOne = U2.getRocketCountU2();
            countOne++;
            U2.setRocketCountU2(countOne);
        }
    }

}
