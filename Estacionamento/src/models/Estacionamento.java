package models;

import javax.xml.crypto.Data;

public class Estacionamento {
    private static long nextId = 1;
    private Long id;
    private Data entrada;
    private Data saida;
    private Double valor;
    private Veiculo veiculo;
    private Vaga vaga;

    public Estacionamento(Data entrada, Data saida, Double valor, Veiculo veiculo, Vaga vaga) {
        this.id = nextId++;
        this.entrada = entrada;
        this.saida = saida;
        this.valor = valor;
        this.veiculo = veiculo;
        this.vaga = vaga;
    }

    // =============================================
    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        throw new UnsupportedOperationException("O id é gerado automaticamente e não pode ser alterado.");
    }

    public Data getEntrada() {
        return entrada;
    }

    public void setEntrada(Data entrada) {
        this.entrada = entrada;
    }

    public Data getSaida() {
        return saida;
    }

    public void setSaida(Data saida) {
        this.saida = saida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    
}
