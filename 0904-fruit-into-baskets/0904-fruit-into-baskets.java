class Solution {
    public int totalFruit(int[] fruits) {
    /*  int[][] array = new int[3][2];
      for(int i=0;i<3;i++)
      for(int j=0;j<2;j++)
       array[i][j]=-1;*/
      int count=0,temp=-1,temp2=-1,temp_c=0,temp2_c=0,i;
      for(i=0;i<fruits.length;i++)
      {
          if(temp==-1||temp==fruits[i])
          {
              temp=fruits[i];
              temp_c++;
          }
          else if(temp2==-1||fruits[i]==temp2)
          {
              temp2=fruits[i];
              temp2_c++;
          }
          else
          {
               if(temp_c+temp2_c>count)
                count=temp_c+temp2_c;
                temp=fruits[i-1];
                temp_c=0;
                int t=i-1;
                while(t>-1 && temp==fruits[t--])
                 temp_c++;
                temp2_c=1;
                temp2=fruits[i];
          }
      }
      if(temp_c+temp2_c>count)
                count=temp_c+temp2_c;
      return count;
    }
}