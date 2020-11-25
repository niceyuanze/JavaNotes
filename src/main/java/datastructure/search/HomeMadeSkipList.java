package datastructure.search;


public class HomeMadeSkipList<T extends Comparable<? super T>> {
// https://time.geekbang.org/column/article/42896?utm_campaign=guanwang&utm_source=baidu-ad&utm_medium=ppzq-pc&utm_content=title&utm_term=baidu-ad-ppzq-title
    private int size ;

    private Node<T> head;

    private Node<T> tail;




    public boolean insert(T data){

        return true;
    }

    private class Node<T>{

        private Node head;

        private Node tail;

        private int size;
    }
}
