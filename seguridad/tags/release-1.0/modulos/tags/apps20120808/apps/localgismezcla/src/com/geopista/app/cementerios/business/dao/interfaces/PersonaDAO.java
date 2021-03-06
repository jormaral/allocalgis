package com.geopista.app.cementerios.business.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.geopista.app.cementerios.business.vo.Persona;
import com.geopista.app.cementerios.business.vo.PersonaExample;

public interface PersonaDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.persona
	 * @throws SQLException 
	 * @ibatorgenerated  Mon Jun 06 12:49:46 CEST 2011
	 */
	int deleteByPrimaryKey(String dni) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.persona
	 * @ibatorgenerated  Mon Jun 06 12:49:46 CEST 2011
	 */
	void insert(Persona record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.persona
	 * @ibatorgenerated  Mon Jun 06 12:49:46 CEST 2011
	 */
	void insertSelective(Persona record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.persona
	 * @ibatorgenerated  Mon Jun 06 12:49:46 CEST 2011
	 */
	List selectByExample(PersonaExample example) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.persona
	 * @ibatorgenerated  Mon Jun 06 12:49:46 CEST 2011
	 */
	Persona selectByPrimaryKey(String dni) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.persona
	 * @ibatorgenerated  Mon Jun 06 12:49:46 CEST 2011
	 */
	int updateByPrimaryKeySelective(Persona record) throws SQLException;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.persona
	 * @ibatorgenerated  Mon Jun 06 12:49:46 CEST 2011
	 */
	int updateByPrimaryKey(Persona record) throws SQLException;

//	/**
//	 * Set the iBATIS Database Layer SqlMapClient to work with.
//	 * @param sqlMapper
//	 */
//	void setSqlMapClient(SqlMapClient sqlMapper)throws SQLException;


}