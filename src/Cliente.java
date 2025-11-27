package ToolsShop;

import ToolsShop.conector.Cadastro;

// Representa um cliente da loja de ferramentas
public class Cliente {

    private String nome;
    private String tel;
    private String end;

    private Cadastro cadastro;

    public Cliente(String nome, String tel, String end) {
        this.nome = nome;
        this.tel = tel;
        this.end = end;
        this.cadastro = new Cadastro();
    }

    public Cliente() {
        this.cadastro = new Cadastro();
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getTel() {
        return tel;
    }

    public String getEnd() {
        return end;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    // Método para cadastrar o cliente no banco de dados
    public void cadastrarCliente() {
        try {
            cadastro.cliente(this.nome, this.tel, this.end);
            System.out.println("Cliente '" + this.nome + "' cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    public void cadastrarCliente(String nome, String tel, String end) {
        this.nome = nome;
        this.tel = tel;
        this.end = end;
        cadastrarCliente();
    }
}
