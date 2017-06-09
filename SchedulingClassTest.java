package SchedulingTest;

import org.flowable.bpmn.model.Task;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.test.Deployment;
import java.util.*;
public class SchedulingClassTest {
	public static void main(String[] args) throws InterruptedException {
	    ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
	      .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
	      .setAsyncExecutorActivate(true)
	      .setJdbcUsername("sa")
	      .setJdbcPassword("")
	      .setJdbcDriver("org.h2.Driver")
	      .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
          ProcessEngine processEngine = cfg.buildProcessEngine();
          
          
          
	    RepositoryService repositoryService = processEngine.getRepositoryService();
	    org.flowable.engine.repository.Deployment deployment = repositoryService.createDeployment()
	      .addClasspathResource("request.bpmn20.xml")
	      .deploy();
	    ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
	    		  .deploymentId(deployment.getId())
	    		  .singleResult();
	    		System.out.println("Found process definition : " + processDefinition.getName());
	    		RuntimeService runtimeService = processEngine.getRuntimeService();
	    		
	    	
		

	  }

}
