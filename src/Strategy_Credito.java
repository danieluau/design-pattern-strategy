

import java.math.BigDecimal;

public class Strategy_Credito {

    public static void main(String[] args) {
        BigDecimal valor = new BigDecimal("10");
        Compra2 compra = new Compra2(valor);
        
        compra.processarCompra(new PagamentoCartaoCredito2());
        //compra.processarCompra(new PagamentoCartaoDebito2());
    }

}

//----------------------------------------------------

class Compra2 {
    

    BigDecimal valor;

    
    
    public Compra2(BigDecimal valor) {
        this.valor = valor;
    }
    
    void processarCompra(EstrategiaPagamento2 estrategiaPagamento) {
        estrategiaPagamento.pagar(this);
    }
    
}

//----------------------------------------------------

interface EstrategiaPagamento2 {

    void pagar(Compra2 compra);

}

//----------------------------------------------------

class PagamentoCartaoCredito2 implements EstrategiaPagamento2 {

    @Override
    public void pagar(Compra2 compra) {
        System.out.println("o cliente passou " + compra.valor + " reais no crédito ");
    }

}

//----------------------------------------------------

class PagamentoCartaoDebito2 implements EstrategiaPagamento2 {

    @Override
    public void pagar(Compra2 compra) {
        System.out.println("o cliente passou" + compra.valor + " reais no débito ");
    }

}

