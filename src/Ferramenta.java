package ToolsShop;

import ToolsShop.conector.Cadastro;

// Classe que representa uma ferramenta e faz o cadastro em uma Thread
public class Ferramenta implements Runnable {

    private String nome_produto;
    private float preco;
    private int estoque;
    private String tipo;

    private Cadastro cadastro;

    // construtor completo
    public Ferramenta(String nome_produto, float preco, int estoque, String tipo) {
        this.nome_produto = nome_produto;
        this.preco = preco;
        this.estoque = estoque;
        this.tipo = tipo;
        this.cadastro = new Cadastro();
    }

    // construtor padrão
    public Ferramenta() {
        this.cadastro = new Cadastro();
    }

    //----- Getters
    public String getNome_produto() {
        return nome_produto;
    }

    public float getpreco() { return preco; }

    public int getEstoque() {
        return estoque;
    }

    public String getTipo() { return tipo; }


    //----- Setters
    public void setNome(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        cadastrarFerramenta();
    }

    // Cadastrar ferramenta
    public void cadastrarFerramenta() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() +
                    " iniciando cadastro da ferramenta: " + this.nome_produto);

            // chama o método adaptado na classe Cadastro
            cadastro.produto(this.nome_produto, this.preco, this.estoque, this.tipo);

            System.out.println("Ferramenta '" + this.nome_produto + "' cadastrada com sucesso! (Thread: " +
                    Thread.currentThread().getName() + ")");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar ferramenta '" + this.nome_produto + "': " + e.getMessage());
        }
    }
}
