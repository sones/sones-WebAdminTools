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

package de.sones.gwt.client.toolslets;

import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

import de.sones.gwt.client.Toolslet;

/**
 * @author david.maier@sones.de
 */
public class VertexTypesToolslet extends Toolslet {

	public VertexTypesToolslet() {
		super("Vertex types", "Vertex.png");
	}
	
	@Override
	protected void onLoad() {
		
		//Do nothing, so show a blank Window -- should be extended with this Toolslets code
		
		//Tabs for Structure, Data, Query, Search, Import/Export
		TabSet tabSet  = new TabSet();
		tabSet.setTabBarPosition(Side.TOP);
		tabSet.setWidth100();
		tabSet.setHeight100();
		
		Tab structureTab  = new Tab("Structure");
		structureTab.setPane(new Canvas());
		
		Tab dataTab = new Tab("Data");
		dataTab.setPane(new Canvas());
		
		Tab qryTab = new Tab("Query");
		qryTab.setPane(new Canvas());
		
		Tab searchTab = new Tab("Search");
		searchTab.setPane(new Canvas());
		
		Tab ioTab = new Tab("Import/Export");
		ioTab.setPane(new Canvas());
		
		tabSet.setTabs(structureTab,dataTab,qryTab,searchTab,ioTab);
		
		this.mainCanvas.addChild(tabSet);
	}

	
	
	
}
