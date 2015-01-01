/**
* The <code>Tree</code> class tree of the TreeNode
*   
* @author Imdadul Hoq
*    e-mail: 
*    Stony Brook ID: 
*    Homework #5 CSE 214
*    
**/
import java.util.*;
public class Tree {
	
	private TreeNode root;
	private TreeNode current;
	private TreeNode runner; 
	/**
	* Constructor for Tree
	*/
	public Tree(){
	}
	/**
	 * 
	 * This method add a new node to the root
	 * @param label -- label of the node
	 * @param prompt -- prompt of the node
	 * @param message -- message of the node
	 * @param parentLabel -- parent Label of the node
	 * @return  true if it is true;
	 */
	public boolean addNode(String label, String prompt, String message, String parentLabel)
	{
		TreeNode newNode = new TreeNode(label,message,prompt);
		TreeNode getParent = new TreeNode();
		if (isEmpty()){
			root = newNode;
			return true;
		}
		
		else {                                                                  // find the parent node and place the child  
			getParent = getNodeReference(parentLabel);
			if (getParent.getLeft()==null)                                      // if there is no left child add into the left
			{
				getParent.setLeft(newNode);
				return true;
			}
			if (getParent.getMiddle()==null)                                    // if there is no left child add into the left
			{
				getParent.setMiddle(newNode);
				return true;
			}
			if (getParent.getRight()==null)                                     // if there is no left child add into the left
			{
				getParent.setRight(newNode);
				return true;
			}		
		}
		
		return false;
	}	
		
	/**
	 * Print the tree in Pre-Order;
	 */
	
	public void preOrder(){
		root.preOrder(); 
	}
	/**
	 * Find the node of a given label
	 * @param label -- Label of a node which node needs to be found
	 * @return -- return the node of that label
	 */
	
	public TreeNode getNodeReference (String label){
	StringTokenizer parent = new StringTokenizer(label, "-",false);
	if (label.equalsIgnoreCase("Root"))
	{
		return root;
	}
	current = root;
	while (parent.hasMoreTokens())
	{
		int number = Integer.parseInt(parent.nextToken());
		if(number==1)
			current = current.getLeft();
		if(number==2)
			current = current.getMiddle();
		if(number==3)
			current = current.getRight();
	}	
	return current;	
	}
	
	/**
	 * Start the Session to help
	 */
	public void beginSession(){
		System.out.println("Welcome to Help Session");
		String traceCode ="";
		
		runner = root;
		int select=-1;
		Scanner input = new Scanner (System.in);
		while((runner!=null)&&(select!=0)&&(!runner.isLeaf()))
		{
			String get="";
			System.out.println(runner.getMessage());
			if (runner.getLeft()!=null){
				System.out.println("1>>\t"+runner.getLeft().getPromt());
			}
			if (runner.getMiddle()!=null){
				System.out.println("2>>\t"+runner.getMiddle().getPromt());
			}
			if (runner.getRight()!=null){
				System.out.println("3>>\t"+runner.getRight().getPromt());
			}
			if(!runner.isLeaf()&&(!traceCode.isEmpty()))
				System.out.println("B>>\tGo Back");
			if (runner.isLeaf()==false){
				System.out.println("0>>\tExit");
				System.out.print("Enter Selection:\t");
				try{
				select =input.nextInt();
				}catch (InputMismatchException e){
					get =input.next();
					select =-1;
				}	
				if(select ==1){
					runner = runner.getLeft();
					traceCode = traceCode+"l";
					}
				if(select ==2){
					runner = runner.getMiddle();
					traceCode = traceCode+"m";
					}
				if(select ==3){
					runner = runner.getRight();
					traceCode = traceCode+"r";
					}
				if(get.equalsIgnoreCase("B")){
					System.out.println("Typed B");
					System.out.println(traceCode);
					runner = prevoius(traceCode);
					if(traceCode.length()>1)
						traceCode =String.copyValueOf(traceCode.toCharArray(), 0, traceCode.length()-1);
					else
						traceCode = "";
				}
				if (runner.isLeaf()){
					System.out.println(runner.getMessage());
				}
			}
		}
		System.out.println("Thanks for Using your help Session");
	}
	/**
	 * This method used to find the parent node of the current node via the trace
	 * @param trace - String that recored the path of the nodes  
	 * @return - parent node of the current node
	 */
	public TreeNode prevoius(String trace){
		TreeNode sendNode=root; 
		for(int i=0;i<trace.length()-1;i++){
			char info = trace.charAt(i);
			if(info=='m'){
				sendNode = sendNode.getMiddle();
			}
			if(info=='l'){
				sendNode = sendNode.getLeft();
			}
			if(info=='r'){
				sendNode = sendNode.getRight();
			}
		}return sendNode;		
	}
	/**
	 * This method check if a root is empty
	 * @return true if the node is empty
	 */
	
	public boolean isEmpty(){
		if (root ==null)
			return true;
		else 
			return false;
	}
	
}
