package org.springframework.samples.petclinic.vets.service;

import java.util.List;

public class VetDTO {

    private String firstName;

    private String lastName;
    
    private List<SpecialtyDTO> specialties;
    
    public VetDTO() {
		// Nothing to do
	}

    public VetDTO(String firstName, String lastName, List<SpecialtyDTO> specialties) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialties = specialties;
	}
    
    public String getFirstName() {
		return firstName;
	}
    
    public String getLastName() {
		return lastName;
	}
    
    public List<SpecialtyDTO> getSpecialties() {
		return specialties;
	}
    
    public int getNrOfSpecialties() {
        return specialties.size();
    }
}
