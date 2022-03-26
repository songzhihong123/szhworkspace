
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words1);
        System.out.println("Total words: "+words1.size());

        long startTime = System.nanoTime();

        BSTSet<String> set1 = new BSTSet<>();
        for(String word:words1){
            set1.add(word);
        }

        long endTime = System.nanoTime();
        System.out.println("Total different words: "+ set1.getSize()+ "耗时："+ (endTime - startTime) / 1000000000.0);


        System.out.println("================================");

        startTime = System.nanoTime();
        AVLSet<String> set2 = new AVLSet<>();
        for(String word:words1){
            set2.add(word);
        }
        endTime = System.nanoTime();
        System.out.println("Total different words: "+ set2.getSize()+ "耗时："+ (endTime - startTime) / 1000000000.0);






    }
}
