/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Scanner;

/**
 *
 * @author Mike
 */
public class Audio_Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
         Scanner scan = new Scanner(System.in);
        System.out.println("Enter 1 for starting as Server or 2 for starting as Client");
        String choice = scan.next();
        if(choice.equals("1")){
           RTPServer.main(args);
        }
        
        else if(choice.equals("2")){
            String[] ip = {"rtp://192.168.2.1:8888"};
            RTPClient.main(ip);
            
          
        
        }
        
        else{
            System.out.println("The entered String was not 1 or 2");
        }
            
        
    }
    
}
