public class Fila {
    private No frente;
    private No tras;

    public void enfileirar(Integer valor) {
        No novo = new No(valor);
        if (tras == null) {
            frente = novo;
            tras = novo;
        } else {
            tras.proximo = novo;
            tras = novo;
        }
    }

    public Integer desenfileirar() {
        if (frente == null) return null;
        Integer valor = frente.dado;
        frente = frente.proximo;
        if (frente == null) tras = null;
        return valor;
    }

    public Integer consultarFrente() {
        return (frente != null) ? frente.dado : null;
    }

    public boolean estaVazia() {
        return frente == null;
    }

    public void imprimir() {
        No atual = frente;
        while (atual != null) {
            System.out.print(atual.dado + " → ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
}