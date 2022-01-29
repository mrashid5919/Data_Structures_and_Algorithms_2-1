#include<iostream>
#include<stdio.h>
#include<vector>
#include<cstdlib>
#include<ctime>
#include<iomanip>
#include<algorithm>

using namespace std;

int temp[100005];

void mergeSort(vector<int> &x,int l,int r)
{
    if(l==r)
        return;
    int mid=(l+r)/2;
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
        else if(temp[i]<temp[j])
            x[k]=temp[i++];
        else
            x[k]=temp[j++];
    }
}

int partition(vector<int> &x,int l,int r)
{
    int i=l-1;
    for(int j=l;j<r;j++)
    {
        if(x[j]<x[r])
        {
            i++;
            swap(x[i],x[j]);
        }
    }
    swap(x[i+1],x[r]);
    return i+1;
}

int partition_random(vector<int> &x,int l,int r,int pivot)
{
    swap(x[r],x[pivot]);
    return partition(x,l,r);
}

void quickSort(vector<int> &vec,int l,int r)
{
    if(l>=r)
        return;
    int pivot=partition(vec,l,r);
    quickSort(vec,l,pivot-1);
    quickSort(vec,pivot+1,r);
}

void quickSort_random(vector<int> &vec,int l,int r)
{
    if(l>=r)
        return;
    int rand_pivot=l+rand()%(r-l+1);
    int pivot=partition_random(vec,l,r,rand_pivot);
    quickSort_random(vec,l,pivot-1);
    quickSort_random(vec,pivot+1,r);
}

void insertionSort(vector<int> &vec)
{
    for(int i=1;i<vec.size();i++)
    {
        for(int j=i;j>0;j--)
        {
            if(vec[j]<vec[j-1])
                swap(vec[j],vec[j-1]);
        }
    }
}

int main()
{
    freopen("output.csv","w",stdout);
    cout<<"n,Merge Sort,Quicksort,Randomized Quicksort,Insertion Sort,Quicksort with Sorted Input,Randomized Quicksort with Sorted Input,STL sort() function\n";
    srand(time(NULL));
    int inp[6]= {5,10,100,1000,10000,100000};
    for(int k=0; k<6; k++)
    {
        int n;
        n=inp[k];
        cout<<n<<",";
        int ara[n];
        vector<int> mSort(n),qSort(n),qSortRand(n),inSort(n),sortedqSort(n),sortedqSortRand(n);
        double sum[7]={0.0};
        for(int j=0; j<20; j++)
        {
            for(int i=0; i<n; i++)
                ara[i]=(rand()%100000);
            for(int i=0; i<n; i++)
            {
                mSort[i]=ara[i];
                qSort[i]=ara[i];
                qSortRand[i]=ara[i];
                inSort[i]=ara[i];
            }

            clock_t merge_sort_duration = clock();
            mergeSort(mSort,0,n-1);
            //printf("Sorting %d numbers using Merge sort function takes: %lf miliseconds\n",n,(clock() - merge_sort_duration)*1000/(double)(CLOCKS_PER_SEC));
            sum[0]+=((clock() - merge_sort_duration)*1000/(double)CLOCKS_PER_SEC);

            clock_t quick_sort_duration = clock();
            quickSort(qSort,0,n-1);
            sum[1]+=((clock() - quick_sort_duration)*1000/(double)CLOCKS_PER_SEC);

            clock_t random_quick_sort_duration = clock();
            quickSort_random(qSortRand,0,n-1);
            sum[2]+=((clock() - random_quick_sort_duration)*1000/(double)CLOCKS_PER_SEC);

            clock_t insertion_sort_duration = clock();
            insertionSort(inSort);
            sum[3]+=((clock() - insertion_sort_duration)*1000/(double)CLOCKS_PER_SEC);

            for(int i=0; i<n; i++)
            {

                sortedqSort[i]=mSort[i];
                sortedqSortRand[i]=mSort[i];
            }

            clock_t sorted_quick_sort_duration = clock();
            quickSort(sortedqSort,0,n-1);
            sum[4]+=((clock() - sorted_quick_sort_duration)*1000/(double)CLOCKS_PER_SEC);

            clock_t sorted_random_quick_sort_duration = clock();
            quickSort_random(sortedqSortRand,0,n-1);
            sum[5]+=((clock() - sorted_random_quick_sort_duration)*1000/(double)CLOCKS_PER_SEC);

            clock_t stl_sort_duration = clock();
            sort(ara,ara+n);
            sum[6]+=((clock() - stl_sort_duration)*1000/(double)CLOCKS_PER_SEC);

        }
        for(int i=0;i<6;i++)
            cout<<(double)sum[i]/20<<",";
        cout<<(double)sum[6]/20;
        cout<<"\n";
    }
    return 0;
}
