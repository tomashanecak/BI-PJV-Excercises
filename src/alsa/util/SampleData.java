package alsa.util;

import alsa.entity.Notebook;
import alsa.entity.NotebookCategory;
import alsa.entity.Television;
import alsa.entity.part.ComputerPart;
import alsa.entity.part.Disk;
import alsa.entity.part.Processor;
import alsa.entity.part.ProcessorSpeed;

public class SampleData {
    public final static Processor intel = new Processor(ProcessorSpeed.FAST);
    public final static Processor amd = new Processor(ProcessorSpeed.FAST);

    public final static Disk memory200GB = new Disk(200);
    public final static Disk memory500GB = new Disk(500);

    public final static Notebook lenovoE500 = new Notebook("Lenovo E500", 10000, 2, NotebookCategory.BASIC, new ComputerPart[]{intel, memory200GB});
    public final static Notebook hpBusinnesPlus = new Notebook("HP Business Plus", 40000, 5, NotebookCategory.PROFESSIONAL, new ComputerPart[]{amd, memory500GB});

    public final static Television samsungMediaPlus = new Television("Samsung Media Plus", 5000, 2);
}
