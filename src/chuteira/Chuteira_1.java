/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuteira;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author si
 */
@Entity
@Table(name = "chuteira", catalog = "fut", schema = "")
@NamedQueries({
    @NamedQuery(name = "Chuteira_1.findAll", query = "SELECT c FROM Chuteira_1 c")
    , @NamedQuery(name = "Chuteira_1.findByMarca", query = "SELECT c FROM Chuteira_1 c WHERE c.marca = :marca")
    , @NamedQuery(name = "Chuteira_1.findByModelo", query = "SELECT c FROM Chuteira_1 c WHERE c.modelo = :modelo")
    , @NamedQuery(name = "Chuteira_1.findByTamanho", query = "SELECT c FROM Chuteira_1 c WHERE c.tamanho = :tamanho")
    , @NamedQuery(name = "Chuteira_1.findByPreco", query = "SELECT c FROM Chuteira_1 c WHERE c.preco = :preco")
    , @NamedQuery(name = "Chuteira_1.findById", query = "SELECT c FROM Chuteira_1 c WHERE c.id = :id")})
public class Chuteira_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "Marca")
    private String marca;
    @Column(name = "Modelo")
    private String modelo;
    @Column(name = "Tamanho")
    private Integer tamanho;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Preco")
    private Double preco;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;

    public Chuteira_1() {
    }

    public Chuteira_1(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        String oldMarca = this.marca;
        this.marca = marca;
        changeSupport.firePropertyChange("marca", oldMarca, marca);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        String oldModelo = this.modelo;
        this.modelo = modelo;
        changeSupport.firePropertyChange("modelo", oldModelo, modelo);
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        Integer oldTamanho = this.tamanho;
        this.tamanho = tamanho;
        changeSupport.firePropertyChange("tamanho", oldTamanho, tamanho);
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        Double oldPreco = this.preco;
        this.preco = preco;
        changeSupport.firePropertyChange("preco", oldPreco, preco);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chuteira_1)) {
            return false;
        }
        Chuteira_1 other = (Chuteira_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "chuteira.Chuteira_1[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
