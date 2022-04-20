package org.springframework.samples.petclinic.vets.service;

import org.springframework.samples.petclinic.vets.db.VetRepository;
import org.springframework.samples.petclinic.vets.model.Specialty;
import org.springframework.samples.petclinic.vets.model.Vet;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VetService {

    private final VetRepository vets;

    public VetService(VetRepository vets) {
        this.vets = vets;
    }

    public Collection<VetDTO> allVets() {
        return this.vets.findAll().stream()
        		.map(this::createVetDTO)
   		        .collect(Collectors.toList());
    }
    
	private VetDTO createVetDTO(Vet vet) {
		List<Specialty> specialties = vet.getSpecialties();
		return new VetDTO(vet.getFirstName(), vet.getLastName(), convertSpecialties(specialties));
	}

	private List<SpecialtyDTO> convertSpecialties(List<Specialty> specialties) {
		return specialties.stream()
				.map(this::createSpecialtyDTO)
				.collect(Collectors.toList());
	}

	private SpecialtyDTO createSpecialtyDTO(Specialty specialty) {
		return new SpecialtyDTO(specialty.getName());
	}
}
