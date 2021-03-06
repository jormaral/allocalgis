package com.geopista.server.database.validacion;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.geopista.server.database.COperacionesEIEL;
import com.geopista.server.database.validacion.beans.CodIne_bean;
import com.geopista.server.database.validacion.beans.V_cap_agua_nucleo_bean;
import com.geopista.server.database.validacion.beans.V_captacion_enc_bean;
import com.geopista.server.database.validacion.beans.V_captacion_enc_m50_bean;
import com.geopista.server.database.validacion.beans.V_colector_enc_bean;
import com.geopista.server.database.validacion.beans.V_colector_enc_m50_bean;
import com.geopista.server.database.validacion.beans.V_colector_nucleo_bean;
import com.geopista.server.database.validacion.beans.V_cond_agua_nucleo_bean;
import com.geopista.server.database.validacion.beans.V_conduccion_enc_bean;
import com.geopista.server.database.validacion.beans.V_conduccion_enc_m50_bean;
import com.geopista.server.database.validacion.beans.V_dep_agua_nucleo_bean;
import com.geopista.server.database.validacion.beans.V_deposito_agua_nucleo_bean;
import com.geopista.server.database.validacion.beans.V_deposito_enc_bean;
import com.geopista.server.database.validacion.beans.V_deposito_enc_m50_bean;
import com.geopista.server.database.validacion.beans.V_emisario_enc_m50_bean;
import com.geopista.server.database.validacion.beans.V_emisario_nucleo_bean;
import com.geopista.server.database.validacion.beans.V_infraestr_viaria_bean;
import com.geopista.server.database.validacion.beans.V_mun_enc_dis_bean;
import com.geopista.server.database.validacion.beans.V_nucl_encuestado_1_bean;
import com.geopista.server.database.validacion.beans.V_nucl_encuestado_2_bean;
import com.geopista.server.database.validacion.beans.V_nucl_encuestado_3_bean;
import com.geopista.server.database.validacion.beans.V_nucl_encuestado_4_bean;
import com.geopista.server.database.validacion.beans.V_nucl_encuestado_5_bean;
import com.geopista.server.database.validacion.beans.V_ot_serv_municipal_bean;
import com.geopista.server.database.validacion.beans.V_padron_bean;
import com.geopista.server.database.validacion.beans.V_plan_urbanistico_bean;
import com.geopista.server.database.validacion.beans.V_potabilizacion_enc_bean;
import com.geopista.server.database.validacion.beans.V_potabilizacion_enc_m50_bean;
import com.geopista.server.database.validacion.beans.V_ramal_saneamiento_bean;
import com.geopista.server.database.validacion.beans.V_red_distribucion_bean;
import com.geopista.server.database.validacion.beans.V_sanea_autonomo_bean;
import com.geopista.server.database.validacion.beans.V_tramo_carretera_bean;
import com.geopista.server.database.validacion.beans.V_tramo_colector_bean;
import com.geopista.server.database.validacion.beans.V_tramo_colector_m50_bean;
import com.geopista.server.database.validacion.beans.V_tramo_conduccion_bean;
import com.geopista.server.database.validacion.beans.V_tramo_conduccion_m50_bean;
import com.geopista.server.database.validacion.beans.V_tramo_emisario_m50_bean;
import com.geopista.server.database.validacion.beans.V_trat_pota_nucleo_bean;

public class Validacion_cuadro30 {
	
	
	public static void validacion(Connection connection, StringBuffer str, ArrayList lstValCuadros){
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean error = false;
		
	    int contTexto = 0;
	    
		try
        {     
			str.append(Messages.getString("cuadro30") + "\n");
			str.append("______________________________________________________________________\n\n");
			
			String sql = "select * from v_EMISARIO_NUCLEO";
			String sql_1 = "select * from v_NUCL_ENCUESTADO_5";
			String sql_2 = "select * from v_SANEA_AUTONOMO";
			String sql_3 = "select * from v_PADRON";
			String sql_4 = "select * from v_EMISARIO_ENC_M50";
			String sql_5 = "select * from v_TRAMO_EMISARIO_M50";

			ArrayList lstemisario_nucleo = new ArrayList();
			ArrayList lstnucl_encuestado_5 = new ArrayList();
			ArrayList lstsanea_autonomo = new ArrayList();
			ArrayList lstpadron = new ArrayList();
			ArrayList lstemisario_enc_m50 = new ArrayList();
			ArrayList lsttramo_emisario_m50 = new ArrayList();
			

			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {	

				V_emisario_nucleo_bean emisario_nucleo_bean = new V_emisario_nucleo_bean();


				emisario_nucleo_bean.setProvincia(rs.getString("PROVINCIA"));
				emisario_nucleo_bean.setMunicipio(rs.getString("MUNICIPIO"));
				emisario_nucleo_bean.setEntidad(rs.getString("ENTIDAD"));
				emisario_nucleo_bean.setNucleo(rs.getString("NUCLEO"));
				emisario_nucleo_bean.setClave(rs.getString("CLAVE"));
				emisario_nucleo_bean.setEm_provinc(rs.getString("EM_PROVINC"));
				emisario_nucleo_bean.setEm_municip(rs.getString("EM_MUNICIP"));
				emisario_nucleo_bean.setOrden_emis(rs.getString("ORDEN_EMIS"));

				lstemisario_nucleo.add(emisario_nucleo_bean);
				
			}
			
			
			ps = connection.prepareStatement(sql_1);
			rs = ps.executeQuery();
			while (rs.next()) {	
				V_nucl_encuestado_5_bean  nucl_encuestado_5_bean = new V_nucl_encuestado_5_bean();

				nucl_encuestado_5_bean.setProvincia(rs.getString("PROVINCIA"));
				nucl_encuestado_5_bean.setMunicipio(rs.getString("MUNICIPIO"));
				nucl_encuestado_5_bean.setEntidad(rs.getString("ENTIDAD"));
				nucl_encuestado_5_bean.setNucleo(rs.getString("NUCLEO"));
				nucl_encuestado_5_bean.setSyd_pozos(rs.getString("SYD_POZOS"));
				nucl_encuestado_5_bean.setSyd_sumide(rs.getString("SYD_SUMIDE"));
				nucl_encuestado_5_bean.setSyd_ali_co(rs.getString("SYD_ALI_CO"));
				nucl_encuestado_5_bean.setSyd_ali_si(rs.getString("SYD_ALI_SI"));
				nucl_encuestado_5_bean.setSyd_calida(rs.getString("SYD_CALIDA"));		
				nucl_encuestado_5_bean.setSyd_v_cone(new Integer(rs.getString("SYD_V_CONE")));
				nucl_encuestado_5_bean.setSyd_v_ncon(new Integer(rs.getString("SYD_V_NCON")));
				nucl_encuestado_5_bean.setSyd_l_defi(new Integer(rs.getString("SYD_L_DEFI")));
				nucl_encuestado_5_bean.setSyd_v_defi(new Integer(rs.getString("SYD_V_DEFI")));
				nucl_encuestado_5_bean.setSyd_pr_def(new Integer(rs.getString("SYD_PR_DEF")));
				nucl_encuestado_5_bean.setSyd_pe_def(new Integer(rs.getString("SYD_PE_DEF")));
				nucl_encuestado_5_bean.setSyd_c_desa(new Integer(rs.getString("SYD_C_DESA")));
				nucl_encuestado_5_bean.setSyd_c_trat(new Integer(rs.getString("SYD_C_TRAT")));
				nucl_encuestado_5_bean.setSyd_re_urb(new Integer(rs.getString("SYD_RE_URB")));
				nucl_encuestado_5_bean.setSyd_re_rus(new Integer(rs.getString("SYD_RE_RUS")));
				nucl_encuestado_5_bean.setSyd_re_ind(new Integer(rs.getString("SYD_RE_IND")));
				
				lstnucl_encuestado_5.add(nucl_encuestado_5_bean);
				
			}
			
			ps = connection.prepareStatement(sql_2);
			rs = ps.executeQuery();
			while (rs.next()) {	
				V_sanea_autonomo_bean  sanea_autonomo_bean = new V_sanea_autonomo_bean();

				sanea_autonomo_bean.setProvincia(rs.getString("PROVINCIA"));
				sanea_autonomo_bean.setMunicipio(rs.getString("MUNICIPIO"));
				sanea_autonomo_bean.setEntidad(rs.getString("ENTIDAD"));
				sanea_autonomo_bean.setNucleo(rs.getString("NUCLEO"));
				sanea_autonomo_bean.setTipo_sanea(rs.getString("TIPO_SANEA"));
				sanea_autonomo_bean.setEstado(rs.getString("ESTADO"));
				sanea_autonomo_bean.setAdecuacion(rs.getString("ADECUACION"));
				sanea_autonomo_bean.setSau_vivien(new Integer(rs.getString("SAU_VIVIEN")));
				sanea_autonomo_bean.setSau_pob_re(new Integer(rs.getString("SAU_POB_RE")));
				sanea_autonomo_bean.setSau_pob_es(new Integer(rs.getString("SAU_POB_ES")));
				sanea_autonomo_bean.setSau_vi_def(new Integer(rs.getString("SAU_VI_DEF")));
				sanea_autonomo_bean.setSau_re_def(new Integer(rs.getString("SAU_RE_DEF")));
				sanea_autonomo_bean.setSau_es_def(new Integer(rs.getString("SAU_ES_DEF")));	

				lstsanea_autonomo.add(sanea_autonomo_bean);
				
			}
			
			ps = connection.prepareStatement(sql_3);
			rs = ps.executeQuery();
			while (rs.next()) {	
				V_padron_bean  padron_bean = new V_padron_bean();

				padron_bean.setCodprov(rs.getString("PROVINCIA"));
				padron_bean.setCodmunic(rs.getString("MUNICIPIO"));
				padron_bean.setN_hombre_a1(new Integer(rs.getString("HOMBRES")));
				padron_bean.setN_mujeres_a1(new Integer(rs.getString("MUJERES")));
				padron_bean.setTotal_poblacion_a1(new Integer(rs.getString("TOTAL_POB")));
				lstpadron.add(padron_bean);
			}
			
			
			ps = connection.prepareStatement(sql_4);
			rs = ps.executeQuery();
			while (rs.next()) {	
				V_emisario_enc_m50_bean emisario_enc_m50_bean = new V_emisario_enc_m50_bean();

				emisario_enc_m50_bean.setClave(rs.getString("CLAVE"));
				emisario_enc_m50_bean.setProvincia(rs.getString("PROVINCIA"));
				emisario_enc_m50_bean.setMunicipio(rs.getString("MUNICIPIO"));
				emisario_enc_m50_bean.setOrden_emis(rs.getString("ORDEN_EMIS"));
				emisario_enc_m50_bean.setTipo_vert(rs.getString("TIPO_VERT"));
				emisario_enc_m50_bean.setZona_vert(rs.getString("ZONA_VERT"));
				if(rs.getString("DISTANCIA")!=null && !rs.getString("DISTANCIA").equals("") )
					emisario_enc_m50_bean.setDistancia(new Integer(rs.getString("DISTANCIA")));
				else
				
				lstemisario_enc_m50.add(emisario_enc_m50_bean);
			}
			
			
			ps = connection.prepareStatement(sql_5);
			rs = ps.executeQuery();
			while (rs.next()) {	
				V_tramo_emisario_m50_bean tramo_emisario_m50_bean = new V_tramo_emisario_m50_bean();

				tramo_emisario_m50_bean.setClave(rs.getString("CLAVE"));
				tramo_emisario_m50_bean.setProvincia(rs.getString("PROVINCIA"));
				tramo_emisario_m50_bean.setMunicipio(rs.getString("MUNICIPIO"));
				tramo_emisario_m50_bean.setOrden_emis(rs.getString("ORDEN_EMIS"));
				tramo_emisario_m50_bean.setTipo_mat(rs.getString("TIPO_MAT"));
				tramo_emisario_m50_bean.setEstado(rs.getString("ESTADO"));
				if(rs.getString("LONG_TERRE")!=null&&!rs.getString("LONG_TERRE").equals(""))
					tramo_emisario_m50_bean.setLong_terre(new Double(Math.rint(new Double(rs.getString("LONG_TERRE")))).intValue());
				else
					tramo_emisario_m50_bean.setLong_terre(0);
				if(rs.getString("LONG_MARIT")!=null&&!rs.getString("LONG_MARIT").equals(""))
					tramo_emisario_m50_bean.setLong_marit(new Double(Math.rint(new Double(rs.getString("LONG_MARIT")))).intValue());
				else
					tramo_emisario_m50_bean.setLong_marit(0);

				lsttramo_emisario_m50.add(tramo_emisario_m50_bean);
				
			}
		
			if(lstValCuadros.contains("v01")){
				//ERROR DEL MPT -> (V_01) 
				for (int i = 0; i < lstemisario_nucleo.size(); i++)
	            {
					V_emisario_nucleo_bean emisario_nucleo_bean   = (V_emisario_nucleo_bean)lstemisario_nucleo.get(i);
					for (int j = 0; j < lstnucl_encuestado_5.size(); j++)
		            {
						V_nucl_encuestado_5_bean nucl_encuestado_5_bean   = (V_nucl_encuestado_5_bean)lstnucl_encuestado_5.get(j);
						if(nucl_encuestado_5_bean.getProvincia().equals(emisario_nucleo_bean.getProvincia()) && 
								nucl_encuestado_5_bean.getMunicipio().equals(emisario_nucleo_bean.getMunicipio()) && 
								nucl_encuestado_5_bean.getEntidad().equals(emisario_nucleo_bean.getEntidad()) &&
								nucl_encuestado_5_bean.getNucleo().equals(emisario_nucleo_bean.getNucleo())){
							
							if((nucl_encuestado_5_bean.getSyd_v_cone() + nucl_encuestado_5_bean.getSyd_v_ncon()) == 0){
								if (contTexto == 0)
								 {
									 str.append(Messages.getString("errorMPT") + " " +Messages.getString("cuadro30.V_01") + "\n");
									 str.append("\n");
									 contTexto++;
								 }
								 str.append( emisario_nucleo_bean.getProvincia() + emisario_nucleo_bean.getMunicipio() + 
										 emisario_nucleo_bean.getEntidad()  + emisario_nucleo_bean.getNucleo()+"\t");
								 error = true;
							}
						}
					}
				
	            }
				if (error)
					str.append("\n\n");
				error = false;
				contTexto = 0;
			}
			if(lstValCuadros.contains("v02")){
				//ERROR DEL MPT -> (V_02) 
				for (int i = 0; i < lstemisario_nucleo.size(); i++)
	            {
					V_nucl_encuestado_5_bean nucl_encuestado_5_bean_encontrado = null;
					V_sanea_autonomo_bean sanea_autonomo_bean_encontrado = null;
					
					V_emisario_nucleo_bean emisario_nucleo_bean   = (V_emisario_nucleo_bean)lstemisario_nucleo.get(i);
					for (int j = 0; j < lstnucl_encuestado_5.size(); j++)
		            {
						V_nucl_encuestado_5_bean nucl_encuestado_5_bean   = (V_nucl_encuestado_5_bean)lstnucl_encuestado_5.get(j);
						if(nucl_encuestado_5_bean.getProvincia().equals(emisario_nucleo_bean.getProvincia()) && 
								nucl_encuestado_5_bean.getMunicipio().equals(emisario_nucleo_bean.getMunicipio()) && 
								nucl_encuestado_5_bean.getEntidad().equals(emisario_nucleo_bean.getEntidad()) &&
								nucl_encuestado_5_bean.getNucleo().equals(emisario_nucleo_bean.getNucleo())){
							
							nucl_encuestado_5_bean_encontrado = nucl_encuestado_5_bean;
						}
					}
					
					
					for (int j = 0; j < lstsanea_autonomo.size(); j++)
		            {
						V_sanea_autonomo_bean sanea_autonomo_bean   = (V_sanea_autonomo_bean)lstsanea_autonomo.get(j);
						if(sanea_autonomo_bean.getProvincia().equals(emisario_nucleo_bean.getProvincia()) && 
								sanea_autonomo_bean.getMunicipio().equals(emisario_nucleo_bean.getMunicipio()) && 
								sanea_autonomo_bean.getEntidad().equals(emisario_nucleo_bean.getEntidad()) &&
								sanea_autonomo_bean.getNucleo().equals(emisario_nucleo_bean.getNucleo())){
							
							sanea_autonomo_bean_encontrado = sanea_autonomo_bean;
						}
					}
	
					if(sanea_autonomo_bean_encontrado != null && nucl_encuestado_5_bean_encontrado != null){
						if((nucl_encuestado_5_bean_encontrado.getSyd_v_cone() + nucl_encuestado_5_bean_encontrado.getSyd_v_ncon()) == 
									sanea_autonomo_bean_encontrado.getSau_vi_def()){
												
							if (contTexto == 0)
							 {
								 str.append(Messages.getString("errorMPT") + " " +Messages.getString("cuadro30.V_02") + "\n");
								 str.append("\n");
								 contTexto++;
							 }
							 str.append( emisario_nucleo_bean.getProvincia() + emisario_nucleo_bean.getMunicipio() + 
									 emisario_nucleo_bean.getEntidad()  + emisario_nucleo_bean.getNucleo()+"\t");
							 error = true;
						}
					}
	            }
				if (error)
					str.append("\n\n");
				error = false;
				contTexto = 0;
			}
			if(lstValCuadros.contains("v03")){
				
				//ERROR DEL MPT -> (V_03) 
				for (int i = 0; i < lstemisario_nucleo.size(); i++)
	            {
					V_emisario_nucleo_bean emisario_nucleo_bean   = (V_emisario_nucleo_bean)lstemisario_nucleo.get(i);
					for (int j = 0; j < lstnucl_encuestado_5.size(); j++)
		            {
						V_nucl_encuestado_5_bean nucl_encuestado_5_bean   = (V_nucl_encuestado_5_bean)lstnucl_encuestado_5.get(j);
						if(nucl_encuestado_5_bean.getProvincia().equals(emisario_nucleo_bean.getProvincia()) && 
								nucl_encuestado_5_bean.getMunicipio().equals(emisario_nucleo_bean.getMunicipio()) && 
								nucl_encuestado_5_bean.getEntidad().equals(emisario_nucleo_bean.getEntidad()) &&
								nucl_encuestado_5_bean.getNucleo().equals(emisario_nucleo_bean.getNucleo())){
						
							if((nucl_encuestado_5_bean.getSyd_v_cone() + nucl_encuestado_5_bean.getSyd_v_ncon()) == 
								nucl_encuestado_5_bean.getSyd_v_defi()){
								if (contTexto == 0)
								 {
									 str.append(Messages.getString("errorMPT") + " " +Messages.getString("cuadro30.V_03") + "\n");
									 str.append("\n");
									 contTexto++;
								 }
								 str.append( emisario_nucleo_bean.getProvincia() + emisario_nucleo_bean.getMunicipio() + 
										 emisario_nucleo_bean.getEntidad()  + emisario_nucleo_bean.getNucleo()+"\t");
								 error = true;
							}
							
						}
					}
	            }
				if (error)
					str.append("\n\n");
				error = false;
				contTexto = 0;
			}
			if(lstValCuadros.contains("v04")){
				
				//ERROR DEL MPT -> (V_04) 
				for (int i = 0; i < lstemisario_nucleo.size(); i++)
	            {
					V_emisario_nucleo_bean emisario_nucleo_bean   = (V_emisario_nucleo_bean)lstemisario_nucleo.get(i);
					int count = 0;
					for (int j = 0; j < lstpadron.size(); j++)
		            {
						V_padron_bean padron_bean   = (V_padron_bean)lstpadron.get(j);
						if(padron_bean.getCodprov().equals(emisario_nucleo_bean.getProvincia()) && 
								padron_bean.getCodmunic().equals(emisario_nucleo_bean.getMunicipio()) && 
								padron_bean.getTotal_poblacion_a1() > 50000 ){
							count ++;
						}
						
		            }
					
					if(count != 0){//si existe en padron con mas de 50000h
						int count_emi50 = 0;
						int count_tramoemi50 = 0;
						for (int j = 0; j < lstemisario_enc_m50.size(); j++)
			            {
							V_emisario_enc_m50_bean emisario_enc_m50_bean   = (V_emisario_enc_m50_bean)lstemisario_enc_m50.get(j);
							if(emisario_enc_m50_bean.getProvincia().equals(emisario_nucleo_bean.getProvincia()) && 
									emisario_enc_m50_bean.getMunicipio().equals(emisario_nucleo_bean.getMunicipio()) && 
									emisario_enc_m50_bean.getOrden_emis().equals(emisario_nucleo_bean.getOrden_emis())){
								count_emi50 ++;
							}
			            }
							
						for (int j = 0; j < lsttramo_emisario_m50.size(); j++)
			            {
							V_tramo_emisario_m50_bean tramo_emisario_m50_bean   = (V_tramo_emisario_m50_bean)lsttramo_emisario_m50.get(j);
							if(tramo_emisario_m50_bean.getProvincia().equals(emisario_nucleo_bean.getProvincia()) && 
									tramo_emisario_m50_bean.getMunicipio().equals(emisario_nucleo_bean.getMunicipio()) && 
									tramo_emisario_m50_bean.getOrden_emis().equals(emisario_nucleo_bean.getOrden_emis())){
								count_tramoemi50 ++;
							}
			            }
						
						if(count_tramoemi50 == 0 || count_emi50 == 0){
	
							if (contTexto == 0)
							 {
								 str.append(Messages.getString("errorMPT") + " " +Messages.getString("cuadro30.V_04") + "\n");
								 str.append("\n");
								 contTexto++;
							 }
							 str.append( emisario_nucleo_bean.getProvincia() + emisario_nucleo_bean.getMunicipio() + 
									 emisario_nucleo_bean.getEntidad()  + emisario_nucleo_bean.getNucleo()+"\t");
	
						}
					}
	            }
			}
			str.append("\n\n");
	

        }
        catch (Exception e)
        {
        	str.append(Messages.getString("exception") + " " +Validacion_cuadro30.class + e.getMessage());
        	str.append("\n\n");
        }      	
        finally{
        	COperacionesEIEL.safeClose(rs, ps, null);
        }
	}
}
