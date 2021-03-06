/**
 * Sesion.java
 * � MINETUR, Government of Spain
 * This program is part of LocalGIS
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 2 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.geopista.protocol.control;

import java.io.Serializable;
import java.security.Principal;
import java.security.acl.Group;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import org.eclipse.jetty.plus.jaas.JAASRole;

import com.geopista.protocol.Version;
import com.geopista.security.GeopistaAcl;


/**
 * Created by IntelliJ IDEA.
 * User: angeles
 * Date: 04-may-2004
 * Time: 11:51:50
 * To change this template use Options | File Templates.
 */
public class Sesion implements ISesion, Serializable {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Sesion.class);

    private String idSesion;
    private String idApp;
    private String idUser;
    private List alMunicipios;
    private String idEntidad;
    private String idCurrentEntidad;
    private String idMunicipio;
    private String idCurrentMunicipio;
    private Principal userPrincipal;
    private Group group = null;
    private Date fechaConexion=null;
    private Version version=null;
    
    private int estadoValidacion=0;
    private int loadFeatureLayer=1;
	private String ip;

    public Sesion() {
    }

    public Sesion(String sIdSesion)
    {
        idSesion=sIdSesion;
        fechaConexion=Calendar.getInstance().getTime();
    }
    public Sesion(String sIdSesion, String sIdApp, Principal pUserPrincipal, Group gRoleGroup) 
    {
        idSesion=sIdSesion;
        idApp=sIdApp;
        userPrincipal=pUserPrincipal;
        group = gRoleGroup;
        fechaConexion=Calendar.getInstance().getTime();
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#getFechaConexion()
	 */
    public Date getFechaConexion() {
        return fechaConexion;
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#setFechaConexion(java.util.Date)
	 */
    public void setFechaConexion(Date fechaConexion) {
        this.fechaConexion = fechaConexion;
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#getIdUser()
	 */
    public String getIdUser() {
        return idUser;
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#setIdSesion(java.lang.String)
	 */
    public void setIdSesion(String idSesion) {
        this.idSesion = idSesion;
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#setIdApp(java.lang.String)
	 */
    public void setIdApp(String idApp) {
        this.idApp = idApp;
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#setIdUser(java.lang.String)
	 */
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#setUserPrincipal(java.security.Principal)
	 */
    public void setUserPrincipal(Principal userPrincipal) {
        this.userPrincipal = userPrincipal;
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#setRoleGroup(java.security.acl.Group)
	 */
    public void setRoleGroup(Group roleGroup) {
        this.group = roleGroup;
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#getIdSesion()
	 */
    public String getIdSesion()
    {
        return idSesion;
    }
    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#getUserPrincipal()
	 */
    public Principal getUserPrincipal()
    {
        return userPrincipal;
    }
    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#getRoleGroup()
	 */
    public Group getRoleGroup()
    {
       return group;
    }
    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#getIdApp()
	 */
    public String getIdApp()
    {
        return idApp;
    }
    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#getConjuncion(java.util.Vector)
	 */
    public Vector getConjuncion(Vector vPermisos)
    {
        Vector auxVector = new Vector();
        for (Enumeration e=vPermisos.elements();e.hasMoreElements();)
        {
            String auxString=(String)e.nextElement();
            if (group.isMember(new JAASRole(auxString)))
                auxVector.add(auxString);
        }
        return (auxVector);
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#getAlMunicipios()
	 */
    public List getAlMunicipios() {
        return alMunicipios;
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#setAlMunicipios(java.util.List)
	 */
    public void setAlMunicipios(List alMunicipios) {
        this.alMunicipios = alMunicipios;
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#getIdEntidad()
	 */
    public String getIdEntidad() {
        return idEntidad;
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#setIdEntidad(java.lang.String)
	 */
    public void setIdEntidad(String idEntidad) {
        this.idEntidad = idEntidad;
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#getIdMunicipio()
	 */
    public String getIdMunicipio() {
        return idMunicipio;
    }

    /* (non-Javadoc)
	 * @see com.geopista.protocol.control.ISesion#setIdMunicipio(java.lang.String)
	 */
    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

   

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	@Override
	public void setEstadoValidacion(int estadoValidacion) {
		this.estadoValidacion=estadoValidacion;
		
	}

	@Override
	public int getEstadoValidacion() {
		// TODO Auto-generated method stub
		return estadoValidacion;
	}

	@Override
	public void setLoadFeatureLayer(int loadFeatureLayer) {
		this.loadFeatureLayer=loadFeatureLayer;
		
	}

	@Override
	public int getLoadFeatureLayer() {
		// TODO Auto-generated method stub
		return loadFeatureLayer;
	}
    /**
     * 
     */
    public String getIdCurrentEntidad() {
        return idCurrentEntidad;
    }

    /**
     * 
     */
    public void setIdCurrentEntidad(String idCurrentEntidad) {
        this.idCurrentEntidad = idCurrentEntidad;
    }
    /**
     * 
     */
    public String getIdCurrentMunicipio() {
        return idCurrentMunicipio;
    }

    /**
     * 
     */
    public void setIdCurrentMunicipio(String idCurrentMunicipio) {
        this.idCurrentMunicipio = idCurrentMunicipio;
    }
    
	public GeopistaAcl getPerfil(long lACL) {
		// TODO Auto-generated method stub
		return null;
	}

	public GeopistaAcl getPerfil(long lACL, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setIP(String ip) {
		this.ip=ip;		
	}

	@Override
	public String getIP() {		
		return ip;
	}
    
}
