#include<bits/stdc++.h>

using namespace std;
#define fastio ios_base::sync_with_stdio(false);cin.tie(NULL)
#define M 10000007

int main()
{
    fastio;
    long long t,n,i,a,b,c,d,e,f,j,sum=0;
    cin>>t;
    for(i=1;i<=t;i++)
    {
        cin>>a>>b>>c>>d>>e>>f>>n;
        long long ara[100005];
        ara[0]=a;
        ara[1]=b;
        ara[2]=c;
        ara[3]=d;
        ara[4]=e;
        ara[5]=f;
        for(j=6;j<=n;j++)
            ara[j]=(ara[j-6]%M + ara[j-5]%M + ara[j-4]%M +ara[j-3]%M + ara[j-2]%M + ara[j-1]%M)%M;
        cout<<"Case "<<i<<": "<<ara[n]%M<<"\n";
    }
    return 0;
}
