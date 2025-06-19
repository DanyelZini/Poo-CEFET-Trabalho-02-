import java.util.ArrayList;
import java.util.List;

import enums.TipoVaga;
import models.Cliente;
import models.Veiculo;

public class App {
    public static void main(String[] args) {        
        try {
            Cliente c = new Cliente("Danyel", "10804176647");
            Veiculo carro1 = new Veiculo("ABC1234", "Civic", "Preto", "Honda", TipoVaga.AUTOMOVEL, c);
            c.addVeiculo(carro1);
            System.out.println(c.toString());            

            Veiculo carro2 = new Veiculo("XYZ5678", "Corolla", "Branco", "Toyota", TipoVaga.AUTOMOVEL, c);
            List<Veiculo> veiculos = new ArrayList<>();
            veiculos.add(carro1);
            veiculos.add(carro2);
            c.putCliente("10804176647", "Laura", veiculos);
            System.out.println(c.toString());

            c.removeClienteVeiculo("10804176647", carro1);
            System.out.println(c.toString());

            System.out.println("=======================================");

            Cliente novoCliente = new Cliente("Carlos", "12345678909");
            Veiculo carroNovo = new Veiculo("DEF4321", "Onix", "Prata", "Chevrolet", TipoVaga.AUTOMOVEL, novoCliente);
            novoCliente.addVeiculo(carroNovo);
            System.out.println(novoCliente.toString());

            Veiculo carroNovo2 = new Veiculo("GHI8765", "HB20", "Azul", "Hyundai", TipoVaga.AUTOMOVEL, novoCliente);
            List<Veiculo> veiculosNovoCliente = new ArrayList<>();
            veiculosNovoCliente.add(carroNovo);
            veiculosNovoCliente.add(carroNovo2);
            novoCliente.putCliente("12345678909", "Carlos", veiculosNovoCliente);
            System.out.println(novoCliente.toString());

            novoCliente.removeClienteVeiculo("12345678909", carroNovo);
            System.out.println(novoCliente.toString());

            System.out.println("=======================================");
            System.out.println(c.getAllClientes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
