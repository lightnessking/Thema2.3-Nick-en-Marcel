
package ArrayExceptions;


public class ArrayExcaptions {
    
    public static void sumArrays(int[] array1, int[] array2) throws ArrayMismatchException{
            if(array1.length == array2.length) {
                int[] array3 = new int[array1.length];
                for(int number : array1) {
                    array3[number - 1] = array1[number - 1] + array2[number - 1];
                    System.out.println("The new array contains: " + array3[number - 1] + " at index number: " + (number-1));
                }            
            }else{
                throw new ArrayMismatchException("Array length mismatch!");
            }
    }
    
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5}; 
        int[] array2 = {1, 2, 3, 4}; 
        
        try{
            sumArrays(array1, array2);
        } catch(Exception e) {
            System.out.println(e);
        }
    } 
}


