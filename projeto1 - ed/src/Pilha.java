public class Pilha {
    private No topo;

    public void empilhar(Integer valor) {
        No novo = new No(valor);
        novo.proximo = topo;
        topo = novo;
    }

    public Integer desempilhar() {
        if (topo == null) return null;
        Integer valor = topo.dado;
        topo = topo.proximo;
        return valor;
    }

    public Integer topo() {
        return (topo != null) ? topo.dado : null;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public void imprimir() {
        No atual = topo;
        while (atual != null) {
            System.out.print(atual.dado + " → ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
}