/**
Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 **/
class AverageOfSubarrayOfSizeK{

    public static double[] findAverages(int[] arrays, int K) {
        double sum = 0;
        double[] res = new double[arrays.length-K+1];
        for( int i=0; i< arrays.length; i++){
            sum += arrays[i];
            if( i>= (K-1)) {
                res[i - (K-1)] = sum / K;
                sum -= arrays[i-K+1];
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[]  input = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K=5;
        double[] res = findAverages(input, K);

        System.out.println("The output is ");
        for( int i=0; i< res.length; i++){
            System.out.println(res[i]);
        }
    }
}