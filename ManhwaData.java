package Model;

public class ManhwaData extends SuperClass {
    private int chapter;
    private String genre;
    private String type;

    public ManhwaData(String title, String author, int chapter, String genre, String type, String status) {
        super(title, author, status);
        this.chapter = chapter;
        this.genre = genre;
        this.type = type;
    }

    public int getChapter() {
        return chapter;
    }

    public String getGenre() {
        return genre;
    }

    public String getType() {
        return type;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    @Override
    public void showInfoManhwaManhua() {
        super.showInfoManhwaManhua();
        System.out.println("Chapter : " + chapter);
        System.out.println("Genre   : " + genre);
        System.out.println("Type    : " + type);
    }
    
    @Override
    public void infoTambahanKomik() {
        System.out.println("Ini adalah Manhwa " + getTitle() + "dengan " + chapter + "Chapter");
    }
}