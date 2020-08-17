import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LinearSort {

    public static boolean linearSort(int[] array, int key){
        for( int element : array ){
            if( element == array[key])
                return true;
        }

        return false;
    }
    public static void main(String[] args) throws IOException{
        int[] input = {1,2,3,4,5,6};

        int number;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the number");
        number = Integer.parseInt(in.readLine());

        if( linearSort( input, number))
            System.out.println("The element "+number+" is found");
        else
            System.out.println("The element "+number+" is not found");
    }
}