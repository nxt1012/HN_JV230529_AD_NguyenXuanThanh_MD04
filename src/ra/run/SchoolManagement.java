package ra.run;

import ra.model.Mark;
import ra.model.Student;
import ra.model.Subject;
import ra.service.MarkService;
import ra.service.StudentService;
import ra.service.SubjectService;

import java.util.Scanner;

public class SchoolManagement {
    public static Student[] students = new Student[100];
    public static int currentStudentIndex = 0;
    public static Subject[] subjects = new Subject[100];
    public static int currentSubjectIndex = 0;
//    Chưa biết cần xử lý Mark kiểu gì
    public static Mark[] marks = new Mark[10000];
    public static int currentMarkIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        StudentService studentService = new StudentService(students);
        SubjectService subjectService = new SubjectService(subjects);
        MarkService markService = new MarkService(marks);

//        Menu lựa chọn điều hướng đến các menu con
        do {
            System.out.println("************************SCHOOL-MANAGEMENT*************************\n");
            System.out.println("1. Quản lý học sinh");
            System.out.println("2. Quản lý môn học");
            System.out.println("3. Quản lý điểm thi");
            System.out.println("4. Thoát");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    manageStudents(studentService, currentStudentIndex);
                    break;
                case 2:
                    manageSubjects(subjectService, currentSubjectIndex);
                    break;
                case 3:
                    manageMarks(markService, currentMarkIndex);
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập vào một số nguyên trong khoảng từ 1-4");
            }
        } while (true);
    }
// Menu quản lý student
    public static void manageStudents(StudentService studentService, int currentStudentIndex) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("**************************STUDENT-MANAGEMENT**************************");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Hiển thị danh sách tất cả học sinh đã lưu trữ");
            System.out.println("3. Thay đổi tên học sinh theo mã id");
            System.out.println("4. Xóa học sinh theo mã id"); // kiểm tra xem nếu sinh viên có điểm thi thì không xóa được
            System.out.println("6. Thoát");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
//                    Thêm mới học sinh
                    studentService.addStudent(sc, currentStudentIndex);
                    break;
                case 2:
//                    Hiển thị danh sách học sinh đã lưu trữ
                    studentService.getStudent(currentStudentIndex);
                    break;
                case 3:
//                    Thay đổi tên học sinh theo mã id
                    System.out.println("Nhập vào id học sinh muốn sửa tên");
                    int studentId = Integer.parseInt(sc.nextLine());
                    studentService.updateStudent(studentId, currentStudentIndex, sc);
                    break;
                case 4:
//                    Xóa học sinh theo mã id
                    System.out.println("Nhập vào id học sinh muốn sửa tên");
                    studentId = Integer.parseInt(sc.nextLine());
                    studentService.deleteStudent(studentId, currentStudentIndex);
                    break;
                case 5:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập vào một số nguyên trong khoảng từ 1-5");
            }

        } while (true);
    }
// Menu quản lý môn học
    public static void manageSubjects(SubjectService subjectService, int currentSubjectIndex) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("**************************SUBJECT-MANAGEMENT**************************");
            System.out.println("1. Thêm mới môn học");
            System.out.println("2. Hiển thị danh sách tất cả môn học đã lưu trữ");
            System.out.println("3. Thay đổi tên môn học theo mã id");
            System.out.println("4. Xóa môn học theo mã id"); // kiểm tra xem nếu môn học có điểm thi thì không xóa được
            System.out.println("5. Thoát");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
//                    Thêm mới môn học
                    subjectService.addSubject(sc, currentSubjectIndex);
                    break;
                case 2:
//                    Hiển thị danh sách tất cả các môn học đã lưu trữ
                    subjectService.getSubject(currentSubjectIndex);
                    break;
                case 3:
//                    Thay đổi tên môn học theo mã id
                    System.out.println("Nhập vào id học sinh muốn sửa tên");
                    int subjectId = Integer.parseInt(sc.nextLine());
                    subjectService.updateSubject(subjectId, currentStudentIndex, sc);
                    break;
                case 4:
//                    Xóa môn học theo mã id
                    System.out.println("Nhập vào id học sinh muốn sửa tên");
                    subjectId = Integer.parseInt(sc.nextLine());
                    subjectService.deleteSubject(subjectId, currentSubjectIndex);
                    break;
                case 5:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập vào một số nguyên trong khoảng từ 1-5");
            }

        } while (true);
    }
// Menu quản lý điểm thi
    public static void manageMarks(MarkService markService, int currentMarkIndex) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("**************************MARKS-MANAGEMENT**************************");
            System.out.println("1. Thêm mới điểm thi cho 1 học sinh");
            System.out.println("2. Hiển thị danh sách tất cả điểm thi theo thứ tự điểm tăng dần");
            System.out.println("3. Thay đổi điểm theo mã id");
            System.out.println("4. Xóa điểm theo mã id");
            System.out.println("5. Hiển thị danh sách điểm thi theo mã môn học");
            System.out.println("6. Hiển thị đánh giá học lực của từng học sinh theo mã môn học"); // <5 là yếu, <=6.5 là trung bình, <=8 là khá, <=9 là giỏi, còn lại là xuất sắc
            System.out.println("7. Thoát");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập vào một số nguyên trong khoảng từ 1-7");
            }

        } while (true);
    }

//    Utilities
}

