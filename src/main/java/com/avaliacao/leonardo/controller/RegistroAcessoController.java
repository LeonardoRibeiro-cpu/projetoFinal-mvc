package com.avaliacao.leonardo.controller;

import com.avaliacao.leonardo.model.RegistroAcesso;
import com.avaliacao.leonardo.model.Vaga;
import com.avaliacao.leonardo.repository.RegistroAcessoRepository;
import com.avaliacao.leonardo.repository.VagaRepository;
import com.avaliacao.leonardo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;//tteste commit
                    
@Controller
@RequestMapping("/acessos")
public class RegistroAcessoController {

    @Autowired
    private RegistroAcessoRepository acessoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VagaRepository vagaRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("acessos", acessoRepository.findAll());
        return "acessos/lista";
    }

    @GetMapping("/entrada")
    public String registrarEntrada(Model model) {
        model.addAttribute("acesso", new RegistroAcesso());
        model.addAttribute("veiculos", veiculoRepository.findAll());
        model.addAttribute("vagas", vagaRepository.findByStatus("DISPONIVEL"));
        return "acessos/form_entrada";
    }

    @PostMapping("/salvarEntrada")
    public String salvarEntrada(@ModelAttribute RegistroAcesso ac) {
        ac.setDataEntrada(LocalDateTime.now());
        ac.setStatus("ABERTO");

        // Ocupa vaga
        Vaga v = ac.getVaga();
        v.setStatus("OCUPADA");
        vagaRepository.save(v);

        acessoRepository.save(ac);
        return "redirect:/acessos";
    }

    @GetMapping("/saida/{id}")
    public String registrarSaida(@PathVariable Long id) {
        RegistroAcesso ac = acessoRepository.findById(id).orElse(null);
        if (ac != null && ac.getStatus().equals("ABERTO")) {
            ac.setDataSaida(LocalDateTime.now());
            ac.setStatus("FINALIZADO");

            // libera vaga
            Vaga vaga = ac.getVaga();
            vaga.setStatus("DISPONIVEL");
            vagaRepository.save(vaga);

            acessoRepository.save(ac);
        }
        return "redirect:/acessos";
    }
}
