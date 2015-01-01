

/**
* The <code>TreeNode</code> class contains the node of the tree 
*   
* @author Imdadul Hoq
*    e-mail: 
*    Stony Brook ID: 
*    Homework #5 CSE 214
*    
**/

public class TreeNode {
	private TreeNode left;
	private TreeNode middle;
	private TreeNode right;
	private String label;
	private String message;
	private String promt;
	/**
	 * Constructor of TreeNode
	 */
	public TreeNode(){
	}
	/**
	 * Constructor of treeNode with label, message, and prompt assigned
	 * @param label - label of the node
	 * @param message  - message of the node
	 * @param promt   - prompt of the node
	 */
	public TreeNode(String label, String message, String promt){
		this.label =label;
		this.message = message;
		this.promt = promt;
	}
	
	/**
	 * Check if a node is a leaf
	 * @return true if a node is a node
	 */
	public boolean isLeaf(){
		if((left == null)&&(right==null)&&(middle ==null))
			return true;
		else
			return false;
	}

	/**
	 * Check if a node is empty 
	 * @return true if the node is empty
	 */
	public boolean isEmpty(){
		if ((label==null)&&(message == null)&&(promt == null)){
			return true;
		}
		return false;
	}
	/**
	 * Accessor method of left node
	 * @return left node of the node 
	 */
	
	public TreeNode getLeft() {
		return left;
	}
	/**
	 * Mutator method of the left
	 * @param left - assign the left node of the node
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}

	/**
	 * Accessor method of the middle node
	 * @return middle node of the current node
	 */
	public TreeNode getMiddle() {
		return middle;
	}
	/**
	 * Mutator method of the middle
	 * @param middle - assign the middle node of the node
	 */

	public void setMiddle(TreeNode middle) {
		this.middle = middle;
	}
	
	/**
	 * Accessor method of the Right node
	 * @return right node of the current node
	 */
	public TreeNode getRight() {
		return right;
	}
	/**
	 * Mutator method of the right
	 * @param right - assign the right node of the node
	 */

	public void setRight(TreeNode right) {
		this.right = right;
	}

	/**
	 * Accessor method of the label
	 * @return label of the current node
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * Mutator method of the label
	 * @param label - assign the label of the node
	 */

	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * Accessor method of the message
	 * @return message of the current node
	 */

	public String getMessage() {
		return message;
	}

	/**
	 * Mutator method of the message
	 * @param message - assign the message of the node
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * Accessor method of the prompt
	 * @return middle node of the prompt
	 */

	public String getPromt() {
		return promt;
	}

	/**
	 * Mutator method of the prompt
	 * @param promt - assign the prompt of the node
	 */
	public void setPromt(String promt) {
		this.promt = promt;
	}
		
	/**
	 * Traverse the tree in pre-order
	 */
	public void preOrder(){
		 System.out.println("Label:\t" + label);
		 System.out.println("Promt:\t" +promt);
		 System.out.println("Message:\t" +message);
		 
		 if(left!=null)
			left.preOrder();
		 if(middle!=null)
			 middle.preOrder();
		 if(right!=null)
			 right.preOrder();
	}
	
}
