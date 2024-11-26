package TempSources;
public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {

        // data의 타입이 Object인 이유?? => data는 다양한 자료형을 필요로 하기 때문
        // Object는 모든 클래스의 상속 부모이기에 모든 객체(자료형)를 담을 수 있다
        private Object data;
        private Node next;

        public Node(Object value) {
            this.data = value;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object value) {
        Node newNode = new Node(value);

        // 사이즈가 0 => 노드가 없는 상태
        // 즉, 앞으로 넣든 뒤로 넣든 상관x
        if (size == 0) {
            addFirst(value);
        } else {
            // tail이 가리키는 노드의 포인터를 newNode로 할당
            tail.next = newNode;
            // tail을 newNode로 업데이트
            tail = newNode;
            size++;
        }
    }

    // 인덱스에 따른 노드 탐색
    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        // x가 head일때 => 0번째

        /*  
        x의 n번째???
        x = x.next를 x = head를 기점으로
        n번 반복하면 n번째 노드로 도달하는 규칙성을 가진다
        x = x.next; => head로 부터 다음 (index : 1)
        x = x.next; => haed로 부터 다음다음 (index : 2)
         */

        // x가 tail일때 => 마지막

        // 리턴되는 x는 객체
        return x;
    }

    public void add (int k, Object value) {
        if(k == 0) {
            addFirst(value);
        } else {
            Node prevNode = node(k-1);
            Node newNode = new Node(value);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            size++;

            // 조건식의 의미 => newNode는 마지막 노드
            // 즉, tail로 존재한다
            if (newNode.next == null) {
                tail = newNode;
            }
            
            // else문과 같은 동작을 하는 로직
            // Node prevNode = node(k-1);
            // Node nextNode = prevNode.next;
            // Node newNode = new Node(value);
            // prevNode.next = newNode;
            // newNode.next = nextNode;
            // size++;

        }
    }

    // 본래의 toString(객체 출력)은 레퍼런스값 즉, 해시코드를 반환
    // 하지만 동작을 재정의하여 객체 출력 시 리스트(객체)의 데이터를 출력
    public String toString() {
    // head == null => empty statement
        if(head == null) {
            return "[]";
        }
        Node temp = head;
        String str = "[";

        while(temp.next != null) {
            str += temp.data + ", ";
            temp = temp.next;
        // node메소드와 같이 temp.next로 반복적 이동하여 순회 구성 
        }

        // 마지막 노드에서는 while이 동작하지 않는다
        // 그래서 마지막 데이터는 직접 추가
        str += temp.data;

        return str + "]";
    }

    public Object removeFirst() {
        Node temp = head;
        head = head.next;
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    public Object remove(int k) {
        if(k == 0) {
            return removeFirst();
        }
        Node prevNode = node(k-1);
        Node todoDeleted = prevNode.next;
        prevNode.next = todoDeleted.next;
        Object returnData = todoDeleted.data;
        
        if(todoDeleted == tail) {
            tail = prevNode;
        }
        todoDeleted = null;
        size--;

        return returnData;
    }

    public Object removeLast() {
        return remove(size - 1);
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        Node targetNode = node(index);
        return targetNode.data;
    }

    public int indexOf(Object value) {
        Node temp = head;
        int index = 0;
        while (temp.data != value) {
            temp = temp.next;
            index++;

            if(temp == null) {
                return -1;
            // -1은 리스트에 값이 존재하지 않는다는 뜻의 관례
            }
        }
        return index;
    }
}
