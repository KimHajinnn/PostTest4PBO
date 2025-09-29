package Main;

import Model.ManhuaData;
import Model.SuperClass;
import Service.InteractManhwaManhua;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        InteractManhwaManhua layananManhwa = new InteractManhwaManhua();
        int menu = 0;

        do {
            System.out.println("===== Manhwa Online =====");
            System.out.println("1. Add Manhwa to Manhwa List");
            System.out.println("2. Show Manhwa List");
            System.out.println("3. Update Manhwa from Manhwa List");
            System.out.println("4. Delete Manhwa from Manhwa List");
            System.out.println("5. Search Manhwa from Manhwa List");
            System.out.println("6. Show Manhua List");
            System.out.println("7. Leaving Manhwa Online");
            System.out.print("Pilih Menu : ");

            if (!input.hasNextInt()) {
                System.out.println("Input harus berupa angka");
                input.nextLine();
                continue;
            }

            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1 -> layananManhwa.addManhwa();
                case 2 -> layananManhwa.showManhwa();
                case 3 -> layananManhwa.updateManhwa();
                case 4 -> layananManhwa.deleteManhwa();
                case 5 -> {
                    System.out.print("Masukkan Judul Manhwa : ");
                    String title = input.nextLine();
                    System.out.print("Masukkan Author Manhwa : ");
                    String author = input.nextLine();
                    layananManhwa.searchManhwa(title, author);
                }    
                case 6 -> {
                    SuperClass manhua = new ManhuaData("Magic Emperor", "Nightingale + No Two Comics", 756, "Action/Martial Arts/Fantasy/Magic/Adventure", "Manhua", "Ongoing");
                    manhua.infoTambahanKomik();
                    System.out.println("=== List Manhua ===");
                    manhua.showInfoManhwaManhua();
                }
                case 7 -> System.out.println("Keluar dari Program.<3 TERIMA KASIH <3");
                default -> System.out.println("!X Menu tidak Valid X!");
            }
        } while (menu != 7);
    }
}
