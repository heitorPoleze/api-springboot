package br.edu.ifes.api.controllers;

import br.edu.ifes.api.domains.Aluno;
import br.edu.ifes.api.domains.Curso;
import br.edu.ifes.api.services.AlunoService;
import br.edu.ifes.api.services.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;
    private final AlunoService alunoService;

    @GetMapping
    public List<Curso> listarTodos() {
        return cursoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorId(id);
    }

    @GetMapping("/{id}/alunos")
    public List<Aluno> listarAlunos(@PathVariable Long id) {
        return alunoService.listarPorCurso(id);
    }
}
