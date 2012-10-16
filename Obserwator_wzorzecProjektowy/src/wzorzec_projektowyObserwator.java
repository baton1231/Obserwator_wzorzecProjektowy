interface predkosc
{
    void predkoscZmieniona(int nowaPredkosc);
}



class samolot
{
    private int predkosc;
    private java.util.ArrayList listeners = new java.util.ArrayList();

    public int getSzybkosc()
    {
        return predkosc;
    }

    public void setSzybkosc(int predkosc)
    {
        System.out.println("wywołano setSzybkosc(" + predkosc + ")");
        //wykonana modyfikacja predkosci
        this.predkosc = predkosc;
        //zawiadamianie wrzystkich obserwujących
        for (int i = 0; i < listeners.size(); ++i) {
            predkosc l = (predkosc) listeners.get(i);
            l.predkoscZmieniona(predkosc);
        }
    }

    public void addListener(predkosc l)
    {
        listeners.add(l);
    }

    public void removeListener(predkosc l)
    {
        listeners.remove(l);
    }
}


class Obserwator implements predkosc
{
    public void predkoscZmieniona(int nowaPredkosc)
    {
        System.out.println("obserwowany samolot zmienił szybkość na "
                        + nowaPredkosc);
    }

}



class wzorzec_projektowyObserwator
{
    public static void main(String args[])
    {
        samolot p = new samolot();
        Obserwator o1 = new Obserwator();
        p.addListener(o1);
        p.setSzybkosc(30);
        p.setSzybkosc(60);
        p.setSzybkosc(90);
        p.removeListener(o1);
    }
}
