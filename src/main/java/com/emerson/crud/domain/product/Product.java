package com.emerson.crud.domain.product;

import jakarta.persistence.*;
import lombok.*;

//@Table Especifica a tabela primária da entidade anotada.
@Table(name = "product")
//@Entity Especifica que a classe é uma entidade. Esta anotação é aplicada à classe de entidade
@Entity(name = "product")
// @Getter @Setter Coloque qualquer campo para fazer o lombok construir um getter padrão.
//A documentação completa pode ser encontrada na página de recursos do projeto lombok para @Getter e @Setter .
@Getter
@Setter
//@AllArgsConstructor Gera um construtor com todos os argumentos. Um construtor all-args requer um argumento para cada campo da classe.
//A documentação completa pode ser encontrada na página de recursos do projeto lombok para @Constructor .
@AllArgsConstructor
//@NoArgsConstructor Gera um construtor sem argumentos. Irá gerar uma mensagem de erro se tal construtor não puder ser escrito devido à existência de campos finais.
//A documentação completa pode ser encontrada na página de recursos do projeto lombok para @Constructor .
@NoArgsConstructor
//@EqualsAndHashCode Gera implementações para os métodos equals e hashCode herdados por todos os objetos, com base nos campos relevantes.
@EqualsAndHashCode(of = "id")
public class Product {
    //@Id Especifica a chave primária de uma entidade.
    //@GeneratedValue Dispõe sobre a especificação de estratégias de geração de valores de chaves primárias.
    //UUID Indica que o provedor de persistência deve atribuir chaves primárias para a entidade gerando um identificador universalmente exclusivo RFC 4122.

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer price_in_cents;
    private Boolean active;

    public Product(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
        this.active = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice_in_cents() {
        return price_in_cents;
    }

    public void setPrice_in_cents(Integer price_in_cents) {
        this.price_in_cents = price_in_cents;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
