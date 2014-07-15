package br.com.semeru.model.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.jar.Attributes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;

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
    
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @org.hibernate.annotations.ForeignKey(name = "EnderecoCidade")
    @JoinColumn(name = "idCidade", referencedColumnName = "idCidade")
    private Cidade cidade;
    
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @org.hibernate.annotations.ForeignKey(name = "EnderecoEstado")
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado")
    private Estado estado;
    
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @org.hibernate.annotations.ForeignKey(name = "EnderecoPessoa")
    @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
    private Pessoa pessoa;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @org.hibernate.annotations.ForeignKey(name = "EnderecoTipoLogradouro")
    @JoinColumn(name = "idTipoLogradouro", referencedColumnName = "idTipoLogradouro")
    private TipoLogradouro tipoLogradouro;
    
    //@OneToOne(optional = true, fetch = FetchType.LAZY)
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @org.hibernate.annotations.ForeignKey(name = "EnderecoTipoEndereco")
    @JoinColumn(name = "idTipoEndereco", referencedColumnName = "idTipoEndereco")
    private TipoEndereco tipoEndereco;

    public Endereco() {
        this.cidade = new Cidade();
        this.estado = new Estado();
        this.tipoEndereco = new TipoEndereco();
        this.pessoa = new Pessoa();
        this.tipoLogradouro = new TipoLogradouro();
        
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

   
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idEndereco);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.idEndereco, other.idEndereco)) {
            return false;
        }
        return true;
    }   
    
}
