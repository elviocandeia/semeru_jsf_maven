package br.com.semeru.model.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {
        
    @Id
    @GeneratedValue
    @Column(name = "idCidade")
    private Integer idCidade;
    @Column(name = "nome", length = 80, nullable = false)
    private String nome;
    
    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    @org.hibernate.annotations.ForeignKey(name = "EnderecoCidade")
    private List<Endereco> enderecos;
    

    public Cidade() {
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.idCidade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.idCidade, other.idCidade)) {
            return false;
        }
        return true;
    }
    
    
    
}
