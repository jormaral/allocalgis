package com.geopista.app.cementerios.business.dao.implementations;

import java.sql.SQLException;
import java.util.List;
import com.geopista.app.cementerios.business.dao.DAO;
import com.geopista.app.cementerios.business.dao.interfaces.InhumacionDAO;
import com.geopista.app.cementerios.business.vo.Inhumacion;
import com.geopista.app.cementerios.business.vo.InhumacionExample;


public class InhumacionDAOImpl extends DAO implements InhumacionDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.inhumacion
	 * @ibatorgenerated  Thu Jul 28 10:27:59 CEST 2011
	 */
	public InhumacionDAOImpl() {
		super();
	}


	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.inhumacion
	 * @throws SQLException 
	 * @ibatorgenerated  Thu Jul 28 10:27:59 CEST 2011
	 */
	public int deleteByExample(InhumacionExample example) throws SQLException {
		int rows = getSqlMapClientTemplate().delete(
				"cementerio_inhumacion.ibatorgenerated_deleteByExample",
				example);
		return rows;
	}


	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.inhumacion
	 * @ibatorgenerated  Thu Jul 28 10:27:59 CEST 2011
	 */
	public int deleteByPrimaryKey(Integer id) throws SQLException {
		Inhumacion key = new Inhumacion();
		key.setId(id);
		int rows = getSqlMapClientTemplate()
				.delete("cementerio_inhumacion.ibatorgenerated_deleteByPrimaryKey",
						key);
		return rows;
	}


	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.inhumacion
	 * @ibatorgenerated  Thu Jul 28 10:27:59 CEST 2011
	 */
	public Integer insert(Inhumacion record) throws SQLException {
		Object newKey = getSqlMapClientTemplate().insert(
				"cementerio_inhumacion.ibatorgenerated_insert", record);
		return (Integer) newKey;
	}


	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.inhumacion
	 * @ibatorgenerated  Thu Jul 28 10:27:59 CEST 2011
	 */
	public Integer insertSelective(Inhumacion record) throws SQLException {
		Object newKey = getSqlMapClientTemplate()
				.insert("cementerio_inhumacion.ibatorgenerated_insertSelective",
						record);
		return (Integer) newKey;
	}


	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.inhumacion
	 * @ibatorgenerated  Thu Jul 28 10:27:59 CEST 2011
	 */
	public List selectByExample(InhumacionExample example) throws SQLException {
		List list = getSqlMapClientTemplate().queryForList(
				"cementerio_inhumacion.ibatorgenerated_selectByExample",
				example);
		return list;
	}


	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.inhumacion
	 * @ibatorgenerated  Thu Jul 28 10:27:59 CEST 2011
	 */
	public Inhumacion selectByPrimaryKey(Integer id) throws SQLException {
		Inhumacion key = new Inhumacion();
		key.setId(id);
		Inhumacion record = (Inhumacion) getSqlMapClientTemplate()
				.queryForObject(
						"cementerio_inhumacion.ibatorgenerated_selectByPrimaryKey",
						key);
		return record;
	}


	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.inhumacion
	 * @ibatorgenerated  Thu Jul 28 10:27:59 CEST 2011
	 */
	public int updateByExampleSelective(Inhumacion record,
			InhumacionExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate()
				.update("cementerio_inhumacion.ibatorgenerated_updateByExampleSelective",
						parms);
		return rows;
	}


	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.inhumacion
	 * @ibatorgenerated  Thu Jul 28 10:27:59 CEST 2011
	 */
	public int updateByExample(Inhumacion record, InhumacionExample example) throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"cementerio_inhumacion.ibatorgenerated_updateByExample", parms);
		return rows;
	}


	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.inhumacion
	 * @ibatorgenerated  Thu Jul 28 10:27:59 CEST 2011
	 */
	public int updateByPrimaryKeySelective(Inhumacion record) throws SQLException {
		int rows = getSqlMapClientTemplate()
				.update("cementerio_inhumacion.ibatorgenerated_updateByPrimaryKeySelective",
						record);
		return rows;
	}


	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table cementerio.inhumacion
	 * @ibatorgenerated  Thu Jul 28 10:27:59 CEST 2011
	 */
	public int updateByPrimaryKey(Inhumacion record) throws SQLException {
		int rows = getSqlMapClientTemplate().update(
				"cementerio_inhumacion.ibatorgenerated_updateByPrimaryKey",
				record);
		return rows;
	}


	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table cementerio.inhumacion
	 * @ibatorgenerated  Thu Jul 28 10:27:59 CEST 2011
	 */
	private static class UpdateByExampleParms extends InhumacionExample {
		private Object record;

		public UpdateByExampleParms(Object record, InhumacionExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}


	public int selectByLastSeqKey() throws SQLException {
		Integer lastKey = (Integer) getSqlMapClientTemplate()
				.queryForObject(
						"cementerio_inhumacion.selectByLastSeqKey",
						null);
		return lastKey.intValue();
	}

	
	public List selectAll() throws SQLException {
	
		List list = getSqlMapClientTemplate().
		queryForList("cementerio_inhumacion.selectAll", null);
		return list;
		
	}
	
	
}