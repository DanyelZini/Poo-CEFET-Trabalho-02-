package models;

import java.util.ArrayList;
import java.util.List;

public class Patio {
    private static Patio instance;
    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Vaga> vagas = new ArrayList<>();
    private List<Estacionamento> estacionamentos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    private Patio() {
    }

    public static Patio getInstance(List<Veiculo> veiculos, List<Vaga> vagas, List<Estacionamento> estacionamentos, List<Cliente> clientes) {
        if (instance == null)
            instance = new Patio();
        else
            throw new IllegalStateException("Patio já foi inicializado.");

        return instance;
    }

    public static Patio getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Patio ainda não foi inicializado.");
        }
        return instance;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    public List<Estacionamento> getEstacionamentos() {
        return estacionamentos;
    }

    public void setEstacionamentos(List<Estacionamento> estacionamentos) {
        this.estacionamentos = estacionamentos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    
}
