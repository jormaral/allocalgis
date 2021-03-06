package com.geopista.app.metadatos.calidad;

import com.geopista.protocol.metadatos.DQ_Element;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.util.Enumeration;

/**
 * The GEOPISTA project is a set of tools and applications to manage
 * geographical data for local administrations.
 *
 * Copyright (C) 2004 INZAMAC-SATEC UTE
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307,
 USA.
 *
 * For more information, contact:
 *
 *
 * www.geopista.com
 *
 *
 */


/**
 * Created by IntelliJ IDEA.
 * User: angeles
 * Date: 26-ago-2004
 * Time: 9:10:53
 */
public class ElementosTableModel  extends DefaultTableModel {
    public static final int idIndex=0;
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ElementosTableModel.class);
    private static String[] elementosModelNames = new String[] { "Titulo"};

    public void setModelData(Vector listaElementos) {
        try
        {
            if (listaElementos==null) return;
            for (Enumeration e=listaElementos.elements();e.hasMoreElements();) {
			    DQ_Element auxElemento =(DQ_Element) e.nextElement();
			    Object row[] = new Object[] {(auxElemento.getCitation()!=null?auxElemento.getCitation().getTitle():"")};
			    this.addRow(row);
		    }
	    	fireTableDataChanged();
        }catch(Exception e)
        {
            logger.error("Error al poner la lista de elementos: "+ e.toString());
        }
	}
	public int getColumnCount() {
		return elementosModelNames.length;
	}

	public String getColumnName(int c) {
		return elementosModelNames[c];
	}
    public String setColumnName(int c, String sName) {
        return elementosModelNames[c]=sName;
    }

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

}
