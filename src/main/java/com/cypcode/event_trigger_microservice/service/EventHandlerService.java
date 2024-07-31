package com.cypcode.event_trigger_microservice.service;

import com.cypcode.event_trigger_microservice.domain.EmployeeDTO;
import com.cypcode.event_trigger_microservice.domain.EventDTO;
import com.cypcode.event_trigger_microservice.feign.IWebhookFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventHandlerService {
    @Autowired
    private IWebhookFeignClient webhookFeignClient;

    public boolean process(EventDTO event) {
        if (event.getName().equals("add")) {
            EmployeeDTO payload = EmployeeDTO.builder()
                    .firstname("web")
                    .lastname("hook")
                    .phone("+440090998988")
                    .email("webhook@cypcode.com")
                    .build();
            ResponseEntity<String> response = webhookFeignClient.createNewEmployee(payload);
            if(response.getStatusCode() == HttpStatus.OK){
               return true;
            }
        }
        return false;
    }
}
