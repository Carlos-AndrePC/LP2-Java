import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lp2g11.biblioteca.*;

public class P3nX {
    Biblioteca biblioteca;
    public static void main(String[] args){
        P3nX progama = new P3nX();
        boolean quersair = false;
        int opc;
        BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
        while(!quersair){
            try {
                System.out.println("Digite 0 para sair: ");
                System.out.println("Digite 1 para manunteção: ");
                System.out.println("Digite 2 para cadastro: ");
                System.out.println("Digite 3 para emprestimo: ");
                System.out.println("Digite 4 para relatorio: ");
                opc = Integer.parseInt(indata.readLine());
                switch(opc){
                    case 0:
                        quersair = true;
                        break;
                    case 1:
                        progama.Manutenção();
                        break;
                    case 2: 
                        progama.Cadastro();
                        break;
                    case 3:
                        progama.Emprestar();
                        break;
                    case 4:
                        progama.Relatorio();
                        break;
                    default:
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Entrada invalida digite uma das opções de baixo");
                System.out.println("Digite 0 para sair: ");
                System.out.println("Digite 1 para manunteção: ");
                System.out.println("Digite 2 para cadastro: ");
                System.out.println("Digite 3 para emprestimo: ");
                System.out.println("Digite 4 para relatorio: ");
                }   
        } 
    }
    public void Manutenção(){

        int opc;
        try {
           
            boolean parasair = false;
            while(!parasair){
                System.out.println("Para voltar  digite 0:");
                System.out.println("Para criar uma nova biboteca digite 1:");
                System.out.println("Para carregar uma biboteca digite 2:");
                System.out.println("Para salvar a biboteca digite 3:");
                BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
               opc = Integer.parseInt(indata.readLine());
                switch(opc){  
                      case 0:
                           parasair = true;
                            break;
                       case 1:
                           biblioteca = new Biblioteca();
                           break;
                        case 2:
                            loadBibioteca();
                            break;
                        case 3:
                           saveBibioteca();
                          break;
                        default:
                            break;
                }
            }
        } 
        catch (Exception e) {
            System.out.println("Entrada invalida digite uma das opções de baixo");
            System.out.println("Para voltar  digite 0:");
            System.out.println("Para criar uma nova biboteca digite 1:");
            System.out.println("Para carregar uma biboteca digite 2:");
            System.out.println("Para salvar a biboteca digite 3:");
        }
    }

    public void loadBibioteca(){
        try {
            biblioteca = new Biblioteca();
            BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nome do arquivo dos livros:");
            String nome = indata.readLine();
            biblioteca.lêArquivo(nome,1);
            System.out.println("Nome do arquivo dos ususarios:");
            nome = indata.readLine();
            biblioteca.lêArquivo(nome,2);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveBibioteca(){
        try {
            biblioteca.salvaArquivos(biblioteca.getLivros(), "BibiotecaLivros.dat");
            biblioteca.salvaArquivo(biblioteca.getUsuarios(), "BibiotecaUsuarios.dat");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Cadastro(){
        BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
        int opc;
        boolean quersair = false;
        while(!quersair){
            try {
                System.out.println("Para voltar  digite 0:");
                System.out.println("Para cadastar Usuarios digite 1:");
                System.out.println("Para cadastar Livros digite 2:");
                System.out.println("Para salvar em arquivos digite 3:");
                opc = Integer.parseInt(indata.readLine());
                switch (opc) {
                    case 0:
                        quersair = true;
                        break;
                    case 1:
                        CadastarUsuarios();
                        break;
                    case 2:
                        CadastarLivros();
                        break;
                    case 3:
                        SalvarArquivos();
                        break;
                    default:
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("valor invalido");
            }
        }
    }
    public void CadastarUsuarios(){
            BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
            
            boolean quersair = false;
            String local = "";
            while(!quersair){
                try{
                    System.out.println("Digite o endereço:");
                    local = indata.readLine();
                    quersair = true;
                }
                catch(Exception e){
                    System.out.println("Valor invalido");
                }
            }
            int cod = -1;
            quersair = false;
            while(!quersair && cod != -1){ 
                try{
                    System.out.println("Digite o codigo(Inteiro):");
                    cod = Integer.parseInt(indata.readLine());
                    if(biblioteca.getUsuário(cod)==null){
                        quersair = true;
                    }
                    else{
                        cod = -1;
                        System.out.println("Codigo ja esta sendo utilizado");
                    }
                }
                catch(IOException e){
                    System.out.println("Valor invalido");
                }
                catch(UsuárioNaoCadastradoEx e){
                    System.out.println(e);
                }
            }
            Usuário novo = new Usuário(local, cod);
            quersair = false;
            while(!quersair){
                try{
                    System.out.println("Digite nome:");
                    novo.setNome(indata.readLine());
                    quersair = true;
                }
                catch(Exception e){
                    System.out.println("Valor invalido");
                }
            }
            quersair = false;
            while(!quersair){
                try{
                    System.out.println("Digite sobre nome:");
                    novo.setSobreNome(indata.readLine());
                    quersair = true;
                }
                catch(Exception e){
                    System.out.println("Valor invalido");
                }
            }
            int dia = -1;
            quersair = false;
            while(!quersair){
                try{
                    System.out.println("Digite o dia do nascimento:");
                    dia = Integer.parseInt(indata.readLine());
                    if(dia<=31 && dia>=1){
                        quersair = true;
                    }
                    else{
                        System.out.println("Não é um dia");
                    }

                }
                catch(Exception e){
                    System.out.println("Valor invalido");
                }
            }
            int mes = -1;
            quersair = false;
            while(!quersair){
                try{
                    System.out.println("Digite o mes do nascimento:");
                    mes = Integer.parseInt(indata.readLine());
                    if(mes<=12 && mes>=1){
                        quersair = true;
                    }
                    else{
                        System.out.println("Não é um mes");
                    }
                }
                catch(Exception e){
                    System.out.println("Valor invalido");
                }
            }
            int ano = -1;
            quersair = false;
            while(!quersair){
                try{
                    System.out.println("Digite o ano do nascimento:");
                    ano = Integer.parseInt(indata.readLine());
                    if(ano<=2023 && ano>=1908){
                        quersair = true;
                    }
                    else{
                        System.out.println("Não é um ano");
                    }
                }
                catch(Exception e){
                    System.out.println("Valor invalido");
                }
            }
            novo.setDataNasc(dia, mes, ano);
            long numCPF = -1;
            quersair = false;
            while(!quersair){
                try{
                    System.out.println("Digite o cpf:");
                    numCPF = Long.parseLong(indata.readLine());
                    quersair = true;
                }
                catch(Exception e){
                    System.out.println("Valor invalido");
                }
            }
            novo.setCPF(numCPF);
            quersair = false;
            float peso = -1;
            while(!quersair){
                try{
                    System.out.println("Digite o peso:");
                    peso = Float.parseFloat(indata.readLine());
                    quersair = true;
                }
                catch(Exception e){
                    System.out.println("Valor invalido");
                }
            }
            novo.setPeso(peso);
            float altura = -1;
            quersair = false;
            while(!quersair){
                try{
                    System.out.println("Digite a altura: ");
                    altura = Float.parseFloat(indata.readLine());
                    quersair = true;
                }
                catch(Exception e){
                    System.out.println("Valor invalido");
                }
            }
            novo.setAltura(altura);
            biblioteca.cadastraUsuário(novo);
    }
    
    public void CadastarLivros(){
        BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
        boolean quersair = false;
        String nome = "";
        while(!quersair){
            try {
                System.out.println("Digite o nome do Livro: ");
                nome = indata.readLine();
                if(nome.isEmpty()) System.out.println("Não pode ser vazio");
                else quersair = true;
            }  
            catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        quersair = false;
        String cod = "";
        while(!quersair){
            try {
                System.out.println("Digite o codigo do Livro: ");
                cod = indata.readLine();
                if(biblioteca.getLivro(cod)==null) quersair = true;
                else System.out.println("Codigo ja esta sendo utilizado");
            } 
            catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        String categoria = "";
        quersair = false;
        while(!quersair){
            try {
                System.out.println("Digite a categoria do Livro: ");
                categoria = indata.readLine(); 
                quersair = true;
            } 
            catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        quersair = false;
        int qua = -1;
        while(!quersair){
            try {
                System.out.println("Digite a quantidade total de copias do Livro: ");
                qua = Integer.parseInt(indata.readLine());
                if(qua<=0) System.out.println("Não pode ser menor que 1: ");
                quersair = true;
            }   
            catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        int empre = -1;
        quersair = false;
        while(!quersair){
            try {
                System.out.println("Digite a quantidades de emprestados atualmente Livro: ");
                empre = Integer.parseInt(indata.readLine());
                if(empre<0) System.out.println("Não pode ser menor que 0");
                else if(empre>qua) System.out.println("Não der mais livro emprestado do que total");
                else quersair = true;
            } 
            catch (Exception e) {
                System.out.println("Valor invalido");
            } 
        }
          
        Livro novo = new Livro(nome, cod, categoria, qua, empre);
        biblioteca.cadastraLivro(novo);
    }

    public void SalvarArquivos(){
        System.out.println("Para salvar os livros digite 1: ");
        System.out.println("Para salvar os usuraios digete 2: ");
        try {
            BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
            int opc = Integer.parseInt(indata.readLine());
            if(opc == 1){
                System.out.println("Digiteo nome para o arquivo dos livros(nao esqueca .tipo):  ");
                String nome = indata.readLine();
                biblioteca.salvaArquivos(biblioteca.getLivros(), nome);
            }
            else if (opc == 2){
                System.out.println("Digiteo nome para o arquivo dos usuarios(nao esqueca .tipo):  ");
                String nome = indata.readLine();
                biblioteca.salvaArquivo(biblioteca.getUsuarios(), nome);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Emprestimo(){
        BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));System.out.println("Para voltar  digite 0:");
        System.out.println("Para cadastar livro digite 1:");
        System.out.println("Para fazer um emprestimo digite 2:");
        System.out.println("Para Fazer uma devolução digite 3:");
        int opc;
        boolean quersair = false;
        while(!quersair){
            try {
                opc = Integer.parseInt(indata.readLine());
                switch(opc){
                    case 0:
                        quersair = true;
                        break;
                    case 1:
                        System.out.println(biblioteca.imprimeLivros());
                        break;
                    case 2:
                        Emprestar();
                        break;
                    case 3:
                        Devolver();
                        break;
                    default:
                        break;
                }
            } 
            catch (Exception e) {
                System.out.println(e);
            }
        }
        
    }
    public void Emprestar(){
        try {
            BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite o codigo do usuario:");
            Usuário usu = biblioteca.getUsuário(Integer.parseInt(indata.readLine()));
            System.out.println("Digite o codigo do livro: ");
            Livro liv = biblioteca.getLivro(indata.readLine());
            biblioteca.emprestaLivro(usu, liv);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Devolver(){
        try {
            BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite o codigo do usuario:");
            Usuário usu = biblioteca.getUsuário(Integer.parseInt(indata.readLine()));
            System.out.println("Digite o codigo do livro: ");
            Livro liv = biblioteca.getLivro(indata.readLine());
            biblioteca.devolveLivro(usu, liv);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Relatorio(){
        BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
        int opc;
        boolean quersair = false;
        while(!quersair){
            System.out.println("Para voltar  digite 0:");
            System.out.println("Para listar todos os Livros digite 1:");
            System.out.println("Para listar todos os Usuarios digite 2:");
            System.out.println("Para lista especificamento 1 Livro digite 3:");
            System.out.println("Para lista especificamento 1 Usuarios digite 4:");
            try {
            opc = Integer.parseInt(indata.readLine());
            switch(opc){
                case 0:
                    quersair = true;
                    break;
                case 1:
                    System.out.println(biblioteca.imprimeLivros());
                    break;
                case 2:
                    System.out.println(biblioteca.imprimeUsuários());
                    break;
                case 3:
                    System.out.println("Digite o codigo do Livro: ");
                    System.out.println(biblioteca.getLivro(indata.readLine()));
                    break;
                case 4:
                    System.out.println("Digite o codigo do Usuario: ");
                    System.out.println(biblioteca.getUsuário(Integer.parseInt(indata.readLine())));
                    break;
                default:
                    break;
                }
            } 
            catch(UsuárioNaoCadastradoEx e){
                System.out.println(e);
            }
            catch(LivroNaoCadastrado e){
                System.out.println(e);
            }
            catch(NumberFormatException e){
                System.out.println("Não é um numero");
            }
            catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
    }
}