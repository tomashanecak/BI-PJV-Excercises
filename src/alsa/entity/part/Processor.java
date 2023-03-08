package alsa.entity.part;

public class Processor extends ComputerPart{
    private final ProcessorSpeed speed;

    public Processor(ProcessorSpeed speed) {
        this.speed = speed;
    }

    public ProcessorSpeed getSpeed() {
        return speed;
    }
}
