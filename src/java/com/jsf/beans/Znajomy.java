/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.beans;

import java.util.List;
import java.util.stream.Stream;
import db.Znajomi;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ZimnY
 */
@ManagedBean
@SessionScoped
public class Znajomy {
    public Object[] listaznajomych(List<Znajomi> znajomi, Integer id)
    {
       return Stream.concat(znajomi.stream().filter(p->p.getIduzytkownika().getIduzytkownika()==id),znajomi.stream().filter(p->p.getIdznajomego().getIduzytkownika()==id)).toArray();
    }
    public long ilosc(List<Znajomi> znajomi, Integer id)
    {
       return Stream.concat(znajomi.stream().filter(p->p.getIduzytkownika().getIduzytkownika()==id),znajomi.stream().filter(p->p.getIdznajomego().getIduzytkownika()==id)).count();
    }
}
