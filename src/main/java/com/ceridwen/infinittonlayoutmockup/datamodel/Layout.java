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
        setButton(a, b, new EmptyButton());
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
  EmptyButton[][] buttons = new EmptyButton[5][3];
  
  public void setButton(int a, int b, EmptyButton button)
  {
    /** TODO: check bounds
     * 
     */
    
    buttons[a-1][b-1] = button;    
  }
  
  public EmptyButton getButton(int a, int b)
  {
    /** TODO: check bounds
     * 
     */
    
    return buttons[a-1][b-1];
  }
  
}
