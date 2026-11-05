package br.edu.ifes.api.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Curso {

    private final Long id;
    private final String nome;
    private final Integer cargaHoraria;
}
