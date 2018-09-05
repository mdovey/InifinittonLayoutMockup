/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceridwen.infinittonlayoutmockup.datamodel;

/**
 *
 * @author Matthew.Dovey
 */
public class LaunchButton extends AbstractButton {
  String executable;

  public String getExecutable() {
    return executable;
  }

  public void setExecutable(String executable) {
    this.executable = executable;
  }
  
  public LaunchButton() {
    super();
    executable = "";
  }
  
  public LaunchButton(String name, String executable)
  {
    this.name = name;
    this.executable = executable;
  }
  
  public LaunchButton(AbstractButton button)
  {
    name = button.getName();
    icon = button.getIcon();
  }
}
