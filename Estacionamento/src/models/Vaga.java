package models;

import enums.EstadoVaga;
import enums.TipoVaga;

public class Vaga {
    private static int nextId = 1; 
    private int numero;
    private TipoVaga tipoVeiculo;
    private EstadoVaga estadoVaga;
    private Taxa taxa;

    public Vaga(TipoVaga tipoVeiculo, EstadoVaga estadoVaga, Taxa taxa) {
        this.numero = Vaga.nextId++;
        this.tipoVeiculo = tipoVeiculo;
        this.estadoVaga = estadoVaga;
        this.taxa = taxa;
    }

    @Override
    public String toString() {
        return "\n" +
                "Vaga {" +
                "numero= " + numero +
                ", tipoVeiculo= '" + tipoVeiculo + '\'' +
                ", estadoVaga= '" + estadoVaga + '\'' +
                ", taxa= '" + (taxa != null ? taxa.getValorHora() : "null") +
                "' }";
    }

    
}
