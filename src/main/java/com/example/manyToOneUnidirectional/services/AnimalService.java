package com.example.manyToOneUnidirectional.services;

import com.example.manyToOneUnidirectional.dto.AnimalDTO;
import com.example.manyToOneUnidirectional.entities.Animal;
import com.example.manyToOneUnidirectional.entities.Client;
import com.example.manyToOneUnidirectional.repositories.AnimalRepository;
import com.example.manyToOneUnidirectional.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public AnimalDTO insert(AnimalDTO dto){
        Animal animal = new Animal();
        animal.setName(dto.getName());
        animal.setAge(dto.getAge());

        Client client = clientRepository.getReferenceById(dto.getClient().getId());

        animal.setClient(client);

        animal = animalRepository.save(animal);

        return new AnimalDTO(animal);
    }

    @Transactional
    public AnimalDTO update(Long id, AnimalDTO dto){

        Animal animal = animalRepository.getReferenceById(id);
        animal.setName(dto.getName());
        animal.setAge(dto.getAge());

        animal = animalRepository.save(animal);

        return new AnimalDTO(animal);
    }

    @Transactional(readOnly = true)
    public AnimalDTO findById(Long id){

        Animal animal = animalRepository.findById(id).get();

        return new AnimalDTO(animal);
    }

    @Transactional(readOnly = true)
    public List<AnimalDTO> findAll(){

        List<Animal> animals = animalRepository.findAll();

        return animals.stream().map(animal -> new AnimalDTO(animal)).collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        animalRepository.deleteById(id);
    }
}
