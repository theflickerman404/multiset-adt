public class TreeMultiSet extends MultiSet {

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
