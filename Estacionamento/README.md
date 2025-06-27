# Sistema de Estacionamento

Este projeto é um sistema de gerenciamento de estacionamento desenvolvido em Java, utilizando o padrão de projeto Singleton para o controle do pátio e organização em classes para clientes, veículos, vagas, taxas e estacionamento.

## Funcionalidades
- Cadastro, alteração e listagem de clientes
- Cadastro, alteração e listagem de veículos
- Controle de vagas (com tipos e estados)
- Definição e alteração de taxas por tipo de vaga
- Menu interativo via terminal para facilitar o uso

## Como usar
1. Compile todos os arquivos Java do projeto:
   ```bash
   javac src/**/*.java
   ```
2. Execute o programa principal:
   ```bash
   java -cp src App
   ```
3. O menu principal será exibido no terminal, permitindo:
   - Gerenciar clientes e veículos (cadastrar, alterar, listar)
   - Gerenciar o pátio (listar vagas, alterar taxas)
   - Sair do sistema

## Estrutura das Classes
- **Cliente**: Gerencia dados dos clientes e seus veículos.
- **Veiculo**: Gerencia dados dos veículos e validação de placas.
- **Vaga**: Representa uma vaga no estacionamento, com tipo, estado e taxa.
- **Taxa**: Define o valor/hora para cada tipo de vaga.
- **Estacionamento**: Registra entradas, saídas e valores pagos.
- **Patio**: Singleton que centraliza o controle de vagas, taxas e operações do estacionamento.

## Observações
- O sistema faz validação de CPF e placa de veículo.
- O menu é totalmente interativo e orientado por texto.
- O código é modular e fácil de expandir para novas funcionalidades.

## Exemplo de Uso
Ao rodar o programa, você verá um menu como este:

```
===== MENU PRINCIPAL =====
1. Clientes e Veículos
2. Pátio
0. Sair
Escolha uma opção:
```

Escolha a opção desejada e siga as instruções na tela.

---

Desenvolvido para fins acadêmicos.
