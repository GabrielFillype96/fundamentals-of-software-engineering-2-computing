import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> nomes = new ArrayList<String>();
        nomes.add("Alice");
        nomes.add("Bob");

        System.out.println("Nomes: " + nomes);
        
        nomes.addFirst("Joao");

        System.out.println("Nomes: " + nomes);

        Queue<String> pedidos = new LinkedList<String>();
        pedidos.add("Pedido 1");
        pedidos.add("Pedido 2");
        pedidos.add("Pedido 3");

        System.out.println("Lista de pedidos: " + pedidos);

        System.out.println("Primeiro pedido: " + pedidos.peek());
        System.out.println("Último pedido: " + ((LinkedList<String>)pedidos).getLast());
        System.out.println("Remover o pedido: " + pedidos.remove());
        System.out.println("Lista de pedidos: " + pedidos);

    }
}
