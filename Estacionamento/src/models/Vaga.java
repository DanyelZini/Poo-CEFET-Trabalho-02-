package models;

import enums.EstadoVaga;
import enums.TipoVaga;

public class Vaga {
    private Integer numero;
    private TipoVaga tipoVeiculo;
    private EstadoVaga estadoVaga;
    private Taxa taxa;

    public Vaga(Integer numero, TipoVaga tipoVeiculo, EstadoVaga estadoVaga, Taxa taxa) {
        this.numero = numero;
        this.tipoVeiculo = tipoVeiculo;
        this.estadoVaga = estadoVaga;
        this.taxa = taxa;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoVaga getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVaga tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public EstadoVaga isEstadoVaga() {
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
