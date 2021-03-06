/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.gov.gba.sg.ipap.gestionactividades2.entities.actividades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Clase de acoplamiento fuerte que forma parte por composición de todas las entidades a las que se pretenda administrar su trazabilidad. 
 * Encapsula todos los campos necesarios para tal administración:
 *      Fechas y usuarios de alta, modificación y baja |
 *      Estado de habilitación que permite su borrado lógico      
 * @author rincostante
 */
@Entity
public class AdmEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    @NotNull(message = "{entidades.fieldNotNullError}")
    private int usAlta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=false)
    @NotNull(message = "{entidades.fieldNotNullError}")
    private Date fechaAlta;
    
    @Column(nullable=true)
    private int usModif;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModif = null;
    
    @Column(nullable=true)
    private int usBaja;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja = null;
    
    @Column(nullable=false)
    @NotNull(message = "{entidades.fieldNotNullError}")
    private boolean habilitado = true;

    /**
     *
     * @return
     */
    public int getUsAlta() {
        return usAlta;
    }

    /**
     *
     * @param usAlta
     */
    public void setUsAlta(int usAlta) {
        this.usAlta = usAlta;
    }

    /**
     *
     * @return
     */
    public Date getFechaAlta() {
        return fechaAlta;
    }

    /**
     *
     * @param fechaAlta
     */
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     *
     * @return
     */
    public int getUsModif() {
        return usModif;
    }

    /**
     *
     * @param usModif
     */
    public void setUsModif(int usModif) {
        this.usModif = usModif;
    }

    /**
     *
     * @return
     */
    public Date getFechaModif() {
        return fechaModif;
    }

    /**
     *
     * @param fechaModif
     */
    public void setFechaModif(Date fechaModif) {
        this.fechaModif = fechaModif;
    }

    /**
     *
     * @return
     */
    public int getUsBaja() {
        return usBaja;
    }

    /**
     *
     * @param usBaja
     */
    public void setUsBaja(int usBaja) {
        this.usBaja = usBaja;
    }

    /**
     *
     * @return
     */
    public Date getFechaBaja() {
        return fechaBaja;
    }

    /**
     *
     * @param fechaBaja
     */
    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    /**
     *
     * @return
     */
    public boolean isHabilitado() {
        return habilitado;
    }

    /**
     *
     * @param habilitado
     */
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
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
        if (!(object instanceof AdmEntidad)) {
            return false;
        }
        AdmEntidad other = (AdmEntidad) object;
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
        return "ar.gov.gba.sg.ipap.gestionactividades.entities.AdmEntidad[ id=" + id + " ]";
    }
    
}
