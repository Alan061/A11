package cdpo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cardapio {

    // Lista para armazenar os produtos, onde cada produto é representado por um
    // array de String
    private static List<String[]> produtos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            telaInicial(sc);
        }
    }

    public static void telaInicial(Scanner sc) {
        System.out.println("Tela de Navegação");
        System.out.println();
        System.out.println("Cadastro de Produtos -> Digite '1' ");
        System.out.println();
        System.out.println("Cardápio -> Digite '2' ");
        System.out.println();
        System.out.println("Consultar Produto -> Digite '3' ");
        System.out.println();
        System.out.println("Excluir Produto -> Digite '4' ");
        System.out.println();
        System.out.println("Sair -> Digite '5' ");

        String resposta = sc.nextLine().toLowerCase();

        switch (resposta) {
            case "1":
                telaCadastro(sc);
                break;
            case "2":
                visualizarCardapio();
                break;
            case "3":
                consultarProduto(sc);
                break;
            case "4":
                excluirProduto(sc);
                break;
            case "5":
                System.out.println("Saindo do sistema. Até logo!");
                sc.close();
                System.exit(0);
            default:
                System.out.println("Opção inválida, tente novamente.");
        }
    }

    public static void telaCadastro(Scanner sc) {
        System.out.println("Cadastro de Produtos: ");

        // Validação do código
        String codigo;
        while (true) {
            System.out.println("Digite o código do produto (6 caracteres alfanuméricos): ");
            codigo = sc.nextLine();
            if (codigo.matches("[a-zA-Z0-9]{6}")) {
                break;
            } else {
                System.out.println("Código inválido! O código deve conter exatamente 6 caracteres alfanuméricos.");
            }
        }

        // Validação do nome do produto
        String nomeProduto;
        while (true) {
            System.out.println("Digite o nome do produto (3 a 60 caracteres): ");
            nomeProduto = sc.nextLine().toUpperCase(); // Converte para caixa alta
            if (nomeProduto.matches("[a-zA-Z0-9 ]{3,60}")) {
                break;
            } else {
                System.out.println("Nome do produto inválido! Deve ter entre 3 e 60 caracteres alfanuméricos.");
            }
        }

        // Validação do preço
        String preco;
        while (true) {
            System.out.println("Digite o preço do produto (número positivo com duas casas decimais): ");
            preco = sc.nextLine();
            if (preco.matches("[0-9]+(\\.[0-9]{1,2})?") && Double.parseDouble(preco) > 0) {
                break;
            } else {
                System.out.println("Preço inválido! Deve ser um número positivo com duas casas decimais.");
            }
        }

        // Produto está ativo por padrão (True)
        String ativo = "True";

        // Adiciona o produto à lista de produtos
        String[] produto = { codigo, nomeProduto, preco, ativo };
        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void visualizarCardapio() {
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
        System.out.println("CÓDIGO        PRODUTO                                                             VALOR");
        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        // Exibe apenas os produtos que estão ativos (ativo == "True")
        for (String[] produto : produtos) {
            if (produto[3].equals("True")) {
                System.out.printf("%-12s %-65s %.2f%n", produto[0], produto[1], Double.parseDouble(produto[2]));
            }
        }

        System.out.println(
                "-------------------------------------------------------------------------------------------------");
    }

    public static void consultarProduto(Scanner sc) {
        System.out.println("Digite o código do produto para consultar: ");
        String codigo = sc.nextLine();

        for (String[] produto : produtos) {
            if (produto[0].equalsIgnoreCase(codigo)) {
                System.out.println("Produto encontrado:");
                System.out.println("Código: " + produto[0]);
                System.out.println("Nome: " + produto[1]);
                System.out.println("Preço: " + produto[2]);
                System.out.println("Ativo: " + produto[3]);
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public static void excluirProduto(Scanner sc) {
        System.out.println("Digite o código do produto que deseja excluir: ");
        String codigo = sc.nextLine();

        for (String[] produto : produtos) {
            if (produto[0].equalsIgnoreCase(codigo)) {
                produto[3] = "False"; // Marca o produto como desativado
                System.out.println("Produto desativado com sucesso.");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }
}     



