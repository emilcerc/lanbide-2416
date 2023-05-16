'use strict';

const URL_PRODUCTOS = 'http://localhost:8080/mf0226/api/v1/productos/';

let tbody;
let inputId, inputNombre, inputPrecio, inputGarantia;

window.addEventListener('DOMContentLoaded', cargado);

async function cargado() {
	tbody = document.querySelector('tbody');
	const form = document.querySelector('form');

	inputId = document.querySelector('#id');
	inputNombre = document.querySelector('#nombre');
	inputPrecio = document.querySelector('#precio');
	inputGarantia = document.querySelector('#garantia');

	form.addEventListener('submit', guardar);

	await actualizarTabla();
}

async function actualizarTabla() {
	const respuesta = await fetch(URL_PRODUCTOS);
	const productos = await respuesta.json();
	// console.log(productos);
	tbody.innerHTML = '';

	for (const producto of productos) {
		console.log(producto);

		const tr = document.createElement('tr');

		const garantia = producto.garantia ? producto.garantia[2] + '/' + producto.garantia[1] + '/' + producto.garantia[0] : 'NO DEFINIDA';

		tr.innerHTML = `
			<td>${producto.id}</td>
			<td>${producto.nombre}</td>
			<td>${producto.precio}</td>
			<td>${garantia}</td>
			<td><a href="javascript:editar(${producto.id})">Editar</a> <a href="javascript:borrar(${producto.id})">Borrar</a></td>`;

		tbody.appendChild(tr);
	}
}

async function guardar(e) {
	e.preventDefault();

	const producto = { nombre: inputNombre.value, precio: inputPrecio.value, garantia: inputGarantia.value };
	
	console.log('PRODUCTO', producto);
	
	const respuesta = await fetch(URL_PRODUCTOS, {
		method: 'POST',
		body: JSON.stringify(producto)
	});
	
	console.log(respuesta);
	
	actualizarTabla();
	
	const productoRecibido = await respuesta.json();
	
	console.log('PRODUCTO_RECIBIDO', productoRecibido);
}

function editar(id) {
	
}

async function borrar(id) {
	const respuesta = await fetch(URL_PRODUCTOS + id, { method: 'DELETE' });
	
	console.log(respuesta);
	
	actualizarTabla();
}
