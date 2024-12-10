package core;
import java.util.*;
public class Grafo {

    private List<Vertice> vertices=new ArrayList<>();
    private int qtMaximaVertices;
    private boolean isQtMaximaDefinida;
    private int qtAtualVertices=0;
    private Map<String,Integer> rotulosEmIndices=new HashMap<>();
    private MatrizAdjacencia matrizAdjacencia;
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

   public Vertice getVertice(String rotulo){
        this.existeVerticeOrThrow(rotulo);
        int indice=this.rotulosEmIndices.get(rotulo);
        return this.vertices.get(indice);
   }

   public void conectarVertices(String rotuloVerticeIncial, String rotuloVerticeFinal) throws Exception{
        if(!this.existeVertice(rotuloVerticeIncial) || !this.existeVertice(rotuloVerticeFinal)){
            throw new Exception("Para adicionar uma aresta ambos os vertices devem existir");
        }
        criarMatrizAdjacencia();
        var indiceVerticeIncial=this.rotulosEmIndices.get(rotuloVerticeIncial);
        var indiceVerticeFinal=this.rotulosEmIndices.get(rotuloVerticeFinal);
        this.matrizAdjacencia.adicionarAresta(indiceVerticeIncial,indiceVerticeFinal);     
   }

   public List<Vertice> getAdjacencias(String vertice){
        this.existeVerticeOrThrow(vertice);
        if (this.rotulosEmIndices.containsKey(vertice)) {
          int indiceVertice=this.rotulosEmIndices.get(vertice);
          return this.matrizAdjacencia.getAdjcencias(indiceVertice);  
        }
          return null;
        
   }

   public boolean existeVerticeOrThrow(String vertice){
        if(!existeVertice(vertice)){
            throw new IllegalArgumentException("O vertice não existe");
        }
        return true;
   }

   private boolean existeVertice(String vertice){   
     return this.rotulosEmIndices.containsKey(vertice);
   }

   private void criarMatrizAdjacencia(){
        if (this.matrizAdjacencia==null) {
            this.matrizAdjacencia=new MatrizAdjacencia(this.vertices);
        } 
   }

 
   
 
}
