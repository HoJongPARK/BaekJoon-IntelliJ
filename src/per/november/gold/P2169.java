package per.november.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class P2169 {


    public static void main(String[] args) throws Exception {
        int N,M,map[][];
        int dp[][];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int [N][M];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = map[0][0];
        for(int i = 1 ; i < M ; i++)
            dp[0][i] = dp[0][i-1]+ map[0][i];
        for(int i = 1 ; i < N ; i++) {
            int temp1 [] = new int [M];
            int temp2 [] = new int [M];
            temp1[0] = dp[i-1][0] + map[i][0];
            for(int j = 1 ; j < M ; j++)
                temp1[j] =map[i][j]+ Math.max(temp1[j-1], dp[i-1][j]);

            temp2[M-1] = dp[i-1][M-1] + map[i][M-1];
            for(int j = M-2 ; j >= 0 ; j--)
                temp2[j] = map[i][j] + Math.max(temp2[j+1] , dp[i-1][j]);
            for(int j = 0 ; j < M ; j++)
                dp[i][j] = Math.max(temp1[j], temp2[j]);
        }
        System.out.println(dp[N-1][M-1]);

    }


}
