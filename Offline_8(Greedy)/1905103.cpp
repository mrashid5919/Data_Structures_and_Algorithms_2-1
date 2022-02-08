#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

long long mincost(vector<long long> &price,long long n,long long k)
{
    long long mn=0;
    sort(price.begin(),price.end(),greater<long long>());
    for(long long i=0;i<n;i++)
        mn+=(i/k+1)*price[i];
    return mn;
}

int main()
{
    long long n,k,x;
    cin>>n>>k;
    vector<long long> price(n);
    for(long long i=0;i<n;i++)
    {
        cin>>x;
        price.push_back(x);
    }
    cout<<mincost(price,n,k)<<"\n";
    return 0;
}
