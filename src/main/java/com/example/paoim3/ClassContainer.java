package com.example.paoim3;

import java.util.HashMap;
public class ClassContainer
{
    HashMap<String, ClassEmployee> Grupy;

    ClassContainer()
    {
        Grupy = new HashMap<String, ClassEmployee>();
    }
    public void addClass(String nazwa, double x)
    {
        Grupy.put(nazwa, new ClassEmployee(nazwa,x));
    }
    public void removeClass(String nazwa)
    {
        Grupy.remove(nazwa);
    }
    public void  findEmpty()
    {
        for (HashMap.Entry<String, ClassEmployee> set :Grupy.entrySet())
        {
            if(set.getValue().lista_pracownikow.size()== 0)
            {
                System.out.println(set.getKey());
            }
        }

    }
    public void summary()
    {
        for (HashMap.Entry<String, ClassEmployee> set :Grupy.entrySet())
        {
            System.out.println("Nazwa Grupy: " + set.getKey() );
            System.out.println("Zapełnienie grupy " + set.getValue().lista_pracownikow.size()/set.getValue().max_p*100 + "%");
        }

    }
}