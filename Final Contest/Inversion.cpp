#include<bits/stdc++.h>
using namespace std;
#define fastio ios_base::sync_with_stdio(false);cin.tie(NULL)

long long inversion,temp[200005];

void mergeSort(vector<long long> &x,long long l,long long r)
{
    if(l==r)
        return;
    long long mid=(l+r)/2;
    mergeSort(x,l,mid);
    mergeSort(x,mid+1,r);
    for(int i=l;i<=r;i++)
        temp[i]=x[i];
    int i=l;
    int j=mid+1;
    for(int k=l;k<=r;k++)
    {
        if(i==mid+1)
            x[k]=temp[j++];
        else if(j>r)
            x[k]=temp[i++];
        else if(temp[i]<=temp[j])
        {
            x[k]=temp[i++];
        }
        else
        {
            x[k]=temp[j++];
            inversion+=(mid-i+1);
        }
    }
}

int main()
{
    fastio;
    long long t,n,i,x;
    cin>>t;
    while(t--)
    {
        inversion=0;
        vector<long long> ara;
        cin>>n;
        for(i=0;i<n;i++)
            temp[i]=0;
        for(i=0; i<n; i++)
        {
            cin>>x;
            ara.push_back(x);
        }
        mergeSort(ara,0,n-1);
        cout<<inversion<<"\n";
    }
    return 0;
}
