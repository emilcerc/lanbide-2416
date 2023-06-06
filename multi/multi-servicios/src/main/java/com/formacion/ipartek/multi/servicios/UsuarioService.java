package com.formacion.ipartek.multi.servicios;

import com.formacion.ipartek.multi.entidades.Cancion;
import com.formacion.ipartek.multi.entidades.Estilo;
import com.formacion.ipartek.multi.entidades.Grupo;
import com.formacion.ipartek.multi.entidades.Usuario;

/**
 * <p>Funcionalidades que se le permiten hacer a todos los usuarios
 * una vez <strong>logueados</strong></p>
 * <p>
 * Cuando se cree una clase que implemente este interface, incluirá 
 * el Usuario que está en sesión.
 * </p>
 * @author javierlete
 * @version 1.0
 */
public interface UsuarioService {
	/**
	 * <p>Agrega la canción y devuelve la canción con el id rellenado</p>
	 * <p>La canción se agregará con el usuario de la instancia del Usuario logueado</p>
	 * @param cancion la canción a guardar (se ignora su id)
	 * @return canción con id rellenado
	 */
	Cancion agregarCancion(Cancion cancion);
	
	/**
	 * <p>Modifica la canción según el id incluído.</p>
	 * <p>Sólo permite que el usuario modifique sus canciones</p>
	 * @param cancion canción a modificar
	 * @return la misma canción
	 */
	Cancion modificarCancion(Cancion cancion);
	
	/**
	 * <p>Elimina la canción de la base de datos</p>
	 * <p>Cada usuario sólo puede eliminar sus propias canciones</p>
	 * @param id id de la canción a eliminar
	 */
	void borrarCancion(Long id);
	
	/**
	 * Se devuelven las canciones correspondientes al usuario
	 * @return las canciones del usuario
	 */
	Iterable<Cancion> obtenerSusCanciones();
	
	/**
	 * Devuelve la canción de dicho id en el caso de que sea del usuario
	 * @param id id de la canción
	 * @return devuelve la canción y si no existe devuelve <code>null</code>
	 */
	Cancion obtenerPorId(Long id);
	
	/**
	 * Buscar canciones por parte del nombre
	 * @param nombre parte del nombre a buscar
	 * @return canciones que concuerdan con el nombre recibido
	 */
	Iterable<Cancion> buscarCancionesPorNombre(String nombre);
	
	/**
	 * Busca canciones por estilo
	 * @param estilo nombre del estilo a buscar
	 * @return canciones del estilo especificado
	 */
	Iterable<Cancion> buscarCancionesPorEstilo(String estilo);
	
	/**
	 * Buscar canciones por grupo
	 * @param grupo el grupo a buscar
	 * @return canciones del grupo
	 */
	Iterable<Cancion> buscarCancionesPorGrupo(String grupo);
	
	/**
	 * Usuario para el cuál se van a hacer el resto de las operaciones
	 * @param usuario el usuario logueado
	 */
	void setUsuario(Usuario usuario);
	
	/**
	 * Obtener usuario
	 * @return usuario sobre el cuál se hacen todas las operaciones
	 */
	Usuario getUsuario();
	
	/**
	 * Obtener todos los estilos
	 * @return los estilos
	 */
	Iterable<Estilo> obtenerEstilos();
	
	/**
	 * Obtener todos los grupos
	 * @return los grupos
	 */
	Iterable<Grupo> obtenerGrupos();
}
