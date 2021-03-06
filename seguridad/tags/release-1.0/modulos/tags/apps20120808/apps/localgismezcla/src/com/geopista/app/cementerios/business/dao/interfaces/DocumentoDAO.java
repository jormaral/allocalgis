package com.geopista.app.cementerios.business.dao.interfaces;

import java.sql.SQLException;

import com.geopista.app.cementerios.business.vo.Documento;
import com.geopista.app.cementerios.business.vo.DocumentoExample;
import java.util.List;
import java.util.Map;

public interface DocumentoDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.documento
	 * @throws SQLException 
	 * @ibatorgenerated  Tue Jun 07 11:18:50 CEST 2011
	 */
	int deleteByPrimaryKey(Integer idDocumento) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.documento
	 * @ibatorgenerated  Tue Jun 07 11:18:50 CEST 2011
	 */
	Integer insert(Documento record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.documento
	 * @ibatorgenerated  Tue Jun 07 11:18:50 CEST 2011
	 */
	Integer insertSelective(Documento record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.documento
	 * @ibatorgenerated  Tue Jun 07 11:18:50 CEST 2011
	 */
	List selectByExampleWithBLOBs(DocumentoExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.documento
	 * @ibatorgenerated  Tue Jun 07 11:18:50 CEST 2011
	 */
	List selectByExampleWithoutBLOBs(DocumentoExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.documento
	 * @ibatorgenerated  Tue Jun 07 11:18:50 CEST 2011
	 */
	Documento selectByPrimaryKey(Integer idDocumento) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.documento
	 * @ibatorgenerated  Tue Jun 07 11:18:50 CEST 2011
	 */
	int updateByPrimaryKeySelective(Documento record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.documento
	 * @ibatorgenerated  Tue Jun 07 11:18:50 CEST 2011
	 */
	int updateByPrimaryKeyWithBLOBs(Documento record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.documento
	 * @ibatorgenerated  Tue Jun 07 11:18:50 CEST 2011
	 */
	int updateByPrimaryKeyWithoutBLOBs(Documento record) throws SQLException;

	List selectAll() throws SQLException;
	
	List selectAttached(Map map) throws SQLException;
	
	List selectAttachedCementerio (Integer idElemCementerio, String superpatron, String patron) throws SQLException;
	
	int selectByLastSeqKey() throws SQLException;
	
	
}