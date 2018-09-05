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
public class HotkeyButton extends AbstractButton{
  String hotkey;

  public String getHotkey() {
    return hotkey;
  }

  public void setHotkey(String hotkey) {
    this.hotkey = hotkey;
  }
  
  public HotkeyButton() {
    super();
    hotkey = "";
  }
  
  public HotkeyButton(String name, String hotkey)
  {
    this.name = name;
    this.hotkey = hotkey;
  }
  
  public HotkeyButton(AbstractButton button)
  {
    name = button.getName();
    icon = button.getIcon();
  }
    
}
