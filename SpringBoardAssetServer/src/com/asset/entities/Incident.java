/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asset.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abiodun-PC
 */
@Entity
@Table(name = "incident")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incident.findAll", query = "SELECT i FROM Incident i"),
    @NamedQuery(name = "Incident.findByIncidentid", query = "SELECT i FROM Incident i WHERE i.incidentid = :incidentid"),
    @NamedQuery(name = "Incident.findByItemid", query = "SELECT i FROM Incident i WHERE i.itemid = :itemid"),
    @NamedQuery(name = "Incident.findByVitalbusinessfunctionaffected", query = "SELECT i FROM Incident i WHERE i.vitalbusinessfunctionaffected = :vitalbusinessfunctionaffected"),
    @NamedQuery(name = "Incident.findByIsincidentdiagnosed", query = "SELECT i FROM Incident i WHERE i.isincidentdiagnosed = :isincidentdiagnosed"),
    @NamedQuery(name = "Incident.findByDiagnose", query = "SELECT i FROM Incident i WHERE i.diagnose = :diagnose"),
    @NamedQuery(name = "Incident.findByIsincidentresolved", query = "SELECT i FROM Incident i WHERE i.isincidentresolved = :isincidentresolved"),
    @NamedQuery(name = "Incident.findByRecoverysolution", query = "SELECT i FROM Incident i WHERE i.recoverysolution = :recoverysolution"),
    @NamedQuery(name = "Incident.findByDescription", query = "SELECT i FROM Incident i WHERE i.description = :description"),
    @NamedQuery(name = "Incident.findByIncidentdate", query = "SELECT i FROM Incident i WHERE i.incidentdate = :incidentdate"),
    @NamedQuery(name = "Incident.findByIncidenttime", query = "SELECT i FROM Incident i WHERE i.incidenttime = :incidenttime"),
    @NamedQuery(name = "Incident.findByStatus", query = "SELECT i FROM Incident i WHERE i.status = :status")})
public class Incident implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "incidentid")
    private Long incidentid;
    @Basic(optional = false)
    @Column(name = "itemid")
    private int itemid;
    @Basic(optional = false)
    @Column(name = "vitalbusinessfunctionaffected")
    private String vitalbusinessfunctionaffected;
    @Basic(optional = false)
    @Column(name = "isincidentdiagnosed")
    private int isincidentdiagnosed;
    @Basic(optional = false)
    @Column(name = "diagnose")
    private String diagnose;
    @Basic(optional = false)
    @Column(name = "isincidentresolved")
    private int isincidentresolved;
    @Basic(optional = false)
    @Column(name = "recoverysolution")
    private String recoverysolution;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "incidentdate")
    private String incidentdate;
    @Basic(optional = false)
    @Column(name = "incidenttime")
    private String incidenttime;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentid")
    private Collection<Problem> problemCollection;
    @JoinColumn(name = "servicerequesttypeid", referencedColumnName = "servicerequesttypeid")
    @ManyToOne(optional = false)
    private Servicerequesttype servicerequesttypeid;
    @JoinColumn(name = "incidentclassificationid", referencedColumnName = "incidentclassificationid")
    @ManyToOne(optional = false)
    private Incidentclassification incidentclassificationid;

    public Incident() {
    }

    public Incident(Long incidentid) {
        this.incidentid = incidentid;
    }

    public Incident(Long incidentid, int itemid, String vitalbusinessfunctionaffected, int isincidentdiagnosed, String diagnose, int isincidentresolved, String recoverysolution, String description, String incidentdate, String incidenttime, String status) {
        this.incidentid = incidentid;
        this.itemid = itemid;
        this.vitalbusinessfunctionaffected = vitalbusinessfunctionaffected;
        this.isincidentdiagnosed = isincidentdiagnosed;
        this.diagnose = diagnose;
        this.isincidentresolved = isincidentresolved;
        this.recoverysolution = recoverysolution;
        this.description = description;
        this.incidentdate = incidentdate;
        this.incidenttime = incidenttime;
        this.status = status;
    }

    public Long getIncidentid() {
        return incidentid;
    }

    public void setIncidentid(Long incidentid) {
        this.incidentid = incidentid;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getVitalbusinessfunctionaffected() {
        return vitalbusinessfunctionaffected;
    }

    public void setVitalbusinessfunctionaffected(String vitalbusinessfunctionaffected) {
        this.vitalbusinessfunctionaffected = vitalbusinessfunctionaffected;
    }

    public int getIsincidentdiagnosed() {
        return isincidentdiagnosed;
    }

    public void setIsincidentdiagnosed(int isincidentdiagnosed) {
        this.isincidentdiagnosed = isincidentdiagnosed;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public int getIsincidentresolved() {
        return isincidentresolved;
    }

    public void setIsincidentresolved(int isincidentresolved) {
        this.isincidentresolved = isincidentresolved;
    }

    public String getRecoverysolution() {
        return recoverysolution;
    }

    public void setRecoverysolution(String recoverysolution) {
        this.recoverysolution = recoverysolution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIncidentdate() {
        return incidentdate;
    }

    public void setIncidentdate(String incidentdate) {
        this.incidentdate = incidentdate;
    }

    public String getIncidenttime() {
        return incidenttime;
    }

    public void setIncidenttime(String incidenttime) {
        this.incidenttime = incidenttime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Problem> getProblemCollection() {
        return problemCollection;
    }

    public void setProblemCollection(Collection<Problem> problemCollection) {
        this.problemCollection = problemCollection;
    }

    public Servicerequesttype getServicerequesttypeid() {
        return servicerequesttypeid;
    }

    public void setServicerequesttypeid(Servicerequesttype servicerequesttypeid) {
        this.servicerequesttypeid = servicerequesttypeid;
    }

    public Incidentclassification getIncidentclassificationid() {
        return incidentclassificationid;
    }

    public void setIncidentclassificationid(Incidentclassification incidentclassificationid) {
        this.incidentclassificationid = incidentclassificationid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incidentid != null ? incidentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incident)) {
            return false;
        }
        Incident other = (Incident) object;
        if ((this.incidentid == null && other.incidentid != null) || (this.incidentid != null && !this.incidentid.equals(other.incidentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Incident[ incidentid=" + incidentid + " ]";
    }
    
}
