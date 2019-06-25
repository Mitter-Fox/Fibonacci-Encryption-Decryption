import java.util.*;
import java.lang.*;
import java.io.*;

class FiboEncrptDecrpt{
    
    static void fibo(int fibo[], int n){
        int a = 1, b = 1;
        if(n == 1)
            fibo[0] = 1;
        else if(n == 2){
            fibo[0] = 1;
            fibo[1] = 1;
        }
        else{
            fibo[0] = 1;
            fibo[1] = 1;
            for(int i = 2; i<n; i++){
                fibo[i] = a + b;
                a = b;
                b = fibo[i];
            }
        }
    }
    
    public static StringBuffer fibonacciEncryption(int fibo[], StringBuffer s, String password){
        int c = 0;
        String v="";
        s = (s.reverse()).append(password);
        fibo(fibo, password.length());
        for(int j = 0; j<password.length(); j++){
            for(int i = 0; i<s.length(); i++){
                if(i%2 == 0){
                    c = (int)s.charAt(i) + fibo[j];
                    if((Character.isLowerCase(s.charAt(i)) && c>122) || (Character.isUpperCase(s.charAt(i)) && c>90))
                        c -= 26;
                    v = v+(char)c;
                    s = s.replace(i,i+1,v);
                    v = "";
                }
                else{
                    c = (int)s.charAt(i) - fibo[j];
                    if((Character.isLowerCase(s.charAt(i)) && c<97) || (Character.isUpperCase(s.charAt(i)) && c<65))
                        c += 26;
                    v = v+(char)c;
                    s = s.replace(i,i+1,v);
                    v = "";
                }
            }
        }
        return s;
    }
    
    public static StringBuffer fibonacciDecryption(int fibo[], StringBuffer s, String password){
        int c = 0;
        String v="";
        fibo(fibo, password.length());
        for(int j = 0; j<password.length(); j++){
            for(int i = 0; i<s.length(); i++){
                if(i%2 == 0){
                    c = (int)s.charAt(i) - fibo[j];
                    if((Character.isLowerCase(s.charAt(i)) && c<97) || (Character.isUpperCase(s.charAt(i)) && c<65))
                        c += 26;
                    v = v+(char)c;
                    s = s.replace(i,i+1,v);
                    v = "";
                }
                else{
                    c = (int)s.charAt(i) + fibo[j];
                    if((Character.isLowerCase(s.charAt(i)) && c>122) || (Character.isUpperCase(s.charAt(i)) && c>90))
                        c -= 26;
                    v = v+(char)c;
                    s = s.replace(i,i+1,v);
                    v = "";
                }
            }
        }
        StringBuffer msg = new StringBuffer("");
        for(int i = 0; i<s.length() - password.length(); i++)
            msg.append(s.charAt(i));    
        s = msg;
        s.reverse();
        return s;
    }
    
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your message: ");
        String message = sc.nextLine();
        StringBuffer s = new StringBuffer(message);
        StringBuffer s1 = new StringBuffer(message);
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        int fibo[] = new int[password.length()];
        System.out.println("Your message: "+message);
        s = fibonacciEncryption(fibo, s, password);
        System.out.println("Encrypted message: "+s);
        s = fibonacciDecryption(fibo, s, password);
        System.out.println("Decrypted message: "+s);
        if((s.toString()).equals(s1.toString()))
            System.out.println("Message is Secured.");
        else
            System.out.println("Message is NOT Secured.");
    }
}