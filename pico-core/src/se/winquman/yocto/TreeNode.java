/**
 * 
 */
package se.winquman.yocto;

import java.util.List;

/**
 * @author jpeter
 *
 */
public interface TreeNode {

	public void addChild(TreeNode node);
	
	public TreeNode getChildFirst();
	
	public TreeNode getParent();
	
	public List<TreeNode> getChildren();
	
	public void addParent(TreeNode parent);
	
	public String treeToText();
}
