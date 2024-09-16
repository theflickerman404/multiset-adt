public class TreeMultiSet extends MultiSet {
    private Tree tree;
    public TreeMultiSet(Tree tree){
	    this.tree = tree;
    }
    @Override
    public void add(Integer item) {
	    this.tree.insert(item);
    }
    public void remove(Integer item){
	    this.tree.delete_item(item);
    }
    public boolean contains(Integer item){
	    return this.tree.contains(item);
    }
}
