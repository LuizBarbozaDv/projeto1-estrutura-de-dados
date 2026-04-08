public class Deque {
    private No frente;
    private No tras;

    public void inserirInicio(Integer valor) {
        No novo = new No(valor);
        novo.proximo = frente;
        frente = novo;
        if (tras == null) tras = novo;
    }

    public void inserirFim(Integer valor) {
        No novo = new No(valor);
        if (tras == null) {
            frente = novo;
            tras = novo;
        } else {
            tras.proximo = novo;
            tras = novo;
        }
    }

    public Integer removerInicio() {
        if (frente == null) return null;
        Integer valor = frente.dado;
        frente = frente.proximo;
        if (frente == null) tras = null;
        return valor;
    }

    public Integer removerFim() {
        if (frente == null) return null;
        if (frente == tras) {
            Integer valor = frente.dado;
            frente = null;
            tras = null;
            return valor;
        }
        No atual = frente;
        while (atual.proximo != tras) {
            atual = atual.proximo;
        }
        Integer valor = tras.dado;
        atual.proximo = null;
        tras = atual;
        return valor;
    }

    public Integer consultarInicio() {
        return (frente != null) ? frente.dado : null;
    }

    public Integer consultarFim() {
        return (tras != null) ? tras.dado : null;
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