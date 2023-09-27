package ra.service;

import ra.model.Student;

import java.util.Scanner;

public class StudentService {
    private Student[] students;

    public StudentService(Student[] students) {
        this.students = students;
    }
//    Methods
//    Getter/Setter

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
//    CRUD Methods
//    Create
    public void addStudent(Scanner sc, int currentStudentIndex){
//        TODO: Thêm học sinh vào mảng
//        Gọi đến inputData của Student ở đây để thêm sinh viên
        System.out.println("Vui lòng nhập số lượng sinh viên muốn thêm thông tin:");
        int numberOfStudents = Integer.parseInt(sc.nextLine());
//        Nếu số lượng chỗ trống không còn đủ thì không cho thêm
        if(numberOfStudents < this.students.length - currentStudentIndex){
            for (int i = 0; i < numberOfStudents; i++) {
//                Nhập thông tin cho từng học viên
                this.students[currentStudentIndex] = new Student();
                this.students[currentStudentIndex].inputData(sc, this.students, currentStudentIndex);
                currentStudentIndex++;
            }
        } else {
            System.err.println("Số vị trí còn trống không đủ");
        }
//
    }
//    Read
    public void getStudent(int currentStudentIndex){
//        TODO: hiển thị hết các thông tin về học sinh đã lưu trữ
        for (int i = 0; i < currentStudentIndex; i++) {
            this.students[i].displayData();
        }
    }
//    Update
    public void updateStudent(int studentId, int currentStudentIndex, Scanner sc){
//        TODO: cập nhật tên học sinh trong cơ sở dữ liệu
        boolean found = false;
        for (int i = 0; i < currentStudentIndex; i++) {
            if(this.students[i].getStudentId() == studentId){
                found = true;
                System.out.println("Nhập tên mới:");
                this.students[i].setStudentName(sc.nextLine());
            }
        }
        if(!found){
            System.out.println("Không tồn tại id học sinh này trong cơ sở dữ liệu");
        }
    }
//    Delete
    public void deleteStudent(int studentId, int currentStudentIndex){
//        TODO: xóa học sinh trong cơ sở dữ liệu
        boolean found = false;
        int deleteIndex = -1;
        for (int i = 0; i < currentStudentIndex; i++) {
            if(this.students[i].getStudentId() == studentId){
                found = true;
                deleteIndex = i;
            }
        }
        if(!found){
            System.out.println("Không tồn tại id học sinh này trong cơ sở dữ liệu");
        } else {
//            TODO: kiểm tra học sinh có điểm thi hay không xong mới xóa

            for (int i = deleteIndex; i < currentStudentIndex-1; i++) {
                this.students[i] = this.students[i+1];
            }
            this.students[currentStudentIndex] = null;
        }
    }
}
