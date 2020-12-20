'''
Question:
Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one.
'''
#runtime is O(N), O(H) space, H is the height of the tee, because at a time we are putting number of
#nodes equal to the height of the tree in the stack

class Node:
    def __init__(self):
        self.left=None
        self.right=None

def getHeight(root):
    if(root==None):
        return -1
    leftHeight= getHeight(root.left)
    if(leftHeight=='unbalanced'): return 'unbalanced'
    rightHeight= getHeight(root.right)
    if(rightHeight=='unbalanced'): return 'unbalanced'
    if(abs(leftHeight-rightHeight)>1):
        return 'unbalanced'
    return 1+max(leftHeight, rightHeight) 

def checkBalancedTree(root):
   return getHeight(root)!='unbalanced' 

#Testing
#Balanced tree
a=Node()
b=Node()
c=Node()
d=Node()
e=Node()
f=Node()
g=Node()

a.left=b
a.right=c
b.left=d
b.right=e
c.left=f
c.right=g

print("The tree is balanced ",checkBalancedTree(a))

#Unbalanced tree
aa=Node()
bb=Node()
cc=Node()
dd=Node()
ee=Node()

aa.left=bb
aa.right=cc
bb.left=dd
dd.right=ee
print("The tree is balanced ",checkBalancedTree(aa))

