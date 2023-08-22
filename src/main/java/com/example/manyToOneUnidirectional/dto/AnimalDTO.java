package com.example.manyToOneUnidirectional.dto;

import com.example.manyToOneUnidirectional.entities.Animal;

public class AnimalDTO {
    private Long id;
    private String name;
    private Integer age;
    private ClientMinDTO client;

    public AnimalDTO(Long id, String name, Integer age, ClientMinDTO client) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.client = client;
    }

    public AnimalDTO(Animal entity) {
        id = entity.getId();
        name = entity.getName();
        age = entity.getAge();
        client = new ClientMinDTO(entity.getClient());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public ClientMinDTO getClient() {
        return client;
    }
}
