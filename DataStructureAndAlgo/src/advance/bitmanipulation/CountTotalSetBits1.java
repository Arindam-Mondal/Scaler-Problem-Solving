package advance.bitmanipulation;

/**
 * For more optimization check : CountTotalSetBits2
 */
public class CountTotalSetBits1 {

    public int solve(int A) {
        long count = 0;
        long mod = 1000000007;

        for(int i=1;i<=A;i++){
            count = count + countSetBits(i);
        }

        return (int)(count % mod);

    }


    public int countSetBits(int x){
        if(x<=0){
            return 0;
        }else {
            return ((x & 1) == 0 ? 0 : 1) + countSetBits(x>>1);
        }
    }
}
