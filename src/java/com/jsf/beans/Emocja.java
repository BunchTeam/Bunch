/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.beans;

import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;
import com.vdurmont.emoji.EmojiParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ZimnY
 */

@ManagedBean
@SessionScoped
public class Emocja implements Serializable{
 
    public Collection<Emoji> emocja()
    {
        return EmojiManager.getAll();
    }
    public String getEmocja(String alias)
    {
        return EmojiManager.getForAlias(alias).getUnicode();
    }
}
