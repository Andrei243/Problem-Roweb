package main;

import java.util.*;

class Pair<T,U>{
    T first;
    U second;
    public Pair(T _first,U _second){
        first=_first;
        second=_second;
    }

}


public class Main {
    static ArrayList<Integer> numere=new ArrayList<>();
    static ArrayList<Integer> pozitii=new ArrayList<>();

    static Integer cautareBinara(Integer a,Integer b,Integer element)throws Exception {

        if(a.equals(b) && !numere.get(pozitii.get(a)).equals(element))throw new Exception("Nu are pereche");
        else if(a.equals(b-1)||b.equals(a-1)){
            if(numere.get(pozitii.get(a)).equals(element))return a;
            if(numere.get(pozitii.get(b)).equals(element))return b;
            else throw new Exception("Nu s-a gasit numarul");
        }
        int mid=(a+b)/2;
        if(numere.get(pozitii.get(mid)).equals(element))return mid;
        else if(numere.get(pozitii.get(mid))>element)return cautareBinara(a,mid-1,element);
        else return cautareBinara(mid+1,b,element);

    }

    public static void main(String[] args) {
        int nrNumere;
        Scanner scn=new Scanner(System.in);
        nrNumere=scn.nextInt();


        for(int i=0;i<nrNumere;i++){
            int aux=scn.nextInt();
            numere.add(aux);
            pozitii.add(i);
        }

        pozitii.sort(Comparator.comparing(numere::get));
        ArrayList<Pair<Integer,Integer>> perechi=new ArrayList<>();

        int nrCautat=scn.nextInt();
        for(int i=0;i<pozitii.size();i++){
            int aux=numere.get(pozitii.get(i));
            try {
                int pos = cautareBinara(0, pozitii.size() - 1, aux - nrCautat);
                while(pos<pozitii.size()-1&& numere.get(pozitii.get(pos)).equals(numere.get(pozitii.get(pos+1))))pos=pos+1;
                while(numere.get(pozitii.get(pos)).equals(aux-nrCautat)){
                    perechi.add(new Pair<>(pozitii.get(i),pozitii.get(pos)));
                    pos--;
                }

            }catch(Exception ex){
            }

        }

        for(Pair<Integer,Integer> pereche : perechi){
            System.out.println(pereche.first+" "+pereche.second);
        }


    }
}
