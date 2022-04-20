package org.springframework.samples.petclinic.vets.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VetClient {

    public VetClient() {
        // Nothing to do
    }

    public Collection<VetDTO> allVets() {
		VetDTO[] result = new RestTemplate().getForObject("http://localhost:8089/vets/all", VetDTO[].class);
		return Arrays.<VetDTO>asList(result);
    }
}
