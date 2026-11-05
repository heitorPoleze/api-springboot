package br.edu.ifes.api.repositories;

import br.edu.ifes.api.domains.Aluno;
import br.edu.ifes.api.domains.Curso;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlunoRepository {

    private final List<Aluno> alunos;

    public AlunoRepository(CursoRepository cursoRepository) {
        Curso sistemas = buscarCurso(cursoRepository, 1L);
        Curso automacao = buscarCurso(cursoRepository, 2L);
        Curso informatica = buscarCurso(cursoRepository, 3L);

        this.alunos = List.of(
                new Aluno(1L, "Ana Souza", "2024001", sistemas),
                new Aluno(2L, "Bruno Lima", "2024002", sistemas),
                new Aluno(3L, "Carla Mendes", "2024003", automacao),
                new Aluno(4L, "Diego Rocha", "2024004", informatica)
        );
    }

    public List<Aluno> findAll() {
        return alunos;
    }

    public Optional<Aluno> findById(Long id) {
        return alunos.stream()
                .filter(aluno -> aluno.getId().equals(id))
                .findFirst();
    }

    public List<Aluno> findByCursoId(Long cursoId) {
        return alunos.stream()
                .filter(aluno -> aluno.getCurso().getId().equals(cursoId))
                .toList();
    }

    private static Curso buscarCurso(CursoRepository cursoRepository, Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Curso mockado não encontrado: " + id));
    }
}
