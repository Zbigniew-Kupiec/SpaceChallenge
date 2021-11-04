public class Rocket implements SpaceShip {
    public int cost;
    public int weight;
    public int maxWeight;
    public int curWeight;
    public double totalWgt = curWeight + weight;

    @Override
    public boolean launch() { return true; }
    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if(maxWeight >= (curWeight + item.getWeight()))
            return true;
        else
            System.out.println("You cannot wear an item : " + item.getName() + "\tWeight : " + item.getWeight());
        return false;
    }

    @Override
    public void carry(Item item) {
        System.out.println("Carrying Item : " + item.getName() + "\tWeight : " + item.getWeight());
        curWeight += item.getWeight();
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getTotalWgt() {
        totalWgt = getCurWeight() + getWeight();
        return totalWgt;
    }

    public int getCurWeight() {
        return curWeight;
    }

    public void setCurWeight(int curWeight) {
        this.curWeight = curWeight;
    }
}
