/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceridwen.infinittonlayoutmockup.datamodel;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
    Layout folder3 = new Layout("Folder 3");
    
    root.setButton(1, 2, new LayoutButton("Folder 1", folder1));
    root.setButton(1, 3, new LayoutButton("Folder 2", folder2));
    root.setButton(2, 1, new LaunchButton("App 1", "App 1"));
    root.setButton(2, 2, new LaunchButton("App 2", "App 2"));
    root.setButton(2, 3, new LaunchButton("App 3", "App 3"));
    root.setButton(3, 1, new HotkeyButton("A", "A"));
    root.setButton(3, 2, new HotkeyButton("B", "B"));
    root.setButton(3, 3, new HotkeyButton("C", "C"));

    folder1.setButton(1, 1, new BackButton("Back"));
    folder1.setButton(1, 2, new LayoutButton("Folder 2", folder2));
    folder1.setButton(1, 3, new LayoutButton("Folder 3", folder3));
    folder1.setButton(2, 1, new LaunchButton("App 4", "App 4"));
    folder1.setButton(2, 2, new LaunchButton("App 5", "App 5"));
    folder1.setButton(2, 3, new LaunchButton("App 6", "App 6"));
    folder1.setButton(3, 1, new HotkeyButton("D", "D"));
    folder1.setButton(3, 2, new HotkeyButton("E", "E"));
    folder1.setButton(3, 3, new HotkeyButton("F", "F"));

    folder2.setButton(1, 1, new BackButton("Back"));
    folder2.setButton(1, 3, new LayoutButton("Root", root));
    folder2.setButton(2, 1, new LaunchButton("App 7", "App 7"));
    folder2.setButton(2, 2, new LaunchButton("App 8", "App 8"));
    folder2.setButton(2, 3, new LaunchButton("App 9", "App 9"));
    folder2.setButton(3, 1, new HotkeyButton("G", "G"));
    folder2.setButton(3, 2, new HotkeyButton("H", "H"));
    folder2.setButton(3, 3, new HotkeyButton("I", "I"));

    folder3.setButton(1, 1, new BackButton("Back"));
    folder3.setButton(2, 1, new LaunchButton("App 10", "App 10"));
    folder3.setButton(2, 2, new LaunchButton("App 11", "App 11"));
    folder3.setButton(2, 3, new LaunchButton("App 12", "App 12"));
    folder3.setButton(3, 1, new HotkeyButton("J", "J"));
    folder3.setButton(3, 2, new HotkeyButton("K", "K"));
    folder3.setButton(3, 3, new HotkeyButton("L", "L"));

    
    LayoutManager manager = getLayoutManager();
    manager.addLayout(root);
    manager.addLayout(folder1);
    manager.addLayout(folder2);
    manager.addLayout(folder3);
  }

    public Collection<Layout> getLayouts() {
        return layouts.values();
    }
}
