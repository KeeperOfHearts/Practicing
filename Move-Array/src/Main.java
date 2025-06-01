public class Main {
    public static void main(String[] args) {
            int[] startingArray = new int[]{1,2,3,4,5,6,7,8,9,10};

            int move = 4;

            int[] result = new int[startingArray.length];

            for (int i = 0;i < startingArray.length;i++) {
                int newIndex = i + move;
                if (newIndex > result.length - 1) newIndex = newIndex % result.length;
                result[newIndex] = startingArray[i];
            }

            System.out.println("-----------------------------");
            System.out.println("{ ");
            for (int i : startingArray) {
                System.out.print(i + ", ");
            }
            System.out.println("}");
            System.out.println("-----------------------------");
            System.out.println("{ ");
            for (int i : result) {
                System.out.print(i + ", ");
            }
            System.out.println("}");
    }
}