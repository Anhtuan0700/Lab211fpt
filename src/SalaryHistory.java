
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalaryHistory implements Comparable<SalaryHistory> {

    private Worker worker;
    private String date;
    private String status;
    private int workerId;
    // Constructor accepting ListWorker to access workers
    public SalaryHistory() {

    }

    public SalaryHistory(Worker worker, String formattedDate, String addStatus) {
        this.worker = worker;
        this.date = formattedDate;
        this.status = addStatus;
    }


    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Override the toString method for displaying information
    @Override
    public String toString() {
        return String.format("%-15s %-15s %10d %15.2f %10s %s",
                worker.getId(),
                worker.getName(),
                worker.getAge(),
                worker.getSalary(),
                getStatus(),
                getDate());
    }

    // Implement compareTo method (currently not supported)
    @Override
    public int compareTo(SalaryHistory o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
