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
@Table(name = "changereview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Changereview.findAll", query = "SELECT c FROM Changereview c"),
    @NamedQuery(name = "Changereview.findByChangereviewid", query = "SELECT c FROM Changereview c WHERE c.changereviewid = :changereviewid"),
    @NamedQuery(name = "Changereview.findByCategoryid", query = "SELECT c FROM Changereview c WHERE c.categoryid = :categoryid"),
    @NamedQuery(name = "Changereview.findByRisk", query = "SELECT c FROM Changereview c WHERE c.risk = :risk"),
    @NamedQuery(name = "Changereview.findByResourceplan", query = "SELECT c FROM Changereview c WHERE c.resourceplan = :resourceplan"),
    @NamedQuery(name = "Changereview.findByFinancialimpact", query = "SELECT c FROM Changereview c WHERE c.financialimpact = :financialimpact"),
    @NamedQuery(name = "Changereview.findByCommunicationplanid", query = "SELECT c FROM Changereview c WHERE c.communicationplanid = :communicationplanid"),
    @NamedQuery(name = "Changereview.findByStatus", query = "SELECT c FROM Changereview c WHERE c.status = :status")})
public class Changereview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "changereviewid")
    private Integer changereviewid;
    @Basic(optional = false)
    @Column(name = "categoryid")
    private int categoryid;
    @Basic(optional = false)
    @Column(name = "risk")
    private String risk;
    @Basic(optional = false)
    @Column(name = "resourceplan")
    private String resourceplan;
    @Basic(optional = false)
    @Column(name = "financialimpact")
    private String financialimpact;
    @Basic(optional = false)
    @Column(name = "communicationplanid")
    private int communicationplanid;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "urgencyid", referencedColumnName = "urgencyid")
    @ManyToOne(optional = false)
    private Urgency urgencyid;
    @JoinColumn(name = "impactid", referencedColumnName = "impactid")
    @ManyToOne(optional = false)
    private Impact impactid;
    @JoinColumn(name = "prioritizationid", referencedColumnName = "prioritizationid")
    @ManyToOne(optional = false)
    private Prioritization prioritizationid;
    @JoinColumn(name = "requestforchangeid", referencedColumnName = "requestforchangeid")
    @ManyToOne(optional = false)
    private Requestforchange requestforchangeid;
    @JoinColumn(name = "classificationid", referencedColumnName = "classificationid")
    @ManyToOne(optional = false)
    private Rfcclassification classificationid;
    @JoinColumn(name = "riskcategoryid", referencedColumnName = "riskcategoryid")
    @ManyToOne(optional = false)
    private Riskcategory riskcategoryid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "changereviewid")
    private Collection<Configuration> configurationCollection;

    public Changereview() {
    }

    public Changereview(Integer changereviewid) {
        this.changereviewid = changereviewid;
    }

    public Changereview(Integer changereviewid, int categoryid, String risk, String resourceplan, String financialimpact, int communicationplanid, String status) {
        this.changereviewid = changereviewid;
        this.categoryid = categoryid;
        this.risk = risk;
        this.resourceplan = resourceplan;
        this.financialimpact = financialimpact;
        this.communicationplanid = communicationplanid;
        this.status = status;
    }

    public Integer getChangereviewid() {
        return changereviewid;
    }

    public void setChangereviewid(Integer changereviewid) {
        this.changereviewid = changereviewid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getResourceplan() {
        return resourceplan;
    }

    public void setResourceplan(String resourceplan) {
        this.resourceplan = resourceplan;
    }

    public String getFinancialimpact() {
        return financialimpact;
    }

    public void setFinancialimpact(String financialimpact) {
        this.financialimpact = financialimpact;
    }

    public int getCommunicationplanid() {
        return communicationplanid;
    }

    public void setCommunicationplanid(int communicationplanid) {
        this.communicationplanid = communicationplanid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Urgency getUrgencyid() {
        return urgencyid;
    }

    public void setUrgencyid(Urgency urgencyid) {
        this.urgencyid = urgencyid;
    }

    public Impact getImpactid() {
        return impactid;
    }

    public void setImpactid(Impact impactid) {
        this.impactid = impactid;
    }

    public Prioritization getPrioritizationid() {
        return prioritizationid;
    }

    public void setPrioritizationid(Prioritization prioritizationid) {
        this.prioritizationid = prioritizationid;
    }

    public Requestforchange getRequestforchangeid() {
        return requestforchangeid;
    }

    public void setRequestforchangeid(Requestforchange requestforchangeid) {
        this.requestforchangeid = requestforchangeid;
    }

    public Rfcclassification getClassificationid() {
        return classificationid;
    }

    public void setClassificationid(Rfcclassification classificationid) {
        this.classificationid = classificationid;
    }

    public Riskcategory getRiskcategoryid() {
        return riskcategoryid;
    }

    public void setRiskcategoryid(Riskcategory riskcategoryid) {
        this.riskcategoryid = riskcategoryid;
    }

    @XmlTransient
    public Collection<Configuration> getConfigurationCollection() {
        return configurationCollection;
    }

    public void setConfigurationCollection(Collection<Configuration> configurationCollection) {
        this.configurationCollection = configurationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (changereviewid != null ? changereviewid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Changereview)) {
            return false;
        }
        Changereview other = (Changereview) object;
        if ((this.changereviewid == null && other.changereviewid != null) || (this.changereviewid != null && !this.changereviewid.equals(other.changereviewid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Changereview[ changereviewid=" + changereviewid + " ]";
    }
    
}
