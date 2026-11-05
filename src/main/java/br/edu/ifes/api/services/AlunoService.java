package br.edu.ifes.api.services;

import br.edu.ifes.api.domains.Aluno;
import br.edu.ifes.api.repositories.AlunoRepository;
import br.edu.ifes.api.services.exceptions.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final CursoService cursoService;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Aluno", id));
    }

    public List<Aluno> listarPorCurso(Long cursoId) {
        cursoService.buscarPorId(cursoId);
        return alunoRepository.findByCursoId(cursoId);
    }
}
