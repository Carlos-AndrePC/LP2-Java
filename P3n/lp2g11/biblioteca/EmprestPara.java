package lp2g11.biblioteca;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EmprestPara {
    private GregorianCalendar dataEmprestimo;
    private GregorianCalendar dataDevolução;
    private int codigoUsuario;

    public EmprestPara(GregorianCalendar dataEntrega, GregorianCalendar datadevolve, int codigo){
        this.dataEmprestimo = dataEntrega;
        this.dataDevolução = datadevolve;
        codigoUsuario = codigo;
    }
    public GregorianCalendar getDataEmprestimo() {
        return dataEmprestimo;
    }
    public GregorianCalendar getDataDevolução() {
        return dataDevolução;
    }
    public int getCodigoUsuario() {
        return codigoUsuario;
    }
    public String toString(){
        return "\n"+"Codigo do Usuario:"+ codigoUsuario + "\nRetirou:" + dataEmprestimo.get(Calendar.DATE)+"/"+dataEmprestimo.get(Calendar.MONTH)+"/"+dataEmprestimo.get(Calendar.YEAR)+"\nDevolve:"+ dataDevolução.get(Calendar.DATE)+"/"+dataDevolução.get(Calendar.MONTH)+"/"+dataDevolução.get(Calendar.YEAR);    }
}