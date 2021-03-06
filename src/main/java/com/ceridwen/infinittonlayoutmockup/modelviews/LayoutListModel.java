/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceridwen.infinittonlayoutmockup.modelviews;

import com.ceridwen.infinittonlayoutmockup.datamodel.LayoutManager;
import javax.swing.AbstractListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Matthew
 */
public class LayoutListModel extends AbstractListModel{

    private final LayoutManager manager;

    public LayoutListModel(LayoutManager manager)
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
      return manager.getLayoutsCount();
    }

    @Override
    public String getElementAt(int index) {
      return manager.getLayoutAt(index).getName();
    }
    
}
