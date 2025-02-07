//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {6,7,8,9};
        int[] array3 = new int[array1.length+array2.length];

        for (int i = 0; i<array1.length; i++){
            array3[i] = array1[i];
        }

        for (int j=0; j<array2.length; j++){
            array3[array1.length+j] = array2[j];
        }
        System.out.println("Merged Array: ");
        for (int element: array3){
            System.out.print(element+" ");
        }
    }
}