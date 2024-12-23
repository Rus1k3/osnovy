import java.util.*;

class Student {
    private String firstName;
    private String lastName;
    private String patronymic;
    private int age;
    private double averageGrade;
    private double stepyha;
    private int attendedClasses;
    private int missedClasses;
    private String gender;

    public Student(String firstName, String lastName, String patronymic, int age, double averageGrade, 
                   double stepyha, int attendedClasses, int missedClasses, String gender) {
        if (firstName.equals("Алексей") && lastName.equals("Белоусов")) {
            throw new IllegalArgumentException("Такой студент не может существовать");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.age = age;
        this.averageGrade = averageGrade;
        this.stepyha = stepyha;
        this.attendedClasses = attendedClasses;
        this.missedClasses = missedClasses;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public double getstepyha() {
        return stepyha;
    }

    public void setstepyha(double stepyha) {
        this.stepyha = stepyha;
    }

    public void addAttendance(boolean attended) {
        if (attended) {
            this.attendedClasses++;
        } else {
            this.missedClasses++;
        }
    }

    public double getAttendancePercentage() {
        int totalClasses = attendedClasses + missedClasses;
        return totalClasses == 0 ? 0 : (attendedClasses * 100.0) / totalClasses;
    }

    @Override
    public String toString() {
        return String.format("ФИО: %s %s %s, Возраст: %d, Средняя оценка: %.2f, Стипендия: %.2f, Посещаемость: %.2f%%",
                lastName, firstName, patronymic, age, averageGrade, stepyha, getAttendancePercentage());
    }
}

class AverageGradeComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getAverageGrade(), s1.getAverageGrade());
    }
}

class stepyhaComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getstepyha(), s1.getstepyha());
    }
}

class AgeComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}

class AttendanceComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getAttendancePercentage(), s1.getAttendancePercentage());
    }
}

public class StudentManagement {
    private static TreeSet<Student> studentsByGrade = new TreeSet<>(new AverageGradeComparator());
    private static TreeSet<Student> studentsBystepyha = new TreeSet<>(new stepyhaComparator());
    private static TreeSet<Student> studentsByAge = new TreeSet<>(new AgeComparator());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Изменить оценку студента");
            System.out.println("4. Изменить стипендию студента");
            System.out.println("5. Добавить посещение/не посещение");
            System.out.println("6. Отобразить список студентов");
            System.out.println("0. Выйти");
            System.out.print("Ваш выбор: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addStudent(scanner);
                    case 2 -> removeStudent(scanner);
                    case 3 -> updateGrade(scanner);
                    case 4 -> updatestepyha(scanner);
                    case 5 -> addAttendance(scanner);
                    case 6 -> displayStudents();
                    case 0 -> {
                        System.out.println("Выход........");
                        return;
                    }
                    default -> System.out.println("Некорректный выбор");
                }
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста введите чтото");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        try {
            System.out.print("Введите имя: ");
            String firstName = scanner.nextLine();
            System.out.print("Введите фамилию: ");
            String lastName = scanner.nextLine();
            System.out.print("Введите отчество: ");
            String patronymic = scanner.nextLine();
            System.out.print("Введите возраст: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Введите среднюю оценку: ");
            double grade = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите стипендию: ");
            double stepyha = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите количество посещенных занятий: ");
            int attended = Integer.parseInt(scanner.nextLine());
            System.out.print("Введите количество пропущенных занятий: ");
            int missed = Integer.parseInt(scanner.nextLine());
            System.out.print("Введите пол: ");
            String gender = scanner.nextLine();

            Student student = new Student(firstName, lastName, patronymic, age, grade, stepyha, attended, missed, gender);
            studentsByGrade.add(student);
            studentsBystepyha.add(student);
            studentsByAge.add(student);
            System.out.println("Студент успешно добавлен");
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод числовых значений");
        }
    }

    private static void removeStudent(Scanner scanner) {
        System.out.print("Введите фамилию студента для удаления: ");
        String lastName = scanner.nextLine();
        studentsByGrade.removeIf(s -> s.getLastName().equals(lastName));
        studentsBystepyha.removeIf(s -> s.getLastName().equals(lastName));
        studentsByAge.removeIf(s -> s.getLastName().equals(lastName));
        System.out.println("Студент успешно удален");
    }

    private static void updateGrade(Scanner scanner) {
        System.out.print("Введите фамилию студента для изменения оценки: ");
        String lastName = scanner.nextLine();
        System.out.print("Введите новую среднюю оценку: ");
        double newGrade = Double.parseDouble(scanner.nextLine());

        studentsByGrade.forEach(student -> {
            if (student.getLastName().equals(lastName)) {
                student.setAverageGrade(newGrade);
            }
        });
    }

    private static void updatestepyha(Scanner scanner) {
    }

    private static void addAttendance(Scanner scanner) {
    }

    private static void displayStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nОтобразить список студентов:");
        System.out.println("1. Сортировка по средней оценке");
        System.out.println("2. Сортировка по стипендии");
        System.out.println("3. Сортировка по возрасту");
        System.out.println("4. Сортировка по проценту посещаемости");
        System.out.print("Ваш выбор: ");
    
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.println("\nСписок студентов сортировка по средней оценке:");
                    studentsByGrade.forEach(System.out::println);
                }
                case 2 -> {
                    System.out.println("\nСписок студентов сортировка по стипендии:");
                    studentsBystepyha.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("\nСписок студентов сортировка по возрасту:");
                    studentsByAge.forEach(System.out::println);
                }
                case 4 -> {
                    System.out.println("\nСписок студентов сортировка по проценту посещаемости:");
                    TreeSet<Student> studentsByAttendance = new TreeSet<>(new AttendanceComparator());
                    studentsByAttendance.addAll(studentsByGrade);
                    studentsByAttendance.forEach(System.out::println);
                }
                default -> System.out.println("");
            }
        } catch (NumberFormatException e) {
            System.out.println("Пожалуйста введите число");
        }
    }
    
}
