import java.util.List;

import core.Grafo;
import core.Vertice;

public class App {
    public static void main(String[] args) throws Exception {
        Grafo grafo=new Grafo(4);
        grafo.adicionarVertices("A");
        grafo.adicionarVertices("B");
        grafo.adicionarVertices("C");
        grafo.adicionarVertices("D");
        
        grafo.conectarVertices("A","B");    
        grafo.conectarVertices("A","C");
        grafo.conectarVertices("A","D");

        System.out.println();

        System.out.println("Grau do vertice A: "+grafo.getVertice("A").getGrau());
        System.out.println("Grau do vertice B: "+grafo.getVertice("B").getGrau());
        System.out.println("Grau do vertice C: "+grafo.getVertice("C").getGrau());
        System.out.println("Grau do vertice D: "+grafo.getVertice("D").getGrau());

        
        System.out.println();
        System.out.println("O A possui as seguintes adjacencias:");
        List<Vertice> adjacentes=grafo.getAdjacencias("A");
        
        for (Vertice v : adjacentes) {
            System.out.println("Rotulo de A "+ v.getRotulo());
        }
        System.out.println();
        System.out.println("O B possui as seguintes adjacencias:");
        adjacentes=grafo.getAdjacencias("B");
        for (Vertice v : adjacentes) {
            System.out.println("Rotulo de B "+ v.getRotulo());
        }

    }

    public static void println(String msg){
        System.out.println(msg);
    }
}


