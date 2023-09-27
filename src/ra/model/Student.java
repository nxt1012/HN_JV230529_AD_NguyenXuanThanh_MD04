package ra.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    //    Fields
    private static int nextId = 0;
    private int studentId; // tự động tăng
    private String studentName; // không được để trống
    private Date birthDay;
    private String address; // không được để trống
    private boolean gender = true;
    private String phone; // 10 hoặc 11 số, bắt đầu bằng số 0, không trùng lặp

    //      Constructors
    public Student() {
//        studentId tự động tăng
        this.studentId = nextId;
        nextId++;
    }

    public Student(String studentName, Date birthDay, String address, boolean gender, String phone) {
//        studentId tự động tăng
        this.studentId = nextId;
        nextId++;
        this.studentName = studentName;
        this.birthDay = birthDay;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }
//    Methods
//    Getter/Setter


    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //    Methods
    public void inputData(Scanner sc, Student[] students, int currentStudentIndex) {
        // TODO: validate dữ liệu trước khi thêm vào
        boolean isExit = true;
//        studentName => không được để trống
        System.out.println("Vui lòng nhập vào tên học sinh:");
        do {
            this.studentName = sc.nextLine();
//            check để trống
            if (!this.studentName.trim().isEmpty()) {
                break;
            } else {
                System.err.println("Tên học sinh không được để trống");
            }
        } while (isExit);
//        birthDay
        System.out.println("Vui lòng nhập vào ngày tháng năm sinh VD: 31/12/2000");
        try {
            this.birthDay = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
        } catch (ParseException e) {
            System.err.println("Nhập sai kiểu định dạng ngày tháng.");
            e.printStackTrace();
        }
//        address
        System.out.println("Vui lòng nhập vào địa chỉ học sinh:");
        do {
            this.address = sc.nextLine();
//            check để trống
            if (!this.address.trim().isEmpty()) {
                break;
            } else {
                System.err.println("Địa chỉ không được để trống");
            }
        } while (isExit);
//        gender
        System.out.println("Vui lòng nhập vào giới tính (Nam/Nữ):");
        String userInput = sc.nextLine();
        do {
//            check để trống
            if (userInput.trim().toLowerCase().equals("nam") || userInput.trim().toLowerCase().equals("nữ")) {
                if (userInput.trim().toLowerCase().equals("nam")) {
                    this.gender = true;
                    break;
                }
                if (userInput.trim().toLowerCase().equals("nữ")) {
                    this.gender = false;
                    break;
                }
            } else {
                System.out.println("Bạn phải nhập vào là 'Nam' hoặc 'Nữ'");
                break;
            }
        } while (isExit);

//        phone => 10 hoặc 11 số, bắt đầu bằng số 0, không trùng lặp
        System.out.println("Vui lòng nhập vào số điện thoại:");
        do {
            this.phone = sc.nextLine();
            String pattern = "0[0-9]{9,10}";
            Pattern regexPattern = Pattern.compile(pattern);
            Matcher matcher = regexPattern.matcher(this.phone);
            if (matcher.matches()) {
                // số điện thoại đúng định dạng
//                Check trùng lặp
                for (int i = 0; i < currentStudentIndex; i++) {
                    if (students[i].getPhone().equals(this.phone)) {
                        System.err.println("Số điện thoại đã được sử dụng");
                        return;
                    }

                }
                break;
            } else {
                System.err.println("Số điện thoại không đúng định dạng!");
            }
        } while (isExit) ;
        System.out.println("Bạn vừa thêm:");
        displayData();
        }

        public void displayData () {
            System.out.printf("Mã học sinh: %d - Tên học sinh: %s - Ngày sinh: %s\n", this.studentId, this.studentName, this.birthDay.toString());
            System.out.printf("Địa chỉ: %s - Giới tính: %s - Phone: %s\n", this.address, this.gender ? "Nam" : "Nữ", this.phone);

        }
    }
