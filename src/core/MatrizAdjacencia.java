package core;
import java.util.*;
public class MatrizAdjacencia {
    private int matriz[][];
    private List<Vertice> vertices;
    private int qtVertices;

    public MatrizAdjacencia(List<Vertice> vertices){
        this.vertices=vertices;
        this.qtVertices=vertices.size();
        this.matriz=new int[this.qtVertices][this.qtVertices];
        inicializarMatriz();
    }

    public  void inicializarMatriz(){
        for(int i=0;i<=matriz.length;i++){
            for(int j=0;j<=matriz.length;j++){
                matriz[i][j]=0;
            }
        }
        
    }
    
    public  void adicionarAresta(int indiceVerticeInicial,int indiceVerticeFinal){
        Vertice verticeInicial=this.vertices.get(indiceVerticeInicial);
        Vertice verticeFinal=this.vertices.get(indiceVerticeFinal);
        if (indiceVerticeInicial==indiceVerticeFinal) {
            matriz[indiceVerticeInicial][indiceVerticeInicial]=1;
        } else {
            matriz[indiceVerticeInicial][indiceVerticeFinal]=1;
            verticeInicial.addGrau();
            matriz[indiceVerticeFinal][indiceVerticeInicial]=1;
            verticeFinal.addGrau();
        }
    }
    public List<Vertice> getAdjcencias(int indiceVertice){
        List<Vertice> vertices=new ArrayList<>();
        for(int j=0;j<=matriz.length;j++){
            if(matriz[indiceVertice][j]==1){
                vertices.add(this.vertices.get(j));
            }
        }
    return vertices;

        
    }



}
