public class Knapsack2 {

    static int knapSack(int weightCap, int[] weights, int[] values, int i)
    {
        int index, weight;
        int[][] matrix = new int[i + 1][weightCap + 1];

        for (index = 0; index <= i; index++) {
            for (weight = 0; weight <= weightCap; weight++) {
                if (index == 0 || weight == 0)
                    matrix[index][weight] = 0;
                else if (weights[index - 1] <= weight)
                    matrix[index][weight] = Math.max(
                            values[index - 1] + matrix[index - 1][weight - weights[index - 1]],
                            matrix[index - 1][weight]);
                else {
                    matrix[index][weight] = matrix[index - 1][weight];
                }
            }
        }
        return matrix[i][weightCap];
    }


    public static void main(String[] args) {
        int[] values = { 70, 20, 39, 37, 7, 5, 10 };
        int[] weights = { 31, 10, 20, 19, 4, 3, 6 };
        int weightCap = 50;
        int i = values.length;
        //Knapsack2 myKnapsack = new Knapsack2();
        //System.out.println(myKnapsack.knapSack(weightCap, weights, values, i));
        System.out.println(knapSack(weightCap, weights, values, i));
    }
}