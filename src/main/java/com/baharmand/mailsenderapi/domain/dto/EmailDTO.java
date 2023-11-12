package com.baharmand.mailsenderapi.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

//Data
@Getter
@Setter
@Generated
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class EmailDTO {

    @NotBlank(message = "To fields cannot be blank")
    @Email(message = "To field must be a valid email address")
    private String to;

    @NotBlank(message = "Subject field must not be blank")
    private String subject;

    @NotBlank(message = "HTML field must not be blank")
    private String html;

    @Positive(message = "Type should be a positive number")
    private Integer type;

}
