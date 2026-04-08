import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean sair = false;

        ListaSimples l1 = new ListaSimples();
        ListaSimples l2 = new ListaSimples();
        Pilha p = new Pilha();
        Fila f = new Fila();
        Deque d = new Deque();
        Pilha aux = new Pilha();

        // elementos aleatórios + menu de posição
        System.out.println("Inserindo 10 números aleatórios ===");

        while (sair != true) {

            int num = rand.nextInt(50) + 1;
            System.out.println("\nNúmero gerado: " + num);
            System.out.println("1 - Início   2 - Meio   3 - Fim 4 - Parar");
            System.out.print("Escolha: ");
            int op = sc.nextInt();

            switch (op) {
                case 1 -> l1.inserirInicio(num);
                case 2 -> l1.inserirMeio(num);
                case 3 -> l1.inserirFim(num);
                case 4 -> sair = true;
                default -> l1.inserirFim(num);
            }
        }

        System.out.println("\nL1 após inserções:");
        l1.imprimir();

        // copia lista
        l1.copiarPara(l2);
        System.out.println("\nL2 (cópia de L1):");
        l2.imprimir();

        // remove pares de L1 e colocar na pilha P
        l1.removerPares(p);
        System.out.println("\nL1 após remover pares:");
        l1.imprimir();
        System.out.println("Pilha P (pares):");
        p.imprimir();

        // ordena L2 com Bubble Sort
        l2.ordenarComBubbleSort();
        System.out.println("\nL2 ordenada (Bubble Sort):");
        l2.imprimir();

        // mostra múltiplos de 3
        System.out.println("\nMúltiplo de 3 em L1:");
        l1.mostrarMultiplosDe3();

        // inverte L2 usando pilha auxiliar
        while (!l2.estaVazia()) {
            aux.empilhar(l2.removerInicio());
        }
        while (!aux.estaVazia()) {
            l2.inserirFim(aux.desempilhar());
        }
        System.out.println("\nL2 invertida (último vira cabeça):");
        l2.imprimir();

        // transfere pilha P para fila F
        while (!p.estaVazia()) {
            f.enfileirar(p.desempilhar());
        }
        System.out.println("\nFila F (recebeu da pilha P):");
        f.imprimir();

        // percorrer L2 e inserir alternado no deque D
        l2.inserirAlternadoNoDeque(d);
        System.out.println("\nDeque D (inserção alternada de L2):");
        d.imprimir();

        // troca primeiro e último de L1
        l1.trocarPrimeiroUltimo();
        System.out.println("\nL1 após trocar o primeiro pelo último:");
        l1.imprimir();

        // mostra tudo que restou
        System.out.println("\nElementos restantes em cada estrutura: ");
        System.out.print("L1: "); l1.imprimir();
        System.out.print("L2: "); l2.imprimir();
        System.out.print("P:  "); p.imprimir();
        System.out.print("F:  "); f.imprimir();
        System.out.print("D:  "); d.imprimir();

        sc.close();
    }
}