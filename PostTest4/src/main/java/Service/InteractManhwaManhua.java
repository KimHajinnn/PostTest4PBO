package Service;

import Model.ManhwaData;
import java.util.ArrayList;
import java.util.Scanner;

public class InteractManhwaManhua {
    private final ArrayList<ManhwaData> daftarManhwa = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);
    
    public InteractManhwaManhua(){
        daftarManhwa.add(new ManhwaData("Solo Leveling", "Chugong", 179, "Action/Adventure/Fantasy", "Manhwa", "Completed"));
        daftarManhwa.add(new ManhwaData("Omniscient Reader’s Viewpoint", "Redice Studio", 278, "Action/Adventure/Fantasy", "Manhwa", "Ongoing"));
        daftarManhwa.add(new ManhwaData("The Novel’s Extra (Remake)", "Jee Gab Song", 142, "Action", "Manhwa", "Ongoing"));
        daftarManhwa.add(new ManhwaData("Revenge of the Iron-Blooded Sword Hound", "I Stepped On Lego", 129, "Action/Fantasy/Martial Arts", "Manhwa", "Ongoing"));
    }
    
    private int getValidAngka(String Message){
        while (true){
            System.out.print(Message);
            if (input.hasNextInt()){
                int value = input.nextInt();
                input.nextLine();
                return value;
            }else{
                System.out.println("!!! ERROR !!! Input harus berupa angka, Silahkan anda coba lagi.");
                input.nextLine();
            }
        }
    }
    
    public void addManhwa(){
        System.out.print("Input Judul Manhwa/Manhua : ");
        String title = input.nextLine();
        System.out.print("Input Author Manhwa/Manhua : ");
        String author = input.nextLine();
        int chapter = getValidAngka("Input Manhwa/Manhua Chapter : ");
        System.out.print("Input Genre Manhwa/Manhua : ");
        String genre = input.nextLine();
        System.out.print("Input Tipe Manhwa/Manhua");
        String type = input.nextLine();
        System.out.print("Input Status Manhwa/Manhua : ");
        String status = input.nextLine();
        
        daftarManhwa.add(new ManhwaData(title, author, chapter, genre, type, status));
        System.out.println("<3 Manhwa Berhasil Ditambahkan <3");
    }
    
    public void showManhwa() {
        System.out.println("===== List Manhwa =====");
        if (daftarManhwa.isEmpty()) {
            System.out.println("List Manhwa Kosong");
        } else {
            for (int i = 0; i < daftarManhwa.size(); i++) {
                ManhwaData number = daftarManhwa.get(i);
                System.out.println("====================================");
                System.out.println("No Manhwa       : " + (i + 1));
                number.showInfoManhwaManhua();
                System.out.println("====================================");
            }
        }
    }
    
    public void updateManhwa() {
        showManhwa();
        if (daftarManhwa.isEmpty()) return;

        int index = getValidAngka("Pilih No. Manhwa untuk di update : ");

        if (index > 0 && index <= daftarManhwa.size()) {
            ManhwaData number = daftarManhwa.get(index - 1);
            System.out.println("===== Update Manhwa =====");
            System.out.println("1. Judul Manhwa");
            System.out.println("2. Author Manhwa");
            System.out.println("3. Chapter Manhwa");
            System.out.println("4. Genre Manhwa");
            System.out.println("5. Status Manhwa");
            int pilihan = getValidAngka("Pilih bagian mana yang ingin di update : ");

            switch (pilihan) {
                case 1 -> {
                    System.out.print("Input Judul terbaru : ");
                    number.setTitle(input.nextLine());
                }
                case 2 -> {
                    System.out.print("Input Author terbaru : ");
                    number.setAuthor(input.nextLine());
                }
                case 3 -> {
                    number.setChapter(getValidAngka("Input Chapter terbaru : "));
                }
                case 4 -> {
                    System.out.print("Input Genre terbaru : ");
                    number.setGenre(input.nextLine());
                }
                case 5 -> {
                    System.out.print("Input Status terbaru : ");
                    number.setStatus(input.nextLine());
                }
                default -> System.out.print("!!! Pilihan tidak Valid !!!");
            }
            System.out.println("<3 Update Berhasil <3");
        } else {
            System.out.println("!X Nomor Tidak Valid X!");
        }
    }
    
    public void deleteManhwa() {
        if (daftarManhwa.isEmpty()) return;

        int index = getValidAngka("Pilih No. Manhwa yang ingin dihapus : ");

        if (index > 0 && index <= daftarManhwa.size()) {
            daftarManhwa.remove(index - 1);
            System.out.println("<3 Manhwa Berhasil dihapus <3");
        } else {
            System.out.println("!X Nomor Tidak Valid X!");
        }
    }
    
    public void searchManhwa() {
        System.out.print("Masukkan Judul Manhwa yang ingin dicari : ");
        String keyWord = input.nextLine().toLowerCase();

        boolean found = false;
        for (ManhwaData number : daftarManhwa) {
            if (number.getTitle().toLowerCase().contains(keyWord)) {
                System.out.println("==================================");
                number.showInfoManhwaManhua();
                System.out.println("==================================");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Manhwa dengan Judul " + keyWord + " tidak ditemukan");
        }
    }
    
    public void searchManhwa(String title, String author) {
        boolean found = false;
        System.out.println("Mencari Manhwa yang Berjudul " + title + " dan yang authornya " + author);
        for (ManhwaData number : daftarManhwa) {
            if (number.getTitle().equalsIgnoreCase(title) && number.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("==================================");
                number.showInfoManhwaManhua();
                System.out.println("==================================");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Manhwa dengan Judul " + title + " dan author " + author +" tidak ditemukan");
        }
    }
}