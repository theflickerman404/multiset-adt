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

    public int is_empty(){
        int value = this.tree.is_empyt();
        return value;
    }

    public int count(){
        int value = this.tree.getSize();
        return value;
    }

    public int size(){
        int value = this.tree.getSize();
        return value;
    }

}
