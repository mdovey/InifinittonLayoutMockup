/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceridwen.infinittonlayoutmockup.datamodel;

/**
 *
 * @author Matthew
 */
public class BackButton extends AbstractButton {
  public BackButton() {
    super();
  }
  
  public BackButton(String name)
  {
    this.name = name;
  }
  
  public BackButton(AbstractButton button)
  {
    name = button.getName();
    icon = button.getIcon();
  }
    
}
