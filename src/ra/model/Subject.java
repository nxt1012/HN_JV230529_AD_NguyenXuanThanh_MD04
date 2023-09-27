package ra.model;

public class Subject {
//    Fields
    private String subjectId; // 5 ký tự bắt đầu bằng "MH" & 3 ký tự số bất kỳ, không trùng lặp
    private String subjectName; // không được để trống, không được trùng nhau

//    Constructors

    public Subject() {
    }

    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

//    Methods
//    Getter/Setter

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
//    Methods
    public void inputData(String subjectId, String subjectName){
        // TODO
    }
    public void displayData(){
        System.out.printf("Mã môn học: %s - Tên môn học: %s");
    }

}

