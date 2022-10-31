public class ThreadSpawn extends Thread{

    private String threadType; // add or subtract thread
    private Warehouse warehouse;
    private int operationsCount;
    private int inventoryCurrent;//This inventory variable is only used on incorrect execution i.e. when this.bugFlag = 1
    private int bugFlag;
    

    public ThreadSpawn(String threadType, Warehouse warehouse, int operationsCount, int bugFlag){ 
        this.threadType = threadType;
        this.warehouse = warehouse;
        this.operationsCount = operationsCount;
        this.bugFlag = bugFlag;
    }
    public void run(){
        if( bugFlag == 0 ){
            if(threadType == "ADD"){//checkes the job of the thread and then perferms the appropriate operation
                warehouse.setInventory(1);
        
            }else if(threadType == "SUB"){
                warehouse.setInventory(-1);

            }            
        }else if(bugFlag == 1){
            inventoryCurrent = warehouse.getInventory();
            if(threadType == "ADD"){//checkes the job of the thread and then perferms the appropriate operation
                warehouse.updateInventory(inventoryCurrent + 1, 1);
            
            }else if(threadType == "SUB"){
                warehouse.updateInventory(inventoryCurrent - 1, 0);

            }            
        }

        if(warehouse.getOperationsCount() == (operationsCount)){//if all operations have been complet the final inventory value is created
            System.out.println("Final Inventory = " + warehouse.getInventory());
        }
    }

}