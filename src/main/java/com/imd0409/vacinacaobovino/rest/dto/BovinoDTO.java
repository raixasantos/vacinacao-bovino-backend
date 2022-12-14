package com.imd0409.vacinacaobovino.rest.dto;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class BovinoDTO {
    private String nome;
    private LocalDate aniversario;
    private String sexo;
    private String cor;
    private Float peso;
    private Boolean chifre;
}