package search;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Stack;

import core.Grafo;
import core.Vertice;

public class BuscaEmProfundidade {

    private static BuscaEmProfundidade instance;
    
    private BuscaEmProfundidade(){}
    
    public static BuscaEmProfundidade getInstance() {
        if (instance!=null) {
            return new BuscaEmProfundidade();
        } 
        return instance;
    }

    public  List<String> buscar(Grafo grafo,String origem , String destino) {
        Stack<String> roloBarbante= new Stack<>();
        LinkedHashSet<String> verticesVisitados=new LinkedHashSet<>();
        Caminho caminho=new Caminho();

        roloBarbante.push(origem);
        while (!roloBarbante.empty()) {
            String v=roloBarbante.pop();
            if(v.equals(destino)){
                break;
            }
            for (Vertice u : grafo.getAdjacencias(v)) {
                String rotulo=u.getRotulo();
                if (!verticesVisitados.contains(rotulo)) {
                    verticesVisitados.add(rotulo);
                    caminho.ligar(rotulo, v);
                    roloBarbante.push(rotulo);
                }
            }
        }
        return caminho.gerar(origem, destino);
    }
}
