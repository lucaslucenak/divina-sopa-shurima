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

    @Autowired
    private AuthenticationService authenticationService;

    @Value("${ifood.credentials.merchantApiHost}")
    private String merchantApiHost;

    @Value("${ifood.credentials.grantType}")
    private String grantType;

    @Value("${ifood.credentials.clientId}")
    private String clientId;

    @Value("${ifood.credentials.clientSecret}")
    private String clientSecret;

    private String accessToken;

    public List<Object> getOrderEventsPolling() {
        String url = merchantApiHost + "/order/v1.0/events:polling";
        accessToken = authenticationService.getNewSession().getAccessToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ParameterizedTypeReference<List<Object>> responseType = new ParameterizedTypeReference<List<Object>>() {};

        ResponseEntity<List<Object>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, responseType);

        return response.getBody();
    }
}
