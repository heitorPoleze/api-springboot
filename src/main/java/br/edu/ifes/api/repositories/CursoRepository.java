package br.edu.ifes.api.repositories;

import br.edu.ifes.api.domains.Curso;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CursoRepository {

    private final List<Curso> cursos = List.of(
            new Curso(1L, "Sistemas de Informação", 3200),
            new Curso(2L, "Engenharia de Controle e Automação", 3600),
            new Curso(3L, "Técnico em Informática", 1200)
    );

    public List<Curso> findAll() {
        return cursos;
    }

    public Optional<Curso> findById(Long id) {
        return cursos.stream()
                .filter(curso -> curso.getId().equals(id))
                .findFirst();
    }
}
