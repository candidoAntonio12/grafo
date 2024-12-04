package core;

public class Vertice{
    private String rotulo;
    private int grau;

    public Vertice(String rotulo) throws Exception{
        boolean isRotuloNullOrBlank= (rotulo==null || rotulo!=null && "".equals(rotulo.trim()));
        if(isRotuloNullOrBlank){
            	throw new Exception("Não é permitido a inclusão de vértices vazios com rotulo em branco");
        }
        this.rotulo=rotulo;

    }
    
    public String getRotulo(){
        return this.rotulo;
    }
    public int getGrau(){
        return this.grau;
    }
    
    public void addGrau(){
         this.grau++;
    }

}
