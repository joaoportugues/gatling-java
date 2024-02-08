package com.example;

import com.example.configurations.ProtocolConfiguration;
import com.example.configurations.ScenarioConfiguration;
import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

public class Runner extends Simulation {
    private static final HttpProtocolBuilder httpProtocol = ProtocolConfiguration.getHttpProtocol();
    private static final ScenarioBuilder scn = ScenarioConfiguration.getScenario();

    {
        setUp(
                scn.injectOpen(atOnceUsers(1))
        ).protocols(httpProtocol);
    }
}
