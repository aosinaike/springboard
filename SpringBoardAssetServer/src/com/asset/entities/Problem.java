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
@Table(name = "problem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Problem.findAll", query = "SELECT p FROM Problem p"),
    @NamedQuery(name = "Problem.findByProblemid", query = "SELECT p FROM Problem p WHERE p.problemid = :problemid"),
    @NamedQuery(name = "Problem.findByIsproblemdetected", query = "SELECT p FROM Problem p WHERE p.isproblemdetected = :isproblemdetected"),
    @NamedQuery(name = "Problem.findByIsproblemresolved", query = "SELECT p FROM Problem p WHERE p.isproblemresolved = :isproblemresolved"),
    @NamedQuery(name = "Problem.findByDescription", query = "SELECT p FROM Problem p WHERE p.description = :description"),
    @NamedQuery(name = "Problem.findBySinglepointoffailure", query = "SELECT p FROM Problem p WHERE p.singlepointoffailure = :singlepointoffailure"),
    @NamedQuery(name = "Problem.findByFixes", query = "SELECT p FROM Problem p WHERE p.fixes = :fixes"),
    @NamedQuery(name = "Problem.findByWorkaround", query = "SELECT p FROM Problem p WHERE p.workaround = :workaround"),
    @NamedQuery(name = "Problem.findByDatedetected", query = "SELECT p FROM Problem p WHERE p.datedetected = :datedetected"),
    @NamedQuery(name = "Problem.findByTimedetected", query = "SELECT p FROM Problem p WHERE p.timedetected = :timedetected"),
    @NamedQuery(name = "Problem.findByDateresolved", query = "SELECT p FROM Problem p WHERE p.dateresolved = :dateresolved"),
    @NamedQuery(name = "Problem.findByTimeresolved", query = "SELECT p FROM Problem p WHERE p.timeresolved = :timeresolved"),
    @NamedQuery(name = "Problem.findByServicerestoreddate", query = "SELECT p FROM Problem p WHERE p.servicerestoreddate = :servicerestoreddate"),
    @NamedQuery(name = "Problem.findByServicesrestoredtime", query = "SELECT p FROM Problem p WHERE p.servicesrestoredtime = :servicesrestoredtime"),
    @NamedQuery(name = "Problem.findByVendoralerts", query = "SELECT p FROM Problem p WHERE p.vendoralerts = :vendoralerts"),
    @NamedQuery(name = "Problem.findByStatus", query = "SELECT p FROM Problem p WHERE p.status = :status")})
public class Problem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "problemid")
    private Long problemid;
    @Basic(optional = false)
    @Column(name = "isproblemdetected")
    private short isproblemdetected;
    @Basic(optional = false)
    @Column(name = "isproblemresolved")
    private short isproblemresolved;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Column(name = "singlepointoffailure")
    private String singlepointoffailure;
    @Basic(optional = false)
    @Column(name = "fixes")
    private String fixes;
    @Basic(optional = false)
    @Column(name = "workaround")
    private String workaround;
    @Basic(optional = false)
    @Column(name = "datedetected")
    private String datedetected;
    @Basic(optional = false)
    @Column(name = "timedetected")
    private String timedetected;
    @Basic(optional = false)
    @Column(name = "dateresolved")
    private String dateresolved;
    @Basic(optional = false)
    @Column(name = "timeresolved")
    private String timeresolved;
    @Basic(optional = false)
    @Column(name = "servicerestoreddate")
    private String servicerestoreddate;
    @Basic(optional = false)
    @Column(name = "servicesrestoredtime")
    private String servicesrestoredtime;
    @Basic(optional = false)
    @Column(name = "vendoralerts")
    private String vendoralerts;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "urgencyid", referencedColumnName = "urgencyid")
    @ManyToOne(optional = false)
    private Urgency urgencyid;
    @JoinColumn(name = "incidentid", referencedColumnName = "incidentid")
    @ManyToOne(optional = false)
    private Incident incidentid;
    @JoinColumn(name = "priorityid", referencedColumnName = "prioritizationid")
    @ManyToOne(optional = false)
    private Prioritization priorityid;
    @JoinColumn(name = "itemid", referencedColumnName = "providedassetitemid")
    @ManyToOne(optional = false)
    private Providedassetitem itemid;
    @JoinColumn(name = "itemid", referencedColumnName = "serviceitemid")
    @ManyToOne(optional = false)
    private Serviceitem itemid1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "problemid")
    private Collection<Requestforchange> requestforchangeCollection;

    public Problem() {
    }

    public Problem(Long problemid) {
        this.problemid = problemid;
    }

    public Problem(Long problemid, short isproblemdetected, short isproblemresolved, String description, String fixes, String workaround, String datedetected, String timedetected, String dateresolved, String timeresolved, String servicerestoreddate, String servicesrestoredtime, String vendoralerts, int status) {
        this.problemid = problemid;
        this.isproblemdetected = isproblemdetected;
        this.isproblemresolved = isproblemresolved;
        this.description = description;
        this.fixes = fixes;
        this.workaround = workaround;
        this.datedetected = datedetected;
        this.timedetected = timedetected;
        this.dateresolved = dateresolved;
        this.timeresolved = timeresolved;
        this.servicerestoreddate = servicerestoreddate;
        this.servicesrestoredtime = servicesrestoredtime;
        this.vendoralerts = vendoralerts;
        this.status = status;
    }

    public Long getProblemid() {
        return problemid;
    }

    public void setProblemid(Long problemid) {
        this.problemid = problemid;
    }

    public short getIsproblemdetected() {
        return isproblemdetected;
    }

    public void setIsproblemdetected(short isproblemdetected) {
        this.isproblemdetected = isproblemdetected;
    }

    public short getIsproblemresolved() {
        return isproblemresolved;
    }

    public void setIsproblemresolved(short isproblemresolved) {
        this.isproblemresolved = isproblemresolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSinglepointoffailure() {
        return singlepointoffailure;
    }

    public void setSinglepointoffailure(String singlepointoffailure) {
        this.singlepointoffailure = singlepointoffailure;
    }

    public String getFixes() {
        return fixes;
    }

    public void setFixes(String fixes) {
        this.fixes = fixes;
    }

    public String getWorkaround() {
        return workaround;
    }

    public void setWorkaround(String workaround) {
        this.workaround = workaround;
    }

    public String getDatedetected() {
        return datedetected;
    }

    public void setDatedetected(String datedetected) {
        this.datedetected = datedetected;
    }

    public String getTimedetected() {
        return timedetected;
    }

    public void setTimedetected(String timedetected) {
        this.timedetected = timedetected;
    }

    public String getDateresolved() {
        return dateresolved;
    }

    public void setDateresolved(String dateresolved) {
        this.dateresolved = dateresolved;
    }

    public String getTimeresolved() {
        return timeresolved;
    }

    public void setTimeresolved(String timeresolved) {
        this.timeresolved = timeresolved;
    }

    public String getServicerestoreddate() {
        return servicerestoreddate;
    }

    public void setServicerestoreddate(String servicerestoreddate) {
        this.servicerestoreddate = servicerestoreddate;
    }

    public String getServicesrestoredtime() {
        return servicesrestoredtime;
    }

    public void setServicesrestoredtime(String servicesrestoredtime) {
        this.servicesrestoredtime = servicesrestoredtime;
    }

    public String getVendoralerts() {
        return vendoralerts;
    }

    public void setVendoralerts(String vendoralerts) {
        this.vendoralerts = vendoralerts;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Urgency getUrgencyid() {
        return urgencyid;
    }

    public void setUrgencyid(Urgency urgencyid) {
        this.urgencyid = urgencyid;
    }

    public Incident getIncidentid() {
        return incidentid;
    }

    public void setIncidentid(Incident incidentid) {
        this.incidentid = incidentid;
    }

    public Prioritization getPriorityid() {
        return priorityid;
    }

    public void setPriorityid(Prioritization priorityid) {
        this.priorityid = priorityid;
    }

    public Providedassetitem getItemid() {
        return itemid;
    }

    public void setItemid(Providedassetitem itemid) {
        this.itemid = itemid;
    }

    public Serviceitem getItemid1() {
        return itemid1;
    }

    public void setItemid1(Serviceitem itemid1) {
        this.itemid1 = itemid1;
    }

    @XmlTransient
    public Collection<Requestforchange> getRequestforchangeCollection() {
        return requestforchangeCollection;
    }

    public void setRequestforchangeCollection(Collection<Requestforchange> requestforchangeCollection) {
        this.requestforchangeCollection = requestforchangeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (problemid != null ? problemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Problem)) {
            return false;
        }
        Problem other = (Problem) object;
        if ((this.problemid == null && other.problemid != null) || (this.problemid != null && !this.problemid.equals(other.problemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Problem[ problemid=" + problemid + " ]";
    }
    
}
