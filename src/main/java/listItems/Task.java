
package listItems;

public class Task {
    
    String taskDetail;
    boolean taskIsDone;
    
    public Task(String detail) {
        taskIsDone = false;
        taskDetail = detail;
    }
    
    public void togleTask () {
        taskIsDone = !taskIsDone;
    }
    
    public void setDetail(String detail) {
        taskDetail = detail;
    }
    
    public void setState(Boolean value) {
        taskIsDone = value;
    }
    
    public String getDetail() {
        return "The task is:   " + taskDetail + "  |  State:   " + taskIsDone;
    }
    
    public String getOnlyDetail() {
        return taskDetail ;
    }
    
    public String getStateString() {
        return String.valueOf(taskIsDone);
    }
    
    @Override
    public String toString() {
        return "The task is: " + taskDetail +" is it done? " + taskIsDone;
    }

}
