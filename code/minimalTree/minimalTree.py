'''
Question:
Given a sorted (increasing order) array with unique integer elements, write an
algorithm to create a binary search tree with minimal height. Considering there is no duplicate
value 
'''
class Node:
    left=None
    right=None
    def __init__(self,value):
        self.value=value

def createMinBinarySearchTree(vertices, start, end):
    if(end<start):
        return 
    mid = (start+end)//2
    root = Node(vertices[mid])
    root.right= createMinBinarySearchTree(vertices, start, mid-1)
    root.left= createMinBinarySearchTree(vertices, mid+1, end)
    return root

# call the function
vertices = [1,2,3,4,5,6,7]
minTree=createMinBinarySearchTree(vertices, 0, len(vertices)-1)

