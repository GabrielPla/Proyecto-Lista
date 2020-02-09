package listItems;
import java.util.ArrayList;

public class List {
    public DataIOtext iOData = new DataIOtext();
    ArrayList<Task> list = new ArrayList<>();
    
    public List () {
        list = iOData.readFile();
    }
    
    public void addTask (String detail) {
        list.add(this.createTask(detail));
        iOData.writeArray(list);
    }
    
    public Task createTask (String detailInput) {
        Task taskCreated = new Task(detailInput);
        return taskCreated;
    }
    
    public void changeTask (int taskNumber, String detail) {
        list.set(taskNumber, this.createTask(detail));
        iOData.writeArray(list);
    }
    
    public void clearTask (int indexTask) {
        list.remove(indexTask);
        iOData.writeArray(list);
    }
    
    public void printList () {
        for (int i = 0; i < list.size(); i++){
                System.out.println( i+1 + " " + list.get(i).taskDetail);
        }
    }
    
    public int numberOfTasks () {
        return list.size();
    }
    
    public void toggleTask (int indexTask) {
        list.get(indexTask).togleTask();
        iOData.writeArray(list);
    }
    
    public String[] getArrayList () {
        String[] taskDetails = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            taskDetails[i] = list.get(i).getDetail();
        }
        
        return taskDetails;
    }
}
