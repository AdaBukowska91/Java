package com.epam.adrianna_bukowska.core_layer.api_operators;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Add class")
class AddTest {

    private final WireMockServer server = new WireMockServer(WireMockConfiguration.wireMockConfig().dynamicPort());
    private ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();

    @BeforeEach
    public void testPrep() {
        server.start();
        mockResponse.withHeader("Content-Type", "text/html; charset=utf-8")
                .withBody("<html>\n" + "  <body>5</body>\n" + "</html>");
        server.stubFor(WireMock.get("/api.mathjs.org/v4/?expr=2%2B3").willReturn(mockResponse));
    }

    @DisplayName("Test operate method - add, using RESTful API Calculator")
    @Test
    void testOperateApiAdd() {
        String endpoint = "http://localhost:" + server.port() + "/api.mathjs.org/v4/";
        Add add = new Add(endpoint);
        assertEquals(5.0, add.operate(2, 3));
    }

    @AfterEach
    public void teardown() {
        if (server != null && server.isRunning()) {
            server.shutdownServer();
        }
    }
}