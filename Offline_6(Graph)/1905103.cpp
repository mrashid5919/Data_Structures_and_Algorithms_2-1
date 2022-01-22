#include<iostream>
#include<cstdlib>
#include<stdio.h>
#include<vector>
#include<queue>

using namespace std;

vector<int> adj[120];
queue<int> q;
vector<pair<int,int> >ladders;
vector<pair<int,int> >snakes;

void BFS(int source,vector<bool> &visited,vector<int> &distance,vector<int> &parent)
{
        q.push(source);
        visited[source]=true;
        distance[source]=0;
        parent[source]=-1;
        while(!q.empty())
        {
            int u=q.front();
            q.pop();
            for(int i=0;i<adj[u].size();i++)
            {
                if(visited[adj[u][i]]==false)
                {
                    visited[adj[u][i]]=true;
                    q.push(adj[u][i]);
                    parent[adj[u][i]]=u;
                    int flag=1;
                    for(int j=0;j<ladders.size();j++)
                    {
                        if(ladders[j].first==u && ladders[j].second==adj[u][i])
                        {
                            flag=0;
                            break;
                        }
                    }
                    for(int j=0;j<snakes.size();j++)
                    {
                        if(snakes[j].first==u && snakes[j].second==adj[u][i])
                        {
                            flag=0;
                            break;
                        }
                    }
                    distance[adj[u][i]]=distance[u]+flag;
                }
            }
        }
}

int main()
{
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    int t,n,x,l,s,start,end;
    cin>>t;
    while(t--)
    {
        cin>>n>>x;
        vector<bool> visited(x+1);
        vector<int> distance(x+1);
        vector<int> parent(x+1);
        cin>>l;
        while(l--)
        {
            cin>>start>>end;
            adj[start].push_back(end);
            ladders.push_back(make_pair(start,end));
        }
        cin>>s;
        while(s--)
        {
            cin>>start>>end;
            adj[start].push_back(end);
            snakes.push_back(make_pair(start,end));
        }
        for(int i=1;i<=x;i++)
        {
            if(adj[i].size()>0)
                continue;
            for(int j=i+n;j>=i+1;j--)
            {
                if(j>x)
                    continue;
                adj[i].push_back(j);
            }
        }
        BFS(1,visited,distance,parent);
        if(visited[x]==false)
        {
            cout<<-1<<"\n";
            cout<<"No solution"<<"\n";
        }
        else
        {
            vector<int> shortestPath;
            for(int i=x;i!=-1;i=parent[i])
            {
                shortestPath.push_back(i);
            }
            cout<<distance[x]<<"\n";
            for(int i=shortestPath.size()-1;i>=0;i--)
            {
                cout<<shortestPath[i];
                if(i!=0)
                    cout<<" -> ";
                else
                    cout<<"\n";
            }
        }
        vector<int> unvisited;
        for(int i=1;i<=x;i++)
        {
            if(visited[i]==false)
                unvisited.push_back(i);
        }
        if(unvisited.size()==0)
            cout<<"All reachable"<<"\n";
        else
        {
            for(int i=0;i<unvisited.size();i++)
                cout<<unvisited[i]<<" ";
            cout<<"\n";
        }
        for(int i=1;i<=x;i++)
            adj[i].clear();
        visited.clear();
        distance.clear();
        parent.clear();
        ladders.clear();
        snakes.clear();
    }
    return 0;
}
