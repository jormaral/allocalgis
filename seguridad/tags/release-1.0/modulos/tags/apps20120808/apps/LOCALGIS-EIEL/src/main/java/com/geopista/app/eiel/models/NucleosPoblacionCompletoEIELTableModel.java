package com.geopista.app.eiel.models;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.geopista.app.eiel.beans.NucleosAbandonadosEIEL;
import com.geopista.app.eiel.beans.NucleosPoblacionEIEL;
import com.vividsolutions.jump.I18N;

/**
 * Clase que implementa el modelo de datos de la tabla del panel BienesJPanel
 */

public class NucleosPoblacionCompletoEIELTableModel  extends EIELCompletoTableModel {
	
	private static String[] columnNames = {
			I18N.get("LocalGISEIEL","localgiseiel.tabla.generico.columna.estado"),
//            I18N.get("LocalGISEIEL","localgiseiel.tabla.nucleospobl.columna.codprov"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.nucleospobl.columna.codmunic"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.nucleospobl.columna.codentidad"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.nucleospobl.columna.codnucleo"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.nucleospobl.columna.fecha_revision"),
            I18N.get("LocalGISEIEL","localgiseiel.tabla.nucleospobl.columna.estado_actualizacion")};
	    
    public NucleosPoblacionCompletoEIELTableModel() {        
    	
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
        
        switch (col)
        {
        case 0: 
        	return ((NucleosPoblacionEIEL)lstElementos.get(row)).getEstadoValidacion();
        case 1: 
            return ((NucleosPoblacionEIEL)lstElementos.get(row)).getCodINEProvincia() + ((NucleosPoblacionEIEL)lstElementos.get(row)).getCodINEMunicipio();
        case 2: 
            return getNombreNucleo( ((NucleosAbandonadosEIEL)lstElementos.get(row)).getCodINEEntidad(),((NucleosAbandonadosEIEL)lstElementos.get(row)).getCodINEPoblamiento());
        case 3: 
            return ((NucleosPoblacionEIEL)lstElementos.get(row)).getCodINEPoblamiento();
        case 4: 
            return ((NucleosPoblacionEIEL) lstElementos.get(row)).getFechaRevision() != null ? ((NucleosPoblacionEIEL) lstElementos
                    .get(row)).getFechaRevision().toString()
                    : "";
        case 5: 
            return ((NucleosPoblacionEIEL)lstElementos.get(row)).getEstadoActualizacion() != null ? ((NucleosPoblacionEIEL) lstElementos
                    .get(row)).getEstadoActualizacion().toString()
                    : "";
        default: 
            return null;
        
        }        
    }
    
    /**
     * Devuelve la Depuradora1EIEL completa de la fila seleccionada
     * @param row �ndice de la fila cuyo objeto FincaCatastro se solicita
     * @return FincaCatastro completa
     */
    public NucleosPoblacionEIEL getValueAt(int row) {
        
        return (NucleosPoblacionEIEL)lstElementos.get(row);
        
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
