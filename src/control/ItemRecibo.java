package control;

public class ItemRecibo {
private int id_produto;
private String descricao;
private float quantidade;
private float precoUnitario;
private float precoTotal;

    public ItemRecibo(int id_produto, String descricao, float quantidade, float precoUnitario) {
        this.id_produto = id_produto;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;        
    }
    
    public float calcularValorTotal(){
        precoTotal = quantidade * precoUnitario;
        return precoTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId_produto() {
        return id_produto;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public float getQuantidade() {
        return quantidade;
    }    
}
