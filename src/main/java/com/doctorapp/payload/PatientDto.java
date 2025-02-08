package com.doctorapp.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PatientDto {
    private Long id;

    private String name;

    private String mobile;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String emailId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String role;
}
