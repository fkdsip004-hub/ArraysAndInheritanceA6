public class NumberUtils {

    private NumberUtils(){}

    public static int[] toArray(int number){
        int[] array = new int[String.valueOf(number).length()];
        String temp = String.valueOf(number);
        for (int i = 0 ; i < temp.length(); i ++){
            array[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
        }

        return array;

    }

    public static int countMatches(int numberA, int numberB){
        int[] array1;
        int[] array2;
        int counter = 0;

        array1 = NumberUtils.toArray(numberA);
        array2 = NumberUtils.toArray(numberB);

        for (int i =0; i < array1.length ; i++){
            if(array1[i] == array2[i] ){
                counter++;
            }
        }
        return counter;
    }

    public static int countIntersect(int numberA, int numberB){
        int[] array1;
        int[] array2;
        int counter = 0;

        array1 = NumberUtils.toArray(numberA);
        array2 = NumberUtils.toArray(numberB);

        for (int testNum : array1) {
            for (int suspect : array2) {
                if (testNum == suspect) {
                    counter++;
                }
            }
        }
        return counter;
    }



}
