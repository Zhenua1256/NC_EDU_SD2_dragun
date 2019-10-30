package com.netcraker.dragun.service;

import com.netcraker.dragun.model.DataUser;
import com.netcraker.dragun.model.SubcriptionTypes;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SubcriptionTypesService {
    private RestTemplate restTemplate;
    @Value("${backend.url}")
    private String backendURL;

    public SubcriptionTypesService (RestTemplateBuilder builder){
        this.restTemplate = builder.build();
    }
    public SubcriptionTypes get(Long id) {
        return restTemplate.getForObject(backendURL+"subcriptiontypes/"+id, SubcriptionTypes.class);
    }
    public List<SubcriptionTypes> getAll() {
        return Arrays.asList(restTemplate.getForObject(backendURL+"subcriptiontypes/", SubcriptionTypes[].class));
    }
    public SubcriptionTypes create(SubcriptionTypes subcriptionTypes) {
        return restTemplate.postForObject(backendURL+"subcriptiontypes/", subcriptionTypes, SubcriptionTypes.class);
    }

    public void update(SubcriptionTypes subcriptionTypes, Long id) {
        restTemplate.put(backendURL+"subcriptiontypes/"+id, subcriptionTypes);
    }

    public void delete(Long id) {
        restTemplate.delete(backendURL+"subcriptiontypes/"+id);
    }
}
