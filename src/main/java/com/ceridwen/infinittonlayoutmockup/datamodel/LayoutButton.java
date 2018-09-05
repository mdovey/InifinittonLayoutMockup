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
public class LayoutButton extends EmptyButton {
  UUID layoutUid;

  public LayoutButton() {
    super();
  }

  public LayoutButton(EmptyButton button)
  {
    name = button.getName();
    icon = button.getIcon();
  }  
  
  public LayoutButton(String name, Layout layout)
  {
    this.name = name;
    this.layoutUid = layout.getUuid();
  }

  public UUID getLayoutUid() {
    return layoutUid;
  }

  public void setLayoutUid(UUID layoutUid) {
    this.layoutUid = layoutUid;
  }
}
