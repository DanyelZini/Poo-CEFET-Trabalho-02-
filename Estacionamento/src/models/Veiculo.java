package models;

import java.util.ArrayList;
import java.util.List;

import enums.TipoVaga;

public class Veiculo {
    public static final List<Veiculo> veiculos = new ArrayList<>();
    private static long nextCodigo = 1;
    private Long codigo;
    private String placa;
    private String modelo;
    private String cor;
    private String marca;
    private TipoVaga tipoVeiculo;
    private Cliente cliente;

    // =============================================
    // Create/Construtor e outras funcoes 
    public Veiculo() {
        
    }
    public Veiculo(String placa, String modelo, String cor, String marca, TipoVaga tipoVeiculo, Cliente cliente) {
        if (placa == null || modelo == null || cor == null || marca == null || tipoVeiculo == null || cliente == null)
            throw new IllegalArgumentException("Nenhum dos campos pode ser nulo.");
        if (!isValidPlaca(placa)) 
            throw new IllegalArgumentException("Placa informada nao e valida.");
        if (getVeiculo(placa) != null)
            throw new IllegalArgumentException("Veiculo ja cadastrado.");
        this.codigo = nextCodigo++;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.tipoVeiculo = tipoVeiculo;
        this.cliente = cliente;
        veiculos.add(this);
    }
    private Boolean isValidPlaca(String placa) {
        return placa.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}") ? true : false;
    }

    // Read
    public List<Veiculo> getAllVeiculos() {
        return veiculos;
    }
    public Veiculo getVeiculo(String placa) {
        if (!isValidPlaca(placa))
            return null;
        
        for(Veiculo v : veiculos) {
            if(v.getPlaca().equals(placa))
                return v;
        }
        return null;
    }
    public Veiculo getVeiculo(Long codigo) {        
        for(Veiculo v : veiculos) {
            if(v.getCodigo().equals(codigo))
                return v;
        }
        return null;
    }

    // Update
    public Veiculo putVeiculo(String placa, String modelo, String cor, String marca) {
        Veiculo veiculoExistente = getVeiculo(placa);
        if (veiculoExistente == null)
            return null;

        veiculoExistente.setModelo(modelo);
        veiculoExistente.setCor(cor);
        veiculoExistente.setMarca(marca);
        return veiculoExistente;
    }
    public Veiculo putVeiculo(Long codigo, String placa) {
        if (!isValidPlaca(placa)) 
            return null;

        Veiculo veiculoExistente = getVeiculo(codigo);
        if (veiculoExistente == null)
            return null;

        veiculoExistente.setPlaca(placa);
        return veiculoExistente;
    }

    // Delete
    public Boolean removeVeiculo(Long codigo) {
        Veiculo veiculoExistente = getVeiculo(codigo);
        if (veiculoExistente == null)
            return false;

        veiculos.remove(veiculoExistente);
        return true;
    }
    public Boolean removeVeiculo(String placa) {
        if (!isValidPlaca(placa)) 
            return null;
        
        Veiculo veiculoExistente = getVeiculo(placa);
        if (veiculoExistente == null)
            return false;

        veiculos.remove(veiculoExistente);
        return true;
    }

    // =============================================
    // Getters e Setters
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
        return  "\n" + 
                "Veiculo {" +
                "codigo= " + codigo +
                ", placa= '" + placa + '\'' +
                ", modelo= '" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", marca= '" + marca + '\'' +
                ", tipoVeiculo= '" + tipoVeiculo + '\'' +
                ", cliente= '" + (cliente != null ? cliente.getNome() : "null") +
                "' }" ;
    }
}
