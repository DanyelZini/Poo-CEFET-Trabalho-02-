package controller;

import java.util.ArrayList;
import java.util.List;

import models.Cliente;
import models.Estacionamento;
import models.Vaga;
import models.Veiculo;

public class Patio {
    private static Patio instance;
    private Veiculo v = new Veiculo();
    private List<Vaga> vagas = new ArrayList<>();
    private List<Estacionamento> estacionamentos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public Patio() {
        
    }

    public static Patio getInstance(List<Veiculo> veiculos, List<Vaga> vagas, List<Estacionamento> estacionamentos, List<Cliente> clientes) {
        if (instance == null) {
            instance = new Patio();
        } else {
            throw new IllegalStateException("Patio já foi inicializado.");
        }
        return instance;
    }

    public void printVeiculos(){
        System.out.println(v.getAllVeiculos());
    }

    public static Patio getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Patio ainda não foi inicializado.");
        }
        return instance;
    }
}
