package lp2g11.biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Usuário extends Pessoa implements Serializable{
    private String endereço;
    private int códigoUsuário;
    private ArrayList<Emprest> hist;
    public Usuário(String local, int numero){
        super();
        hist = new ArrayList<Emprest>();
        endereço = local;
        códigoUsuário = numero;
        
    }
    public void addLivroHist(GregorianCalendar dataEnt,GregorianCalendar dataDev ,String livro){
        hist.add(new Emprest(dataEnt, dataDev ,livro));
    }
    public int getCódigoUsuário() {
        return códigoUsuário;
    }
    public String getEndereço() {
        return endereço;
    }
    public String toString(){
        String line = super.toString()+"\nEndereço: " + endereço +"\nUsuario:" + códigoUsuário+"\nHistorico:";
        for(int i=0;i<hist.size();i++){
            line += hist.get(i);
        }
        return line;
    }
}