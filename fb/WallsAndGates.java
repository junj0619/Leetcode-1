//For the last test case, TLE, as for every INF, my solution will do a bfs
//need to do some optimization
public class WallsAndGates {
    private static int rows = 0;
    private static int cols = 0;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    
    class Pair {
        int x;
        int y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        
        this.rows = rooms.length;
        this.cols = rooms[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == Integer.MAX_VALUE) {
                    boolean[][] hash = new boolean[rows][cols];
                    rooms[i][j] = bfs(i, j, rooms, hash);
                } 
            }
        }
        
    }
    
    private int bfs(int i, int j, int[][] rooms, boolean[][] hash) {
        Deque<Pair> q = new ArrayDeque<Pair>();
        
        q.offer(new Pair(i, j));
        hash[i][j] = true;
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Pair cur = q.poll();
                
                for (int k = 0; k < 4; k++) {
                    int index_x = cur.x + dx[k];
                    int index_y = cur.y + dy[k];
                
                    if (index_x >= 0 && index_x < rows && index_y >= 0 && index_y < cols) {
                        if (rooms[index_x][index_y] != -1 && rooms[index_x][index_y] != 0 && !hash[index_x][index_y]) {
                            q.offer(new Pair(index_x, index_y));
                            hash[index_x][index_y] = true;
                        } 
                        
                        if (rooms[index_x][index_y] == 0) {
                            return ++count;
                        }
                    }
                }
            }
            count++;
        }
        
        //not reach a zero
        return Integer.MAX_VALUE;
    }
}
