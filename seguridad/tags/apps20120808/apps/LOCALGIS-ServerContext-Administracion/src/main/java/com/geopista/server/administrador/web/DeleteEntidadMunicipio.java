/**
 * 
 */
package com.geopista.server.administrador.web;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

import com.geopista.protocol.CResultadoOperacion;
import com.geopista.protocol.administrador.EntidadMunicipio;

import com.geopista.protocol.net.EnviarSeguro;
import com.geopista.server.LoggerHttpServlet;
import com.geopista.server.database.COperacionesAdministrador;


/**
 * @author seilagamo
 *
 */
public class DeleteEntidadMunicipio extends LoggerHttpServlet {
    private static final long serialVersionUID = -4146217768318971267L;
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DeleteEntidadMunicipio.class);
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CResultadoOperacion resultado = null;
        super.doPost(request);	
        
        try {
            EntidadMunicipio entidadMunicipio = (EntidadMunicipio) Unmarshaller.unmarshal(EntidadMunicipio.class, new StringReader(
                    request.getParameter(EnviarSeguro.mensajeXML)));
            Marshaller.marshal(entidadMunicipio, new OutputStreamWriter(System.out));
            resultado = COperacionesAdministrador.ejecutarDeleteEntidadMunicipio(entidadMunicipio);
        } catch (Exception e) {
            java.io.StringWriter sw = new java.io.StringWriter();
            java.io.PrintWriter pw = new java.io.PrintWriter(sw);
            e.printStackTrace(pw);
            logger.error("Excepci�n al eliminar la relaci�n ENTIDAD-MUNICIPIO: " + sw.toString());
            resultado = new CResultadoOperacion(false, "Excepci�n al eliminar una relaci�n entidad-municipio:"
                    + e.toString());
        }
        Writer writer = response.getWriter();
        writer.write(resultado.buildResponse());
        writer.flush();
        writer.close();
    }
}
