import org.junit.Test;

import javax.imageio.plugins.tiff.ExifParentTIFFTagSet;

import static junit.framework.TestCase.assertEquals;

public class myBinaryTreeNodeTester {
    //TEST CASE 1: Inserting a node into the tree
    @Test
    public void test1(){
        myBinarySearchTreeNode r = new myBinarySearchTreeNode(new int []{7,2,9});
        r.insert(1);

        myBinarySearchTreeNode exp = new myBinarySearchTreeNode(new int [] {7,2,9,1});
        //checking for the root '7'
        assertEquals(exp.myValue, r.myValue);
        //checking for the '2'
        assertEquals(exp.left.myValue, r.left.myValue);
        //checking for the '9'
        assertEquals(exp.right.myValue, r.right.myValue);
        //checking if the inserted '1' is in the tree
        assertEquals(exp.left.left.myValue , r.left.left.myValue);
    }
    /***************************************************************************************/
    //TEST CASE 2: Finding the size of the tree
    @Test
    public void sizeTest(){
        myBinarySearchTreeNode r = new myBinarySearchTreeNode(6);
        //inserting 5 nodes, since the '1' should not be duplicate
        r.insert(1);
        r.insert(9);
        r.insert(1);
        r.insert(2);
        r.insert(8);
        r.insert(4);
                //the 5 nodes plus the root
        assertEquals(6, r.size());
        //the test passed, meaning that it traverse the tree and added to the size recursively
        //and also did not duplicate the node with the number '1'
    }
    /***************************************************************************************/
    //TEST CASE 3: Finding the height from the root to the deepest leaf
    @Test
    public void heightTest(){
        myBinarySearchTreeNode r = new myBinarySearchTreeNode(4);
        //height of left subtree = 1
        //height of right subtree = 3
        //the deepest leaf is 8, meaning that the right subtree has
        //the greatest height so the height of the tree should be
        // 3+1 = 4
        r.insert(3);
        r.insert(5);
        r.insert(6);
        r.insert(3);
        r.insert(1);
        r.insert(8);
        r.insert(7);

        assertEquals(4, r.height());
        //the test passed and was able to compare the heights of the
        //left and right tree
    }
    /***************************************************************************************/
    //TEST CASE 4: Finding a note within a tree
    @Test
    public void depthTest1(){
        myBinarySearchTreeNode r = new myBinarySearchTreeNode(  10);
        //Searching for the node '17' which is at a depth of 2
        r.insert(4);
        r.insert(6);
        r.insert(14);
        r.insert(4);
        r.insert(3);
        r.insert(17);
        r.insert(22);

        assertEquals(2, r.depth(17));
        //the test passed, meaning it was able to recursively add to depth while
        //traversing the tree in search for '17'
    }/***************************************************************************************/
    //TEST CASE 5: Finding a node which happens to be root
    @Test
    public void depthTest2(){
        myBinarySearchTreeNode r = new myBinarySearchTreeNode(  10);
        //Searching for the node '10' which is the root and at a depth of 0
        r.insert(4);
        r.insert(6);
        r.insert(14);
        r.insert(4);
        r.insert(3);
        r.insert(17);
        r.insert(22);

        assertEquals(2, r.depth(17));
        //the test passed, meaning it was able to compare if myValue == inValue and return 0;
    }
    /***************************************************************************************/
    //TEST CASE 6: Trying to find a node that is not within the tree
    @Test
    public void depthTest3(){
        myBinarySearchTreeNode r = new myBinarySearchTreeNode(  10);
        //searching for a node '66' which is not in the tree
        r.insert(4);
        r.insert(6);
        r.insert(14);
        r.insert(4);
        r.insert(3);
        r.insert(17);
        r.insert(22);

        assertEquals(-1, r.depth(66));
        //the test passed,  after going throughout the whole tree and not
        //having any more left or rights to look at, it returned -1
    }

}
