/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.beans;

import db.Powiadomieniaopostach;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ZimnY
 */
@ManagedBean
@SessionScoped
public class Powiadomienia {

    private String post = " dodał/a post.";
    private String komentarz = " dodał/a komentarz.";
    private String interakcji = " dodał/a interakcję.";

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getKomentarz() {
        return komentarz;
    }

    public void setKomentarz(String komentarz) {
        this.komentarz = komentarz;
    }

    public String getInterakcji() {
        return interakcji;
    }

    public void setInterakcji(String interakcji) {
        this.interakcji = interakcji;
    }

    public String getStrona(Powiadomieniaopostach powiadomienie) {
        String s = "";
        if (powiadomienie.getIdposta().toString().length() > 0) {
            s = getPost();
        }
        if (powiadomienie.getIdposta().getIdkommentarzposta() > 0) {
            s = getKomentarz();
        }
        if (powiadomienie.getIdinterakcji()!= null) {
           s = getInterakcji();
        }
        return s;
    }
}
