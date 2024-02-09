package com.example.builders;

import com.example.requests.Requests;

import static io.gatling.javaapi.core.CoreDsl.*;

public class ScenarioBuilder {
    public static io.gatling.javaapi.core.ScenarioBuilder getScenario() {
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
