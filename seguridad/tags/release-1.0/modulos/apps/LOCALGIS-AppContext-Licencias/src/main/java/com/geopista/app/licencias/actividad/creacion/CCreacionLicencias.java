package com.geopista.app.licencias.actividad.creacion;

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
import com.geopista.app.utilidades.JNumberTextField;
import com.geopista.app.utilidades.JDialogConfiguracion;
import com.geopista.app.licencias.estructuras.Estructuras;
import com.geopista.app.utilidades.estructuras.ComboBoxEstructuras;
import com.geopista.app.utilidades.estructuras.CellRendererEstructuras;
import com.geopista.app.licencias.*;
import com.geopista.app.licencias.actividad.datosActividad.DatosActividadJPanel;
import com.geopista.app.licencias.actividad.CConstantesLicenciasActividad;
import com.geopista.app.licencias.actividad.MainActividad;
import com.geopista.app.licencias.utilidades.ComboBoxTableEditor;
import com.geopista.app.licencias.utilidades.TextFieldTableEditor;
import com.geopista.app.licencias.utilidades.TextFieldRenderer;
import com.geopista.app.licencias.tableModels.CReferenciasCatastralesTableModel;
import com.geopista.app.licencias.documentacion.DocumentacionLicenciasJPanel;
import com.geopista.app.licencias.consulta.CConsultaLicencias;
import com.geopista.editor.GeopistaEditor;
import com.geopista.protocol.CResultadoOperacion;
import com.geopista.protocol.CConstantesComando;
import com.geopista.protocol.administrador.dominios.DomainNode;
import com.geopista.protocol.licencias.*;
import com.geopista.protocol.licencias.actividad.DatosActividad;
import com.geopista.protocol.licencias.estados.CEstado;
import com.geopista.protocol.licencias.tipos.CTipoLicencia;
import com.geopista.protocol.licencias.tipos.CTipoObra;
import com.geopista.model.GeopistaListener;
import com.geopista.model.GeopistaLayer;
import com.vividsolutions.jump.feature.Feature;
import com.vividsolutions.jump.workbench.model.FeatureEvent;
import com.vividsolutions.jump.workbench.ui.AbstractSelection;
import com.vividsolutions.jump.workbench.ui.ErrorDialog;
import com.vividsolutions.jump.workbench.ui.GUIUtil;
import com.vividsolutions.jump.workbench.ui.IAbstractSelection;
import com.vividsolutions.jump.workbench.ui.task.TaskMonitorDialog;
import com.vividsolutions.jump.util.StringUtil;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.*;
import java.util.*;

/**
 * @author avivar
 */
public class CCreacionLicencias extends javax.swing.JInternalFrame implements IMultilingue{


	Logger logger = Logger.getLogger(CConsultaLicencias.class);
	/**
	 * Datos del Titular
	 */
	private String _DNI_CIF_Titular = "";
	private String _nombreTitular = "";
	private String _apellido1Titular = "";
	private String _apellido2Titular = "";
	//private String _faxTitular = "";
	//private String _movilTitular = "";
	private String _emailTitular = "";
	private String _nombreViaTitular = "";
	private String _numeroViaTitular = "";
	private String _portalTitular = "";
	private String _plantaTitular = "";
	private String _escaleraTitular = "";
	private String _letraTitular = "";
	private String _cPostalTitular = "";
	private String _municipioTitular = "";
	private String _provinciaTitular = "";
	private int _seNotificaTitular = 0;
    private boolean emailTitularObligatorio= false;

	/**
	 * Datos del Representado
	 */
	private String _DNI_CIF_RepresentaA = "";
	private String _nombreRepresentaA = "";
	private String _apellido1RepresentaA = "";
	private String _apellido2RepresentaA = "";
	//private String _faxRepresentaA = "";
	//private String _movilRepresentaA = "";
	private String _emailRepresentaA = "";
	private String _nombreViaRepresentaA = "";
	private String _numeroViaRepresentaA = "";
	private String _portalRepresentaA = "";
	private String _plantaRepresentaA = "";
	private String _escaleraRepresentaA = "";
	private String _letraRepresentaA = "";
	private String _cPostalRepresentaA = "";
	private String _municipioRepresentaA = "";
	private String _provinciaRepresentaA = "";
	private int _seNotificaRepresentaA = 0;
    private boolean _flagRepresentante= false;
    private boolean emailRepresentanteObligatorio= false;
	/**
	 * Datos del Tecnico
	 */
	private String _DNI_CIF_Tecnico = "";
	private String _nombreTecnico = "";
	private String _apellido1Tecnico = "";
	private String _apellido2Tecnico = "";
	private String _colegioTecnico = "";
	private String _visadoTecnico = "";
	private String _titulacionTecnico = "";
	//private String _faxTecnico = "";
	//private String _movilTecnico = "";
	private String _emailTecnico = "";
	private String _nombreViaTecnico = "";
	private String _numeroViaTecnico = "";
	private String _portalTecnico = "";
	private String _plantaTecnico = "";
	private String _escaleraTecnico = "";
	private String _letraTecnico = "";
	private String _cPostalTecnico = "";
	private String _municipioTecnico = "";
	private String _provinciaTecnico = "";
	private int _seNotificaTecnico = 0;
    private boolean _flagTecnico= false;
    private boolean emailTecnicoObligatorio= false;

	/**
	 * Datos del Promotor
	 */
	private String _DNI_CIF_Promotor = "";
	private String _nombrePromotor = "";
	private String _apellido1Promotor = "";
	private String _apellido2Promotor = "";
	private String _colegioPromotor = "";
	private String _visadoPromotor = "";
	private String _titulacionPromotor = "";
	//private String _faxPromotor = "";
	//private String _movilPromotor = "";
	private String _emailPromotor = "";
	private String _nombreViaPromotor = "";
	private String _numeroViaPromotor = "";
	private String _portalPromotor = "";
	private String _plantaPromotor = "";
	private String _escaleraPromotor = "";
	private String _letraPromotor = "";
	private String _cPostalPromotor = "";
	private String _municipioPromotor = "";
	private String _provinciaPromotor = "";
	private int _seNotificaPromotor = 0;
    private boolean _flagPromotor= false;
    private boolean emailPromotorObligatorio= false;

	/**
	 * Datos de la solicitud
	 */
	// Tendra un valor u otro en funcion del TabbedPane seleccionado (CConstantesLicencias.ObraMayor)
	private String _unidadRegistro = "";
	private String _unidadTramitadora = "";
	private String _motivo = "";
	private String _asunto = "";
	private String _observaciones = "";

	/**
	 * por defecto la solicitud es manual y no llega desde Ventanilla Unica
	 */

	private Vector _vEstado = null;
	private Hashtable _hEstado = new Hashtable();


    /** pestanna de documentacion de una solicitud (documentacion requerida, anexos...) */
    private DocumentacionLicenciasJPanel documentacionJPanel;


    private ResourceBundle literales;


	/**
	 * Creates new form CCreacionLicencias
	 */
	public CCreacionLicencias(final JFrame desktop, final ResourceBundle literales) {
		this.desktop = desktop;
        this.literales= literales;
        CUtilidadesComponentes.menuLicenciasSetEnabled(false, this.desktop);

        //***para sacar la ventana de espera**
        final TaskMonitorDialog progressDialog = new TaskMonitorDialog(this.desktop, null);
        progressDialog.setTitle(literales.getString("Licencias.Tag1"));
        progressDialog.addComponentListener(new ComponentAdapter()
        {
            public void componentShown(ComponentEvent e)
            {
                new Thread(new Runnable()
                {
                    public void run()
                    {
                         try
                        {
                            progressDialog.report(literales.getString("Licencias.Tag2"));
                            initComponents();
                            initComboBoxesEstructuras();
                            configureComponents();

                            renombrarComponentes(literales);

                            fechaSolicitudJTField.setEnabled(false);
                            fechaSolicitudJTField.setText(showToday());

                            fechaLimiteObraJTField.setEnabled(false);
                            fechaLimiteObraJTField.setText("");

                            estadoJCBox.setEnabled(false);
                            progressDialog.report(literales.getString("Licencias.Tag1"));
                             if (CUtilidadesComponentes.showGeopistaMap(desktop,editorMapaJPanel, MainActividad.geopistaEditor, 273, false))
                            {
                                GeopistaLayer layer=(GeopistaLayer)MainActividad.geopistaEditor.getLayerManager().getLayer("parcelas");
                                if (layer!=null)
                                {
                                    layer.setEditable(true);
                                    layer.setActiva(true);
                                }
                            } else
                            {
                                new JOptionPane("No existe el mapa licencias actividad en el sistema. \nContacte con el administrador."
                                        , JOptionPane.ERROR_MESSAGE).createDialog(desktop, "ERROR").show();
                            }
                         }catch(Exception e){
                             logger.error("Error ", e);
                             ErrorDialog.show(desktop, "ERROR", "ERROR", StringUtil.stackTrace(e));
                             return;
                         }
                         finally
                         {
                             progressDialog.setVisible(false);
                         }
                     }
               }).start();
           }
        });
        GUIUtil.centreOnWindow(progressDialog);
        progressDialog.setVisible(true);

        MainActividad.geopistaEditor.removeAllGeopistaListener();
        MainActividad.geopistaEditor.addGeopistaListener(new GeopistaListener() {

            public void selectionChanged(IAbstractSelection abtractSelection) {
                logger.info("selectionChanged");
            }

            public void featureAdded(FeatureEvent e) {
                logger.info("featureAdded");
            }

            public void featureRemoved(FeatureEvent e) {
                logger.info("featureRemoved");
            }

            public void featureModified(FeatureEvent e) {
                logger.info("featureModified");
            }

            public void featureActioned(IAbstractSelection abtractSelection) {
                logger.info("featureActioned");
            }

        });

        municipioJTField.setText(CConstantesLicencias.Municipio);
        provinciaJTField.setText(CConstantesLicencias.Provincia);

        rellenarEstadoJCBox();
	}


	private void configureComponents() {

		long tiempoInicial=new Date().getTime();
		if (MainActividad.geopistaEditor == null) MainActividad.geopistaEditor= new GeopistaEditor("workbench-properties-simple.xml");
		logger.info("TIME (new GeopistaEditor()): "+(new Date().getTime()-tiempoInicial));

        try
        {
		    referenciasCatastralesJTableModel = new CReferenciasCatastralesTableModel(new String[]{literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column1"),
                                                                               literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column2"),
                                                                               literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column3"),
                                                                               literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column4"),
                                                                               literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column5"),
                                                                               literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column6"),
                                                                               literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column7"),
                                                                               literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column8"),
                                                                               literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column9"),
                                                                               literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column10"), ""});
        }catch (Exception e)
        {
            logger.error("Excepci�n en los recursos",e);
        }

		referenciasCatastralesJTable.setModel(referenciasCatastralesJTableModel);
		referenciasCatastralesJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		referenciasCatastralesJTable.setCellSelectionEnabled(false);
		referenciasCatastralesJTable.setColumnSelectionAllowed(false);
		referenciasCatastralesJTable.setRowSelectionAllowed(true);
        referenciasCatastralesJTable.getTableHeader().setReorderingAllowed(false);

        referenciasCatastralesJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int j=0; j< referenciasCatastralesJTable.getColumnCount(); j++){
            TableColumn column = referenciasCatastralesJTable.getColumnModel().getColumn(j);

            if (j==1){
                column.setMinWidth(75);
                column.setMaxWidth(150);
                column.setWidth(75);
                column.setPreferredWidth(75);
            }else if (j>2 && j!=10){
                column.setMinWidth(50);
                column.setMaxWidth(100);
                column.setWidth(50);
                column.setPreferredWidth(50);
            }else if (j==10){
                column.setMinWidth(0);
                column.setMaxWidth(0);
                column.setWidth(0);
                column.setPreferredWidth(0);
            }else{
                column.setMinWidth(150);
                column.setMaxWidth(300);
                column.setWidth(150);
                column.setPreferredWidth(150);
            }
            column.setResizable(true);
        }

        // Annadimos a la tabla el editor ComboBox en la segunda columna (tipoVia)
        TableColumn column= referenciasCatastralesJTable.getColumnModel().getColumn(1);
        ComboBoxEstructuras comboBoxEstructuras= new ComboBoxEstructuras(Estructuras.getListaTiposViaINE(), null, literales.getLocale().toString(), true);
        comboBoxEstructuras.setSelectedIndex(0);

        ComboBoxTableEditor comboBoxTableEditor= new ComboBoxTableEditor(comboBoxEstructuras);
        comboBoxTableEditor.setEnabled(true);
        column.setCellEditor(comboBoxTableEditor);

        CellRendererEstructuras renderer =
                new CellRendererEstructuras(literales.getLocale().toString(),Estructuras.getListaTiposViaINE());
        column.setCellRenderer(renderer);

        // Annadimos a la tabla el editor TextField en el resto de columnas
        for (int col=2; col < referenciasCatastralesJTable.getColumnModel().getColumnCount(); col++){
            column= referenciasCatastralesJTable.getColumnModel().getColumn(col);
            TextFieldTableEditor textFieldTableEditor= null;
            if (col == 2){
                // Nombre
                textFieldTableEditor= new TextFieldTableEditor(68);
            }else if (col == 3){
                // Numero
                textFieldTableEditor= new TextFieldTableEditor(8);
            }else if (col == 9){
                // CPostal
                textFieldTableEditor= new TextFieldTableEditor(true, 99999);                
            }else{
                // resto de campos
                textFieldTableEditor= new TextFieldTableEditor(5);
            }
            textFieldTableEditor.setEnabled(true);
            column.setCellEditor(textFieldTableEditor);
            column.setCellRenderer(new TextFieldRenderer());
        }

        /** cnae */
        cnaeTField= new com.geopista.app.utilidades.TextField(16);
        datosSolicitudJPanel.add(cnaeTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 188, 330, -1));

        /** tasa */
        tasaTextField= new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.CURRENCY, new Integer(99999999), true);
        tasaTextField.setSignAllowed(false);
        datosSolicitudJPanel.add(tasaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 209, 100, -1));
        /** impuesto */
        impuestoTextField= new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.CURRENCY, new Integer(99999999), true);
        impuestoTextField.setSignAllowed(false);
        datosSolicitudJPanel.add(impuestoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 209, 100, -1));

        fechaSolicitudJTField.setEnabled(false);
        fechaLimiteObraJTField.setEnabled(false);

		fechaSolicitudJButton.setIcon(com.geopista.app.licencias.CUtilidadesComponentes.iconoZoom);
        fechaLimiteObraJButton.setIcon(com.geopista.app.licencias.CUtilidadesComponentes.iconoZoom);
		nombreJButton.setIcon(com.geopista.app.licencias.CUtilidadesComponentes.iconoZoom);
		referenciaCatastralJButton.setIcon(com.geopista.app.licencias.CUtilidadesComponentes.iconoZoom);
		MapToTableJButton.setIcon(com.geopista.app.licencias.CUtilidadesComponentes.iconoFlechaIzquierda);
		tableToMapJButton.setIcon(com.geopista.app.licencias.CUtilidadesComponentes.iconoFlechaDerecha);

		buscarDNITitularJButton.setIcon(com.geopista.app.licencias.CUtilidadesComponentes.iconoZoom);
		buscarDNIRepresentaAJButton.setIcon(com.geopista.app.licencias.CUtilidadesComponentes.iconoZoom);
		buscarDNITecnicoJButton.setIcon(com.geopista.app.licencias.CUtilidadesComponentes.iconoZoom);
		buscarDNIPromotorJButton.setIcon(com.geopista.app.licencias.CUtilidadesComponentes.iconoZoom);
		deleteRegistroCatastralJButton.setIcon(com.geopista.app.licencias.CUtilidadesComponentes.iconoDeleteParcela);

        /** emplazamiento */
        nombreViaTField= new com.geopista.app.utilidades.TextField(68);
        nombreViaTField.setEditable(true);
        emplazamientoJPanel.add(nombreViaTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 45, 190, -1));

        //numeroViaNumberTField=  new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(99999), true);
        numeroViaNumberTField=  new com.geopista.app.utilidades.TextField(8);
        numeroViaNumberTField.setEditable(true);
        //numeroViaNumberTField.setSignAllowed(false);
        emplazamientoJPanel.add(numeroViaNumberTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 66, 80, -1));

        portalViaTField= new com.geopista.app.utilidades.TextField(5);
        portalViaTField.setEditable(true);
        emplazamientoJPanel.add(portalViaTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 66, 80, -1));

        plantaViaTField= new com.geopista.app.utilidades.TextField(5);
        plantaViaTField.setEditable(true);
        emplazamientoJPanel.add(plantaViaTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 66, 70, -1));

        letraViaTField= new com.geopista.app.utilidades.TextField(5);
        letraViaTField.setEditable(true);
        emplazamientoJPanel.add(letraViaTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 66, 70, -1));

        cpostalViaTField= new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(99999), true);
        cpostalViaTField.setEditable(true);
        cpostalViaTField.setSignAllowed(false);
        emplazamientoJPanel.add(cpostalViaTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 87, 80, -1));

        /** Pestanas */
        jTabbedPaneSolicitud= new JTabbedPane();
        jTabbedPaneSolicitud.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPaneSolicitud.setFont(new java.awt.Font("Arial", 0, 10));
        try{
            jTabbedPaneSolicitud.addTab(CUtilidadesComponentes.annadirAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.obraMayorJPanel.SubTitleTab")), CUtilidadesComponentes.iconoSolicitud, obraMayorJPanel);
        }catch(Exception e){
             jTabbedPaneSolicitud.addTab(CUtilidadesComponentes.annadirAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.obraMayorJPanel.SubTitleTab")), obraMayorJPanel);
        }
        /** anndimos la pestanna con los datos de la actividad */
        datosActividadJPanel= new DatosActividadJPanel(this.desktop, literales);
        datosActividadJPanel.load(null);
        try{
            jTabbedPaneSolicitud.addTab(literales.getString("DatosActividadJPanel.SubTitleTab"), CUtilidadesComponentes.iconoSolicitud, datosActividadJPanel);
        }catch(Exception e){
             jTabbedPaneSolicitud.addTab(literales.getString("DatosActividadJPanel.SubTitleTab"), datosActividadJPanel);
        }

        try{
            jTabbedPaneSolicitud.addTab(CUtilidadesComponentes.annadirAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.titularJPanel.TitleTab")), CUtilidadesComponentes.iconoPersona, titularJPanel);
        }catch(Exception e){
             jTabbedPaneSolicitud.addTab(CUtilidadesComponentes.annadirAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.titularJPanel.TitleTab")), titularJPanel);
        }
        try{
            jTabbedPaneSolicitud.addTab(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.representaAJPanel.TitleTab"), CUtilidadesComponentes.iconoRepresentante, representaAJPanel);
        }catch(Exception e){
            jTabbedPaneSolicitud.addTab(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.representaAJPanel.TitleTab"), representaAJPanel);
        }

        try{
            jTabbedPaneSolicitud.addTab(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.tecnicoJPanel.TitleTab"), CUtilidadesComponentes.iconoPersona, tecnicoJPanel);
        }catch(Exception e){
             jTabbedPaneSolicitud.addTab(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.tecnicoJPanel.TitleTab"), tecnicoJPanel);
        }
        try{
            jTabbedPaneSolicitud.addTab(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.promotorJPanel.TitleTab"), CUtilidadesComponentes.iconoPersona, promotorJPanel);
        }catch(Exception e){
            jTabbedPaneSolicitud.addTab(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.promotorJPanel.TitleTab"), promotorJPanel);
        }
        try{
            obraMayorJTabbedPane.addTab(CUtilidadesComponentes.annadirAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.obraMayorJPanel.TitleTab")), CUtilidadesComponentes.iconoSolicitud, jTabbedPaneSolicitud);
        }catch(Exception e){
            obraMayorJTabbedPane.addTab(CUtilidadesComponentes.annadirAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.obraMayorJPanel.TitleTab")), jTabbedPaneSolicitud);
        }

        /** Annadimos la pestanna de documentacion para la solicitud */
        documentacionJPanel= new DocumentacionLicenciasJPanel(literales);
        documentacionJPanel.setCreacion();

        try{
            obraMayorJTabbedPane.addTab(literales.getString("DocumentacionLicenciasJPanel.title"), CUtilidadesComponentes.iconoDocumentacion, documentacionJPanel);
        }catch(Exception e){
            obraMayorJTabbedPane.addTab(literales.getString("DocumentacionLicenciasJPanel.title"), documentacionJPanel);
        }

	}


	/**
	 * This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    private void initComponents() {//GEN-BEGIN:initComponents
        templateJScrollPane = new javax.swing.JScrollPane();
        templateJPanel = new javax.swing.JPanel();
        obraMayorJTabbedPane = new javax.swing.JTabbedPane();
        obraMayorJPanel = new javax.swing.JPanel();
        datosSolicitudJPanel = new javax.swing.JPanel();
        estadoJLabel = new javax.swing.JLabel();
        tipoObraJLabel = new javax.swing.JLabel();
        unidadTJLabel = new javax.swing.JLabel();
        unidadRJLabel = new javax.swing.JLabel();
        motivoJLabel = new javax.swing.JLabel();
        asuntoJLabel = new javax.swing.JLabel();
        fechaSolicitudJLabel = new javax.swing.JLabel();
        observacionesJLabel = new javax.swing.JLabel();
        estadoJCBox = new javax.swing.JComboBox();
        unidadTJTField = new javax.swing.JTextField();
        unidadRJTField = new javax.swing.JTextField();
        motivoJTField = new javax.swing.JTextField();
        asuntoJTField = new javax.swing.JTextField();
        fechaSolicitudJTField = new javax.swing.JTextField();
        observacionesJScrollPane = new javax.swing.JScrollPane();
        observacionesJTArea = new javax.swing.JTextArea();
        fechaSolicitudJButton = new javax.swing.JButton();
        cnaeJLabel = new javax.swing.JLabel();
        tasaJLabel = new javax.swing.JLabel();
        impuestoJLabel = new javax.swing.JLabel();
        fechaLimiteObraJLabel = new javax.swing.JLabel();
        fechaLimiteObraJTField = new javax.swing.JTextField();
        fechaLimiteObraJButton = new javax.swing.JButton();
        emplazamientoJPanel = new javax.swing.JPanel();
        nombreViaJLabel = new javax.swing.JLabel();
        numeroViaJLabel = new javax.swing.JLabel();
        cPostalJLabel = new javax.swing.JLabel();
        provinciaJLabel = new javax.swing.JLabel();
        municipioJTField = new javax.swing.JTextField();
        provinciaJTField = new javax.swing.JTextField();
        referenciasCatastralesJScrollPane = new javax.swing.JScrollPane();
        referenciasCatastralesJTable = new javax.swing.JTable();
        nombreJButton = new javax.swing.JButton();
        referenciaCatastralJLabel = new javax.swing.JLabel();
        referenciaJTextField = new javax.swing.JTextField();
        referenciaCatastralJButton = new javax.swing.JButton();
        MapToTableJButton = new javax.swing.JButton();
        deleteRegistroCatastralJButton = new javax.swing.JButton();
        tableToMapJButton = new javax.swing.JButton();
        titularJPanel = new javax.swing.JPanel();
        datosPersonalesTitularJPanel = new javax.swing.JPanel();
        DNITitularJLabel = new javax.swing.JLabel();
        DNITitularJTField = new javax.swing.JTextField();
        nombreTitularJLabel = new javax.swing.JLabel();
        nombreTitularJTField = new javax.swing.JTextField();
        apellido1TitularJLabel = new javax.swing.JLabel();
        apellido2TitularJLabel2 = new javax.swing.JLabel();
        apellido1TitularJTField = new javax.swing.JTextField();
        apellido2TitularJTField = new javax.swing.JTextField();
        buscarDNITitularJButton = new javax.swing.JButton();
        datosNotificacionTitularJPanel = new javax.swing.JPanel();
        viaNotificacionTitularJLabel = new javax.swing.JLabel();
        faxTitularJLabel = new javax.swing.JLabel();
        telefonoTitularJLabel = new javax.swing.JLabel();
        movilTitularJLabel = new javax.swing.JLabel();
        emailTitularJLabel = new javax.swing.JLabel();
        tipoViaTitularJLabel = new javax.swing.JLabel();
        nombreViaTitularJLabel = new javax.swing.JLabel();
        numeroViaTitularJLabel = new javax.swing.JLabel();
        portalTitularJLabel = new javax.swing.JLabel();
        plantaTitularJLabel = new javax.swing.JLabel();
        escaleraTitularJLabel = new javax.swing.JLabel();
        letraTitularJLabel = new javax.swing.JLabel();
        cPostalTitularJLabel = new javax.swing.JLabel();
        municipioTitularJLabel = new javax.swing.JLabel();
        provinciaTitularJLabel = new javax.swing.JLabel();
        faxTitularJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(999999999), true);
        telefonoTitularJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(999999999), true);
        movilTitularJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(999999999), true);
        emailTitularJTField = new javax.swing.JTextField();
        nombreViaTitularJTField = new javax.swing.JTextField();
        numeroViaTitularJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(99999), true);
        plantaTitularJTField = new javax.swing.JTextField();
        portalTitularJTField = new javax.swing.JTextField();
        escaleraTitularJTField = new javax.swing.JTextField();
        letraTitularJTField = new javax.swing.JTextField();
        cPostalTitularJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(99999), true);
        municipioTitularJTField = new javax.swing.JTextField();
        provinciaTitularJTField = new javax.swing.JTextField();
        notificarTitularJCheckBox = new javax.swing.JCheckBox();
        notificarTitularJLabel = new javax.swing.JLabel();
        representaAJPanel = new javax.swing.JPanel();
        datosPersonalesRepresentaAJPanel = new javax.swing.JPanel();
        DNIRepresenaAJLabel = new javax.swing.JLabel();
        DNIRepresentaAJTField = new javax.swing.JTextField();
        nombreRepresentaAJLabel = new javax.swing.JLabel();
        nombreRepresentaAJTField = new javax.swing.JTextField();
        apellido1RepresentaAJLabel = new javax.swing.JLabel();
        apellido2RepresentaAJLabel = new javax.swing.JLabel();
        apellido1RepresentaAJTField = new javax.swing.JTextField();
        apellido2RepresentaAJTField = new javax.swing.JTextField();
        buscarDNIRepresentaAJButton = new javax.swing.JButton();
        datosNotificacionRepresentaAJPanel = new javax.swing.JPanel();
        viaNotificacionRepresentaAJLabel = new javax.swing.JLabel();
        faxRepresentaAJLabel = new javax.swing.JLabel();
        telefonoRepresentaAJLabel = new javax.swing.JLabel();
        movilRepresentaAJLabel = new javax.swing.JLabel();
        emailRepresentaAJLabel = new javax.swing.JLabel();
        tipoViaRepresentaAJLabel = new javax.swing.JLabel();
        nombreViaRepresentaAJLabel = new javax.swing.JLabel();
        numeroViaRepresentaAJLabel = new javax.swing.JLabel();
        portalRepresentaAJLabel = new javax.swing.JLabel();
        plantaRepresentaAJLabel = new javax.swing.JLabel();
        escaleraRepresentaAJLabel = new javax.swing.JLabel();
        letraRepresentaAJLabel = new javax.swing.JLabel();
        cPostalRepresentaAJLabel = new javax.swing.JLabel();
        municipioRepresentaAJLabel = new javax.swing.JLabel();
        provinciaRepresentaAJLabel = new javax.swing.JLabel();
        faxRepresentaAJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(999999999), true);
        telefonoRepresentaAJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(999999999), true);
        movilRepresentaAJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(999999999), true);
        emailRepresentaAJTField = new javax.swing.JTextField();
        nombreViaRepresentaAJTField = new javax.swing.JTextField();
        numeroViaRepresentaAJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(99999), true);
        plantaRepresentaAJTField = new javax.swing.JTextField();
        portalRepresentaAJTField = new javax.swing.JTextField();
        escaleraRepresentaAJTField = new javax.swing.JTextField();
        letraRepresentaAJTField = new javax.swing.JTextField();
        cPostalRepresentaAJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(99999), true);
        municipioRepresentaAJTField = new javax.swing.JTextField();
        provinciaRepresentaAJTField = new javax.swing.JTextField();
        notificarRepresentaAJCheckBox = new javax.swing.JCheckBox();
        notificarRepresentaAJLabel = new javax.swing.JLabel();
        tecnicoJPanel = new javax.swing.JPanel();
        datosPersonalesTecnicoJPanel = new javax.swing.JPanel();
        DNITecnicoJLabel = new javax.swing.JLabel();
        DNITecnicoJTField = new javax.swing.JTextField();
        nombreTecnicoJLabel = new javax.swing.JLabel();
        nombreTecnicoJTField = new javax.swing.JTextField();
        apellido1TecnicoJLabel = new javax.swing.JLabel();
        apellido2TecnicoJLabel = new javax.swing.JLabel();
        apellido1TecnicoJTField = new javax.swing.JTextField();
        apellido2TecnicoJTField = new javax.swing.JTextField();
        buscarDNITecnicoJButton = new javax.swing.JButton();
        colegioTecnicoJLabel = new javax.swing.JLabel();
        visadoTecnicoJLabel = new javax.swing.JLabel();
        titulacionTecnicoJLabel = new javax.swing.JLabel();
        colegioTecnicoJTField = new javax.swing.JTextField();
        visadoTecnicoJTField = new javax.swing.JTextField();
        jCheckBoxActividadNoCalificada= new javax.swing.JCheckBox();
        titulacionTecnicoJTField = new javax.swing.JTextField();
        datosNotificacionTecnicoJPanel = new javax.swing.JPanel();
        viaNotificacionTecnicoJLabel = new javax.swing.JLabel();
        faxTecnicoJLabel = new javax.swing.JLabel();
        telefonoTecnicoJLabel = new javax.swing.JLabel();
        movilTecnicoJLabel = new javax.swing.JLabel();
        emailTecnicoJLabel = new javax.swing.JLabel();
        tipoViaTecnicoJLabel = new javax.swing.JLabel();
        nombreViaTecnicoJLabel = new javax.swing.JLabel();
        numeroViaTecnicoJLabel = new javax.swing.JLabel();
        portalTecnicoJLabel = new javax.swing.JLabel();
        plantaTecnicoJLabel = new javax.swing.JLabel();
        escaleraTecnicoJLabel = new javax.swing.JLabel();
        letraTecnicoJLabel = new javax.swing.JLabel();
        cPostalTecnicoJLabel = new javax.swing.JLabel();
        municipioTecnicoJLabel = new javax.swing.JLabel();
        provinciaTecnicoJLabel = new javax.swing.JLabel();
        faxTecnicoJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(999999999), true);
        telefonoTecnicoJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(999999999), true);
        movilTecnicoJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(999999999), true);
        emailTecnicoJTField = new javax.swing.JTextField();
        nombreViaTecnicoJTField = new javax.swing.JTextField();
        numeroViaTecnicoJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(99999), true);
        plantaTecnicoJTField = new javax.swing.JTextField();
        portalTecnicoJTField = new javax.swing.JTextField();
        escaleraTecnicoJTField = new javax.swing.JTextField();
        letraTecnicoJTField = new javax.swing.JTextField();
        cPostalTecnicoJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(99999), true);
        municipioTecnicoJTField = new javax.swing.JTextField();
        provinciaTecnicoJTField = new javax.swing.JTextField();
        notificarTecnicoJCheckBox = new javax.swing.JCheckBox();
        notificarTecnicoJLabel = new javax.swing.JLabel();
        promotorJPanel = new javax.swing.JPanel();
        datosPersonalesPromotorJPanel = new javax.swing.JPanel();
        DNIPromotorJLabel = new javax.swing.JLabel();
        DNIPromotorJTField = new javax.swing.JTextField();
        nombrePromotorJLabel = new javax.swing.JLabel();
        nombrePromotorJTField = new javax.swing.JTextField();
        apellido1PromotorJLabel = new javax.swing.JLabel();
        apellido2PromotorJLabel = new javax.swing.JLabel();
        apellido1PromotorJTField = new javax.swing.JTextField();
        apellido2PromotorJTField = new javax.swing.JTextField();
        buscarDNIPromotorJButton = new javax.swing.JButton();
        colegioPromotorJLabel = new javax.swing.JLabel();
        visadoPromotorJLabel = new javax.swing.JLabel();
        titulacionPromotorJLabel = new javax.swing.JLabel();
        colegioPromotorJTField = new javax.swing.JTextField();
        visadoPromotorJTField = new javax.swing.JTextField();
        titulacionPromotorJTField = new javax.swing.JTextField();
        datosNotificacionPromotorJPanel = new javax.swing.JPanel();
        viaNotificacionPromotorJLabel = new javax.swing.JLabel();
        faxPromotorJLabel = new javax.swing.JLabel();
        telefonoPromotorJLabel = new javax.swing.JLabel();
        movilPromotorJLabel = new javax.swing.JLabel();
        emailPromotorJLabel = new javax.swing.JLabel();
        tipoViaPromotorJLabel = new javax.swing.JLabel();
        nombreViaPromotorJLabel = new javax.swing.JLabel();
        numeroViaPromotorJLabel = new javax.swing.JLabel();
        portalPromotorJLabel = new javax.swing.JLabel();
        plantaPromotorJLabel = new javax.swing.JLabel();
        escaleraPromotorJLabel = new javax.swing.JLabel();
        letraPromotorJLabel = new javax.swing.JLabel();
        cPostalPromotorJLabel = new javax.swing.JLabel();
        municipioPromotorJLabel = new javax.swing.JLabel();
        provinciaPromotorJLabel = new javax.swing.JLabel();
        faxPromotorJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(999999999), true);
        telefonoPromotorJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(999999999), true);
        movilPromotorJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(999999999), true);
        emailPromotorJTField = new javax.swing.JTextField();
        nombreViaPromotorJTField = new javax.swing.JTextField();
        numeroViaPromotorJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(99999), true);
        plantaPromotorJTField = new javax.swing.JTextField();
        portalPromotorJTField = new javax.swing.JTextField();
        escaleraPromotorJTField = new javax.swing.JTextField();
        letraPromotorJTField = new javax.swing.JTextField();
        cPostalPromotorJTField = new com.geopista.app.utilidades.JNumberTextField(JNumberTextField.NUMBER, new Integer(99999), true);
        municipioPromotorJTField = new javax.swing.JTextField();
        provinciaPromotorJTField = new javax.swing.JTextField();
        notificarPromotorJCheckBox = new javax.swing.JCheckBox();
        notificarPromotorJLabel = new javax.swing.JLabel();
        botoneraJPanel = new javax.swing.JPanel();
        aceptarJButton = new javax.swing.JButton();
        cancelarJButton = new javax.swing.JButton();
        editorMapaJPanel = new javax.swing.JPanel();

        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed();
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        templateJPanel.setLayout(new BorderLayout());

        obraMayorJTabbedPane.setFont(new java.awt.Font("Arial", 0, 10));
        obraMayorJTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        obraMayorJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosSolicitudJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosSolicitudJPanel.setBorder(new javax.swing.border.TitledBorder("Datos solicitud"));
        datosSolicitudJPanel.setAutoscrolls(true);
        estadoJLabel.setText("(*) Estado:");
        datosSolicitudJPanel.add(estadoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 41, 150, 20));

        tipoObraJLabel.setText("(*) Tipo Obra:");
        datosSolicitudJPanel.add(tipoObraJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 20));
        datosSolicitudJPanel.add(jCheckBoxActividadNoCalificada, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 20, -1, 20));
        unidadTJLabel.setText("Unidad Tramitadora:");
        datosSolicitudJPanel.add(unidadTJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 62, 150, 20));

        unidadRJLabel.setText("Unidad de Registro:");
        datosSolicitudJPanel.add(unidadRJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, 150, 20));

        motivoJLabel.setText("Motivo:");
        datosSolicitudJPanel.add(motivoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 104, 150, 20));

        asuntoJLabel.setText("Asunto:");
        datosSolicitudJPanel.add(asuntoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 125, 150, 20));

        fechaSolicitudJLabel.setText("(*) Fecha Solicitud:");
        datosSolicitudJPanel.add(fechaSolicitudJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 146, 150, 20));

        observacionesJLabel.setText("Observaciones:");
        datosSolicitudJPanel.add(observacionesJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 232, 150, 20));

        datosSolicitudJPanel.add(estadoJCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 41, 330, 20));

        datosSolicitudJPanel.add(unidadTJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 62, 330, -1));

        datosSolicitudJPanel.add(unidadRJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 83, 330, -1));

        datosSolicitudJPanel.add(motivoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 104, 330, -1));

        datosSolicitudJPanel.add(asuntoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 125, 330, -1));

        datosSolicitudJPanel.add(fechaSolicitudJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 146, 70, -1));

        observacionesJScrollPane.setViewportBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0)));
        observacionesJTArea.setLineWrap(true);
        observacionesJTArea.setRows(3);
        observacionesJTArea.setTabSize(4);
        observacionesJTArea.setWrapStyleWord(true);
        observacionesJTArea.setBorder(null);
        observacionesJTArea.setMaximumSize(new java.awt.Dimension(102, 51));
        observacionesJTArea.setMinimumSize(new java.awt.Dimension(102, 51));
        observacionesJTArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                observacionesJTAreaKeyTyped();
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                observacionesJTAreaKeyReleased();
            }
        });

        observacionesJScrollPane.setViewportView(observacionesJTArea);

        datosSolicitudJPanel.add(observacionesJScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 232, 330, 75));

        fechaSolicitudJButton.setIcon(new javax.swing.ImageIcon(""));
        fechaSolicitudJButton.setToolTipText("");
        fechaSolicitudJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fechaSolicitudJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        fechaSolicitudJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaSolicitudJButtonActionPerformed();
            }
        });

        datosSolicitudJPanel.add(fechaSolicitudJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 146, 20, 20));

        /** cnae */
        datosSolicitudJPanel.add(cnaeJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 188, 150, 20));

        tasaJLabel.setText("Tasa:");
        tasaJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        datosSolicitudJPanel.add(tasaJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 209, 100, 20));

        impuestoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.impuestoJLabel.text"));
        datosSolicitudJPanel.add(impuestoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 209, 150, 20));

        fechaLimiteObraJLabel.setText("Fecha L\u00edmite Obra:");
        datosSolicitudJPanel.add(fechaLimiteObraJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 167, 130, 20));

        datosSolicitudJPanel.add(fechaLimiteObraJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 167, 70, -1));

        fechaLimiteObraJButton.setIcon(new javax.swing.ImageIcon(""));
        fechaLimiteObraJButton.setToolTipText("");
        fechaLimiteObraJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fechaLimiteObraJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        fechaLimiteObraJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaLimiteObraJButtonActionPerformed();
            }
        });

        datosSolicitudJPanel.add(fechaLimiteObraJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 167, 20, 20));

        obraMayorJPanel.add(datosSolicitudJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 518, 317));

        emplazamientoJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emplazamientoJPanel.setBorder(new javax.swing.border.TitledBorder("Emplazamiento"));
        nombreViaJLabel.setText("Tipo v\u00eda / Nombre V\u00eda:");
        emplazamientoJPanel.add(nombreViaJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 150, 20));

        numeroViaJLabel.setText("N\u00ba / Portal / Planta /Letra:");
        emplazamientoJPanel.add(numeroViaJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, 150, 20));

        cPostalJLabel.setText("C.P. / Municipio: ");
        emplazamientoJPanel.add(cPostalJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, 150, 20));

        provinciaJLabel.setText("Provincia:");
        emplazamientoJPanel.add(provinciaJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 108, 150, 20));

        municipioJTField.setEnabled(false);
        emplazamientoJPanel.add(municipioJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 87, 240, -1));

        provinciaJTField.setEnabled(false);
        emplazamientoJPanel.add(provinciaJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 108, 330, -1));

         referenciasCatastralesJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                referenciasCatastralesJTableMouseClicked();
            }
        });

        referenciasCatastralesJScrollPane.setViewportView(referenciasCatastralesJTable);

        emplazamientoJPanel.add(referenciasCatastralesJScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 470, 90));

        nombreJButton.setIcon(new javax.swing.ImageIcon(""));
        nombreJButton.setToolTipText("");
        nombreJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nombreJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        nombreJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreJButtonActionPerformed();
            }
        });

        emplazamientoJPanel.add(nombreJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 45, 20, 20));

        referenciaCatastralJLabel.setText("Referencia catastral:");
        emplazamientoJPanel.add(referenciaCatastralJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 20));

        referenciaJTextField.setEnabled(false);
        emplazamientoJPanel.add(referenciaJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 310, -1));

        referenciaCatastralJButton.setIcon(new javax.swing.ImageIcon(""));
        referenciaCatastralJButton.setToolTipText("");
        referenciaCatastralJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        referenciaCatastralJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        referenciaCatastralJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                referenciaCatastralJButtonActionPerformed();
            }
        });

        emplazamientoJPanel.add(referenciaCatastralJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 20, 20));

        MapToTableJButton.setIcon(new javax.swing.ImageIcon(""));
        MapToTableJButton.setToolTipText("");
        MapToTableJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MapToTableJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        MapToTableJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapToTable();
            }
        });

        emplazamientoJPanel.add(MapToTableJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 20, 20));

        deleteRegistroCatastralJButton.setIcon(new javax.swing.ImageIcon(""));
        deleteRegistroCatastralJButton.setToolTipText("");
        deleteRegistroCatastralJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteRegistroCatastralJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        deleteRegistroCatastralJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRegistroCatastralJButtonActionPerformed();
            }
        });

        emplazamientoJPanel.add(deleteRegistroCatastralJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 20, 20));

        tableToMapJButton.setIcon(new javax.swing.ImageIcon(""));
        tableToMapJButton.setToolTipText("");
        tableToMapJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tableToMapJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        tableToMapJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableToMapJButtonActionPerformed();
            }
        });

        emplazamientoJPanel.add(tableToMapJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 20, 20));

        obraMayorJPanel.add(emplazamientoJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 317, 518, 230));

        titularJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosPersonalesTitularJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosPersonalesTitularJPanel.setBorder(new javax.swing.border.TitledBorder("Datos Personales"));
        DNITitularJLabel.setText("(*) DNI/CIF:");
        datosPersonalesTitularJPanel.add(DNITitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 20));

        DNITitularJTField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DNITitularJTFieldKeyTyped();
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DNITitularJTFieldKeyReleased();
            }
        });

        datosPersonalesTitularJPanel.add(DNITitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 280, -1));

        nombreTitularJLabel.setText("(*) Nombre:");
        datosPersonalesTitularJPanel.add(nombreTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 51, 130, 20));

        datosPersonalesTitularJPanel.add(nombreTitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 51, 300, -1));

        apellido1TitularJLabel.setText("Apellido1:");
        datosPersonalesTitularJPanel.add(apellido1TitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 72, 130, 20));

        apellido2TitularJLabel2.setText("Apellido2:");
        datosPersonalesTitularJPanel.add(apellido2TitularJLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 93, 130, 20));

        datosPersonalesTitularJPanel.add(apellido1TitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 72, 300, -1));

        datosPersonalesTitularJPanel.add(apellido2TitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 93, 300, -1));

        buscarDNITitularJButton.setIcon(new javax.swing.ImageIcon(""));
        buscarDNITitularJButton.setToolTipText("");
        buscarDNITitularJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buscarDNITitularJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        buscarDNITitularJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDNITitularJButtonActionPerformed();
            }
        });

        datosPersonalesTitularJPanel.add(buscarDNITitularJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 20, 20));

        titularJPanel.add(datosPersonalesTitularJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 518, 127));

        datosNotificacionTitularJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosNotificacionTitularJPanel.setBorder(new javax.swing.border.TitledBorder("Datos Notificaci\u00f3n"));
        viaNotificacionTitularJLabel.setText("V\u00eda Notificaci\u00f3n:");
        datosNotificacionTitularJPanel.add(viaNotificacionTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 20));

        faxTitularJLabel.setText("Fax:");
        datosNotificacionTitularJPanel.add(faxTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 41, 130, 20));

        telefonoTitularJLabel.setText("Tel\u00e9fono:");
        datosNotificacionTitularJPanel.add(telefonoTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 62, 130, 20));

        movilTitularJLabel.setText("M\u00f3vil:");
        datosNotificacionTitularJPanel.add(movilTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 83, 130, 20));

        emailTitularJLabel.setText("Email:");
        datosNotificacionTitularJPanel.add(emailTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 104, 130, 20));

        tipoViaTitularJLabel.setText("(*) Tipo V\u00eda:");
        datosNotificacionTitularJPanel.add(tipoViaTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 125, 130, 20));

        nombreViaTitularJLabel.setText("(*) Nombre:");
        datosNotificacionTitularJPanel.add(nombreViaTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 146, 130, 20));

        numeroViaTitularJLabel.setText("(*) N\u00famero:");
        datosNotificacionTitularJPanel.add(numeroViaTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 175, 90, 20));

        portalTitularJLabel.setText("Portal:");
        datosNotificacionTitularJPanel.add(portalTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 238, 50, 20));

        plantaTitularJLabel.setText("Planta:");
        datosNotificacionTitularJPanel.add(plantaTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 196, 70, 20));

        escaleraTitularJLabel.setText("Escalera:");
        datosNotificacionTitularJPanel.add(escaleraTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 259, 60, 20));

        letraTitularJLabel.setText("Letra:");
        datosNotificacionTitularJPanel.add(letraTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 217, 40, 20));

        cPostalTitularJLabel.setText("(*) C\u00f3digo Postal:");
        datosNotificacionTitularJPanel.add(cPostalTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 285, 130, 20));

        municipioTitularJLabel.setText("(*) Municipio:");
        datosNotificacionTitularJPanel.add(municipioTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 306, 130, 20));

        provinciaTitularJLabel.setText("(*) Provincia:");
        datosNotificacionTitularJPanel.add(provinciaTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 327, 130, 20));

        datosNotificacionTitularJPanel.add(faxTitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 41, 300, -1));

        datosNotificacionTitularJPanel.add(telefonoTitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 62, 300, -1));

        datosNotificacionTitularJPanel.add(movilTitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 83, 300, -1));

        datosNotificacionTitularJPanel.add(emailTitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 104, 300, -1));

        datosNotificacionTitularJPanel.add(nombreViaTitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 146, 300, -1));

        datosNotificacionTitularJPanel.add(numeroViaTitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 175, 150, -1));

        datosNotificacionTitularJPanel.add(plantaTitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 196, 150, -1));

        datosNotificacionTitularJPanel.add(portalTitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 238, 150, -1));

        datosNotificacionTitularJPanel.add(escaleraTitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 259, 150, -1));

        datosNotificacionTitularJPanel.add(letraTitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 217, 150, -1));

        datosNotificacionTitularJPanel.add(cPostalTitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 285, 300, -1));

        datosNotificacionTitularJPanel.add(municipioTitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 306, 300, -1));

        datosNotificacionTitularJPanel.add(provinciaTitularJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 327, 300, -1));

        notificarTitularJCheckBox.setEnabled(false);
        notificarTitularJCheckBox.setSelected(true);
        datosNotificacionTitularJPanel.add(notificarTitularJCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 30, -1));

        notificarTitularJLabel.setText("Notificar propietario:");
        datosNotificacionTitularJPanel.add(notificarTitularJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 120, 20));

        titularJPanel.add(datosNotificacionTitularJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 127, 518, 420));

        representaAJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosPersonalesRepresentaAJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosPersonalesRepresentaAJPanel.setBorder(new javax.swing.border.TitledBorder("Datos Personales"));
        DNIRepresenaAJLabel.setText("(*) DNI/CIF:");
        datosPersonalesRepresentaAJPanel.add(DNIRepresenaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 20));

        DNIRepresentaAJTField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DNIRepresentaAJTFieldKeyTyped();
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DNIRepresentaAJTFieldKeyReleased();
            }
        });

        datosPersonalesRepresentaAJPanel.add(DNIRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 280, -1));

        nombreRepresentaAJLabel.setText("(*) Nombre:");
        datosPersonalesRepresentaAJPanel.add(nombreRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 51, 130, 20));

        datosPersonalesRepresentaAJPanel.add(nombreRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 51, 300, -1));

        apellido1RepresentaAJLabel.setText("Apellido1:");
        datosPersonalesRepresentaAJPanel.add(apellido1RepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 72, 130, 20));

        apellido2RepresentaAJLabel.setText("Apellido2:");
        datosPersonalesRepresentaAJPanel.add(apellido2RepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 93, 130, 20));

        datosPersonalesRepresentaAJPanel.add(apellido1RepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 72, 300, -1));

        datosPersonalesRepresentaAJPanel.add(apellido2RepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 93, 300, -1));

        buscarDNIRepresentaAJButton.setIcon(new javax.swing.ImageIcon(""));
        buscarDNIRepresentaAJButton.setToolTipText("");
        buscarDNIRepresentaAJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buscarDNIRepresentaAJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        buscarDNIRepresentaAJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDNIRepresentaAJButtonActionPerformed();
            }
        });

        datosPersonalesRepresentaAJPanel.add(buscarDNIRepresentaAJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 20, 20));

        representaAJPanel.add(datosPersonalesRepresentaAJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 518, 127));

        datosNotificacionRepresentaAJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosNotificacionRepresentaAJPanel.setBorder(new javax.swing.border.TitledBorder("Datos Notificaci\u00f3n"));
        viaNotificacionRepresentaAJLabel.setText("V\u00eda Notificaci\u00f3n:");
        datosNotificacionRepresentaAJPanel.add(viaNotificacionRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 20));

        faxRepresentaAJLabel.setText("Fax:");
        datosNotificacionRepresentaAJPanel.add(faxRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 41, 130, 20));

        telefonoRepresentaAJLabel.setText("Tel\u00e9fono:");
        datosNotificacionRepresentaAJPanel.add(telefonoRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 62, 130, 20));

        movilRepresentaAJLabel.setText("M\u00f3vil:");
        datosNotificacionRepresentaAJPanel.add(movilRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 83, 130, 20));

        emailRepresentaAJLabel.setText("Email:");
        datosNotificacionRepresentaAJPanel.add(emailRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 104, 130, 20));

        tipoViaRepresentaAJLabel.setText("(*) Tipo V\u00eda:");
        datosNotificacionRepresentaAJPanel.add(tipoViaRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 125, 130, 20));

        nombreViaRepresentaAJLabel.setText("(*) Nombre:");
        datosNotificacionRepresentaAJPanel.add(nombreViaRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 146, 100, 20));

        numeroViaRepresentaAJLabel.setText("(*) N\u00famero:");
        datosNotificacionRepresentaAJPanel.add(numeroViaRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 175, 90, 20));

        portalRepresentaAJLabel.setText("Portal:");
        datosNotificacionRepresentaAJPanel.add(portalRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 238, 50, 20));

        plantaRepresentaAJLabel.setText("Planta:");
        datosNotificacionRepresentaAJPanel.add(plantaRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 196, 70, 20));

        escaleraRepresentaAJLabel.setText("Escalera:");
        datosNotificacionRepresentaAJPanel.add(escaleraRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 259, 60, 20));

        letraRepresentaAJLabel.setText("Letra:");
        datosNotificacionRepresentaAJPanel.add(letraRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 217, 40, 20));

        cPostalRepresentaAJLabel.setText("(*) C\u00f3digo Postal:");
        datosNotificacionRepresentaAJPanel.add(cPostalRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 285, 130, 20));

        municipioRepresentaAJLabel.setText("(*) Municipio:");
        datosNotificacionRepresentaAJPanel.add(municipioRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 306, 130, 20));

        provinciaRepresentaAJLabel.setText("(*) Provincia:");
        datosNotificacionRepresentaAJPanel.add(provinciaRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 327, 130, 20));

        datosNotificacionRepresentaAJPanel.add(faxRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 41, 300, -1));

        datosNotificacionRepresentaAJPanel.add(telefonoRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 62, 300, -1));

        datosNotificacionRepresentaAJPanel.add(movilRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 83, 300, -1));

        datosNotificacionRepresentaAJPanel.add(emailRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 104, 300, -1));

        datosNotificacionRepresentaAJPanel.add(nombreViaRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 146, 300, -1));

        datosNotificacionRepresentaAJPanel.add(numeroViaRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 175, 150, -1));

        datosNotificacionRepresentaAJPanel.add(plantaRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 196, 150, -1));

        datosNotificacionRepresentaAJPanel.add(portalRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 238, 150, -1));

        datosNotificacionRepresentaAJPanel.add(escaleraRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 259, 150, -1));

        datosNotificacionRepresentaAJPanel.add(letraRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 217, 150, -1));

        datosNotificacionRepresentaAJPanel.add(cPostalRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 285, 300, -1));

        datosNotificacionRepresentaAJPanel.add(municipioRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 306, 300, -1));

        datosNotificacionRepresentaAJPanel.add(provinciaRepresentaAJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 327, 300, -1));

        datosNotificacionRepresentaAJPanel.add(notificarRepresentaAJCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 30, -1));

        notificarRepresentaAJLabel.setText("Notificar representante:");
        datosNotificacionRepresentaAJPanel.add(notificarRepresentaAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 120, 20));

        representaAJPanel.add(datosNotificacionRepresentaAJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 127, 518, 420));

        tecnicoJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosPersonalesTecnicoJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosPersonalesTecnicoJPanel.setBorder(new javax.swing.border.TitledBorder("Datos Personales"));
        DNITecnicoJLabel.setText("(*) DNI/CIF:");
        datosPersonalesTecnicoJPanel.add(DNITecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 20));

        DNITecnicoJTField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DNITecnicoJTFieldKeyTyped();
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DNITecnicoJTFieldKeyReleased();
            }
        });

        datosPersonalesTecnicoJPanel.add(DNITecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 280, -1));

        nombreTecnicoJLabel.setText("(*) Nombre:");
        datosPersonalesTecnicoJPanel.add(nombreTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 46, 130, 20));

        datosPersonalesTecnicoJPanel.add(nombreTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 46, 300, -1));

        apellido1TecnicoJLabel.setText("Apellido1:");
        datosPersonalesTecnicoJPanel.add(apellido1TecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 67, 130, 20));

        apellido2TecnicoJLabel.setText("Apellido2:");
        datosPersonalesTecnicoJPanel.add(apellido2TecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 88, 130, 20));

        datosPersonalesTecnicoJPanel.add(apellido1TecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 67, 300, -1));

        datosPersonalesTecnicoJPanel.add(apellido2TecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 88, 300, -1));

        buscarDNITecnicoJButton.setIcon(new javax.swing.ImageIcon(""));
        buscarDNITecnicoJButton.setToolTipText("");
        buscarDNITecnicoJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buscarDNITecnicoJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        buscarDNITecnicoJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDNITecnicoJButtonActionPerformed();
            }
        });

        datosPersonalesTecnicoJPanel.add(buscarDNITecnicoJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 20, 20));

        colegioTecnicoJLabel.setText("(*) Colegio:");
        datosPersonalesTecnicoJPanel.add(colegioTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 109, 130, 20));

        visadoTecnicoJLabel.setText("(*) Visado:");
        datosPersonalesTecnicoJPanel.add(visadoTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, 20));

        titulacionTecnicoJLabel.setText("Titulaci\u00f3n:");
        datosPersonalesTecnicoJPanel.add(titulacionTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 151, 130, 20));

        datosPersonalesTecnicoJPanel.add(colegioTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 109, 300, -1));

        datosPersonalesTecnicoJPanel.add(visadoTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 300, -1));

        datosPersonalesTecnicoJPanel.add(titulacionTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 151, 300, -1));

        tecnicoJPanel.add(datosPersonalesTecnicoJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 518, 180));

        datosNotificacionTecnicoJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosNotificacionTecnicoJPanel.setBorder(new javax.swing.border.TitledBorder("Datos Notificaci\u00f3n"));
        viaNotificacionTecnicoJLabel.setText("V\u00eda Notificaci\u00f3n:");
        datosNotificacionTecnicoJPanel.add(viaNotificacionTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 20));

        faxTecnicoJLabel.setText("Fax:");
        datosNotificacionTecnicoJPanel.add(faxTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 41, 130, 20));

        telefonoTecnicoJLabel.setText("Tel\u00e9fono:");
        datosNotificacionTecnicoJPanel.add(telefonoTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 62, 130, 20));

        movilTecnicoJLabel.setText("M\u00f3vil:");
        datosNotificacionTecnicoJPanel.add(movilTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 83, 130, 20));

        emailTecnicoJLabel.setText("Email:");
        datosNotificacionTecnicoJPanel.add(emailTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 104, 130, 20));

        tipoViaTecnicoJLabel.setText("(*) Tipo V\u00eda:");
        datosNotificacionTecnicoJPanel.add(tipoViaTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 125, 130, 20));

        nombreViaTecnicoJLabel.setText("(*) Nombre:");
        datosNotificacionTecnicoJPanel.add(nombreViaTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 146, 130, 20));

        numeroViaTecnicoJLabel.setText("(*) N\u00famero:");
        datosNotificacionTecnicoJPanel.add(numeroViaTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 70, 20));

        portalTecnicoJLabel.setText("Portal:");
        datosNotificacionTecnicoJPanel.add(portalTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 233, 70, 20));

        plantaTecnicoJLabel.setText("Planta:");
        datosNotificacionTecnicoJPanel.add(plantaTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 191, 70, 20));

        escaleraTecnicoJLabel.setText("Escalera:");
        datosNotificacionTecnicoJPanel.add(escaleraTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 254, 70, 20));

        letraTecnicoJLabel.setText("Letra:");
        datosNotificacionTecnicoJPanel.add(letraTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 212, 70, 20));

        cPostalTecnicoJLabel.setText("(*) C\u00f3digo Postal:");
        datosNotificacionTecnicoJPanel.add(cPostalTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 130, 20));

        municipioTecnicoJLabel.setText("(*) Municipio:");
        datosNotificacionTecnicoJPanel.add(municipioTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 301, 130, 20));

        provinciaTecnicoJLabel.setText("(*) Provincia:");
        datosNotificacionTecnicoJPanel.add(provinciaTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 322, 130, 20));

        datosNotificacionTecnicoJPanel.add(faxTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 41, 300, -1));

        datosNotificacionTecnicoJPanel.add(telefonoTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 62, 300, -1));

        datosNotificacionTecnicoJPanel.add(movilTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 83, 300, -1));

        datosNotificacionTecnicoJPanel.add(emailTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 104, 300, -1));

        datosNotificacionTecnicoJPanel.add(nombreViaTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 146, 300, -1));

        datosNotificacionTecnicoJPanel.add(numeroViaTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 150, -1));

        datosNotificacionTecnicoJPanel.add(plantaTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 191, 150, -1));

        datosNotificacionTecnicoJPanel.add(portalTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 233, 150, -1));

        datosNotificacionTecnicoJPanel.add(escaleraTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 254, 150, -1));

        datosNotificacionTecnicoJPanel.add(letraTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 212, 150, -1));

        datosNotificacionTecnicoJPanel.add(cPostalTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 300, -1));

        datosNotificacionTecnicoJPanel.add(municipioTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 301, 300, -1));

        datosNotificacionTecnicoJPanel.add(provinciaTecnicoJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 322, 300, -1));

        notificarTecnicoJCheckBox.setVisible(false);
        datosNotificacionTecnicoJPanel.add(notificarTecnicoJCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 343, 200, -1));

        notificarTecnicoJLabel.setVisible(false);
        notificarTecnicoJLabel.setText("Notificar t\u00e9cnico:");
        datosNotificacionTecnicoJPanel.add(notificarTecnicoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 343, 120, 20));

        tecnicoJPanel.add(datosNotificacionTecnicoJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 518, 367));

        promotorJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosPersonalesPromotorJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosPersonalesPromotorJPanel.setBorder(new javax.swing.border.TitledBorder("Datos Personales"));
        DNIPromotorJLabel.setText("(*) DNI/CIF:");
        datosPersonalesPromotorJPanel.add(DNIPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 20));

        DNIPromotorJTField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DNIPromotorJTFieldKeyTyped();
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DNIPromotorJTFieldKeyReleased();
            }
        });

        datosPersonalesPromotorJPanel.add(DNIPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 280, -1));

        nombrePromotorJLabel.setText("(*) Nombre:");
        datosPersonalesPromotorJPanel.add(nombrePromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 46, 130, 20));

        datosPersonalesPromotorJPanel.add(nombrePromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 46, 300, -1));

        apellido1PromotorJLabel.setText("Apellido1:");
        datosPersonalesPromotorJPanel.add(apellido1PromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 67, 130, 20));

        apellido2PromotorJLabel.setText("Apellido2:");
        datosPersonalesPromotorJPanel.add(apellido2PromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 88, 130, 20));

        datosPersonalesPromotorJPanel.add(apellido1PromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 67, 300, -1));

        datosPersonalesPromotorJPanel.add(apellido2PromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 88, 300, -1));

        buscarDNIPromotorJButton.setIcon(new javax.swing.ImageIcon(""));
        buscarDNIPromotorJButton.setToolTipText("");
        buscarDNIPromotorJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buscarDNIPromotorJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        buscarDNIPromotorJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDNIPromotorJButtonActionPerformed();
            }
        });

        datosPersonalesPromotorJPanel.add(buscarDNIPromotorJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 20, 20));

        colegioPromotorJLabel.setText("(*) Colegio:");
        datosPersonalesPromotorJPanel.add(colegioPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 109, 130, 20));

        visadoPromotorJLabel.setText("(*) Visado:");
        datosPersonalesPromotorJPanel.add(visadoPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, 20));

        titulacionPromotorJLabel.setText("Titulaci\u00f3n:");
        datosPersonalesPromotorJPanel.add(titulacionPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 151, 130, 20));

        datosPersonalesPromotorJPanel.add(colegioPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 109, 300, -1));

        datosPersonalesPromotorJPanel.add(visadoPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 300, -1));

        datosPersonalesPromotorJPanel.add(titulacionPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 151, 300, -1));

        promotorJPanel.add(datosPersonalesPromotorJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 518, 180));

        datosNotificacionPromotorJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosNotificacionPromotorJPanel.setBorder(new javax.swing.border.TitledBorder("Datos Notificaci\u00f3n"));
        viaNotificacionPromotorJLabel.setText("V\u00eda Notificaci\u00f3n:");
        datosNotificacionPromotorJPanel.add(viaNotificacionPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 20));

        faxPromotorJLabel.setText("Fax:");
        datosNotificacionPromotorJPanel.add(faxPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 41, 130, 20));

        telefonoPromotorJLabel.setText("Tel\u00e9fono:");
        datosNotificacionPromotorJPanel.add(telefonoPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 62, 130, 20));

        movilPromotorJLabel.setText("M\u00f3vil:");
        datosNotificacionPromotorJPanel.add(movilPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 83, 130, 20));

        emailPromotorJLabel.setText("Email:");
        datosNotificacionPromotorJPanel.add(emailPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 104, 130, 20));

        tipoViaPromotorJLabel.setText("(*) Tipo V\u00eda:");
        datosNotificacionPromotorJPanel.add(tipoViaPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 125, 130, 20));

        nombreViaPromotorJLabel.setText("(*) Nombre:");
        datosNotificacionPromotorJPanel.add(nombreViaPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 146, 130, 20));

        numeroViaPromotorJLabel.setText("(*) N\u00famero:");
        datosNotificacionPromotorJPanel.add(numeroViaPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 80, 20));

        portalPromotorJLabel.setText("Portal:");
        datosNotificacionPromotorJPanel.add(portalPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 233, 50, 20));

        plantaPromotorJLabel.setText("Planta:");
        datosNotificacionPromotorJPanel.add(plantaPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 191, 80, 20));

        escaleraPromotorJLabel.setText("Escalera:");
        datosNotificacionPromotorJPanel.add(escaleraPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 254, 60, 20));

        letraPromotorJLabel.setText("Letra:");
        datosNotificacionPromotorJPanel.add(letraPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 212, 80, 20));

        cPostalPromotorJLabel.setText("(*) C\u00f3digo Postal:");
        datosNotificacionPromotorJPanel.add(cPostalPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 130, 20));

        municipioPromotorJLabel.setText("(*) Municipio:");
        datosNotificacionPromotorJPanel.add(municipioPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 301, 130, 20));

        provinciaPromotorJLabel.setText("(*) Provincia:");
        datosNotificacionPromotorJPanel.add(provinciaPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 322, 130, 20));

        datosNotificacionPromotorJPanel.add(faxPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 41, 300, -1));

        datosNotificacionPromotorJPanel.add(telefonoPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 62, 300, -1));

        datosNotificacionPromotorJPanel.add(movilPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 83, 300, -1));

        datosNotificacionPromotorJPanel.add(emailPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 104, 300, -1));

        datosNotificacionPromotorJPanel.add(nombreViaPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 146, 300, -1));

        datosNotificacionPromotorJPanel.add(numeroViaPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 150, -1));

        datosNotificacionPromotorJPanel.add(plantaPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 191, 150, -1));

        datosNotificacionPromotorJPanel.add(portalPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 233, 150, -1));

        datosNotificacionPromotorJPanel.add(escaleraPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 254, 150, -1));

        datosNotificacionPromotorJPanel.add(letraPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 212, 150, -1));

        datosNotificacionPromotorJPanel.add(cPostalPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 300, -1));

        datosNotificacionPromotorJPanel.add(municipioPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 301, 300, -1));

        datosNotificacionPromotorJPanel.add(provinciaPromotorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 322, 300, -1));

        notificarPromotorJCheckBox.setVisible(false);
        datosNotificacionPromotorJPanel.add(notificarPromotorJCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 343, 80, 20));

        notificarPromotorJLabel.setVisible(false);
        notificarPromotorJLabel.setText("Notificar promotor:");
        datosNotificacionPromotorJPanel.add(notificarPromotorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 120, 20));

        promotorJPanel.add(datosNotificacionPromotorJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 518, 367));

        templateJPanel.add(obraMayorJTabbedPane, BorderLayout.WEST);

        botoneraJPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(1, 1, 1, 1)));
        aceptarJButton.setText("Crear");
        aceptarJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aceptarJButtonMouseClicked();
            }
        });

        aceptarJButton.setPreferredSize(new Dimension(120,30));
        botoneraJPanel.add(aceptarJButton);

        cancelarJButton.setText("Salir");
        cancelarJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarJButtonMouseClicked();
            }
        });

        cancelarJButton.setPreferredSize(new Dimension(120,30));
        botoneraJPanel.add(cancelarJButton);

        templateJPanel.add(botoneraJPanel, BorderLayout.SOUTH);

        editorMapaJPanel.setLayout(new java.awt.GridLayout(1, 0));

        editorMapaJPanel.setBorder(new javax.swing.border.TitledBorder("Mapa"));
        templateJPanel.add(editorMapaJPanel, BorderLayout.CENTER);

        templateJScrollPane.setViewportView(templateJPanel);

        getContentPane().add(templateJScrollPane);

    }//GEN-END:initComponents

    private void fechaLimiteObraJButtonActionPerformed() {//GEN-FIRST:event_fechaLimiteObraJButtonActionPerformed
        CUtilidadesComponentes.showCalendarDialog(desktop);

        if ((CConstantesLicencias.calendarValue != null) && (!CConstantesLicencias.calendarValue.trim().equals(""))) {
            fechaLimiteObraJTField.setText(CConstantesLicencias.calendarValue);
        }

    }//GEN-LAST:event_fechaLimiteObraJButtonActionPerformed

    private void formInternalFrameClosed() {//GEN-FIRST:event_formInternalFrameClosed
        CConstantesLicencias.helpSetHomeID = "geopistaIntro";
        CUtilidadesComponentes.menuLicenciasSetEnabled(true, this.desktop);
    }//GEN-LAST:event_formInternalFrameClosed

    /** Los estados no pueden redefinirse como dominio, puesto que necesitamos el valor del campo step */
    public void initComboBoxesEstructuras(){

        while (!Estructuras.isCargada())
        {
            if (!Estructuras.isIniciada()) Estructuras.cargarEstructuras();
            try {Thread.sleep(500);}catch(Exception e){}
        }

        /** Inicializamos los comboBox que llevan estructuras */
        tipoObraEJCBox= new ComboBoxEstructuras(Estructuras.getListaTiposActividad(), null, literales.getLocale().toString(), false);
        datosSolicitudJPanel.add(tipoObraEJCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 180, 20));

        viaNotificacionTitularEJCBox= new ComboBoxEstructuras(Estructuras.getListaViasNotificacion(), null, literales.getLocale().toString(), false);
        viaNotificacionTitularEJCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viaNotificacionTitularEJCBoxActionPerformed();}});


        datosNotificacionTitularJPanel.add(viaNotificacionTitularEJCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 300, 20));
        tipoViaNotificacionTitularEJCBox= new ComboBoxEstructuras(Estructuras.getListaTiposViaINE(), null, literales.getLocale().toString(), false);
        datosNotificacionTitularJPanel.add(tipoViaNotificacionTitularEJCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 125, 300, 20));

        viaNotificacionRepresentaAEJCBox= new ComboBoxEstructuras(Estructuras.getListaViasNotificacion(), null, literales.getLocale().toString(), false);
        viaNotificacionRepresentaAEJCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viaNotificacionRepresentaAEJCBoxActionPerformed();}});

        datosNotificacionRepresentaAJPanel.add(viaNotificacionRepresentaAEJCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 300, 20));
        tipoViaNotificacionRepresentaAEJCBox= new ComboBoxEstructuras(Estructuras.getListaTiposViaINE(), null, literales.getLocale().toString(), false);
        datosNotificacionRepresentaAJPanel.add(tipoViaNotificacionRepresentaAEJCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 125, 300, 20));

        viaNotificacionTecnicoEJCBox= new ComboBoxEstructuras(Estructuras.getListaViasNotificacion(), null, literales.getLocale().toString(), false);
        viaNotificacionTecnicoEJCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viaNotificacionTecnicoEJCBoxActionPerformed();}});

        datosNotificacionTecnicoJPanel.add(viaNotificacionTecnicoEJCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 300, 20));
        tipoViaNotificacionTecnicoEJCBox= new ComboBoxEstructuras(Estructuras.getListaTiposViaINE(), null, literales.getLocale().toString(), false);
        datosNotificacionTecnicoJPanel.add(tipoViaNotificacionTecnicoEJCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 125, 300, 20));

        viaNotificacionPromotorEJCBox= new ComboBoxEstructuras(Estructuras.getListaViasNotificacion(), null, literales.getLocale().toString(), false);
        viaNotificacionPromotorEJCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viaNotificacionPromotorEJCBoxActionPerformed();}});

        datosNotificacionPromotorJPanel.add(viaNotificacionPromotorEJCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 300, 20));
        tipoViaNotificacionPromotorEJCBox= new ComboBoxEstructuras(Estructuras.getListaTiposViaINE(), null, literales.getLocale().toString(), false);
        datosNotificacionPromotorJPanel.add(tipoViaNotificacionPromotorEJCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 125, 300, 20));

        tipoViaINEEJCBox= new ComboBoxEstructuras(Estructuras.getListaTiposViaINE(), null, literales.getLocale().toString(), true);
        tipoViaINEEJCBox.setSelectedIndex(0);
        emplazamientoJPanel.add(tipoViaINEEJCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 45, 110, 20));
    }

    private void viaNotificacionTitularEJCBoxActionPerformed() {
        String index= viaNotificacionTitularEJCBox.getSelectedPatron();
        if (index.equalsIgnoreCase(CConstantesLicencias.patronNotificacionEmail)){
            emailTitularJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.emailTitularJLabel.text")));
            emailTitularObligatorio= true;
        }else{
            emailTitularJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.emailTitularJLabel.text"));
            emailTitularObligatorio= false;
        }

    }

    private void viaNotificacionTecnicoEJCBoxActionPerformed() {
        String index= viaNotificacionTecnicoEJCBox.getSelectedPatron();
        if (index.equalsIgnoreCase(CConstantesLicencias.patronNotificacionEmail)){
            emailTecnicoJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.emailTecnicoJLabel.text")));
            emailTecnicoObligatorio= true;
        }else{
            emailTecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.emailTecnicoJLabel.text"));
            emailTecnicoObligatorio= false;
        }

    }


    private void viaNotificacionRepresentaAEJCBoxActionPerformed() {

        String index= viaNotificacionRepresentaAEJCBox.getSelectedPatron();
        if (index.equalsIgnoreCase(CConstantesLicencias.patronNotificacionEmail)){
            emailRepresentaAJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.emailRepresentaAJLabel.text")));
            emailRepresentanteObligatorio= true;
        }else{
            emailRepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.emailRepresentaAJLabel.text"));
            emailRepresentanteObligatorio= false;
        }

    }

    private void viaNotificacionPromotorEJCBoxActionPerformed() {

        String index= viaNotificacionPromotorEJCBox.getSelectedPatron();
        if (index.equalsIgnoreCase(CConstantesLicencias.patronNotificacionEmail)){
            emailPromotorJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.emailPromotorJLabel.text")));
            emailPromotorObligatorio= true;
        }else{
            emailPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.emailPromotorJLabel.text"));
            emailPromotorObligatorio= false;
        }

    }




    private void referenciasCatastralesJTableMouseClicked() {//GEN-FIRST:event_referenciasCatastralesJTableMouseClicked

        try {

            int selectedRow = referenciasCatastralesJTable.getSelectedRow();
            logger.info("selectedRow: " + selectedRow);

            if (selectedRow != -1) {

                logger.info("referenciasCatastralesJTable.getValueAt(selectedRow, 0): " + referenciasCatastralesJTable.getValueAt(selectedRow, 0));

                CConstantesLicenciasActividad.referencia.setReferenciaCatastral((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 0));

                Object objeto=referenciasCatastralesJTableModel.getValueAt(selectedRow, 1);
                String patron=null;
                CConstantesLicenciasActividad.referencia.setTipoVia("");
                if ((objeto instanceof DomainNode) && objeto!=null)
                {
                	CConstantesLicenciasActividad.referencia.setTipoVia(((DomainNode)objeto).getTerm(literales.getLocale().toString()));
                    patron=((DomainNode)objeto).getPatron();
                }
                if ((objeto instanceof String) && objeto!=null)
                {
                    if (((String)objeto).length()>0)
                    {
                    	CConstantesLicenciasActividad.referencia.setTipoVia(Estructuras.getListaTiposViaINE().getDomainNode((String)objeto).getTerm(literales.getLocale().toString()));
                        patron=((String)objeto);
                    }
                }

                CConstantesLicenciasActividad.referencia.setNombreVia((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 2));
                CConstantesLicenciasActividad.referencia.setPrimerNumero((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 3));
                CConstantesLicenciasActividad.referencia.setPrimeraLetra((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 4));
                CConstantesLicenciasActividad.referencia.setBloque((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 5));
                CConstantesLicenciasActividad.referencia.setEscalera((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 6));
                CConstantesLicenciasActividad.referencia.setPlanta((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 7));
                CConstantesLicenciasActividad.referencia.setPuerta((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 8));
                CConstantesLicenciasActividad.referencia.setCPostal((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 9));
                CUtilidadesComponentes.showDatosReferenciaCatastralDialog(desktop, true, literales);

                if (CConstantesLicencias.esDireccionEmplazamiento){
                    referenciaJTextField.setText((String)referenciasCatastralesJTable.getValueAt(selectedRow, 0));

                    //renderBox= (ComboBoxRendererEstructuras) referenciasCatastralesJTable.getCellRenderer(selectedRow, 1);
                    //referenciasCatastralesJTable.prepareRenderer(renderBox, selectedRow, 1);
                    tipoViaINEEJCBox.setSelectedPatron(patron);

                    nombreViaTField.setText((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 2));
                    numeroViaNumberTField.setText((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 3));
                    portalViaTField.setText((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 5));
                    plantaViaTField.setText((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 7));
                    letraViaTField.setText((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 4));
                    // no existe el dato en la referencia catastral
                    cpostalViaTField.setText((String)referenciasCatastralesJTableModel.getValueAt(selectedRow, 9));
                }
            }

        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            logger.error("Exception: " + sw.toString());
        }

    }//GEN-LAST:event_referenciasCatastralesJTableMouseClicked


	private void tableToMapJButtonActionPerformed() {//GEN-FIRST:event_tableToMapJButtonActionPerformed

		refreshFeatureSelection();

	}//GEN-LAST:event_tableToMapJButtonActionPerformed

	private void deleteRegistroCatastralJButtonActionPerformed() {//GEN-FIRST:event_deleteRegistroCatastralJButtonActionPerformed
		int selectedRow = referenciasCatastralesJTable.getSelectedRow();
		logger.info("selectedRow: " + selectedRow);
		if (selectedRow != -1) {
			//CConstantesLicencias.referenciasCatastrales.remove(referenciasCatastralesJTable.getValueAt(selectedRow, 0));
			//logger.info("referenciasCatastralesJTable.getValueAt(selectedRow, 0): " + referenciasCatastralesJTable.getValueAt(selectedRow, 0));
			referenciasCatastralesJTableModel.removeRow(selectedRow);
			refreshFeatureSelection();
		}


	}//GEN-LAST:event_deleteRegistroCatastralJButtonActionPerformed

	private void mapToTable()
    {
		Object[] options = {literales.getString("Licencias.mensaje3"), literales.getString("Licencias.mensaje4")};
		if (JOptionPane.showOptionDialog(this,
				literales.getString("Licencias.mensaje1"),
				literales.getString("Licencias.mensaje2"),
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, //don't use a custom Icon
				options, //the titles of buttons
				options[1])!=JOptionPane.OK_OPTION) return;

    	CUtilidadesComponentes.clearTable(referenciasCatastralesJTableModel);
    	Collection collection = MainActividad.geopistaEditor.getSelection();
		Iterator it = collection.iterator();
		while (it.hasNext()) {
			Feature feature = (Feature) it.next();
        	if (feature == null) {
                logger.error("feature: " + feature);
				continue;
			}
			CReferenciaCatastral referenciaCatastral = CUtilidadesComponentes.getReferenciaCatastral(feature);
            Object[] features= new Object[1];
            features[0]= feature;
			referenciasCatastralesJTableModel.addRow(new Object[]{referenciaCatastral.getReferenciaCatastral(),
																  referenciaCatastral.getTipoVia(),
																  referenciaCatastral.getNombreVia(),
																  referenciaCatastral.getPrimerNumero(),
																  referenciaCatastral.getPrimeraLetra(),
																  referenciaCatastral.getBloque(),
																  referenciaCatastral.getEscalera(),
																  referenciaCatastral.getPlanta(),
																  referenciaCatastral.getPuerta(),
                                                                  referenciaCatastral.getCPostal(), features});
		}
	}//GEN-LAST:event_MapToTableJButtonActionPerformed


	private void referenciaCatastralJButtonActionPerformed() {//GEN-FIRST:event_referenciaCatastralJButtonActionPerformed

		this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

		CUtilidadesComponentes.showReferenciaCatastralDialog(desktop,literales);

		try {

			Enumeration enumerationElement = CConstantesLicencias.referenciasCatastrales.elements();
			while (enumerationElement.hasMoreElements()) {
				CReferenciaCatastral referenciaCatastral = (CReferenciaCatastral) enumerationElement.nextElement();

				referenciasCatastralesJTableModel.addRow(new Object[]{referenciaCatastral.getReferenciaCatastral(),
																	  referenciaCatastral.getTipoVia(),
																	  referenciaCatastral.getNombreVia(),
																	  referenciaCatastral.getPrimerNumero(),
																	  referenciaCatastral.getPrimeraLetra(),
																	  referenciaCatastral.getBloque(),
																	  referenciaCatastral.getEscalera(),
																	  referenciaCatastral.getPlanta(),
																	  referenciaCatastral.getPuerta(),
                                                                      referenciaCatastral.getCPostal(), CUtilidadesComponentes.getFeatureSearched(MainActividad.geopistaEditor, referenciaCatastral.getReferenciaCatastral())});
      		}
			refreshFeatureSelection();

		} catch (Exception ex) {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            logger.error("Exception: " + sw.toString());
		}


		this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));


	}//GEN-LAST:event_referenciaCatastralJButtonActionPerformed


	private boolean refreshFeatureSelection() {

		try {
			this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			MainActividad.geopistaEditor.getSelectionManager().clear();

			GeopistaLayer geopistaLayer = (GeopistaLayer) MainActividad.geopistaEditor.getLayerManager().getLayer("parcelas");

            for (int i=0; i < referenciasCatastralesJTable.getModel().getRowCount(); i++){
				String refCatastral= (String) referenciasCatastralesJTable.getValueAt(i,0);
         		Collection collection = CUtilidadesComponentes.searchByAttribute(geopistaLayer, "Referencia catastral", refCatastral);
				Iterator it = collection.iterator();
				if (it.hasNext()) {
					Feature feature = (Feature) it.next();
					MainActividad.geopistaEditor.select(geopistaLayer, feature);
				}
			}
			MainActividad.geopistaEditor.zoomToSelected();
			this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			return true;
		} catch (Exception ex) {
			logger.error("Exception: ", ex);
			return false;
		}
	}


	private void nombreJButtonActionPerformed() {//GEN-FIRST:event_nombreJButtonActionPerformed


		this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

		CUtilidadesComponentes.showAddressDialog(desktop,literales);

		try {
         	Enumeration enumerationElement = CConstantesLicencias.referenciasCatastrales.elements();
			while (enumerationElement.hasMoreElements()) {
				CReferenciaCatastral referenciaCatastral = (CReferenciaCatastral) enumerationElement.nextElement();

				referenciasCatastralesJTableModel.addRow(new Object[]{referenciaCatastral.getReferenciaCatastral(),
																	  referenciaCatastral.getTipoVia(),
																	  referenciaCatastral.getNombreVia(),
																	  referenciaCatastral.getPrimerNumero(),
																	  referenciaCatastral.getPrimeraLetra(),
																	  referenciaCatastral.getBloque(),
																	  referenciaCatastral.getEscalera(),
																	  referenciaCatastral.getPlanta(),
																	  referenciaCatastral.getPuerta(),
                                                                      referenciaCatastral.getCPostal(), CUtilidadesComponentes.getFeatureSearched(MainActividad.geopistaEditor, referenciaCatastral.getReferenciaCatastral())});
     		}
			refreshFeatureSelection();

		} catch (Exception ex) {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            logger.error("Exception: " + sw.toString());
		}

		this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

	}//GEN-LAST:event_nombreJButtonActionPerformed

	private void buscarDNIPromotorJButtonActionPerformed() {//GEN-FIRST:event_buscarDNIPromotorJButtonActionPerformed

		logger.info("Inicio.");

		CUtilidadesComponentes.showPersonaDialog(desktop,literales);

		if ((CConstantesLicenciasActividad.persona != null) && (CConstantesLicenciasActividad.persona.getDniCif() != null)) {
            DNIPromotorJTField.setText(CConstantesLicenciasActividad.persona.getDniCif());
            nombrePromotorJTField.setText(CConstantesLicenciasActividad.persona.getNombre());
            apellido1PromotorJTField.setText(CConstantesLicenciasActividad.persona.getApellido1());
            apellido2PromotorJTField.setText(CConstantesLicenciasActividad.persona.getApellido2());
            colegioPromotorJTField.setText(CConstantesLicenciasActividad.persona.getColegio());
            visadoPromotorJTField.setText(CConstantesLicenciasActividad.persona.getVisado());
            titulacionPromotorJTField.setText(CConstantesLicenciasActividad.persona.getTitulacion());
            faxPromotorJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getFax());
            telefonoPromotorJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getTelefono());
            movilPromotorJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getMovil());
            emailPromotorJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getEmail());
            try{
                tipoViaNotificacionPromotorEJCBox.setSelectedPatron(CConstantesLicenciasActividad.persona.getDatosNotificacion().getTipoVia());
            }catch (Exception e){
                DomainNode auxNode=Estructuras.getListaTiposViaINE().getDomainNodeByTraduccion(CConstantesLicenciasActividad.persona.getDatosNotificacion().getTipoVia());
                if (auxNode!=null)
                        tipoViaNotificacionPromotorEJCBox.setSelected(auxNode.getIdNode());
            }
            try{
                viaNotificacionPromotorEJCBox.setSelectedPatron(new Integer(CConstantesLicenciasActividad.persona.getDatosNotificacion().getViaNotificacion().getIdViaNotificacion()).toString());
            }catch (Exception e){
                DomainNode auxNode=Estructuras.getListaViasNotificacion().getDomainNodeByTraduccion(new Integer(CConstantesLicenciasActividad.persona.getDatosNotificacion().getViaNotificacion().getIdViaNotificacion()).toString());
                if (auxNode!=null)
                        viaNotificacionPromotorEJCBox.setSelected(auxNode.getIdNode());
            }


            nombreViaPromotorJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getNombreVia());
            numeroViaPromotorJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getNumeroVia());
            plantaPromotorJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getPlanta());
            portalPromotorJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getPortal());
            escaleraPromotorJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getEscalera());
            letraPromotorJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getLetra());
            cPostalPromotorJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getCpostal());
            municipioPromotorJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getMunicipio());
            provinciaPromotorJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getProvincia());
            if (CConstantesLicenciasActividad.persona.getDatosNotificacion().getNotificar().equalsIgnoreCase("1"))
                notificarPromotorJCheckBox.setSelected(true);
            else notificarPromotorJCheckBox.setSelected(false);

		}


	}//GEN-LAST:event_buscarDNIPromotorJButtonActionPerformed

	private void buscarDNITecnicoJButtonActionPerformed() {//GEN-FIRST:event_buscarDNITecnicoJButtonActionPerformed

		logger.info("Inicio.");

		CUtilidadesComponentes.showPersonaDialog(desktop, literales);

		if ((CConstantesLicenciasActividad.persona != null) && (CConstantesLicenciasActividad.persona.getDniCif() != null)) {
            DNITecnicoJTField.setText(CConstantesLicenciasActividad.persona.getDniCif());
            nombreTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getNombre());
            apellido1TecnicoJTField.setText(CConstantesLicenciasActividad.persona.getApellido1());
            apellido2TecnicoJTField.setText(CConstantesLicenciasActividad.persona.getApellido2());
            colegioTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getColegio());
            visadoTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getVisado());
            titulacionTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getTitulacion());
            faxTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getFax());
            telefonoTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getTelefono());
            movilTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getMovil());
            emailTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getEmail());
            try{
                tipoViaNotificacionTecnicoEJCBox.setSelectedPatron(CConstantesLicenciasActividad.persona.getDatosNotificacion().getTipoVia());
            }catch (Exception e){
                DomainNode auxNode=Estructuras.getListaTiposViaINE().getDomainNodeByTraduccion(CConstantesLicenciasActividad.persona.getDatosNotificacion().getTipoVia());
                if (auxNode!=null)
                        tipoViaNotificacionTecnicoEJCBox.setSelected(auxNode.getIdNode());
            }
            try{
                viaNotificacionTecnicoEJCBox.setSelectedPatron(new Integer(CConstantesLicenciasActividad.persona.getDatosNotificacion().getViaNotificacion().getIdViaNotificacion()).toString());
            }catch (Exception e){
                DomainNode auxNode=Estructuras.getListaViasNotificacion().getDomainNodeByTraduccion(new Integer(CConstantesLicenciasActividad.persona.getDatosNotificacion().getViaNotificacion().getIdViaNotificacion()).toString());
                if (auxNode!=null)
                        viaNotificacionTecnicoEJCBox.setSelected(auxNode.getIdNode());
            }


            nombreViaTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getNombreVia());
            numeroViaTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getNumeroVia());
            plantaTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getPlanta());
            portalTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getPortal());
            escaleraTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getEscalera());
            letraTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getLetra());
            cPostalTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getCpostal());
            municipioTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getMunicipio());
            provinciaTecnicoJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getProvincia());
            if (CConstantesLicenciasActividad.persona.getDatosNotificacion().getNotificar().equalsIgnoreCase("1"))
                notificarTecnicoJCheckBox.setSelected(true);
            else notificarTecnicoJCheckBox.setSelected(false);

		}


	}//GEN-LAST:event_buscarDNITecnicoJButtonActionPerformed

	private void buscarDNIRepresentaAJButtonActionPerformed() {//GEN-FIRST:event_buscarDNIRepresentaAJButtonActionPerformed

		logger.info("Inicio.");

		CUtilidadesComponentes.showPersonaDialog(desktop,literales);

		if ((CConstantesLicenciasActividad.persona != null) && (CConstantesLicenciasActividad.persona.getDniCif() != null)) {
            DNIRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getDniCif());
            nombreRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getNombre());
            apellido1RepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getApellido1());
            apellido2RepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getApellido2());
            faxRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getFax());
            telefonoRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getTelefono());
            movilRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getMovil());
            emailRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getEmail());
            try{
                tipoViaNotificacionRepresentaAEJCBox.setSelectedPatron(CConstantesLicenciasActividad.persona.getDatosNotificacion().getTipoVia());
            }catch (Exception e){
                DomainNode auxNode=Estructuras.getListaTiposViaINE().getDomainNodeByTraduccion(CConstantesLicenciasActividad.persona.getDatosNotificacion().getTipoVia());
                if (auxNode!=null)
                        tipoViaNotificacionRepresentaAEJCBox.setSelected(auxNode.getIdNode());
            }
            try{
                viaNotificacionRepresentaAEJCBox.setSelectedPatron(new Integer(CConstantesLicenciasActividad.persona.getDatosNotificacion().getViaNotificacion().getIdViaNotificacion()).toString());
            }catch (Exception e){
                DomainNode auxNode=Estructuras.getListaViasNotificacion().getDomainNodeByTraduccion(new Integer(CConstantesLicenciasActividad.persona.getDatosNotificacion().getViaNotificacion().getIdViaNotificacion()).toString());
                if (auxNode!=null)
                        viaNotificacionRepresentaAEJCBox.setSelected(auxNode.getIdNode());
            }


            nombreViaRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getNombreVia());
            numeroViaRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getNumeroVia());
            plantaRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getPlanta());
            portalRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getPortal());
            escaleraRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getEscalera());
            letraRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getLetra());
            cPostalRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getCpostal());
            municipioRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getMunicipio());
            provinciaRepresentaAJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getProvincia());
            if (CConstantesLicenciasActividad.persona.getDatosNotificacion().getNotificar().equalsIgnoreCase("1"))
                notificarRepresentaAJCheckBox.setSelected(true);
            else notificarRepresentaAJCheckBox.setSelected(false);

		}


	}//GEN-LAST:event_buscarDNIRepresentaAJButtonActionPerformed

	private void buscarDNITitularJButtonActionPerformed() {//GEN-FIRST:event_buscarDNITitularJButtonActionPerformed

		logger.info("Inicio.");

		CUtilidadesComponentes.showPersonaDialog(desktop, literales);

		if ((CConstantesLicenciasActividad.persona != null) && (CConstantesLicenciasActividad.persona.getDniCif() != null)) {
            DNITitularJTField.setText(CConstantesLicenciasActividad.persona.getDniCif());
            nombreTitularJTField.setText(CConstantesLicenciasActividad.persona.getNombre());
            apellido1TitularJTField.setText(CConstantesLicenciasActividad.persona.getApellido1());
            apellido2TitularJTField.setText(CConstantesLicenciasActividad.persona.getApellido2());
            faxTitularJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getFax());
            telefonoTitularJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getTelefono());
            movilTitularJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getMovil());
            emailTitularJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getEmail());
            try{
                tipoViaNotificacionTitularEJCBox.setSelectedPatron(CConstantesLicenciasActividad.persona.getDatosNotificacion().getTipoVia());
            }catch (Exception e){
                DomainNode auxNode=Estructuras.getListaTiposViaINE().getDomainNodeByTraduccion(CConstantesLicenciasActividad.persona.getDatosNotificacion().getTipoVia());
                if (auxNode!=null)
                        tipoViaNotificacionTitularEJCBox.setSelected(auxNode.getIdNode());
            }
            try{
                viaNotificacionTitularEJCBox.setSelectedPatron(new Integer(CConstantesLicenciasActividad.persona.getDatosNotificacion().getViaNotificacion().getIdViaNotificacion()).toString());
            }catch (Exception e){
                DomainNode auxNode=Estructuras.getListaViasNotificacion().getDomainNodeByTraduccion(new Integer(CConstantesLicenciasActividad.persona.getDatosNotificacion().getViaNotificacion().getIdViaNotificacion()).toString());
                if (auxNode!=null)
                        viaNotificacionTitularEJCBox.setSelected(auxNode.getIdNode());
            }


            nombreViaTitularJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getNombreVia());
            numeroViaTitularJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getNumeroVia());
            plantaTitularJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getPlanta());
            portalTitularJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getPortal());
            escaleraTitularJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getEscalera());
            letraTitularJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getLetra());
            cPostalTitularJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getCpostal());
            municipioTitularJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getMunicipio());
            provinciaTitularJTField.setText(CConstantesLicenciasActividad.persona.getDatosNotificacion().getProvincia());
            /*
            if (CConstantesLicenciasActividad.persona.getDatosNotificacion().getNotificar().equalsIgnoreCase("1"))
                notificarTitularJCheckBox.setSelected(true);
            else notificarTitularJCheckBox.setSelected(false);
            */

		}

	}//GEN-LAST:event_buscarDNITitularJButtonActionPerformed


	private void fechaSolicitudJButtonActionPerformed() {//GEN-FIRST:event_fechaSolicitudJButtonActionPerformed


		logger.info("Inicio.");
		CUtilidadesComponentes.showCalendarDialog(desktop);

		if ((CConstantesLicencias.calendarValue != null) && (!CConstantesLicencias.calendarValue.trim().equals(""))) {
			fechaSolicitudJTField.setText(CConstantesLicencias.calendarValue);
		}

	}//GEN-LAST:event_fechaSolicitudJButtonActionPerformed

	private void DNIPromotorJTFieldKeyReleased() {//GEN-FIRST:event_DNIPromotorJTFieldKeyReleased
		if (DNIPromotorJTField.getDocument() != null) {
			if (DNIPromotorJTField.getText().length() <= CConstantesLicencias.MaxLengthDNI) {
				_DNI_CIF_Promotor = DNIPromotorJTField.getText();
			} else if (DNIPromotorJTField.getText().length() > CConstantesLicencias.MaxLengthDNI) {
				DNIPromotorJTField.setText(_DNI_CIF_Promotor);
			}
		}
	}//GEN-LAST:event_DNIPromotorJTFieldKeyReleased

	private void DNIPromotorJTFieldKeyTyped() {//GEN-FIRST:event_DNIPromotorJTFieldKeyTyped
		if (DNIPromotorJTField.getDocument() != null) {
			if (DNIPromotorJTField.getText().length() <= CConstantesLicencias.MaxLengthDNI) {
				_DNI_CIF_Promotor = DNIPromotorJTField.getText();
			} else if (DNIPromotorJTField.getText().length() > CConstantesLicencias.MaxLengthDNI) {
				DNIPromotorJTField.setText(_DNI_CIF_Promotor);
			}
		}
	}//GEN-LAST:event_DNIPromotorJTFieldKeyTyped

	private void DNITecnicoJTFieldKeyReleased() {//GEN-FIRST:event_DNITecnicoJTFieldKeyReleased
		if (DNITecnicoJTField.getDocument() != null) {
			if (DNITecnicoJTField.getText().length() <= CConstantesLicencias.MaxLengthDNI) {
				_DNI_CIF_Tecnico = DNITecnicoJTField.getText();
			} else if (DNITecnicoJTField.getText().length() > CConstantesLicencias.MaxLengthDNI) {
				DNITecnicoJTField.setText(_DNI_CIF_Tecnico);
			}
		}
	}//GEN-LAST:event_DNITecnicoJTFieldKeyReleased

	private void DNITecnicoJTFieldKeyTyped() {//GEN-FIRST:event_DNITecnicoJTFieldKeyTyped
		if (DNITecnicoJTField.getDocument() != null) {
			if (DNITecnicoJTField.getText().length() <= CConstantesLicencias.MaxLengthDNI) {
				_DNI_CIF_Tecnico = DNITecnicoJTField.getText();
			} else if (DNITecnicoJTField.getText().length() > CConstantesLicencias.MaxLengthDNI) {
				DNITecnicoJTField.setText(_DNI_CIF_Tecnico);
			}
		}
	}//GEN-LAST:event_DNITecnicoJTFieldKeyTyped

	private void DNIRepresentaAJTFieldKeyReleased() {//GEN-FIRST:event_DNIRepresentaAJTFieldKeyReleased
		if (DNIRepresentaAJTField.getDocument() != null) {
			if (DNIRepresentaAJTField.getText().length() <= CConstantesLicencias.MaxLengthDNI) {
				_DNI_CIF_RepresentaA = DNIRepresentaAJTField.getText();
			} else if (DNIRepresentaAJTField.getText().length() > CConstantesLicencias.MaxLengthDNI) {
				DNIRepresentaAJTField.setText(_DNI_CIF_RepresentaA);
			}
		}
	}//GEN-LAST:event_DNIRepresentaAJTFieldKeyReleased

	private void DNIRepresentaAJTFieldKeyTyped() {//GEN-FIRST:event_DNIRepresentaAJTFieldKeyTyped
		if (DNIRepresentaAJTField.getDocument() != null) {
			if (DNIRepresentaAJTField.getText().length() <= CConstantesLicencias.MaxLengthDNI) {
				_DNI_CIF_RepresentaA = DNIRepresentaAJTField.getText();
			} else if (DNIRepresentaAJTField.getText().length() > CConstantesLicencias.MaxLengthDNI) {
				DNIRepresentaAJTField.setText(_DNI_CIF_RepresentaA);
			}
		}
	}//GEN-LAST:event_DNIRepresentaAJTFieldKeyTyped

	private void DNITitularJTFieldKeyReleased() {//GEN-FIRST:event_DNITitularJTFieldKeyReleased
		if (DNITitularJTField.getDocument() != null) {
			if (DNITitularJTField.getText().length() <= CConstantesLicencias.MaxLengthDNI) {
				_DNI_CIF_Titular = DNITitularJTField.getText();
			} else if (DNITitularJTField.getText().length() > CConstantesLicencias.MaxLengthDNI) {
				DNITitularJTField.setText(_DNI_CIF_Titular);
			}
		}
	}//GEN-LAST:event_DNITitularJTFieldKeyReleased

	private void DNITitularJTFieldKeyTyped() {//GEN-FIRST:event_DNITitularJTFieldKeyTyped
		if (DNITitularJTField.getDocument() != null) {
			if (DNITitularJTField.getText().length() <= CConstantesLicencias.MaxLengthDNI) {
				_DNI_CIF_Titular = DNITitularJTField.getText();
			} else if (DNITitularJTField.getText().length() > CConstantesLicencias.MaxLengthDNI) {
				DNITitularJTField.setText(_DNI_CIF_Titular);
			}
		}
	}//GEN-LAST:event_DNITitularJTFieldKeyTyped


	private void cancelarJButtonMouseClicked() {//GEN-FIRST:event_cancelarJButtonMouseClicked
        CConstantesLicencias.helpSetHomeID= "licenciasIntro";
		this.dispose();
	}//GEN-LAST:event_cancelarJButtonMouseClicked


	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);

// Get the size of the file
		long length = file.length();

// You cannot create an array using a long type.
// It needs to be an int type.
// Before converting to an int type, check
// to ensure that file is not larger than Integer.MAX_VALUE.
		if (length > Integer.MAX_VALUE) {
// File is too large
		}

// Create the byte array to hold the data
		byte[] bytes = new byte[(int) length];

// Read in the bytes
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}

// Close the input stream and return bytes
		is.close();
		return bytes;
	}


	private void aceptarJButtonMouseClicked() {//GEN-FIRST:event_aceptarJButtonMouseClicked
        try{
            if (rellenaCamposObligatorios()) {
                /** Comprobamos los datos de entrada */

                /** Datos del propietario, representante, tecnico y promotor */
                if (datosTitularOK() && datosRepresentaAOK() && datosTecnicoOK() && datosPromotorOK()) {
                    /** Datos de la solicitud */
                    int index = estadoJCBox.getSelectedIndex();
                    CEstado estado = (CEstado) _hEstado.get(new Integer(index));

    // TRAZAS-----------------------------------------
    /*
    System.out.println("indexSelected="+_estado + " valorSelected="+estadoJCBox.getSelectedItem());
    for (int t=0; t<_vEstado.size(); t++){
         CEstado e= (CEstado)_vEstado.get(t);
         System.out.println("t="+t+ " valor="+e.getDescripcion());
    }
    */
    //-------------------------------------------------
                    CTipoObra tipoObra = new CTipoObra((new Integer(tipoObraEJCBox.getSelectedPatron())).intValue(), "", "");

                    _unidadRegistro = unidadRJTField.getText();
                    _unidadTramitadora = unidadTJTField.getText();
                    if (excedeLongitud(_unidadRegistro, CConstantesLicencias.MaxLengthUnidad) || excedeLongitud(_unidadTramitadora, CConstantesLicencias.MaxLengthUnidad)) {
                        mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.SolicitudTab.mensaje1"));
                        return;
                    }

                    _motivo = motivoJTField.getText();
                    if (excedeLongitud(_motivo, CConstantesLicencias.MaxLengthMotivo)) {
                        mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.SolicitudTab.mensaje2"));
                        return;
                    }
                    _asunto = asuntoJTField.getText();
                    if (excedeLongitud(_asunto, CConstantesLicencias.MaxLengthAsunto)) {
                        mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.SolicitudTab.mensaje3"));
                        return;
                    }

                    _observaciones = observacionesJTArea.getText();
                    if (excedeLongitud(_observaciones, CConstantesLicencias.MaxLengthObservaciones)) {
                        mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.SolicitudTab.mensaje5"));
                        return;
                    }


    //***********************************************
    //** Datos del titular
    //*****************************************

                    int viaNotificacionIndex = new Integer(viaNotificacionTitularEJCBox.getSelectedPatron()).intValue();
                    CViaNotificacion viaNotificacion= new CViaNotificacion(viaNotificacionIndex, "");

                    if ((_seNotificaRepresentaA == 0) && (_seNotificaTecnico == 0) && (_seNotificaPromotor == 0))
                        _seNotificaTitular= 1;

                    String fax= "";
                    try{fax= faxTitularJTField.getNumber().toString();}catch(Exception e){}
                    String telefono= "";
                    try{telefono= telefonoTitularJTField.getNumber().toString();}catch (Exception e){}
                    String movil= "";
                    try{movil=  movilTitularJTField.getNumber().toString();}catch(Exception e){}
                    String numero= "";
                    try{numero= numeroViaTitularJTField.getNumber().toString();}catch(Exception e){}
                    String cPostal= "";
                    try{cPostal= cPostalTitularJTField.getNumber().toString();}catch(Exception e){}
                    CDatosNotificacion datosNotificacion = new CDatosNotificacion(DNITitularJTField.getText().trim(),
                            viaNotificacion,
                            fax,
                            telefono,
                            movil,
                            emailTitularJTField.getText().trim(),
                            tipoViaNotificacionTitularEJCBox.getSelectedPatron(),
                            nombreViaTitularJTField.getText().trim(),
                            numero,
                            portalTitularJTField.getText().trim(),
                            plantaTitularJTField.getText().trim(),
                            escaleraTitularJTField.getText().trim(),
                            letraTitularJTField.getText().trim(),
                            cPostal,
                            municipioTitularJTField.getText().trim(),
                            provinciaTitularJTField.getText().trim(),
                            new Integer(_seNotificaTitular).toString());

                    logger.info("viaNotificacion.getIdViaNotificacion(): " + viaNotificacion.getIdViaNotificacion());
                    logger.info("datosNotificacion.getNotificar(): " + datosNotificacion.getNotificar());

                    CPersonaJuridicoFisica propietario = new CPersonaJuridicoFisica(DNITitularJTField.getText().trim(),
                            nombreTitularJTField.getText().trim(),
                            apellido1TitularJTField.getText().trim(),
                            apellido2TitularJTField.getText().trim(),
                            "",
                            "",
                            "",
                            datosNotificacion);



    //***********************************************
    //** Datos del Representante
    //*****************************************
                    CPersonaJuridicoFisica representante= new CPersonaJuridicoFisica();

                    if (_flagRepresentante){
                        viaNotificacionIndex = new Integer(viaNotificacionRepresentaAEJCBox.getSelectedPatron()).intValue();
                        viaNotificacion= new CViaNotificacion(viaNotificacionIndex, "");

                        fax= "";
                        try{fax= faxRepresentaAJTField.getNumber().toString();}catch(Exception e){}
                        telefono= "";
                        try{telefono= telefonoRepresentaAJTField.getNumber().toString();}catch (Exception e){}
                        movil= "";
                        try{movil=  movilRepresentaAJTField.getNumber().toString();}catch(Exception e){}
                        numero= "";
                        try{numero= numeroViaRepresentaAJTField.getNumber().toString();}catch(Exception e){}
                        cPostal= "";
                        try{cPostal= cPostalRepresentaAJTField.getNumber().toString();}catch(Exception e){}
                        datosNotificacion = new CDatosNotificacion(DNIRepresentaAJTField.getText().trim(),
                                viaNotificacion,
                                fax,
                                telefono,
                                movil,
                                emailRepresentaAJTField.getText().trim(),
                                tipoViaNotificacionRepresentaAEJCBox.getSelectedPatron(),
                                nombreViaRepresentaAJTField.getText().trim(),
                                numero,
                                portalRepresentaAJTField.getText().trim(),
                                plantaRepresentaAJTField.getText().trim(),
                                escaleraRepresentaAJTField.getText().trim(),
                                letraRepresentaAJTField.getText().trim(),
                                cPostal,
                                municipioRepresentaAJTField.getText().trim(),
                                provinciaRepresentaAJTField.getText().trim(),
                                (notificarRepresentaAJCheckBox.isSelected() ? "1" : "0"));

                        logger.info("viaNotificacion.getIdViaNotificacion(): " + viaNotificacion.getIdViaNotificacion());
                        logger.info("datosNotificacion.getNotificar(): " + datosNotificacion.getNotificar());

                        representante = new CPersonaJuridicoFisica(DNIRepresentaAJTField.getText().trim(),
                                nombreRepresentaAJTField.getText().trim(),
                                apellido1RepresentaAJTField.getText().trim(),
                                apellido2RepresentaAJTField.getText().trim(),
                                "",
                                "",
                                "",
                                datosNotificacion);
                    }else representante= null;


    //***********************************************
    //** Datos del Tecnico
    //*****************************************
                    Vector vTecnicos= new Vector();
                    if (_flagTecnico){
                        CPersonaJuridicoFisica tecnico= new CPersonaJuridicoFisica();
                        viaNotificacionIndex = new Integer(viaNotificacionTecnicoEJCBox.getSelectedPatron()).intValue();
                        viaNotificacion= new CViaNotificacion(viaNotificacionIndex, "");

                        fax= "";
                        try{fax= faxTecnicoJTField.getNumber().toString();}catch(Exception e){}
                        telefono= "";
                        try{telefono= telefonoTecnicoJTField.getNumber().toString();}catch (Exception e){}
                        movil= "";
                        try{movil=  movilTecnicoJTField.getNumber().toString();}catch(Exception e){}
                        numero= "";
                        try{numero= numeroViaTecnicoJTField.getNumber().toString();}catch(Exception e){}
                        cPostal= "";
                        try{cPostal= cPostalTecnicoJTField.getNumber().toString();}catch(Exception e){}
                        datosNotificacion = new CDatosNotificacion(DNITecnicoJTField.getText().trim(),
                                viaNotificacion,
                                fax,
                                telefono,
                                movil,
                                emailTecnicoJTField.getText().trim(),
                                tipoViaNotificacionTecnicoEJCBox.getSelectedPatron().trim(),
                                nombreViaTecnicoJTField.getText().trim(),
                                numero,
                                portalTecnicoJTField.getText().trim(),
                                plantaTecnicoJTField.getText().trim(),
                                escaleraTecnicoJTField.getText().trim(),
                                letraTecnicoJTField.getText().trim(),
                                cPostal,
                                municipioTecnicoJTField.getText().trim(),
                                provinciaTecnicoJTField.getText().trim(),
                                (notificarTecnicoJCheckBox.isSelected() ? "1" : "0"));

                        logger.info("viaNotificacion.getIdViaNotificacion(): " + viaNotificacion.getIdViaNotificacion());
                        logger.info("datosNotificacion.getNotificar(): " + datosNotificacion.getNotificar());


                        tecnico= new CPersonaJuridicoFisica(DNITecnicoJTField.getText().trim(),
                                nombreTecnicoJTField.getText().trim(),
                                apellido1TecnicoJTField.getText().trim(),
                                apellido2TecnicoJTField.getText().trim(),
                                colegioTecnicoJTField.getText().trim(),
                                visadoTecnicoJTField.getText().trim(),
                                titulacionTecnicoJTField.getText().trim(),
                                datosNotificacion);
                        vTecnicos.add(tecnico);
                    }







    //***********************************************
    //** Datos del Promotor
    //*****************************************
                    CPersonaJuridicoFisica promotor= new CPersonaJuridicoFisica();

                    if (_flagPromotor){
                        viaNotificacionIndex = new Integer(viaNotificacionPromotorEJCBox.getSelectedPatron()).intValue();
                        viaNotificacion= new CViaNotificacion(viaNotificacionIndex, "");

                        fax= "";
                        try{fax= faxPromotorJTField.getNumber().toString();}catch(Exception e){}
                        telefono= "";
                        try{telefono= telefonoPromotorJTField.getNumber().toString();}catch (Exception e){}
                        movil= "";
                        try{movil=  movilPromotorJTField.getNumber().toString();}catch(Exception e){}
                        numero= "";
                        try{numero= numeroViaPromotorJTField.getNumber().toString();}catch(Exception e){}
                        cPostal= "";
                        try{cPostal= cPostalPromotorJTField.getNumber().toString();}catch(Exception e){}
                        datosNotificacion = new CDatosNotificacion(DNIPromotorJTField.getText().trim(),
                                viaNotificacion,
                                fax,
                                telefono,
                                movil,
                                emailPromotorJTField.getText().trim(),
                                tipoViaNotificacionPromotorEJCBox.getSelectedPatron(),
                                nombreViaPromotorJTField.getText().trim(),
                                numero,
                                portalPromotorJTField.getText().trim(),
                                plantaPromotorJTField.getText().trim(),
                                escaleraPromotorJTField.getText().trim(),
                                letraPromotorJTField.getText().trim(),
                                cPostal,
                                municipioPromotorJTField.getText().trim(),
                                provinciaPromotorJTField.getText().trim(),
                                (notificarPromotorJCheckBox.isSelected() ? "1" : "0"));


                        logger.info("viaNotificacion.getIdViaNotificacion(): " + viaNotificacion.getIdViaNotificacion());
                        logger.info("datosNotificacion.getNotificar(): " + datosNotificacion.getNotificar());

                        promotor = new CPersonaJuridicoFisica(DNIPromotorJTField.getText().trim(),
                                nombrePromotorJTField.getText().trim(),
                                apellido1PromotorJTField.getText().trim(),
                                apellido2PromotorJTField.getText().trim(),
                                colegioPromotorJTField.getText().trim(),
                                visadoPromotorJTField.getText().trim(),
                                titulacionPromotorJTField.getText().trim(),
                                datosNotificacion);
                    }else promotor= null;




                    CTipoLicencia tipoLicencia = new CTipoLicencia((jCheckBoxActividadNoCalificada.isSelected()?
                            CConstantesLicencias.ActividadesNoCalificadas:CConstantesLicencias.Actividades), "", "");
                    CExpedienteLicencia expedienteLicencia = new CExpedienteLicencia(estado);
                    //A�adimos los par�metros de la configuracion
                    expedienteLicencia.setServicioEncargado(JDialogConfiguracion.getServicioActividades());
                    expedienteLicencia.setFormaInicio(JDialogConfiguracion.getInicioActividades());
                    expedienteLicencia.setResponsable(JDialogConfiguracion.getResponsableActividades());

                    expedienteLicencia.setCNAE(cnaeTField.getText().trim());

                    /** REFERENCIAS CATASTRALES */
                    Vector referenciasCatastrales = new Vector();
                    for (int i = 0; i < referenciasCatastralesJTable.getRowCount(); i++) {

                        /** tipoVia */
                        String tipoVia= null;
                        Object objeto=referenciasCatastralesJTableModel.getValueAt(i, 1);
                        if ((objeto instanceof DomainNode) && objeto!=null)
                        {
                            CConstantesLicenciasActividad.referencia.setTipoVia(((DomainNode)objeto).getTerm(literales.getLocale().toString()));
                            tipoVia=((DomainNode)objeto).getPatron();
                        }
                        if ((objeto instanceof String) && objeto!=null)
                        {
                            if (((String)objeto).length()>0)
                            {
                            	CConstantesLicenciasActividad.referencia.setTipoVia(Estructuras.getListaTiposViaINE().getDomainNode((String)objeto).getTerm(literales.getLocale().toString()));
                                tipoVia=((String)objeto);
                            }
                        }


                        String ref_Catastral = (String) referenciasCatastralesJTable.getValueAt(i, 0);

                        String nombre= null;
                        if ((((String)referenciasCatastralesJTable.getValueAt(i, 2)) != null) && (!((String)referenciasCatastralesJTable.getValueAt(i, 2)).trim().equalsIgnoreCase(""))){
                           nombre= ((String)referenciasCatastralesJTable.getValueAt(i, 2)).trim();
                        }
                        numero= null;
                        if ((((String)referenciasCatastralesJTable.getValueAt(i, 3)) != null) && (!((String)referenciasCatastralesJTable.getValueAt(i, 3)).trim().equalsIgnoreCase(""))){
                           numero= ((String)referenciasCatastralesJTable.getValueAt(i, 3)).trim();
                        }
                        String letra= null;
                        if ((((String)referenciasCatastralesJTable.getValueAt(i, 4)) != null) && (!((String)referenciasCatastralesJTable.getValueAt(i, 4)).trim().equalsIgnoreCase(""))){
                           letra= ((String)referenciasCatastralesJTable.getValueAt(i, 4)).trim();
                        }
                        String bloque= null;
                        if ((((String)referenciasCatastralesJTable.getValueAt(i, 5)) != null) && (!((String)referenciasCatastralesJTable.getValueAt(i, 5)).trim().equalsIgnoreCase(""))){
                           bloque= ((String)referenciasCatastralesJTable.getValueAt(i, 5)).trim();
                        }
                        String escalera= null;
                        if ((((String)referenciasCatastralesJTable.getValueAt(i, 6)) != null) && (!((String)referenciasCatastralesJTable.getValueAt(i, 6)).trim().equalsIgnoreCase(""))){
                           escalera= ((String)referenciasCatastralesJTable.getValueAt(i, 6)).trim();
                        }
                        String planta= null;
                        if ((((String)referenciasCatastralesJTable.getValueAt(i, 7)) != null) && (!((String)referenciasCatastralesJTable.getValueAt(i, 7)).trim().equalsIgnoreCase(""))){
                           planta= ((String)referenciasCatastralesJTable.getValueAt(i, 7)).trim();
                        }
                        String puerta= null;
                        if ((((String)referenciasCatastralesJTable.getValueAt(i, 8)) != null) && (!((String)referenciasCatastralesJTable.getValueAt(i, 8)).trim().equalsIgnoreCase(""))){
                           puerta= ((String)referenciasCatastralesJTable.getValueAt(i, 8)).trim();
                        }
                        String cpostal= null;
                        if ((((String)referenciasCatastralesJTable.getValueAt(i, 9)) != null) && (!((String)referenciasCatastralesJTable.getValueAt(i, 9)).trim().equalsIgnoreCase(""))){
                           cpostal= ((String)referenciasCatastralesJTable.getValueAt(i, 9)).trim();
                        }

                        CReferenciaCatastral referenciaCatastral = new CReferenciaCatastral(ref_Catastral, tipoVia, nombre, numero, letra, bloque, escalera, planta, puerta);
                        referenciaCatastral.setCPostal(cpostal);

                        referenciasCatastrales.add(referenciaCatastral);

                    }

                    double tasa= 0.00;
                    try {
                        tasa= tasaTextField.getNumber().doubleValue();
                    } catch (Exception ex) {
                        logger.warn("Tasa no v�lida. tasaTextField.getText(): " + tasaTextField.getText());
                    }

                    double impuesto= 0.00;
                    try {
                        impuesto= impuestoTextField.getNumber().doubleValue();
                    } catch (Exception ex) {
                        logger.warn("Impuesto no v�lida. impuestoTextField.getText(): " + impuestoTextField.getText());
                    }

                    /** EMPLAZAMIENTO */
                    String tipoViaINE= null;
                    if (tipoViaINEEJCBox.getSelectedIndex()!=0){
                          tipoViaINE= tipoViaINEEJCBox.getSelectedPatron();
                    }
                    String nombreViaEmplazamiento= null;
                    if (nombreViaTField.getText().trim().length() > 0){
                        nombreViaEmplazamiento= nombreViaTField.getText().trim();
                    }
                    String numeroViaEmplazamiento= null;
                    try{
                        //numeroViaEmplazamiento= numeroViaNumberTField.getNumber().toString();
                        numeroViaEmplazamiento= numeroViaNumberTField.getText().trim();
                    }catch(Exception e){}
                    String plantaViaEmplazamiento= null;
                    if (plantaViaTField.getText().trim().length() > 0){
                        plantaViaEmplazamiento= plantaViaTField.getText().trim();
                    }
                    String portalViaEmplazamiento= null;
                    if (portalViaTField.getText().trim().length() > 0){
                        portalViaEmplazamiento= portalViaTField.getText().trim();
                    }
                    String letraViaEmplazamiento= null;
                    if (letraViaTField.getText().trim().length() > 0){
                        letraViaEmplazamiento= letraViaTField.getText().trim();
                    }
                    String cPostalEmplazamiento= null;
                    try{
                        cPostalEmplazamiento= String.valueOf(cpostalViaTField.getNumber());
                    }catch(Exception e){}


                    CSolicitudLicencia solicitudLicencia = new CSolicitudLicencia(tipoLicencia,
                            tipoObra,
                            propietario,
                            representante,
                            null,
                            promotor,
                            "",
                            "",
                            unidadTJTField.getText(),
                            unidadRJTField.getText(),
                            motivoJTField.getText(),
                            asuntoJTField.getText(),
                            CUtilidades.getDate(fechaSolicitudJTField.getText()),
                            tasa,
                            tipoViaINE,
                            nombreViaEmplazamiento,
                            numeroViaEmplazamiento,
                            portalViaEmplazamiento,
                            plantaViaEmplazamiento,
                            letraViaEmplazamiento,
                            cPostalEmplazamiento,
                            municipioJTField.getText(),
                            provinciaJTField.getText(),
                            observacionesJTArea.getText(),
                            documentacionJPanel.getAnexos(),
                            referenciasCatastrales);

                    /** Documentacion entregada de caracter obligatorio */
                    solicitudLicencia.setDocumentacionEntregada(documentacionJPanel.getDocumentacionObligatoriaSeleccionada());
                    solicitudLicencia.setObservacionesDocumentacionEntregada(documentacionJPanel.getObservacionesGenerales());

                    /** Tecnicos */
                    solicitudLicencia.setTecnicos(vTecnicos);
                    /** Impuesto */
                    solicitudLicencia.setImpuesto(impuesto);
                    /** Fecha resolucion */
                    solicitudLicencia.setFechaResolucion(null);
                    /** fecha limite de obra */
                    Date dateFechaLimite= CUtilidades.parseFechaStringToDate(fechaLimiteObraJTField.getText());
                    solicitudLicencia.setFechaLimiteObra(dateFechaLimite);
                    /** datos de actividad */
                    DatosActividad datosActividad= datosActividadJPanel.getDatosActividad();
                    solicitudLicencia.setDatosActividad(datosActividad);

                    CResultadoOperacion resultado = COperacionesLicencias.crearExpediente(solicitudLicencia, expedienteLicencia);
                    logger.info("resultado.getResultado(): " + resultado.getResultado());
                    logger.info("resultado.getDescripcion(): " + resultado.getDescripcion());

                    this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    if (resultado.getResultado()){
                        mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.SolicitudTab.mensaje16")+ " " + resultado.getDescripcion());
                        CUtilidadesComponentes.addFeatureCapa(MainActividad.geopistaEditor, "licencias_actividad", referenciasCatastralesJTable, referenciasCatastralesJTableModel);
                        refreshFeatureSelection();
                        clearAll();
                    }
                    else{
                        /** Comprobamos que no se haya excedido el maximo FileUploadBase.SizeLimitExceededException */
                       if (resultado.getDescripcion().equalsIgnoreCase("FileUploadBase.SizeLimitExceededException")){
                           JOptionPane optionPane= new JOptionPane(literales.getString("AnexosJPanel.Message1"), JOptionPane.ERROR_MESSAGE);
                           JDialog dialog =optionPane.createDialog(this,"ERROR");
                           dialog.show();
                       }else{
                         JOptionPane optionPane= new JOptionPane(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.SolicitudTab.mensaje19") + "\n"+resultado.getDescripcion(),JOptionPane.ERROR_MESSAGE);
                         JDialog dialog =optionPane.createDialog(this,"ERROR");
                         dialog.show();
                       }
                    }
                }
            } else {
                mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.SolicitudTab.mensaje17"));
            }
        }catch(Exception ex){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            logger.error("Exception: " + sw.toString());
        }

	}//GEN-LAST:event_aceptarJButtonMouseClicked


	private void observacionesJTAreaKeyReleased() {//GEN-FIRST:event_observacionesJTAreaKeyReleased
		if (observacionesJTArea.getDocument() != null) {
			if (observacionesJTArea.getText().length() <= CConstantesLicencias.MaxLengthObservaciones) {
				_observaciones = observacionesJTArea.getText();
			} else if (observacionesJTArea.getText().length() > CConstantesLicencias.MaxLengthObservaciones) {
				observacionesJTArea.setText(_observaciones);
			}
		}
	}//GEN-LAST:event_observacionesJTAreaKeyReleased

	private void observacionesJTAreaKeyTyped() {//GEN-FIRST:event_observacionesJTAreaKeyTyped
		if (observacionesJTArea.getDocument() != null) {
			if (observacionesJTArea.getText().length() <= CConstantesLicencias.MaxLengthObservaciones) {
				_observaciones = observacionesJTArea.getText();
			} else if (observacionesJTArea.getText().length() > CConstantesLicencias.MaxLengthObservaciones) {
				observacionesJTArea.setText(_observaciones);
			}
		}
	}//GEN-LAST:event_observacionesJTAreaKeyTyped



	/*******************************************************************/
/*                         Metodos propios                         */
	/**
	 * ****************************************************************
	 */
    /**
     * Datos Titular
     */


	public boolean datosTitularOK() {

        try{
            if (excedeLongitud(_DNI_CIF_Titular, CConstantesLicencias.MaxLengthDNI)) {
                mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PropietarioTab.mensaje1"));
                return false;
            }
            if (excedeLongitud(_nombreTitular, CConstantesLicencias.MaxLengthNombre)) {
                mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PropietarioTab.mensaje2"));
                return false;
            }
            if (excedeLongitud(_apellido1Titular, CConstantesLicencias.MaxLengthApellido) || excedeLongitud(_apellido2Titular, CConstantesLicencias.MaxLengthApellido)) {
                mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PropietarioTab.mensaje3"));
                return false;
            }
            _emailTitular = emailTitularJTField.getText();
            if (excedeLongitud(_emailTitular, CConstantesLicencias.MaxLengthEmail)) {
                mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PropietarioTab.mensaje6"));
                return false;
            }
            _nombreViaTitular = nombreViaTitularJTField.getText();
            if (excedeLongitud(_nombreViaTitular, CConstantesLicencias.MaxLengthNombreVia)) {
                mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PropietarioTab.mensaje8"));
                return false;
            }
            _portalTitular = portalTitularJTField.getText();
            if (_portalTitular.length() > 0) {
                if (excedeLongitud(_portalTitular, CConstantesLicencias.MaxLengthPortal)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PropietarioTab.mensaje11"));
                    return false;
                }
            }
            _plantaTitular = plantaTitularJTField.getText();
            if (_plantaTitular.length() > 0) {
                if (excedeLongitud(_plantaTitular, CConstantesLicencias.MaxLengthPlanta)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PropietarioTab.mensaje13"));
                    return false;
                }
            }
            _escaleraTitular = escaleraTitularJTField.getText();
            if (excedeLongitud(_escaleraTitular, CConstantesLicencias.MaxLengthPlanta)) {
                mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PropietarioTab.mensaje14"));
                return false;
            }
            _letraTitular = letraTitularJTField.getText();
            if (excedeLongitud(_letraTitular, CConstantesLicencias.MaxLengthLetra)) {
                mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PropietarioTab.mensaje15"));
                return false;
            }
            _municipioTitular = municipioTitularJTField.getText();
            if (excedeLongitud(_municipioTitular, CConstantesLicencias.MaxLengthMunicipio)) {
                mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PropietarioTab.mensaje18"));
                return false;
            }

            _provinciaTitular = provinciaTitularJTField.getText();
            if (excedeLongitud(_provinciaTitular, CConstantesLicencias.MaxLengthProvincia)) {
                mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PropietarioTab.mensaje19"));
                return false;
            }

            boolean notificar = notificarTitularJCheckBox.isSelected();
            if (notificar)
                _seNotificaTitular = 1;
            else
                _seNotificaTitular = 0;

        }catch(Exception ex){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            logger.error("Exception: " + sw.toString());
        }

		return true;
	}

    /**
     * Datos Representante
     */

	public boolean datosRepresentaAOK() {

        try{
            /** Comprobamos que el propietario tenga representante */
            if (_flagRepresentante){
                if (excedeLongitud(_DNI_CIF_RepresentaA, CConstantesLicencias.MaxLengthDNI)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.RepresentanteTab.mensaje1"));
                    return false;
                }
                if (excedeLongitud(_nombreRepresentaA, CConstantesLicencias.MaxLengthNombre)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.RepresentanteTab.mensaje2"));
                    return false;
                }
                if (excedeLongitud(_apellido1RepresentaA, CConstantesLicencias.MaxLengthApellido) || excedeLongitud(_apellido2RepresentaA, CConstantesLicencias.MaxLengthApellido)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.RepresentanteTab.mensaje3"));
                    return false;
                }
                _emailRepresentaA = emailRepresentaAJTField.getText();
                if (excedeLongitud(_emailRepresentaA, CConstantesLicencias.MaxLengthEmail)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.RepresentanteTab.mensaje6"));
                    return false;
                }
                _nombreViaRepresentaA = nombreViaRepresentaAJTField.getText();
                if (excedeLongitud(_nombreViaRepresentaA, CConstantesLicencias.MaxLengthNombreVia)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.RepresentanteTab.mensaje8"));
                    return false;
                }
                _portalRepresentaA = portalRepresentaAJTField.getText();
                if (_portalRepresentaA.length() > 0) {
                    if (excedeLongitud(_portalRepresentaA, CConstantesLicencias.MaxLengthPortal)) {
                        mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.RepresentanteTab.mensaje11"));
                        return false;
                    }
                }
                _plantaRepresentaA = plantaRepresentaAJTField.getText();
                if (_plantaRepresentaA.length() > 0) {
                    if (excedeLongitud(_plantaRepresentaA, CConstantesLicencias.MaxLengthPlanta)) {
                        mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.RepresentanteTab.mensaje13"));
                        return false;
                    }
                }
                _escaleraRepresentaA = escaleraRepresentaAJTField.getText();
                if (excedeLongitud(_escaleraRepresentaA, CConstantesLicencias.MaxLengthPlanta)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.RepresentanteTab.mensaje14"));
                    return false;
                }
                _letraRepresentaA = letraRepresentaAJTField.getText();
                if (excedeLongitud(_letraRepresentaA, CConstantesLicencias.MaxLengthLetra)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.RepresentanteTab.mensaje15"));
                    return false;
                }
                _municipioRepresentaA = municipioRepresentaAJTField.getText();
                if (excedeLongitud(_municipioRepresentaA, CConstantesLicencias.MaxLengthMunicipio)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.RepresentanteTab.mensaje18"));
                    return false;
                }

                _provinciaRepresentaA = provinciaRepresentaAJTField.getText();
                if (excedeLongitud(_provinciaRepresentaA, CConstantesLicencias.MaxLengthProvincia)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.RepresentanteTab.mensaje19"));
                    return false;
                }
            }else{
                borrarCamposRepresentante();
            }


            boolean notificar = notificarRepresentaAJCheckBox.isSelected();
            if (notificar)
                _seNotificaRepresentaA = 1;
            else
                _seNotificaRepresentaA = 0;

        }catch(Exception ex){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            logger.error("Exception: " + sw.toString());
        }

		return true;
	}

    public void borrarCamposRepresentante() {
        try {
            // Actualizamos campos
            DNIRepresentaAJTField.setText("");
            nombreRepresentaAJTField.setText("");
            apellido1RepresentaAJTField.setText("");
            apellido2RepresentaAJTField.setText("");
            faxRepresentaAJTField.setText("");
            telefonoRepresentaAJTField.setText("");
            movilRepresentaAJTField.setText("");
            emailRepresentaAJTField.setText("");
            nombreViaRepresentaAJTField.setText("");
            numeroViaRepresentaAJTField.setText("");
            plantaRepresentaAJTField.setText("");
            letraRepresentaAJTField.setText("");
            portalRepresentaAJTField.setText("");
            escaleraRepresentaAJTField.setText("");
            cPostalRepresentaAJTField.setText("");
            municipioRepresentaAJTField.setText("");
            provinciaRepresentaAJTField.setText("");
            notificarRepresentaAJCheckBox.setSelected(false);

        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            logger.error("Exception: " + sw.toString());
        }
    }




    /**
     * Datos Tecnico
     */

	public boolean datosTecnicoOK() {

        try{
            if (_flagTecnico){
                if (excedeLongitud(_DNI_CIF_Tecnico, CConstantesLicencias.MaxLengthDNI)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.TecnicoTab.mensaje1"));
                    return false;
                }
                if (excedeLongitud(_nombreTecnico, CConstantesLicencias.MaxLengthNombre)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.TecnicoTab.mensaje2"));
                    return false;
                }
                if (excedeLongitud(_apellido1Tecnico, CConstantesLicencias.MaxLengthApellido) || excedeLongitud(_apellido2Tecnico, CConstantesLicencias.MaxLengthApellido)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.TecnicoTab.mensaje3"));
                    return false;
                }
                if (excedeLongitud(_colegioTecnico, CConstantesLicencias.MaxLengthColegio)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.TecnicoTab.mensaje4"));
                    return false;
                }
                if (excedeLongitud(_visadoTecnico, CConstantesLicencias.MaxLengthVisado)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.TecnicoTab.mensaje5"));
                    return false;
                }
                if (excedeLongitud(_titulacionTecnico, CConstantesLicencias.MaxLengthTitulacion)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.TecnicoTab.mensaje6"));
                    return false;
                }
                _emailTecnico = emailTecnicoJTField.getText();
                if (excedeLongitud(_emailTecnico, CConstantesLicencias.MaxLengthEmail)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.TecnicoTab.mensaje9"));
                    return false;
                }
                _nombreViaTecnico = nombreViaTecnicoJTField.getText();
                if (excedeLongitud(_nombreViaTecnico, CConstantesLicencias.MaxLengthNombreVia)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.TecnicoTab.mensaje11"));
                    return false;
                }
                _portalTecnico = portalTecnicoJTField.getText();
                if (_portalTecnico.length() > 0) {
                    if (excedeLongitud(_portalTecnico, CConstantesLicencias.MaxLengthPortal)) {
                        mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.TecnicoTab.mensaje14"));
                        return false;
                    }
                }
                _plantaTecnico = plantaTecnicoJTField.getText();
                if (_plantaTecnico.length() > 0) {
                    if (excedeLongitud(_plantaTecnico, CConstantesLicencias.MaxLengthPlanta)) {
                        mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.TecnicoTab.mensaje16"));
                        return false;
                    }
                }
                _escaleraTecnico = escaleraTecnicoJTField.getText();
                if (excedeLongitud(_escaleraTecnico, CConstantesLicencias.MaxLengthPlanta)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.TecnicoTab.mensaje17"));
                    return false;
                }
                _letraTecnico = letraTecnicoJTField.getText();
                if (excedeLongitud(_letraTecnico, CConstantesLicencias.MaxLengthLetra)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.TecnicoTab.mensaje18"));
                    return false;
                }
                _municipioTecnico = municipioTecnicoJTField.getText();
                if (excedeLongitud(_municipioTecnico, CConstantesLicencias.MaxLengthMunicipio)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.TecnicoTab.mensaje21"));
                    return false;
                }

                _provinciaTecnico = provinciaTecnicoJTField.getText();
                if (excedeLongitud(_provinciaTecnico, CConstantesLicencias.MaxLengthProvincia)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.TecnicoTab.mensaje22"));
                    return false;
                }
            }else{
                borrarCamposTecnico();
            }

            boolean notificar = notificarTecnicoJCheckBox.isSelected();
            if (notificar)
                _seNotificaTecnico = 1;
            else
                _seNotificaTecnico = 0;

        }catch(Exception ex){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            logger.error("Exception: " + sw.toString());
        }

		return true;
	}


    public void borrarCamposTecnico() {
        try {
            // Actualizamos campos
            DNITecnicoJTField.setText("");
            nombreTecnicoJTField.setText("");
            apellido1TecnicoJTField.setText("");
            apellido2TecnicoJTField.setText("");
            faxTecnicoJTField.setText("");
            telefonoTecnicoJTField.setText("");
            movilTecnicoJTField.setText("");
            emailTecnicoJTField.setText("");
            nombreViaTecnicoJTField.setText("");
            numeroViaTecnicoJTField.setText("");
            plantaTecnicoJTField.setText("");
            letraTecnicoJTField.setText("");
            portalTecnicoJTField.setText("");
            escaleraTecnicoJTField.setText("");
            cPostalTecnicoJTField.setText("");
            municipioTecnicoJTField.setText("");
            provinciaTecnicoJTField.setText("");
            notificarTecnicoJCheckBox.setSelected(false);

        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            logger.error("Exception: " + sw.toString());
        }
    }

    /**
     * Datos Promotor
     */

	public boolean datosPromotorOK() {

        try{
            if (_flagPromotor){
                if (excedeLongitud(_DNI_CIF_Promotor, CConstantesLicencias.MaxLengthDNI)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PromotorTab.mensaje1"));
                    return false;
                }
                if (excedeLongitud(_nombrePromotor, CConstantesLicencias.MaxLengthNombre)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PromotorTab.mensaje2"));
                    return false;
                }
                if (excedeLongitud(_apellido1Promotor, CConstantesLicencias.MaxLengthApellido) || excedeLongitud(_apellido2Promotor, CConstantesLicencias.MaxLengthApellido)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PromotorTab.mensaje3"));
                    return false;
                }
                if (excedeLongitud(_colegioPromotor, CConstantesLicencias.MaxLengthColegio)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PromotorTab.mensaje4"));
                    return false;
                }
                if (excedeLongitud(_visadoPromotor, CConstantesLicencias.MaxLengthVisado)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PromotorTab.mensaje5"));
                    return false;
                }
                if (excedeLongitud(_titulacionPromotor, CConstantesLicencias.MaxLengthTitulacion)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PromotorTab.mensaje6"));
                    return false;
                }

                _emailPromotor = emailPromotorJTField.getText();
                if (excedeLongitud(_emailPromotor, CConstantesLicencias.MaxLengthEmail)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PromotorTab.mensaje9"));
                    return false;
                }
                _nombreViaPromotor = nombreViaPromotorJTField.getText();
                if (excedeLongitud(_nombreViaPromotor, CConstantesLicencias.MaxLengthNombreVia)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PromotorTab.mensaje11"));
                    return false;
                }
                _portalPromotor = portalPromotorJTField.getText();
                if (_portalPromotor.length() > 0) {
                    if (excedeLongitud(_portalPromotor, CConstantesLicencias.MaxLengthPortal)) {
                        mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PromotorTab.mensaje14"));
                        return false;
                    }
                }
                _plantaPromotor = plantaPromotorJTField.getText();
                if (_plantaPromotor.length() > 0) {
                    if (excedeLongitud(_plantaPromotor, CConstantesLicencias.MaxLengthPlanta)) {
                        mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PromotorTab.mensaje16"));
                        return false;
                    }
                }
                _escaleraPromotor = escaleraPromotorJTField.getText();
                if (excedeLongitud(_escaleraPromotor, CConstantesLicencias.MaxLengthPlanta)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PromotorTab.mensaje17"));
                    return false;
                }
                _letraPromotor = letraPromotorJTField.getText();
                if (excedeLongitud(_letraPromotor, CConstantesLicencias.MaxLengthLetra)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PromotorTab.mensaje18"));
                    return false;
                }
                _municipioPromotor = municipioPromotorJTField.getText();
                if (excedeLongitud(_municipioPromotor, CConstantesLicencias.MaxLengthMunicipio)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PromotorTab.mensaje21"));
                    return false;
                }

                _provinciaPromotor = provinciaPromotorJTField.getText();
                if (excedeLongitud(_provinciaPromotor, CConstantesLicencias.MaxLengthProvincia)) {
                    mostrarMensaje(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.PromotorTab.mensaje22"));
                    return false;
                }
            }else{
                borrarCamposPromotor();
            }

            boolean notificar = notificarPromotorJCheckBox.isSelected();
            if (notificar)
                _seNotificaPromotor = 1;
            else
                _seNotificaPromotor = 0;

        }catch(Exception ex){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            logger.error("Exception: " + sw.toString());
        }

		return true;
	}

    public void borrarCamposPromotor() {
        try {
            // Actualizamos campos
            DNIPromotorJTField.setText("");
            nombrePromotorJTField.setText("");
            apellido1PromotorJTField.setText("");
            apellido2PromotorJTField.setText("");
            faxPromotorJTField.setText("");
            telefonoPromotorJTField.setText("");
            movilPromotorJTField.setText("");
            emailPromotorJTField.setText("");
            nombreViaPromotorJTField.setText("");
            numeroViaPromotorJTField.setText("");
            plantaPromotorJTField.setText("");
            letraPromotorJTField.setText("");
            portalPromotorJTField.setText("");
            escaleraPromotorJTField.setText("");
            cPostalPromotorJTField.setText("");
            municipioPromotorJTField.setText("");
            provinciaPromotorJTField.setText("");
            notificarPromotorJCheckBox.setSelected(false);

        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            logger.error("Exception: " + sw.toString());
        }
    }

    //Como estamos en la creaci�n del ex


	public void rellenarEstadoJCBox() {

 		_vEstado = COperacionesLicencias.getEstadosDisponibles(null,CConstantesComando.TIPO_ACTIVIDAD );
		if (_vEstado != null) {
			Enumeration e = _vEstado.elements();
			int i = 0;
			while (e.hasMoreElements()) {
				CEstado estado = (CEstado) e.nextElement();
                DomainNode dominio= Estructuras.getListaEstados().getDomainNode(new Integer(estado.getIdEstado()).toString());
				estadoJCBox.addItem(dominio.getTerm(literales.getLocale().toString()));
				_hEstado.put(new Integer(i), estado);
				i++;
			}
		}
	}


	public boolean rellenaCamposObligatorios() {
		// Chequeamos que el usuario haya rellenado los campos obligatorios
		/** Comprobamos los datos del titular */
		// leemos los datos referentes al titular
		_DNI_CIF_Titular = DNITitularJTField.getText();
		_nombreTitular = nombreTitularJTField.getText();
		/** Comprobamos si el titular representa a otra peprsona juridico-fisica */

		_nombreViaTitular = nombreViaTitularJTField.getText();
		_numeroViaTitular = numeroViaTitularJTField.getText();
		_cPostalTitular = cPostalTitularJTField.getText();
		_municipioTitular = municipioTitularJTField.getText();
		_provinciaTitular = provinciaTitularJTField.getText();
		if ((_DNI_CIF_Titular.trim().length() == 0) || (_nombreTitular.trim().length() == 0)) return false;

		if (    (_nombreViaTitular.trim().length() == 0) ||
				(_numeroViaTitular.trim().length() == 0) || (_cPostalTitular.trim().length() == 0) ||
				(_municipioTitular.trim().length() == 0) || (_provinciaTitular.trim().length() == 0))
			return false;
        /** si ha seleccionado el tipo de notificacion por email, el campo email es obligatorio */
        if (emailTitularObligatorio){
            if (emailTitularJTField.getText().trim().length() == 0) return false;
        }



        /** Comprobamos los datos del representado */
        // leemos los datos referentes al representado
        _DNI_CIF_RepresentaA = DNIRepresentaAJTField.getText();
        /** si se inserta el DNI consideramos que el propietario tiene representante */
        if (_DNI_CIF_RepresentaA.trim().length() > 0) _flagRepresentante= true;
        else _flagRepresentante= false;
        if (_flagRepresentante){
            _nombreRepresentaA = nombreRepresentaAJTField.getText();
            _nombreViaRepresentaA = nombreViaRepresentaAJTField.getText();
            _numeroViaRepresentaA = numeroViaRepresentaAJTField.getText();
            _cPostalRepresentaA = cPostalRepresentaAJTField.getText();
            _municipioRepresentaA = municipioRepresentaAJTField.getText();
            _provinciaRepresentaA = provinciaRepresentaAJTField.getText();
            if ((_DNI_CIF_RepresentaA.trim().length() == 0) || (_nombreRepresentaA.trim().length() == 0)) return false;

            if (    (_nombreViaRepresentaA.trim().length() == 0) ||
                    (_numeroViaRepresentaA.trim().length() == 0) || (_cPostalRepresentaA.trim().length() == 0) ||
                    (_municipioRepresentaA.trim().length() == 0) || (_provinciaRepresentaA.trim().length() == 0))
                return false;
            /** si ha seleccionado el tipo de notificacion por email, el campo email es obligatorio */
            if (emailRepresentanteObligatorio){
                if (emailRepresentaAJTField.getText().trim().length() == 0) return false;
            }

        }

		/** Comprobamos los datos del tecnico */
        // leemos los datos referentes al tecnico
        _DNI_CIF_Tecnico = DNITecnicoJTField.getText();
        /** si se inserta el DNI consideramos que el propietario tiene tecnico */
        if (_DNI_CIF_Tecnico.trim().length() > 0) _flagTecnico= true;
        else _flagTecnico=false;
        if (_flagTecnico){
            _nombreTecnico = nombreTecnicoJTField.getText();
            _colegioTecnico = colegioTecnicoJTField.getText();
            _visadoTecnico = visadoTecnicoJTField.getText();
            _titulacionTecnico = titulacionTecnicoJTField.getText();
            _nombreViaTecnico = nombreViaTecnicoJTField.getText();
            _numeroViaTecnico = numeroViaTecnicoJTField.getText();
            _cPostalTecnico = cPostalTecnicoJTField.getText();
            _municipioTecnico = municipioTecnicoJTField.getText();
            _provinciaTecnico = provinciaTecnicoJTField.getText();

            if ((_DNI_CIF_Tecnico.trim().length() == 0) || (_nombreTecnico.trim().length() == 0))
                return false;

            if (    (_nombreViaTecnico.trim().length() == 0) ||
                    (_numeroViaTecnico.trim().length() == 0) || (_cPostalTecnico.trim().length() == 0) ||
                    (_municipioTecnico.trim().length() == 0) || (_provinciaTecnico.trim().length() == 0))
                return false;
            /** si ha seleccionado el tipo de notificacion por email, el campo email es obligatorio */
            if (emailTecnicoObligatorio){
                if (emailTecnicoJTField.getText().trim().length() == 0) return false;
            }

        }

		/** Comprobamos los datos del promotor */
        // leemos los datos referentes al tecnico
		_DNI_CIF_Promotor = DNIPromotorJTField.getText();
        /** si se inserta el DNI consideramos que el propietario tiene tecnico */
        if (_DNI_CIF_Promotor.trim().length() > 0) _flagPromotor= true;
        else _flagPromotor=false;
        if (_flagPromotor){
            _nombrePromotor = nombrePromotorJTField.getText();
            _colegioPromotor = colegioPromotorJTField.getText();
            _visadoPromotor = visadoPromotorJTField.getText();
            _titulacionPromotor= titulacionPromotorJTField.getText();
            _nombreViaPromotor = nombreViaPromotorJTField.getText();
            _numeroViaPromotor = numeroViaPromotorJTField.getText();
            _cPostalPromotor = cPostalPromotorJTField.getText();
            _municipioPromotor = municipioPromotorJTField.getText();
            _provinciaPromotor = provinciaPromotorJTField.getText();

            if ((_DNI_CIF_Promotor.trim().length() == 0) || (_nombrePromotor.trim().length() == 0))
                return false;

            if (    (_nombreViaPromotor.trim().length() == 0) ||
                    (_numeroViaPromotor.trim().length() == 0) || (_cPostalPromotor.trim().length() == 0) ||
                    (_municipioPromotor.trim().length() == 0) || (_provinciaPromotor.trim().length() == 0))
                return false;
            /** si ha seleccionado el tipo de notificacion por email, el campo email es obligatorio */
            if (emailPromotorObligatorio){
                if (emailPromotorJTField.getText().trim().length() == 0) return false;
            }

        }

		if (fechaSolicitudJTField.getText().trim().length() == 0)
			return false;
		else if (estadoJCBox.getSelectedIndex() == -1)
			return false;
		else if (tipoObraEJCBox.getSelectedPatron() == null)
			return false;
        else if (tipoViaINEEJCBox.getSelectedPatron() == null)
            return false;
        else if (nombreViaTField.getText().trim().length() == 0)
            return false;
		else
			return true;
	}


	public void buscarRellenarDatosPersonaConDNI(String dni) {
		// Falta por rellenar

	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(obraMayorJPanel, mensaje);
	}

	public boolean esNumerico(String s) {
		try {
			new Integer(s).intValue();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean excedeLongitud(String campo, int maxLengthPermitida) {
		if (campo.length() > maxLengthPermitida)
			return true;
		else
			return false;
	}

	public String showToday() {
		Calendar cal = new GregorianCalendar();
		Locale locale = Locale.getDefault();
		cal = Calendar.getInstance(TimeZone.getTimeZone(locale.toString()));

		int anno = cal.get(Calendar.YEAR);
		int mes = cal.get(Calendar.MONTH) + 1; // 0 == Enero
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		String sMes = "";
		String sDia = "";
		if (mes < 10)
			sMes = "0" + mes;
		else
			sMes = "" + mes;
		if (dia < 10)
			sDia = "0" + dia;
		else
			sDia = "" + dia;

		return sDia + "/" + sMes + "/" + anno;
	}
    

    public void renombrarComponentes(ResourceBundle literales) {
        this.literales=literales;
         try{

                /** Pestanas */
                jTabbedPaneSolicitud.setTitleAt(0, CUtilidadesComponentes.annadirAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.obraMayorJPanel.SubTitleTab")));
                jTabbedPaneSolicitud.setTitleAt(1, literales.getString("DatosActividadJPanel.SubTitleTab"));
                jTabbedPaneSolicitud.setTitleAt(2, CUtilidadesComponentes.annadirAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.titularJPanel.TitleTab")));
                jTabbedPaneSolicitud.setTitleAt(3, literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.representaAJPanel.TitleTab"));
                jTabbedPaneSolicitud.setTitleAt(4, literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.tecnicoJPanel.TitleTab"));
                jTabbedPaneSolicitud.setTitleAt(5, literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.promotorJPanel.TitleTab"));
                obraMayorJTabbedPane.setTitleAt(0, CUtilidadesComponentes.annadirAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.obraMayorJPanel.TitleTab")));
                obraMayorJTabbedPane.setTitleAt(1, literales.getString("DocumentacionLicenciasJPanel.title"));

                /** Solicitud */
                setTitle(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.JInternalFrame.title"));
                datosSolicitudJPanel.setBorder(new javax.swing.border.TitledBorder(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.datosSolicitudJPanel.TitleBorder")));
                estadoJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.estadoJLabel.text")));
                tipoObraJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.tipoObraJLabel.text")));
                jCheckBoxActividadNoCalificada.setText(literales.getString("jCheckBoxActividadNoCalificada"));
                unidadTJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.unidadTJLabel.text"));
                unidadRJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.unidadRJLabel.text"));
                motivoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.motivoJLabel.text"));
                asuntoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.asuntoJLabel.text"));
                fechaSolicitudJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.fechaSolicitudJLabel.text")));
                fechaLimiteObraJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.fechaLimiteObraJLabel.text"));
                observacionesJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.observacionesJLabel.text"));
                fechaSolicitudJTField.setText(showToday());
                unidadTJTField.setText(JDialogConfiguracion.getUnidadTramitadoraActividades());
                unidadRJTField.setText(JDialogConfiguracion.getUnidadRegistroActividades());
                impuestoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.impuestoJLabel.text"));
                tasaJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.tasaJLabel.text"));
                emplazamientoJPanel.setBorder(new javax.swing.border.TitledBorder(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.emplazamientoJPanel.TitleBorder")));
                nombreViaJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.tipoViaJLabel.text"), literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.nombreViaJLabel.text")));
                numeroViaJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.numeroViaJLabel.text"));
                cPostalJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.cPostalJLabel.text"));
                provinciaJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.provinciaJLabel.text"));
                referenciaCatastralJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciaCatastralJLabel.text"));
                cnaeJLabel.setText(literales.getString("cnaeJLabel.text"));

                 /** Datos Actividad */
                 datosActividadJPanel.renameComponents(literales);

                /** Propietario */
                datosPersonalesTitularJPanel.setBorder(new javax.swing.border.TitledBorder(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.datosPersonalesTitularJPanel.TitleBorder")));
                DNITitularJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.DNITitularJLabel.text")));
                nombreTitularJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.nombreTitularJLabel.text")));
                apellido1TitularJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.apellido1TitularJLabel.text"));
                apellido2TitularJLabel2.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.apellido2TitularJLabel.text"));
                datosNotificacionTitularJPanel.setBorder(new javax.swing.border.TitledBorder(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.datosNotificacionTitularJPanel.TitleBorder")));
                viaNotificacionTitularJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.viaNotificacionTitularJLabel.text"));
                faxTitularJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.faxTitularJLabel.text"));
                telefonoTitularJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.telefonoTitularJLabel.text"));
                movilTitularJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.movilTitularJLabel.text"));
                emailTitularJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.emailTitularJLabel.text"));
                tipoViaTitularJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.tipoViaTitularJLabel.text")));
                nombreViaTitularJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.nombreViaTitularJLabel.text")));
                numeroViaTitularJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.numeroViaTiularJLabel.text")));
                portalTitularJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.portalTitularJLabel.text"));
                plantaTitularJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.plantaTitularJLabel.text"));
                escaleraTitularJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.escaleraTitularJLabel.text"));
                letraTitularJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.letraTitularJLabel.text"));
                cPostalTitularJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.cPostalTitularJLabel.text")));
                municipioTitularJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.municipioTitularJLabel.text")));
                provinciaTitularJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.provinciaTitularJLabel.text")));
                notificarTitularJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.notificarTitularJLabel.text"));

                /** Representante */
                datosPersonalesRepresentaAJPanel.setBorder(new javax.swing.border.TitledBorder(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.datosPersonalesRepresentaAJPanel.TitleBorder")));
                DNIRepresenaAJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.DNIRepresentaAJLabel.text")));
                nombreRepresentaAJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.nombreRepresentaAJLabel.text")));
                apellido1RepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.apellido1RepresentaAJLabel.text"));
                apellido2RepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.apellido2RepresentaAJLabel.text"));
                datosNotificacionRepresentaAJPanel.setBorder(new javax.swing.border.TitledBorder(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.datosNotificacionRepresentaAJPanel.TitleBorder")));
                viaNotificacionRepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.viaNotificacionRepresentaAJLabel.text"));
                faxRepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.faxRepresentaAJLabel.text"));
                telefonoRepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.telefonoRepresentaAJLabel.text"));
                movilRepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.movilRepresentaAJLabel.text"));
                emailRepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.emailRepresentaAJLabel.text"));
                tipoViaRepresentaAJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.tipoViaRepresentaAJLabel.text")));
                nombreViaRepresentaAJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.nombreViaRepresentaAJLabel.text")));
                numeroViaRepresentaAJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.numeroViaTiularJLabel.text")));
                portalRepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.portalRepresentaAJLabel.text"));
                plantaRepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.plantaRepresentaAJLabel.text"));
                escaleraRepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.escaleraRepresentaAJLabel.text"));
                letraRepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.letraRepresentaAJLabel.text"));
                cPostalRepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.cPostalRepresentaAJLabel.text"));
                municipioRepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.municipioRepresentaAJLabel.text"));
                provinciaRepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.provinciaRepresentaAJLabel.text"));
                notificarRepresentaAJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.notificarRepresentaAJLabel.text"));

                /** Tecnico */
                datosPersonalesTecnicoJPanel.setBorder(new javax.swing.border.TitledBorder(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.datosPersonalesTecnicoJPanel.TitleBorder")));
                DNITecnicoJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.DNITecnicoJLabel.text")));
                nombreTecnicoJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.nombreTecnicoJLabel.text")));
                apellido1TecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.apellido1TecnicoJLabel.text"));
                apellido2TecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.apellido2TecnicoJLabel.text"));
                colegioTecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.colegioTecnicoJLabel.text"));
                visadoTecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.visadoTecnicoJLabel.text"));
                titulacionTecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.titulacionTecnicoJLabel.text"));
                datosNotificacionTecnicoJPanel.setBorder(new javax.swing.border.TitledBorder(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.datosNotificacionTecnicoJPanel.TitleBorder")));
                viaNotificacionTecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.viaNotificacionTecnicoJLabel.text"));
                faxTecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.faxTecnicoJLabel.text"));
                telefonoTecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.telefonoTecnicoJLabel.text"));
                movilTecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.movilTecnicoJLabel.text"));
                emailTecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.emailTecnicoJLabel.text"));
                tipoViaTecnicoJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.tipoViaTecnicoJLabel.text")));
                nombreViaTecnicoJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.nombreViaTecnicoJLabel.text")));
                numeroViaTecnicoJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.numeroViaTiularJLabel.text")));
                portalTecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.portalTecnicoJLabel.text"));
                plantaTecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.plantaTecnicoJLabel.text"));
                escaleraTecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.escaleraTecnicoJLabel.text"));
                letraTecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.letraTecnicoJLabel.text"));
                cPostalTecnicoJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.cPostalTecnicoJLabel.text")));
                municipioTecnicoJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.municipioTecnicoJLabel.text")));
                provinciaTecnicoJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.provinciaTecnicoJLabel.text")));
                notificarTecnicoJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.notificarTecnicoJLabel.text"));

                /** Promotor */
                datosPersonalesPromotorJPanel.setBorder(new javax.swing.border.TitledBorder(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.datosPersonalesPromotorJPanel.TitleBorder")));
                DNIPromotorJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.DNIPromotorJLabel.text")));
                nombrePromotorJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.nombrePromotorJLabel.text")));
                apellido1PromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.apellido1PromotorJLabel.text"));
                apellido2PromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.apellido2PromotorJLabel.text"));
                colegioPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.colegioPromotorJLabel.text"));
                visadoPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.visadoPromotorJLabel.text"));
                titulacionPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.titulacionPromotorJLabel.text"));
                datosNotificacionPromotorJPanel.setBorder(new javax.swing.border.TitledBorder(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.datosNotificacionPromotorJPanel.TitleBorder")));
                viaNotificacionPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.viaNotificacionPromotorJLabel.text"));
                faxPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.faxPromotorJLabel.text"));
                telefonoPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.telefonoPromotorJLabel.text"));
                movilPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.movilPromotorJLabel.text"));
                emailPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.emailPromotorJLabel.text"));
                tipoViaPromotorJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.tipoViaPromotorJLabel.text")));
                nombreViaPromotorJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.nombreViaPromotorJLabel.text")));
                numeroViaPromotorJLabel.setText(CUtilidadesComponentes.getLabelConAsterisco(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.numeroViaTiularJLabel.text")));
                portalPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.portalPromotorJLabel.text"));
                plantaPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.plantaPromotorJLabel.text"));
                escaleraPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.escaleraPromotorJLabel.text"));
                letraPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.letraPromotorJLabel.text"));
                cPostalPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.cPostalPromotorJLabel.text"));
                municipioPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.municipioPromotorJLabel.text"));
                provinciaPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.provinciaPromotorJLabel.text"));
                notificarPromotorJLabel.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.notificarPromotorJLabel.text"));

                /** Documentacion */
                documentacionJPanel.renombrarComponentes(literales);

                aceptarJButton.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.aceptarJButton.text"));
                cancelarJButton.setText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.cancelarJButton.text"));
                editorMapaJPanel.setBorder(new javax.swing.border.TitledBorder(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.editorMapaJPanel.TitleBorder")));

             aceptarJButton.setToolTipText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.aceptarJButton.toolTipText"));
             cancelarJButton.setToolTipText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.cancelarJButton.text"));
             fechaSolicitudJButton.setToolTipText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.fechaSolicitudJButton.toolTipText"));
             nombreJButton.setToolTipText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.nombreJButton.toolTipText"));
             referenciaCatastralJButton.setToolTipText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciaCatastralJButton.toolTipText"));
             MapToTableJButton.setToolTipText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.MapToTableJButton.toolTipText"));
             deleteRegistroCatastralJButton.setToolTipText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.deleteRegistroCatastralJButton.toolTipText"));
             tableToMapJButton.setToolTipText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.tableToMapJButton.toolTipText"));
             buscarDNITitularJButton.setToolTipText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.buscarDNITitularJButton.toolTipText"));
             buscarDNIRepresentaAJButton.setToolTipText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.buscarDNIRepresentaAJButton.toolTipText"));
             buscarDNIPromotorJButton.setToolTipText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.buscarDNIPromotorJButton.toolTipText"));
             fechaLimiteObraJButton.setToolTipText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.fechaLimiteObraJButton.toolTipText"));
             buscarDNITecnicoJButton.setToolTipText(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.buscarDNITecnicoJButton.toolTipText"));

             /** Header tabla referenciasCatastrales */
             TableColumn tableColumn= referenciasCatastralesJTable.getColumnModel().getColumn(0);
             tableColumn.setHeaderValue(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column1"));
             tableColumn= referenciasCatastralesJTable.getColumnModel().getColumn(1);
             tableColumn.setHeaderValue(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column2"));
             tableColumn= referenciasCatastralesJTable.getColumnModel().getColumn(2);
             tableColumn.setHeaderValue(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column3"));
             tableColumn= referenciasCatastralesJTable.getColumnModel().getColumn(3);
             tableColumn.setHeaderValue(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column4"));
             tableColumn= referenciasCatastralesJTable.getColumnModel().getColumn(4);
             tableColumn.setHeaderValue(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column5"));
             tableColumn= referenciasCatastralesJTable.getColumnModel().getColumn(5);
             tableColumn.setHeaderValue(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column6"));
             tableColumn= referenciasCatastralesJTable.getColumnModel().getColumn(6);
             tableColumn.setHeaderValue(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column7"));
             tableColumn= referenciasCatastralesJTable.getColumnModel().getColumn(7);
             tableColumn.setHeaderValue(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column8"));
             tableColumn= referenciasCatastralesJTable.getColumnModel().getColumn(8);
             tableColumn.setHeaderValue(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column9"));
             tableColumn= referenciasCatastralesJTable.getColumnModel().getColumn(9);
             tableColumn.setHeaderValue(literales.getString("CCreacionLicenciasForm.ObraMenorJMenuItem.referenciasCatastralesJTable.column10"));

        }catch(Exception ex){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            logger.error("Exception al pintar las etiquetas: " , ex);
        }
    }



    public void clearAll() {

        try{
            /** Solicitud */
            unidadTJTField.setText(JDialogConfiguracion.getUnidadTramitadoraActividades());
            unidadRJTField.setText(JDialogConfiguracion.getUnidadRegistroActividades());
            motivoJTField.setText("");
            asuntoJTField.setText("");
            fechaLimiteObraJTField.setText("");
            fechaSolicitudJTField.setText(showToday());
            observacionesJTArea.setText("");
            tasaTextField.setText("�0.00");
            impuestoTextField.setText("�0.00");
            CUtilidadesComponentes.clearTable(referenciasCatastralesJTableModel);
            MainActividad.geopistaEditor.getSelectionManager().clear();
            cnaeTField.setText("");

            /** datos de actividad */
            datosActividadJPanel.load(null);

            /** Emplazamiento */
            tipoViaINEEJCBox.setSelectedIndex(0);
            referenciaJTextField.setText("");
            nombreViaTField.setText("");
            numeroViaNumberTField.setText("");
            portalViaTField.setText("");
            plantaViaTField.setText("");
            letraViaTField.setText("");
            cpostalViaTField.setText("");
            municipioJTField.setText(CConstantesLicencias.Municipio);
            provinciaJTField.setText(CConstantesLicencias.Provincia);

            /** Documentacion */
            documentacionJPanel.clearDocumentacionJPanel();

            /** Propietario */
            DNITitularJTField.setText("");
            nombreTitularJTField.setText("");
            apellido1TitularJTField.setText("");
            apellido2TitularJTField.setText("");
            buscarDNITitularJButton.setToolTipText("");
            faxTitularJTField.setText("");
            telefonoTitularJTField.setText("");
            movilTitularJTField.setText("");
            emailTitularJTField.setText("");
            nombreViaTitularJTField.setText("");
            numeroViaTitularJTField.setText("");
            plantaTitularJTField.setText("");
            portalTitularJTField.setText("");
            escaleraTitularJTField.setText("");
            letraTitularJTField.setText("");
            cPostalTitularJTField.setText("");
            municipioTitularJTField.setText("");
            provinciaTitularJTField.setText("");
            notificarTitularJCheckBox.setSelected(true);

            /** Representante */
            DNIRepresentaAJTField.setText("");
            nombreRepresentaAJTField.setText("");
            apellido1RepresentaAJTField.setText("");
            apellido2RepresentaAJTField.setText("");
            buscarDNIRepresentaAJButton.setToolTipText("");
            faxRepresentaAJTField.setText("");
            telefonoRepresentaAJTField.setText("");
            movilRepresentaAJTField.setText("");
            emailRepresentaAJTField.setText("");
            nombreViaRepresentaAJTField.setText("");
            numeroViaRepresentaAJTField.setText("");
            plantaRepresentaAJTField.setText("");
            portalRepresentaAJTField.setText("");
            escaleraRepresentaAJTField.setText("");
            letraRepresentaAJTField.setText("");
            cPostalRepresentaAJTField.setText("");
            municipioRepresentaAJTField.setText("");
            provinciaRepresentaAJTField.setText("");
            notificarRepresentaAJCheckBox.setSelected(false);
            _seNotificaRepresentaA= 0;
            _flagRepresentante= false;


            /** Tecnico */
            DNITecnicoJTField.setText("");
            nombreTecnicoJTField.setText("");
            apellido1TecnicoJTField.setText("");
            apellido2TecnicoJTField.setText("");
            colegioTecnicoJTField.setText("");
            visadoTecnicoJTField.setText("");
            titulacionTecnicoJTField.setText("");
            buscarDNITecnicoJButton.setToolTipText("");
            faxTecnicoJTField.setText("");
            telefonoTecnicoJTField.setText("");
            movilTecnicoJTField.setText("");
            emailTecnicoJTField.setText("");
            nombreViaTecnicoJTField.setText("");
            numeroViaTecnicoJTField.setText("");
            plantaTecnicoJTField.setText("");
            portalTecnicoJTField.setText("");
            escaleraTecnicoJTField.setText("");
            letraTecnicoJTField.setText("");
            cPostalTecnicoJTField.setText("");
            municipioTecnicoJTField.setText("");
            provinciaTecnicoJTField.setText("");
            notificarTecnicoJCheckBox.setSelected(false);
            _seNotificaTecnico= 0;


            /** Promotor */
            DNIPromotorJTField.setText("");
            nombrePromotorJTField.setText("");
            apellido1PromotorJTField.setText("");
            apellido2PromotorJTField.setText("");
            colegioPromotorJTField.setText("");
            visadoPromotorJTField.setText("");
            titulacionPromotorJTField.setText("");
            buscarDNIPromotorJButton.setToolTipText("");
            faxPromotorJTField.setText("");
            telefonoPromotorJTField.setText("");
            movilPromotorJTField.setText("");
            emailPromotorJTField.setText("");
            nombreViaPromotorJTField.setText("");
            numeroViaPromotorJTField.setText("");
            plantaPromotorJTField.setText("");
            portalPromotorJTField.setText("");
            escaleraPromotorJTField.setText("");
            letraPromotorJTField.setText("");
            cPostalPromotorJTField.setText("");
            municipioPromotorJTField.setText("");
            provinciaPromotorJTField.setText("");
            notificarPromotorJCheckBox.setSelected(false);
            _seNotificaPromotor= 0;


        }catch(Exception ex){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            logger.error("Exception: " + sw.toString());
        }
    }




	private DefaultTableModel referenciasCatastralesJTableModel;
	private JFrame desktop;
    private ComboBoxEstructuras tipoObraEJCBox;
    private ComboBoxEstructuras viaNotificacionTitularEJCBox;
    private ComboBoxEstructuras viaNotificacionRepresentaAEJCBox;
    private ComboBoxEstructuras viaNotificacionTecnicoEJCBox;
    private ComboBoxEstructuras viaNotificacionPromotorEJCBox;

    private ComboBoxEstructuras tipoViaNotificacionTitularEJCBox;
    private ComboBoxEstructuras tipoViaNotificacionRepresentaAEJCBox;
    private ComboBoxEstructuras tipoViaNotificacionTecnicoEJCBox;
    private ComboBoxEstructuras tipoViaNotificacionPromotorEJCBox;

    /** tasa */
    private com.geopista.app.utilidades.JNumberTextField tasaTextField;
    private com.geopista.app.utilidades.JNumberTextField impuestoTextField;

    /** emplazamiento */
    private com.geopista.app.utilidades.TextField nombreViaTField;
    //private com.geopista.app.utilidades.JNumberTextField numeroViaNumberTField;
    private com.geopista.app.utilidades.TextField numeroViaNumberTField;
    private com.geopista.app.utilidades.TextField portalViaTField;
    private com.geopista.app.utilidades.TextField plantaViaTField;
    private com.geopista.app.utilidades.TextField letraViaTField;
    private com.geopista.app.utilidades.JNumberTextField cpostalViaTField;
    private ComboBoxEstructuras tipoViaINEEJCBox;

    /** cnae */
    private com.geopista.app.utilidades.TextField cnaeTField;

    /** pestanna de los datos de actividad */
    private com.geopista.app.licencias.actividad.datosActividad.DatosActividadJPanel datosActividadJPanel;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DNIPromotorJLabel;
    private javax.swing.JTextField DNIPromotorJTField;
    private javax.swing.JLabel DNIRepresenaAJLabel;
    private javax.swing.JTextField DNIRepresentaAJTField;
    private javax.swing.JLabel DNITecnicoJLabel;
    private javax.swing.JTextField DNITecnicoJTField;
    private javax.swing.JLabel DNITitularJLabel;
    private javax.swing.JTextField DNITitularJTField;
    private javax.swing.JButton MapToTableJButton;
    private javax.swing.JButton aceptarJButton;
    private javax.swing.JLabel apellido1PromotorJLabel;
    private javax.swing.JTextField apellido1PromotorJTField;
    private javax.swing.JLabel apellido1RepresentaAJLabel;
    private javax.swing.JTextField apellido1RepresentaAJTField;
    private javax.swing.JLabel apellido1TecnicoJLabel;
    private javax.swing.JTextField apellido1TecnicoJTField;
    private javax.swing.JLabel apellido1TitularJLabel;
    private javax.swing.JTextField apellido1TitularJTField;
    private javax.swing.JLabel apellido2PromotorJLabel;
    private javax.swing.JTextField apellido2PromotorJTField;
    private javax.swing.JLabel apellido2RepresentaAJLabel;
    private javax.swing.JTextField apellido2RepresentaAJTField;
    private javax.swing.JLabel apellido2TecnicoJLabel;
    private javax.swing.JTextField apellido2TecnicoJTField;
    private javax.swing.JLabel apellido2TitularJLabel2;
    private javax.swing.JTextField apellido2TitularJTField;
    private javax.swing.JLabel asuntoJLabel;
    private javax.swing.JTextField asuntoJTField;
    private javax.swing.JPanel botoneraJPanel;
    private javax.swing.JButton buscarDNIPromotorJButton;
    private javax.swing.JButton buscarDNIRepresentaAJButton;
    private javax.swing.JButton buscarDNITecnicoJButton;
    private javax.swing.JButton buscarDNITitularJButton;
    private javax.swing.JLabel cPostalJLabel;
    private javax.swing.JLabel cPostalPromotorJLabel;
    private com.geopista.app.utilidades.JNumberTextField cPostalPromotorJTField;
    private javax.swing.JLabel cPostalRepresentaAJLabel;
    private com.geopista.app.utilidades.JNumberTextField cPostalRepresentaAJTField;
    private javax.swing.JLabel cPostalTecnicoJLabel;
    private com.geopista.app.utilidades.JNumberTextField cPostalTecnicoJTField;
    private javax.swing.JLabel cPostalTitularJLabel;
    private com.geopista.app.utilidades.JNumberTextField cPostalTitularJTField;
    private javax.swing.JButton cancelarJButton;
    private javax.swing.JLabel colegioPromotorJLabel;
    private javax.swing.JTextField colegioPromotorJTField;
    private javax.swing.JLabel colegioTecnicoJLabel;
    private javax.swing.JTextField colegioTecnicoJTField;
    private javax.swing.JPanel datosNotificacionPromotorJPanel;
    private javax.swing.JPanel datosNotificacionRepresentaAJPanel;
    private javax.swing.JPanel datosNotificacionTecnicoJPanel;
    private javax.swing.JPanel datosNotificacionTitularJPanel;
    private javax.swing.JPanel datosPersonalesPromotorJPanel;
    private javax.swing.JPanel datosPersonalesRepresentaAJPanel;
    private javax.swing.JPanel datosPersonalesTecnicoJPanel;
    private javax.swing.JPanel datosPersonalesTitularJPanel;
    private javax.swing.JPanel datosSolicitudJPanel;
    private javax.swing.JButton deleteRegistroCatastralJButton;
    private javax.swing.JPanel editorMapaJPanel;
    private javax.swing.JLabel emailPromotorJLabel;
    private javax.swing.JTextField emailPromotorJTField;
    private javax.swing.JLabel emailRepresentaAJLabel;
    private javax.swing.JTextField emailRepresentaAJTField;
    private javax.swing.JLabel emailTecnicoJLabel;
    private javax.swing.JTextField emailTecnicoJTField;
    private javax.swing.JLabel emailTitularJLabel;
    private javax.swing.JTextField emailTitularJTField;
    private javax.swing.JPanel emplazamientoJPanel;
    private javax.swing.JLabel escaleraPromotorJLabel;
    private javax.swing.JTextField escaleraPromotorJTField;
    private javax.swing.JLabel escaleraRepresentaAJLabel;
    private javax.swing.JTextField escaleraRepresentaAJTField;
    private javax.swing.JLabel escaleraTecnicoJLabel;
    private javax.swing.JTextField escaleraTecnicoJTField;
    private javax.swing.JLabel escaleraTitularJLabel;
    private javax.swing.JTextField escaleraTitularJTField;
    private javax.swing.JComboBox estadoJCBox;
    private javax.swing.JLabel estadoJLabel;
    private javax.swing.JLabel faxPromotorJLabel;
    private com.geopista.app.utilidades.JNumberTextField faxPromotorJTField;
    private javax.swing.JLabel faxRepresentaAJLabel;
    private com.geopista.app.utilidades.JNumberTextField faxRepresentaAJTField;
    private javax.swing.JLabel faxTecnicoJLabel;
    private com.geopista.app.utilidades.JNumberTextField faxTecnicoJTField;
    private javax.swing.JLabel faxTitularJLabel;
    private com.geopista.app.utilidades.JNumberTextField faxTitularJTField;
    private javax.swing.JButton fechaLimiteObraJButton;
    private javax.swing.JLabel fechaLimiteObraJLabel;
    private javax.swing.JTextField fechaLimiteObraJTField;
    private javax.swing.JButton fechaSolicitudJButton;
    private javax.swing.JLabel fechaSolicitudJLabel;
    private javax.swing.JTextField fechaSolicitudJTField;
    private javax.swing.JLabel impuestoJLabel;
    private javax.swing.JLabel letraPromotorJLabel;
    private javax.swing.JTextField letraPromotorJTField;
    private javax.swing.JLabel letraRepresentaAJLabel;
    private javax.swing.JTextField letraRepresentaAJTField;
    private javax.swing.JLabel letraTecnicoJLabel;
    private javax.swing.JTextField letraTecnicoJTField;
    private javax.swing.JLabel letraTitularJLabel;
    private javax.swing.JTextField letraTitularJTField;
    private javax.swing.JLabel motivoJLabel;
    private javax.swing.JTextField motivoJTField;
    private javax.swing.JLabel movilPromotorJLabel;
    private com.geopista.app.utilidades.JNumberTextField movilPromotorJTField;
    private javax.swing.JLabel movilRepresentaAJLabel;
    private com.geopista.app.utilidades.JNumberTextField movilRepresentaAJTField;
    private javax.swing.JLabel movilTecnicoJLabel;
    private com.geopista.app.utilidades.JNumberTextField movilTecnicoJTField;
    private javax.swing.JLabel movilTitularJLabel;
    private com.geopista.app.utilidades.JNumberTextField movilTitularJTField;
    private javax.swing.JTextField municipioJTField;
    private javax.swing.JLabel municipioPromotorJLabel;
    private javax.swing.JTextField municipioPromotorJTField;
    private javax.swing.JLabel municipioRepresentaAJLabel;
    private javax.swing.JTextField municipioRepresentaAJTField;
    private javax.swing.JLabel municipioTecnicoJLabel;
    private javax.swing.JTextField municipioTecnicoJTField;
    private javax.swing.JLabel municipioTitularJLabel;
    private javax.swing.JTextField municipioTitularJTField;
    private javax.swing.JButton nombreJButton;
    private javax.swing.JLabel nombrePromotorJLabel;
    private javax.swing.JTextField nombrePromotorJTField;
    private javax.swing.JLabel nombreRepresentaAJLabel;
    private javax.swing.JTextField nombreRepresentaAJTField;
    private javax.swing.JLabel nombreTecnicoJLabel;
    private javax.swing.JTextField nombreTecnicoJTField;
    private javax.swing.JLabel nombreTitularJLabel;
    private javax.swing.JTextField nombreTitularJTField;
    private javax.swing.JLabel nombreViaJLabel;
    private javax.swing.JLabel nombreViaPromotorJLabel;
    private javax.swing.JTextField nombreViaPromotorJTField;
    private javax.swing.JLabel nombreViaRepresentaAJLabel;
    private javax.swing.JTextField nombreViaRepresentaAJTField;
    private javax.swing.JLabel nombreViaTecnicoJLabel;
    private javax.swing.JTextField nombreViaTecnicoJTField;
    private javax.swing.JLabel nombreViaTitularJLabel;
    private javax.swing.JTextField nombreViaTitularJTField;
    private javax.swing.JCheckBox notificarPromotorJCheckBox;
    private javax.swing.JLabel notificarPromotorJLabel;
    private javax.swing.JCheckBox notificarRepresentaAJCheckBox;
    private javax.swing.JLabel notificarRepresentaAJLabel;
    private javax.swing.JCheckBox notificarTecnicoJCheckBox;
    private javax.swing.JLabel notificarTecnicoJLabel;
    private javax.swing.JCheckBox notificarTitularJCheckBox;
    private javax.swing.JLabel notificarTitularJLabel;
    private javax.swing.JLabel numeroViaJLabel;
    private javax.swing.JLabel numeroViaPromotorJLabel;
    private com.geopista.app.utilidades.JNumberTextField numeroViaPromotorJTField;
    private javax.swing.JLabel numeroViaRepresentaAJLabel;
    private com.geopista.app.utilidades.JNumberTextField numeroViaRepresentaAJTField;
    private javax.swing.JLabel numeroViaTecnicoJLabel;
    private com.geopista.app.utilidades.JNumberTextField numeroViaTecnicoJTField;
    private javax.swing.JLabel numeroViaTitularJLabel;
    private com.geopista.app.utilidades.JNumberTextField numeroViaTitularJTField;
    private javax.swing.JPanel obraMayorJPanel;
    private javax.swing.JTabbedPane obraMayorJTabbedPane;
    private javax.swing.JLabel observacionesJLabel;
    private javax.swing.JScrollPane observacionesJScrollPane;
    private javax.swing.JTextArea observacionesJTArea;
    private javax.swing.JLabel plantaPromotorJLabel;
    private javax.swing.JTextField plantaPromotorJTField;
    private javax.swing.JLabel plantaRepresentaAJLabel;
    private javax.swing.JTextField plantaRepresentaAJTField;
    private javax.swing.JLabel plantaTecnicoJLabel;
    private javax.swing.JTextField plantaTecnicoJTField;
    private javax.swing.JLabel plantaTitularJLabel;
    private javax.swing.JTextField plantaTitularJTField;
    private javax.swing.JLabel portalPromotorJLabel;
    private javax.swing.JTextField portalPromotorJTField;
    private javax.swing.JLabel portalRepresentaAJLabel;
    private javax.swing.JTextField portalRepresentaAJTField;
    private javax.swing.JLabel portalTecnicoJLabel;
    private javax.swing.JTextField portalTecnicoJTField;
    private javax.swing.JLabel portalTitularJLabel;
    private javax.swing.JTextField portalTitularJTField;
    private javax.swing.JPanel promotorJPanel;
    private javax.swing.JLabel provinciaJLabel;
    private javax.swing.JTextField provinciaJTField;
    private javax.swing.JLabel provinciaPromotorJLabel;
    private javax.swing.JTextField provinciaPromotorJTField;
    private javax.swing.JLabel provinciaRepresentaAJLabel;
    private javax.swing.JTextField provinciaRepresentaAJTField;
    private javax.swing.JLabel provinciaTecnicoJLabel;
    private javax.swing.JTextField provinciaTecnicoJTField;
    private javax.swing.JLabel provinciaTitularJLabel;
    private javax.swing.JTextField provinciaTitularJTField;
    private javax.swing.JButton referenciaCatastralJButton;
    private javax.swing.JLabel referenciaCatastralJLabel;
    private javax.swing.JTextField referenciaJTextField;
    private javax.swing.JScrollPane referenciasCatastralesJScrollPane;
    private javax.swing.JTable referenciasCatastralesJTable;
    private javax.swing.JPanel representaAJPanel;
    private javax.swing.JButton tableToMapJButton;
    private javax.swing.JLabel tasaJLabel;
    private javax.swing.JPanel tecnicoJPanel;
    private javax.swing.JLabel telefonoPromotorJLabel;
    private com.geopista.app.utilidades.JNumberTextField telefonoPromotorJTField;
    private javax.swing.JLabel telefonoRepresentaAJLabel;
    private com.geopista.app.utilidades.JNumberTextField telefonoRepresentaAJTField;
    private javax.swing.JLabel telefonoTecnicoJLabel;
    private com.geopista.app.utilidades.JNumberTextField telefonoTecnicoJTField;
    private javax.swing.JLabel telefonoTitularJLabel;
    private com.geopista.app.utilidades.JNumberTextField telefonoTitularJTField;
    private javax.swing.JPanel templateJPanel;
    private javax.swing.JScrollPane templateJScrollPane;
    private javax.swing.JLabel tipoObraJLabel;
    private javax.swing.JLabel tipoViaPromotorJLabel;
    private javax.swing.JLabel tipoViaRepresentaAJLabel;
    private javax.swing.JLabel tipoViaTecnicoJLabel;
    private javax.swing.JLabel tipoViaTitularJLabel;
    private javax.swing.JLabel titulacionPromotorJLabel;
    private javax.swing.JTextField titulacionPromotorJTField;
    private javax.swing.JLabel titulacionTecnicoJLabel;
    private javax.swing.JTextField titulacionTecnicoJTField;
    private javax.swing.JPanel titularJPanel;
    private javax.swing.JLabel unidadRJLabel;
    private javax.swing.JTextField unidadRJTField;
    private javax.swing.JLabel unidadTJLabel;
    private javax.swing.JTextField unidadTJTField;
    private javax.swing.JLabel viaNotificacionPromotorJLabel;
    private javax.swing.JLabel viaNotificacionRepresentaAJLabel;
    private javax.swing.JLabel viaNotificacionTecnicoJLabel;
    private javax.swing.JLabel viaNotificacionTitularJLabel;
    private javax.swing.JLabel visadoPromotorJLabel;
    private javax.swing.JTextField visadoPromotorJTField;
    private javax.swing.JLabel visadoTecnicoJLabel;
    private javax.swing.JTextField visadoTecnicoJTField;
    private javax.swing.JCheckBox jCheckBoxActividadNoCalificada;
    private JTabbedPane jTabbedPaneSolicitud;
    private javax.swing.JLabel cnaeJLabel;
    // End of variables declaration//GEN-END:variables

}
