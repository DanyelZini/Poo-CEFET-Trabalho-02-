package models;

import enums.TipoVaga;

public class Veiculo {
    private static long nextCodigo = 1;
    private Long codigo;
    private String placa;
    private String modelo;
    private String cor;
    private String marca;
    private TipoVaga tipoVeiculo;
    private Cliente cliente;

    public Veiculo(String placa, String modelo, String cor, String marca, TipoVaga tipoVeiculo, Cliente cliente) {
        this.codigo = nextCodigo++;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.tipoVeiculo = tipoVeiculo;
        this.cliente = cliente;
    }

    public Veiculo(Long codigo, String placa, String modelo, String cor, String marca, TipoVaga tipoVeiculo, Cliente cliente) {
        this.codigo = codigo;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.tipoVeiculo = tipoVeiculo;
        this.cliente = cliente;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        throw new UnsupportedOperationException("O código é gerado automaticamente e não pode ser alterado.");
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoVaga getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVaga tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // toString
    public String toString() {
        return "Veiculo{" +
                "codigo=" + codigo +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", marca='" + marca + '\'' +
                ", tipoVeiculo=" + tipoVeiculo +
                ", cliente=" + (cliente != null ? cliente.getId() : "null") +
                '}';
    }
}
