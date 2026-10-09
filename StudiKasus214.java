import java.util.Scanner;

public class StudiKasus214 {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in); 

        // Input data mahasiswa
        System.out.print("Nama mahasiswa : ");
        String nama = key.nextLine();

        System.out.print("Jenis kegiatan (BELMAWA/BAKORMA/MANDIRI/PKM/LAINNYA) : ");
        String jenisKegiatan = key.nextLine().trim().toUpperCase();

        System.out.print("Jumlah dokumen : ");
        int jumlahDokumen = key.nextInt();

        int peringkat = 0;
        int statusPendanaanPKM = 0;

        // Pemilihan bersarang (nested IF) untuk input data spesifik kegiatan
        if (jenisKegiatan.equals("BELMAWA") || jenisKegiatan.equals("BAKORMA") || jenisKegiatan.equals("MANDIRI")) {
            System.out.print("Peringkat juara : ");
            peringkat = key.nextInt();
        } else if (jenisKegiatan.equals("PKM")) {
            System.out.print("Status pendanaan PKM (1 = lolos, 0 = tidak lolos) : ");
            statusPendanaanPKM = key.nextInt();
        }

        // Validasi kelengkapan dokumen dan ketentuan penghargaan
        if (jumlahDokumen == 4) {
            if (jenisKegiatan.equals("BELMAWA") || jenisKegiatan.equals("BAKORMA") || jenisKegiatan.equals("MANDIRI")) {
                if (peringkat >= 1 && peringkat <= 3) {
                    System.out.println("Status : Dokumen lengkap. Dana penghargaan diberikan.");
                } else {
                    System.out.println("Status : Dokumen lengkap. Dana penghargaan tidak diberikan.");
                }
            } else if (jenisKegiatan.equals("PKM")) {
                if (statusPendanaanPKM == 1) {
                    System.out.println("Status : Dokumen lengkap. Dana penghargaan diberikan.");
                } else {
                    System.out.println("Status : Dokumen lengkap. Dana penghargaan tidak diberikan.");
                }
            } else {
                System.out.println("Status : Dokumen lengkap. Dana penghargaan tidak diberikan.");
            }
        } else {
            int kurangDokumen = 4 - jumlahDokumen;
            System.out.println("Status : Dokumen tidak lengkap (kurang " + kurangDokumen + " dokumen). Dana penghargaan tidak diberikan.");
        }

        key.close();
    }
} 
