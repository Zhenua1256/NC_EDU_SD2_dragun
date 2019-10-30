package com.netcraker.dragun.service;

import com.netcraker.dragun.model.DataUser;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class DataUserService {
    private RestTemplate restTemplate;
    @Value("${backend.url}")
    private String backendURL;

    public DataUserService (RestTemplateBuilder builder){
        this.restTemplate = builder.build();
    }
    public DataUser get(Long id) {
        return restTemplate.getForObject(backendURL+"datausers/"+id, DataUser.class);
    }
    public List<DataUser> getAll() {
        return Arrays.asList(restTemplate.getForObject(backendURL+"datausers/", DataUser[].class));
    }
    public DataUser create(DataUser dataUser) {
        return restTemplate.postForObject(backendURL+"datausers/", dataUser, DataUser.class);
    }

    public void update(DataUser dataUser, Long id) {
        restTemplate.put(backendURL+"datausers/"+id, dataUser);
    }

    public void delete(Long id) {
        restTemplate.delete(backendURL+"datausers/"+id);
    }
}
