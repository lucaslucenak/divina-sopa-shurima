package com.lucaslucenak.Shurima.services;

import com.lucaslucenak.Shurima.entities.OrderEventsPollingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderEventsService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${ifood.credentials.merchantApiHost}")
    private String merchantApiHost;

    @Value("${ifood.credentials.clientId}")
    private String clientId;

    @Value("${ifood.credentials.clientSecret}")
    private String clientSecret;


    public List<Object> getOrderEventsPolling(String accessToken) {
        String url = merchantApiHost + "/order/v1.0/events:polling";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessToken);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ParameterizedTypeReference<List<Object>> responseType = new ParameterizedTypeReference<>() {};

        ResponseEntity<List<Object>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, responseType);

        return response.getBody();
    }

    public Void orderEventsAcknowledgment(List<Object> acknowledgments, String accessToken) {
        String url = merchantApiHost + "/order/v1.0/events/acknowledgment";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessToken);

        HttpEntity<List<Object>> httpEntity = new HttpEntity<>(acknowledgments, headers);
        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Void.class);
        return response.getBody();

    }
}
