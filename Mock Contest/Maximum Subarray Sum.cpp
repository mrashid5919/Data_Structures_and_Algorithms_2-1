#include<bits/stdc++.h>
using namespace std;
#define fastio ios_base::sync_with_stdio(false);cin.tie(NULL)

long long ara[200005];

int main()
{
    fastio;
    long long n,sc=0,mx=INT_MIN,i;
    cin>>n;
    for(i=0;i<n;i++)
        cin>>ara[i];
    for(i=0;i<n;i++)
    {
        sc+=ara[i];
        mx=max(sc,mx);
        if(sc<0)
            sc=0;
    }
    cout<<mx<<"\n";
    return 0;
}
