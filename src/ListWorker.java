
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListWorker {

    private ArrayList<Worker> workers;
    private ArrayList<SalaryHistory> salaryHistories;

    public ListWorker() {
        this.workers = new ArrayList<>();
        this.salaryHistories = new ArrayList<>();
    }

    public boolean addWorker(Worker worker) {

        if (findWorkerById(worker.getId()) != null) {
            System.out.println("Error adding worker: Worker ID already exists.");
            return false;
        }

        workers.add(worker);
        return true;
    }

    public Worker findWorkerById(String id) {
        for (Worker worker : workers) {
            if (worker.getId().equals(id)) {
                return worker;
            }
        }

        return null;
    }

    public boolean changeSalary(String status, String id, double amount) throws Exception {

        Worker worker = findWorkerById(id);

        if (worker == null) {
            throw new Exception("Worker not found.");
        }

        if (amount <= 0) {
            throw new Exception("Amount must be greater than 0.");
        }

        // Cập nhật lương worker
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(new Date());

        if (status.equals("INCREASE")) {

            worker.setSalary(worker.getSalary() + amount);

            SalaryHistory history = new SalaryHistory(worker, formattedDate, "UP");
            salaryHistories.add(history);
       
        } else if (status.equals("DECREASE")) {

            if (worker.getSalary() < 0) {
                throw new Exception("Salary cannot be negative.");
            }
            worker.setSalary(worker.getSalary() - amount);
            SalaryHistory history = new SalaryHistory(worker, formattedDate, "DOWN");
            salaryHistories.add(history);
        } else {
            throw new Exception("Invalid status.");
        }
 
        return true;
    }

    // Get salary history information
    public List<SalaryHistory> getInformationSalary() {
        System.out.println(salaryHistories);
        return salaryHistories;
    }

    public List<Worker> getWorkerList() {

        return new ArrayList<>(workers); // Return a copy of the list to avoid external modification
    }
}
