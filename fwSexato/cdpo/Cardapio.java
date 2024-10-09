import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Produto {
    String codigo;
    String descricao;
    boolean ativo;
    float preco;

    Produto(String codigo, String descricao, float preco) {
        this.codigo = codigo.toUpperCase();
        this.descricao = descricao.toUpperCase();
        this.ativo = true; // Produto padrão ativo
        this.preco = preco;
    }
}

public class Cardapio {
    List<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        Cardapio cardapio = new Cardapio();
        Scanner ler = new Scanner(System.in);
        String resposta;

        do {
            String codigo, produto;
            float valor;

            System.out.print("Código: ");
            codigo = ler.nextLine();

            System.out.print("Produto: ");
            produto = ler.nextLine();

            System.out.print("Valor: ");
            valor = Float.parseFloat(ler.nextLine().replace(',', '.')); // Substitui a vírgula pelo ponto

            cardapio.adicionarProduto(new Produto(codigo, produto, valor));

            System.out.print("Deseja continuar? (s/n): ");
            resposta = ler.nextLine().trim().toLowerCase();
        } while (!resposta.equals("n"));

        System.out.println("\nCardápio:");
        cardapio.listarProdutos();
        ler.close();
    }

    void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    void listarProdutos() {
        for (Produto p : produtos) {
            if (p.ativo) {
                System.out.println(p.codigo + " - " + p.descricao + " - R$ " + String.format("%.2f", p.preco));
            }
        }
    }
}
