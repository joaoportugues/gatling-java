package com.example;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class Testing extends Simulation {
    private static final HttpProtocolBuilder httpProtocol = ProtocolConfiguration.getHttpProtocol();
    private static final ScenarioBuilder scn = ScenarioConfiguration.getScenario();

    {
        setUp(
                scn.injectOpen(atOnceUsers(1))
        ).protocols(httpProtocol);
    }
}
