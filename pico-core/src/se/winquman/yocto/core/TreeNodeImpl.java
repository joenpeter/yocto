/**
 * 
 */
package se.winquman.yocto.core;

import java.util.ArrayList;
import java.util.List;

import se.winquman.yocto.TreeNode;

/**
 * @author jpeter
 *
 */
public class TreeNodeImpl extends AbstractComponent implements TreeNode {

	TreeNode parent;
	protected List<TreeNode> children;
	

	/* (non-Javadoc)
	 * @see se.winquman.yocto.TreeNode#addChild(se.winquman.yocto.TreeNode)
	 */
	@Override
	public void addChild(TreeNode node) {
		if(node == null) {
			return;
		}
		children.add(node);
		node.addParent(this);
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.TreeNode#getChildFirst()
	 */
	@Override
	public TreeNode getChildFirst() {
		return children.get(0);
	}


	/* (non-Javadoc)
	 * @see se.winquman.yocto.TreeNode#getParent()
	 */
	@Override
	public TreeNode getParent() {
		return parent;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.AbstractYoctoObject#init()
	 */
	@Override
	protected void init() {
		children = new ArrayList<TreeNode>();
	}

	@Override
	public List<TreeNode> getChildren() {
		return children;
	}

	@Override
	public void addParent(TreeNode parent) {
		this.parent = parent;
	}

	@Override
	public String treeToText() {
		String s = this.toString() + "{";
		
		for(TreeNode child: children) {
			s = s + child.treeToText();
		}
		s = s + "}";
		return s;
	}

}
