interface Device {
    void turnOn();
    void turnOff();
    void setChannel(int channel);
}

class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("Turning on the TV");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the TV");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Setting TV channel to " + channel);
    }
}

class Radio implements Device {
    @Override
    public void turnOn() {
        System.out.println("Turning on the Radio");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the Radio");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Setting Radio channel to " + channel);
    }
}

 class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }

    public void setChannel(int channel) {
        device.setChannel(channel);
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        TV tv = new TV();
        RemoteControl remoteTV = new RemoteControl(tv);

        Radio radio = new Radio();
        RemoteControl remoteRadio = new RemoteControl(radio);

        remoteTV.turnOn();
        remoteTV.setChannel(5);
        remoteTV.turnOff();

        remoteRadio.turnOn();
        remoteRadio.setChannel(1025);
        remoteRadio.turnOff();
    }
}
