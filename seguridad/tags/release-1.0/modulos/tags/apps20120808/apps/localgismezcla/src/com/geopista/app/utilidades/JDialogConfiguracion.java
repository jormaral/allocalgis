/*
 * JDialogConfiguracion.java
 *
 * Created on 5 de mayo de 2005, 11:19
 */

package com.geopista.app.utilidades;

import org.apache.log4j.Logger;

import java.util.ResourceBundle;

import com.geopista.util.ApplicationContext;
import com.geopista.app.AppContext;

/**
 *
 * @author  angeles
 */
public class JDialogConfiguracion extends javax.swing.JDialog {
    private ResourceBundle messages;
    private Logger logger = Logger.getLogger(JDialogConfiguracion.class);
    /** Licencias de obra */
    private static final String SERVICIO="geopista.licencias.servicio";
    private static final String INICIO="geopista.licencias.inicio";
    private static final String RESPONSABLE="geopista.licencias.responsable";
    private static final String UNIDAD_TRAMITADORA="geopista.licencias.unidad.tramitadora";
    private static final String UNIDAD_REGISTRO="geopista.licencias.unidad.registro";

    /** Licencias de actividad */
    private static final String SERVICIO_ACTIVIDAD="geopista.actividad.servicio";
    private static final String INICIO_ACTIVIDAD="geopista.actividad.inicio";
    private static final String RESPONSABLE_ACTIVIDAD="geopista.actividad.responsable";
    private static final String UNIDAD_TRAMITADORA_ACTIVIDAD="geopista.actividad.unidad.tramitadora";
    private static final String UNIDAD_REGISTRO_ACTIVIDAD="geopista.actividad.unidad.registro";

    /** Licencias de ocupacion */
    private static final String SERVICIO_OCUPACION="geopista.ocupaciones.servicio";
    private static final String INICIO_OCUPACION="geopista.ocupaciones.inicio";
    private static final String RESPONSABLE_OCUPACION="geopista.ocupaciones.responsable";
    private static final String UNIDAD_TRAMITADORA_OCUPACION="geopista.ocupaciones.unidad.tramitadora";
    private static final String UNIDAD_REGISTRO_OCUPACION="geopista.ocupaciones.unidad.registro";


    private String descApp= "";

    /** Creates new form JDialogConfiguracion */
    public JDialogConfiguracion(java.awt.Frame parent, boolean modal, ResourceBundle messages, String descApp) {
        super(parent, modal);
        this.descApp= descApp;
        this.messages=messages;
        initComponents();
        initData();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jPanelDatos = new javax.swing.JPanel();
        jLabelServicio = new javax.swing.JLabel();
        //jTextFieldServicio = new javax.swing.JTextField();
        /** Definido en BD como varchar(128) */
        jTextFieldServicio= new com.geopista.app.utilidades.TextField(128);
        jTextFieldInicio = new javax.swing.JTextField();
        jLabelInicio = new javax.swing.JLabel();
        //jTextFieldResponsable = new javax.swing.JTextField();
        /** Definido en BD como varchar(128) */
        jTextFieldResponsable= new com.geopista.app.utilidades.TextField(128);
        //jTextFieldUTramitadora= new javax.swing.JTextField();
        /** Definido en BD como varchar(32) */
        jTextFieldUTramitadora= new com.geopista.app.utilidades.TextField(32);
        //jTextFieldURegistro= new javax.swing.JTextField();
        /** Definido en BD como varchar(32) */
        jTextFieldURegistro= new com.geopista.app.utilidades.TextField(32);
        jLabelResponsable = new javax.swing.JLabel();
        jLabelUTramitadora= new javax.swing.JLabel();
        jLabelURegistro = new javax.swing.JLabel();
        jPanelBotonera = new javax.swing.JPanel();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jPanelDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelDatos.setBorder(new javax.swing.border.TitledBorder("Par\u00e1metros"));
        jPanelDatos.add(jLabelServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, -1));
        jPanelDatos.add(jTextFieldServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 270, -1));
        jPanelDatos.add(jTextFieldInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 270, -1));
        jPanelDatos.add(jLabelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, -1));
        jPanelDatos.add(jTextFieldResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 270, -1));
        jPanelDatos.add(jLabelResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10,80, 110, -1));
        jPanelDatos.add(jTextFieldUTramitadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 270, -1));
        jPanelDatos.add(jLabelUTramitadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, -1));
        jPanelDatos.add(jTextFieldURegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 270, -1));
        jPanelDatos.add(jLabelURegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, -1));

        getContentPane().add(jPanelDatos, java.awt.BorderLayout.CENTER);
        jPanelBotonera.add(jButtonAceptar);
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				aceptar();
			}
		});
        jPanelBotonera.add(jButtonCancelar);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dispose();
			}
		});
        changeScreenLang(messages);
        getContentPane().add(jPanelBotonera, java.awt.BorderLayout.SOUTH);
        pack();
    }//GEN-END:initComponents

     public void changeScreenLang(ResourceBundle messages) {
        try
        {
            this.messages = messages;
            setTitle(messages.getString("JDialogConfiguracion.title"));//"Configuración");//messages.getString("JDialogBuscarVertedero.title"));//"Seleccionar vertedero");
            jLabelResponsable.setText(messages.getString("JDialogConfiguracion.jLabelResponsable"));//"Responsable:");
            jButtonAceptar.setText(messages.getString("JDialogConfiguracion.jButtonAceptar"));//"Aceptar");
            jButtonCancelar.setText(messages.getString("JDialogConfiguracion.jButtonCancelar"));//"Cancelar");
            jLabelServicio.setText(messages.getString("JDialogConfiguracion.jLabelServicio"));//"Servicio encargado:");
            jLabelInicio.setText(messages.getString("JDialogConfiguracion.jLabelInicio"));//"Forma de inicio:");
            jLabelUTramitadora.setText(messages.getString("JDialogConfiguracion.jLabelUTramitadora"));//Unidad tramitadora
            jLabelURegistro.setText(messages.getString("JDialogConfiguracion.jLabelURegistro"));//Unidad tramitadora
        }catch(Exception e)
        {
            logger.error("Error al cargar las etiquetas: ",e);
        }
 	}
    private void initData()
    {
        ApplicationContext app= AppContext.getApplicationContext();
        if (descApp.equalsIgnoreCase("LICENCIAS_OBRA")){
            jTextFieldServicio.setText((SERVICIO.equalsIgnoreCase(app.getString(SERVICIO))?"":app.getString(SERVICIO)));
            jTextFieldInicio.setText((INICIO.equalsIgnoreCase(app.getString(INICIO))?"":app.getString(INICIO)));
            jTextFieldResponsable.setText((RESPONSABLE.equalsIgnoreCase(app.getString(RESPONSABLE))?"":app.getString(RESPONSABLE)));
            jTextFieldUTramitadora.setText((UNIDAD_TRAMITADORA.equalsIgnoreCase(app.getString(UNIDAD_TRAMITADORA))?"":app.getString(UNIDAD_TRAMITADORA)));
            jTextFieldURegistro.setText((UNIDAD_REGISTRO.equalsIgnoreCase(app.getString(UNIDAD_REGISTRO))?"":app.getString(UNIDAD_REGISTRO)));
        }else if (descApp.equalsIgnoreCase("LICENCIAS_ACTIVIDAD")){
            jTextFieldServicio.setText((SERVICIO_ACTIVIDAD.equalsIgnoreCase(app.getString(SERVICIO_ACTIVIDAD))?"":app.getString(SERVICIO_ACTIVIDAD)));
            jTextFieldInicio.setText((INICIO_ACTIVIDAD.equalsIgnoreCase(app.getString(INICIO_ACTIVIDAD))?"":app.getString(INICIO_ACTIVIDAD)));
            jTextFieldResponsable.setText((RESPONSABLE_ACTIVIDAD.equalsIgnoreCase(app.getString(RESPONSABLE_ACTIVIDAD))?"":app.getString(RESPONSABLE_ACTIVIDAD)));
            jTextFieldUTramitadora.setText((UNIDAD_TRAMITADORA_ACTIVIDAD.equalsIgnoreCase(app.getString(UNIDAD_TRAMITADORA_ACTIVIDAD))?"":app.getString(UNIDAD_TRAMITADORA_ACTIVIDAD)));
            jTextFieldURegistro.setText((UNIDAD_REGISTRO_ACTIVIDAD.equalsIgnoreCase(app.getString(UNIDAD_REGISTRO_ACTIVIDAD))?"":app.getString(UNIDAD_REGISTRO_ACTIVIDAD)));
        }else if (descApp.equalsIgnoreCase("LICENCIAS_OCUPACION")){
            jTextFieldServicio.setText((SERVICIO_OCUPACION.equalsIgnoreCase(app.getString(SERVICIO_OCUPACION))?"":app.getString(SERVICIO_OCUPACION)));
            jTextFieldInicio.setText((INICIO_OCUPACION.equalsIgnoreCase(app.getString(INICIO_OCUPACION))?"":app.getString(INICIO_OCUPACION)));
            jTextFieldResponsable.setText((RESPONSABLE_OCUPACION.equalsIgnoreCase(app.getString(RESPONSABLE_OCUPACION))?"":app.getString(RESPONSABLE_OCUPACION)));
            jTextFieldUTramitadora.setText((UNIDAD_TRAMITADORA_OCUPACION.equalsIgnoreCase(app.getString(UNIDAD_TRAMITADORA_OCUPACION))?"":app.getString(UNIDAD_TRAMITADORA_OCUPACION)));
            jTextFieldURegistro.setText((UNIDAD_REGISTRO_OCUPACION.equalsIgnoreCase(app.getString(UNIDAD_REGISTRO_OCUPACION))?"":app.getString(UNIDAD_REGISTRO_OCUPACION)));
        }
    }
    private void aceptar()
    {
        ApplicationContext app = AppContext.getApplicationContext();
        if (descApp.equalsIgnoreCase("LICENCIAS_OBRA")){
            app.setUserPreference(SERVICIO,jTextFieldServicio.getText());
            app.setUserPreference(INICIO,jTextFieldInicio.getText());
            app.setUserPreference(RESPONSABLE,jTextFieldResponsable.getText());
            app.setUserPreference(UNIDAD_TRAMITADORA,jTextFieldUTramitadora.getText());
            app.setUserPreference(UNIDAD_REGISTRO,jTextFieldURegistro.getText());
        }else if (descApp.equalsIgnoreCase("LICENCIAS_ACTIVIDAD")){
            app.setUserPreference(SERVICIO_ACTIVIDAD,jTextFieldServicio.getText());
            app.setUserPreference(INICIO_ACTIVIDAD,jTextFieldInicio.getText());
            app.setUserPreference(RESPONSABLE_ACTIVIDAD,jTextFieldResponsable.getText());
            app.setUserPreference(UNIDAD_TRAMITADORA_ACTIVIDAD,jTextFieldUTramitadora.getText());
            app.setUserPreference(UNIDAD_REGISTRO_ACTIVIDAD,jTextFieldURegistro.getText());
        }else if (descApp.equalsIgnoreCase("LICENCIAS_OCUPACION")){
            app.setUserPreference(SERVICIO_OCUPACION,jTextFieldServicio.getText());
            app.setUserPreference(INICIO_OCUPACION,jTextFieldInicio.getText());
            app.setUserPreference(RESPONSABLE_OCUPACION,jTextFieldResponsable.getText());
            app.setUserPreference(UNIDAD_TRAMITADORA_OCUPACION,jTextFieldUTramitadora.getText());
            app.setUserPreference(UNIDAD_REGISTRO_OCUPACION,jTextFieldURegistro.getText());
        }

        dispose();
    }
    public static String getServicio()
    {
        ApplicationContext app = AppContext.getApplicationContext();
        return (SERVICIO.equalsIgnoreCase(app.getString(SERVICIO))?"":app.getString(SERVICIO));
    }
    public static String getServicioActividades(){
        ApplicationContext app = AppContext.getApplicationContext();
        return (SERVICIO_ACTIVIDAD.equalsIgnoreCase(app.getString(SERVICIO_ACTIVIDAD))?"":app.getString(SERVICIO_ACTIVIDAD));
    }
    public static String getServicioOcupaciones(){
        ApplicationContext app = AppContext.getApplicationContext();
        return (SERVICIO_OCUPACION.equalsIgnoreCase(app.getString(SERVICIO_OCUPACION))?"":app.getString(SERVICIO_OCUPACION));
    }

    public static String getInicio()
    {
        ApplicationContext app = AppContext.getApplicationContext();
        return (INICIO.equalsIgnoreCase(app.getString(INICIO))?"":app.getString(INICIO));
    }
    public static String getInicioActividades(){
        ApplicationContext app = AppContext.getApplicationContext();
        return (INICIO_ACTIVIDAD.equalsIgnoreCase(app.getString(INICIO_ACTIVIDAD))?"":app.getString(INICIO_ACTIVIDAD));
    }
    public static String getInicioOcupaciones(){
        ApplicationContext app = AppContext.getApplicationContext();
        return (INICIO_OCUPACION.equalsIgnoreCase(app.getString(INICIO_OCUPACION))?"":app.getString(INICIO_OCUPACION));
    }
    public static String getResponsable()
    {
        ApplicationContext app = AppContext.getApplicationContext();
        return (RESPONSABLE.equalsIgnoreCase(app.getString(RESPONSABLE))?"":app.getString(RESPONSABLE));
    }
    public static String getResponsableActividades(){
        ApplicationContext app = AppContext.getApplicationContext();
        return (RESPONSABLE_ACTIVIDAD.equalsIgnoreCase(app.getString(RESPONSABLE_ACTIVIDAD))?"":app.getString(RESPONSABLE_ACTIVIDAD));
    }
    public static String getResponsableOcupaciones(){
        ApplicationContext app = AppContext.getApplicationContext();
        return (RESPONSABLE_OCUPACION.equalsIgnoreCase(app.getString(RESPONSABLE_OCUPACION))?"":app.getString(RESPONSABLE_OCUPACION));
    }
    public static String getUnidadTramitadora()
    {
        ApplicationContext app = AppContext.getApplicationContext();
        return (UNIDAD_TRAMITADORA.equalsIgnoreCase(app.getString(UNIDAD_TRAMITADORA))?"":app.getString(UNIDAD_TRAMITADORA));
    }
    public static String getUnidadTramitadoraActividades(){
        ApplicationContext app = AppContext.getApplicationContext();
        return (UNIDAD_TRAMITADORA_ACTIVIDAD.equalsIgnoreCase(app.getString(UNIDAD_TRAMITADORA_ACTIVIDAD))?"":app.getString(UNIDAD_TRAMITADORA_ACTIVIDAD));
    }
    public static String getUnidadTramitadoraOcupaciones(){
        ApplicationContext app = AppContext.getApplicationContext();
        return (UNIDAD_TRAMITADORA_OCUPACION.equalsIgnoreCase(app.getString(UNIDAD_TRAMITADORA_OCUPACION))?"":app.getString(UNIDAD_TRAMITADORA_OCUPACION));
    }
    public static String getUnidadRegistro()
    {
        ApplicationContext app = AppContext.getApplicationContext();
        return (UNIDAD_REGISTRO.equalsIgnoreCase(app.getString(UNIDAD_REGISTRO))?"":app.getString(UNIDAD_REGISTRO));
    }
    public static String getUnidadRegistroActividades(){
        ApplicationContext app = AppContext.getApplicationContext();
        return (UNIDAD_REGISTRO_ACTIVIDAD.equalsIgnoreCase(app.getString(UNIDAD_REGISTRO_ACTIVIDAD))?"":app.getString(UNIDAD_REGISTRO_ACTIVIDAD));
    }
    public static String getUnidadRegistroOcupaciones(){
        ApplicationContext app = AppContext.getApplicationContext();
        return (UNIDAD_REGISTRO_OCUPACION.equalsIgnoreCase(app.getString(UNIDAD_REGISTRO_OCUPACION))?"":app.getString(UNIDAD_REGISTRO_OCUPACION));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelInicio;
    private javax.swing.JLabel jLabelResponsable;
    private javax.swing.JLabel jLabelServicio;
    private javax.swing.JLabel jLabelUTramitadora;
    private javax.swing.JLabel jLabelURegistro;
    private javax.swing.JPanel jPanelBotonera;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JTextField jTextFieldInicio;
    //private javax.swing.JTextField jTextFieldResponsable;
    private com.geopista.app.utilidades.TextField jTextFieldResponsable;
    //private javax.swing.JTextField jTextFieldServicio;
    private com.geopista.app.utilidades.TextField jTextFieldServicio;
    //private javax.swing.JTextField jTextFieldUTramitadora;
    private com.geopista.app.utilidades.TextField jTextFieldUTramitadora;
    //private javax.swing.JTextField jTextFieldURegistro;
    private com.geopista.app.utilidades.TextField jTextFieldURegistro;
    // End of variables declaration//GEN-END:variables
    
}
