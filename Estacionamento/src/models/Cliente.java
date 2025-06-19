package models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static final List<Cliente> clientes = new ArrayList<>();
    private static long nextId = 1;
    private Long id;
    private String nome;
    private String cpf;
    private List<Veiculo> veiculos = new ArrayList<>();

    // =============================================
    // RUD | Read Update Delete
    // Read
    public List<Cliente> getAllClientes() {
        return clientes;
    }
    public Cliente getCliente(String cpf) {
        cpf = formatarCpf(cpf);
        if (!isCpfValido(cpf))
            return null;

        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf))
                return c;
        }
        return null;
    }

    // Update
    public Cliente putCliente(String cpf, String nome, List<Veiculo> veiculos) {
        Cliente clienteExistente = getCliente(cpf);
        if (clienteExistente == null)
            return null;

        clienteExistente.setNome(nome);
        clienteExistente.setVeiculos(veiculos);
        return clienteExistente;
    }

    // Delete
    public Boolean removeClienteVeiculo(String cpf, Veiculo veiculos) {
        Cliente clienteExistente = getCliente(cpf);
        if (clienteExistente == null)
            return false;
        
        clienteExistente.veiculos.remove(veiculos);
        return true;
    }
    public Boolean removeCliente(String cpf) {
        Cliente clienteExistente = getCliente(cpf);
        if (clienteExistente == null)
            return false;
        
        clientes.remove(clienteExistente);
        return true;
    }

    // =============================================
    // Funcoes para validacao do CPF | Create como construtor
    public Cliente(String nome, String cpf) {
        if (!isCpfValido(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        if (existeCpf(cpf)) {
            throw new IllegalArgumentException("Já existe um cliente com este CPF");
        }
        this.id = nextId++;
        this.nome = nome;
        this.cpf = formatarCpf(cpf);
        clientes.add(this);
    }

    private String formatarCpf(String cpf) {
        return cpf.replaceAll("[\\.\\-]", "");
    }

    private Boolean isCpfValido(String cpf) {
        cpf = formatarCpf(cpf);

        if (!cpf.matches("\\d{11}") || cpf.length() != 11)
            return false;

        int soma = 0;
        for (int i = 0; i < 9; i++)
            soma += (int) (cpf.charAt(i) - '0') * (10 - i);
        int n1 = 11 - (soma % 11);
        if (n1 >= 10)
            n1 = 0;

        soma = 0;
        for (int i = 0; i < 10; i++)
            soma += (int) (cpf.charAt(i) - '0') * (11 - i);
        int n2 = 11 - (soma % 11);
        if (n2 >= 10)
            n2 = 0;

        if (n1 != (cpf.charAt(9) - '0') || n2 != (cpf.charAt(10) - '0'))
            return false;

        return true;
    }

    private Boolean existeCpf(String cpf) {
        return getCliente(cpf) == null ? false : true;
    }

    // =============================================
    // Getters e Setters
    public static List<Cliente> getClientes() {
        return clientes;
    }

    public static long getNextId() {
        return nextId;
    }

    public static void setNextId(long nextId) {
        Cliente.nextId = nextId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public void addVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    // toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente {\n");
        sb.append("  id: ").append(id).append(",\n");
        sb.append("  nome: '").append(nome).append("',\n");
        sb.append("  cpf: '").append(cpf).append("',\n");
        sb.append("  veiculos: [\n");
        for (Veiculo v : veiculos) {
            sb.append("    ").append(v.toString()).append(",\n");
        }
        sb.append("  ]\n");
        sb.append("}");
        return sb.toString();
    }

}
