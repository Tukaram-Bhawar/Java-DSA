public class tria {

    static class node{
        node children[];
        boolean eow;
        node(){
            children=new node[26];
            for (int i = 0; i < 26; i++) {
                children[i]=null;
            }
            eow=false;
        }
    }
    static node root= new node();


    public static void insert(String word){
        node curr=root;
        for(int i=0;i<word.length();i++){
            int indx=word.charAt(i)-'a';
            if(curr.children[indx]==null){
                curr.children[indx]=new node();
            }
            if(i==word.length()-1){
                curr.children[indx].eow=true;
            }
            curr=curr.children[indx];
        }
    }

    public static boolean search(String word){
        node curr=root;
        for(int i=0;i<word.length();i++){
            int indxs=word.charAt(i)-'a';
            if(curr.children[indxs]==null){
                return false;
            }
            if(i==(word.length()-1) && curr.children[indxs].eow==false){
                return false;
            }

            curr=curr.children[indxs];
            
        }
        return true;
    }

    public static boolean substreing(String key){
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            String firstPart= key.substring(0, i);
            String SecondPart =key.substring(i);
            if(search(firstPart) && substreing(SecondPart)){
                return true;
            }
        }
        return false;
    }


public static boolean startWith(String key){
    node curr=root;
    for(int i=0;i<key.length();i++){
        int indx=key.charAt(i)-'a';
        if(curr.children[indx]==null){
            return false;
        }
        curr=curr.children[indx];
    }
    return true;
}

public static int countNode(node root){
    if (root==null){
        return 0;
    }
    int count=0;
    for(int i=0;i<26;i++){
        if(root.children[i]!=null){
            count+=countNode(root.children[i]);
        }
    }
    return count+1;
}
public static String ans="";
public static void LongestWord(node root,StringBuilder temp){
    if(root==null){
        return;
    }
    for(int i=0;i<26;i++){
        if(root.children[i]!=null&& root.children[i].eow==true){
            temp.append((char)('a'+i));
            if(temp.length()>ans.length()){
                ans=temp.toString();
            }
            LongestWord(root.children[i],temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}

    public static void main(String[] args) {
        // String words[]={"a","banana","app","appl","ap","apply","apple"};
        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);
        // }
        // String key="theaanythere";
        // System.out.println(substreing(key));
        // System.out.println(search("th"));

        // String key="thej";
        // System.out.println(startWith(key));

        // String key="aba";
        // for(int i=0;i<key.length();i++){
        //     String prifix=key.substring(i);
        //     insert(prifix);
        // }

        // System.out.println(countNode(root));

        String words[]={"a","banana","app","appl","ap","apply"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        LongestWord(root,new StringBuilder(""));
        System.out.println(ans);
    }

    
}
