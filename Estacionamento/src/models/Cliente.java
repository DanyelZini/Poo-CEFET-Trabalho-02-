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
    public static List<Cliente> getAllClientes() {
        return clientes;
    }
    public static Cliente getCliente(String cpf) {
        cpf = formatarCpf(cpf);
        if (!isCpfValido(cpf))
            return null;

        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf))
                return c;
        }
        return null;
    }
    public static Cliente getCliente(Long id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }

    // Update
    public static Cliente putCliente(String cpf, String nome, List<Veiculo> veiculos) {
        Cliente clienteExistente = getCliente(cpf);
        if (clienteExistente == null)
            return null;

        clienteExistente.setNome(nome);
        clienteExistente.setVeiculos(veiculos);
        return clienteExistente;
    }

    // Delete
    public static Boolean removeClienteVeiculo(String cpf, Veiculo veiculo) {
        Cliente clienteExistente = getCliente(cpf);
        if (clienteExistente == null)
            return false;
        
        clienteExistente.veiculos.remove(veiculo);
        return true;
    }
    public static Boolean removeCliente(String cpf) {
        Cliente clienteExistente = getCliente(cpf);
        if (clienteExistente == null)
            return false;
        
        clientes.remove(clienteExistente);
        return true;
    }

    // =============================================
    // Funcoes para validacao do CPF | Create como construtor
    public Cliente(String nome, String cpf) {
        if (nome == null || cpf == null)
            throw new IllegalArgumentException("Nome e CPF nao podem ser nulos");
        if (!isCpfValido(cpf)) {
            throw new IllegalArgumentException("CPF invalido");
        }
        if (existeCpf(cpf)) {
            throw new IllegalArgumentException("Ja existe um cliente com este CPF");
        }
        this.id = Cliente.nextId++;
        this.nome = nome;
        this.cpf = formatarCpf(cpf);
        clientes.add(this);
    }

    public Cliente(){

    }

    private static String formatarCpf(String cpf) {
        return cpf.replaceAll("[\\.\\-]", "");
    }

    private static Boolean isCpfValido(String cpf) {
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

        if (n1 != (cpf.charAt(9) - '0') || n2 != (cpf.charAt(10) - '0')) {
            return false;
        }

        return true;
    }

    private static Boolean existeCpf(String cpf) {
        return getCliente(cpf) != null;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
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

    @Override
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
