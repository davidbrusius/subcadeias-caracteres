/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subcadeiascaracteres;

/**
 *
 * @author 
 */
class Subcadeia {
    private int posicao;
    private String caracteresSubcadeia;
    private String padraoP;
    private int distancia;

    public Subcadeia(int posicao, String caracteresSubcadeia, String padraoP, int distancia) {
        this.posicao = posicao;
        this.caracteresSubcadeia = caracteresSubcadeia;
        this.padraoP = padraoP;
        this.distancia = distancia;
    }
    
    @Override
    public String toString() {
        StringBuilder subcadeia = new StringBuilder();
        subcadeia.append("Posição S: ").append(this.getPosicao());
        subcadeia.append(" Padrão T: ").append(this.getCaracteresSubcadeia());
        subcadeia.append(" Padrão P: ").append(this.getPadraoP());
        subcadeia.append(" Distância: ").append(this.getDistancia());
        return subcadeia.toString();   
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getCaracteresSubcadeia() {
        return caracteresSubcadeia;
    }

    public void setCaracteresSubcadeia(String caracteresSubcadeia) {
        this.caracteresSubcadeia = caracteresSubcadeia;
    }
    
    public String getPadraoP() {
        return padraoP;
    }

    public void setPadraoP(String padraoP) {
        this.padraoP = padraoP;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
}
