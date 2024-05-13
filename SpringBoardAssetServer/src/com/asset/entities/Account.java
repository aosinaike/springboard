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
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAccountid", query = "SELECT a FROM Account a WHERE a.accountid = :accountid"),
    @NamedQuery(name = "Account.findByName", query = "SELECT a FROM Account a WHERE a.name = :name"),
    @NamedQuery(name = "Account.findByPurchaseprice", query = "SELECT a FROM Account a WHERE a.purchaseprice = :purchaseprice"),
    @NamedQuery(name = "Account.findByDateofpurchase", query = "SELECT a FROM Account a WHERE a.dateofpurchase = :dateofpurchase"),
    @NamedQuery(name = "Account.findByCapitalcost", query = "SELECT a FROM Account a WHERE a.capitalcost = :capitalcost"),
    @NamedQuery(name = "Account.findByOperationalcost", query = "SELECT a FROM Account a WHERE a.operationalcost = :operationalcost"),
    @NamedQuery(name = "Account.findByDirectcost", query = "SELECT a FROM Account a WHERE a.directcost = :directcost"),
    @NamedQuery(name = "Account.findByIndirectcost", query = "SELECT a FROM Account a WHERE a.indirectcost = :indirectcost"),
    @NamedQuery(name = "Account.findByFixedcost", query = "SELECT a FROM Account a WHERE a.fixedcost = :fixedcost"),
    @NamedQuery(name = "Account.findByVariablecost", query = "SELECT a FROM Account a WHERE a.variablecost = :variablecost"),
    @NamedQuery(name = "Account.findByStatus", query = "SELECT a FROM Account a WHERE a.status = :status")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accountid")
    private Integer accountid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "purchaseprice")
    private String purchaseprice;
    @Basic(optional = false)
    @Column(name = "dateofpurchase")
    private String dateofpurchase;
    @Basic(optional = false)
    @Column(name = "capitalcost")
    private String capitalcost;
    @Basic(optional = false)
    @Column(name = "operationalcost")
    private String operationalcost;
    @Basic(optional = false)
    @Column(name = "directcost")
    private String directcost;
    @Basic(optional = false)
    @Column(name = "indirectcost")
    private String indirectcost;
    @Basic(optional = false)
    @Column(name = "fixedcost")
    private String fixedcost;
    @Basic(optional = false)
    @Column(name = "variablecost")
    private String variablecost;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "costcenterid", referencedColumnName = "costcenterid")
    @ManyToOne(optional = false)
    private Costcenter costcenterid;
    @JoinColumn(name = "chargebacktypeid", referencedColumnName = "chargebacktypeid")
    @ManyToOne(optional = false)
    private Chargebacktype chargebacktypeid;

    public Account() {
    }

    public Account(Integer accountid) {
        this.accountid = accountid;
    }

    public Account(Integer accountid, String name, String purchaseprice, String dateofpurchase, String capitalcost, String operationalcost, String directcost, String indirectcost, String fixedcost, String variablecost, String status) {
        this.accountid = accountid;
        this.name = name;
        this.purchaseprice = purchaseprice;
        this.dateofpurchase = dateofpurchase;
        this.capitalcost = capitalcost;
        this.operationalcost = operationalcost;
        this.directcost = directcost;
        this.indirectcost = indirectcost;
        this.fixedcost = fixedcost;
        this.variablecost = variablecost;
        this.status = status;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(String purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public String getDateofpurchase() {
        return dateofpurchase;
    }

    public void setDateofpurchase(String dateofpurchase) {
        this.dateofpurchase = dateofpurchase;
    }

    public String getCapitalcost() {
        return capitalcost;
    }

    public void setCapitalcost(String capitalcost) {
        this.capitalcost = capitalcost;
    }

    public String getOperationalcost() {
        return operationalcost;
    }

    public void setOperationalcost(String operationalcost) {
        this.operationalcost = operationalcost;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Costcenter getCostcenterid() {
        return costcenterid;
    }

    public void setCostcenterid(Costcenter costcenterid) {
        this.costcenterid = costcenterid;
    }

    public Chargebacktype getChargebacktypeid() {
        return chargebacktypeid;
    }

    public void setChargebacktypeid(Chargebacktype chargebacktypeid) {
        this.chargebacktypeid = chargebacktypeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountid != null ? accountid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountid == null && other.accountid != null) || (this.accountid != null && !this.accountid.equals(other.accountid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Account[ accountid=" + accountid + " ]";
    }
    
}
