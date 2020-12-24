"""
Question:
Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
projects, where the second project is dependent on the first project). All of a project's dependencies
must be built before the project is. Find a build order that will allow the projects to be built. If there
is no valid build order, return an error.

EXAMPLE
Input:
    projects: a, b, c, d, e, f
    dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
Output: f, e, a, b, d, c
"""

from enum import Enum, auto

adjacency_list = {}
adjacency_list['e']=[]
adjacency_list['a'] = ['f']
adjacency_list['b']=['f']
adjacency_list['c']=['d']
adjacency_list['d']=['a', 'b']
adjacency_list['f']=[]

visited=[]
visiting =[]
buildOrder=[]

def findBuildOrder(node):
    if node in visiting:
        buildOrder.clear()
        raise Exception("Build not possible")
    if node not in visited:
        visiting.append(node)
        for neighbor in adjacency_list[node]:
            findBuildOrder(neighbor)
        buildOrder.append(node)
        visiting.pop()
        visited.append(node)

for node in adjacency_list:
    findBuildOrder(node)

print (buildOrder)




