import java.util.Scanner;
import java.util.ArrayList;


public class PhotoLineups {

   public static void printAllPermutations(ArrayList<String> permList, ArrayList<String> nameList) {
   int i; 
   String temp;
      if(nameList.size() == 0){
         for(i = 0; i < permList.size(); i++){
            if(i + 1 == permList.size()){
               System.out.println(permList.get(i));
            }
            else{
               System.out.print(permList.get(i) + ", ");
            }
         }
     }

      else{
         for(i = 0; i < nameList.size(); i++){
            temp = nameList.get(i);
            nameList.remove(i);
            permList.add(temp);
            printAllPermutations(permList, nameList);
            nameList.add(i, temp);
            permList.remove(temp);
         }
      }
   }
   public static void main(String[] args) {
      //input names, once -1 is added to input, program prints all combinations of inputted names to output
         try (Scanner scnr = new Scanner(System.in)) {
            ArrayList<String> nameList = new ArrayList<String>();
            ArrayList<String> permList = new ArrayList<String>();
            String name = scnr.next();
   
            while(name.equals("-1") != true){
               nameList.add(name);
               name = (String)scnr.next();
            }
    
            printAllPermutations(permList, nameList);
         }
     }
}