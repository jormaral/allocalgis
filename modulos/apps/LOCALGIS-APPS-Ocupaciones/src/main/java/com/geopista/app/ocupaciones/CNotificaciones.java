/**
 * CNotificaciones.java
 * � MINETUR, Government of Spain
 * This program is part of LocalGIS
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 2 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * CNotificaciones.java
 *
 * Created on 16 de abril de 2004, 14:38
 */

package com.geopista.app.ocupaciones;


import java.awt.Cursor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.log4j.Logger;

import com.geopista.app.ocupaciones.panel.CCalendarJDialog;
import com.geopista.app.ocupaciones.panel.CSearchJDialog;
import com.geopista.app.utilidades.TableSorted;
import com.geopista.app.utilidades.estructuras.ComboBoxEstructuras;
import com.geopista.protocol.administrador.dominios.DomainNode;
import com.geopista.protocol.licencias.CDatosNotificacion;
import com.geopista.protocol.licencias.CExpedienteLicencia;
import com.geopista.protocol.licencias.CNotificacion;
import com.geopista.protocol.licencias.COperacionesLicencias;
import com.geopista.protocol.licencias.CPersonaJuridicoFisica;

/**
 * @author charo
 */
public class CNotificaciones extends javax.swing.JInternalFrame implements IMultilingue{

	private Vector _vNotificaciones = new Vector();

	/**
	 * Modelo para el componente resultadosJTable
	 */
	private DefaultTableModel _resultadosTableModel;
    TableSorted resultadosJTModelSorted= new TableSorted();
    int hiddenColumn= 8;


    /** Necesario para ir a Modificacion de expdiente */
    private CExpedienteLicencia _expedienteSelected= null;


	Logger logger = Logger.getLogger(CNotificaciones.class);

	/**
	 * Creates new form CNotificaciones
	 */
	public CNotificaciones(JFrame desktop) {
		this.desktop = desktop;
        CUtilidadesComponentes.menuLicenciasSetEnabled(false, this.desktop);

		initComponents();
		initComboBoxesEstructuras();
		String[] columnNames = {CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column1"),
								CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column2"),
                                CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column3"),
								CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column4"),
								CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column5"),
								CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column6"),
								CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column7"),
								CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column8"),
                                "HIDDEN"};

		CNotificacionesTableModel.setColumnNames(columnNames);
		_resultadosTableModel = new CNotificacionesTableModel();

		buscarExpedienteJButton.setIcon(CUtilidadesComponentes.iconoZoom);
		fechaDesdeJButton.setIcon(CUtilidadesComponentes.iconoZoom);
		fechaHastaJButton.setIcon(CUtilidadesComponentes.iconoZoom);

        resultadosJTModelSorted= new TableSorted(_resultadosTableModel);
        resultadosJTModelSorted.setTableHeader(resultadosJTable.getTableHeader());
        resultadosJTable.setModel(resultadosJTModelSorted);
        resultadosJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultadosJTable.getTableHeader().setReorderingAllowed(false);
        ((TableSorted)resultadosJTable.getModel()).getTableHeader().addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                resultadosJTableFocusGained();
            }
        });
        ((TableSorted)resultadosJTable.getModel()).getTableHeader().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultadosJTableMouseClicked();
            }
        });
        TableColumn col= resultadosJTable.getColumnModel().getColumn(hiddenColumn);
        col.setResizable(false);
        col.setWidth(0);
        col.setMaxWidth(0);
        col.setMinWidth(0);
        col.setPreferredWidth(0);


        fechaDesdeJTField.setEnabled(false);
        fechaHastaJTField.setEnabled(false);

		renombrarComponentes();
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
        datosBusquedaJPanel = new javax.swing.JPanel();
        numExpedienteJLabel = new javax.swing.JLabel();
        numExpedienteJTField = new javax.swing.JTextField();
        fechaVencimientoJLabel = new javax.swing.JLabel();
        fechaDesdeJTField = new javax.swing.JTextField();
        fechaHastaJTField = new javax.swing.JTextField();
        tipoLicenciaJLabel = new javax.swing.JLabel();
        buscarJButton = new javax.swing.JButton();
        enEstadoNotificacionJLabel = new javax.swing.JLabel();
        fechaDesdeJButton = new javax.swing.JButton();
        fechaHastaJButton = new javax.swing.JButton();
        buscarExpedienteJButton = new javax.swing.JButton();
        estadoExpedienteJLabel = new javax.swing.JLabel();
        resultadosJScrollPane = new javax.swing.JScrollPane();
        resultadosJTable = new javax.swing.JTable();
        salirJButton = new javax.swing.JButton();
        datosNotificacionJPanel = new javax.swing.JPanel();
        datosNombreApellidosJLabel = new javax.swing.JLabel();
        datosDireccionJLabel = new javax.swing.JLabel();
        datosCPostalJLabel = new javax.swing.JLabel();
        datosNotificarPorJLabel = new javax.swing.JLabel();
        datosNombreApellidosJTField = new javax.swing.JTextField();
        datosCPostalJTField = new javax.swing.JTextField();
        datosDireccionJTField = new javax.swing.JTextField();
        datosNotificarPorJTField = new javax.swing.JTextField();
        borrarFechaDesdeJButton = new javax.swing.JButton();
        borrarFechaHastaJButton = new javax.swing.JButton();
        irExpedienteJButton = new javax.swing.JButton();


        setClosable(true);
        setTitle("Consulta de Notificaciones");
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

        templateJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosBusquedaJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosBusquedaJPanel.setBorder(new javax.swing.border.TitledBorder("Datos de B\u00fasqueda"));
        //datosBusquedaJPanel.setToolTipText("");
        numExpedienteJLabel.setText("N\u00famero de Expediente:");
        datosBusquedaJPanel.add(numExpedienteJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 52, -1, -1));

        datosBusquedaJPanel.add(numExpedienteJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 52, 290, 20));

        fechaVencimientoJLabel.setText("Fecha Vencimiento (desde/hasta):");
        datosBusquedaJPanel.add(fechaVencimientoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 118, -1, -1));

        datosBusquedaJPanel.add(fechaDesdeJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 118, 100, 20));

        datosBusquedaJPanel.add(fechaHastaJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 118, 100, 20));

        tipoLicenciaJLabel.setText("Tipo Licencia:");
        datosBusquedaJPanel.add(tipoLicenciaJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        buscarJButton.setText("Buscar");
        buscarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarJButtonActionPerformed();
            }
        });

        datosBusquedaJPanel.add(buscarJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, -1, -1));
        enEstadoNotificacionJLabel.setText("Estado de la Notificaci\u00f3n:");
        datosBusquedaJPanel.add(enEstadoNotificacionJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 96, -1, -1));

        fechaDesdeJButton.setIcon(CUtilidadesComponentes.iconoZoom);
        fechaDesdeJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fechaDesdeJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        fechaDesdeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaDesdeJButtonActionPerformed();
            }
        });

        datosBusquedaJPanel.add(fechaDesdeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 118, 20, 20));

        fechaHastaJButton.setIcon(CUtilidadesComponentes.iconoZoom);
        fechaHastaJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fechaHastaJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        fechaHastaJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaHastaJButtonActionPerformed();
            }
        });

        datosBusquedaJPanel.add(fechaHastaJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 118, 20, 20));


        borrarFechaDesdeJButton.setIcon(new javax.swing.ImageIcon(""));
        borrarFechaDesdeJButton.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        borrarFechaDesdeJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        borrarFechaDesdeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarFechaDesdeJButtonActionPerformed();
            }
        });

        datosBusquedaJPanel.add(borrarFechaDesdeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 118, 20, 20));

        borrarFechaHastaJButton.setIcon(new javax.swing.ImageIcon(""));
        borrarFechaHastaJButton.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        borrarFechaHastaJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        borrarFechaHastaJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarFechaHastaJButtonActionPerformed();
            }
        });

        datosBusquedaJPanel.add(borrarFechaHastaJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 118, 20, 20));


        buscarExpedienteJButton.setIcon(CUtilidadesComponentes.iconoZoom);
        buscarExpedienteJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buscarExpedienteJButton.setPreferredSize(new java.awt.Dimension(30, 30));
        buscarExpedienteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarExpedienteJButtonActionPerformed();
            }
        });

        datosBusquedaJPanel.add(buscarExpedienteJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 52, 20, 20));

        estadoExpedienteJLabel.setText("Estado actual de Expediente:");
        datosBusquedaJPanel.add(estadoExpedienteJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, -1, -1));

        templateJPanel.add(datosBusquedaJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 10, 980, 210));

        resultadosJScrollPane.setBorder(new javax.swing.border.TitledBorder("Resultado de la B\u00fasqueda"));
        resultadosJTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0)));
        resultadosJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo Licencia", "Num. Expediente", "Fecha Vencimiento", "En Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultadosJTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        resultadosJTable.setFocusCycleRoot(true);
        resultadosJTable.setSurrendersFocusOnKeystroke(true);
        resultadosJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultadosJTableMouseClicked();
            }
        });
        resultadosJTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                resultadosJTableFocusGained();
            }
        });
        resultadosJTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                resultadosJTableMouseDragged();
            }
        });
        resultadosJTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                resultadosJTableKeyTyped();
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                resultadosJTableKeyPressed();
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                resultadosJTableKeyReleased();
            }
        });




        resultadosJScrollPane.setViewportView(resultadosJTable);

        templateJPanel.add(resultadosJScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 220, 980, 210));

        salirJButton.setText("Cancelar");
        salirJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirJButtonActionPerformed();
            }
        });

        templateJPanel.add(salirJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 600, 90, -1));

        irExpedienteJButton.setText(CMainOcupaciones.literales.getString("CNotificaciones.irExpedienteJButton.text"));
        irExpedienteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irExpedienteJButtonActionPerformed();
            }
        });
        templateJPanel.add(irExpedienteJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 600, 120, -1));


        datosNotificacionJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosNotificacionJPanel.setBorder(new javax.swing.border.TitledBorder("Datos de Notificaci\u00f3n de la Notificaci\u00f3n Seleccionada"));
        datosNombreApellidosJLabel.setText("Nombre y Apellidos:");
        datosNotificacionJPanel.add(datosNombreApellidosJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 20));

        datosDireccionJLabel.setText("Direcci\u00f3n:");
        datosNotificacionJPanel.add(datosDireccionJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        datosCPostalJLabel.setText("C.Postal/Municipio/Provincia:");
        datosNotificacionJPanel.add(datosCPostalJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        datosNotificarPorJLabel.setText("Notificar Por:");
        datosNotificacionJPanel.add(datosNotificarPorJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, 20));

        datosNombreApellidosJTField.setEditable(false);
        datosNombreApellidosJTField.setBorder(null);
        datosNotificacionJPanel.add(datosNombreApellidosJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 700, 20));

        datosCPostalJTField.setEditable(false);
        datosCPostalJTField.setBorder(null);
        datosNotificacionJPanel.add(datosCPostalJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 700, 20));

        datosDireccionJTField.setEditable(false);
        datosDireccionJTField.setBorder(null);
        datosNotificacionJPanel.add(datosDireccionJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 700, 20));

        datosNotificarPorJTField.setEditable(false);
        datosNotificarPorJTField.setBorder(null);
        datosNotificacionJPanel.add(datosNotificarPorJTField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 700, 20));

        templateJPanel.add(datosNotificacionJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 430, 980, 160));

        templateJScrollPane.setViewportView(templateJPanel);

        getContentPane().add(templateJScrollPane, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents

    private void irExpedienteJButtonActionPerformed(){

        if (_expedienteSelected == null) {
            mostrarMensaje(CMainOcupaciones.literales.getString("Notificaciones.mensaje2"));
            this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            return;
        }

        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        CConstantesOcupaciones.helpSetHomeID = "ocupacionesModificacion";

        CUtilidadesComponentes.menuLicenciasSetEnabled(false, this.desktop);

        /** Comprobamos si el expediente esta bloqueado */
        if (CUtilidadesComponentes.expedienteBloqueado(_expedienteSelected.getNumExpediente(), CMainOcupaciones.currentLocale)){
            if (CUtilidadesComponentes.mostrarMensajeBloqueo(this, true) != 0){
                this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                return;
            }
        }
        dispose();

        CMainOcupaciones mainOcupaciones = (CMainOcupaciones)desktop;
        mainOcupaciones.mostrarJInternalFrame(new com.geopista.app.ocupaciones.CModificacionLicencias((JFrame)this.desktop, _expedienteSelected.getNumExpediente(), false));

        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_modificarJButtonActionPerformed


    private void borrarFechaHastaJButtonActionPerformed() {//GEN-FIRST:event_borrarFechaHastaJButtonActionPerformed
         fechaHastaJTField.setText("");
    }//GEN-LAST:event_borrarFechaHastaJButtonActionPerformed

    private void borrarFechaDesdeJButtonActionPerformed() {//GEN-FIRST:event_borrarFechaDesdeJButtonActionPerformed
        fechaDesdeJTField.setText("");
    }//GEN-LAST:event_borrarFechaDesdeJButtonActionPerformed


    private void formInternalFrameClosed() {//GEN-FIRST:event_formInternalFrameClosed
        CConstantesOcupaciones.helpSetHomeID = "ocupacionesIntro";
        CUtilidadesComponentes.menuLicenciasSetEnabled(true, this.desktop);
    }//GEN-LAST:event_formInternalFrameClosed

	private void resultadosJTableMouseClicked() {//GEN-FIRST:event_resultadosJTableMouseClicked
	    mostrarNotificacionSeleccionada();
	}//GEN-LAST:event_resultadosJTableMouseClicked

    private void resultadosJTableFocusGained() {//GEN-FIRST:event_resultadosJTableFocusGained
        mostrarNotificacionSeleccionada();
    }//GEN-LAST:event_resultadosJTableFocusGained

    private void resultadosJTableMouseDragged() {//GEN-FIRST:event_resultadosJTableMouseDragged
        mostrarNotificacionSeleccionada();
    }//GEN-LAST:event_resultadosJTableMouseDragged

    private void resultadosJTableKeyReleased() {//GEN-FIRST:event_ultimosJTableKeyReleased
        mostrarNotificacionSeleccionada();
    }//GEN-LAST:event_ultimosJTableKeyReleased

    private void resultadosJTableKeyPressed() {//GEN-FIRST:event_ultimosJTableKeyPressed
        mostrarNotificacionSeleccionada();
    }//GEN-LAST:event_ultimosJTableKeyPressed

    private void resultadosJTableKeyTyped() {//GEN-FIRST:event_ultimosJTableKeyTyped
        mostrarNotificacionSeleccionada();
    }//GEN-LAST:event_ultimosJTableKeyTyped



    private void mostrarNotificacionSeleccionada(){
        int row = resultadosJTable.getSelectedRow();
        if (row != -1) {
            // primero borramos los campos
            datosNombreApellidosJTField.setText("");
            datosDireccionJTField.setText("");
            datosCPostalJTField.setText("");
            datosNotificarPorJTField.setText("");

            // recargamos con los nuevos valores
            CNotificacion notificacion = (CNotificacion) _vNotificaciones.get(((Integer)resultadosJTModelSorted.getValueAt(row, hiddenColumn)).intValue());
            CPersonaJuridicoFisica persona = notificacion.getPersona();
            CDatosNotificacion datos = persona.getDatosNotificacion();
            String interesado= CUtilidades.componerCampo(persona.getApellido1(), persona.getApellido2(), persona.getNombre());
            datosNombreApellidosJTField.setText(interesado);
            datosDireccionJTField.setText(CUtilidades.componerCampo(((DomainNode) Estructuras.getListaTiposViaINE().getDomainNode(datos.getTipoVia())).getTerm(CMainOcupaciones.currentLocale.toString()),
                    datos.getNombreVia(),
                    datos.getNumeroVia()));
            datosCPostalJTField.setText(CUtilidades.componerCampo(datos.getCpostal(), datos.getMunicipio(), datos.getProvincia()));
            datosNotificarPorJTField.setText(((DomainNode)Estructuras.getListaViasNotificacion().getDomainNode(new Integer(datos.getViaNotificacion().getIdViaNotificacion()).toString())).getTerm(CMainOcupaciones.currentLocale.toString()));

            _expedienteSelected= notificacion.getExpediente();
        }else _expedienteSelected= null;
    }


	private void buscarExpedienteJButtonActionPerformed() {//GEN-FIRST:event_buscarExpedienteJButtonActionPerformed
        CSearchJDialog dialog= CUtilidadesComponentes.showSearchDialog(desktop, false);
        if ((dialog != null) && (dialog.getSelectedExpediente() != null)){
            numExpedienteJTField.setText(dialog.getSelectedExpediente());
        }
	}//GEN-LAST:event_buscarExpedienteJButtonActionPerformed

	private void fechaHastaJButtonActionPerformed() {//GEN-FIRST:event_fechaHastaJButtonActionPerformed
	    CCalendarJDialog dialog= CUtilidadesComponentes.showCalendarDialog(desktop);
        if (dialog != null){
            String fecha= dialog.getFechaSelected();
            if ((fecha != null) && (!fecha.trim().equals(""))) {
                fechaHastaJTField.setText(fecha);
            }
        }

	}//GEN-LAST:event_fechaHastaJButtonActionPerformed

	private void fechaDesdeJButtonActionPerformed() {//GEN-FIRST:event_fechaDesdeJButtonActionPerformed
	    CCalendarJDialog dialog= CUtilidadesComponentes.showCalendarDialog(desktop);
        if (dialog != null){
            String fecha= dialog.getFechaSelected();
            if ((fecha != null) && (!fecha.trim().equals(""))) {
                fechaDesdeJTField.setText(fecha);
            }
        }

	}//GEN-LAST:event_fechaDesdeJButtonActionPerformed

	private void salirJButtonActionPerformed() {//GEN-FIRST:event_salirJButtonActionPerformed
		this.dispose();
	}//GEN-LAST:event_salirJButtonActionPerformed

	private void buscarJButtonActionPerformed() {//GEN-FIRST:event_buscarJButtonActionPerformed
		Hashtable hash = new Hashtable();
		hash.put("E.NUM_EXPEDIENTE", numExpedienteJTField.getText());
		if (tipoLicenciaEJCBox.getSelectedIndex() != 0) {
			hash.put("D.TIPO_OCUPACION", tipoLicenciaEJCBox.getSelectedPatron());
		}
		if (estadoNotificacionEJCBox.getSelectedIndex() != 0) {
			hash.put("A.ID_ESTADO", estadoNotificacionEJCBox.getSelectedPatron());
		}
		if (estadoExpedienteEJCBox.getSelectedIndex() != 0) {
			hash.put("E.ID_ESTADO", estadoExpedienteEJCBox.getSelectedPatron());
		}
        /** Fechas de Busqueda */
        if ((CUtilidades.parseFechaStringToString(fechaDesdeJTField.getText()) == null) || (CUtilidades.parseFechaStringToString(fechaHastaJTField.getText()) == null)) {
            mostrarMensaje(CMainOcupaciones.literales.getString("CSearchJDialog.mensaje2"));
            return;
        } else {

            //Between entre fechas
            Date fechaDesde = CUtilidades.parseFechaStringToDate(fechaDesdeJTField.getText());
            if (fechaDesdeJTField.getText().trim().equals("")) {
                fechaDesde = new Date(1);
            }
            Date fechaHasta = CUtilidades.parseFechaStringToDate(fechaHastaJTField.getText().trim());
            if (fechaHastaJTField.getText().trim().equals("")) {
                try{fechaHasta =  new SimpleDateFormat("dd/mm/yyyy").parse("1/1/3000");}catch (Exception e){};
	         }

            if ((fechaDesde != null) && (fechaHasta != null)) {
                /** comprobamos que fechaDesde sea menor que fechaHasta */
                long millisDesde= fechaDesde.getTime();
                long millisHasta= fechaHasta.getTime();
                if (millisDesde > millisHasta){
                    mostrarMensaje(CMainOcupaciones.literales.getString("CSearchJDialog.mensaje1"));
                    return;
                }
                String fechaDesdeFormatted = new SimpleDateFormat("yyyy-MM-dd").format(fechaDesde);
                long millis = fechaHasta.getTime();
                /** annadimos un dia */
                millis += 24 * 60 * 60 * 1000;
                fechaHasta = new Date(millis);
                String fechaHastaFormatted = new SimpleDateFormat("yyyy-MM-dd").format(fechaHasta);

				hash.put("BETWEEN*A.PLAZO_VENCIMIENTO", fechaDesdeFormatted + "*" + fechaHastaFormatted);
			}
		}

		this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

		/** Datos de la solicitud y del expediente seleccionado */
		CUtilidadesComponentes.clearTable(_resultadosTableModel);
		datosCPostalJTField.setText("");
		datosDireccionJTField.setText("");
		datosNombreApellidosJTField.setText("");
		datosNotificarPorJTField.setText("");

        /** Redefinimos el tamanno de las celdas fecha */
        TableColumn column = resultadosJTable.getColumnModel().getColumn(6);
        CUtilidades.resizeColumn(column, 80);
        column = resultadosJTable.getColumnModel().getColumn(7);
        CUtilidades.resizeColumn(column, 80);
        column = resultadosJTable.getColumnModel().getColumn(4);
        CUtilidades.resizeColumn(column, 80);


		_vNotificaciones = COperacionesLicencias.getNotificacionesMenu(hash, null);
		if ((_vNotificaciones != null) && (_vNotificaciones.size() > 0)) {
			this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

			CUtilidadesComponentes.clearTable(_resultadosTableModel);

			for (int i=0; i < _vNotificaciones.size(); i++) {
                CNotificacion notificacion = (CNotificacion) _vNotificaciones.get(i);
                String sEstado="";
                try{sEstado=((DomainNode) Estructuras.getListaEstadosOcupacion().getDomainNode(new Integer(notificacion.getExpediente().getEstado().getIdEstado()).toString())).getTerm(CMainOcupaciones.currentLocale.toString());}catch(Exception e){logger.error("Error al obtener el estado:"+notificacion.getExpediente().getEstado().getIdEstado(),e);}

                String nombreInteresado= CUtilidades.componerCampo(notificacion.getPersona().getApellido1(), notificacion.getPersona().getApellido2(), notificacion.getPersona().getNombre());
                /** intentamos mostrar la referencia catastral con datos de emplazamiento(tipo de via, nombre de calle, ...) si la hay. */
                String emplazamiento= CUtilidades.getEmplazamiento(notificacion.getSolicitud());

				Object[] rowData = {((DomainNode) Estructuras.getListaTipoOcupacion().getDomainNode(new Integer(notificacion.getSolicitud().getDatosOcupacion().getTipoOcupacion()).toString())).getTerm(CMainOcupaciones.currentLocale.toString()),
									notificacion.getExpediente().getNumExpediente(),
                                    emplazamiento,
									sEstado,
									CUtilidades.formatFecha(notificacion.getPlazoVencimiento()),
									//notificacion.getPersona().getDniCif(),
                                    nombreInteresado,
									CUtilidades.formatFecha(notificacion.getFechaNotificacion()),
									CUtilidades.formatFecha(notificacion.getFecha_reenvio()),
                                    new Integer(i)};

				_resultadosTableModel.addRow(rowData);
			}
		} else {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			JOptionPane.showMessageDialog(desktop, CMainOcupaciones.literales.getString("Notificaciones.mensaje1"));
			CUtilidadesComponentes.clearTable(_resultadosTableModel);
			return;
		}


	}//GEN-LAST:event_buscarJButtonActionPerformed




	/*******************************************************************/
	/*                         Metodos propios                         */
	/**
	 * ****************************************************************
	 */

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(datosBusquedaJPanel, mensaje);
	}



	private JFrame desktop;

	private ComboBoxEstructuras tipoLicenciaEJCBox;
	private ComboBoxEstructuras estadoExpedienteEJCBox;
	private ComboBoxEstructuras estadoNotificacionEJCBox;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarExpedienteJButton;
    private javax.swing.JButton buscarJButton;
    private javax.swing.JPanel datosBusquedaJPanel;
    private javax.swing.JLabel datosCPostalJLabel;
    private javax.swing.JTextField datosCPostalJTField;
    private javax.swing.JLabel datosDireccionJLabel;
    private javax.swing.JTextField datosDireccionJTField;
    private javax.swing.JLabel datosNombreApellidosJLabel;
    private javax.swing.JTextField datosNombreApellidosJTField;
    private javax.swing.JPanel datosNotificacionJPanel;
    private javax.swing.JLabel datosNotificarPorJLabel;
    private javax.swing.JTextField datosNotificarPorJTField;
    private javax.swing.JLabel enEstadoNotificacionJLabel;
    private javax.swing.JLabel estadoExpedienteJLabel;
    private javax.swing.JButton fechaDesdeJButton;
    private javax.swing.JTextField fechaDesdeJTField;
    private javax.swing.JButton fechaHastaJButton;
    private javax.swing.JTextField fechaHastaJTField;
    private javax.swing.JLabel fechaVencimientoJLabel;
    private javax.swing.JLabel numExpedienteJLabel;
    private javax.swing.JTextField numExpedienteJTField;
    private javax.swing.JScrollPane resultadosJScrollPane;
    private javax.swing.JTable resultadosJTable;
    private javax.swing.JButton salirJButton;
    private javax.swing.JPanel templateJPanel;
    private javax.swing.JScrollPane templateJScrollPane;
    private javax.swing.JLabel tipoLicenciaJLabel;
    private javax.swing.JButton borrarFechaDesdeJButton;
    private javax.swing.JButton borrarFechaHastaJButton;
    private javax.swing.JButton irExpedienteJButton;

    // End of variables declaration//GEN-END:variables


	public void renombrarComponentes() {

		try {
			setTitle(CMainOcupaciones.literales.getString("CNotificaciones.JInternalFrame.title"));
			datosBusquedaJPanel.setBorder(new javax.swing.border.TitledBorder(CMainOcupaciones.literales.getString("CNotificaciones.datosBusquedaJPanel.TitleBorder")));
			datosNotificacionJPanel.setBorder(new javax.swing.border.TitledBorder(CMainOcupaciones.literales.getString("CNotificaciones.datosNotificacionJPanel.TitleBorder")));
			resultadosJScrollPane.setBorder(new javax.swing.border.TitledBorder(CMainOcupaciones.literales.getString("CNotificaciones.resultadosJScrollPane.TitleBorder")));

			tipoLicenciaJLabel.setText(CMainOcupaciones.literales.getString("CNotificaciones.tipoLicenciaJLabel.text"));
			numExpedienteJLabel.setText(CMainOcupaciones.literales.getString("CNotificaciones.numExpedienteJLabel.text"));
			estadoExpedienteJLabel.setText(CMainOcupaciones.literales.getString("CNotificaciones.estadoExpedienteJLabel.text"));
			enEstadoNotificacionJLabel.setText(CMainOcupaciones.literales.getString("CNotificaciones.enEstadoNotificacionJLabel.text"));
			fechaVencimientoJLabel.setText(CMainOcupaciones.literales.getString("CNotificaciones.fechaVencimientoJLabel.text"));


			datosNombreApellidosJLabel.setText(CMainOcupaciones.literales.getString("CNotificaciones.datosNombreApellidosJLabel.text"));
			datosDireccionJLabel.setText(CMainOcupaciones.literales.getString("CNotificaciones.datosDireccionJLabel.text"));
			datosCPostalJLabel.setText(CMainOcupaciones.literales.getString("CNotificaciones.datosCPostalJLabel.text"));
			datosNotificarPorJLabel.setText(CMainOcupaciones.literales.getString("CNotificaciones.datosNotificarPorJLabel.text"));

			buscarJButton.setText(CMainOcupaciones.literales.getString("CNotificaciones.buscarJButton.text"));
            irExpedienteJButton.setText(CMainOcupaciones.literales.getString("CNotificaciones.irExpedienteJButton.text"));
			salirJButton.setText(CMainOcupaciones.literales.getString("CNotificaciones.salirJButton.text"));

            borrarFechaHastaJButton.setIcon(com.geopista.app.ocupaciones.CUtilidadesComponentes.iconoDeleteParcela);
            borrarFechaDesdeJButton.setIcon(com.geopista.app.ocupaciones.CUtilidadesComponentes.iconoDeleteParcela);

            /** Headers tabla eventos */
            TableColumn tableColumn= resultadosJTable.getColumnModel().getColumn(0);
            tableColumn.setHeaderValue(CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column1"));
            tableColumn= resultadosJTable.getColumnModel().getColumn(1);
            tableColumn.setHeaderValue(CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column2"));
            tableColumn= resultadosJTable.getColumnModel().getColumn(2);
            tableColumn.setHeaderValue(CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column3"));
            tableColumn= resultadosJTable.getColumnModel().getColumn(3);
            tableColumn.setHeaderValue(CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column4"));
            tableColumn= resultadosJTable.getColumnModel().getColumn(4);
            tableColumn.setHeaderValue(CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column5"));
            tableColumn= resultadosJTable.getColumnModel().getColumn(5);
            tableColumn.setHeaderValue(CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column6"));
            tableColumn= resultadosJTable.getColumnModel().getColumn(6);
            tableColumn.setHeaderValue(CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column7"));
            tableColumn= resultadosJTable.getColumnModel().getColumn(7);
            tableColumn.setHeaderValue(CMainOcupaciones.literales.getString("CNotificaciones.resultadosJTable.text.column8"));

            buscarExpedienteJButton.setToolTipText(CMainOcupaciones.literales.getString("CNotificaciones.buscarExpedienteJButton.setToolTip.text"));
            fechaDesdeJButton.setToolTipText(CMainOcupaciones.literales.getString("CNotificaciones.fechaDesdeJButton.setToolTip.text"));
            fechaHastaJButton.setToolTipText(CMainOcupaciones.literales.getString("CNotificaciones.fechaHastaJButton.setToolTip.text"));
            borrarFechaDesdeJButton.setToolTipText(CMainOcupaciones.literales.getString("CNotificaciones.borrarFechaDesdeJButton.setToolTip.text"));
            borrarFechaHastaJButton.setToolTipText(CMainOcupaciones.literales.getString("CNotificaciones.borrarFechaHastaJButton.setToolTip.text"));

            buscarJButton.setToolTipText(CMainOcupaciones.literales.getString("CNotificaciones.buscarJButton.text"));
            irExpedienteJButton.setToolTipText(CMainOcupaciones.literales.getString("CNotificaciones.irExpedienteJButton.text"));
            salirJButton.setToolTipText(CMainOcupaciones.literales.getString("CNotificaciones.salirJButton.text"));
		} catch (Exception ex) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			logger.error("Exception: " + sw.toString());
		}
	}

	public void initComboBoxesEstructuras() {
		while (!Estructuras.isCargada()) {
			if (!Estructuras.isIniciada()) Estructuras.cargarEstructuras();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
		/** Inicializamos los comboBox que llevan estructuras */
		tipoLicenciaEJCBox = new ComboBoxEstructuras(Estructuras.getListaTipoOcupacion(), null, CMainOcupaciones.currentLocale.toString(), true);
        /** por defecto selected TODOS */
        tipoLicenciaEJCBox.setSelectedIndex(0);
		datosBusquedaJPanel.add(tipoLicenciaEJCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 310, 20));

		estadoExpedienteEJCBox = new ComboBoxEstructuras(Estructuras.getListaEstadosOcupacion(), null, CMainOcupaciones.currentLocale.toString(), true);
        /** por defecto selected TODOS */
        estadoExpedienteEJCBox.setSelectedIndex(0);
		datosBusquedaJPanel.add(estadoExpedienteEJCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 74, 310, 20));

		estadoNotificacionEJCBox = new ComboBoxEstructuras(Estructuras.getListaEstadosNotificacion(), null, CMainOcupaciones.currentLocale.toString(), true);
        /** por defecto selected TODOS */
        estadoNotificacionEJCBox.setSelectedIndex(0);                        
		datosBusquedaJPanel.add(estadoNotificacionEJCBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 96, 310, 20));

	}

    public void setEnabledIrExpedienteJButton(boolean b){
        irExpedienteJButton.setEnabled(b);
    }
    

}
