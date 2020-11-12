
import java.io.*;
import java.util.*;
/**
 * The MorseCodeConverter contains a static MorseCodeTree object
 * and constructs (calls the constructor for) the MorseCodeTree.
 * 
 * @author Trupti Thakur
 *
 */
public class MorseCodeConverter {
	private static MorseCodeTree mcTree = new MorseCodeTree();
	private static StringBuilder treeString = new StringBuilder();
	private static StringBuilder englishString = new StringBuilder();

	public MorseCodeConverter() {
	}

	public static String printTree() {
		printTreeHelper(mcTree.getRoot());
		return treeString.toString().trim();
	}
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * @param code - the morse code
	 * @return -the English translation
	 */

	public static String convertToEnglish(String code) {
		if (englishString.length() > 0)
			englishString.delete(0, englishString.length() - 1);
		String[] words = code.split("/");
		for (String word : words) {
			String trimmedWord = word.trim();
			String[] chars = trimmedWord.split(" ");
			for (String charCode : chars) {
				englishString.append(mcTree.fetch(charCode.trim()));
			}
			englishString.append(" ");
		}

		return englishString.toString().trim();
	}

	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * @param codeFile - name of the File that contains Morse Code
	 * @return the English translation of the file
	 */
	public static String convertToEnglish(File codeFile) {
		String returnString = "";
		Scanner scan = null;
		try {
			scan = new Scanner(codeFile);
			while (scan.hasNext()) {
				returnString = returnString + scan.next() + " ";
			}

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} finally {
			scan.close();
		}
		return convertToEnglish(returnString);
	}

	// Recursive method to iterate the morse tree in infix traversal order.
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them.
	 * Uses the toArrayList method in MorseCodeTree It should return the data in this order:
	 * @param root
	 */

	private static void printTreeHelper(TreeNode<String> root) {
		// base case
		if (root == null) {
			return;
		}
		// iterate deeper into the tree
		printTreeHelper(root.getLeftChild());
		treeString.append(root.getData()).append(" ");
		printTreeHelper(root.getRightChild());
	}

}
