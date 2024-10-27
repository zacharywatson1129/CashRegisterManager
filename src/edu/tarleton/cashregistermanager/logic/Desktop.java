package edu.tarleton.cashregistermanager.logic;

public class Desktop extends Computer {

    private final boolean includesMonitor;
    private final boolean includesSpeakers;
    private final boolean includesWifiAndBluetooth;
    private final boolean hasDVDDrive;

    public boolean isIncludesMonitor() {
        return includesMonitor;
    }

    public boolean isIncludesSpeakers() {
        return includesSpeakers;
    }

    public boolean isIncludesWifiAndBluetooth() {
        return includesWifiAndBluetooth;
    }

    public boolean isHasDVDDrive() {
        return hasDVDDrive;
    }
    
    /*
     * Stored in text file like this:
     * ID,brand,name,ProcessorBrand,ProcessorName,ProcessorCores,ProcessorMaxSpeed,StorageInGB,GraphicsCard,Price,Monitor,Speakers,WifiBT,DVD
     */
    public Desktop(String ID, String brand, String name, int ram, int storage, 
            Processor proc, String graphics, 
            double price, boolean includesMonitor,
                    boolean includesSpeakers, boolean includesWifiAndBluetooth, boolean hasDvdDrive) {
        super(ID, brand, name, price, proc, storage, graphics, ram); 
        // Computer(String ID, String brand, String name, double price, Processor proc, int storage, String gc, int ram) 
        this.includesMonitor = includesMonitor;
        this.includesSpeakers = includesSpeakers;
        this.includesWifiAndBluetooth = includesWifiAndBluetooth;
        this.hasDVDDrive = hasDvdDrive;
    }

    

    @Override
    public String featuresFormat() {
                String output = "";
        StringBuilder builder = new StringBuilder();
        builder.append(
                String.format("\t%s %s Desktop:%n", brand, name));

        builder.append(
                String.format("\t\u2022 Powered by a %s-core %s %s processor, running at %.1f GHz max%n",
                        processor.getNumCores(), processor.getBrand(), processor.getName(), processor.getMaxSpeed()));
        builder.append(String.format("\t\u2022 %d GB RAM%n", ram));
        builder.append(String.format("\t\u2022 %s Storage%n", this.getStorage()));
        builder.append(String.format("\t\u2022 %s Graphics%n", gc));
        if (includesMonitor) {
            builder.append(String.format("\t\u2022 Includes standard 24 inch monitor%n"));
        }
        if (includesSpeakers) {
            builder.append(String.format("\t\u2022 Standard high quality speakers included%n"));
        }
        if (includesWifiAndBluetooth) {
            builder.append(String.format("\t\u2022 Includes WiFi and Bluetooth for wireless connectivity%n"));
        }
        if (hasDVDDrive) {
            builder.append(String.format("\t\u2022 Standard RW DVD Drive included%n"));
        }

        output = builder.toString();

        return output;
    }

    @Override
    public String descriptionFormat() {
        return String.format("%s %s Desktop Computer", brand, name);
    }

}
