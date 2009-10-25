/*******************************************************************************
 * Copyright (c) 2009 Thales Corporate Services SAS                             *
 * Author : Gregory Boissinot                                                   *
 *                                                                              *
 * Permission is hereby granted, free of charge, to any person obtaining a copy *
 * of this software and associated documentation files (the "Software"), to deal*
 * in the Software without restriction, including without limitation the rights *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell    *
 * copies of the Software, and to permit persons to whom the Software is        *
 * furnished to do so, subject to the following conditions:                     *
 *                                                                              *
 * The above copyright notice and this permission notice shall be included in   *
 * all copies or substantial portions of the Software.                          *
 *                                                                              *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR   *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,     *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE  *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER       *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,*
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN    *
 * THE SOFTWARE.                                                                *
 *******************************************************************************/

package com.thalesgroup.hudson.plugins.xunit.types;

import hudson.ExtensionPoint;
import hudson.ExtensionList;
import hudson.model.Hudson;
import hudson.model.Describable;
import hudson.model.Descriptor;

import java.io.Serializable;


public abstract class XUnitType implements ExtensionPoint, Describable<XUnitType>, Serializable {

    private final String pattern;

    protected XUnitType() {
        this.pattern = null;
    }

    protected XUnitType(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    /**
     * All regsitered instances.
     */
    public static ExtensionList<XUnitType> all() {
        return Hudson.getInstance().getExtensionList(XUnitType.class);
    }

    @SuppressWarnings("unchecked")
    public Descriptor<XUnitType> getDescriptor() {
        return Hudson.getInstance().getDescriptor(getClass());
    }


    /**
     * Gets the associated Xsl to the type
     *
     * @return
     */
    public abstract String getXsl();

}
