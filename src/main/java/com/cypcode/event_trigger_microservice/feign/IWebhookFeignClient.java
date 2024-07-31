package com.cypcode.event_trigger_microservice.feign;

import com.cypcode.event_trigger_microservice.domain.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "webhook", url = "http://localhost:8090/api")
public interface IWebhookFeignClient {
    @PostMapping(value = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    ResponseEntity<String> createNewEmployee(@RequestBody EmployeeDTO payload);
}
