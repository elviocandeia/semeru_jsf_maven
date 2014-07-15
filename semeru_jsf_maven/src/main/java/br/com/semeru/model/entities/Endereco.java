package br.com.semeru.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    
    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idEndereco")
    private Integer idEndereco;
    @Column(name = "bairro", length = 60, nullable = false)
    private String bairro;
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;
    @Column(name = "complemento", length = 20)
    private String complemento;
    @Column(name = "nomeLogradouro", length = 90, nullable = false)
    private String nomeLogradouro;
    @Column(name = "numero", length = 6, nullable = false)
    private String numero;
    
    
    

   
    
}
