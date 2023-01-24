package testng.yaml.two_models;

public class TwoModelsDataObject {
    private Login login=new Login();
    private Student student=new Student();

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
