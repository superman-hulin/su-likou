package su;

/**
 * 矩阵中的路径
 *  DFS搜索矩阵中所有路径，并在搜索中进行剪枝
 *  剪枝条件：1.行标i和列标j越界  2.矩阵当前元素不等于当前搜索的字符 3.矩阵当前元素之前已被访问
 *  条件3可合并到2  合并方法：在当前矩阵元素再进行dfs前将元素值置为“ ” 这样条件2判断时直接剪枝了
 *  满足上述剪枝条件时 该层递归返回false
 *
 */
public class offer12 {
    public boolean exist(char[][] board, String word) {
        //字符串转成字符数组
        char[] words=word.toCharArray();
        //dfs优先搜索矩阵元素路径
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                //每进到该处一次 就代表从当前元素出发 和 整个字符串比对 一次
               if( dfs(board,i,j,words,0)) return true;
            }
        }
        return false;

    }
    private boolean dfs(char[][] board,int i,int j,char[] words,int k){
        //剪枝条件放在最前面
        if(i>=board.length||i<0||j>=board[i].length||j<0||board[i][j]!=words[k]) return false;
        //走到该处时 标志着当前矩阵元素等于words[k] 并且当k为字符串最后一个字符时 则代表该路径成功 则直接返回true
        if(k==words.length-1) return true;
        //在对当前节点进行dfs前 将当前节点通过该方式标志为已访问
        board[i][j]=' ';
        //dfs遍历当前矩阵元素
        boolean rs=dfs(board,i-1,j,words,k+1)||dfs(board,i+1,j,words,k+1)||dfs(board,i,j-1,words,k+1)
                ||dfs(board,i,j+1,words,k+1);
        //当前元素被访问后 再置换回来
        board[i][j]=words[k];
        return rs;
    }
}
