
package ArrayExceptions;


public class ArrayExcaptions {
    
    public void sumArrays() {
        int[] eersteArray = {1, 2, 3, 4, 5}; 
        int[] tweedeArray = {1, 2, 3, 4, 5}; 
        
        int sum = 0; 
        
        if(eersteArray.length == tweedeArray.length) {
            for(int number : eersteArray) {
                sum = sum + number; 
            }

            for(int number : tweedeArray) {
                sum = sum + number;
            }

            System.out.println("Sum of both arrays = " + sum);
        }
        else {
            System.out.println("Error");
        }
    }
    
    //implement custom try and catch ff opzoeken alles! 
}
