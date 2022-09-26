package com.atilsamancioglu.landmarkbook;

import android.graphics.Bitmap;

public class Singleton {
    //static değişkenleri kafaya göre kullanmak doğru değildir - herkes ulasabilr
    //singleton-statik olarak erişebileceğimiz fakat tek bir objeye sahip bir sınıftır
    //kontrol bende olur tek bır objesini oluşturuyor

    private Landmark selectedLandmark; // yollanan landmark
    private static Singleton singleton;//static obje oluşur-kendim oluşturdum

    private Singleton() {
        //constructorı private olmalıdır
        //private yaparsak bu methoda sadece bu sınıf içinden ulasılır
        //getter-setter lar oluştu
        //ne zaman cagırırsam cagırıyım hep aynı obje döner
    }

    public Landmark getSelectedLandmark() {
        return selectedLandmark;
    }

    public void setChosenLandmark(Landmark selectedLandmark) {
        this.selectedLandmark = selectedLandmark;
    }
//eğer önceden oluşmadıysa-ilk kez oluşuyosa
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
//değislse return daha onceden olusan obje
        return singleton;

    }

}
