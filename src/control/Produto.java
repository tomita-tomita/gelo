package control;

public class Produto {
    private int id;
    private String codigo;
    private String descricao;
    private String codigoBarras;
    private float precoCompra;
    private float precoVenda;

    public Produto(String codigo, String descricao, String codigoBarras, float precoCompra, float precoVenda) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.codigoBarras = codigoBarras;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.id = 0;
    }

    public Produto(int id, String codigo, String descricao, String codigoBarras, float precoCompra, float precoVenda) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.codigoBarras = codigoBarras;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
    }    

    public int getId() {
        return id;
    }
    
    public String getCodigo() {
        return codigo;
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
