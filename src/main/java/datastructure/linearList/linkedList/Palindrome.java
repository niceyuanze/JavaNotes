package datastructure.linearList.linkedList;

public class Palindrome {
    public static void main(String[] args) {
        String testString1 = "abcde";
        String testString2 = "abc";
        String testString3 = "abba";
        String testString4 = "abcba";
        System.out.println(isPalindrome(testString1));
        System.out.println(isPalindrome(testString2));
        System.out.println(isPalindrome(testString3));
        System.out.println(isPalindrome(testString4));


    }
//    ²Î¿¼https://github.com/andavid/leetcode-java/blob/master/note/234/README.md
    public static boolean isPalindrome(String input){
        if(input.length() == 1 || input.length() == 2){
            return true;
        }
        HomeMadeSinglyLinkedList<Byte> linkedList1 = convertStringToLinkedList(input);
        Node<Byte> prev = null;
        Node<Byte> slow = linkedList1.getHead();
        Node<Byte> fast = linkedList1.getHead();
        while( fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            Node tmp = slow.getNext();
            slow.setNext(prev);
            prev = slow;
            slow = tmp;
        }
        slow = slow.getNext();

        while(slow.getNext() != null){
            if(!slow.getData().equals(prev.getData())){
                return false;
            }
            slow = slow.getNext();
            prev = prev.getNext();
            if(slow == prev){
                return false;
            }
        }
        return true;
    }
    public static HomeMadeSinglyLinkedList convertStringToLinkedList(String input){
        HomeMadeSinglyLinkedList homeMadeSinglyLinkedList = new HomeMadeSinglyLinkedList();
        for(Byte c: input.getBytes()){
            homeMadeSinglyLinkedList.put(c);
        }
        return homeMadeSinglyLinkedList;
    }
}
