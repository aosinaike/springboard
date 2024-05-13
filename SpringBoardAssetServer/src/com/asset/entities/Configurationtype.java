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
import javax.persistence.Id;
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
@Table(name = "configurationtype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configurationtype.findAll", query = "SELECT c FROM Configurationtype c"),
    @NamedQuery(name = "Configurationtype.findByConfigurationtypeid", query = "SELECT c FROM Configurationtype c WHERE c.configurationtypeid = :configurationtypeid"),
    @NamedQuery(name = "Configurationtype.findByName", query = "SELECT c FROM Configurationtype c WHERE c.name = :name"),
    @NamedQuery(name = "Configurationtype.findByDescription", query = "SELECT c FROM Configurationtype c WHERE c.description = :description")})
public class Configurationtype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "configurationtypeid")
    private Integer configurationtypeid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "configurationtypeid")
    private Collection<Configuration> configurationCollection;

    public Configurationtype() {
    }

    public Configurationtype(Integer configurationtypeid) {
        this.configurationtypeid = configurationtypeid;
    }

    public Configurationtype(Integer configurationtypeid, String name, String description) {
        this.configurationtypeid = configurationtypeid;
        this.name = name;
        this.description = description;
    }

    public Integer getConfigurationtypeid() {
        return configurationtypeid;
    }

    public void setConfigurationtypeid(Integer configurationtypeid) {
        this.configurationtypeid = configurationtypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (configurationtypeid != null ? configurationtypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configurationtype)) {
            return false;
        }
        Configurationtype other = (Configurationtype) object;
        if ((this.configurationtypeid == null && other.configurationtypeid != null) || (this.configurationtypeid != null && !this.configurationtypeid.equals(other.configurationtypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Configurationtype[ configurationtypeid=" + configurationtypeid + " ]";
    }
    
}
