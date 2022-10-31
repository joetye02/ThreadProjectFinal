public class InventoryMain{
    public static void main(String args[])
      {
         int addOperations = getArgument(0, args), subtractOperations = getArgument(1, args), bugFlag = getArgument(2, args);
         ThreadSpawn threads[] = new ThreadSpawn[addOperations + subtractOperations];//creates an array which can hold all the threads needed to execute each operation
         Warehouse theWarehouse = new Warehouse();// instantiates the warehouse class which stores the toal inventory
         createThreads(theWarehouse, threads, addOperations, subtractOperations, bugFlag);

      }
      public static void createThreads(Warehouse w, ThreadSpawn threads[], int addOperations, int subtractOperations, int bugFlag){
        for(int gap = 0; gap < threads.length; gap ++){
            if(gap >= addOperations){
                threads[gap] = new ThreadSpawn("SUB", w, addOperations + subtractOperations, bugFlag);//spawn a thread which will decrement inventory

            }else{
                threads[gap] = new ThreadSpawn("ADD", w, addOperations + subtractOperations, bugFlag);// spawns a thread which will increment inventory

            }    
            threads[gap].start();//begins thread processes
        }
    }
      public static int getArgument(int index, String args[]){
        int currentArg = 0;
        if (args.length > 0) {
          try {
              currentArg = Integer.parseInt(args[index]);//Parses a command input of type integer

          } catch (NumberFormatException e) {
             System.out.println(e);
             System.err.println("Argument " + args[index] + " must be of type integer");
             System.exit(1);// if the argument is not an integer, abandon the program
          }
      }
        return currentArg;
      }
 

}