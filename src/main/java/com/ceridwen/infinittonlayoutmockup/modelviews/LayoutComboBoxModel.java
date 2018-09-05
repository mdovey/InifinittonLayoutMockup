/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceridwen.infinittonlayoutmockup.modelviews;

import com.ceridwen.infinittonlayoutmockup.datamodel.LayoutManager;
import java.io.Serializable;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Matthew
 */
public class LayoutComboBoxModel extends AbstractListModel<String> implements ComboBoxModel<String>, Serializable {

    private final LayoutManager manager;

    public LayoutComboBoxModel(LayoutManager manager)
    {
        this.manager = manager;
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        super.addListDataListener(l); 
        this.manager.AddListener(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        super.removeListDataListener(l);
        this.manager.RemoveListener(l);
    }
    
    @Override
    public int getSize() {
        return manager.getLayoutsCount() + 1;
    }

    @Override
    public String getElementAt(int index) {
        if (index != manager.getLayoutsCount()) {
            return manager.getLayoutAt(index).getName();
        } else {
            return "<Back>";
        }
    }

  String selected = null;
  
  @Override
  public void setSelectedItem(Object anItem) {
    selected = (String)anItem;
  }

  @Override
  public Object getSelectedItem() {
    return selected;
  }
    
}
