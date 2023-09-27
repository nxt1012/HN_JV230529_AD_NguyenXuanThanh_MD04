package ra.model;

public class Mark {
//    Fields
    private static int nextId;
    private int markId; // markId tự tăng
    private Student student; // không được null (khi khởi tạo từ lớp này bắt buộc phải truyền vào student
    private Subject subject; // không được null (khi khởi tạo từ lớp này bắt buộc phải truyền vào subject

    private double point; // từ 0 đến 10

//    Constructors

    public Mark() {
//        markId tự tăng
        this.markId = nextId;
        nextId++;
    }

    public Mark(Student student, Subject subject, double point) {
        //        markId tự tăng
        this.markId = nextId;
        nextId++;
        this.student = student;
        this.subject = subject;
        this.point = point;
    }
//    Methods
//    Getter/Setter

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
//   Methods
public void inputData(){
//        TODO: hiển thị danh sách học sinh và môn học cho người dùng chọn theo id nhập vào
//    nếu không có học sinh hoặc một môn học thì bắt buộc người dùng thêm học sinh và môn học trước
//    nhập thông tin điểm số từ bàn phím
}
public void displayData(){
//        Hiển thị tất cả thông tin điểm số: ID, tên học sinh, tên môn học, điểm sôa
    System.out.printf("Mã học sinh: %d - Tên học sinh: %s - Tên môn học: %s\n", this.student.getStudentId(), this.student.getStudentName(), this.subject.getSubjectName(), this.point);
}
}
