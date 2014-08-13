package org.kie.remote.client.jaxb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.kie.remote.jaxb.gen.AbortProcessInstanceCommand;
import org.kie.remote.jaxb.gen.AbortWorkItemCommand;
import org.kie.remote.jaxb.gen.ActivateTaskCommand;
import org.kie.remote.jaxb.gen.AddTaskCommand;
import org.kie.remote.jaxb.gen.AuditCommand;
import org.kie.remote.jaxb.gen.CancelDeadlineCommand;
import org.kie.remote.jaxb.gen.ClaimNextAvailableTaskCommand;
import org.kie.remote.jaxb.gen.ClaimTaskCommand;
import org.kie.remote.jaxb.gen.ClearHistoryLogsCommand;
import org.kie.remote.jaxb.gen.CompleteTaskCommand;
import org.kie.remote.jaxb.gen.CompleteWorkItemCommand;
import org.kie.remote.jaxb.gen.DelegateTaskCommand;
import org.kie.remote.jaxb.gen.DeleteCommand;
import org.kie.remote.jaxb.gen.ExecuteTaskRulesCommand;
import org.kie.remote.jaxb.gen.ExitTaskCommand;
import org.kie.remote.jaxb.gen.FailTaskCommand;
import org.kie.remote.jaxb.gen.FindActiveProcessInstancesCommand;
import org.kie.remote.jaxb.gen.FindNodeInstancesCommand;
import org.kie.remote.jaxb.gen.FindProcessInstanceCommand;
import org.kie.remote.jaxb.gen.FindProcessInstancesCommand;
import org.kie.remote.jaxb.gen.FindSubProcessInstancesCommand;
import org.kie.remote.jaxb.gen.FindVariableInstancesByNameCommand;
import org.kie.remote.jaxb.gen.FindVariableInstancesCommand;
import org.kie.remote.jaxb.gen.FireAllRulesCommand;
import org.kie.remote.jaxb.gen.ForwardTaskCommand;
import org.kie.remote.jaxb.gen.GetAttachmentCommand;
import org.kie.remote.jaxb.gen.GetContentCommand;
import org.kie.remote.jaxb.gen.GetFactCountCommand;
import org.kie.remote.jaxb.gen.GetGlobalCommand;
import org.kie.remote.jaxb.gen.GetIdCommand;
import org.kie.remote.jaxb.gen.GetProcessIdsCommand;
import org.kie.remote.jaxb.gen.GetProcessInstanceByCorrelationKeyCommand;
import org.kie.remote.jaxb.gen.GetProcessInstanceCommand;
import org.kie.remote.jaxb.gen.GetProcessInstancesCommand;
import org.kie.remote.jaxb.gen.GetTaskAssignedAsBusinessAdminCommand;
import org.kie.remote.jaxb.gen.GetTaskAssignedAsPotentialOwnerCommand;
import org.kie.remote.jaxb.gen.GetTaskByWorkItemIdCommand;
import org.kie.remote.jaxb.gen.GetTaskCommand;
import org.kie.remote.jaxb.gen.GetTaskContentCommand;
import org.kie.remote.jaxb.gen.GetTasksByProcessInstanceIdCommand;
import org.kie.remote.jaxb.gen.GetTasksByStatusByProcessInstanceIdCommand;
import org.kie.remote.jaxb.gen.GetTasksByVariousFieldsCommand;
import org.kie.remote.jaxb.gen.GetTasksOwnedCommand;
import org.kie.remote.jaxb.gen.GetVariableCommand;
import org.kie.remote.jaxb.gen.GetWorkItemCommand;
import org.kie.remote.jaxb.gen.InsertObjectCommand;
import org.kie.remote.jaxb.gen.NominateTaskCommand;
import org.kie.remote.jaxb.gen.ProcessSubTaskCommand;
import org.kie.remote.jaxb.gen.ReleaseTaskCommand;
import org.kie.remote.jaxb.gen.ResumeTaskCommand;
import org.kie.remote.jaxb.gen.SetGlobalCommand;
import org.kie.remote.jaxb.gen.SetProcessInstanceVariablesCommand;
import org.kie.remote.jaxb.gen.SignalEventCommand;
import org.kie.remote.jaxb.gen.SkipTaskCommand;
import org.kie.remote.jaxb.gen.StartCorrelatedProcessCommand;
import org.kie.remote.jaxb.gen.StartProcessCommand;
import org.kie.remote.jaxb.gen.StartTaskCommand;
import org.kie.remote.jaxb.gen.StopTaskCommand;
import org.kie.remote.jaxb.gen.SuspendTaskCommand;
import org.kie.remote.jaxb.gen.TaskCommand;
import org.kie.remote.jaxb.gen.UpdateCommand;

@XmlRootElement(name = "command-request")
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("rawtypes")
public class JaxbCommandsRequest {

    @XmlElement(name = "deployment-id")
    @XmlSchemaType(name = "string")
    private String deploymentId;

    @XmlElement(name = "process-instance-id")
    @XmlSchemaType(name = "long")
    private Long processInstanceId;

    @XmlElement(name = "ver")
    @XmlSchemaType(name = "string")
    private String version;

    @XmlElement
    @XmlSchemaType(name = "string")
    private String user;
   
    private transient String [] userPass;

    // This list should match the list in AcceptedCommands
    @XmlElements({
            @XmlElement(name = "complete-work-item", type = CompleteWorkItemCommand.class),
            @XmlElement(name = "abort-work-item", type = AbortWorkItemCommand.class),
            @XmlElement(name = "get-workitem", type = GetWorkItemCommand.class),
            
            @XmlElement(name = "abort-process-instance", type = AbortProcessInstanceCommand.class),
            @XmlElement(name = "get-process-ids", type = GetProcessIdsCommand.class),
            @XmlElement(name = "get-process-instance-by-correlation-key", type = GetProcessInstanceByCorrelationKeyCommand.class),
            @XmlElement(name = "get-process-instance", type = GetProcessInstanceCommand.class),
            @XmlElement(name = "get-process-instances", type = GetProcessInstancesCommand.class),
            @XmlElement(name = "set-process-instance-vars", type = SetProcessInstanceVariablesCommand.class),
            @XmlElement(name = "signal-event", type = SignalEventCommand.class),
            @XmlElement(name = "start-correlated-process", type = StartCorrelatedProcessCommand.class),
            @XmlElement(name = "start-process", type = StartProcessCommand.class),
            
            @XmlElement(name = "get-variable", type = GetVariableCommand.class),
            @XmlElement(name = "get-fact-count", type = GetFactCountCommand.class),
            @XmlElement(name = "get-global", type = GetGlobalCommand.class),
            @XmlElement(name = "get-id", type = GetIdCommand.class),
            @XmlElement(name = "set-global", type = SetGlobalCommand.class),
            
            @XmlElement(name = "delete", type = DeleteCommand.class),
            @XmlElement(name = "fire-all-rules", type = FireAllRulesCommand.class),
            @XmlElement(name = "insert-object", type = InsertObjectCommand.class),
            @XmlElement(name = "update", type = UpdateCommand.class),
           
            // task
            @XmlElement(name = "activate-task", type = ActivateTaskCommand.class),
            @XmlElement(name = "add-task", type = AddTaskCommand.class),
            @XmlElement(name = "claim-next-available-task", type = ClaimNextAvailableTaskCommand.class),
            @XmlElement(name = "claim-task", type = ClaimTaskCommand.class),
            @XmlElement(name = "complete-task", type = CompleteTaskCommand.class),
            @XmlElement(name = "delegate-task", type = DelegateTaskCommand.class),
            @XmlElement(name = "exit-task", type = ExitTaskCommand.class),
            @XmlElement(name = "fail-task", type = FailTaskCommand.class),
            @XmlElement(name = "forward-task", type = ForwardTaskCommand.class),
            @XmlElement(name = "get-attachment", type = GetAttachmentCommand.class),

            @XmlElement(name = "get-content", type = GetContentCommand.class),
            @XmlElement(name = "get-task-content-command", type = GetTaskContentCommand.class),

            @XmlElement(name = "get-task-as-business-admin", type = GetTaskAssignedAsBusinessAdminCommand.class),
            @XmlElement(name = "get-task-as-potential-owner", type = GetTaskAssignedAsPotentialOwnerCommand.class),
            @XmlElement(name = "get-task-by-workitemid", type = GetTaskByWorkItemIdCommand.class),
            @XmlElement(name = "get-task", type = GetTaskCommand.class),
            @XmlElement(name = "get-tasks-by-processinstanceid", type = GetTasksByProcessInstanceIdCommand.class),
            @XmlElement(name = "get-tasks-by-status-by-processinstanceid", type = GetTasksByStatusByProcessInstanceIdCommand.class),
            @XmlElement(name = "get-tasks-by-various-command", type = GetTasksByVariousFieldsCommand.class),
            @XmlElement(name = "get-tasks-owned", type = GetTasksOwnedCommand.class),
            @XmlElement(name = "nominate-task", type = NominateTaskCommand.class),
            @XmlElement(name = "release-task", type = ReleaseTaskCommand.class),
            @XmlElement(name = "resume-task", type = ResumeTaskCommand.class),
            @XmlElement(name = "skip-task", type = SkipTaskCommand.class),
            @XmlElement(name = "start-task", type = StartTaskCommand.class),
            @XmlElement(name = "stop-task", type = StopTaskCommand.class),
            @XmlElement(name = "suspend-task", type = SuspendTaskCommand.class),
            @XmlElement(name = "process-sub-tasks-command", type = ProcessSubTaskCommand.class),
            @XmlElement(name = "execute-task-rules-command", type = ExecuteTaskRulesCommand.class),
            @XmlElement(name = "cancel-deadline-command", type = CancelDeadlineCommand.class),
            
            // audit
            @XmlElement(name = "clear-history-logs", type = ClearHistoryLogsCommand.class),
            @XmlElement(name = "find-active-process-instances", type = FindActiveProcessInstancesCommand.class),
            @XmlElement(name = "find-node-instances", type = FindNodeInstancesCommand.class),
            @XmlElement(name = "find-process-instance", type = FindProcessInstanceCommand.class),
            @XmlElement(name = "find-process-instances", type = FindProcessInstancesCommand.class),
            @XmlElement(name = "find-subprocess-instances", type = FindSubProcessInstancesCommand.class),
            @XmlElement(name = "find-variable-instances", type = FindVariableInstancesCommand.class),
            @XmlElement(name = "find-variable-instances-by-name", type = FindVariableInstancesByNameCommand.class)
    })
    protected List<Object> commands;

    public JaxbCommandsRequest() {
        // Default constructor
    }

    public JaxbCommandsRequest(Object command) {
        checkThatCommandIsAccepted(command);
        this.commands = new ArrayList<Object>();
        this.commands.add(command);
        checkThatCommandsContainDeploymentIdIfNeeded(this.commands);
    }
    
    public JaxbCommandsRequest(List<Object> commands) {
        checkThatCommandsAreAccepted(commands);
        this.commands = new ArrayList<Object>();
        this.commands.addAll(commands);
        checkThatCommandsContainDeploymentIdIfNeeded(this.commands);
    }

    private void checkThatCommandsContainDeploymentIdIfNeeded(List<Object> checkCommands) {
        for( Object command : checkCommands ) { 
            if( ! (command instanceof TaskCommand) && ! (command instanceof AuditCommand) ) { 
                throw new UnsupportedOperationException( "A " + command.getClass().getSimpleName() + " requires that the deployment id has been set!" );
            }
        }
    }

    public JaxbCommandsRequest(String deploymentId, Object command) {
        checkThatCommandIsAccepted(command);
        this.deploymentId = deploymentId;
        this.commands = new ArrayList<Object>();
        this.commands.add(command);
    }

    public JaxbCommandsRequest(String deploymentId, List<Object> commands) {
        checkThatCommandsAreAccepted(commands);
        this.deploymentId = deploymentId;
        this.commands = new ArrayList<Object>();
        this.commands.addAll(commands);
    }

    private void checkThatCommandsAreAccepted(Collection<Object> cmds) { 
       for( Object cmd : cmds ) { 
          checkThatCommandIsAccepted(cmd); 
       }
    }
    
    private void checkThatCommandIsAccepted(Object cmd) { 
        if( ! AcceptedClientCommands.isAcceptedCommandClass(cmd.getClass()) ) {
           throw new UnsupportedOperationException(cmd.getClass().getName() + " is not an accepted command." ); 
        }
    }
    
    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public Long getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(Long processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setCommands(List<Object> commands) {
        checkThatCommandsAreAccepted(commands);
        this.commands = commands;
    }

    public List<Object> getCommands() {
        if( this.commands == null ) { 
            this.commands = new ArrayList<Object>();
        }
        return this.commands;
    }
   
    @JsonIgnore
    public String [] getUserPass() {
        return userPass;
    }

    @JsonIgnore
    public void setUserPass(String [] userPass) {
        this.userPass = userPass;
    }

    public String toString() {
    	StringBuffer result = new StringBuffer("JaxbCommandsRequest " + deploymentId + "\n");
    	if (commands != null) {
	    	for (Object command: commands) {
	    		result.append(command.getClass().getSimpleName() + "\n");
	    	}
    	}
    	return result.toString();
    }

}
