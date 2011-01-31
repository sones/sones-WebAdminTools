/*
 * sones GraphDB - OpenSource Graph Database - http://www.sones.com
 * Copyright (C) 2007-2011 sones GmbH
 *
 * This file is part of sones GraphDB OpenSource Edition.
 *
 * sones GraphDB OSE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * sones GraphDB OSE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with sones GraphDB OSE. If not, see <http://www.gnu.org/licenses/>.
 */

package de.sones.gwt.client;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

/**
 * @author david.maier@sones.de
 */
public abstract class Toolslet {

	public static final int MAINWIN_WIDTH_PERC = 60;
	public static final int MAINWIN_HEIGHT_PERC = 80;
	
	protected String name;
	protected String iconName;
	
	protected Shortcut shortcut;
	protected MenuItem menuItem;
	protected Window mainWindow;
	protected Canvas mainCanvas;

	
	public Toolslet(String name, String iconName) {
		
		this.name = name;
		this.iconName = iconName;
	
		mainWindow = new Window();
		mainWindow.setWidth(MAINWIN_WIDTH_PERC + "%");
		mainWindow.setHeight(MAINWIN_HEIGHT_PERC + "%");
		mainWindow.setTitle(name);
		mainWindow.setShowModalMask(true);
		mainWindow.centerInPage();
		mainWindow.setShowMinimizeButton(false);
		mainWindow.setIsModal(true);
		
		mainCanvas = new Canvas();
		mainCanvas.setTop(20);
		mainCanvas.setHeight("97%");
		mainCanvas.setWidth100();
		mainCanvas.setBackgroundColor("#e9efdd");
	
		mainWindow.addChild(mainCanvas);
		
		onLoad();
		
		shortcut = new Shortcut(iconName, name);
	
		shortcut.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				mainWindow.show();
			}
		});
		
		menuItem = new MenuItem(name);
		menuItem.setIcon(iconName);
		
		menuItem.addClickHandler(new com.smartgwt.client.widgets.menu.events.ClickHandler() {
			
			@Override
			public void onClick(MenuItemClickEvent event) {
				
				mainWindow.show();
			}
		});
	
	}

	public String getName() {
		return name;
	}

	public String getIconName() {
		return iconName;
	}
	
	public MenuItem getMenuItem() {
		return menuItem;
	}
	
	public Shortcut getShortcut() {
		return shortcut;
	}
	
	/**
	 * This method should be implemented to create the GUI of the Toolslet
	 */
	abstract protected void onLoad();
}
