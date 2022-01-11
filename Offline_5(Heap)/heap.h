#include<iostream>
#include<vector>
#include<cstdlib>
using namespace std;

class Heap
{
    int* ara;
    int mxsize;
    int n;

    void heapify(int i)
    {
        int leftchild=2*i;
        int rightchild=(2*i)+1;
        int largest;
        if(leftchild<=n && ara[leftchild]>ara[i])
            largest=leftchild;
        else
            largest=i;
        if(rightchild<=n && ara[rightchild]>ara[largest])
            largest=rightchild;
        if(largest!=i)
        {
            swap(ara[largest],ara[i]);
            heapify(largest);
        }
    }

    void siftup(int i)
    {
        int parent=i/2;
        if(parent>0 && ara[parent]<ara[i])
        {
            swap(ara[parent],ara[i]);
            siftup(parent);
        }
    }

    public:
    Heap(int size)
    {
        mxsize=size;
        ara=new int[mxsize+1];
        n=0;
    }

    Heap(vector<int> &v)
    {
        mxsize=v.size();
        ara=new int[mxsize+1];
        n=v.size();
        for(int i=0;i<v.size();i++)
            ara[i+1]=v[i];
        for(int i=mxsize/2;i>=1;i--)
            heapify(i);
    }

    ~Heap()
    {
        delete ara;
    }

    void insert(int &num)
    {
        if(n>=mxsize)
        {
            cout<<"Heap is full\n";
            return;
        }
        ara[++n]=num;
        siftup(n);
    }

    int size()
    {
        return n;
    }

    int getMax()
    {
        return ara[1];
    }

    int deleteKey()
    {
        int rt=ara[1];
        swap(ara[1],ara[n]);
        n--;
        heapify(1);
        return rt;
    }
};

void heapsort(vector<int> &numbers)
{
    Heap h(numbers);
    int sz=h.size();
    for(int i=0;i<sz;i++)
        numbers[i]=h.deleteKey();
}
