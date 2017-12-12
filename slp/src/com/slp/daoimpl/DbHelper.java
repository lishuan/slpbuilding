package com.slp.daoimpl;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.slp.entity.LogEntity;
import com.slp.entity.ReturnResultEntity;
import com.slp.entity.SqlCommandEntity;
import com.slp.toolutil.DateUtil;
import com.slp.toolutil.ToolUtil;

public class DbHelper {

	// [start]私有变量
	private BasicDataSource rds = getBasicRDataSource();
	private BasicDataSource wds = getBasicWDataSource();
	private String CONFIGNAME = "/config.properties";

	// [end]

	// [start]私有函数

	private Map<String, Object> setData(ResultSet rs) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Integer> metaDataMap = new HashMap<String, Integer>();
			ResultSetMetaData metaData = rs.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			for (int column = 0; column < numberOfColumns; column++) {
				String columnName = metaData.getColumnLabel(column + 1);
				int colunmType = metaData.getColumnType(column + 1);
				columnName = columnName.toLowerCase();
				metaDataMap.put(columnName, colunmType);
			}
			for (String columnName : metaDataMap.keySet()) {
				int columnType = metaDataMap.get(columnName);
				Object object = rs.getObject(columnName);
				if (object == null) {
					map.put(columnName, null);
					continue;
				}
				// 以下并为对所有的数据类型做处理，未特殊处理的数据类型将以object的形式存储。
				switch (columnType) {
				case java.sql.Types.VARCHAR:
					map.put(columnName, DateUtil.GetString(object));
					break;
				case java.sql.Types.INTEGER:
					map.put(columnName, DateUtil.GetInt(object));
					break;
				case java.sql.Types.DATE:
					map.put(columnName, DateUtil.GetStringFromDateTime(object));
					break;
				case java.sql.Types.TIMESTAMP:
					map.put(columnName, DateUtil.GetStringFromDateTime(object));
					break;
				case java.sql.Types.TIME:
					map.put(columnName, DateUtil.GetStringFromDateTime(object));
					break;
				case java.sql.Types.CLOB:
					try {
						if (object != null) {
							Clob clob = (Clob) object;
							long length = clob.length();
							map.put(columnName,
									clob.getSubString(1L, (int) length));
						}
					} catch (Exception e) {

					}
					break;
				case java.sql.Types.BLOB:
					map.put(columnName, "");
					break;
				default:
					map.put(columnName, object);
					break;
				}
			}
			return map;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return map;
		}
	}

	private BasicDataSource getBasicWDataSource() {
		if (wds == null) {
			wds = new BasicDataSource();
			if (ToolUtil.IsEmptyOrNull(CONFIGNAME)) {
				CONFIGNAME = "/config.properties";
			}
			try {
				Properties prop = new Properties();
				prop.load(this.getClass().getResourceAsStream(CONFIGNAME));
				// wds.setDriverClassName("com.mysql.jdbc.Driver");
				wds.setDriverClassName(prop.getProperty("DRIVER_CLASS"));
				wds.setUrl(prop.getProperty("CONNECTION_URL")
						+ "?useUnicode=true&characterEncoding=utf8&autoReconnect=true");
				wds.setUsername(prop.getProperty("CONNECTION_USERNAME"));
				wds.setPassword(prop.getProperty("CONNECTION_PASSWORD"));
				wds.setMaxActive(200);
				wds.setMaxWait(5000);
				wds.setMaxIdle(20);
				wds.setValidationQuery("select 1");
				wds.setTestOnBorrow(true);
			} catch (Exception ex) {

			}
		}
		return wds;
	}

	private BasicDataSource getBasicRDataSource() {
		if (rds == null) {
			rds = new BasicDataSource();
			if (ToolUtil.IsEmptyOrNull(CONFIGNAME)) {
				CONFIGNAME = "/config.properties";
			}
			try {
				Properties prop = new Properties();
				prop.load(this.getClass().getResourceAsStream(CONFIGNAME));
				rds = new BasicDataSource();
				rds.setDriverClassName(prop.getProperty("DRIVER_CLASS"));
				rds.setUrl(prop.getProperty("CONNECTION_URL")
						+ "?useUnicode=true&characterEncoding=utf8&autoReconnect=true");
				rds.setUsername(prop.getProperty("CONNECTION_USERNAME"));
				rds.setPassword(prop.getProperty("CONNECTION_PASSWORD"));
				rds.setMaxActive(200);
				rds.setMaxWait(5000);
				rds.setMaxIdle(20);
				rds.setValidationQuery("select 1");
				rds.setTestOnBorrow(true);
			} catch (Exception ex) {

			}
		}
		return rds;
	}

	private Connection GetReadConn() throws ClassNotFoundException,
			SQLException {
		if (null == rds) {
			rds = getBasicRDataSource();
		}
		java.sql.Connection conn = rds.getConnection();
		if (conn.isClosed()) {
			rds = null;
			rds = getBasicRDataSource();
			conn = rds.getConnection();
		}
		return (Connection) conn;
	}

	private Connection GetWriteConn() throws ClassNotFoundException,
			SQLException {
		if (null == wds) {
			wds = getBasicWDataSource();
		}
		java.sql.Connection conn = wds.getConnection();
		if (conn.isClosed()) {
			wds = null;
			wds = getBasicWDataSource();
			conn = wds.getConnection();
		}
		return (Connection) conn;
	}

	private void closeAll(Connection conn, PreparedStatement pStatement,
			ResultSet rSet) {
		/* 如果 rs 不空,关闭rs */
		if (rSet != null) {
			try {
				rSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/* 如果 pStatement 不空,关闭pStatement */
		if (pStatement != null) {
			try {
				pStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/* 如果 conn 不空,关闭conn */
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	private String GetString(String sql, List<Object> valueList) {
		String count = "";
		Connection conn = null;
		try {
			conn = GetReadConn(); // 得到数据库连接
			QueryRunner qRunner = new QueryRunner();
			if (valueList == null) {
				Object o = qRunner.query(conn, sql, new ScalarHandler(1));
				if (o != null) {
					count = o.toString();
				}
			} else {
				Object o = qRunner.query(conn, sql, valueList.toArray(),
						new ScalarHandler(1));
				if (o != null) {
					count = o.toString();
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return count;
	}

	private int GetInt(String sql, List<Object> valueList) {
		String count = GetString(sql, valueList);
		return DateUtil.GetInt(count);
	}

	// [end]

	// [start]公有函数
	public DbHelper() {
		if (null == rds) {
			rds = getBasicRDataSource();
		}
		if (null == wds) {
			wds = getBasicWDataSource();
		}
		if (ToolUtil.IsEmptyOrNull(CONFIGNAME)) {
			CONFIGNAME = "/config.properties";
		}
	}

	public ReturnResultEntity Execute(SqlCommandEntity cmd) {
		ReturnResultEntity item = new ReturnResultEntity();
		Connection conn = null;

		/* 处理SQL,执行SQL */
		try {
			conn = GetWriteConn(); // 得到数据库连接
			String sql = cmd.getSql();
			QueryRunner qRunner = new QueryRunner();
			int num = 0;
			if (cmd.getParams() == null) {
				num = qRunner.update(conn, sql);
			} else {
				num = qRunner.update(conn, sql, cmd.getParams().toArray());
			}
			return num > 0 ? item.getSuccessInfo("") : item
					.getFailureInfo("数据库操作失败");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			item.getFailureInfo(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			item.getFailureInfo(e.getMessage());
		} catch (Exception e) {
			item.getFailureInfo(e.getMessage());
		} finally {
			closeAll(conn, null, null);
		}
		return item;
	}

	public ReturnResultEntity Execute(List<SqlCommandEntity> list) {
		ReturnResultEntity item = new ReturnResultEntity();
		String sql = "";
		try {
			Connection conn = GetWriteConn(); // 得到数据库连接
			QueryRunner qRunner = new QueryRunner();

			/* 处理SQL,执行SQL */
			try {
				conn.setAutoCommit(false);
				int count = list.size();
				for (int i = 0; i < count; i++) {
					sql = list.get(i).getSql();
					if (list.get(i).getParams() == null) {
						qRunner.update(conn, sql);
					} else {
						qRunner.update(conn, sql, list.get(i).getParams()
								.toArray());
					}
				}
				conn.commit();
				conn.setAutoCommit(true);
				DbUtils.close(conn);
				item.getSuccessInfo("");

			} catch (Exception e) {
				conn.rollback();
				DbUtils.close(conn);
				item.getFailureInfo(e.getMessage() + sql);
			}
		} catch (Exception ex) {
			item.getFailureInfo(ex.getMessage());
		}
		return item;
	}

	public <T> List<T> Query(SqlCommandEntity cmd, Class<?> t) {
		return Query(cmd.getSql(), cmd.getParams(), t);
	}

	public List<Map<String, Object>> Query(SqlCommandEntity cmd) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement pStatement = null;
		ResultSet rset = null;

		/* 处理SQL,执行SQL */
		try {
			conn = GetReadConn(); // 得到数据库连接
			pStatement = conn.prepareStatement(cmd.getSql());
			if (null != cmd.getParams()) {
				int vcount = cmd.getParams().size();

				if (cmd.getParams() != null && vcount > 0) {
					for (int i = 0; i < vcount; i++) {
						Object obj = cmd.getParams().get(i);
						// setParameterValue(pStatement, i + 1, obj);
						pStatement.setObject(i + 1, obj);
					}
				}
			}
			rset = pStatement.executeQuery();
			while (rset.next()) {
				Map<String, Object> m = this.setData(rset);
				if (m != null) {
					result.add(m);
				}

			}
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pStatement, rset);
			// System.out.println(sql);
		}
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	private <T> List<T> Query(String sql, List<Object> valueList, Class t) {
		List<T> result = new ArrayList<T>();
		Connection conn = null;

		/* 处理SQL,执行SQL */
		try {
			conn = GetReadConn(); // 得到数据库连接
			QueryRunner qRunner = new QueryRunner();
			if (valueList == null) {
				result = (List<T>) qRunner.query(conn, sql,
						new BeanListHandler(t));
			} else {
				result = (List<T>) qRunner.query(conn, sql,
						valueList.toArray(), new BeanListHandler(t));
			}
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, null, null);
		}
		return result;

	}

	public int GetInt(SqlCommandEntity cmd) {
		String sql = cmd.getSql();
		List<Object> valueList = cmd.getParams();
		return GetInt(sql, valueList);
	}

	public String GetString(SqlCommandEntity cmd) {
		String sql = cmd.getSql();
		List<Object> valueList = cmd.getParams();
		return GetString(sql, valueList);
	}

	public String GetString(String sql) {
		return GetString(sql, null);
	}

	// [end]
	//其他函数
	/**
	 * @Description:增加管理员日志
	 * @Author: 李栓
	 * @Version: V1.00
	 * @Create Date: 2017年4月2日 下午10:17:43
	 * @Parameters:
	 */
	public SqlCommandEntity AddAdminLog(LogEntity log) {
		List<Object> v = new ArrayList<Object>();
		String sql = "";
		sql += "insert into log(";
		sql += "id,adminname,addtime,remark,status";
		sql += ") values (";
		sql += "?,?,now(),?,?";
		sql += ")";
		v.add(log.getId());
		v.add(log.getAdminname());
		v.add(log.getRemark());
		v.add(log.getStatus());
		SqlCommandEntity cmd = new SqlCommandEntity(sql, v);
		return cmd;
	}

}
