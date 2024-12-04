package core;
import java.util.*;
public class Grafo {

    private List<Vertice> vertices=new ArrayList<>();
    private int qtMaximaVertices;
    private boolean isQtMaximaDefinida;
    private int qtAtualVertices=0;
    private Map<String,Integer> rotulosEmIndices=new HashMap<>();

    public Grafo(){
         qtMaximaVertices=10;
    }
    
    public Grafo(int qtVertices){
        if(qtVertices<=0){
            throw new IllegalArgumentException("A quantidade maxima de vértices deve ser maior ou igual à 1 ");
        }
        this.qtMaximaVertices=qtVertices;
        this.isQtMaximaDefinida=true;
   }
   public List<Vertice> getVertices(){
    return this.vertices;
}

   public void adicionarVertices(String rotulo) throws Exception{
        if(qtAtualVertices<=qtMaximaVertices-1){
            Vertice novoVertice=new Vertice(rotulo);
            this.vertices.add(novoVertice);
            this.rotulosEmIndices.put(rotulo, qtAtualVertices);
            qtAtualVertices++;
            return;
        }
        throw new Exception("A quantidade de vértices permitida ("+ qtMaximaVertices +") foi execedida");
   }

 
   
 
}
