package com.avaliacao.leonardo.controller;

import com.avaliacao.leonardo.model.Vaga;
import com.avaliacao.leonardo.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaRepository vagaRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vagas", vagaRepository.findAll());
        return "vagas/lista";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("vaga", new Vaga());
        return "vagas/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Vaga vaga) {
        if (vaga.getStatus() == null || vaga.getStatus().isBlank()) {
            vaga.setStatus("DISPONIVEL");
        }
        vagaRepository.save(vaga);
        return "redirect:/vagas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("vaga", vagaRepository.findById(id).orElse(null));
        return "vagas/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        vagaRepository.deleteById(id);
        return "redirect:/vagas";
    }

    // RF05 — Desalocar vaga
    @GetMapping("/desalocar/{id}")
    public String desalocar(@PathVariable Long id) {
        Vaga vaga = vagaRepository.findById(id).orElse(null);
        if (vaga != null) {
            vaga.setStatus("DISPONIVEL");
            vagaRepository.save(vaga);
        }
        return "redirect:/vagas";
    }
}
