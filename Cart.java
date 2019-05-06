public class Cart {
    public String screen;
    public int screenPrice;
    public String ram;
    public int ramPrice;
    public String hdd;
    public int hddPrice;
    public String processor;
    public int processorPrice;
    public int basePrice;
    public int unitPrice;

    public Cart(String screen, int screenPrice, String ram, int ramPrice,
        String hdd, int hddPrice, String processor, int processorPrice, int unitPrice, int basePrice) {
        this.screen = screen;
        this.screenPrice = screenPrice;
        this.ram = ram;
        this.ramPrice = ramPrice;
        this.hdd = hdd;
        this.hddPrice = hddPrice;
        this.processor = processor;
        this.processorPrice = processorPrice;
        this.unitPrice = unitPrice;
        this.basePrice = basePrice;
    }
}