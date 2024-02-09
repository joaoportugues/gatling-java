package com.example.simulations;

import com.example.configurations.ProtocolConfiguration;
import com.example.builders.ScenarioBuilder;
import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

public class TestSimulation extends Simulation {
    private static final HttpProtocolBuilder httpProtocol = ProtocolConfiguration.getHttpProtocol();
    private static final io.gatling.javaapi.core.ScenarioBuilder scn = ScenarioBuilder.getScenario();

    {
        setUp(
                scn.injectOpen(atOnceUsers(1))
        ).protocols(httpProtocol);
    }
}
