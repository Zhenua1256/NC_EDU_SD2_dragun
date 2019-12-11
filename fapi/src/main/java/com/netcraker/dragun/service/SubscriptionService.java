package com.netcraker.dragun.service;

import com.netcraker.dragun.model.Subscription;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SubscriptionService {
    private RestTemplate restTemplate;
    @Value("${backend.url}")
    private String backendURL;
    public SubscriptionService(RestTemplateBuilder builder){
        this.restTemplate = builder.build();
    }
    public Subscription get(Long id) {
        return restTemplate.getForObject(backendURL+"subscriptions/"+id, Subscription.class);
    }
    public List<Subscription> getAll() {
        return Arrays.asList(restTemplate.getForObject(backendURL+"subscriptions/", Subscription[].class));
    }
    public Subscription create(Subscription subscription) {
        return restTemplate.postForObject(backendURL+"subscriptions/", subscription, Subscription.class);
    }
    public Subscription unSubscribe (Long id) {
        return restTemplate.getForObject(backendURL + "subscriptions/unsubscribe/" + id, Subscription.class);
    }
    public Subscription onSubscribe (Long id) {
        return restTemplate.getForObject(backendURL + "subscriptions/onsubscribe/" + id, Subscription.class);
    }
    public List<Subscription> getSubscriptionUser(Long id){
        return Arrays.asList(restTemplate.getForObject(backendURL + "subscriptions/user/" + id, Subscription[].class));
    }
    public void update(Subscription subscription, Long id) {
        restTemplate.put(backendURL+"subscriptions/"+id, subscription);
    }

    public void delete(Long id) {
        restTemplate.delete(backendURL+"subscriptions/"+id);
    }
}
