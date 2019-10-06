package org.cjpostma.opensaysme;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;

public class RaspberryPiOperator {
    final static GpioController gpio = GpioFactory.getInstance();
    private final GpioPinDigitalOutput garageRelay;

    public RaspberryPiOperator() {
        this.garageRelay = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24,             // PIN NUMBER
                "GarageRelay"); // PIN RESISTANCE (optional)
    }

    public void fireGarageRelay() {

        this.garageRelay.pulse(1000);
    }
}
