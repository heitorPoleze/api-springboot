package br.edu.ifes.api.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Aluno {

    private final Long id;
    private final String nome;
    private final String matricula;
    private final Curso curso;
}
