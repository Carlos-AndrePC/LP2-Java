import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2nX {
    MinhaListaOrdenavel lista;
    public static void main(String[] args){
        P2nX meuprogama = new P2nX();
        if(meuprogama.escolha()){
            meuprogama.encherLista();
            meuprogama.Maneiraordena();
            meuprogama.printLista();
        }
        
    }
    //Procedimento que enche o ArrayList
    public void encherLista(){
        lista = new MinhaListaOrdenavel();
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
    //Função para escolher entre printar(1) e sair(2)
    public boolean escolha(){
        System.out.println("1-Para para o print da lista e ordenar");
        System.out.println("2-Sair");
        int n =0;
        while(n!=1 && n!= 2){
            try{
                System.out.println("Digite sua opção: ");
                BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
                n = Integer.parseInt(indata.readLine());
            }catch(Exception e){
                
            }
        }
        if(n==1)return true;
        else return false;
    }
    public void Maneiraordena(){
        System.out.println("1-Altura Cresente");
        System.out.println("2-Altura Decresente");
        System.out.println("3-Primeiro Mulheres");
        System.out.println("4-Primeiro Homens");
        System.out.println("5-IMC Cresente");
        System.out.println("6-IMC Decresente");
        System.out.println("7-Alfabeto A-Z");
        System.out.println("8-Alfabeto Z-A");
        System.out.println("9-Peso Cresente");
        System.out.println("10-Peso DEcresente");
        System.out.println("11-Idade Cresente");
        System.out.println("12-Idade DEcresente");
        int ordem = 0;
        while(!(ordem>=1 && ordem<=13)){
            try{
                System.out.println("Digite sua opção: ");
                BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
                ordem = Integer.parseInt(indata.readLine());
            }
            catch(Exception e){}
        }
        lista.lista = lista.ordena(ordem);
    }
    public void printLista(){
        System.out.println(lista);
    }
}
