import core.Grafo;
import core.Vertice;

public class App {
    public static void main(String[] args) throws Exception {
        Grafo grafo=new Grafo();
        grafo.adicionarVertices("LD");
        grafo.adicionarVertices("BG");
        grafo.adicionarVertices("CS");
        grafo.adicionarVertices("CN");
        grafo.adicionarVertices("LN");
        grafo.adicionarVertices("LS");

        for (Vertice v : grafo.getVertices()) {
            System.out.println("Vertice "+ v.getRotulo());
        }

    }
}
