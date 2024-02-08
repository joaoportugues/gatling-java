package com.example.configurations;

import com.example.requests.Requests;
import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;

public class ScenarioConfiguration {
    public static ScenarioBuilder getScenario() {
        return scenario("BasicSimulation")
                .group("Group name").on(
                        exec(
                                Requests.search,
                                Requests.browse,
                                Requests.edit
                        )
                );
    }
}
