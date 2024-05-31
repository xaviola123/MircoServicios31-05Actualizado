
package com.curso.service;

import java.util.List;

import com.curso.model.Formacion;

public interface FormacionService {
	
	
	void altaCurso(Formacion formacion);
	List<Formacion> listaCursos();
}
