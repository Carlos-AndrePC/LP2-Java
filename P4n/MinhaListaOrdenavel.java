import java.util.*;

public class MinhaListaOrdenavel{
    private ArrayList <PessoaIMC> lista;
    public Comparator<Object> pesoC = new Comparator<Object> () {
        public int compare (Object p1, Object p2){ 
            float pf1, pf2;
            pf2 = ((PessoaIMC) p2).getPeso();
            pf1 = ((PessoaIMC) p1).getPeso();
            return (int)Math.round (pf1-pf2);
        }
    };
    public Comparator<Object> nomeC = new Comparator<Object>() {
        public int compare (Object p1, Object p2){ 
            String pf1, pf2;
            pf2 = ((PessoaIMC) p2).getNome();
            pf1 = ((PessoaIMC) p1).getNome();
            int comparar = pf1.compareToIgnoreCase(pf2);
            if(comparar == 0){
                pf2 = ((PessoaIMC) p2).getSobreNome();
                pf1 = ((PessoaIMC) p1).getSobreNome();
                comparar = pf1.compareToIgnoreCase(pf2);
            }
            return comparar;
        }
    };
    public Comparator<Object> alturaC = new Comparator<Object> () {
        public int compare (Object p1, Object p2){ 
            float pf1, pf2;
            pf2 = ((PessoaIMC) p2).getAltura();
            pf1 = ((PessoaIMC) p1).getAltura();
             if(pf1>pf2){
                return 1;
            }
            else return -1;
        }
    };
    public Comparator<Object> imcC = new Comparator<Object> () {
        public int compare (Object p1, Object p2){ 
            float pf1, pf2;
            pf2 = PessoaIMC.calculaIMC(((PessoaIMC) p2).getAltura(),((PessoaIMC) p2).getPeso());
            pf1 = PessoaIMC.calculaIMC(((PessoaIMC) p1).getAltura(),((PessoaIMC) p1).getPeso());
            return Math.round(pf1-pf2);
        }
    };
    public Comparator<Object> generoC = new Comparator<Object> () {
        public int compare (Object p1, Object p2){ 
            if(p1 instanceof Mulher){
                if(p2 instanceof Mulher){
                    return 0;
                }
                else return -1;
           }
           else{
                if(p2 instanceof Mulher){
                    return 1;
                }
                else return 0;
           }
        }
    };
    public Comparator<Object> dataC = new Comparator<Object> () {
        public int compare (Object p1, Object p2){ 
            int pf1 ,pf2;
            pf1 = ((PessoaIMC)p1).getDataNasc().get(Calendar.YEAR);
            pf2 = ((PessoaIMC)p2).getDataNasc().get(Calendar.YEAR);
            if(pf1-pf2==0){
                pf1 = ((PessoaIMC)p1).getDataNasc().get(Calendar.MONTH);
                pf2 = ((PessoaIMC)p2).getDataNasc().get(Calendar.MONTH);
                if(pf1-pf2==0){
                    pf1 = ((PessoaIMC)p1).getDataNasc().get(Calendar.DATE);
                    pf2 = ((PessoaIMC)p2).getDataNasc().get(Calendar.DATE);
                }
            }
            return (pf2 -pf1);
        }
    };
    public void add(PessoaIMC p){
        lista.add(p);
    }
    public MinhaListaOrdenavel(){
        lista = new ArrayList<PessoaIMC>();
        lista.add(new Homem("Carlos", "Campos", 29, 1, 2004, 0, 1.83f, 60f));
        lista.add(new Mulher("Alexandra", "Pinheiro", 19, 6, 1974, 0, 1.74f, 80f));
        lista.add(new Homem("Fulano", "Silva", 31, 12, 1978, 0, 1.63f, 78.4f));
        lista.add(new Mulher("Fulana", "Dias", 1, 1, 2011, 0, 1.40f, 40f));
        lista.add(new Homem("Pedro", "Rosa", 13, 5, 1986, 0, 1.95f, 120.7f));
        lista.add(new Mulher("Maria", "Ludis", 6, 7, 1956, 0, 1.55f, 78.4f));
        lista.add(new Homem("Enzo", "Carvalho", 23, 6, 1997, 0, 2.10f, 150.8f));
        lista.add(new Mulher("Roseia", "Lima", 5, 3, 1954, 0, 1.46f, 54.6f));
        lista.add(new Homem("Gergio", "Oliveira", 24, 9, 2000, 0, 1.87f, 110.2f));
        lista.add(new Mulher("Valentina", "Gomes", 8, 10, 2009, 0, 1.54f, 43.8f));
    }
    public PessoaIMC get(int i){
        return lista.get(i);
    }

    public void ordena(int criterio){
        switch(criterio){
            case 1:
                Collections.sort(lista, alturaC);
                break;
            case 2:
                Collections.sort(lista, alturaC.reversed());
                break;
            case 3:
                Collections.sort(lista,generoC);
                break;
            case 4:
                Collections.sort(lista, generoC.reversed());
                break;
            case 5:
                Collections.sort(lista, imcC);
                break;
            case 6:
                Collections.sort(lista,imcC.reversed());
                break;
            case 7:
                Collections.sort(lista, nomeC);
                break;
            case 8:
                Collections.sort(lista, nomeC.reversed());
                break;
            case 9:
                Collections.sort(lista, pesoC);
                break;
            case 10:
                Collections.sort(lista, pesoC.reversed());
                break;
            case 11:
            Collections.sort(lista, dataC);
                break;
            case 12:
                Collections.sort(lista, dataC.reversed());
                break;
            default:
                break;
        }
    }

    public ArrayList<PessoaIMC> getLista() {
        return lista;
    }
    public void setLista(ArrayList<PessoaIMC> lista) {
        this.lista = lista;
    }
    public String toString(){
        String line ="";
        for(int i =0;i<Pessoa.numPessoas();i++){
            line+= "----------------------------------------------\n";
            line+=lista.get(i)+"\n";
            line+="----------------------------------------------\n";
        }
        return line;
    }
}