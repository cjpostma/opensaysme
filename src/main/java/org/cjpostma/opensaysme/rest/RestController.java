package org.cjpostma.opensaysme.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cjpostma.opensaysme.manager.GarageOpener;
import spark.Request;
import spark.Response;

import static spark.Spark.get;
import static spark.Spark.post;


public class RestController {

    private static final Logger logger = LogManager.getLogger();
    private static final GarageOpener GARAGE_OPENER = new GarageOpener();

    private RestController() {

    }

    public static void publish() {
        post("/open-garage", RestController::openGarageHandler);
    }

    private static Object openGarageHandler(Request req, Response res) {

        GARAGE_OPENER.operateGarageDoor();
        return "Well yeah, that happened";
    }
}
