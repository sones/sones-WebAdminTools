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

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

/**
 * @author david.maier@sones.de
 */
public class Shortcut extends Label {

	protected Shortcut()
	{
		   setAlign(Alignment.CENTER);  
	       setPadding(4);  
	       setBackgroundColor("EEEEEE");  
	       setKeepInParentRect(true);   
	       setCanDragReposition(true);
	       setDragAppearance(DragAppearance.TARGET);
	       setDragOpacity(40);
	}
	
	public Shortcut(String icon, String label)
	{
		this();
		
		this.setIcon(icon);
		this.setIconHeight(48);
		this.setIconWidth(48);
		this.setContents(label);
		
	}
	
	
	public Shortcut(String icon, String label, int posX, int posY)
	{
		this(icon, label);
		
		this.setLeft(posX);
		this.setTop(posY);
		
		/*
		this.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				Window w = new Window();
				w.setWidth("60%");
				w.setHeight("80%");
				w.setTitle("Example Window");
				w.setShowModalMask(true);
				w.centerInPage();
				w.setShowMinimizeButton(false);
				w.setIsModal(true);
				w.show();				
			}
		});
		*/
	}
}
