public class ListaSimples {
    private No cabeca;

    public void inserirInicio(Integer valor) {
        No novo = new No(valor);
        novo.proximo = cabeca;
        cabeca = novo;
    }

    public void inserirFim(Integer valor) {
        No novo = new No(valor);
        if (cabeca == null) {
            cabeca = novo;
            return;
        }
        No atual = cabeca;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        atual.proximo = novo;
    }

    public void inserirMeio(Integer valor) {
        int tam = tamanho();
        if (tam <= 1) {
            inserirFim(valor);
            return;
        }
        int posMeio = tam / 2;
        inserirNaPosicao(posMeio, valor);
    }

    public void inserirNaPosicao(int pos, Integer valor) {
        if (pos <= 0) {
            inserirInicio(valor);
            return;
        }
        if (pos >= tamanho()) {
            inserirFim(valor);
            return;
        }
        No novo = new No(valor);
        No atual = cabeca;
        for (int i = 0; i < pos - 1; i++) {
            atual = atual.proximo;
        }
        novo.proximo = atual.proximo;
        atual.proximo = novo;
    }

    public int tamanho() {
        int cont = 0;
        No atual = cabeca;
        while (atual != null) {
            cont++;
            atual = atual.proximo;
        }
        return cont;
    }

    public boolean estaVazia() {
        return cabeca == null;
    }

    public void imprimir() {
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.dado + " → ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    public void copiarPara(ListaSimples destino) {
        No atual = cabeca;
        while (atual != null) {
            destino.inserirFim(atual.dado);
            atual = atual.proximo;
        }
    }

    public void removerPares(Pilha p) {
        if (cabeca == null) return;
        No anterior = null;
        No atual = cabeca;
        while (atual != null) {
            if (atual.dado % 2 == 0) {
                p.empilhar(atual.dado);
                if (anterior == null) {
                    cabeca = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }
                atual = atual.proximo;
            } else {
                anterior = atual;
                atual = atual.proximo;
            }
        }
    }

    public void mostrarMultiplosDe3() {
        No atual = cabeca;
        boolean encontrou = false;
        while (atual != null) {
            if (atual.dado % 3 == 0) {
                System.out.print(atual.dado + " ");
                encontrou = true;
            }
            atual = atual.proximo;
        }
        if (!encontrou) System.out.print("Nenhum");
        System.out.println();
    }

    public Integer removerInicio() {
        if (cabeca == null) return null;
        Integer valor = cabeca.dado;
        cabeca = cabeca.proximo;
        return valor;
    }

    public void ordenarComBubbleSort() {
        if (cabeca == null) return;
        boolean trocou;
        do {
            trocou = false;
            No atual = cabeca;
            while (atual.proximo != null) {
                if (atual.dado > atual.proximo.dado) {
                    Integer temp = atual.dado;
                    atual.dado = atual.proximo.dado;
                    atual.proximo.dado = temp;
                    trocou = true;
                }
                atual = atual.proximo;
            }
        } while (trocou);
    }

    public void trocarPrimeiroUltimo() {
        if (cabeca == null || cabeca.proximo == null) return;
        No primeiro = cabeca;
        No ultimo = cabeca;
        while (ultimo.proximo != null) {
            ultimo = ultimo.proximo;
        }
        Integer temp = primeiro.dado;
        primeiro.dado = ultimo.dado;
        ultimo.dado = temp;
    }

    public void inserirAlternadoNoDeque(Deque d) {
        No atual = cabeca;
        boolean inserirNoInicio = true;
        while (atual != null) {
            if (inserirNoInicio) {
                d.inserirInicio(atual.dado);
            } else {
                d.inserirFim(atual.dado);
            }
            inserirNoInicio = !inserirNoInicio;
            atual = atual.proximo;
        }
    }
}