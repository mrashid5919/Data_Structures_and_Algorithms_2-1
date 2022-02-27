#include<bits/stdc++.h>
using namespace std;
#define fastio ios_base::sync_with_stdio(false);cin.tie(NULL)

int ara[200005],idx[200005];

int main()
{
    fastio;
    int n,i,st=0;
    cin>>n;
    for(i=0;i<n;i++)
        cin>>ara[i];
    for(i=0;i<n;i++)
    {
        idx[ara[i]]=i;
    }
    for(i=1;i<=n;i++)
    {
        if(i==1)
            st++;
        else if(idx[i]<idx[i-1])
            st++;
    }
    cout<<st<<"\n";
    return 0;
}
