#include<iostream>

using namespace std;

int power(int a,int b)
{
    int u=1;
    for(int i=0;i<b;i++)
        u*=a;
    return u;
}

int main()
{
    int n,i,j,ara[10][10],dp[1024],m,mn;
    cin>>n;
    for(i=0;i<n;i++)
    {
        for(j=0;j<n;j++)
            cin>>ara[i][j];
    }
    dp[0]=0;
    for(m=1;m<power(2,n);m++)
    {
        mn=INT_MAX;
        for(i=0;i<n;i++)
        {
            if(m&(1<<i)) //checking whether the ith bit of m is 1
            {
                int c=0;
                for(j=0;j<n;j++)
                {
                    if(m&(1<<j)){
                         c+=ara[i][j];
                         //cout<<i<<" "<<j<<" "<<c<<"\n";
                    }
                }
                c+=dp[m&~(1<<i)]; //unsetting the ith bit in m
                mn=min(mn,c);
            }
        }
        //cout<<mn<<"\n";
        dp[m]=mn;
    }
    /*for(i=0;i<(1<<n);i++)
        cout<<dp[i]<<"\n";*/
    cout<<dp[power(2,n)-1]<<"\n";
    return 0;
}
