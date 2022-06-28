package com.epam.adrianna_bukowska.core_layer.api_operators;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Divide class")
class DivideTest {

    private final WireMockServer server = new WireMockServer(WireMockConfiguration.wireMockConfig().dynamicPort());
    private ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();

    @BeforeEach
    public void testPrep() {
        server.start();
    }

    @Nested
    class OperateApiDivide {

        @BeforeEach
        public void testPrep() {
            mockResponse.withHeader("Content-Type", "text/html; charset=utf-8")
                    .withBody("<html>\n" + "  <body>6</body>\n" + "</html>");
            server.stubFor(WireMock.get("/api.mathjs.org/v4/?expr=12%2F2").willReturn(mockResponse));
        }

        @DisplayName("Test operate method - divide, using RESTful API Calculator")
        @Test
        void testOperateApiDivide() {
            String endpoint = "http://localhost:" + server.port() + "/api.mathjs.org/v4/";
            Divide divide = new Divide(endpoint);
            assertEquals(6.0, divide.operate(12, 2));
        }
    }

    @Nested
    class OperateApiDivideByZero {

        @BeforeEach
        public void testPrep() {
            mockResponse.withHeader("Content-Type", "text/html; charset=utf-8")
                    .withBody("<html>\n" + "  <body>Infinity</body>\n" + "</html>");
            server.stubFor(WireMock.get("/api.mathjs.org/v4/?expr=5%2F0").willReturn(mockResponse));
        }

        @DisplayName("Test operate method - divide by zero, using RESTful API Calculator")
        @Test
        void testOperateApiDivideByZero() {
            String endpoint = "http://localhost:" + server.port() + "/api.mathjs.org/v4/";
            Divide divide = new Divide(endpoint);
            assertEquals(Double.POSITIVE_INFINITY, divide.operate(5, 0));
        }
    }

    @AfterEach
    public void teardown() {
        if (server != null && server.isRunning()) {
            server.shutdownServer();
        }
    }
}