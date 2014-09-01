package org.kie.remote.services.rest;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.jbpm.kie.services.impl.KModuleDeploymentService;
import org.jbpm.services.cdi.Kjar;
import org.kie.remote.services.rest.api.DeploymentsResource;
import org.kie.services.client.serialization.jaxb.impl.deploy.JaxbDeploymentUnitList;
import org.kie.services.client.serialization.jaxb.impl.process.JaxbProcessDefinitionList;

@RequestScoped
@Path("/deployment")
public class DeploymentsResourceImpl extends ResourceBase implements DeploymentsResource {

    @Context
    private HttpHeaders headers;
   
    /* Deployment operations */
   
    @Inject
    private DeployResourceBase deployResourceBase;
  
    // REST operations -----------------------------------------------------------------------------------------------------------

    /* (non-Javadoc)
     * @see org.kie.remote.services.rest.DeploymentsResource#listDeployments()
     */
    @Override
    @GET
    // TODO: docs pagination
    public Response listDeployments() { 
        String oper = getRelativePath();
        Map<String, String[]> params = getRequestParams();
        int [] pageInfo = getPageNumAndPageSize(params, oper);
        int maxNumResults = getMaxNumResultsNeeded(pageInfo); 
        
       JaxbDeploymentUnitList resultList = deployResourceBase.getDeploymentList(pageInfo, maxNumResults);
       
        return createCorrectVariant(resultList, headers);
    }
   
    /* (non-Javadoc)
     * @see org.kie.remote.services.rest.DeploymentsResource#listProcessDefinitions()
     */
    @Override
    @GET
    @Path("/processes")
    // DOCS: (+ pagination)
    public Response listProcessDefinitions() { 
        String oper = getRelativePath();
        Map<String, String[]> params = getRequestParams();
        int [] pageInfo = getPageNumAndPageSize(params, oper);
        int maxNumResults = getMaxNumResultsNeeded(pageInfo); 
        
        JaxbProcessDefinitionList resultList = deployResourceBase.getProcessDefinitionList(pageInfo, maxNumResults);
        
        return createCorrectVariant(resultList, headers);
    }
}
