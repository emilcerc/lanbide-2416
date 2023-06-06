package com.formacion.ipartek.multi.servicios;

/**
 * Servicio para exportar e importar información de la base de datos
 * @author javierlete
 * @version 1.0
 */
public interface ExportacionImportacionService {
	/**
	 * Exporta los usuarios de la base de datos en un CSV
	 * @param rutaFichero ruta completa del fichero al cuál se van a exportar los usuarios 
	 */
	void exportarUsuariosEnCsv(String rutaFichero);
	
	/**
	 * Importa los usuarios de un fichero CSV
	 * @param rutaFichero ruta completa del fichero del cuál se van a importar los usuarios
	 */
	void importarUsuariosDeCsv(String rutaFichero);
}
