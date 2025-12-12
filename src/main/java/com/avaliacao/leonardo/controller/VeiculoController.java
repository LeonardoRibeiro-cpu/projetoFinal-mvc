package com.avaliacao.leonardo.controller;

import com.avaliacao.leonardo.model.Veiculo;
import com.avaliacao.leonardo.repository.UsuarioRepository;
import com.avaliacao.leonardo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("veiculos", veiculoRepository.findAll());
        return "veiculos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("veiculo", new Veiculo());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "veiculos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Veiculo veiculo) {
        veiculoRepository.save(veiculo);
        return "redirect:/veiculos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("veiculo", veiculoRepository.findById(id).orElse(null));
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "veiculos/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        veiculoRepository.deleteById(id);
        return "redirect:/veiculos";
    }
}
