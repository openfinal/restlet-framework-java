/*
 * Copyright 2005-2006 J�r�me LOUVEL
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 *
 * You can obtain a copy of the license at
 * http://www.opensource.org/licenses/cddl1.txt
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * http://www.opensource.org/licenses/cddl1.txt
 * If applicable, add the following below this CDDL
 * HEADER, with the fields enclosed by brackets "[]"
 * replaced with your own identifying information:
 * Portions Copyright [yyyy] [name of copyright owner]
 */

package org.restlet.component;

import java.io.IOException;

import org.restlet.UniformCall;
import org.restlet.connector.Client;
import org.restlet.connector.Server;

/**
 * Definitive source for representations of resources in a governed namespace.<br/><br/> "An origin server
 * uses a server connector to govern the namespace for a requested resource. It is the definitive source for
 * representations of its resources and must be the ultimate recipient of any request that intends to modify
 * the value of its resources. Each origin server provides a generic interface to its services as a resource
 * hierarchy. The resource implementation details are hidden behind the interface." Roy T. Fielding
 * @see <a href="http://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm#sec_5_2_3">Source
 * dissertation</a>
 */
public interface OriginServer extends Component
{
   /**
    * Adds a server connector to this component.
    * @param server The server connector to add.
    * @return The server connector added.
    */
   public Server addServer(Server server);

   /**
    * Removes a server connector from this component.
    * @param name The name of the server connector to remove.
    */
   public void removeServer(String name);

   /**
    * Adds a client connector to this component.
    * @param client The client connector to add.
    * @return The client connector added.
    */
   public Client addClient(Client client);

   /**
    * Removes a client connector from this component.
    * @param name The name of the client connector to remove.
    */
   public void removeClient(String name);

   /**
    * Calls a client connector.
    * @param name The name of the client connector.
    * @param call The call to handle.
    * @throws IOException
    */
   public void callClient(String name, UniformCall call) throws IOException;
}
