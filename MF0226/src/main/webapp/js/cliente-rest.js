'use strict';

const URL_PRODUCTOS = 'http://localhost:8080/mf0226/api/v1/productos/';

window.addEventListener('DOMContentLoaded', cargado);

async function cargado() {
	const respuesta = await fetch(URL_PRODUCTOS);
	const productos = await respuesta.json();
	const tbody = document.querySelector('tbody');
	
	// console.log(productos);
	
	tbody.innerHTML = '';
	
	for(const producto of productos) {
		console.log(producto);
		
		const tr = document.createElement('tr');
		
		const garantia = producto.garantia ? producto.garantia[2] + '/' + producto.garantia[1] + '/' + producto.garantia[0] : 'NO DEFINIDA';
		
		tr.innerHTML = `
			<td>${producto.id}</td>
			<td>${producto.nombre}</td>
			<td>${producto.precio}</td>
			<td>${garantia}</td>
			<td><a href="#">Editar</a> <a href="#">Borrar</a></td>`;
		
		tbody.appendChild(tr);
	}
}
