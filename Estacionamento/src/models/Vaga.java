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

    // =============================================
    // Definindo estado da vaga
    public void definirEstado(int n) {
        if(n < 1 || n > 3)
            return;
        
        switch (n) {
            case 1:
                this.estadoVaga = EstadoVaga.LIVRE;
                break;
            case 2:
                this.estadoVaga = EstadoVaga.OCUPADA;
                break;
            case 3:
                this.estadoVaga = EstadoVaga.INDISPONIVEL;
                break;
        }
    }

    // =============================================
    public boolean isLivre() {
        return this.estadoVaga == EstadoVaga.LIVRE;
    }
    

    // =============================================
    // Getters e Setters
    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Vaga.nextId = nextId;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoVaga getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVaga tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public EstadoVaga getEstadoVaga() {
        return estadoVaga;
    }

    public void setEstadoVaga(EstadoVaga estadoVaga) {
        this.estadoVaga = estadoVaga;
    }

    public Taxa getTaxa() {
        return taxa;
    }

    public void setTaxa(Taxa taxa) {
        this.taxa = taxa;
    }

    
}
