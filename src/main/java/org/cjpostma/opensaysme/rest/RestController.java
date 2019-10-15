package org.cjpostma.opensaysme.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cjpostma.opensaysme.manager.GarageOpener;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;
import spark.Service;

import static spark.Spark.post;


public class RestController {

    private static final Logger logger = LogManager.getLogger();
    private static final GarageOpener GARAGE_OPENER = new GarageOpener();
    private static spark.Service sparkService = null;

    public static void publish() {
        getSparkService().post("/open-garage", RestController::openGarageHandler);
    }

    private static Object openGarageHandler(Request req, Response res) {

        GARAGE_OPENER.operateGarageDoor();
        return "Well yeah, that happened";
    }

    private static Service getSparkService() {

        if (sparkService == null) {
            sparkService = spark.Service.ignite().threadPool(80, 20, 3000);
            sparkService.before(RestController::beforeFilter);
        }
        return sparkService;
    }

    private static Object beforeFilter(Request req, Response res) {

        if (!req.ip().startsWith("192.168.1.3") && !req.ip().startsWith("192.168.1.4")) {
            logger.error(() -> String.format("Somebody using ip %s is on to us", req.ip()));
            sparkService.halt(HttpStatus.FORBIDDEN_403);
        }
        return "";
    }

}
