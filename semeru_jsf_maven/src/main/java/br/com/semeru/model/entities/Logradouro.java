/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "logradouro")
public class Logradouro implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idLogradouro")
    private Integer idLogradouro;
    @Column(name = "descricaoTipo", nullable = false)
    private String descricaoTipo;
    
    @OneToMany(mappedBy = "logradouro", fetch = FetchType.LAZY)
    @org.hibernate.annotations.ForeignKey(name = "EnderecoLogradouro")
    private List<Logradouro> logradouros;

    public Logradouro() {
    }

    public Integer getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(Integer idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public String getDescricaoTipo() {
        return descricaoTipo;
    }

    public void setDescricaoTipo(String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idLogradouro);
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
        final Logradouro other = (Logradouro) obj;
        if (!Objects.equals(this.idLogradouro, other.idLogradouro)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
