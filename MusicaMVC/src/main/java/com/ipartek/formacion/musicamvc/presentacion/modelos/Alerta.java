package com.ipartek.formacion.musicamvc.presentacion.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alerta {
	private String mensaje;
	private String nivel;
}
