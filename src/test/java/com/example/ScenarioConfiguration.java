package com.example;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class ScenarioConfiguration {
    public static ScenarioBuilder getScenario() {
        return scenario("BasicSimulation")
                .exec(http("request_1")
                        .get("/"))
                .pause(5);
    }
}
