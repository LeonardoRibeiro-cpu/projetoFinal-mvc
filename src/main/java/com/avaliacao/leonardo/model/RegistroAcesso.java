package com.avaliacao.leonardo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "acessos")
public class RegistroAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // veículo que entrou
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    // vaga utilizada
    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;

    private String status; // ABERTO / FINALIZADO

    public RegistroAcesso() {}

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }

    public Vaga getVaga() { return vaga; }
    public void setVaga(Vaga vaga) { this.vaga = vaga; }

    public LocalDateTime getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(LocalDateTime dataEntrada) { this.dataEntrada = dataEntrada; }

    public LocalDateTime getDataSaida() { return dataSaida; }
    public void setDataSaida(LocalDateTime dataSaida) { this.dataSaida = dataSaida; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
