import java.io.*;
import java.util.*;

class Node {
    int left;
    int right;
    int order;
    int level;
    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Main {

    public static Node[] tree = new Node[10001];
    public static int cnt = 1;

    // 중위 순회 ( inOrder )
    public static void inOrder(int node, int level){
        if(node == -1)
            return;

        inOrder(tree[node].left, level+1);
        tree[node].order = cnt++;
        tree[node].level = level;
        inOrder(tree[node].right,level+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] parent = new int[N+1];
        Arrays.fill(parent, -1);
        // 입력
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            int left = Integer.parseInt(input[1]);
            int right = Integer.parseInt(input[2]);
            if(left != -1)
                parent[left] = node;
            if(right != -1)
                parent[right] = node;
            tree[node] = new Node(left, right);
        }

        int root = 0;
        for(int i = 1; i <= N; i++){
            if(parent[i] == -1)
                root = i;
        }

        inOrder(root, 1);

        // 각 노드의 레벨과 순서 출력
//        for(int i = 1; i <= N; i++){
//            Node now = tree[i];
//            System.out.println("Node : "+i+", order : "+now.order+", level : "+now.level);
//        }

        int[] left = new int[N+1]; // 각 레벨마다 최소값
        int[] right = new int[N+1]; // 각 레벨마다 최대값

        int maxLevel = 0; // 최대 레벨(깊이)
        for(int i = 1; i <= N; i++){
            int level = tree[i].level;
            int order = tree[i].order;
            // 최소값 찾기
            if(left[level] == 0){
                left[level] = order;
            } else {
                if(left[level] > order){ // 최소값
                    left[level] = order;
                }
            }

            // 최대값 찾기
            if(right[level] < order)
                right[level] = order;

            // 최대 깊이 구하기
            if(level > maxLevel)
                maxLevel = level;
        }

        int answer = 0;
        int answer_level = 0;
        for(int i = 1; i <= maxLevel; i++){
            if(answer < right[i]-left[i]+1){
                answer = right[i]-left[i]+1;
                answer_level = i;
            }
        }

        System.out.println(answer_level+" "+answer);

    }
}