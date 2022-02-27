#include<bits/stdc++.h>
using namespace std;
#define fastio ios_base::sync_with_stdio(false);cin.tie(NULL)

int main()
{
    fastio;
    int n,i,j,x,count,dp[60005];
    cin>>n;
    dp[1]=1;
    for(i=2;i<=n;i++)
    {
        x=sqrt(i);
        if(x*x==i)
        {
            dp[i]=1;
            continue;
        }
        dp[i]=i;
        for(j=1;j<=i/2;j++)
        {
            dp[i]=min(dp[i],dp[j]+dp[i-j]);
        }
    }
    cout<<dp[n]<<"\n";
    return 0;
}
