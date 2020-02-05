public class TrappingRainWater {
    public int trap1(int[] height) {
       int count = 0;
       int n = height.length;
       int max = 0;
       for (int i =0;i<n;i++){
           if(height[i]>max) max = height[i];
       }
       int left;
       int nl = 0,nr = n,nrtemp = n-1;
       boolean hasnl = false;
       boolean flag = false;
       int temp = 0;
       for (int i =0;i<max;i++){
           hasnl = false;
           flag = false;
           left = 0;
           nr = nrtemp+1;
           for (int j =nl;j<nr;j++){
               if(!flag&&height[j]!=0){
                   height[j]--;
                   left = j;
                   flag = true;
               }else if(flag&&height[j]!=0){
                   height[j]--;
                   temp = j-left-1;
                   left = j;
                   count += temp;
               }
               if(!hasnl && height[j]>0){
                   hasnl = true;
                   nl = j;
               }else if(hasnl && height[j]>0){
                   nrtemp = j;
               }
           }
       }
        return count;
    }

    public int trap(int[] height) {
        int n = height.length;
        int count = 0;
        boolean hasl = false;
        int left = 0,right;
        int reduce = 0,tempReduce = 0;
        for (int i=0;i<n;i++){
            if(!hasl&&height[i]>0){
                left = i;
                hasl = true;
            }else if(hasl&&height[i]>0){
                if(height[i]>=height[left]){
                    count += (i-left-1)*height[left];
                    left = i;
                }else {
                    int current = i;
                    int next = i+1;
                    tempReduce = 0;
                    while (next<n&&height[next]<=height[left]){
                        tempReduce += height[current];
                        current++;
                        next++;
                    }
                    if()
                    count += (current-left-1)*Math.min(height[current],height[left]);
                    reduce += tempReduce;
                    i = current;
                    left = i;
                }
            }
        }
        return count - reduce;
    }

    public static void main(String[] args) {
//        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] height = new int[]{2,0,2};
//        int[] height = new int[]{5,4,1,2};
        int[] height = new int[]{5,2,1,2,1,5};
        System.out.println(new TrappingRainWater().trap(height));
    }
}
