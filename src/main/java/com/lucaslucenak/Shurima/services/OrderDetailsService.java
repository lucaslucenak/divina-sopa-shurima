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
public class OrderDetailsService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${ifood.credentials.merchantApiHost}")
    private String merchantApiHost;

    @Value("${ifood.credentials.clientId}")
    private String clientId;

    @Value("${ifood.credentials.clientSecret}")
    private String clientSecret;

    public Object getOrderDetails(UUID orderId, String accessToken) {
        String url = merchantApiHost + "/order/v1.0/orders/" + orderId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessToken);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Object.class);

        return response.getBody();
    }
}
