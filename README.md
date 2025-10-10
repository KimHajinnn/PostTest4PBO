# PostTest4PBO

    NAMA     : Christian Amsal Asimaro Lumban Tobing
    NIM      : 2409116053

# A. DESKRIPSI SINGKAT
Hasil Pengerjaan PostTest dengan Tema _**"Manajemen Daftar Komik Online"**_ merupakan sebuah Aplikasi Manajemen Komik berbasis Teks dengan membuat 3 Package untuk menjalankan programnya yaitu :
1. Package Model {_'SuperClass.java', 'ManhwaData.java' & 'ManhuaData.java'_} (Sebagai tempat atribut dan constructor)
2. Package Service {_'InteractManhwa/Manhua.java'_} (CRUD: tambah, tampil, update, hapus & tambahan fitur Search)
menerapkan konsep CRUD (Create, Read, Update, Delete) yang dimana memungkinkan pengguna untuk :
- Menambah Data Manhwa
- Melihat Daftar Manhwa
- Mengubah Data Manhwa
- Menghapus Data Manhwa.
3. Package Main {_'Main.java'_} (Sebagai Menu Utama Program)

# B. DESKRIPSI CLASS
1. SuperClass (Superclass)
  - untuk menyimpan atribut umum seperti title (judul), author, status.
  - Menerapkan Encapsulation (getter & setter).
  - Membuat Method showInfoManhwa/Manhua() untuk menampilkan informasi umum publikasi.
2. ManhwaData (Subclass dari SuperClass)
  - Tambahan atribut Seperti chapter, genre.
  - Override method showInfoManhwa/Manhua() untuk menampilkan detail lebih lengkap.
3. ManhuaData (Subclass dari SuperClass)
  - Struktur sama seperti ManhwaData, tapi digunakan untuk komik Manhua.
4. InteractManhwa/Manhua (Service)
  - Menyediakan fitur CRUD:
      - Add Untuk menambah data manhwa baru.
      - Show untuk menampilkan seluruh daftar manhwa.
      - Update untuk mengubah data berdasarkan nomor manhwa.
      - Delete untuk menghapus data dari daftar.
      - Search untuk mencari manhwa berdasarkan judul.
  - Menggunakan ArrayList untuk menyimpan data.
5. Main (Program Utama)
  - Menyediakan menu interaktif.
  - Memanggil service CRUD dari InteractManhwa/Manhua.
  - Menambahkan Tampilkan data ManhuaData.

# ALUR PROGRAM
1. User menjalankan File Main.java.
2. Menu ditampilkan:
   - Tambah Manhwa
   - tampilkan List Manhwa
   - update Manhwa
   - hapus Manhwa
   - cari manhwa.
   - Lihat data Manhua yang ada.
3. Program berjalan secara berulang, sampai user memilih keluar.

# PENJELASAN ENCAPSULATION, INHERITANCE DAN OVERRIDING
## ENCAPSULATION
Menggunakan Encapsulation dengan mengatur semua atribut bersifat Private, yang dimana akses data hanya bisa dilakukan dengan Getter & Setter.
## INHERITANCE
Membuat file java baru (SuperClass) untuk mengaturnya menjadi file Superclass yang dimana file ManhwaData.java dan ManhuaData.java menjadi subclass yang mewarisi atribut dan method dari superclass (SuperClass.java).
## OVERRIDING
Membuat method showInfoManhwa/Manhua di SuperClass.java dioverride oleh ManhwaData.java dan ManhuaData.java agar dapat menampilkan info tambahan dari SuperClass.java

# OUTPUT

<img width="264" height="515" alt="image" src="https://github.com/user-attachments/assets/28b72345-0c4f-4dd9-9048-6413fbc0ae31" />

Menampilkan List Manhwa

<img width="398" height="243" alt="image" src="https://github.com/user-attachments/assets/9181c1e3-cddf-428e-a70b-b6ca427b5909" />

Menampilkan List Manhua

# PENERAPAN ABSTRACTION & POLYMORPHISM
## ABSTRACTION
```java
public abstract class SuperClass {
```
```java
  public abstract void infoTambahanKomik();
```
Penjelasan :
  - Class SuperClass didefinisikan menjadi class Abstrak
  - Menambahkan Abstract void infoTambahanKomik() yang isinya kosong.
  - Method abstract ini membuat setiap class turunan seperti ManhuaData dan ManhwaData untuk harus mengimplementasikan method infoTambahanKomik();

## POLYMORPHISM
### OVERLOADING
```java
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
```
Penjelasan :
  - awalnya sudah ada method searchManhwa() yang mencari berdasarkan judul yang di cari.
  - ditambahkan method searchManhwa(String title, String author) untuk mencari manhwa berdasarkan judul dan author.
  - dan pada saat program dijalankan, yang muncul adalah method searchManhwa(String title, String author).

### OVERRIDING
```java
    @Override
    public void infoTambahanKomik() {
        System.out.println("Ini adalah Manhwa " + getTitle() + "dengan " + chapter + "Chapter");
```
```java
    @Override
    public void infoTambahanKomik() {
        System.out.println("Ini adalah Manhua " + getTitle() + "dengan " + chapter + " Chapter");
```
Penjelasan :
  - karena pada file SuperClass memakai abstract method infoTambahanKomik(), maka subclass harus mengimplementasikan method tersebut.
  - di implementasikan di dalam masing masing file ManhuaData dan ManhwaData.

# Output

<img width="509" height="396" alt="Screenshot 2025-10-10 130214" src="https://github.com/user-attachments/assets/18eead9e-54b4-4f10-9bbc-85d8a26b2bfd" />

<img width="665" height="258" alt="Screenshot 2025-10-10 130228" src="https://github.com/user-attachments/assets/642cfd58-c0c1-40dc-87e2-2007c469ed15" />

<img width="510" height="289" alt="Screenshot 2025-10-10 130305" src="https://github.com/user-attachments/assets/c370653c-86ba-4add-9dd0-b2f414d98813" />

<img width="505" height="224" alt="Screenshot 2025-10-10 130317" src="https://github.com/user-attachments/assets/ccab2734-5134-4b7a-b813-2ec32998b19c" />

<img width="633" height="380" alt="Screenshot 2025-10-10 130327" src="https://github.com/user-attachments/assets/ec9394b5-3f87-460c-9bc5-ba1644288de5" />



