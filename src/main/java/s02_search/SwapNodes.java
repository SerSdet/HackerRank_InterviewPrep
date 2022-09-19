package s02_search;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SwapNodes {
    public static void main(String[] args) {
        List<List<Integer>>indexes = getIndexes();
        List<Integer>queries = new ArrayList<>();
        queries.add(2);
        queries.add(4);

        System.out.println(swapNodes(indexes,queries).toString());

    }

    /**
     * This method is for example array
     * @return the example array to the main method
     */
    private static List<List<Integer>> getIndexes(){
        List<List<Integer>>indexes = new ArrayList<>();
        Integer[]n1=new Integer[]{2,3};
        Integer[]n2=new Integer[]{4,-1};
        Integer[]n3=new Integer[]{5,-1};
        Integer[]n4=new Integer[]{6,-1};
        Integer[]n5=new Integer[]{7,8};
        Integer[]n6=new Integer[]{-1,9};
        Integer[]n7=new Integer[]{-1,-1};
        Integer[]n8=new Integer[]{10,11};
        Integer[]n9=new Integer[]{-1,-1};
        Integer[]n10=new Integer[]{-1,-1};
        Integer[]n11=new Integer[]{-1,-1};
        indexes.add(Arrays.asList(n1));
        indexes.add(Arrays.asList(n2));
        indexes.add(Arrays.asList(n3));
        indexes.add(Arrays.asList(n4));
        indexes.add(Arrays.asList(n5));
        indexes.add(Arrays.asList(n6));
        indexes.add(Arrays.asList(n7));
        indexes.add(Arrays.asList(n8));
        indexes.add(Arrays.asList(n9));
        indexes.add(Arrays.asList(n10));
        indexes.add(Arrays.asList(n11));
        return indexes;
    }

    public static int nodeCount = 0;

    /**
     *
     * @param indexes 2 dimensional array for the tree, we make tree with these queries
     * @param queries which level of tree will be swapped
     * @return the result array for printout the final tree inOrder
     *
     * First, we build the tree with one method, that explained below
     * Then, create an empty array for the results
     * Then, go over the queries to make swap
     *      first swap the level that in query with a different method (explained below)
     *      then create result array to fill with the results after swap
     *      then fill that array tree inOrder with separate method
     */
    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        Node root = buildTree(indexes);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++){
            swap(root, queries.get(i));
            List<Integer>arr = new ArrayList<>();
            inOrder(root, arr);
            results.add(arr);
        }
        return results;
    }

    /**
     * This method made swap operation in the tree
     * @param root root node of the tree
     * @param level in which level swap operation must be done
     *
     *First, add root node to queue and set the level of the tree is 1 for root level
     *Then, set the size as queue size,(this is the number of elements in the level)
     *Then, for each level, check that is the nodes will be swapped,
     *      - if we have query for swap, then swap the left and right node
     *      - add left and right node to the queue, so we have a next level nodes.
     * After that, decrease size -1,
     * If size become 0 means that all elements in that level has checked,
     * we can check next level of the tree, so :
     *     - increase the level +1
     *     - set the size as the numbers of element in the queue,
     *       so in next level we will be go over this much element
     */
    private static void swap (Node root, Integer level){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 1;
        int size = queue.size();
        while (!queue.isEmpty()){
            Node n = queue.remove();
            if(currentLevel % level == 0){
                Node tmp = n.left;
                n.left = n.right;
                n.right = tmp;
            }
            if(n.left != null){
                queue.add(n.left);
            }
            if(n.right != null){
                queue.add(n.right);
            }
            size --;
            if(size == 0){
                currentLevel++;
                size = queue.size();
            }
        }
    }

    /**
     * This method creates a tree for the example also count the number of total nodes in the example
     * @param indexes inputs in the examle
     * @return the tree
     *
     * First, root Node created
     * Then, root Node added to queue, for each pair entry will be added to these nodes.
     * Then, Loop started go through indexes List pairs, which are left and right.
     *       If queue has some node this loop starts,
     *       First, Node in the queue taken to temp n and removed from the queue,
     *       Then, node count increased 1;
     *       Then, Nodes for left and right added to this node and each time they also added to queue,
     * Finally, root node, which all nodes connected returned.
     */
    private static Node buildTree(List<List<Integer>> indexes){
        Node root = new Node(1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 0; i < indexes.size(); i++){
            if(!queue.isEmpty()){
                Node n = queue.remove();
                nodeCount++;
                if(indexes.get(i).get(0) != -1) {
                    n.left = new Node(indexes.get(i).get(0));
                    queue.add(n.left);
                }
                if(indexes.get(i).get(1) != -1) {
                    n.right = new Node(indexes.get(i).get(1));
                    queue.add(n.right);
                }
            }
        }
        return root;
    }

    /**
     * This method putt all the values in the tree as inorder, as an integer List
     * @param root the root of the tree
     * @param arr that stores the values in the tree
     *
     * First, left node must be added, but we must add with calling same method recursively because it may contain
     *        more nodes,
     * Then, add root value,
     * Finally, add right as same as left with calling method recursively.
     */
    private static void inOrder(Node root, List<Integer>arr){
        if(root == null) {
            return;
        }
        inOrder(root.left, arr);
        arr.add(root.value);
        inOrder(root.right, arr);
    }

    /**
     * This class define the nodes, which has one root and left and right nodes. Since left and right can be empty
     * constructor for the class only required root value for each node.
     */
    static class Node{
        Integer value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

}
