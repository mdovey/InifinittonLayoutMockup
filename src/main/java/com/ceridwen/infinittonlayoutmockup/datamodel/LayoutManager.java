/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceridwen.infinittonlayoutmockup.datamodel;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import org.apache.commons.collections4.map.LinkedMap;

/**
 *
 * @author Matthew.Dovey
 */
public class LayoutManager implements Serializable {
  static final LayoutManager manager = new LayoutManager();
  final List<ListDataListener> listeners = new ArrayList<>();
  
  LinkedMap<UUID, Layout> layouts = new LinkedMap<>();

  public void AddListener(ListDataListener listener)
  {
      listeners.add(listener);
  }
  
  public void RemoveListener(ListDataListener listener)
  {
      listeners.remove(listener);
  }
  
  private void fireListeners() {
      ListDataEvent e = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, layouts.size());
   
      for (ListDataListener listener: listeners) {
          listener.contentsChanged(e);
      }
  }
  
  public static LayoutManager getLayoutManager()
  {
    return manager;
  }

  public int getLayoutsCount()
  {
      return layouts.size();
  }
  
  public Layout getLayout(UUID uid)
  {
    return layouts.get(uid);
  }
  
  public Layout getLayoutAt(int index)
  {
    if (index < 0 || index >= layouts.size()) {
      return null;
    }
    return layouts.getValue(index);
  }
  
  public void addLayout(Layout layout)
  {
    layouts.put(layout.getUuid(), layout);
    fireListeners();
  }
  
  public int getLayoutIndex(Layout layout)
  {
    return layouts.indexOf(layout);
  }

  public int getLayoutIndex(UUID uid)
  {
    return layouts.indexOf(uid);
  }  
  
  public void deleteLayout(UUID uid)
  {
    if (layouts.size() < 2) {
      return;
    }
    layouts.remove(uid);
    fireListeners();
  }
  
  public void deleteLayoutAt(int index)
  {
    if (layouts.size() < 2) {
      return;
    }
    if (index < 0 || index >= layouts.size()) {
      return;
    }
    layouts.remove(index);
    fireListeners();
  }
  
  static {
    Layout root = new Layout("Root");
    Layout folder1 = new Layout("Folder 1");
    Layout folder2 = new Layout("Folder 2");
    
    root.setButton(1, 2, new LayoutButton("Folder 1", folder1));
    root.setButton(1, 3, new LayoutButton("Folder 2", folder2));
    root.setButton(2, 1, new ExecutableButton("App 1", "App 1"));
    root.setButton(2, 2, new ExecutableButton("App 2", "App 2"));
    root.setButton(2, 3, new ExecutableButton("App 3", "App 3"));

    folder1.setButton(1, 1, new LayoutButton("Back", root));
    folder1.setButton(1, 2, new LayoutButton("Folder 2", folder2));
    folder1.setButton(2, 1, new ExecutableButton("App 4", "App 4"));
    folder1.setButton(2, 2, new ExecutableButton("App 5", "App 5"));
    folder1.setButton(2, 3, new ExecutableButton("App 6", "App 6"));

    folder2.setButton(1, 1, new LayoutButton("Back", folder1));
    folder2.setButton(1, 3, new LayoutButton("Home", root));
    folder2.setButton(2, 1, new ExecutableButton("App 7", "App 7"));
    folder2.setButton(2, 2, new ExecutableButton("App 8", "App 8"));
    folder2.setButton(2, 3, new ExecutableButton("App 9", "App 9"));
    
    LayoutManager manager = getLayoutManager();
    manager.addLayout(root);
    manager.addLayout(folder1);
    manager.addLayout(folder2);
  }
}
