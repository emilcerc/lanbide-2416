package com.formacion.ipartek.multi.servicios;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Log
@Service
public class ExportacionImportacionServiceImpl implements ExportacionImportacionService {
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public void exportarUsuariosEnCsv(String rutaFichero) {
		try (FileWriter fw = new FileWriter(rutaFichero);
				PrintWriter pw = new PrintWriter(fw)) {
			
			pw.println("id;email;password;nombre");
			
			jdbc.query("SELECT * FROM usuarios", (rs, rowNum) -> {
				pw.printf("%s;%s;%s;%s\n", rs.getLong("id"),
						rs.getString("email"), rs.getString("password"), rs.getString("nombre"));
				return null;
			});
		} catch (DataAccessException | IOException e) {
			ServiciosException ex = new ServiciosException("No se ha podido exportar el fichero", e);
			log.log(Level.WARNING, "Fallo al exportar el fichero", ex);
			throw ex;
		}
	}

	@Override
	public void importarUsuariosDeCsv(String rutaFichero) {
		try (FileReader fr = new FileReader(rutaFichero);
				Scanner sc = new Scanner(fr)) {
			String linea;
			String[] datos;
			
			sc.nextLine();
			
			while(sc.hasNext()) {
				linea = sc.nextLine();
				datos = linea.split(";");
				
				jdbc.update("INSERT INTO usuarios (email, password, nombre) VALUES (?,?,?)",
						datos[1], datos[2], datos[3]);
			}
		} catch (DataAccessException | IOException e) {
			ServiciosException ex = new ServiciosException("No se ha podido importar el fichero", e);
			log.log(Level.WARNING, "Fallo al importar el fichero", ex);
			throw ex;
		}
	}

}
