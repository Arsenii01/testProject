package ru.musailov.symbols.gatlingTest;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class RequestSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol =
            http.baseUrl("http://localhost:8080")
                    .acceptHeader("application/json")
                    .contentTypeHeader("application/json");

    String requestBody = "{\"string\": \"Arseny was here\"}";

    ScenarioBuilder scn = scenario("many requests scenario")
            .exec(http("/main")
            .post("/main")
                    .body(StringBody(requestBody)).asJson()
                    .check(status().is(200)));


    {
        setUp(
                scn.injectOpen(rampUsers(30).during(30))
        ).protocols(httpProtocol);
    }
}
