
public class Warehouse{
    private int inventory = 0;
    private int operationsCount = 0;// records the operations executed so far in the program so the final inventory is not outputted early

    synchronized void setInventory(int addValue){// synchronize key word to ensure only one thread is updating the value of inventory
        inventory += addValue;
    
        if (addValue > 0 ){
            System.out.println("ADDED. Inventory size = " + inventory);
        }else{System.out.println("REMOVED. Inventory size = " + inventory);}
        operationsCount ++;
    }

    public void updateInventory(int newInventory, int opType){//this method is used when the bug flag is set to 1
        //The getInventory method is called in the ThreadSpawn class (hopefully) whilst another thred is also updating it
        //causing conflict which results in an incorrect final inventory value
        inventory = newInventory;
        if (opType > 0 ){
            System.out.println("ADDED. Inventory size = " + inventory);
        }else{System.out.println("REMOVED. Inventory size = " + inventory);}
        operationsCount ++;
    }
    public int getInventory(){
        return this.inventory;
    }
    public int getOperationsCount(){
        return this.operationsCount;
    }
        
    
    

    
}