package com.example.paoim3;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.*;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class ClassEmployee implements Comparator<String>
{
    String nazwa_grupy;
    ObservableList<Employee>  lista_pracownikow;
    double max_p;
    String zapelnienie;



    ClassEmployee(String nazwa, double x )//Button button1
    {
        nazwa_grupy = nazwa;
        max_p = x;
        lista_pracownikow = FXCollections.observableArrayList();
        zapelnienie = "0 %";

    }
    public void addEmployee(Employee nowy_p)
    {
        if(lista_pracownikow.size() < max_p)
        {
            for (int i = 0; i < lista_pracownikow.size(); i++)
            {

             //   if(nowy_p.compareTo(lista_pracownikow.get(i)) == 0)
            //    {
            //        System.out.println(" Pracownik o takich danych już istnieje");
                //  }
            }

            lista_pracownikow.add(nowy_p);
            this.setZapelnienie();
        }
        else
        {
           // System.out.println(" Grupa pełna, nie mozna dodać nowego pracownika");
        }
    }
    public void addSalary(Employee prac, double wart)
    {
        System.out.println(" Wyplata przed podywzka " + prac.wynagrodzenie);
        prac.wynagrodzenie +=wart;
        System.out.println(" Wyplata po podywzce " + prac.wynagrodzenie);

    }
    public void removeEmployee(Employee prac)
    {
        this.lista_pracownikow.remove(prac);
        this.setZapelnienie();
    }
    public void changeCondition(Employee prac, EmployeeCondition con)
    {
        prac.stan_pracownika = con;
    }
    public void  search(String dane)
    {
        for (int i = 0; i < lista_pracownikow.size(); i++)
        {

            if( compare(dane, lista_pracownikow.get(i).nazwisko) == 0)
            {
                System.out.println(" znaleziono");
                lista_pracownikow.get(i).Print();
            }
            else
            {
                System.out.println(" nie znaleziono ");
            }
        }
    }
    public void   searchPartial(String dane)
    {
        for (int i = 0; i < lista_pracownikow.size(); i++)
        {
            if( lista_pracownikow.get(i).nazwisko.contains(dane))
            {
                lista_pracownikow.get(i).Print();
            }
            if( lista_pracownikow.get(i).imie.contains(dane))
            {
                lista_pracownikow.get(i).Print();
            }

        }
    }
    public void   countByCondition (EmployeeCondition x)
    {
        int wyn =0;
        for (int i = 0; i < lista_pracownikow.size(); i++)
        {

            if(x == lista_pracownikow.get(i).stan_pracownika)
            {

                wyn += 1;
            }
        }

        System.out.println(" Znaleziono " + wyn + " pracownikow w takim stanie");
    }
    public void  summary()
    {
        for (int i = 0; i < lista_pracownikow.size(); i++)
        {
            lista_pracownikow.get(i).Print();
        }
    }
  /*  public void  sortByName()
    {
        Collections.sort(lista_pracownikow);
        for(Employee prac : lista_pracownikow){prac.Print();}

    }
   */
    public void sortBySalary()
    {
        Collections.sort(lista_pracownikow, new Sort_salary());
        for(Employee prac : lista_pracownikow){prac.Print();}
    }
 /*   public void   max()
    {
        Employee temp = Collections.max(lista_pracownikow);
        System.out.println("Max value is:");
        temp.Print();

    }
  */

    public int compare(String a, String b)
    {
        if(a == b )
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    public String getNazwa_grupy() {
        return nazwa_grupy;
    }

    public List<Employee> getLista_pracownikow() {
        return lista_pracownikow;
    }

    public double getMax_p() {

        return max_p;
    }

    public String getZapelnienie() {
        return zapelnienie;
    }

    public void setZapelnienie() {
        this.zapelnienie =  ""+this.lista_pracownikow.size()/this.max_p *100 + "%";;
    }

    public void setNazwa_grupy(String nazwa_grupy) {
        this.nazwa_grupy = nazwa_grupy;
    }

    public void setLista_pracownikow(ObservableList<Employee> lista_pracownikow) {
        this.lista_pracownikow = lista_pracownikow;
    }

    public void setMax_p(double max_p) {
        this.max_p = max_p;
    }
}