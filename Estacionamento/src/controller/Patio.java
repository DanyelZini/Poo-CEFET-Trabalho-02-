package controller;

import java.util.ArrayList;
import java.util.List;

import enums.EstadoVaga;
import enums.TipoVaga;
import models.Cliente;
import models.Estacionamento;
import models.Taxa;
import models.Vaga;
import models.Veiculo;

public class Patio {
    private static Patio instance;
    private List<Taxa> taxa;
    private List<Vaga> vagas;
    private List<Estacionamento> estacionamentos;
    private Veiculo v;
    private Cliente c;

    private Patio() {
        this.init();
    }

    public static Patio getInstance() {
        if (instance == null) {
            instance = new Patio();
        }
        return instance;
    }

    private void init() {
        vagas = new ArrayList<>();
        estacionamentos = new ArrayList<>();
        taxa = new ArrayList<>();
        taxa.add(new Taxa(TipoVaga.AUTOMOVEL, 5.0));
        taxa.add(new Taxa(TipoVaga.MOTO, 3.0));
        taxa.add(new Taxa(TipoVaga.UTILITARIO, 8.0));
        v = new Veiculo();
        c = new Cliente();

        for (int i = 1; i <= 10; i++) {
            vagas.add(new Vaga(TipoVaga.AUTOMOVEL, EstadoVaga.LIVRE, this.buscarTaxa(TipoVaga.AUTOMOVEL)));
        }
        for (int i = 1; i <= 5; i++) {
            vagas.add(new Vaga(TipoVaga.MOTO, EstadoVaga.LIVRE, this.buscarTaxa(TipoVaga.MOTO)));
        }
        for (int i = 1; i <= 5; i++) {
            vagas.add(new Vaga(TipoVaga.UTILITARIO, EstadoVaga.LIVRE, this.buscarTaxa(TipoVaga.UTILITARIO)));
        }

        new Cliente("Danyel", "82734012863");
        new Cliente("Carlos", "12345678909");
        new Cliente("Mariana", "98765432100");
        new Cliente("Fernanda", "23456789092");
        new Cliente("Lucas", "34567890175");
        new Cliente("Ana", "45678901249");

        new Veiculo("ABC1E34", "Civic", "Preto", "Honda", TipoVaga.AUTOMOVEL, c.getCliente("82734012863"));          
        new Veiculo("XYZ5T78", "Corolla", "Branco", "Toyota", TipoVaga.AUTOMOVEL, c.getCliente("82734012863"));
        new Veiculo("DEF4C21", "Onix", "Prata", "Chevrolet", TipoVaga.AUTOMOVEL,  c.getCliente("12345678909"));
        new Veiculo("GHI8D65", "HB20", "Azul", "Hyundai", TipoVaga.AUTOMOVEL,  c.getCliente("12345678909"));
        new Veiculo("JKL2F98", "Fiesta", "Vermelho", "Ford", TipoVaga.AUTOMOVEL, c.getCliente("98765432100"));
        new Veiculo("MNO7H32", "Uno", "Branco", "Fiat", TipoVaga.AUTOMOVEL, c.getCliente("23456789092"));
        new Veiculo("PQR3J21", "Gol", "Preto", "Volkswagen", TipoVaga.AUTOMOVEL, c.getCliente("34567890175"));
        new Veiculo("STU6L54", "Sandero", "Prata", "Renault", TipoVaga.AUTOMOVEL, c.getCliente("45678901249"));
        new Veiculo("VWX9M87", "Celta", "Verde", "Chevrolet", TipoVaga.AUTOMOVEL, c.getCliente("98765432100"));
        new Veiculo("YZA5N43", "Ka", "Azul", "Ford", TipoVaga.AUTOMOVEL, c.getCliente("23456789092"));
    }

    public Taxa buscarTaxa(TipoVaga tipoVaga) {
        for (Taxa t : taxa) {
            if (t.getTipoVeiculo() == tipoVaga) {
                return t;
            }
        }
        return null;
    }

    public Boolean alterarTaxa(TipoVaga tipoVaga, Double novaTaxa) {
        for (Taxa t : taxa) {
            if (t.getTipoVeiculo() == tipoVaga) {
                t.setValorHora(novaTaxa);
                return true;
            }
        }
        return false;
    }

}
