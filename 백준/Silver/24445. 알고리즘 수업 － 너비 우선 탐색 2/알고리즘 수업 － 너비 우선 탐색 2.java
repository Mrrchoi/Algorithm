import java.util.*;

public class Main {
    public static void bfs(List<List<Integer>> vertex, int[] result, int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[vertex.size()];
        int count = 1;

        queue.offer(start);

        visit[start] = true;

        result[start] = count++;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int ver : vertex.get(now)){
                if(!visit[ver]){
                    queue.offer(ver);
                    visit[ver] = true;
                    result[ver] = count++;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        List<List<Integer>> vertex = new ArrayList<>();
        int[] result = new int[n + 1];

        for(int i = 0; i <= n; i++) vertex.add(new ArrayList<>());

        for(int i = 0; i < m; i++){
            int ver_1 = sc.nextInt();
            int ver_2 = sc.nextInt();

            vertex.get(ver_1).add(ver_2);
            vertex.get(ver_2).add(ver_1);
        }

        for(int i = 0; i <= n; i++) vertex.get(i).sort(Comparator.reverseOrder());

        bfs(vertex, result, r);

        for(int i = 1; i <= n; i++) System.out.println(result[i]);

    }
}
