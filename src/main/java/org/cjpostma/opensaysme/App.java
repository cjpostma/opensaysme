package org.cjpostma.opensaysme;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cjpostma.opensaysme.rest.RestController;

/**
 * Hello world!
 */
public class App {

private static final Logger logger = LogManager.getLogger();

    public static void main(String... args) {

        logger.info("Hello World!");
        RestController.publish();
        while(true);
    }
}
