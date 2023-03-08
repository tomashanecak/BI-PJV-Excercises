package alsa.entity.part;

public class Disk extends ComputerPart{
    private final int capacity;

    public Disk(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
