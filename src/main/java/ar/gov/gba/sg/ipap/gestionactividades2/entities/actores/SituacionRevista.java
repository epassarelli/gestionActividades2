/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.gov.gba.sg.ipap.gestionactividades2.entities.actores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entidad que paramétrica que encapsula la información relativa a la situación de revista de los agentes públicos
 * Se vincula con:
 *      Agente
 * @author rincostante
 */
@Entity
public class SituacionRevista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * Campo de texto que indica el nombre de la situación de revista
     */        
    @Column (nullable=false, length=50, unique=true)
    @NotNull(message = "{entidades.fieldNotNullError}")
    @Size(message = "{endidades.stringSizeError}", min = 1, max = 50)
    private String nombre;  
    
    /**
     * Campo de tipo Array que contiene el conjunto de los Agentes con esta situación de revista
     */    
    @OneToMany(mappedBy="situacionRevista")
    private List<Agente> agentes;   
    
    /**
     * Constructor
     */
    public SituacionRevista(){
        agentes = new ArrayList();
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Agente> getAgentes() {
        return agentes;
    }

    /**
     *
     * @param agentes
     */
    public void setAgentes(List<Agente> agentes) {
        this.agentes = agentes;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacionRevista)) {
            return false;
        }
        SituacionRevista other = (SituacionRevista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "ar.gov.gba.sg.ipap.gestionactividades.entities.actores.SituacionRevista[ id=" + id + " ]";
    }
    
}
