package com.cypcode.event_trigger_microservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDTO implements Serializable {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
}