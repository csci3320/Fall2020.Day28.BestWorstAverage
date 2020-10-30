public class Examples {

  public static void main(String[] args) {
    new Examples();
  }

  public Examples(){
    int[] array = new int[]{1,2,3,4,5,6,7,8,9,1};

    /* Routine 1 - Constant time complexity, O(0) or O(1)*/
    System.out.println("I have an array.");

    /* Routine 2a */
    /**
     * 1 timestep for int i=0;
     * n checks against array.length
     * n increments, i++
     * n System.out.println
     * 1 + 3*n - O(n)
     */
    for(int i = 0; i < array.length; i++){
      System.out.println(array[i]);
    }

    /* Routine 2b */
    /**
     * 1 timestep for int i = 0;
     * n checks against array.length
     * n increments, i++
     * n integer declarations
     * n if statements
     * n print statements
     * 1+5*n  - O(n)
     */
    for(int i = 0; i < array.length; i++){
      int integer = array[i];
      if(integer < 0)
        System.out.println("The integer is negative");
      else
        System.out.println("The integer is positive");
    }

    /* Routine 2c */
    /*
    1 timestep to initialize i = 0
    n times to compare i to array.length
    n times i++
    n times{
      1 timestep to initailize j = 0
      n times to compare j to array.length
      n times j++
    }
    1 + 2*n + n*(1+2*n)
    1 + 2*n + n + 2*n^2
    1 + 3*n + 2*n^2
    O(n^2)
    */

    for(int i = 0; i < array.length; i++){
      for(int j = 0; j < array.length; j++){
        System.out.println("" + i + "," + j);
      }
    }

    /* Routine 3 */
    /*
    1 timestep to initialize i = 0
    n times to compare i to array.length
    n times i++
    i - 1 ->9
    i - 2 ->8
    ...
    i - 9 ->1
    i - 10 ->0
    For the internal loop, what is the sum of 9 + 8+ ... + 1 + 0
    More importantly, What is the sum of n + n-1 + .... + 1 + 0
    The inner loop runs n*(n+1)/2 times.
    1+2*n+n*(n+1)/2
    1+2*n+n^2/2+n/2
    1+5/2*n+n^2/2
    O(n^2)
    
    */
    for(int i = 0; i < array.length; i++){
      for(int j = i+1; j < array.length; j++){//How many times does this get called?
        if(array[i] == array[j])
          System.out.println("Indeces " + i + " and " + j + " match.");
      }
    }

    /* Routine 4 */

    int toFind = 2;
    int index = find(toFind, array, 0, array.length-1);
    System.out.println("Found the index at " + index);


    /* What about an algorthm that doesn't fit in a bucket? */

    int count = 0;
    boolean cont = true;
    while(cont){
      if(Math.random() > .9){
        cont = false;
      }
      count++;
    }
    System.out.println(count);

    System.out.println("Best, Worst, Average");

    /* A concrete example */
    /*
      Best Case is O(1)
      Worst case O(n)
      Average case?
      What if the average things I'm looking for is not in my array?
      What if the average thing I'm looking for is the number 1?
      One solution: If the domain is random, i.e. I don't know anything, what would I expect the average to be?
      if it's not in our array -> O(n)
      What if it is in our array, but I don't know the number?
      With a size of 10 my options are: 1,2,3,4,5,6,7,8,9, or 10 tries. The average is (10*11/2)/10->11/2->5.5
      With a size of n, my options are: 1,2,...,n-1,n tries. The average is (n*(n+1)/2)/n->(n+1)/2->n/2+1/2->O(n)
      Average case is: O(n)

    */
    int search = 11;
    int i = 0;
    for(i = 0; i < array.length; i++){
      if(array[i] == search){
        break;
      }
    }
    System.out.println(i);

    

  }

  public int find(int toFind, int[] array, int start, int end){
    if(start == end)
      return -1;
    int middleIndex = (end-start)/2 + start;
    int middleValue = array[middleIndex];
    if(middleValue == toFind)
      return middleIndex;
    if(middleValue < toFind){
      return find(toFind, array, middleIndex, end);
    }
    return find(toFind, array, start, middleIndex);
  }

}
