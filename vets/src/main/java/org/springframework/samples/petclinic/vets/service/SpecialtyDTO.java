package org.springframework.samples.petclinic.vets.service;

public class SpecialtyDTO {

    private String name;
    
    public SpecialtyDTO(String name) {
		this.name = name;
	}
    
    public String getName() {
		return name;
	}
}
