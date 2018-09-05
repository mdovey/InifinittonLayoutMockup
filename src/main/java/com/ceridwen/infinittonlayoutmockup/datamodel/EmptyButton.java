/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceridwen.infinittonlayoutmockup.datamodel;

import javax.swing.Icon;

/**
 *
 * @author Matthew.Dovey
 */
public class EmptyButton {
  String name;

  public EmptyButton()
  {
    name = "";
    icon = "";
  }
  
  public EmptyButton(EmptyButton button)
  {
    name = button.getName();
    icon = button.getIcon();
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }
  String icon;
}
