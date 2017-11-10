package org.pspf.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.pspf.model.dto.Message;
import org.pspf.services.PspfService;

import io.swagger.annotations.Api;

/**
 * @author Shalitha Mihirnga
 *
 */
@Api(tags = { "pspf" }, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PspfResources {
	
	/**
	 * get pspf pensioner list
	 * 
	 * @return
	 */
	@GET
	public Response getList() {
		
		PspfService service = new PspfService();
		
		return Response.ok(service.getAllList()).build();
	}
	
	/**
	 * get pending cheque list
	 * @return
	 */
	@GET
	@Path("/pending")
	public Response getPendingList() {
		
		PspfService service = new PspfService();
		
		return Response.ok(service.getAllListByState("pending")).build();
	}
	
	/**
	 * get received cheque list
	 * @return
	 */
	@GET
	@Path("/received")
	public Response getReceivedList() {
		
		PspfService service = new PspfService();
		
		return Response.ok(service.getAllListByState("received")).build();
	}
	
	/**
	 * get toBank cheque list
	 * @return
	 */
	@GET
	@Path("/toBank")
	public Response getToBankList() {
		
		PspfService service = new PspfService();
		
		return Response.ok(service.getAllListByState("toBank")).build();
	}
	
	/**
	 * get realized cheque list
	 * @return
	 */
	@GET
	@Path("/realized")
	public Response getRealizedList() {
		
		PspfService service = new PspfService();
		
		return Response.ok(service.getAllListByState("realized")).build();
	}
	
	/**
	 * get complete cheque list
	 * @return
	 */
	@GET
	@Path("/complete")
	public Response getCompleteList() {
		
		PspfService service = new PspfService();
		
		return Response.ok(service.getAllListByState("complete")).build();
	}
	
	/**
	 * get verified cheque list
	 * @return
	 */
	@GET
	@Path("/verified")
	public Response getVerifiedList() {
		
		PspfService service = new PspfService();
		
		return Response.ok(service.getAllListByState("verified")).build();
	}
	
	/**
	 * get reject cheque list
	 * @return
	 */
	@GET
	@Path("/reject")
	public Response getRejectList() {
		
		PspfService service = new PspfService();
		
		return Response.ok(service.getAllListByState("reject")).build();
	}
	
	/**
	 * update state
	 * @return
	 */
	@PUT
	@Path("/{state}/{cheque_no}")
	public Response updateState(@PathParam("state") String state, @PathParam("cheque_no") String chequeNo) {
		
		PspfService service = new PspfService();
		boolean isUpdated = service.updateState(state, chequeNo);
		
		if(isUpdated){
			return Response.ok(new Message(Status.OK.getStatusCode(),"update success")).build();
		}else{
			return Response.status(Status.BAD_REQUEST).entity(new Message(Status.BAD_REQUEST.getStatusCode(), "update failed")).build();
		}

	}

}
