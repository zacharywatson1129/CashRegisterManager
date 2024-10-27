package edu.tarleton.cashregistermanager.logic;

public class Laptop extends Computer {

    private final int screenSize; // screen diagonal in inches
    private final int batteryLife; // battery life in hours

    public int getScreenSize() {
        return screenSize;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    /*
     * Stored in text file like this:
     * ID,brand,name,ProcessorBrand,Processor name,ProcessorCores,ProcessorSpeed,storage GB,graphicsCard,price,screenSize
     */
    public Laptop(String ID, String brand, String name, int ram, Processor proc, int storage, String gc,
            double price, int screenSize,
            int battery) {
        super(ID, brand, name, price, proc, storage, gc, ram);
        this.screenSize = screenSize;
        this.batteryLife = battery;
    }

    @Override
    public String featuresFormat() {
        String output = "";
        StringBuilder builder = new StringBuilder();
        builder.append(
                String.format("\t%s %s Laptop:%n", brand, name));

        builder.append(
                String.format("\t\u2022 Powered by a %s-core %s %s processor, running at %.1f GHz max%n",
                        processor.getNumCores(), processor.getBrand(), processor.getName(), processor.getMaxSpeed()));
        builder.append(String.format("\t\u2022 %d GB RAM%n", ram));
        builder.append(String.format("\t\u2022 %s Storage%n", this.getStorage()));
        builder.append(String.format("\t\u2022 %s Graphics%n", gc));
        builder.append(String.format("\t\u2022 %d inch HD screen%n", screenSize));
        builder.append(String.format("\t\u2022 Long-lasting %d-hour battery%n", batteryLife));

        output = builder.toString();

        return output;
    }

    @Override
    public String descriptionFormat() {
        return String.format("%s %s, %d-inch", brand, name, screenSize);
    }

}
