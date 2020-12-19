'''
Question: List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth 4, you'll have 4 linked levelList).
'''
class Node:
    def __init__(self, value):
        self.value=value
        self.left=None
        self.right=None

# Using BFS method
def createListOfDepth(root):
    if(root==None):
        return
    parent= [root]
    result=list()
    while len(parent)>0:
        result.append(parent)
        children=parent
        parent=list()
        for node in children:
            if(node.left!=None):
                parent.append(node.left)
            if(node.right!=None):
                parent.append(node.right)
    return result
        

#Test
#create tree
a= Node("A")
b = Node("B")
c = Node("C")
d = Node("D")
e = Node("E")
f = Node("F")
g = Node("G")
h = Node("H")
i = Node("I")
j = Node("J")
k = Node("K")
l = Node("L")
m = Node("M")
n = Node("N")

#level 1 is a

#level 2
a.left=b
a.right=c

#level 3
b.left=d
b.right=e
c.left=f
c.right=g

#level 4
d.left=h
d.right=i
f.left=j
f.right=k
g.left=l
g.right=m

#level 5
l.left=n

result=list()
# expected result is 5
print(len(createListOfDepth(a)))

# expected result is 3
print(len(createListOfDepth(b)))

# expected result is 2
print(len(createListOfDepth(l)))
