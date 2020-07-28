import java.io.*;
import java.util.*;

class Node {
    int left;
    int right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Main {

    // 전위 순회
    public static void preOrder(Node[] tree, int node){
        if(node == -1)
            return;

        System.out.print((char)(node+'A'));
        preOrder(tree, tree[node].left);
        preOrder(tree, tree[node].right);
    }

    // 중위 순회
    public static void inOrder(Node[] tree, int node){
        if(node == -1)
            return;

        inOrder(tree, tree[node].left);
        System.out.print((char)(node+'A'));
        inOrder(tree, tree[node].right);
    }

    // 후위 순회
    public static void postOrder(Node[] tree, int node){
        if(node == -1)
            return;

        postOrder(tree, tree[node].left);
        postOrder(tree, tree[node].right);
        System.out.print((char)(node+'A'));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] tree = new Node[26];

        // 입
        while(N-- > 0){
            String[] input = br.readLine().split(" ");
            int node = input[0].charAt(0)-'A';
            char leftchild = input[1].charAt(0);
            char rightchild = input[2].charAt(0);
            int left = -1; // 기본 설정 값
            int right = -1; // 기본 설정 값
            if(leftchild != '.')
                left = leftchild - 'A';
            if(rightchild != '.')
                right = rightchild - 'A';
            tree[node] = new Node(left, right);
        }

        // 아스키 코드에 따라 0부터 시작된다. (항상 루트노드는 A이므로 0)
        preOrder(tree, 0);
        System.out.println();
        inOrder(tree, 0);
        System.out.println();
        postOrder(tree, 0);

    }
}