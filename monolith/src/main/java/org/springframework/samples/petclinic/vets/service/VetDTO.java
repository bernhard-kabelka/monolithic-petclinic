package org.springframework.samples.petclinic.vets.service;

import java.util.List;

public class VetDTO {

    private String firstName;

    private String lastName;
    
    private List<SpecialtyDTO> specialties;

	private Integer id;
    
    public VetDTO(Integer id, String firstName, String lastName, List<SpecialtyDTO> specialties) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialties = specialties;
	}
    
    public Integer getId() {
		return id;
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
