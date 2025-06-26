package models;

import enums.TipoVaga;

public class Taxa {
    private TipoVaga tipoVeiculo;
    private Double valorHora;

    public Taxa(TipoVaga tipoVeiculo, Double valorHora) {
        this.tipoVeiculo = tipoVeiculo;
        this.valorHora = valorHora;
    }

    public TipoVaga getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVaga tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return "Taxa{" +
                "tipoVeiculo=" + tipoVeiculo +
                ", valorHora=" + valorHora +
                '}';
    }
}
