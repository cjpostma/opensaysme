package org.cjpostma.opensaysme.manager;

import org.cjpostma.opensaysme.RaspberryPiOperator;

public class GarageOpener {

    private static RaspberryPiOperator raspberryPiOperator;

    public GarageOpener() {
        raspberryPiOperator = new RaspberryPiOperator();
    }

    public void operateGarageDoor() {

        raspberryPiOperator.fireGarageRelay();
    }
}
