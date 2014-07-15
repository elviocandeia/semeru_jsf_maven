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
@Table(name = "tipoEndereco")
public class TipoEndereco implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idTipoEndereco")
    private Integer idTipoEndereco;
    @Column(name = "descricaoTipoEmdereco", nullable = false)
    private String descricaoTipoEndereco;
    
    @OneToMany(mappedBy = "descricaoTipoEndereco", fetch = FetchType.LAZY)
    @org.hibernate.annotations.ForeignKey(name = "descricaoTipoEndereco")
    private List<Endereco> descricaoTipoEnderecos;

    public TipoEndereco() {
    }

    public Integer getIdEndereco() {
        return idTipoEndereco;
    }

    public void setIdEndereco(Integer idTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
    }

    public String getDescricaoTipoEndereco() {
        return descricaoTipoEndereco;
    }

    public void setDescricaoTipoEndereco(String descricaoTipoEndereco) {
        this.descricaoTipoEndereco = descricaoTipoEndereco;
    }

    public List<Endereco> getDescricaoTipoEnderecos() {
        return descricaoTipoEnderecos;
    }

    public void setDescricaoTipoEnderecos(List<Endereco> descricaoTipoEnderecos) {
        this.descricaoTipoEnderecos = descricaoTipoEnderecos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idTipoEndereco);
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
        final TipoEndereco other = (TipoEndereco) obj;
        if (!Objects.equals(this.idTipoEndereco, other.idTipoEndereco)) {
            return false;
        }
        return true;
    }
    
}
