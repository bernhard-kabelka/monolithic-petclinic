package org.springframework.samples.petclinic.vets;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.vets.service.VetDTO;
import org.springframework.web.client.RestTemplate;

import com.github.tomakehurst.wiremock.WireMockServer;

public class VetsClientTest {

    private final WireMockServer wireMock = new WireMockServer(options().port(8089));

    @BeforeEach
    void startWireMock() {
        wireMock.start();
    }

    @AfterEach
    void stopWireMock() {
        wireMock.stop();
    }

    @Test
    void how_to_stub_a_server_with_wiremock() {
        wireMock.stubFor(get(urlEqualTo("/demo"))
            .willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBody("[{\"firstName\":\"James\",\"lastName\":\"Carter\",\"specialties\":[],\"id\":1,\"nrOfSpecialties\":0},{\"firstName\":\"Helen\",\"lastName\":\"Leary\",\"specialties\":[{\"name\":\"radiology\"}],\"id\":2,\"nrOfSpecialties\":1},{\"firstName\":\"Linda\",\"lastName\":\"Douglas\",\"specialties\":[{\"name\":\"dentistry\"},{\"name\":\"surgery\"}],\"id\":3,\"nrOfSpecialties\":2},{\"firstName\":\"Rafael\",\"lastName\":\"Ortega\",\"specialties\":[{\"name\":\"surgery\"}],\"id\":4,\"nrOfSpecialties\":1},{\"firstName\":\"Henry\",\"lastName\":\"Stevens\",\"specialties\":[{\"name\":\"radiology\"}],\"id\":5,\"nrOfSpecialties\":1},{\"firstName\":\"Sharon\",\"lastName\":\"Jenkins\",\"specialties\":[],\"id\":6,\"nrOfSpecialties\":0}]")));

        VetDTO[] result = new RestTemplate().getForObject("http://localhost:8089/demo", VetDTO[].class);

        assertThat(result).hasSize(6);
    }
}