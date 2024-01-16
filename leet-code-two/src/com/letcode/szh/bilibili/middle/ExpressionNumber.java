package com.letcode.szh.bilibili.middle;

/**
 * @ClassName ExpressionNumber
 * @Description ExpressionNumber
 * @Author szh
 * @Date 2024年01月15日
 */
public class ExpressionNumber {




    public static int num1(String express , boolean desired){
        if(express == null || express.equals("")){
            return 0;
        }
        char[] exp = express.toCharArray();

        return process(exp , 0 , exp.length - 1 , desired);
    }


    // exp[L..R] 范围上达到desired的最小组合数
    // L R位置不要压中逻辑符号
    public static int process(char[] exp , int L , int R , boolean desired){
        if(L == R){
            if(exp[L] == '1'){
                return desired ? 1 : 0;
            }else{ //  '0'
                return desired ? 0 : 1;
            }
        }

        // L..R 不止一个字符
        int res = 0;
        if(desired){ // 期待结果是true
            for(int i = L + 1 ; i < R ; i += 2){
                switch (exp[i]){
                    case '&':
                        res += process(exp , L , i - 1 , true) * process(exp , i + 1 , R , true);
                        break;
                    case '|':
                        res += process(exp , L , i - 1 , true) * process(exp , i + 1 , R , true);
                        res += process(exp , L , i - 1 , false) * process(exp , i + 1 , R , true);
                        res += process(exp , L , i - 1 , true) * process(exp , i + 1 , R , false);
                        break;
                    case '^':
                        res += process(exp , L , i - 1 , true) * process(exp , i + 1 , R , false);
                        res += process(exp , L , i - 1 , false) * process(exp , i + 1 , R , true);
                        break;
                }
            }
        }else{ // 期待是false
            for(int i = L + 1 ; i < R ; i += 2){
                switch (exp[i]){
                    case '&':
                        res += process(exp , L , i - 1 , false) * process(exp , i + 1 , R , false);
                        break;
                    case '|':
                        res += process(exp , L , i - 1 , false) * process(exp , i + 1 , R , false);
                        res += process(exp , L , i - 1 , false) * process(exp , i + 1 , R , true);
                        res += process(exp , L , i - 1 , true) * process(exp , i + 1 , R , false);
                        break;
                    case '^':
                        res += process(exp , L , i - 1 , true) * process(exp , i + 1 , R , true);
                        res += process(exp , L , i - 1 , false) * process(exp , i + 1 , R , false);
                        break;
                }
            }

        }
        return res;
    }



    public static int dbLive(String express , boolean desired){
        char[] str = express.toCharArray();
        int N = str.length;
        int[][] tMap = new int[N][N];
        int[][] fMap = new int[N][N];

        for(int i = 0 ; i < N; i += 2){
            tMap[i][i] = str[i] == '1' ? 1 : 0;
            fMap[i][i] = str[i] == '0' ? 1 : 0;
        }

        for(int row = N -3 ; row >= 0 ; row =+2){
            for(int col = row + 2 ; col <= N -1 ; col += 2){


                for(int i = row + 1 ; i < col ; i += 2){
                    switch (str[i]){
                        case '&':
                            tMap[row][col] += tMap[row][col - 1] * tMap[row + 1][col];
                            break;
                        case '|':
                            tMap[row][col] += tMap[row][col - 1] * tMap[row + 1][col];
                            tMap[row][col] += fMap[row][col - 1] * tMap[row + 1][col];
                            tMap[row][col] += tMap[row][col - 1] * fMap[row + 1][col];
                            break;
                        case '^':
                            tMap[row][col] += tMap[row][col - 1] * fMap[row + 1][col];
                            tMap[row][col] += fMap[row][col - 1] * tMap[row + 1][col];
                            break;
                    }
                }
                for(int i = row + 1 ; i < col ; i += 2){
                    switch (str[i]){
                        case '&':
                            fMap[row][col] += fMap[row][col - 1] * fMap[row + 1][col];
                            break;
                        case '|':
                            fMap[row][col] += fMap[row][col - 1] * fMap[row + 1][col];
                            fMap[row][col] += fMap[row][col - 1] * tMap[row + 1][col];
                            fMap[row][col] += tMap[row][col - 1] * fMap[row + 1][col];
                            break;
                        case '^':
                            fMap[row][col] += tMap[row][col - 1] * tMap[row + 1][col];
                            fMap[row][col] += fMap[row][col - 1] * fMap[row + 1][col];
                            break;
                    }
                }

            }
        }

        return desired ? tMap[0][N-1] : fMap[0][N-1];
    }






}
