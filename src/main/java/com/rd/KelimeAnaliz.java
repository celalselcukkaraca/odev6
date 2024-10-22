package com.rd;

import java.util.*;

public class KelimeAnaliz {

    // Kelimede tekrarlı harf olup olmadığını kontrol eden fonksiyon
    public static boolean tekrarliHarfVarMi(String kelime) {
        Set<Character> harfSeti = new HashSet<>();
        for (char harf : kelime.toCharArray()) {
            if (harfSeti.contains(harf)) {
                return true; // Eğer tekrarlı harf varsa true döndür.
            }
            harfSeti.add(harf);
        }
        return false;
    }

    // İki kelimenin harflerinden rastgele bir metin oluşturan fonksiyon
    public static String rastgeleMetinOlustur(String kelime1, String kelime2) {
        List<Character> harfListesi = new ArrayList<>();

        // İki kelimenin harflerini listeye ekle
        for (char harf : kelime1.toCharArray()) {
            harfListesi.add(harf);
        }
        for (char harf : kelime2.toCharArray()) {
            harfListesi.add(harf);
        }

        // Harfleri karıştır (shuffle)
        Collections.shuffle(harfListesi);

        // Harf listesinden rastgele metin oluştur
        StringBuilder rastgeleMetin = new StringBuilder();
        for (char harf : harfListesi) {
            rastgeleMetin.append(harf);
        }
        return rastgeleMetin.toString();
    }

    public static void main(String[] args) {
        // 1. Kelime dizisini oluştur
        String[] kelimeDizisi = {"kalem", "elalem", "kelam", "kelime"};

        // 2. Tekrarlı harf içeren kelimeleri bul ve 3. adımda iki kelime bulununca dur
        List<String> tekrarliKelimeler = new ArrayList<>();

        for (String kelime : kelimeDizisi) {
            if (tekrarliHarfVarMi(kelime)) {
                tekrarliKelimeler.add(kelime);
            }
            if (tekrarliKelimeler.size() == 2) {
                break; // İki kelime bulunduğunda aramayı kes
            }
        }

        // 4. Bulunan iki kelimenin harflerinden rastgele bir metin oluştur
        if (tekrarliKelimeler.size() == 2) {
            String kelime1 = tekrarliKelimeler.get(0);
            String kelime2 = tekrarliKelimeler.get(1);
            String rastgeleMetin = rastgeleMetinOlustur(kelime1, kelime2);
            System.out.println("Tekrarlı harf içeren kelimeler: " + kelime1 + ", " + kelime2);
            System.out.println("Oluşturulan metin: " + rastgeleMetin);
        } else {
            System.out.println("İki adet tekrarlı harf içeren kelime bulunamadı.");
        }
    }
}
