/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.gov.gba.sg.ipap.gestionactividades2.entities.actores;

import ar.gov.gba.sg.ipap.gestionactividades2.entities.actividades.ActividadImplementada;
import ar.gov.gba.sg.ipap.gestionactividades2.entities.actividades.AdmEntidad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entidad que encapsula la información relativa a los participantes de las diferentes actividades implementadas
 * Se vincula con:
 *      Clase,
 *      Agente,
 *      EstadoParticipante,
 *      AdmEntidad
 * @author rincostante
 */
@Entity
public class Participante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Campo que indica el agente participante
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="agente_id", nullable=false)
    @NotNull(message = "{entidades.objectNotNullError}")
    private Agente agente;
    
    /**
     * Campo que indica la actividad de la que participa
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="actividad_id", nullable=false)
    @NotNull(message = "{entidades.objectNotNullError}")
    private ActividadImplementada actividad;
    
    /**
     * Campo que indica el estado del participante
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="estado_id", nullable=false)
    @NotNull(message = "{entidades.objectNotNullError}")
    private EstadoParticipante estado;
    
    /**
     * Campo que indica las clases del participante
     */    
    @ManyToMany
    @JoinTable(
            name = "participantesXClases",
            joinColumns = @JoinColumn(name = "participante_fk"),
            inverseJoinColumns = @JoinColumn(name = "clase_fk")
    )
    private List<Clase> clases;    
    
    /**
     * Campo de tipo AdmEntidad que encapsula los datos propios para su trazabilidad.
     */
    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @NotNull(message = "{enitdades.objectNotNullError}") 
    private AdmEntidad admin;
    
    /**
     * Constructor
     */
    public Participante(){
        clases = new ArrayList();
    }

    /**
     *
     * @return
     */
    public Agente getAgente() {
        return agente;
    }

    /**
     *
     * @param agente
     */
    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    /**
     *
     * @return
     */
    public ActividadImplementada getActividad() {
        return actividad;
    }

    /**
     *
     * @param actividad
     */
    public void setActividad(ActividadImplementada actividad) {
        this.actividad = actividad;
    }

    /**
     *
     * @return
     */
    public EstadoParticipante getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(EstadoParticipante estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Clase> getClases() {
        return clases;
    }

    /**
     *
     * @param clases
     */
    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    /**
     *
     * @return
     */
    public AdmEntidad getAdmin() {
        return admin;
    }

    /**
     *
     * @param admin
     */
    public void setAdmin(AdmEntidad admin) {
        this.admin = admin;
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
        if (!(object instanceof Participante)) {
            return false;
        }
        Participante other = (Participante) object;
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
        return "ar.gov.gba.sg.ipap.gestionactividades.entities.actores.Participante[ id=" + id + " ]";
    }
    
}
