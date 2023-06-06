package com.formacion.ipartek.musicamvcspring.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formacion.ipartek.musicamvcspring.servicios.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final int TAMANYO_PAGINA = 2;
	
	@Autowired
	private AdminService servicio;
	
	@GetMapping
	public String index(Model modelo, Pageable pageable) {
		System.out.println(pageable);

		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), TAMANYO_PAGINA, pageable.getSort());

		Sort.Order order = pageRequest.getSort().get().findFirst().orElse(null);
		
		String ordenacion = "id,ASC";
		
		if(order != null) {
			ordenacion = order.getProperty() + "," + (order.isAscending() ? "ASC" : "DESC");
		}
		
		modelo.addAttribute("ordenacion", ordenacion);
		modelo.addAttribute("paginacion", pageRequest);
		modelo.addAttribute("totalPaginas", servicio.getNumeroCanciones() / TAMANYO_PAGINA);
		modelo.addAttribute("canciones", servicio.obtenerPagina(pageRequest));
		
		return "admin/canciones";
	}
}
