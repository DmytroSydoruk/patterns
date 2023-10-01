"""Bridge"""


class RemoteControl:
    def __init__(self, device):
        self.device = device

    def turn_on(self):
        self.device.turn_on()

    def turn_off(self):
        self.device.turn_off()

    def set_channel(self, channel):
        self.device.set_channel(channel)


class Device:
    def turn_on(self):
        pass

    def turn_off(self):
        pass

    def set_channel(self, channel):
        pass


class TV(Device):
    def turn_on(self):
        print("Turning on the TV")

    def turn_off(self):
        print("Turning off the TV")

    def set_channel(self, channel):
        print(f"Setting TV channel to {channel}")


class Radio(Device):
    def turn_on(self):
        print("Turning on the Radio")

    def turn_off(self):
        print("Turning off the Radio")

    def set_channel(self, channel):
        print(f"Setting Radio channel to {channel}")


if __name__ == "__main__":
    tv = TV()
    remote_tv = RemoteControl(tv)

    radio = Radio()
    remote_radio = RemoteControl(radio)

    remote_tv.turn_on()
    remote_tv.set_channel(5)
    remote_tv.turn_off()

    remote_radio.turn_on()
    remote_radio.set_channel(102.5)
    remote_radio.turn_off()
