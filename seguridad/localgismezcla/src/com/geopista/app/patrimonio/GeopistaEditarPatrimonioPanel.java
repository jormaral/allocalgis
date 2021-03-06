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

package com.geopista.app.patrimonio;

import java.util.ResourceBundle;

import com.geopista.ui.GEOPISTAWorkbench;
public class GeopistaEditarPatrimonioPanel 
{
 
   public GeopistaEditarPatrimonioPanel()
   {
    final String[] parametros = new String[6];

    try{
    ResourceBundle RB = ResourceBundle.getBundle("GeoPista");
    String rutaMapa = RB.getString("url.mapa.patrimonio");
    parametros[0] = "-map";
    parametros[1] = rutaMapa; 
    parametros[2] = "-closeall";
    parametros[3] = "false";
    parametros[4] = "-properties";
    parametros[5] = "GeopistaHerramientas-properties.xml";
    GEOPISTAWorkbench.main(parametros);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

}