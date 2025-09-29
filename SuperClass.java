package Model;

public abstract class SuperClass {
    private String title;
    private String author;
    private String Status;
    
    public SuperClass(String title, String author, String status) {
        this.title = title;
        this.author = author;
        this.Status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getStatus() {
        return Status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
    public void showInfoManhwaManhua() {
        System.out.println("Judul   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("Status  : " + Status);
    }
    
    public abstract void infoTambahanKomik();
}