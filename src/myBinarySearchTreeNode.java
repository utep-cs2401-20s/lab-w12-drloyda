class myBinarySearchTreeNode{
  int myValue;
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;

  /************************************************************************************/
  myBinarySearchTreeNode(int inValue){
    // created a new node with empty child pointers
    myValue = inValue;

  }
 /************************************************************************************/
  myBinarySearchTreeNode(int[] A){
    // creates a new Binary Search Tree rooted at the first value in the array
    /// by inserting elements into the tree in the order they are given in A.

    //creating root from first element of array
    myValue = A[0];
    //inserting the next value into the tree node
    //use a loop
    for (int i = 1; i < A.length ; i++) {
      insert(A[i]);
    }

  }
  /************************************************************************************/
  public void insert(int inValue){
    // This method takes a new integer as input and decides 
    // if it should be place: 
    //    * as the left child,
    //    * as the right child, 
    //    * in the left subtree,
    //    * or in the right subtree.
    // If the value already exists in the tree, no action is taken.

    if(inValue < myValue){//insert to left
      //checks if theres already a node there
      if(left == null){
        //creates the new node on the left side
        left = new myBinarySearchTreeNode(inValue);
      }else{
        left.insert(inValue);
      }

    }else if( inValue > myValue){ //insert to right
      //checks if theres already a node there
      if(right == null){
        //creates the new node on the right side
        right = new myBinarySearchTreeNode(inValue);
      }else{
        right.insert(inValue);
      }

    }else if (inValue == myValue){
      System.out.println("Mo duplicates allowed in this tree");
    }
    
  }
  /************************************************************************************/
  public int height(){
     // This method recursively calculates the height of the entire (sub)tree.
     // This method will take O(n) time
    int height = 0;
    int leftHeight = 0;
    int rightHeight = 0;
    //base case
    if (left == null && right == null) {
      return 0;
    }else{
      //if theres a left sub node, then recursively add to height
      if(left != null){
        leftHeight = left.height();
      }
      //if theres a right sub node, then recursively add to height
      if(right != null){
        rightHeight = right.height();
      }
      //returning the greatest height between the left/right
      //subtree plus the root
      if (leftHeight > rightHeight){
        height =  leftHeight + 1;
      }else{
        height = rightHeight + 1;
      }
    }
     return height;
  }
  /************************************************************************************/
  public int depth(int search){
     // This method recursively calculates the depth of a given search value. 
     // If the given value is not in the tree, this method returns -1. 
     // Note that if the tree is a proper BST, this method should complete in O(log n) time.
     // Additionally, remember that the depth is the number of nodes on the path from a node to the root 
     // (i.e. the number of the recursive calls).
    int depth = 0;

    //if the search node is on the left side, move left
    // and add to depth
     if(search < myValue){
      if(left != null){
        //if the node was not found
        if(left.depth(search) == -1){
          return -1;
        }
         return  1 + left.depth(search);
      }
    }
     //if the node is on the right side, move right
    //and add to depth
      if(search > myValue){
      if(right != null){
        //if the node was not found
        if(right.depth(search) == -1){
          return -1;
        }
         return  1 + right.depth(search);
      }
    }
    //if you found the value
    if(search == myValue){
      return 0;
    }
    return -1 ;
  }
  /************************************************************************************/
  public int size(){
    // This method recursively calculates the number of nodes in the (sub)tree.
    //the trees root is first included in the size
    int sum = 1;
    //traversing through tree and adding to size if theres a node
    //on the left and or right side
    if(left != null){
      sum += left.size();
    }
    if( right != null){
      sum += right.size();
    }
    return sum;
  }
  /************************************************************************************/
  // Utility function included so you can debug your solution.
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }



} 
