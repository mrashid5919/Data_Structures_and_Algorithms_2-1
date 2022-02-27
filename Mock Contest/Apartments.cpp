#include<bits/stdc++.h>
using namespace std;
#define fastio ios_base::sync_with_stdio(false);cin.tie(NULL)

//long long ara[200005],b[200005],vis[200005];

int main()
{
    fastio;
    //freopen("test_input.txt","r",stdin);
    long long n,m,k,i,count=0,x=-1,temp;
    cin>>n>>m>>k;
    vector<long long> ara,b;
    vector<long long>::iterator lower,higher;
    for(i=0;i<n;i++)
    {
        cin>>temp;
        ara.push_back(temp);
    }
    for(i=0;i<m;i++)
    {
        cin>>temp;
        b.push_back(temp);
        //vis.push_back(0LL);
    }
    //cout<<b.size()<<"\n";
    sort(ara.begin(),ara.end());
    sort(b.begin(),b.end());
    for(i=0;i<n;i++)
    {
        if(x==m-1)
            break;
        lower = lower_bound(b.begin()+(x+1), b.end(), ara[i]-k);
        higher = upper_bound(b.begin(),b.end(),ara[i]+k);
        //cout<<i<<" "<<(lower-b.begin())<<endl;
        if(lower==b.end() || lower==higher)
        {
            continue;
        }
        temp=(lower-b.begin());
        count++;
        if(x==-1)
            x=temp;
        else
        {
            x=max(x+1,temp);
        }
    }
    cout<<count<<"\n";
    return 0;
}
