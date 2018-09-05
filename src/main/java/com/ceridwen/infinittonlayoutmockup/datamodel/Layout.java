/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceridwen.infinittonlayoutmockup.datamodel;

import java.util.UUID;

/**
 *
 * @author Matthew.Dovey
 */
public class Layout {
  String name;
  UUID uuid;

  public Layout(String name)
  {
    this.name = name;
    this.uuid = UUID.randomUUID();
    
    for (int a=1; a <= 5; a++) {
      for (int b = 1; b <= 3; b++) {
        setButton(a, b, new HotkeyButton());
      }
    }
  }
  
  public UUID getUuid() {
    return uuid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  AbstractButton[][] buttons = new AbstractButton[5][3];
  
  public void setButton(int a, int b, AbstractButton button)
  {
    /** TODO: check bounds
     * 
     */
    
    buttons[a-1][b-1] = button;    
  }
  
  public AbstractButton getButton(int a, int b)
  {
    /** TODO: check bounds
     * 
     */
    
    return buttons[a-1][b-1];
  }
  
}
