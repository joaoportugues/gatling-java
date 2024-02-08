package com.example.requests;

import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class Requests {

    public static ChainBuilder search =
            exec(http("Home")
                    .get("/"))
                    .pause(7)
                    .exec(http("Search")
                            .get("/computers?f=macbook"))
                    .pause(2)
                    .exec(http("Select")
                            .get("/computers/6"))
                    .pause(3);

    public static ChainBuilder browse =
            repeat(5, "n").on( // 1
                    exec(http("Page #{n}").get("/computers?p=#{n}")) // 2
                            .pause(1)
            );

    public static ChainBuilder edit =
            exec(http("Form").get("/computers/new"))
                    .pause(1)
                    .exec(http("Post")
                            .post("/computers")
                            .formParam("name", "computer xyz")
                            .check(status().is(session ->
                                    200 + java.util.concurrent.ThreadLocalRandom.current().nextInt(2) // 2
                            ))
                    );

}