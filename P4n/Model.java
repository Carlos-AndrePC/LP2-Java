
import java.util.Calendar;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author carlos
 */
public class Model extends AbstractTableModel{
    private String coluna[] = new String[]{"Nome","Data","Altura","Peso","IMC","Genero"};
    private MinhaListaOrdenavel ordem = new MinhaListaOrdenavel();
    private int criteiro = 7;
    public Model(){
       ordena(criteiro);
    }
    public Model(int i){
       ordena(i);
    }

    @Override
    public String getColumnName(int i) {
        return coluna[i];
    }
    
    @Override
    public int getRowCount() {
        return ordem.getLista().size();
    }

    @Override
    public int getColumnCount() {
        return coluna.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return ordem.getLista().get(linha).getNome() + " " + ordem.getLista().get(linha).getSobreNome();
            case 1:
                return ordem.getLista().get(linha).getDataNasc().get(Calendar.DATE)+"/"+ ordem.getLista().get(linha).getDataNasc().get(Calendar.MONTH)+"/"+ordem.getLista().get(linha).getDataNasc().get(Calendar.YEAR);
            case 2:
                return ordem.getLista().get(linha).getAltura();
            case 3:
                return ordem.getLista().get(linha).getPeso();
            case 4:
                return PessoaIMC.calculaIMC(ordem.getLista().get(linha).getAltura(), ordem.getLista().get(linha).getPeso());
            case 5:
                if(ordem.getLista().get(linha) instanceof Mulher){
                    return "Mulher";
                }
                else return "Homem";
        }
        return null;
    }
    public void setCriteiro(int criteiro) {
        this.criteiro = criteiro;
    }
    public int getCriteiro() {
        return criteiro;
    }
   public void ordena(int criterio){
        this.criteiro = criterio;
        ordem.ordena(criterio);
        this.fireTableDataChanged();
    }
            
}
