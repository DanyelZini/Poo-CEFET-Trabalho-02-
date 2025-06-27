import java.util.Scanner;

import controller.Patio;
import enums.TipoVaga;
import models.Cliente;
import models.Estacionamento;
import models.Veiculo;

public class App {    
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        Patio p = Patio.getInstance();
        while (true) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Clientes e Veículos");
            System.out.println("2. Pátio");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int mainOp = scanner.nextInt();
            scanner.nextLine();
            if (mainOp == 0) {
                System.out.println("Saindo...");
                scanner.close();
                return;
            }
            switch (mainOp) {
                case 1:
                    menuClientesVeiculos(scanner);
                    break;
                case 2:
                    menuPatio(scanner, p);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuClientesVeiculos(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Menu Clientes e Veículos ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Alterar Cliente");
            System.out.println("3. Cadastrar Veículo");
            System.out.println("4. Alterar Veículo");
            System.out.println("5. Listar Clientes");
            System.out.println("6. Listar Veículos");
            System.out.println("7. Pesquisar Cliente");
            System.out.println("8. Pesquisar Veículo");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        new Cliente(nome, cpf);
                        System.out.println("Cliente cadastrado!");
                        break;
                    case 2:
                        System.out.print("CPF do cliente a alterar: ");
                        String cpfAlt = scanner.nextLine();
                        Cliente clienteAlt = new Cliente().getCliente(cpfAlt);
                        if (clienteAlt == null) {
                            System.out.println("Cliente não encontrado!");
                            break;
                        }
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();
                        clienteAlt.setNome(novoNome);
                        System.out.println("Nome alterado!");
                        break;
                    case 3:
                        System.out.print("CPF do dono: ");
                        String cpfDono = scanner.nextLine();
                        Cliente dono = new Cliente().getCliente(cpfDono);
                        if (dono == null) {
                            System.out.println("Cliente não encontrado!");
                            break;
                        }
                        System.out.print("Placa: ");
                        String placa = scanner.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = scanner.nextLine();
                        System.out.print("Cor: ");
                        String cor = scanner.nextLine();
                        System.out.print("Marca: ");
                        String marca = scanner.nextLine();
                        System.out.print("Tipo (1-AUTOMOVEL, 2-MOTO, 3-UTILITARIO): ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();
                        TipoVaga tipoVaga = tipo == 2 ? TipoVaga.MOTO : (tipo == 3 ? TipoVaga.UTILITARIO : TipoVaga.AUTOMOVEL);
                        new Veiculo(placa, modelo, cor, marca, tipoVaga, dono);
                        System.out.println("Veículo cadastrado!");
                        break;
                    case 4:
                        System.out.print("Placa do veículo a alterar: ");
                        String placaAlt = scanner.nextLine();
                        Veiculo veiculoAlt = new Veiculo().getVeiculo(placaAlt);
                        if (veiculoAlt == null) {
                            System.out.println("Veículo não encontrado!");
                            break;
                        }
                        System.out.print("Novo modelo: ");
                        String novoModelo = scanner.nextLine();
                        System.out.print("Nova cor: ");
                        String novaCor = scanner.nextLine();
                        System.out.print("Nova marca: ");
                        String novaMarca = scanner.nextLine();
                        veiculoAlt.setModelo(novoModelo);
                        veiculoAlt.setCor(novaCor);
                        veiculoAlt.setMarca(novaMarca);
                        System.out.println("Veículo alterado!");
                        break;
                    case 5:
                        System.out.println("Clientes:");
                        for (Cliente c : Cliente.getClientes()) {
                            System.out.println(c.toString());
                        }
                        break;
                    case 6:
                        System.out.println("Veículos:");
                        for (Veiculo v : Veiculo.veiculos) {
                            System.out.println(v);
                        }
                        break;
                    case 7:
                        System.out.print("CPF do cliente para pesquisar: ");
                        String cpfPesquisa = scanner.nextLine();
                        Cliente clientePesq = new Cliente().getCliente(cpfPesquisa);
                        if (clientePesq == null) {
                            System.out.println("Cliente não encontrado!");
                        } else {
                            System.out.println("Cliente encontrado: " + clientePesq);
                        }
                        break;
                    case 8:
                        System.out.print("Placa do veículo para pesquisar: ");
                        String placaPesquisa = scanner.nextLine();
                        Veiculo veiculoPesq = new Veiculo().getVeiculo(placaPesquisa);
                        if (veiculoPesq == null) {
                            System.out.println("Veículo não encontrado!");
                        } else {
                            System.out.println("Veículo encontrado: " + veiculoPesq);
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void menuPatio(Scanner scanner, Patio p) {
        while (true) {
            System.out.println("\n--- Menu Pátio ---");
            System.out.println("1. Listar Vagas");
            System.out.println("2. Alterar Taxa de Vaga");
            System.out.println("3. Buscar Vaga por Número");
            System.out.println("4. Alterar Estado da Vaga");
            System.out.println("5. Entrada de Estacionamento");
            System.out.println("6. Listar Estacionamentos");
            System.out.println("7. Saída de Estacionamento");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (opcao) {
                    case 1:
                        System.out.println(p.listarVagas());
                        break;
                    case 2:
                        System.out.print("Tipo de vaga (1-AUTOMOVEL, 2-MOTO, 3-UTILITARIO): ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();
                        TipoVaga tipoVaga = tipo == 2 ? TipoVaga.MOTO : (tipo == 3 ? TipoVaga.UTILITARIO : TipoVaga.AUTOMOVEL);
                        System.out.print("Nova taxa/hora: ");
                        double novaTaxa = scanner.nextDouble();
                        scanner.nextLine();
                        boolean alterado = p.alterarTaxa(tipoVaga, novaTaxa);
                        if (alterado) {
                            System.out.println("Taxa alterada!");
                        } else {
                            System.out.println("Tipo de vaga não encontrado!");
                        }
                        break;
                    case 3:
                        System.out.print("Número da vaga para buscar: ");
                        int numeroVaga = scanner.nextInt();
                        scanner.nextLine();
                        var vaga = Patio.buscarVagaPorNumero(numeroVaga);
                        if (vaga != null) {
                            System.out.println("Vaga encontrada: " + vaga);
                        } else {
                            System.out.println("Vaga não encontrada!");
                        }
                        break;
                    case 4:
                        System.out.print("Número da vaga para alterar estado: ");
                        int numVaga = scanner.nextInt();
                        scanner.nextLine();
                        var vagaEstado = Patio.buscarVagaPorNumero(numVaga);
                        if (vagaEstado == null) {
                            System.out.println("Vaga não encontrada!");
                            break;
                        }
                        System.out.println("Definir estado: 1 - Livre, 2 - Ocupado, 3 - Indisponível");
                        System.out.print("Escolha o estado: ");
                        int estado = scanner.nextInt();
                        scanner.nextLine();
                        vagaEstado.definirEstado(estado);
                        System.out.println("Estado da vaga alterado!");
                        break;
                    case 5:
                        System.out.print("Placa do veículo: ");
                        String placaEntrada = scanner.nextLine();
                        System.out.print("Número da vaga: ");
                        int numeroVagaEntrada = scanner.nextInt();
                        scanner.nextLine();
                        try {
                            Patio.adicionarEstacionamento(new Estacionamento(placaEntrada, numeroVagaEntrada));
                        } catch (Exception e) {
                            System.out.println("Erro ao registrar entrada: " + e.getMessage());
                        }
                        break;
                    case 6:
                        System.out.println("Estacionamentos registrados:");
                        System.out.println(Patio.listarEstacionamentos());
                        break;
                    case 7:
                        System.out.print("Placa do veículo para saída: ");
                        String placaSaida = scanner.nextLine();
                        try {
                            double valor = Patio.saidaVeiculo(placaSaida);
                            System.out.printf("Saída registrada! Valor a pagar: R$ %.2f\n", valor);
                        } catch (Exception e) {
                            System.out.println("Erro ao registrar saída: " + e.getMessage());
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
