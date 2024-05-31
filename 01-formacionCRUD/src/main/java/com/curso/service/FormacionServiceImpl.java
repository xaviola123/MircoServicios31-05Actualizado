package com.curso.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.CursoAuxiliar;
import com.curso.model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String CURSOS_URL = "http://localhost:8080/cursos";

    @Override
    public List<Formacion> listaCursos() {
        Formacion[] cursos = restTemplate.getForObject(CURSOS_URL, Formacion[].class);
        if (cursos != null) {
            for (Formacion curso : cursos) {
                if (curso.getDuracion() >= 50) {
                    curso.setAsignaturas(10);
                } else {
                    curso.setAsignaturas(5);
                }
            }
        }
        return Arrays.asList(cursos);
    }

    @Override
    public void altaCurso(Formacion formacion) {
        List<Formacion> cursosExistentes = listaCursos();
        boolean cursoExistente = false;

        if (formacion.getCurso() != null) {
            for (Formacion curso : cursosExistentes) {
                if (curso.getCurso() != null && curso.getCurso().equals(formacion.getCurso())) {
                    cursoExistente = true;
                    break;
                }
            }
        }
        
        if (!cursoExistente) {
            CursoAuxiliar cursoAux = new CursoAuxiliar();
            cursoAux.setNombre(formacion.getCurso());
            cursoAux.setDuracion(formacion.getAsignaturas() * 10);
            cursoAux.setPrecio(formacion.getPrecio());

            restTemplate.postForLocation(CURSOS_URL, cursoAux);
        }
    }
}
