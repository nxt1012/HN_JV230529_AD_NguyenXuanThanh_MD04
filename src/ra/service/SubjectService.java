package ra.service;

import ra.model.Subject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubjectService {
    private Subject[] subjects;

    public SubjectService(Subject[] subjects) {
        this.subjects = subjects;
    }
//    Methods
//    Getter/Setter

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }
    //    CRUD Methods
//    Create
    public void addSubject(Scanner sc, int currentSubjectIndex){
//        TODO: Thêm môn học vào mảng
        System.out.println("Vui lòng nhập mã môn học:");
//        subjectId
        String subjectId = sc.nextLine();
        String pattern = "MH[0-9]{3}";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(subjectId);
        if(!matcher.matches()){
            System.err.println("Định dạng mã môn học không đúng");
        } else {
            this.subjects[currentSubjectIndex].setSubjectId(subjectId);
        }
//        subjectName
        System.out.println("Vui lòng nhập tên môn học:");
        String subjectName = sc.nextLine();
//        check để trống
        if(!subjectName.trim().isEmpty()){
            for (int i = 0; i < currentSubjectIndex; i++) {
                if(this.subjects[i].getSubjectName().equals(subjectName)){
                    System.err.println("Tên môn học đã tồn tại");
                } else {
                    this.subjects[i].setSubjectName(subjectName);
                }
            }
        } else {
            System.err.println("Tên môn học không được để trống");

        }
    }
    //    Read
    public void getSubject(int currentSubjectIndex){
//        TODO: Hiển thị danh sách tất cả các môn học đã lưu trữ
        for (int i = 0; i < currentSubjectIndex; i++) {
            this.subjects[i].displayData();
        }
    }
    //    Update
    public void updateSubject(int subjectId, int currentSubjectIndex, Scanner sc){
//        TODO: đổi thông tin môn học theo mã id
    }
    //    Delete
    public void deleteSubject(int subjectId, int currentSubjectIndex){
//        TODO: Xóa môn học theo mã id
    }
}
