package pers.xy.DataStruct;

/**
 * 稀疏数组
 * 当需要存储的数据中含有大量无效数据，可以试用稀疏数组存储数据
 * 稀疏数组记录的是一共几行几列，有多少个不同的值
 *
 * 稀疏数组转换二维数组的思路
 * 1.遍历原始二维数组，得到有效数据的个数sum
 * 2.根据sum创建稀疏数组SparseArr int[sum + 1][3]
 * 3.将二维数组的有效值存入稀疏数组
 *
 * 稀疏数组转换原始数组的思路
 * 1.现读取稀疏数组第一行，根据第一行的数据创建原始的二维数组
 * 2.读取稀疏数组后几行的数据，并赋给原始的二维数组
 */

public class SparseArray
{
    public static void main(String[] args)
    {
        //创建一个原始原始的二维数组
        //0:表示没有棋子,1:表示黑子,2:表示蓝子;
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][4] = 1;
        chessArr1[0][5] = 2;

        //输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArr1)
        {
            for (int data : row)
            {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转换为稀疏数组
        //遍历原始二维数组
        int sum = 0;
        for (int i = 0; i < 11; i++)
        {
            for (int j = 0; j < 11; j++)
            {
                if (chessArr1[i][j] != 0)
                {
                    sum++;
                }
            }
        }

        //创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //赋值
        sparseArr[0][0] = 11;       //原始二维数组行数
        sparseArr[0][1] = 11;       //原始二维数组列数
        sparseArr[0][2] = sum;      //原始二维数组有效数据总数

        //遍历二维数组，将有效数据存放至稀疏数组中
        int count = 0;      //用于记录是第几个非0数据
        for (int i = 0; i < 11; i++)
        {
            for (int j = 0; j < 11; j++)
            {
                if (chessArr1[i][j] != 0)
                {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为：");
        for (int i = 0; i < sparseArr.length; i++)
        {
            System.out.printf("%d\t%d\t%d\t", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
            System.out.println();
        }

        //将稀疏数组恢复成原始的二维数组
        //创建原始二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //遍历稀疏数组
        for (int i = 1; i < sparseArr.length; i++)
        {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //输出原始二维数组
        System.out.println("还原后的原始的二维数组");
        for (int[] row : chessArr2)
        {
            for (int data : row)
            {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
