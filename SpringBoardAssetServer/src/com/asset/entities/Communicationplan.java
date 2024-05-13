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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abiodun-PC
 */
@Entity
@Table(name = "communicationplan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Communicationplan.findAll", query = "SELECT c FROM Communicationplan c"),
    @NamedQuery(name = "Communicationplan.findByCommunicationplanid", query = "SELECT c FROM Communicationplan c WHERE c.communicationplanid = :communicationplanid"),
    @NamedQuery(name = "Communicationplan.findByCommunicationmode", query = "SELECT c FROM Communicationplan c WHERE c.communicationmode = :communicationmode"),
    @NamedQuery(name = "Communicationplan.findByStakeholders", query = "SELECT c FROM Communicationplan c WHERE c.stakeholders = :stakeholders"),
    @NamedQuery(name = "Communicationplan.findByStatus", query = "SELECT c FROM Communicationplan c WHERE c.status = :status")})
public class Communicationplan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "communicationplanid")
    private Integer communicationplanid;
    @Basic(optional = false)
    @Column(name = "communicationmode")
    private String communicationmode;
    @Basic(optional = false)
    @Column(name = "stakeholders")
    private String stakeholders;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    public Communicationplan() {
    }

    public Communicationplan(Integer communicationplanid) {
        this.communicationplanid = communicationplanid;
    }

    public Communicationplan(Integer communicationplanid, String communicationmode, String stakeholders, String status) {
        this.communicationplanid = communicationplanid;
        this.communicationmode = communicationmode;
        this.stakeholders = stakeholders;
        this.status = status;
    }

    public Integer getCommunicationplanid() {
        return communicationplanid;
    }

    public void setCommunicationplanid(Integer communicationplanid) {
        this.communicationplanid = communicationplanid;
    }

    public String getCommunicationmode() {
        return communicationmode;
    }

    public void setCommunicationmode(String communicationmode) {
        this.communicationmode = communicationmode;
    }

    public String getStakeholders() {
        return stakeholders;
    }

    public void setStakeholders(String stakeholders) {
        this.stakeholders = stakeholders;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (communicationplanid != null ? communicationplanid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Communicationplan)) {
            return false;
        }
        Communicationplan other = (Communicationplan) object;
        if ((this.communicationplanid == null && other.communicationplanid != null) || (this.communicationplanid != null && !this.communicationplanid.equals(other.communicationplanid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Communicationplan[ communicationplanid=" + communicationplanid + " ]";
    }
    
}
