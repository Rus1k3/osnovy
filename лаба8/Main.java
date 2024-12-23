class Person {
    private String name;
    private String surname;
    private String gender;
    private boolean active;

    public Person(String name, String surname, String gender, boolean active) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.active = active;
    }

    public void sleep() {
        System.out.println(name + " Чилит");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

class Employee extends Person {
    private String position;
    private double payment;
    private int experience;
    private String department;

    public Employee(String name, String surname, String gender, boolean active, 
                    String position, double payment, int experience, String department) {
        super(name, surname, gender, active);
        this.position = position;
        this.payment = payment;
        this.experience = experience;
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void work() {
        System.out.println(getName() + " Вкалывает " + position + " в " + department);
    }
}

class KitchenWorker extends Employee {
    private String specialty;
    private boolean hasChefTraining;

    public KitchenWorker(String name, String surname, String gender, boolean active, 
                         String position, double payment, int experience, String department,
                         String specialty, boolean hasChefTraining) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.specialty = specialty;
        this.hasChefTraining = hasChefTraining;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public boolean isHasChefTraining() {
        return hasChefTraining;
    }

    public void setHasChefTraining(boolean hasChefTraining) {
        this.hasChefTraining = hasChefTraining;
    }

    public void cook() {
        System.out.println(getName() + " Готовит " + specialty);
    }
}

class OfficeWorker extends Employee {
    private String officeNumber;
    private boolean remoteWork;

    public OfficeWorker(String name, String surname, String gender, boolean active, 
                        String position, double payment, int experience, String department,
                        String officeNumber, boolean remoteWork) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.officeNumber = officeNumber;
        this.remoteWork = remoteWork;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public boolean isRemoteWork() {
        return remoteWork;
    }

    public void setRemoteWork(boolean remoteWork) {
        this.remoteWork = remoteWork;
    }

    public void attendMeeting() {
        System.out.println(getName() + " Совещается " + officeNumber);
    }
}

class GuardWorker extends Employee {
    private String shift;
    private boolean armed;

    public GuardWorker(String name, String surname, String gender, boolean active, 
                       String position, double payment, int experience, String department,
                       String shift, boolean armed) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.shift = shift;
        this.armed = armed;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public boolean isArmed() {
        return armed;
    }

    public void setArmed(boolean armed) {
        this.armed = armed;
    }

    public void patrol() {
        System.out.println(getName() + " Патрулирует " + shift);
    }
}

public class Main {
    public static void main(String[] args) {
        KitchenWorker chef = new KitchenWorker("Константин", "Ивлев", "Муж", true, 
                                                "Чертила", 50000, 0, "Инфоциган", 
                                                "Типо кухня", true);
        chef.work();
        chef.cook();

        OfficeWorker manager = new OfficeWorker("Аким", "Чертилла", "Муж", true, 
                                                "Раб", 600, 5, "Оффис", 
                                                "10", false);
        manager.work();
        manager.attendMeeting();

        GuardWorker guard = new GuardWorker("Джон", "Смит", "Муж", true, 
                                            "охранник супермаркета", 350000000, 1000, "ОХРАНА", 
                                            "Ночь", true);
        guard.work();
        guard.patrol();
    }
}
