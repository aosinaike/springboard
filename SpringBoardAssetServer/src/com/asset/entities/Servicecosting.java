/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asset.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abiodun-PC
 */
@Entity
@Table(name = "servicecosting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicecosting.findAll", query = "SELECT s FROM Servicecosting s"),
    @NamedQuery(name = "Servicecosting.findByServicecostingid", query = "SELECT s FROM Servicecosting s WHERE s.servicecostingid = :servicecostingid"),
    @NamedQuery(name = "Servicecosting.findByDirectcost", query = "SELECT s FROM Servicecosting s WHERE s.directcost = :directcost"),
    @NamedQuery(name = "Servicecosting.findByIndirectcost", query = "SELECT s FROM Servicecosting s WHERE s.indirectcost = :indirectcost"),
    @NamedQuery(name = "Servicecosting.findByOperationalcost", query = "SELECT s FROM Servicecosting s WHERE s.operationalcost = :operationalcost"),
    @NamedQuery(name = "Servicecosting.findByFixedcost", query = "SELECT s FROM Servicecosting s WHERE s.fixedcost = :fixedcost"),
    @NamedQuery(name = "Servicecosting.findByVariablecost", query = "SELECT s FROM Servicecosting s WHERE s.variablecost = :variablecost"),
    @NamedQuery(name = "Servicecosting.findByChargebacktypeid", query = "SELECT s FROM Servicecosting s WHERE s.chargebacktypeid = :chargebacktypeid"),
    @NamedQuery(name = "Servicecosting.findByCostingstartdate", query = "SELECT s FROM Servicecosting s WHERE s.costingstartdate = :costingstartdate"),
    @NamedQuery(name = "Servicecosting.findByCostingstarttime", query = "SELECT s FROM Servicecosting s WHERE s.costingstarttime = :costingstarttime"),
    @NamedQuery(name = "Servicecosting.findByCostingenddate", query = "SELECT s FROM Servicecosting s WHERE s.costingenddate = :costingenddate"),
    @NamedQuery(name = "Servicecosting.findByCostingendtime", query = "SELECT s FROM Servicecosting s WHERE s.costingendtime = :costingendtime"),
    @NamedQuery(name = "Servicecosting.findByStatus", query = "SELECT s FROM Servicecosting s WHERE s.status = :status")})
public class Servicecosting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "servicecostingid")
    private Integer servicecostingid;
    @Basic(optional = false)
    @Column(name = "directcost")
    private String directcost;
    @Basic(optional = false)
    @Column(name = "indirectcost")
    private String indirectcost;
    @Basic(optional = false)
    @Column(name = "operationalcost")
    private String operationalcost;
    @Basic(optional = false)
    @Column(name = "fixedcost")
    private String fixedcost;
    @Basic(optional = false)
    @Column(name = "variablecost")
    private String variablecost;
    @Basic(optional = false)
    @Column(name = "chargebacktypeid")
    private String chargebacktypeid;
    @Basic(optional = false)
    @Column(name = "costingstartdate")
    private String costingstartdate;
    @Basic(optional = false)
    @Column(name = "costingstarttime")
    private String costingstarttime;
    @Basic(optional = false)
    @Column(name = "costingenddate")
    private String costingenddate;
    @Basic(optional = false)
    @Column(name = "costingendtime")
    private String costingendtime;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "serviceclassificationid", referencedColumnName = "serviceassetclassificationid")
    @ManyToOne(optional = false)
    private Serviceassetclassification serviceclassificationid;
    @JoinColumn(name = "costunitid", referencedColumnName = "costunitid")
    @ManyToOne(optional = false)
    private Costunits costunitid;
    @JoinColumn(name = "providedserviceitemid", referencedColumnName = "providedserviceitemid")
    @ManyToOne(optional = false)
    private Providedserviceitem providedserviceitemid;
    @JoinColumn(name = "requestid", referencedColumnName = "requestid")
    @ManyToOne(optional = false)
    private Request requestid;
    @JoinColumn(name = "serviceid", referencedColumnName = "serviceid")
    @ManyToOne(optional = false)
    private Service serviceid;

    public Servicecosting() {
    }

    public Servicecosting(Integer servicecostingid) {
        this.servicecostingid = servicecostingid;
    }

    public Servicecosting(Integer servicecostingid, String directcost, String indirectcost, String operationalcost, String fixedcost, String variablecost, String chargebacktypeid, String costingstartdate, String costingstarttime, String costingenddate, String costingendtime, int status) {
        this.servicecostingid = servicecostingid;
        this.directcost = directcost;
        this.indirectcost = indirectcost;
        this.operationalcost = operationalcost;
        this.fixedcost = fixedcost;
        this.variablecost = variablecost;
        this.chargebacktypeid = chargebacktypeid;
        this.costingstartdate = costingstartdate;
        this.costingstarttime = costingstarttime;
        this.costingenddate = costingenddate;
        this.costingendtime = costingendtime;
        this.status = status;
    }

    public Integer getServicecostingid() {
        return servicecostingid;
    }

    public void setServicecostingid(Integer servicecostingid) {
        this.servicecostingid = servicecostingid;
    }

    public String getDirectcost() {
        return directcost;
    }

    public void setDirectcost(String directcost) {
        this.directcost = directcost;
    }

    public String getIndirectcost() {
        return indirectcost;
    }

    public void setIndirectcost(String indirectcost) {
        this.indirectcost = indirectcost;
    }

    public String getOperationalcost() {
        return operationalcost;
    }

    public void setOperationalcost(String operationalcost) {
        this.operationalcost = operationalcost;
    }

    public String getFixedcost() {
        return fixedcost;
    }

    public void setFixedcost(String fixedcost) {
        this.fixedcost = fixedcost;
    }

    public String getVariablecost() {
        return variablecost;
    }

    public void setVariablecost(String variablecost) {
        this.variablecost = variablecost;
    }

    public String getChargebacktypeid() {
        return chargebacktypeid;
    }

    public void setChargebacktypeid(String chargebacktypeid) {
        this.chargebacktypeid = chargebacktypeid;
    }

    public String getCostingstartdate() {
        return costingstartdate;
    }

    public void setCostingstartdate(String costingstartdate) {
        this.costingstartdate = costingstartdate;
    }

    public String getCostingstarttime() {
        return costingstarttime;
    }

    public void setCostingstarttime(String costingstarttime) {
        this.costingstarttime = costingstarttime;
    }

    public String getCostingenddate() {
        return costingenddate;
    }

    public void setCostingenddate(String costingenddate) {
        this.costingenddate = costingenddate;
    }

    public String getCostingendtime() {
        return costingendtime;
    }

    public void setCostingendtime(String costingendtime) {
        this.costingendtime = costingendtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Serviceassetclassification getServiceclassificationid() {
        return serviceclassificationid;
    }

    public void setServiceclassificationid(Serviceassetclassification serviceclassificationid) {
        this.serviceclassificationid = serviceclassificationid;
    }

    public Costunits getCostunitid() {
        return costunitid;
    }

    public void setCostunitid(Costunits costunitid) {
        this.costunitid = costunitid;
    }

    public Providedserviceitem getProvidedserviceitemid() {
        return providedserviceitemid;
    }

    public void setProvidedserviceitemid(Providedserviceitem providedserviceitemid) {
        this.providedserviceitemid = providedserviceitemid;
    }

    public Request getRequestid() {
        return requestid;
    }

    public void setRequestid(Request requestid) {
        this.requestid = requestid;
    }

    public Service getServiceid() {
        return serviceid;
    }

    public void setServiceid(Service serviceid) {
        this.serviceid = serviceid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicecostingid != null ? servicecostingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicecosting)) {
            return false;
        }
        Servicecosting other = (Servicecosting) object;
        if ((this.servicecostingid == null && other.servicecostingid != null) || (this.servicecostingid != null && !this.servicecostingid.equals(other.servicecostingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Servicecosting[ servicecostingid=" + servicecostingid + " ]";
    }
    
}
