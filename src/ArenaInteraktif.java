/*
     Menjalankan pertarungan antar dua robot
 */

import java.util.Scanner;

public class ArenaInteraktif extends Arena {
    public void bertanding() {
        Scanner in = new Scanner(System.in);
        //UI sederhana untuk pertandingan

        //loop sampai salah satu robot habis skor kesehatannya
        boolean isSelesai = false;

        //LENGKAPI dengan NIM dan NAMA
        System.out.println("Saya berjanji tdk berbuat curang dan/atau membantu orang lain berbuat curang");
        System.out.println(" Quiz 1 27 Feb ");
        System.out.println(" 1607488 Akhmad Maulana Akbar ");

        System.out.print("Pertandingan dimulai =====\n");
        System.out.println("Selamat Datang di Arena Interaktif!");

        //player
        Robot robotAktif = robot1; // robot1 di set protected di class Arena parent
        Robot robotPasif = robot2; // robot2 di set protected di class Arena parent

        while (!isSelesai) {
            System.out.println("Pilih senjata untuk robot "+robotAktif.nama+" Menyerang!");
            System.out.println("[1] Senjata Pukulan (25)");
            System.out.println("[2] Senjata Kilat (40)");
            System.out.println("[3] Senjata Dagger (15)");
            senjata = in.nextInt(); // scan senjata apa
            senjata-=1; // untuk menyesuaikan dengan key array
            int perisai = (int) (Math.random() * robotPasif.oPerisai.length);
            System.out.println("");
            System.out.println("Giliran robot:"+robotAktif.nama);
            System.out.println("Robot menyerang dengan senjata "+robotAktif.oSenjata[senjata].namaSenjata+"("+robotAktif.oSenjata[senjata].kekuatan+")");
            // cek jika robot lawan menggunakan perisai, jika ada tampilkan nama
            if(robotPasif.oPerisai == null){
                System.out.println("Robot lawan tidak menggunakan perisai");
            }
            else{
                System.out.println("Robot lawan menggunakan perisai "+robotPasif.oPerisai[perisai].namaPerisai+"("+robotPasif.oPerisai[perisai].kekuatanPerisai+")");
            }

            robotAktif.serang(robotPasif, senjata, perisai); // tambah parameter baru untuk senjata dan perisai yang digunakan
            //print kesehatan
            robot1.printStatistik();
            robot2.printStatistik();
            //tukar peran
            Robot temp = robotAktif; //supaya tdk tertimpa
            robotAktif = robotPasif;
            robotPasif = temp;

            //stop jika salah satu robot skor kesehatanya nol
            isSelesai = (robotAktif.kesehatan<=0 || robotPasif.kesehatan<=0);
        }

        System.out.println("Pertandingan Selesai");

        //cek pemenang
        //lengkapi
        // check robot yang kesehatannya masih diatas 0
        if(robotAktif.kesehatan>0){
            System.out.println("Pemenangnya adalah "+robotAktif.nama); // print nama
        }
        else{
            System.out.println("Pemenangnya adalah "+robotPasif.nama); // print nama
        }
    }

    public static void main(String[] args){
        ArenaInteraktif oArena = new ArenaInteraktif(); // instansiasi arenainteraktif
        Scanner in = new Scanner(System.in); // scanner

        System.out.print("Nama Robot pertama: ");
        Robot robot1 = new Robot(in.nextLine()); // scan nama robot1
        System.out.print("Nama Robot kedua: ");
        Robot robot2 = new Robot(in.nextLine()); // scan nama robot2

        Senjata oSenjataPukulan = new SenjataPukulan();
        Senjata oSenjataKilat = new SenjataKilat(); // panggil SenjataKilat untuk digunakan
        Senjata oSenjataDagger = new SenjataDagger(); // panggil SenjataDagger untuk digunakan
        // robot 1
        robot1.tambahSenjata(oSenjataPukulan);
        robot1.tambahSenjata(oSenjataKilat);
        robot1.tambahSenjata(oSenjataDagger);
        // robot 2
        robot2.tambahSenjata(oSenjataPukulan);
        robot2.tambahSenjata(oSenjataKilat);
        robot2.tambahSenjata(oSenjataDagger);
//        robot2.tambahSenjata(oSenjataDagger);
//        robot2.tambahSenjata(oSenjataKilat);
//        robot2.tambahSenjata(oSenjataPukulan);

        // tambah perisai ke robot
        Perisai oPoormanShield = new PoormanShield();
        Perisai oStoutShield = new StoutShield();
        robot1.tambahPerisai(oPoormanShield);
        robot1.tambahPerisai(oStoutShield);
        robot2.tambahPerisai(oPoormanShield);
        robot2.tambahPerisai(oStoutShield);

        //tambahkan robot ke arena
        oArena.tambahRobot(robot1,robot2);

        //mainkan
        oArena.bertanding();
    }
}