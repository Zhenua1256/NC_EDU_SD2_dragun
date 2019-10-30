package com.netcraker.dragun.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.netcraker.dragun.model.Subcription;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SubcriptionService {
    private RestTemplate restTemplate;
    @Value("${backend.url")
    private String backendURL;
    public SubcriptionService (RestTemplateBuilder builder){
        this.restTemplate = builder.build();
    }
    public Subcription get (Long id){
        return restTemplate.getForObject(backendURL+"subcriptions/"+id, Subcription.class);
    }
    public List<Subcription> getAll(){
        return Arrays.asList(restTemplate.getForObject(backendURL+"subcribtions/", Subcription[].class));
    }
    public Subcription create (Subcription subcription){
        return restTemplate.postForObject(backendURL+"subcriptions/", subcription , Subcription.class);
    }
    public void update(Subcription subcription , Long id){
        restTemplate.put(backendURL+"subcriptions/"+id, subcription);
    }
    public void delete (Long id){
        restTemplate.delete(backendURL+"subcriptions/"+id);
    }
}
