package com.geopista.app.eiel.models.versionados;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.geopista.app.eiel.beans.CentrosAsistencialesEIEL;
import com.geopista.app.eiel.beans.ServiciosAbastecimientosEIEL;
import com.geopista.app.eiel.beans.VersionEiel;
import com.geopista.app.eiel.utils.LocalGISEIELUtils;
import com.geopista.app.utilidades.estructuras.Estructuras;
import com.vividsolutions.jump.I18N;

/**
 * Clase que implementa el modelo de datos de la tabla del panel BienesJPanel
 */

public class CentrosAsistencialesVersionadoCompletoEIELTableModel  extends DefaultTableModel {
	
	private static String[] columnNames = {
			I18N.get("LocalGISEIEL","localgiseiel.version.CampoVersion"),
			I18N.get("LocalGISEIEL","localgiseiel.version.CampoAccion"),
			I18N.get("LocalGISEIEL","localgiseiel.version.CampoUsuario"),
			I18N.get("LocalGISEIEL","localgiseiel.version.CampoFecha"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.clave"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.codprov"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.codmunic"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.codentidad"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.codnucleo"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.orden_as"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.nombre_as"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.tipo_as"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.titular_as"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.gestor_as"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.plazas"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.s_cubi"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.s_aire"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.s_solar"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.estado_as"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.fecha_inst"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.observ"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.fecha_revision"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.estado_revision"),
    		I18N.get("LocalGISEIEL","localgiseiel.tabla.au.columna.bloqueado"),
			I18N.get("LocalGISEIEL","localgiseiel.tabla.cc.columna.acceso_S_Ruedas"),
			I18N.get("LocalGISEIEL","localgiseiel.tabla.cc.columna.obra_ejec")};

    public CentrosAsistencialesVersionadoCompletoEIELTableModel() {        
    	
    }

    private ArrayList lstElementos = new ArrayList();

    /**
     * @return n�mero de columnas de la tabla
     */
    public int getColumnCount() {
    	if (columnNames!=null){
    		return columnNames.length;
    	}
    	else
    		return 0;
    }
    
    /**
     * @return n�mero de filas de la tabla
     */
    public int getRowCount() {
    	if (lstElementos != null)
    		return lstElementos.size();
    	else
    		return 0;
    }
    
    
    /**
     * Devuelve el nombre de la columna solicitada
     * @param col �ndice de la columna
     * @return nombre de la columna
     */
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    /**
     * Devuelve el objeto que contiene la celda en la posici�n indicada
     * @param row �ndice de la fila
     * @param col �ndice de la columna
     * 
     * @return Objeto contenido en la posici�n seleccionada
     */
    public Object getValueAt(int row, int col) {
        
        if (lstElementos.get(row)==null)
            return null;
        
        Object[] fila = (Object[]) lstElementos.get(row);
		switch (col) {
			case 0:
			case 1:
			case 2:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:		
			
			case 20:
				return	 fila[col];
			case 11:
				 Estructuras.cargarEstructura("eiel_Tipo de Centro Asistencial");
		          return LocalGISEIELUtils.getNameFromEstructura((String) fila[col]);
			case 12:
	        	Estructuras.cargarEstructura("eiel_Titularidad_General_equip");
	            return LocalGISEIELUtils.getNameFromEstructura((String) fila[col]);
			case 13:
	            Estructuras.cargarEstructura("eiel_Gestor_General_equip");
	            return LocalGISEIELUtils.getNameFromEstructura((String) fila[col]);
			case 18:
	            Estructuras.cargarEstructura("eiel_Estado de conservaci�n");
	            return LocalGISEIELUtils.getNameFromEstructura((String) fila[col]);
			case 22:
	            Estructuras.cargarEstructura("eiel_Estado de revisi�n");
            	return fila[col]!=null? LocalGISEIELUtils.getNameFromEstructura(Integer.toString((Integer)fila[col])):"";
			case 24:
		           Estructuras.cargarEstructura("eiel_Acceso con silla de ruedas");
		            return LocalGISEIELUtils.getNameFromEstructura((String) fila[col]);		   
			case 25:
		         Estructuras.cargarEstructura("eiel_Obra ejecutada");
		            return LocalGISEIELUtils.getNameFromEstructura((String) fila[col]);
		       
			case 14:
			case 15:
			case 16:
			case 17:
			case 19:
			case 21:
			case 23:

				return fila[col] != null ? fila[col].toString() : "";
			case 3:	
        		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        		return fila[col] != null ? formatter.format(fila[col]):"";				
			default:
				return null;
		}

    }
    
    /**
     * Devuelve la Depuradora1EIEL completa de la fila seleccionada
     * @param row �ndice de la fila cuyo objeto FincaCatastro se solicita
     * @return FincaCatastro completa
     */
    public CentrosAsistencialesEIEL getValueAt(int row) {
        
    	Object[] fila = (Object[]) lstElementos.get(row);
    	CentrosAsistencialesEIEL obj = new CentrosAsistencialesEIEL();
    	 
    	VersionEiel version = new VersionEiel();
		version.setIdVersion((Integer) fila[0]);
		version.setAccion((String) fila[1]);
		version.setUsuario((String) fila[2]);
		version.setFecha((Date) fila[3]); 
		
		obj.setVersion(version);
		
		obj.setClave((String) fila[4]);
		obj.setCodINEProvincia((String) fila[5]);
		obj.setCodINEMunicipio((String) fila[6]); 
		obj.setCodINEEntidad((String) fila[7]);
		obj.setCodINEPoblamiento((String) fila[8]);
		obj.setOrdenAsistencial((String) fila[9]);
		obj.setNombre((String) fila[10]); 
		obj.setTipo((String) fila[11]);
		obj.setTitularidad((String) fila[12]);
		obj.setGestion((String) fila[13]);
		obj.setPlazas((Integer) fila[14]);
		obj.setSuperficieCubierta((Integer) fila[15]);
		obj.setSuperficieAireLibre((Integer) fila[16]);
		obj.setSuperficieSolar((Integer) fila[17]); 
		obj.setEstado((String) fila[18]);
		obj.setFechaInstalacion((Date) fila[19]);
		obj.setObservaciones((String) fila[20]);							
		obj.setFechaRevision((Date) fila[21]);
		obj.setEstadoRevision((Integer) fila[22]);
		obj.setBloqueado((String) fila[23]);														
		obj.setAcceso_s_ruedas((String) fila[24]);
		obj.setObra_ejec((String) fila[25]);
    	
        return obj;
        
    }
    /**
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  
     */
    public Class getColumnClass(int c) {
        
        if (getValueAt(0, c)!=null)        
            return getValueAt(0, c).getClass();
        else
            return String.class;
    }
    
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    
    /**
     * Establece los datos mostrados en el modelo
     * @param datos Datos a mostrar en el modelo
     */
    public void setData (ArrayList datos)
    {
        this.lstElementos = datos;
    }
    
    /**
     * Recupera los datos del modelo
     * @return Datos del modelo
     */
    public ArrayList getData (){
        return lstElementos;
    }    

}
