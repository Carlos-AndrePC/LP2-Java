package lp2g11.biblioteca;

import java.util.GregorianCalendar;
import java.util.Calendar;

public class Emprest {
    private GregorianCalendar dataEmprestimo;
    private GregorianCalendar dataDevolução;
    private String livro;

    public Emprest(GregorianCalendar dataEnt, GregorianCalendar dataDev,String codigo){
        this.dataEmprestimo = dataEnt;
        dataDevolução = dataDev;
        livro = codigo;
    }
    public GregorianCalendar getDataDevolução() {
        return dataDevolução;
    }
    public String getLivro() {
        return livro;
    }
    public GregorianCalendar getDataEmprestimo() {
        return dataEmprestimo;
    }
    public String toString(){
        return "\n"+"Livro"+ livro + "\nRetirou:" + dataEmprestimo.get(Calendar.DATE)+"/"+dataEmprestimo.get(Calendar.MONTH)+"/"+dataEmprestimo.get(Calendar.YEAR)+"\nDevolve:"+ dataDevolução.get(Calendar.DATE)+"/"+dataDevolução.get(Calendar.MONTH)+"/"+dataDevolução.get(Calendar.YEAR);
    }
}
