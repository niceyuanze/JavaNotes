package datastructure.linearList.stack;

public class BrowserBasedOnStack {
    private StackBasedOnLinkedList<String> history = new StackBasedOnLinkedList<>();

    private StackBasedOnLinkedList<String> advance = new StackBasedOnLinkedList<>();

    private String current = null;


    public BrowserBasedOnStack() {
        history.push("initial");
    }

    public boolean add(String input){
        if(current != null){
            history.push(current);
        }
        current = input;
        advance.clear();
        return true;
    }
    public String back(){
        if(current != null){
            advance.push(current);
        }
        String tmp = history.pop();
        current = tmp;

        return tmp;
    }

    public String advance(){
        String tmp = advance.pop();
        if(current != null){
            history.push(current);
        }
        current = tmp;
        return tmp;
    }

    public static void main(String[] args) {
        BrowserBasedOnStack browserBasedOnStack = new BrowserBasedOnStack();
        browserBasedOnStack.add("baidu");
        browserBasedOnStack.add("4399");
        browserBasedOnStack.add("google");
        System.out.println(browserBasedOnStack.back());
        System.out.println(browserBasedOnStack.back());
        System.out.println(browserBasedOnStack.back());
        System.out.println(browserBasedOnStack.advance());
        System.out.println(browserBasedOnStack.advance());
        System.out.println(browserBasedOnStack.advance());
        browserBasedOnStack.add("steam");
        System.out.println(browserBasedOnStack.back());
        System.out.println(browserBasedOnStack.advance());
        System.out.println(browserBasedOnStack.advance());
    }

}
