package com.avaliacao.leonardo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vagas")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private String status; // DISPONIVEL / OCUPADA

    public Vaga() {}

    public Vaga(String numero, String status) {
        this.numero = numero;
        this.status = status;
    }

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
