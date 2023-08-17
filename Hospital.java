import java.time.LocalDateTime;
import java.util.*;

class PatientNode {
    String patientName, doctorName;
    LocalDateTime currentTime;
    PatientNode next = null;

    PatientNode(String pnm, String dnm, LocalDateTime time) {
        patientName = pnm;
        doctorName = dnm;
        currentTime = time;
    }
}

class Patient {
    PatientNode head = null;

    void addPatient(String patientname, String doctorname) {
        LocalDateTime currentTime = LocalDateTime.now();
        PatientNode mn = new PatientNode(patientname, doctorname, currentTime);
        if (head == null) {
            head = mn;
        } else {
            mn.next = head;
            head = mn;
        }
    }

    void show() {
        // Patient Database
        PatientNode temp = head;
        if (head == null) {
            System.out.println("No record!!");
        } else {
            while (temp != null) {
                System.out.println("Patient Name:" + temp.patientName + "      Doctor Name:" + temp.doctorName
                        + "     Entry time:" + temp.currentTime);
                temp = temp.next;
            }
        }
    }
}

class DoctorNode {
    String name;
    String field;
    int empId;
    int no_of_patients = 0;
    String availability;
    DoctorNode next = null;
    int rand;

    DoctorNode(int empId, String name, String field, String avl) {
        this.empId = empId;
        this.name = name;
        this.field = field;
        this.availability = avl;
    }
}

class Doctor {
    Scanner sc = new Scanner(System.in);
    static DoctorNode head = null;
    Patient pt = new Patient();

    void add(int empId) {
        String name, field, availability;
        System.out.println("Enter name:");
        name = sc.nextLine();
        System.out.println("Enter field:");
        field = sc.nextLine();
        System.out.println("Enter availability:");
        availability = sc.nextLine();
        DoctorNode dn = new DoctorNode(empId, name, field, availability);
        if (head == null) {
            head = dn;
        } else {
            dn.next = head;
            head = dn;
        }
    }

    void show() {
        System.out.println("Doctor Database");
        DoctorNode temp = head;
        if (temp == null) {
            System.out.println("No record!!");
        } else {
            while (temp != null) {
                System.out.println("Name:" + temp.name + "    Field:" + temp.field + "    Number of patients:"
                        + temp.no_of_patients + "     Availability:" + temp.availability);
                temp = temp.next;
            }
        }
    }

    void show(int x) {
        System.out.println("Doctor Database");
        DoctorNode temp = head;
        if (temp == null) {
            System.out.println("No record!!");
        } else {
            Random rand = new Random();
            while (temp != null) {
                int r = rand.nextInt(101);
                temp.rand = r;
                System.out.println("Name:" + temp.name + "    Field:" + temp.field + "    Number of patients:"
                        + temp.no_of_patients + "     Availability:" + temp.availability + "    Doctor ID:"
                        + temp.rand);
                temp = temp.next;
            }
        }
    }

    void login(int id) {
        Scanner sc = new Scanner(System.in);
        DoctorNode temp = head;
        while (temp.empId == id) {
            temp = temp.next;
        }
        System.out.println("Do you want to add information regarding your availability? y/n");
        char ch = sc.next().charAt(0);
        ch = Character.toLowerCase(ch);
        if (ch == 'y') {
            System.out.println("Edit your availability:");
            String str = sc.nextLine();
            temp.availability = str;
        } else {
            System.out.println("Name:" + temp.name + "    Field:" + temp.field + "    Number of patients:"
                    + temp.no_of_patients + "    Availability:" + temp.availability);
        }
    }

    void cancelMeeting(String dname, int count) {
        DoctorNode temp = head;
        int x = 0;
        while (!temp.name.equalsIgnoreCase(dname) && x <= count + 1) {
            temp = temp.next;
            x++;
        }
        temp.no_of_patients--;
    }
}

class JrDoctor {
    DoctorNode head = null;

    void add(int empId) {
        Scanner sc = new Scanner(System.in);
        String name, field, availability;
        System.out.println("Enter name:");
        name = sc.nextLine();
        System.out.println("Enter field:");
        field = sc.nextLine();
        System.out.println("Enter availability:");
        availability = sc.nextLine();
        DoctorNode dn = new DoctorNode(empId, name, field, availability);
        if (head == null) {
            head = dn;
        } else {
            dn.next = head;
            head = dn;
        }
    }

    void show() {
        System.out.println("Junior Doctor Database");
        DoctorNode temp = head;
        while (temp != null) {
            System.out.println("Name:" + temp.name + "    Field:" + temp.field + "    Number of patients:"
                    + temp.no_of_patients + "     Availability:" + temp.availability);
            temp = temp.next;
        }
    }

    void login(int id) {
        Scanner sc = new Scanner(System.in);
        DoctorNode temp = head;
        while (temp.empId == id) {
            temp = temp.next;
        }
        System.out.println("Do you want to add information regarding your availability? y/n");
        char ch = sc.next().charAt(0);
        ch = Character.toLowerCase(ch);
        if (ch == 'y') {
            System.out.println("Edit your availability:");
            String str = sc.nextLine();
            temp.availability = str;
        } else {
            System.out.println("Name:" + temp.name + "    Field:" + temp.field + "    Number of patients:"
                    + temp.no_of_patients + "    Availability:" + temp.availability);
        }
    }
}

class Nurse {
    DoctorNode head = null;

    void add(int empId) {
        Scanner sc = new Scanner(System.in);
        String name, field, availability;
        System.out.println("Enter name:");
        name = sc.nextLine();
        System.out.println("Enter field:");
        field = sc.nextLine();
        System.out.println("Enter availability:");
        availability = sc.nextLine();
        DoctorNode dn = new DoctorNode(empId, name, field, availability);
        if (head == null) {
            head = dn;
        } else {
            dn.next = head;
            head = dn;
        }
    }

    void show() {
        System.out.println("Nurse Database:");
        DoctorNode temp = head;
        while (temp != null) {
            System.out.println("Name:" + temp.name + "    Field:" + temp.field + "    Number of patients:"
                    + temp.no_of_patients + "     Availability:" + temp.availability);
            temp = temp.next;
        }
    }

    void login(int id) {
        // Nurse
        Scanner sc = new Scanner(System.in);
        DoctorNode temp = head;
        while (temp.empId == id) {
            temp = temp.next;
        }
        System.out.println("Do you want to add information regarding your availability? y/n");
        char ch = sc.next().charAt(0);
        ch = Character.toLowerCase(ch);
        if (ch == 'y') {
            Scanner s = new Scanner(System.in);
            System.out.println("Edit your availability:");
            String str = s.nextLine();
            temp.availability = str;
        } else {
            System.out.println("Name:" + temp.name + "    Field:" + temp.field + "    Number of patients:"
                    + temp.no_of_patients + "    Availability:" + temp.availability);
        }
    }
}

class WorkerNode {
    String name;
    String post;
    int empId;
    char shift;
    WorkerNode next = null;

    WorkerNode(int empId, String name, String post, char shift) {
        this.empId = empId;
        this.name = name;
        this.post = post;
        this.shift = shift;
    }
}

class Worker {
    WorkerNode head;

    void add(int empId) {
        Scanner s = new Scanner(System.in);
        String name, post;
        char shift;
        System.out.println("Enter your name:");
        name = s.nextLine();
        System.out.println("Enter post:");
        post = s.nextLine();
        System.out.println("Enter your shift(A or B or C):");
        shift = s.nextLine().charAt(0);
        shift = Character.toUpperCase(shift);
        WorkerNode wn = new WorkerNode(empId, name, post, shift);
        if (head == null) {
            head = wn;
        } else {
            wn.next = head;
            head = wn;
        }
    }

    void login(int empId) {
        Scanner S = new Scanner(System.in);
        WorkerNode temp = head;
        while (temp.empId != empId) {
            temp = temp.next;
        }
        System.out.println("Do you want to change your shift?  y/n");
        char choice = S.next().charAt(0);
        choice = Character.toLowerCase(choice);
        if (choice == 'y') {
            System.out.println("Edit your shift(A or B or C)");
            char shift = S.next().charAt(0);
            shift = Character.toUpperCase(shift);
            temp.shift = shift;
        } else
            System.out.println("Name:" + temp.name + "    Post:" + temp.post + "    Shift:" + temp.shift);
    }

    void show() {
        WorkerNode temp = head;
        while (temp != null) {
            System.out.println("Name:" + temp.name + "    Post:" + temp.post + "    Shift:" + temp.shift);
            temp = temp.next;
        }
    }
}

class Hospital {
    public static void main(String args[]) {
        int empId = 0;
        int DoctorCount = 0;
        Doctor d = new Doctor();
        JrDoctor jd = new JrDoctor();
        Nurse n = new Nurse();
        Worker w = new Worker();
        Patient p = new Patient();
        int choice = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("=================Hospital Management  System===================");
            System.out.println("1)Management     2)Patient       3)Patient Database       4)Clear Screen      5)Exit");
            try {
                System.out.println("Enter choice");
                choice = sc.nextInt();
                if (choice == 1) {
                    // MANAGEMENT
                    System.out.print("Enter Management ID:");
                    String id = sc.next();
                    if (id.equals("ho")) {
                        System.out.println("Access Granted");
                        System.out.println("1)Doctor     2)Junior Doctor     3)Nurses     4)Workers");
                        int dept = sc.nextInt();
                        if (dept == 1) {
                            // Doctor
                            System.out.println("1)SignUp    2)SignIn    3)Show Database");
                            int ch = sc.nextInt();
                            if (ch == 1) {
                                // Sign Up
                                DoctorCount++;
                                empId++;
                                System.out.println("Your Employee id:" + (empId));
                                d.add(empId);
                            } else if (ch == 2) {
                                // Sign In
                                System.out.println("Enter your Employee ID:");
                                int ID = sc.nextInt();
                                d.login(ID);
                            } else if (ch == 3) {
                                d.show();
                            } else {
                                System.out.println("Invalid Input");
                            }
                        } else if (dept == 2) {
                            // jr. Doctor
                            System.out.println("1)SignUp    2)SignIn    3)Show Database");
                            int ch = sc.nextInt();
                            if (ch == 1) {
                                // Sign Up
                                empId++;
                                System.out.println("Your Employee id:" + (empId));
                                jd.add(empId);
                            } else if (ch == 2) {
                                // Sign In
                                System.out.println("Enter your Employee ID:");
                                int ID = sc.nextInt();
                                jd.login(ID);
                            } else if (ch == 3) {
                                jd.show();
                            } else {
                                System.out.println("Invalid Input");
                            }
                        } else if (dept == 3) {
                            // Nurses
                            System.out.println("1)SignUp    2)SignIn    3)Show Database");
                            int ch = sc.nextInt();
                            if (ch == 1) {
                                // Sign Up
                                empId++;
                                System.out.println("Your Employee id:" + (empId));
                                n.add(empId);
                            } else if (ch == 2) {
                                // Sign In
                                System.out.println("Enter your Employee ID:");
                                int ID = sc.nextInt();
                                n.login(ID);
                            } else if (ch == 3) {
                                n.show();
                            } else {
                                System.out.println("Invalid Input");
                            }
                        } else if (dept == 4) {
                            // Worker
                            System.out.println("1)SignUp    2)SignIn    3)Show Database");
                            int ch = sc.nextInt();
                            if (ch == 1) {
                                // SignUp
                                empId++;
                                System.out.println("Your Employee ID:" + (empId));
                                w.add(empId);
                            } else if (ch == 2) {
                                // SignIn
                                System.out.println("Enter your Employee ID:");
                                int empID = sc.nextInt();
                                w.login(empID);
                            } else if (ch == 3) {
                                // Show Database
                                w.show();
                            }
                        } else {
                            System.out.println("Invalid input");
                        }
                    } else {
                        System.out.println("Access Denied");
                    }
                } else if (choice == 2) {
                    // Patient
                    Scanner s = new Scanner(System.in);
                    System.out.println("1)See doctors    2)Cancel meeting");
                    int ch = s.nextInt();
                    if (ch == 1) {
                        System.out.println("Welcome");
                        System.out.println("We have following doctors:");
                        d.show(1);
                        // bos.fflush();
                        System.out.println("If you want an appointment, enter the Doctor ID otherwise press -1");
                        int confirm = s.nextInt();
                        s.nextLine();
                        if (confirm != -1) {
                            // s.nextLine();
                            System.out.println("Enter your name:");
                            String patientnm = s.nextLine();
                            {
                                DoctorNode temp = Doctor.head;
                                if (temp == null) {
                                    System.out.println("No record!!");
                                } else {
                                    int x = 0;
                                    while (temp.rand != confirm && x < DoctorCount) {
                                        temp = temp.next;
                                        x++;
                                    }
                                    if (x < DoctorCount) {
                                        System.out.println("Meeting Confirmed");
                                        temp.no_of_patients++;
                                        System.out.println("Doctor available at:" + temp.availability);
                                        p.addPatient(patientnm, temp.name);
                                    } else {
                                        System.out.println("Enter correct ID");
                                    }
                                }
                            }
                        } else {
                            System.out.println("Thanks for visiting");
                        }
                    } else if (ch == 2) {
                        System.out.println("Enter doctor with whom your meeting was confirmed");
                        String dname = s.nextLine();
                        d.cancelMeeting(dname, DoctorCount);
                    }
                } else if (choice == 3) {
                    p.show();
                } else if (choice == 4) {
                    // Clear Screen
                    try {
                        if (System.getProperty("os.name").contains("Windows")) {
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        } else {
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (choice == 5) {
                    // Exit
                    System.out.println("Exiting");
                    System.out.println("Thank You for visiting");
                } else {
                    System.out.println("Wrong input!!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input!!");
                System.out.println(e);
            }

        } while (choice != 5);
    }
}