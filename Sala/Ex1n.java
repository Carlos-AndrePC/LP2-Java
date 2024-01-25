import java.io.*;
class Ex1n{
    public static void main(String[] args){
        int[] letterCount = new int[26];
        int index;        
        int count = 0;
        BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        System.out.println("Digite um frase: ");
        try{
            line  = inData.readLine();
        } catch(IOException e){
            System.err.println("Fudeu");
        }
        while (line.isEmpty() || count ==0) // Enquando houver linhas a serem lidas
        { 
            if(count == 0){
                for (int location =0; location<line.length(); location++) { 
                    char letter = line.charAt(location);
                    if ((letter  >= 'A' && letter <= 'Z') || (letter  >= 'a' && letter <= 'z')){ 
                        // 2o truque
                        index = (int)Character.toUpperCase(letter) - (int) 'A';	
                        letterCount[index]++;
                    }
                }
                count++;
            }
            for (index = 0; index < letterCount.length; index++){
                System.out.println("The total number of " 
                + (char) (index + (int) 'A')
                + ("'s is ") 
                + letterCount[index]);
            }
            System.out.println("Se quiser ver denovo digeite Enter se nao qualquer coisa : ");
            try{
                line  = inData.readLine();
            } catch(IOException e){
                System.err.println("Fudeu");
            }
        }    
    }
}
