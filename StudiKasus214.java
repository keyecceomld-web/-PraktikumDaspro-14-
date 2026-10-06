import java.util.Scanner;

public class StudiKasus214 {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        // Deklarasi variabel sesuai ketentuan masukan
        String namaMahasiswa, jenisKegiatan;
        int jumlahDokumen, peringkatJuara, statusPendanaanPKM;

        // Input data
        System.out.print("Nama mahasiswa : ");
        namaMahasiswa = key.nextLine();
        
        System.out.print("Jenis kegiatan (BELMAWA/BAKORMA/MANDIRI/PKM/LAINNYA) : ");
        jenisKegiatan = key.nextLine();
        
        System.out.print("Jumlah dokumen : ");
        jumlahDokumen = key.nextInt();
        
        System.out.print("Peringkat juara : ");
        peringkatJuara = key.nextInt();
        
        System.out.print("Status pendanaan PKM (1 = lolos, 0 = tidak lolos) : ");
        statusPendanaanPKM = key.nextInt();

        // Konversi jenis kegiatan ke huruf besar agar tidak case-sensitive
        jenisKegiatan = jenisKegiatan.toUpperCase();

        // Pemilihan bersarang (Nested IF)
        if (jenisKegiatan.equals("BELMAWA") || jenisKegiatan.equals("BAKORMA") || jenisKegiatan.equals("MANDIRI")) {
            // Tingkat 1: Cek jenis lomba
            if (jumlahDokumen == 4) {
                // Tingkat 2: Cek kelengkapan dokumen[cite: 2]
                if (peringkatJuara >= 1 && peringkatJuara <= 3) {
                    // Tingkat 3: Cek peringkat juara[cite: 2]
                    System.out.println("Status : Selamat, dana penghargaan diberikan (Juara " + peringkatJuara + ").");
                } else {
                    System.out.println("Status : Dana penghargaan tidak diberikan (Bukan Juara 1, 2, atau 3).");
                }
            } else {
                int kurangDokumen = 4 - jumlahDokumen;
                System.out.println("Status : Dokumen tidak lengkap (kurang " + kurangDokumen + " dokumen). Dana penghargaan tidak diberikan.");
            }
        } 
        else if (jenisKegiatan.equals("PKM")) {
            // Tingkat 1: Cek jika jenis kegiatan PKM[cite: 2]
            if (jumlahDokumen == 4) {
                // Tingkat 2: Cek kelengkapan dokumen[cite: 2]
                if (statusPendanaanPKM == 1) {
                    // Tingkat 3: Cek status pendanaan[cite: 2]
                    System.out.println("Status : Selamat, dana penghargaan diberikan (PKM lolos pendanaan).");
                } else {
                    System.out.println("Status : Dana penghargaan tidak diberikan (PKM tidak lolos pendanaan).");
                }
            } else {
                int kurangDokumen = 4 - jumlahDokumen;
                System.out.println("Status : Dokumen tidak lengkap (kurang " + kurangDokumen + " dokumen). Dana penghargaan tidak diberikan.");
            }
        } 
        else if (jenisKegiatan.equals("LAINNYA")) {
            // Kegiatan di luar ketentuan[cite: 2]
            System.out.println("Status : Dana penghargaan tidak diberikan (Kegiatan Lainnya).");
        } 
        else {
            System.out.println("Status : Jenis kegiatan tidak valid.");

        key.close();
        }
    }
}

