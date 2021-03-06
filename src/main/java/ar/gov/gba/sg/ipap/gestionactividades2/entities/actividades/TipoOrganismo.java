/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.gov.gba.sg.ipap.gestionactividades2.entities.actividades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entidad paramétrica que indica el Tipo de Organismo de la Actividad planificada y/o sus implementaciones
 * Se vincula a:
 *      Organismo
 * @author rincostante
 */
@Entity
public class TipoOrganismo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Campo de texto que indica el nombre del Tipo de Organismo
     */        
    @Column (nullable=false, length=255, unique=true)
    @NotNull(message = "{entidades.fieldNotNullError}")
    @Size(message = "{endidades.stringSizeError}", min = 1, max = 255)
    private String nombre;
    
    /**
     * Campo de tipo Array que contiene el conjunto de los Organismo de este Tipo de Organismo
     */    
    @OneToMany(mappedBy="tipoOrganismo")
    private List<Organismo> organismos;    
    
    /**
     * Constructor
     */
    public TipoOrganismo(){
        organismos = new ArrayList();
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Organismo> getOrganismos() {
        return organismos;
    }

    /**
     *
     * @param organismos
     */
    public void setOrganismos(List<Organismo> organismos) {
        this.organismos = organismos;
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
        if (!(object instanceof TipoOrganismo)) {
            return false;
        }
        TipoOrganismo other = (TipoOrganismo) object;
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
        return "ar.gov.gba.sg.ipap.gestionactividades.entities.actividades.TipoOrganismo[ id=" + id + " ]";
    }
    
}
