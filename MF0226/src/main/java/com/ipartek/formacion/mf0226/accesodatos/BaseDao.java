package com.ipartek.formacion.mf0226.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

class BaseDao {
	static final String BDD_URL = "jdbc:mysql://localhost:3306/mf0226";
	static final String BDD_USER = "mf0226_user";
	static final String BDD_PASS = "user";
	static final String BDD_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	static {
		try {
			Class.forName(BDD_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha podido cargar el driver", e);
		}
	}

	static Connection getConexion() {
		try {
			Connection con = DriverManager.getConnection(BDD_URL, BDD_USER, BDD_PASS);
			return con;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}
	
	static LocalDate dateToLocalDate(java.sql.Date date) throws SQLException {
		LocalDate localDate = null;
		
		if(date != null) {
			localDate = date.toLocalDate();
		}
		
		return localDate;
	}
}
