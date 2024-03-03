package com.emerson.crud.infra;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

//@JsonAutoDetect Anotação de classe que pode ser usada para definir quais tipos de métodos devem ser detectados por autodetecção e com qual nível mínimo de acesso. Detecção automática significa usar convenções de nomes e/ou modelos de assinatura para encontrar métodos a serem usados para vinculação de dados.
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ExceptionDTO {
    String message;
    Integer status;
    public ExceptionDTO(String message, Integer status){

        this.message = message;
        this.status = status;
    }
}