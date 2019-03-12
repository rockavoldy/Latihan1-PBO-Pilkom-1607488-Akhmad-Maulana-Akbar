/*
     Robot yang akan bertarung. Robot punya senjata, perisai dan skor kesehatan.
 */
public class Robot {
    Senjata[] oSenjata = new Senjata[3]; // array objek senjata untuk menampung banyak senjata
    Perisai[] oPerisai = new Perisai[2]; // tambah perisai
    int kesehatan;
    int i;
    String nama = "";

    //isi senjata milik robot
    public void tambahSenjata(Senjata s) {
        for(i=0;i<3;i++){
            if(oSenjata[i] == null){
                oSenjata[i] = s;
                break;
            }
        }
    }

    public void tambahPerisai(Perisai p){
        for(i=0;i<2;i++){
            if (oPerisai[i] == null) {
                oPerisai[i] = p;
                break;
            }
        }
    }

    //print kesehatan dsb
    public void printStatistik() {
        System.out.println("Nama Robot: "+nama);
        // print nama-nama senjata yang tersedia yang bisa dipakai
        for(int i=0;i<oSenjata.length;i++){
            System.out.println("Nama Senjata "+(i+1)+" : "+oSenjata[i].namaSenjata+"("+oSenjata[i].kekuatan+")");
        }
        // print nama-nama perisai yang tersedia yang bisa dipakai
        for(i=0;i<oPerisai.length;i++){
            System.out.println("Nama Perisai "+(i+1)+" : "+oPerisai[i].namaPerisai+"("+oPerisai[i].kekuatanPerisai+")");
        }
        System.out.println("Kesehatan:"+kesehatan);
        System.out.println();
    }

    //constructor
    public Robot(String vNama) {
        nama = vNama;
        kesehatan = 100; //default
    }

    /* menyerang robot lain, skor kesehatan robot lain akan berkurang
    */
    public void serang(Robot rLawan, int senjata, int perisai) {
        // tambah parameter senjata dan perisai untuk yang digunakan oleh robot, senjata oleh robotaktif dan perisai oleh robotpasif
        //skor kesehatan robot lawan akan dikurangi
        // skor kesehatan robot pasif akan dikurangi dengan random dari 0 sampai kekuatan perisai, sehingga kekuatan perisai tidak menjamin pertahanan penuh
        rLawan.kesehatan =  rLawan.kesehatan - (oSenjata[senjata].kekuatan - (int) (Math.random() * rLawan.oPerisai[perisai].kekuatanPerisai));
    }
}
