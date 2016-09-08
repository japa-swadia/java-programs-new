
public class stackPkg {
	int MAXSTACK;
    String [] stack;
    int top;

    public stackPkg (int max) {
        MAXSTACK = max;
        stack = new String [MAXSTACK];
        top = 0;
    }
    public boolean isEmpty () {
        return top == 0;
    }
    public boolean isFull () {
        return top == MAXSTACK;
    }
    public void push (String item) {
        stack [top] = item;
        ++top;
    }
    public String pop () {
        --top;
        return stack [top];
    }
    public String top () {
        return stack [top - 1];
    }
    public void reset () {
        top = 0;
    }

}
