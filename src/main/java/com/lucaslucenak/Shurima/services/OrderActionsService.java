package com.lucaslucenak.Shurima.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class OrderActionsService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${ifood.credentials.merchantApiHost}")
    private String merchantApiHost;

    @Value("${ifood.credentials.grantType}")
    private String grantType;

    @Value("${ifood.credentials.clientId}")
    private String clientId;

    @Value("${ifood.credentials.clientSecret}")
    private String clientSecret;


    public Void confirmOrder(UUID orderId, String accessToken) {
        String url = merchantApiHost + "/order/v1.0/orders/" + orderId.toString() + "/confirm";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessToken);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Void.class);

        return response.getBody();
    }

    public Void startOrderPreparation(UUID orderId, String accessToken) {
        String url = merchantApiHost + "/order/v1.0/orders/" + orderId.toString() + "/startPreparation";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessToken);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Void.class);

        return response.getBody();
    }

    public Void orderReadyToPickup(UUID orderId, String accessToken) {
        String url = merchantApiHost + "/order/v1.0/orders/" + orderId.toString() + "/readyToPickup";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessToken);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Void.class);

        return response.getBody();
    }

    public Void dispatchOrder(UUID orderId, String accessToken) {
        String url = merchantApiHost + "/order/v1.0/orders/" + orderId.toString() + "/dispatch";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessToken);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Void.class);

        return response.getBody();
    }
}
