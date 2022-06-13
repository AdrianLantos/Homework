public class Bottle {


    private int totalCapacity;

    private int availableLiquid;
    private int emptyCapacity;
    private boolean open;

    public Bottle(int totalCapacitySet, boolean openState) {
        if (totalCapacitySet > 0) {
            this.totalCapacity = totalCapacitySet;
            this.availableLiquid = totalCapacitySet;

        } else {
            System.out.println("You bought an empty bottle");
        }
        this.open = openState;
    }


    public int getAvailableLiquid() {
        return availableLiquid;
    }

    public boolean hasMoreLiquid() {
        if (availableLiquid > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int emptyVolume() {
        int emptyVolume = this.emptyCapacity;
        return emptyVolume;
    }

    public void openBottle() {
        if (open) {
            System.out.println("Bottle is already open.");
        } else {
            open = true;
            System.out.println("Bottle has been opened");
        }
    }

    public void drink(int drunkenVolume) {
        if (this.availableLiquid == 0) {
            System.out.println("Bottle is empty");
        } else if (open == false) {
            System.out.println("Bottle is closed");
        } else if (drunkenVolume > this.availableLiquid) {
            System.out.println("You want to drink more than the bottle holds");
        } else {
            this.availableLiquid = this.availableLiquid - drunkenVolume;
            this.emptyCapacity = this.emptyCapacity + drunkenVolume;
            System.out.println("You have " + availableLiquid + " ml left in the bottle");
        }
    }

    public void closeBottle() {
        if (open) {
            open = false;
            System.out.println("Bottle closed");
        } else {
            System.out.println("Bottle is already closed");
        }
    }
}
