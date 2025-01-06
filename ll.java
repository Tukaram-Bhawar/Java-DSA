import org.w3c.dom.Node;

class ll{

    class node{
        String data;
        node next;
        node(String data){
            this.data=data;
            this.next=null;
        }

    }
    private node head;
    public void addFirst(String data){
        node newNode=new node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public void addLast(String data){
        node newNode=new node(data);
        if(head==null){
            head=newNode;
            return;
        }

        node currentnode=head;
        while (currentnode.next!=null) {
            currentnode=currentnode.next;
        }
        currentnode.next=newNode;
    }

    public void deletFirt(){
        if(head==null){
            System.out.println("LIST IS EMPTY");
        }
        head=head.next;
    }
    public void deletLast(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        node lastnode=head.next;
        node secondLast=head;
        while (lastnode.next!=null) {
            lastnode=lastnode.next;
            secondLast=secondLast.next;
        }
        secondLast.next=null;
    }

    public void printlist(){
        if(head==null){
            System.out.println("List is empty");
        }
        node currentnode =head;
        while (currentnode!=null) {
            System.out.print(currentnode.data+"-->");
            currentnode=currentnode.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        ll list=new ll();
        list.addFirst("a");
        list.addFirst("is");
        list.addFirst("oveal");
        list.addFirst("last");
       list.deletLast();
        list.printlist();
        
    }
}