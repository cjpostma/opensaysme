package org.cjpostma.opensaysme;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RaspberryPiOperator {
    private static final GpioController gpio = GpioFactory.getInstance();
    private final GpioPinDigitalOutput garageRelay;
    private static final Logger logger = LogManager.getLogger();

    public RaspberryPiOperator() {
        this.garageRelay = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "GarageRelay", PinState.LOW);
    }

    public void fireGarageRelay() {
        logger.info("Firing pulse");
        this.garageRelay.pulse(2000);
    }
}
