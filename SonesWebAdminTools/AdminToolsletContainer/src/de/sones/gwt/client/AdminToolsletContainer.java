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

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripMenuButton;

import de.sones.gwt.client.toolslets.ConfigurationToolslet;
import de.sones.gwt.client.toolslets.PerformanceMonitoringToolslet;
import de.sones.gwt.client.toolslets.UserManagementToolslet;
import de.sones.gwt.client.toolslets.VertexTypesToolslet;

/**
 * @author david.maier@sones.de
 */
public class AdminToolsletContainer implements EntryPoint {
			
	public static final String IMGDIR = "[APP]/de.sones.gwt.AdminToolsletContainer/images/";
	public static final String BACKGRND = "back_1600x1200.png";
	
	public static final int MAINWIN_SIZE_PERC = 80;
	public static final String MAINWIN_TITLE = "sones WebAdminTools";
	public static final String MAINWIN_BACKGND = "SonesBack.png";
	
	public static final String FOOTER_MSG = "Welcome! Please click on one of the shortcuts or menu entries to start an application. | (c)2010, sones GmbH, solutions@sones.de";
	
	
	protected ArrayList<Toolslet> toolslets;
	
	
	public void onModuleLoad() {
		
		//The Toolslets those should live in this container
		addToolslets();
		
		//The absolute root panel
		RootPanel rootPanel = RootPanel.get();
		
		//SmartGWT specific syntax
		Page.setAppImgDir(IMGDIR);
		
		//The root Canvas
		Canvas rootCanvas = new Canvas();
		rootCanvas.setWidth100();
		rootCanvas.setHeight100();
		rootCanvas.setBackgroundImage(BACKGRND);
		
		//The Main Window
		Window mainWindow = new Window();
		mainWindow.setTitle(MAINWIN_TITLE);
		mainWindow.setWidth(MAINWIN_SIZE_PERC + "%");
		mainWindow.setHeight(MAINWIN_SIZE_PERC + "%");

		//The main Window position
		mainWindow.centerInPage();
		
		//The Toolstrip
		ToolStrip toolStrip = new ToolStrip();
		toolStrip.setWidth100();
		toolStrip.addMenuButton(createMenu());
		
		//The shortcut Canvas
		Canvas canvas = new Canvas();
		canvas.setHeight100();
		canvas.setWidth100();
		canvas.setBackgroundImage(MAINWIN_BACKGND);
		
		
		final int START = 50;
		final int OFFSET = 150;
		final int X_MAX = 6;
		
		
		 int count_x = 0;
		 int count_y = 0;
		 
		 for (Toolslet toolslet : toolslets)
		 {
			 Shortcut currShortcut = toolslet.getShortcut();

			 currShortcut.setLeft(START + (count_x * OFFSET));
			 currShortcut.setTop(START + (count_y * OFFSET));
			 
			 if (count_x == X_MAX) count_y++;
			 
			 canvas.addChild(currShortcut);
			 
			 count_x++;
		 }
		 
		//The footer
		ToolStrip footer = new ToolStrip();
		footer.setWidth100();
		Label footerLabel = new Label(FOOTER_MSG);
		footerLabel.setWidth100();
		footer.addMember(footerLabel);
		
		//Layouting
		HLayout mainLayout = new HLayout();
		mainLayout.setTop(20);
		mainLayout.setHeight("97%");
		mainLayout.setWidth100();
		
		VLayout vLayout = new VLayout();
		vLayout.setWidth100();
		
		vLayout.addMember(toolStrip);
		vLayout.addMember(canvas);
		vLayout.addMember(footer);
		
		mainLayout.addMember(vLayout);
		mainWindow.addChild(mainLayout);
		rootCanvas.addChild(mainWindow);
		rootPanel.add(rootCanvas);
		
	}
	
	
	private void addToolslets()
	{
		this.toolslets = new ArrayList<Toolslet>();
		
		this.toolslets.add(new VertexTypesToolslet());
		this.toolslets.add(new UserManagementToolslet());
		this.toolslets.add(new ConfigurationToolslet());
		this.toolslets.add(new PerformanceMonitoringToolslet());
	}
	
	private ToolStripMenuButton createMenu()
	{
		 Menu menu = new Menu();  
		 
		 menu.setShowShadow(true);  
		 menu.setShadowDepth(3);  
 
		 
		 for (Toolslet toolslet : toolslets)
		 {
			 menu.addItem(toolslet.getMenuItem());
		 }
		  
		 
		 ToolStripMenuButton button = new ToolStripMenuButton("sones", menu);
		 
		 return button;
	}	
}
