import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class upvotes{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input;
            input=br.readLine();
            String[] spl = input.split(" ");
			int[] arr = new int[Integer.parseInt(spl[0])];
            int k = Integer.parseInt(spl[1]);
            input=br.readLine();
            String[] spl2 = input.split(" ");
            for(int i = 0; i < spl2.length; i++)
                arr[i] = Integer.parseInt(spl2[i]);
            
            for(int i = 0; i < arr.length-k+1; i++)
                System.out.println(diff2(arr,i,i+k));
			
        }catch(IOException io){
            io.printStackTrace();
        }
        
    }
    
    public static int diff2(int[] arr, int start, int end){
        int inc = 0, dec = 0, inc_add = 0, dec_add = 0;
        
        for(int i = 1; i < end - start; i++){
            inc = arr[i+start]>=arr[i+start-1]?(1+inc):0;
            inc_add+=inc;
            
            dec = arr[i+start]<=arr[i+start-1]?(1+dec):0;
            dec_add+=dec;
        }
        return inc_add - dec_add;
        
    }
    
    public static int diff(int[] arr, int start, int end){
        int[] inc = new int[end-start];
        int[] dec = new int[end-start];
        inc[0] = 0;
        dec[0] = 0;
        for(int i = 1; i < end - start; i++){
            inc[i] = arr[i+start]>=arr[i+start-1]?(1+inc[i-1]):0;
            dec[i] = arr[i+start]<=arr[i+start-1]?(1+dec[i-1]):0;
        }
        
        int[] inc_add = new int[inc.length];
        int[] dec_add = new int[inc.length];
        inc_add[0] = inc[0];
        dec_add[0] = dec[0];
        for(int i = 1; i < end-start; i++){
            inc_add[i] = inc_add[i-1]+inc[i];
            dec_add[i] = dec_add[i-1]+dec[i];
        }
        return inc_add[end-start-1]-dec_add[end-start-1];
    }
}