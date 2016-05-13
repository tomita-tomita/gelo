package control;

public class Produto {
    private int id;    
    private String descricao;
    private String codigoBarras;
    private float precoCompra;
    private float precoVenda;

    public Produto(String descricao, String codigoBarras, float precoCompra, float precoVenda) {        
        this.descricao = descricao;
        this.codigoBarras = codigoBarras;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.id = 0;
    }

    public Produto(int id, String descricao, String codigoBarras, float precoCompra, float precoVenda) {
        this.id = id;       
        this.descricao = descricao;
        this.codigoBarras = codigoBarras;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
    }    

    public int getId() {
        return id;
    }        

    public String getDescricao() {
        return descricao;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

}
