/*
 * Copyright (c) 2011, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.glassfish.admingui.devtests;

import static org.junit.Assert.*;

import org.junit.Test;


public class LogViewerTest extends BaseSeleniumTestClass {
    private static final String TRIGGER_SERVER = "i18n.instance.GeneralTitle";
    private static final String TRIGGER_LV = "i18nc.logViewer.levelLabel";
    private static final String TRIGGER_IV = "i18nc.logViewer.instanceLabel";


    // basic sanity test for log viewer
    @Test
    public void testLogViewer() {
    	try {
	        clickAndWait("treeForm:tree:applicationServer:applicationServer_link", TRIGGER_SERVER);
	        pressButton("propertyForm:propertyContentPage:logViewer");
	        waitForPopUp("LogViewerWindow", "300000");
	        selectWindow("LogViewerWindow");
	        assertTrue(isTextPresent(TRIGGER_LV));
    	} finally {
    		selectWindow(null);
    	}
    }

    // basic sanity test for raw log viewer
    @Test
    public void testRawLogViewer() {
    	try {
		    clickAndWait("treeForm:tree:applicationServer:applicationServer_link", TRIGGER_SERVER);
		    pressButton("propertyForm:propertyContentPage:logViewerRaw");
		    waitForPopUp("LogViewerRawWindow", "300000");
		    selectWindow("LogViewerRawWindow");
		    assertTrue(isTextPresent(TRIGGER_IV));
    	} finally {
    		selectWindow(null);
    	}
    }
}

