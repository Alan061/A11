import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cardapio {

    private static List<String[]> produtos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            telaInicial(sc);
        }
    }

    public static void telaInicial(Scanner sc) {
        System.out.println("Tela de Navegação");
        System.out.println("1. Cadastro de Produtos");
        System.out.println("2. Cardápio");
        System.out.println("3. Cadastro de Clientes");
        System.out.println("4. Alterar Produto");
        System.out.println("5. Excluir Produto");
        System.out.println("6. Alterar Cliente");
        System.out.println("7. Excluir Cliente");
        System.out.println("8. Sair");

        String resposta = sc.nextLine().toLowerCase();

        switch (resposta) {
            case "1":
                telaCadastroProduto(sc);
                break;
            case "2":
                visualizarCardapio();
                break;
            case "3":
                telaCadastroCliente(sc);
                break;
            case "4":
                alterarProduto(sc);
                break;
            case "5":
                excluirProduto(sc);
                break;
            case "6":
                alterarCliente(sc);
                break;
            case "7":
                excluirCliente(sc);
                break;
            case "8":
                System.out.println("Saindo do sistema. Até logo!");
                sc.close();
                System.exit(0);
            default:
                System.out.println("Opção inválida, tente novamente.");
        }
    }

    public static void telaCadastroProduto(Scanner sc) {
        System.out.println("Cadastro de Produtos:");

        String codigo;
        while (true) {
            System.out.print("Digite o código do produto (6 caracteres alfanuméricos): ");
            codigo = sc.nextLine();
            if (codigo.matches("[a-zA-Z0-9]{6}")) {
                break;
            } else {
                System.out.println("Código inválido!");
            }
        }

        String nomeProduto;
        while (true) {
            System.out.print("Digite o nome do produto (3 a 60 caracteres): ");
            nomeProduto = sc.nextLine().toUpperCase();
            if (nomeProduto.matches("[a-zA-Z0-9 ]{3,60}")) {
                break;
            } else {
                System.out.println("Nome inválido!");
            }
        }

        String preco;
        while (true) {
            System.out.print("Digite o preço do produto (número positivo com duas casas decimais): ");
            preco = sc.nextLine();
            if (preco.matches("[0-9]+(\\.[0-9]{1,2})?") && Double.parseDouble(preco) > 0) {
                break;
            } else {
                System.out.println("Preço inválido!");
            }
        }

        String ativo = "True";
        String[] produto = {codigo, nomeProduto, preco, ativo};
        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void visualizarCardapio() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("CÓDIGO        PRODUTO                                                             VALOR");
        System.out.println("-------------------------------------------------------------------------------------------------");

        for (String[] produto : produtos) {
            if (produto[3].equals("True")) {
                System.out.printf("%-12s %-65s %.2f%n", produto[0], produto[1], Double.parseDouble(produto[2]));
            }
        }

        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    public static void alterarProduto(Scanner sc) {
        System.out.print("Digite o código do produto que deseja alterar: ");
        String codigo = sc.nextLine();

        for (String[] produto : produtos) {
            if (produto[0].equals(codigo)) {
                System.out.print("Digite o novo nome do produto: ");
                produto[1] = sc.nextLine().toUpperCase();
                System.out.print("Digite o novo preço do produto: ");
                produto[2] = sc.nextLine();
                System.out.println("MSG003 Produto alterado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não existe no cadastro.");
    }

    public static void excluirProduto(Scanner sc) {
        System.out.print("Digite o código do produto que deseja excluir: ");
        String codigo = sc.nextLine();

        for (String[] produto : produtos) {
            if (produto[0].equals(codigo)) {
                produtos.remove(produto);
                System.out.println("MSG004 Produto excluído com sucesso!");
                return;
            }
        }
        System.out.println("Produto não existe no cadastro.");
    }

    public static void telaCadastroCliente(Scanner sc) {
        System.out.println("Cadastro de Clientes:");

        String nome;
        while (true) {
            System.out.print("Digite o nome do cliente (mínimo 6 caracteres): ");
            nome = sc.nextLine().toUpperCase();
            if (nome.length() >= 6 && nome.length() <= 60) {
                break;
            } else {
                System.out.println("Nome inválido!");
            }
        }

        // Coletando outros dados do cliente
        String logradouro, numero, complemento, bairro, cidade, cep, estado, sexo, telefone, nascimento;
        boolean autorizado = true;

        System.out.print("Digite o logradouro: ");
        logradouro = sc.nextLine();
        System.out.print("Digite o número: ");
        numero = sc.nextLine();
        System.out.print("Digite o complemento (opcional): ");
        complemento = sc.nextLine();
        System.out.print("Digite o bairro: ");
        bairro = sc.nextLine();
        System.out.print("Digite a cidade: ");
        cidade = sc.nextLine();
        System.out.print("Digite o CEP: ");
        cep = sc.nextLine();
        System.out.print("Digite o estado: ");
        estado = sc.nextLine();
        
        while (true) {
            System.out.print("Digite o sexo (M/F): ");
            sexo = sc.nextLine().toUpperCase();
            if (sexo.equals("M") || sexo.equals("F")) {
                break;
            } else {
                System.out.println(" Sexo inválido. Favor tentar novamente.");
            }
        }

        System.out.print("Digite o telefone: ");
        telefone = sc.nextLine();
        System.out.print("Digite a data de nascimento (DD/MM/AAAA): ");
        nascimento = sc.nextLine();

        // Cria um novo cliente
        Cliente cliente = new Cliente(nome, logradouro, numero, complemento, bairro,
                                       cidade, cep, estado, sexo, telefone,
                                       nascimento, autorizado);
        clientes.add(cliente);

        System.out.println(" Cliente cadastrado com sucesso!");
    }

    public static void alterarCliente(Scanner sc) {
        System.out.print("Digite o nome do cliente que deseja alterar: ");
        String nomeCliente = sc.nextLine().toUpperCase();

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nomeCliente)) {
                System.out.print("Digite o novo logradouro: ");
                cliente.setLogradouro(sc.nextLine());
                System.out.print("Digite o novo número: ");
                cliente.setNumero(sc.nextLine());
                // Continue para outros atributos que você deseja alterar
                System.out.println("MSG007 Cliente alterado com sucesso!");
                return;
            }
        }
        System.out.println(" Cliente não existe no cadastro.");
    }

    public static void excluirCliente(Scanner sc) {
        System.out.print("Digite o nome do cliente que deseja excluir: ");
        String nomeCliente = sc.nextLine().toUpperCase();

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nomeCliente)) {
                clientes.remove(cliente);
                System.out.println("MSG008 Cliente excluído com sucesso!");
                return;
            }
        }
        System.out.println(" Cliente não existe no cadastro.");
    }

    // Classe para representar um Cliente
    public static class Cliente {
        private String nome;
        private String logradouro;
        private String numero;
        private String complemento;
        private String bairro;
        private String cidade;
        private String cep;
        private String estado;
        private String sexo;
        private String telefone;
        private String nascimento;
        private boolean autorizado;

        public Cliente(String nome, String logradouro, String numero, String complemento, String bairro,
                       String cidade, String cep, String estado, String sexo, String telefone,
                       String nascimento, boolean autorizado) {
            this.nome = nome;
            this.logradouro = logradouro;
            this.numero = numero;
            this.complemento = complemento;
            this.bairro = bairro;
            this.cidade = cidade;
            this.cep = cep;
            this.estado = estado;
            this.sexo = sexo;
            this.telefone = telefone;
            this.nascimento = nascimento;
            this.autorizado = autorizado;
        }

        // Getters e Setters
        public String getNome() {
            return nome;
        }

        public void setLogradouro(String logradouro) {
            this.logradouro = logradouro;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        // Outros getters e setters podem ser adicionados conforme necessário

        @Override
        public String toString() {
            return "Cliente{" +
                    "nome='" + nome + '\'' +
                    ", logradouro='" + logradouro + '\'' +
                    ", numero='" + numero + '\'' +
                    ", complemento='" + complemento + '\'' +
                    ", bairro='" + bairro + '\'' +
                    ", cidade='" + cidade + '\'' +
                    ", cep='" + cep + '\'' +
                    ", estado='" + estado + '\'' +
                    ", sexo='" + sexo + '\'' +
                    ", telefone='" + telefone + '\'' +
                    ", nascimento='" + nascimento + '\'' +
                    ", autorizado=" + autorizado +
                    '}';
        }
    }
}
