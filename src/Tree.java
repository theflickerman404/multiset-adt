import java.util.ArrayList;
import java.util.List;

public class Tree {
    // TODO complete this Tree class to replicate the implementation from the Tree class in adts.py
    private int _root;
    private List<Tree> _subtrees;

    public Tree(int root, List<Tree> subtrees) {
        _root = root;
        _subtrees = subtrees;
    }

    public boolean isEmpty() {
        return _root == 0;
    }

    public int getSize(){
        return _subtrees.size();
    }

    public int count(int item) {
        if (this.isEmpty()) {
            return 0;
        } else {
            int num = 0;
            if (this._root == item){
                num ++;
            }
            for (Tree subtree : _subtrees) {
                num += subtree.count(item);
            }
            return num;
        }
    }

    public float _average_helper_total(){
        if (this.isEmpty()) {
            return 0;
        } else {
            float total = this._root;
            for (Tree subtree : _subtrees) {
                total += subtree._average_helper_total();
            }
            return total;
        }
    }

    public float _average_helper_count(){
        if (this.isEmpty()) {
            return 0;
        } else {
            float size = 1;
            for (Tree subtree : _subtrees) {
                size += subtree._average_helper_count();
            }
            return size;
        }
    }

    public float average(){
        if (this.isEmpty()) {
            return 0;
        } else {
            float total = this._average_helper_total();
            float count = this._average_helper_count();
            return total / count;
        }
    }

    public boolean equals(Tree other){
        if (this.isEmpty() && other.isEmpty()) {
            return true;
        } else if (this.isEmpty() || other.isEmpty()) {
            return false;
        } else {
            if (this._root != other._root) {
                return false;
            }

            if (this.getSize() != other.getSize()) {
                return false;
            }

            return this._subtrees.equals(other._subtrees);
        }
    }

    public boolean contains(int item) {
        if (this.isEmpty()) {
            return false;
        }

        if (this._root == item) {
            return true;
        } else {
            for (Tree subtree : _subtrees) {
                if (subtree.contains(item)) {
                    return true;
                }
            }
            return false;
        }
    }

    public List<Integer> leaves(){
        List<Integer> leaves = new ArrayList<Integer>();
        if (this.isEmpty()) {
            return leaves;
        } else if (this._subtrees.isEmpty()) {
            leaves.add(_root);
            return leaves;
        } else {
            for (Tree subtree : _subtrees) {
                List<Integer> subleaves = subtree.leaves();
                leaves.addAll(subleaves);
            }
            return leaves;
        }
    }

    public boolean deleteItem(int item) {
        if (this.isEmpty()) {
            return false;
        } else if (this._root == item) {
            this._deleteRoot();
            return true;
        } else {
            for (Tree subtree : _subtrees) {
                boolean deleted = subtree.deleteItem(item);
                if (deleted && subtree.isEmpty()) {
                    this._subtrees.remove(subtree);
                    return true;
                } else if (deleted) {
                    return true;
                }
            }
        }
        return false;
    }

    public void _deleteRoot(){
        if (this._subtrees.isEmpty()) {
            this._root = 0;
        } else {
            Tree chosen_subtree = this._subtrees.get(this._subtrees.size() - 1);
            this._subtrees.remove(chosen_subtree);
            this._root = chosen_subtree._root;
            this._subtrees.addAll(chosen_subtree._subtrees);
        }
    }

    public int _extractLeaf(){
        if (this._subtrees.isEmpty()) {
            int old_root = this._root;
            this._root = 0;
            return old_root;
        } else {
            int leaf = this._subtrees.get(0)._extractLeaf();
            if (this._subtrees.get(0).isEmpty()) {
                this._subtrees.remove(0);
            }
            return leaf;
        }
    }

    public void insert(int item){
        if (this.isEmpty()) {
            this._root = item;
        } else if (this._subtrees.isEmpty()) {
            this._subtrees.add(new Tree(item, null));
        } else {
            this._subtrees.add(new Tree(item, null));
        }
    }
}
