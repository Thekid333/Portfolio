/* Binary Search Tree Class
*  A binary search tree of generic type which extends Comparable
*/

public class BST<E extends Comparable<E>> implements Tree<E> {

    private TreeNode root;
    private int size;

    public class TreeNode<E extends Comparable<E>> {
        public E element;
        public TreeNode right;
        public TreeNode left;

    
        public TreeNode(E element) {
            this.element = element;
            right = null;
            left = null;
        }
    }

    public BST() {
        this.root = null;
        size = 0;
    }

    public BST(E item) {
        this();
        insert(item);
    }

    public BST(E[] items) {
        for(int i = 0; i < items.length; i++){
            insert(items[i]);
    }
}

    @SuppressWarnings("unchecked")
    @Override
    public boolean search(E item) {
        TreeNode curr = root;
        //while item != to curr.element || curr == null;
        while(curr != null){
            if(curr.element.compareTo(item) == 0)return true;
            //if item is less than curr, curr = curr.left;
            else if(curr.element.compareTo(item) > 0){
                curr = curr.left;
            }
            else if(curr.element.compareTo(item) < 0){
                curr = curr.right;
            }
        }
        return false;
    }
   
    @SuppressWarnings("unchecked")
    @Override
    public boolean insert(E e) {
        TreeNode curr = root;
        TreeNode newNode = new TreeNode<>(e);
        if(size == 0){
            root = newNode;
            size++;
            return true;
        }
        //while curr.element != item
        while(curr.element.compareTo(e) != 0){
            // if item is less than curr.element 
            if(curr.element.compareTo(e) > 0){
                //if curr.left == null, curr.left = newNode; size++; return true;
                if(curr.left == null){
                    curr.left = newNode;
                    size++;
                    return true;
                }
                //else curr = curr.left;
                curr = curr.left;
            }
            //if item is greater than curr.element
            if(curr.element.compareTo(e) < 0){
                // if curr.right == null, curr.right = newNode; size++; return true
                if(curr.right == null){
                    curr.right = newNode;
                    size++;
                    return true;
                }
                //else curr == curr.right;
                curr = curr.right;
            }

        }
        return false;
    }

    @Override
    public boolean remove(E e) {
       TreeNode par = null;
       TreeNode curr = root;
       while(curr != null){
        if(curr.element == e){
            if(curr.left == null && curr.right == null){
                if(par == null){
                    root = null;
                }
                else if(par.left == curr){
                    par.left = null;
                }
                else par.right = null;
            }
            else if(curr.right == null){
                if(par == null){
                    root = curr.left;
                
                }
                else if(par.left == curr){
                    par.left = curr.left;
                    
                }
                else par.left = curr.right;
            }
            else if (curr.left == null) {                // Remove node with only right child
                if (par == null) // Node is root
                {root = curr.right;}
                else if (par.left == curr) {
                   par.left = curr.right;
                }
                else
                   par.right = curr.right;
             }
             else {                                      // Remove node with two children
                // Find successor (leftmost child of right subtree)
                TreeNode suc = curr.right;
                while (suc.left != null){
                   suc = suc.left;}
                E successorData = (E) suc.element;
                remove(successorData);     // Remove successor
                //Assign cur's data with successorData
                curr.element = successorData;
             }
             return true;// Node found and removed
          }
          else if (curr.element.compareTo(e) < 0) { // Search right
             par = curr;
             curr = curr.right;
          }
          else {                     // Search left
             par = curr;
             curr = curr.left;
          }
       }
       return false;// Node not found
    }

    /* Getter method for the size of the tree
    */
    @Override
    public int size() {
        return size;
    }

    /* Does an inorder traversal of the tree, printing each visited node
    */
    @Override
    public void inorder() {
        inorderTraversal(root);
    }
    public void inorderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        inorderTraversal(node.left);

        System.out.print(node.element + " ");

        inorderTraversal(node.right);
    }

    /* Does a postorder traversal of the tree, printing each visited node
     */
    @Override
    public void postorder() {
        postorderTraversal(root);
    }
    public  void postorderTraversal(TreeNode node){
        if(node == null) return;
        postorderTraversal(node.left);

        postorderTraversal(node.right);

        System.out.print(node.element + " ");

        
    }


    /* Does a preorder traversal of the tree, printing each visited node
     */
    @Override
    public void preorder() {
        preorderTraversal(root);
    }

    public  void preorderTraversal(TreeNode node){
        if(node == null) return;
        
        System.out.print(node.element + " ");

        preorderTraversal(node.left);

        preorderTraversal(node.right);
        }


    /* Prints true on empty tree, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if(size > 0){
        return false;}
        else return true;
    }

    /* Returns the root node of the tree */
    public TreeNode getRoot() {
        return root;
    }
}
