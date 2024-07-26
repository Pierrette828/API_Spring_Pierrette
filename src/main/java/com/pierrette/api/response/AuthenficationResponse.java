package com.pierrette.api.response;

import com.pierrette.api.entities.Operateur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AuthenficationResponse {
    private String token;
    private Operateur operateur;
}
