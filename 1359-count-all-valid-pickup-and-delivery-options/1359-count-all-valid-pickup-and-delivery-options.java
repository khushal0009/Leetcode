class Solution 
{
    private static final int mod=1000000007;

    public int countOrders(int n)
    {
        long count=1;//if we have only 1 pickup and 1 delivery so we have just one way to arrange ie P1 D1

        for(int i=2;i<=n;i++)//we already solved the 1st one so start from 2
        {
            count=(count*(2*i-1)*i)%mod;
        }
        return (int)count;
    }
}