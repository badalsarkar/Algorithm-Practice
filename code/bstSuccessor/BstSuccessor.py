"""
Question:
Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
binary search tree. You may assume that each node has a link to its parent.
"""

class Node:
    def __init__(self,value, parent: Node):
        self.parent = parent
        self.value=value
        self.left=None
        self.right=None

def findSuccessor(node):
    if node == None:
        return None # No successor 
    if node.right == None:
        #go upward
        # get the parent
        parentNode = node.parent
        while parentNode != None and node != parentNode.left:
            node = parentNode
            parentNode= parentNode.parent
        return parentNode 
    else:
        subtreeRoot = node.right
        #go downward
        while subtreeRoot.left != None:
            subtreeRoot = subtreeRoot.left
        return subtreeRoot

