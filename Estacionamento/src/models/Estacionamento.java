package models;

import java.util.Date;

import controller.Patio;

public class Estacionamento {
    private static long nextId = 1;
    private Long id;
    private Date entrada;
    private Date saida;
    private Double valor;
    private Veiculo veiculo;
    private int numVaga;

    // =============================================
    // Create
    public Estacionamento(String placa, int numeroVaga) {
        if(!Patio.buscarVagaPorNumero(numeroVaga).isLivre())
            throw new IllegalArgumentException("Vaga Ocupada ou Indisponivel!");
        Patio.alterarEstadoVaga(numeroVaga, 2);
        this.id = nextId++;
        this.veiculo = Veiculo.getVeiculo(placa);
        this.entrada = new Date();
        this.numVaga = numeroVaga;
        this.saida = null;
        this.valor = null;
    }

    public Double registrarSaida() {
        this.saida = new Date();
        var vaga = Patio.buscarVagaPorNumero(this.numVaga);
        Patio.alterarEstadoVaga(this.numVaga, 1);

        if (this.entrada != null && this.saida != null && vaga != null && vaga.getTaxa() != null) {
            long tempoMili = this.saida.getTime() - this.entrada.getTime();
            double tempoHoras = Math.ceil(tempoMili / (1000.0 * 60 * 60));
            double taxaPorHora = vaga.getTaxa().getValorHora();
            this.valor = tempoHoras * taxaPorHora;
        } else {
            this.valor = 0.0;
        }
        return this.valor;
    }

    // =============================================
    // Read

    // =============================================
    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        throw new UnsupportedOperationException("O id é gerado automaticamente e não pode ser alterado.");
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estacionamento {\n");
        sb.append("  id: ").append(id).append(",\n");
        sb.append("  entrada: ").append(entrada).append(",\n");
        sb.append("  saida: ").append(saida).append(",\n");
        sb.append("  valor: ").append(valor).append(",\n");
        sb.append("  numVaga: ").append(numVaga).append(",\n");
        sb.append("  veiculo: ");
        if (veiculo != null) {
            sb.append(veiculo.getPlaca()).append("\n");
        } else {
            sb.append("null\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
