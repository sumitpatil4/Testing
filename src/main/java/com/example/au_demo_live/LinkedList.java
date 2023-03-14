package com.example.au_demo_live;

public class LinkedList<T> {

    private Node<T> headNode;


    /*
    1. index = -1 ---> Exception should be thrown
    2. index less than the size ---> Element should be returned
    3. index greater than the size ---> null || throw exception
     */
    public T getElement(int index){
        if(index<0){
            throw new RuntimeException("Index cannot be negative");
        }
        var currIndex=0;
        var iteratorNode =headNode;
        while(iteratorNode!=null){
            if(currIndex == index){
                return iteratorNode.getValue();
            }
            iteratorNode=iteratorNode.getNextNode();
            currIndex++;
        }

        throw new RuntimeException("Index greater than the size");
    }

    /*
    1. length of LinkedList should be increased after adding
    2. If element is null, throw exception
     */
    public int addElement(T element){
        if(element==null){
            throw new RuntimeException("Cannot add null");
        }
        final var tempNode = new Node<T>();
        tempNode.setValue(element);

        if(headNode==null){
            headNode=tempNode;
            return getLength();
        }
        var iteratorNode =headNode;
        while(iteratorNode.getNextNode()!=null){
            iteratorNode=iteratorNode.getNextNode();
        }
        iteratorNode.setNextNode(tempNode);
        return getLength();
    }

    int getLength(){
        var iteratorNode=headNode;
        var length=0;
        while(iteratorNode.getNextNode()!=null){
            iteratorNode=iteratorNode.getNextNode();
            length++;
        }
        return length;
    }
}

class Node<T>{
    private T value;

    private Node<T> nextNode;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}
