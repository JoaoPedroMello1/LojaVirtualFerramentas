package ToolsShop;

// Classe de modelo para o controle de estoque de ferramentas/produtos
public class Estoque {

    private String nomeProduto;   // nome da ferramenta/produto
    private Integer quantidade;   // quantidade em estoque

    public Estoque(String nomeProduto, Integer quantidade) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    // Metodo utilitario para incrementar estoque
    public void adicionar(int qtd) {
        if (qtd > 0) {
            this.quantidade += qtd;
        }
    }

    // Metodo utilitario para decrementar estoque
    public void remover(int qtd) {
        if (qtd > 0 && this.quantidade >= qtd) {
            this.quantidade -= qtd;
        }
    }
}
