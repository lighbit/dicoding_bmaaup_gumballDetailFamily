package com.zulkarnaen.gumball.data;

import java.util.ArrayList;

public class GumballFamilyData {
    public static String[][] data = new String[][]{
            {
                    "Gumball Watterson",
                    "Karakter utama",
                    "https://vignette.wikia.nocookie.net/theamazingworldofgumball/images/c/c0/Season_3_Gumball.png/revision/latest/scale-to-width-down/2000?cb=20161202111548&path-prefix=id",
                    "Gumball dua belas tahun memiliki bakat epik untuk kecelakaan. Tapi tak peduli bagaimana skema bodoh nya berubah, Gumball sepertinya tidak pernah jera.",
                    "Oktober 573 Mekkah, Jazirah Arab",
                    "23 Agustus 634 Madinah"
            },
            {
                    "Darwin Watterson",
                    "Adik Angkat Laki-laki Gumball Watterson",
                    "https://vignette.wikia.nocookie.net/theamazingworldofgumball/images/a/ab/Darwinregplisss.png/revision/latest/scale-to-width-down/200?cb=20161112120531",
                    "Umar bin Khattab berasal dari Bani Adi, salah satu rumpun suku Quraisy, suku terbesar di kota Mekkah saat itu. Ayahnya bernama Khattab bin Nufail Al Shimh Al Quraisyi dan ibunya Hantamah binti Hasyim, dari Bani Makhzum",
                    "c.583 Mekkah, Jazirah Arab","3 November 644 Madinah, Jazirah Arab"
            },
            {       "Anais Watterson",
                    "Adik perempuan Gumball Watterson",
                    "https://vignette.wikia.nocookie.net/theamazingworldofgumball/images/8/8c/Anais-01.png/revision/latest?cb=20171004164716&path-prefix=id",
                    "Utsman bin Affan adalah sahabat nabi dan juga khalifah ketiga dalam Khulafaur Rasyidin. Beliau dikenal sebagai pedagang yang kaya raya dan handal dalam bidang ekonomi namun sangat dermawan",
                    "574 Ta'if, Jazirah Arab",
                    "17 Juli 656 Madinah, Jazirah Arab"
            },
            {       "Richard Watterson",
                    "Bapak Karakter Utama",
                    "https://vignette.wikia.nocookie.net/theamazingworldofgumball/images/5/5a/Season_3_Richard.png/revision/latest/scale-to-width-down/2000?cb=20161202111621&path-prefix=id",
                    "Ali bin Abi Thalib sepupu dan sekaligus mantu Nabi Muhammad, setelah menikah dengan Fatimah az-Zahra. Ia pernah menjabat sebagai salah seorang khalifah pada tahun 656 sampai 661.",
                    "599 Mekkah, Jazirah Arab","28 Januari 661 Najaf, Irak"
            },
            {
                    "Nicole Watterson",
                    "Ibu Karakter Utama",
                    "https://vignette.wikia.nocookie.net/theamazingworldofgumball/images/7/7b/Season_3_Nicole.png/revision/latest?cb=20161202111602&path-prefix=id",
                    "Ali bin Abi Thalib sepupu dan sekaligus mantu Nabi Muhammad, setelah menikah dengan Fatimah az-Zahra. Ia pernah menjabat sebagai salah seorang khalifah pada tahun 656 sampai 661.",
                    "599 Mekkah, Jazirah Arab","28 Januari 661 Najaf, Irak"
            }
    };
    public static ArrayList<GumballFamily> getListData(){
        GumballFamily gumballFamily = null;
        ArrayList<GumballFamily> list = new ArrayList<>();
        for (int i = 0; i<data.length; i++){
            gumballFamily = new GumballFamily();
            gumballFamily.setName(data[i][0]);
            gumballFamily.setRemarks(data[i][1]);
            gumballFamily.setPhoto(data[i][2]);
            gumballFamily.setDeskripsi(data[i][3]);
            gumballFamily.setLahir(data[i][4]);
            gumballFamily.setWafat(data[i][5]);

            list.add(gumballFamily);
        }

        return list;
    }
}
