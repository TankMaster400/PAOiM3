package com.example.paoim3;

public class Employee implements Comparable<String>
{
    String imie;
    String nazwisko;
    EmployeeCondition stan_pracownika;
    int rok_urodzenia;
    double wynagrodzenie;

    Employee( String d1, String d2,EmployeeCondition d3, int d4, double d5)
    {imie =d1;nazwisko=d2;stan_pracownika=d3;rok_urodzenia=d4;wynagrodzenie=d5;}

    public void Print()
    {
        System.out.println(" imie oraz nazwisko: "+ imie + " " +  nazwisko);
        System.out.println(" stan_pracownika: " +stan_pracownika );
        System.out.println(" rok_urodzenia: "+ rok_urodzenia);
        System.out.println(" wynagrodzenie: " +wynagrodzenie );

    };
 /*   @Override
    public int compareTo(Employee pracownik1)
    {
        int results = this.nazwisko.compareTo(pracownik1.nazwisko);
        return results;
    }


  */
 @Override
 public int compareTo(String nazwisko)
 {
     int results = this.nazwisko.compareTo(nazwisko);
     return results;
 }
    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public EmployeeCondition getStan_pracownika() {
        return stan_pracownika;
    }

    public int getRok_urodzenia() {
        return rok_urodzenia;
    }

    public double getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setStan_pracownika(EmployeeCondition stan_pracownika) {
        this.stan_pracownika = stan_pracownika;
    }

    public void setRok_urodzenia(int rok_urodzenia) {
        this.rok_urodzenia = rok_urodzenia;
    }

    public void setWynagrodzenie(double wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }
}
