package RePractice.Meituan_2019;

import java.util.*;


public class Code_0514_2 {
    //
    static class Pair implements Comparable<Pair>{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }


        @Override
        public int compareTo(Pair o) {
            return this.first - o.first ;
        }
    }
    public static void main(String[] agrs){
        int n,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Map<Integer,Integer> BS = new HashMap<>();
        Map<Integer,Integer> AS = new HashMap<>();
        for (int i = 0;i < n;i++){
            for (int j = 0;j < m;j++){
                int x;
                x = sc.nextInt();
                if ((i + j) % 2 == 1){
                    AS.put(x, AS.getOrDefault(x,0) + 1);
                }else {
                    BS.put(x, AS.getOrDefault(x,0) + 1);
                }
            }
        }
        List<Pair> A = new ArrayList<>();
        List<Pair> B = new ArrayList<>();
        for (Integer item : AS.keySet()){
            A.add(new Pair(AS.get(item),item));
        }
        for (Integer item : BS.keySet()){
            B.add(new Pair(BS.get(item),item));
        }
        //根据第一个关键字，从大到小排列
        //这样就可以对自定义结构排序！
        Collections.sort(A);
        Collections.reverse(A);
        Collections.sort(B);
        Collections.reverse(B);

        int res = 0;
        for (int i = 0;i < 2 && i < A.size();i++){
            for (int j = 0;j < 2 && j < B.size();j++){
                if (A.get(i).second == B.get(j).second){
                    res = Math.max(res, Math.max(A.get(i).first,B.get(j).first));
                }else {
                    res = Math.max(res,A.get(i).first + B.get(j).first);
                }
            }
        }
        if (A.size() == 0){
            res = B.get(0).first;
        }
        if (B.size() == 0){
            res = A.get(0).first;
        }
        System.out.println(n * m - res);
    }

//        public static void main(String[] args)
//        {
//            Scanner sc = new Scanner(System.in);
//            while(sc.hasNextInt())
//            {
//                int n = sc.nextInt();
//                int m = sc.nextInt();
//                int [][] nums = new int[n][m];
//                //int temp = sc.nextInt();犯了一个愚蠢的错误，本来要用temp给nums[i][j]赋值，结果光写了个sc.nextInt()导致程序一直超时。。。。'''
//                for(int i=0;i<n;i++)
//                {
//                    for(int j =0;j<m;j++)
//                    {
//                        nums[i][j]=sc.nextInt();
//                    }
//                }
//
//                HashMap<Integer,Integer> map1=new HashMap<Integer,Integer>();
//                HashMap<Integer,Integer> map2=new HashMap<Integer,Integer>();
//                int max_num1=0;
//                int max_num2=0;
//                for(int x=0;x<n;x++){
//                    for(int y=0;y<m;y++)
//                    {
//                        if(1==(x+y)%2)
//                        {
//                            if(map1.containsKey(nums[x][y]))
//                            {
//                                map1.put(nums[x][y],map1.get(nums[x][y])+1);
//                            }
//                            else
//                            {
//                                map1.put(nums[x][y],1);
//                            }
//                            max_num1=Math.max(max_num1,map1.get(nums[x][y]));
//                        }
//                        if(0==(x+y)%2)
//                        {
//                            if(map2.containsKey(nums[x][y]))
//                            {
//                                map2.put(nums[x][y],map2.get(nums[x][y])+1);
//                            }
//                            else
//                            {
//                                map2.put(nums[x][y],1);
//                            }
//                            max_num2=Math.max(max_num2,map2.get(nums[x][y]));
//                        }
//                    }
//                }
//                //Collection<Integer> count1=map1.values;
//                //Collection<Integer> count2=map2.values;
//                //int max_num1=Collections.max(count1);
//                //int max_num2=Collections.max(count2);
//                int num1=0,num2=0;
//                for(Map.Entry<Integer,Integer> entry:map1.entrySet())
//                {
//                    if(max_num1==entry.getValue())
//                    {
//                        num1=entry.getKey();
//                    }
//                }
//                for(Map.Entry<Integer,Integer> entry:map2.entrySet())
//                {
//                    if(max_num2==entry.getValue())
//                    {
//                        num2=entry.getKey();
//                    }
//                }
//                int flag=0;
//                if(num1==num2)
//                {
//                    map2.remove(num2);
//                    if(!map2.isEmpty()){
//                        for(int x=0;x<n;x++){
//                            for(int y=0;y<m;y++)
//                            {
//                                if(0==(x+y)%2&&nums[x][y]!=num2)
//                                {
//                                    max_num2=Math.max(max_num2,map2.get(nums[x][y]));
//                                }
//                            }
//                        }
//
//                        for(Map.Entry<Integer,Integer> entry:map2.entrySet())
//                        {
//                            if(max_num2==entry.getValue())
//                            {
//                                num2=entry.getKey();
//                            }
//                        }
//                    }
//                    else
//                    {
//                        flag=1;
//                        num2=num1+1;
//                    }
//
//                }
//                int sum=0;
//                for(int x=0;x<n;x++){
//                    for(int y=0;y<m;y++)
//                    {
//                        if(1==(x+y)%2)
//                        {
//                            if(nums[x][y]!=num1)
//                            {
//                                sum++;
//                            }
//                        }
//                        if(0==(x+y)%2)
//                        {
//                            if(nums[x][y]!=num2)
//                            {
//                                sum++;
//                            }
//                        }
//                    }
//                }
//                if(flag==1)
//                {
//                    sum=Math.min(sum,n*m-sum);
//                }
//                System.out.println(sum);
//                for(int x=0;x<n;x++){
//                    for(int y=0;y<m;y++)
//                    {
//                        System.out.println(nums[x][y]);
//                    }
//                }
//            }
//        }
    }

