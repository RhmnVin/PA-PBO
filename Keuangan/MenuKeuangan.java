package Keuangan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;


public class MenuKeuangan {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Debit> debit = new ArrayList<Debit>();
    static ArrayList<Kredit> kredit = new ArrayList<Kredit>();
    static Debit debitt = new Debit();
    static Kredit kreditt = new Kredit();
    static int totalDebit, totalKredit, Total;


    public static void main(String[] args) throws Exception{
        menu();
    }

    public static void menu() throws Exception{
        Total = totalDebit-totalKredit;
        while(true){
            System.out.println(" ");
            System.out.println("     SELAMAT DATANG");
            System.out.println("    PROGRAM KEUANGAN");
            System.out.println("Uang Anda: "+ Total);
            System.out.println("=====================================");
            System.out.println("1. Kategori Pemasukkan");
            System.out.println("2. Kategori Pengeluaran");
            System.out.println("3. Keseluruhan");
            System.out.println("4. Keluar Program");

            System.out.println("=====================================");
            System.out.print("Masukkan pilihan anda: ");
            int pilihan = Integer.parseInt(br.readLine());
            switch(pilihan){
                case 1:
                    menu(debitt);
                    break;
                case 2:
                    menu(kreditt);
                    break;
                case 3:
                    lihat();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak ada");
                    break;
            }

        }
    }

    public static void menu(Debit debitt) throws Exception{
        while(true){
            System.out.println(" ");
            System.out.println("    KATEGORI PEMASUKKAN");
            System.out.println("=====================================");
            System.out.println("1. Tambah Pemasukkan");
            System.out.println("2. Lihat Pemasukkan");
            System.out.println("3. Edit Pemasukkan");
            System.out.println("4. Hapus Pemasukkan");
            System.out.println("5. Kembali");
            System.out.println("=====================================");
            System.out.print("Masukkan pilihan anda: ");
            int pilihan = Integer.parseInt(br.readLine());
            switch(pilihan){
                case 1:
                    tambah(debitt);
                    break;
                case 2:
                    lihat(debitt);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("Pilihan tidak ada");
                    break;
            }

        }
    }

    public static void menu(Kredit kreditt) throws Exception{
        while(true){
            System.out.println(" ");
            System.out.println("    KATEGORI PENGELUARAN");
            System.out.println("=====================================");
            System.out.println("1. Tambah Pengeluaran");
            System.out.println("2. Lihat Pengeluaran");
            System.out.println("3. Edit Pengeluaran");
            System.out.println("4. Hapus Pengeluaran");
            System.out.println("5. Kembali");
            System.out.println("=====================================");
            System.out.print("Masukkan pilihan anda: ");
            int pilihan = Integer.parseInt(br.readLine());
            switch(pilihan){
                case 1:
                    tambah(kreditt);
                    break;
                case 2:
                    lihat(kreditt);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("Pilihan tidak ada");
                    break;
            }

        }
    }

    public static void tambah(Debit debitt) throws IOException{
        String addjenis;
        System.out.print("Masukkan Nama Pemasukkan: ");
        String addNama = br.readLine();
        System.out.println("1. Bulanan");
        System.out.println("2. Bonus");
        System.out.println("3. Upah");
        System.out.println("4. Lainnya");
        System.out.print("Pilihlah Jenis Pemasukkan: ");
        int pilih = Integer.parseInt(br.readLine());
        if (pilih == 1){
             addjenis = "Bulanan";
        }else if (pilih==2) {
             addjenis = "Bonus";
        }  else if(pilih==3){
             addjenis = "Upah";
        } else {
             addjenis = "Lainnya"; 
        }
        System.out.print("Masukkan Jumlah Pemasukkan: ");
        int addJumlah = Integer.parseInt(br.readLine());
        totalDebit += addJumlah;
        System.out.print("Masukkan Catatan Pemasukkan: ");
        String addCatat = br.readLine();
        System.out.print("Masukkan Tanggal Pemasukkan: ");
        String addTanggal = br.readLine();
        Debit pemasukkan = new Debit(addNama, addJumlah, addTanggal, addCatat, addjenis,null);
        debit.add(pemasukkan);
    }

    public static void tambah(Kredit kreditt) throws Exception{
        String addjenis;
        System.out.print("Masukkan Nama Pengeluaran: ");
        String addNama = br.readLine();
        System.out.println("1. Makanan");
        System.out.println("2. Transportasi");
        System.out.println("3. Pakaian");
        System.out.println("4. Lainnya");
        System.out.print("Pilihlah Jenis Pengeluaran: ");
        int pilih = Integer.parseInt(br.readLine());
        if (pilih == 1){
             addjenis = "Makanan";
        }else if (pilih==2) {
             addjenis = "Transportasi";
        }  else if(pilih==3){
             addjenis = "Pakaian";
        } else {
             addjenis = "Lainnya"; 
        }
        System.out.print("Masukkan Jumlah Pengeluaran: ");
        int addJumlah = Integer.parseInt(br.readLine());
        totalKredit += addJumlah;
        System.out.print("Masukkan Catatan Pengeluaran: ");
        String addCatat = br.readLine();
        System.out.print("Masukkan Tanggal Pengeluaran: ");
        String addTanggal = br.readLine();
        Kredit pengeluaran = new Kredit(addNama, addJumlah, addTanggal, addCatat, addjenis,null);
        kredit.add(pengeluaran);
    }

    public static void lihat() throws Exception{
         Integer jumlahDebit = 0;
         Integer  jumlahKredit =0;
        if (debit.size()==0 && kredit.size()==0){
            System.out.println("Pemasukkan dan Pengeluaran tidak ada");
        }
        else{
            for (int i=0; i <  debit.size(); i++){
                System.out.println("Kategori           : " + debit.get(i).getKategori());
                System.out.println("Nama Pemasukkan    : " + debit.get(i).getNama());
                System.out.println("Jumlah Pemasukkan  : " + debit.get(i).getJumlah());
                System.out.println("Catatan            : " + debit.get(i).getCatatan());
                System.out.println("Tanggal            : " + debit.get(i).getTanggal());
                System.out.println("\n");
                jumlahDebit += debit.get(i).getJumlah();
            }
            for (int i=0; i <  kredit.size(); i++){
                System.out.println("Kategori           : " + kredit.get(i).getKategori());
                System.out.println("Nama Pengeluaran    : " + kredit.get(i).getNama());
                System.out.println("Jumlah Pengeluaran  : " + kredit.get(i).getJumlah());
                System.out.println("Catatan            : " + kredit.get(i).getCatatan());
                System.out.println("Tanggal            : " + kredit.get(i).getTanggal());
                System.out.println("\n");
                jumlahKredit += kredit.get(i).getJumlah();
            }
            totalDebit = jumlahDebit;
            totalKredit = jumlahKredit;
            System.out.println("TOTAL PEMASUKKAN: "+ totalDebit);
            System.out.println("TOTAL PENGELUARAN: "+ totalKredit);
            Total = totalDebit-totalKredit;
            System.out.println("TOTAL KESELURUHAN: "+ Total);


        }
    }

    public static void lihat(Kredit kreditt) throws Exception{
        int total =0;
        if (kredit.size()==0){
            System.out.println("Pengeluaran tidak ada");
        }
        else{
            for (int i=0; i <  kredit.size(); i++){
                System.out.println("Kategori           : " + kredit.get(i).getKategori());
                System.out.println("Nama Pengeluaran    : " + kredit.get(i).getNama());
                System.out.println("Jumlah Pengeluaran  : " + kredit.get(i).getJumlah());
                System.out.println("Catatan            : " + kredit.get(i).getCatatan());
                System.out.println("Tanggal            : " + kredit.get(i).getTanggal());
                System.out.println("\n");
                total += kredit.get(i).getJumlah();

            }
            totalKredit = total;
            System.out.println("TOTAL PENGELUARAN: "+ totalKredit);
        }
    }

    public static void lihat(Debit debitt) throws Exception{
        int total = 0;
        if (debit.size()==0){
            System.out.println("Pemasukkan tidak ada");
        }
        else{
            for (int i=0; i <  debit.size(); i++){
                System.out.println("Kategori           : " + debit.get(i).getKategori());
                System.out.println("Nama Pemasukkan    : " + debit.get(i).getNama());
                System.out.println("Jumlah Pemasukkan  : " + debit.get(i).getJumlah());
                System.out.println("Catatan            : " + debit.get(i).getCatatan());
                System.out.println("Tanggal            : " + debit.get(i).getTanggal());
                System.out.println("\n");
                total += debit.get(i).getJumlah();
            }
            totalDebit = total;
            System.out.println("TOTAL PEMASUKKAN: "+ totalDebit);
        }
    }

    public static void update(Debit debitt) throws Exception{

    }

    public static void update(Kredit kreditt) throws Exception{
        
    }

    public static void hapus(Debit debitt) throws Exception{

    }

    public static void hapus(Kredit kreditt) throws Exception{
        
    }


}
