import java.util.ArrayList;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to english 
 * It relies on a root (reference to root of the tree) The root is set to null when the tree is empty.
 * The class uses an external generic TreeNode class which consists of a reference to the data and a reference to the left and right child. 
 * The TreeNode is parameterized as a String, TreeNode This class uses a private member root (reference to a TreeNode) 
 * The constructor will call the buildTree method
 * @author Trupti Thakur
 *
 */

public class MorseCodeTree implements LinkedConverterTreeInterface {
	private static final Map<String, String> FIRST_LEVEL = new LinkedHashMap<>();
	private static final Map<String, String> SECOND_LEVEL = new LinkedHashMap<>();
	private static final Map<String, String> THIRD_LEVEL = new LinkedHashMap<>();
	private static final Map<String, String> FOURTH_LEVEL = new LinkedHashMap<>();

	private static final List<String> TREE_LEVELS = Arrays.asList("FIRST_LEVEL", "SECOND_LEVEL", "THIRD_LEVEL",
			"FOURTH_LEVEL");

	private TreeNode<String> rootNode = null;
	static {

		FIRST_LEVEL.put("e", ".");
		FIRST_LEVEL.put("t", "-");

		SECOND_LEVEL.put("i", "..");
		SECOND_LEVEL.put("a", ".-");
		SECOND_LEVEL.put("n", "-.");
		SECOND_LEVEL.put("m", "--");

		THIRD_LEVEL.put("s", "...");
		THIRD_LEVEL.put("u", "..-");
		THIRD_LEVEL.put("r", ".-.");
		THIRD_LEVEL.put("w", ".--");
		THIRD_LEVEL.put("d", "-..");
		THIRD_LEVEL.put("k", "-.-");
		THIRD_LEVEL.put("g", "--.");
		THIRD_LEVEL.put("o", "---");

		FOURTH_LEVEL.put("h", "....");
		FOURTH_LEVEL.put("v", "...-");
		FOURTH_LEVEL.put("f", "..-.");
		FOURTH_LEVEL.put("l", ".-..");
		FOURTH_LEVEL.put("p", ".--.");
		FOURTH_LEVEL.put("j", ".---");
		FOURTH_LEVEL.put("b", "-...");
		FOURTH_LEVEL.put("x", "-..-");
		FOURTH_LEVEL.put("c", "-.-.");
		FOURTH_LEVEL.put("y", "-.--");
		FOURTH_LEVEL.put("z", "--..");
		FOURTH_LEVEL.put("q", "--.-");

	}

	public MorseCodeTree() {
		buildTree();
	}

	public TreeNode<String> getRoot() {
		return rootNode;
	}

	/**
	 * sets the root of the MorseCodeTree
	 * @param newNode - a copy of newNode will be the new root
	 */
	public void setRoot(TreeNode<String> newNode) {
		if (rootNode == null) {
			rootNode = new TreeNode<>("");
		}
	}

	/**
	 * Adds element to the correct position in the tree based on the code 
	 * This method will call the recursive method addNode
	 * @param code - the code for the new node to be added, example ".-."
	 * @param  letter - the letter for the corresponding code, example "r"
	 * @return the MorseCodeTree with the new node added
	 */
	public MorseCodeTree insert(String code, String letter) {
		addNode(rootNode, code, letter);
		return this;
	}

	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code.
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @param letter - the data of the new TreeNode to be added
	 */
	public void addNode(TreeNode root, String code, String letter) {
		insertNodeHelper(rootNode, code, 0, letter);
	}

	/**
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode.
	 * @param code - the code that describes the traversals to retrieve the string (letter)
	 * @returns the string (letter) that corresponds to the code
	 * 
	 */
	public String fetch(String code) {
		return fetchNode(rootNode, code);
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode that corresponds with the code A '.' 
	 * (dot) means traverse to the left. A "-" (dash) means traverse to the right.
	 *  The code ".-" would fetch the data of the TreeNode stored as the right child of the left child of the root\
	 *  @param root - the root of the tree for this particular recursive instance of addNode
	 *  @param code - the code for this particular recursive instance of addNode
	 *  @return the string (letter) corresponding to the code
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		return fetchNodeHelper(root, code, 0);
	}

	
	/**
	 * This operation is not supported in the MorseCodeTree
	 */
	public MorseCodeTree delete(String data) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	/**
	 * This operation is not supported in the MorseCodeTree
	 */
	public MorseCodeTree update() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. 
	 * The root will have a value of "" (empty string) level one: insert(".", "e"); insert("-", "t"); level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m"); etc.
	 * Look at the tree and the table of codes to letters in the assignment description
	 */
	public void buildTree() {
		rootNode = new TreeNode<>("");
		for (String level : TREE_LEVELS) {
			switch (level) {
			case "FIRST_LEVEL":
				iterateEntries(FIRST_LEVEL);
				break;
			case "SECOND_LEVEL":
				iterateEntries(SECOND_LEVEL);
				break;
			case "THIRD_LEVEL":
				iterateEntries(THIRD_LEVEL);
				break;
			case "FOURTH_LEVEL":
				iterateEntries(FOURTH_LEVEL);
				break;

			default:
				System.out.println("This is not a Valid Level");
				break;
			}
		}
	}

	private void iterateEntries(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			insertNodeHelper(rootNode, entry.getValue(), 0, entry.getKey());
		}
	}

	// Recursive Method to insert node
	private void insertNodeHelper(TreeNode<String> root, String code, int index, String chr) {
		// base case
		if (code.length() - 1 == index) {
			TreeNode<String> node = new TreeNode<>(chr);
			if (code.charAt(index) == '.') {
				root.setLeftChild(node);
			} else {
				root.setRightChild(node);
			}
			return;
		}
		// iterate deeper
		if (code.charAt(index) == '.') {
			insertNodeHelper(root.getLeftChild(), code, index + 1, chr);
		} else {
			insertNodeHelper(root.getRightChild(), code, index + 1, chr);
		}
	}
	
	// Recursive Method to retrieve node data
	private String fetchNodeHelper(TreeNode<String> root, String code, int index) {
		if(code.length()==index) {
			return root.getData();
		}
		return code.charAt(index)=='.'?fetchNodeHelper(root.getLeftChild(), code, index+1):fetchNodeHelper(root.getRightChild(), code, index+1);
	}

	
	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	public java.util.ArrayList<java.lang.String> toArrayList() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 *@param root - the root of the tree for this particular recursive instance
	 *@param list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal(TreeNode root, ArrayList list) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

}
