'''
Question:
Validate 8ST: Implement a function to check if a binary tree is a binary search tree.
'''

#Time O(N) space O(log N)
class Node:
    def __init__(self,value):
        self.value=value
        self.left=None
        self.right=None

def validateBST(root, minVal, maxVal):
    if(root==None):
        return True
    if(minVal!=None and root.value<=minVal) or (maxVal!=None and root.value>maxVal):
        return False
    return validateBST(root.left,minVal,root.value) and validateBST(root.right, root.value,maxVal)

#Tree
#Not binary search tree
a=Node(8)
b=Node(6)
c=Node(5)
d=Node(15)
e=Node(10)
f=Node(9)
g=Node(11)

a.left=b
a.right=e
b.left=c
b.right=d
e.left=f
e.right=g

print(validateBST(a,None, None))

#Tree
##Binary search tree

aa=Node(8)
ba=Node(6)
ca=Node(5)
da=Node(7)
ea=Node(10)
fa=Node(9)
ga=Node(11)

aa.left=ba
aa.right=ea
ba.left=ca
ba.right=da
ea.left=fa
ea.right=ga
print(validateBST(aa,None,None))


