package control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Recibo {

    private String cliente;
    private String endereco;
    private String telefone;
    private float valorTotal;
    private float taxaEntrega;
    private ArrayList<ItemRecibo> itensRecibo = new ArrayList<>();

    public Recibo(String cliente, String endereco, String telefone, float taxaEntrega, ArrayList<ItemRecibo> itensRecibo) {
        this.cliente = cliente;
        this.endereco = endereco;
        this.telefone = telefone;        
        this.taxaEntrega = taxaEntrega;
        this.itensRecibo = itensRecibo;
        this.valorTotal = calcularTotal();
    }

    private float calcularTotal() {
        float total = 0;
        for (ItemRecibo item : itensRecibo) {
            total = total + item.calcularValorTotal();
        }        
        return total + taxaEntrega;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public ArrayList<ItemRecibo> getItensRecibo() {
        return itensRecibo;
    }

    public float getTaxaEntrega() {
        return taxaEntrega;
    }

    public String getTelefone() {
        return telefone;
    }

    public float getValorTotal() {
        return valorTotal;
    }    
}
