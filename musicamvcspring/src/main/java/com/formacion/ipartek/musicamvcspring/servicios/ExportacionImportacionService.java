package com.formacion.ipartek.musicamvcspring.servicios;

public interface ExportacionImportacionService {
	void exportarUsuariosEnCsv(String rutaFichero);
	void importarUsuariosDeCsv(String rutaFichero);
}
