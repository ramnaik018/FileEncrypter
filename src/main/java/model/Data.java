package model;

public class Data {
    private int Id;
    private String email;
    private String fileName;
    private String filePath;

    public Data(int Id,String email, String fileName, String filePath) {
        this.Id=Id;
        this.email = email;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
