/*
 * Copyright 2005-2008 Noelios Consulting.
 * 
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the "License"). You may not use this file except in
 * compliance with the License.
 * 
 * You can obtain a copy of the license at
 * http://www.opensource.org/licenses/cddl1.txt See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing Covered Code, include this CDDL HEADER in each file and
 * include the License file at http://www.opensource.org/licenses/cddl1.txt If
 * applicable, add the following below this CDDL HEADER, with the fields
 * enclosed by brackets "[]" replaced with your own identifying information:
 * Portions Copyright [yyyy] [name of copyright owner]
 */
package org.restlet.test.jaxrs.services.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.ProduceMime;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.MessageBodyWorkers;

import org.restlet.data.ClientInfo;
import org.restlet.data.Conditions;
import org.restlet.test.jaxrs.services.tests.RestletContextsTest;

/**
 * @author Stephan Koops
 * @see RestletContextsTest
 */
@Path("anchestorTest")
public class RestletContextsTestService {
    
    @Context MessageBodyWorkers messageBodyWorkers;
    
    @Context ContextResolver<Integer> contextResolver;
    
    @Context UriInfo uriInfo;

    @GET
    @ProduceMime("text/plain")
    @Path("fields")
    public String fieldsAvailable() {
        StringBuilder stb = new StringBuilder();
        if(messageBodyWorkers != null)
            stb.append("messageBodyWorkers\n");
        if(contextResolver != null)
            stb.append("contextResolver\n");
        if(uriInfo != null)
            stb.append("uriInfo\n");
        return stb.toString();
    }

    @GET
    @ProduceMime("text/plain")
    @Path("params")
    public String getResources(@Context UriInfo uriInfo,
            @Context ClientInfo clientInfo, @Context Conditions conditions) {
        StringBuilder stb = new StringBuilder();
        if(clientInfo != null)
            stb.append("messageBodyWorkers\n");
        if(conditions != null)
            stb.append("contextResolver\n");
        if(uriInfo != null)
            stb.append("uriInfo\n");
        return stb.toString();
    }
}