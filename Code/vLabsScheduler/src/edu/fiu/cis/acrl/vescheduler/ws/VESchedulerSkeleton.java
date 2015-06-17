package edu.fiu.cis.acrl.vescheduler.ws;

import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.engine.ServiceLifeCycle;

import edu.fiu.cis.acrl.vescheduler.server.VEScheduler;

public class VESchedulerSkeleton implements ServiceLifeCycle {

	private VEScheduler veScheduler = null;
	
	public VESchedulerSkeleton() {
	
		veScheduler = VEScheduler.instance();
		
	}
	    
	public DisableKaseyaAccountResponse disableKaseyaAccount(
			DisableKaseyaAccountRequest disableKaseyaAccountRequest) {
		
		return veScheduler.disableKaseyaAccount(disableKaseyaAccountRequest);
		
	}
	
	public DelKaseyaAccountResponse delKaseyaAccount(
			DelKaseyaAccountRequest delKaseyaAccountRequest) {
		
		return veScheduler.delKaseyaAccount(delKaseyaAccountRequest);
		
	}
	
	public DelKaseyaAccountsResponse delKaseyaAccounts(
			DelKaseyaAccountsRequest delKaseyaAccountsRequest) {
		
		return veScheduler.delKaseyaAccounts(delKaseyaAccountsRequest);
		
	}
	
	public RedistributeDevasEvenlyResponse redistributeDevasEvenly(
			RedistributeDevasEvenlyRequest redistributeDevasEvenlyRequest) {
		
		return veScheduler.redistributeDevasEvenly(redistributeDevasEvenlyRequest);
		
	}
	
	public RefreshVMResponse refreshVM(
			RefreshVMRequest refreshVMRequest) {
		
		return veScheduler.refreshVM(refreshVMRequest);
		
	}
	
	public RunVMCmdResponse runVMCmd(
			RunVMCmdRequest runVMCmdRequest) {
		
		return veScheduler.runVMCmd(runVMCmdRequest);
		
	}
	
	public DestroyDevaInsResponse destroyDevaIns(
			DestroyDevaInsRequest destroyDevaInsRequest) {
		
		return veScheduler.destroyDevaIns(destroyDevaInsRequest);
		
	}
	
	public GetDevaInsInfoResponse getDevaInsInfo(
			GetDevaInsInfoRequest getDevaInsInfoRequest) {
		
		return veScheduler.getDevaInsInfo(getDevaInsInfoRequest);
		
	}
	
	public GetEndDate4CurrentDevaInsResponse getEndDate4CurrentDevaIns(
			GetEndDate4CurrentDevaInsRequest getEndDate4CurrentDevaInsRequest) {
		
		return veScheduler.getEndDate4CurrentDevaIns(getEndDate4CurrentDevaInsRequest);
		
	}
	
	public GetVMInsInfoResponse getVMInsInfo(
			GetVMInsInfoRequest getVMInsInfoRequest) {
		
		return veScheduler.getVMInsInfo(getVMInsInfoRequest);
		
	}
	
	public ReserveResourceResponse reserveResource(
			ReserveResourceRequest reserveResourceRequest) {
		
		return veScheduler.reserveResource(reserveResourceRequest);
		
	}
	
	public CheckinResponse checkin(CheckinRequest request) {

		return veScheduler.checkin(request);

	}
        
	public GetVMMacResponse getVMMac(GetVMMacRequest request) {

		return veScheduler.getVMMac(request);

	}
        
	public GetVEMacsResponse getVEMacs(GetVEMacsRequest request) {

		return veScheduler.getVEMacs(request);

	}
        
	public GetVEInsIdUsingMacResponse getVEInsIdUsingMac(GetVEInsIdUsingMacRequest request) {

		return veScheduler.getVEInsIdUsingMac(request);

	}
        
	public ScheduleVEResponse scheduleVE(ScheduleVERequest request) {

		return veScheduler.scheduleVE(request);

	}
        
    public CancelScheduledVEResponse cancelScheduledVE(CancelScheduledVERequest request) {

		return veScheduler.cancelScheduledVE(request);

    }
         
    public DelVEInsResponse delVEIns(DelVEInsRequest request) {

		return veScheduler.delVEIns(request);

    }
         
    public ModifyScheduledVEResponse modifyScheduledVE(ModifyScheduledVERequest request) {

		return veScheduler.modifyScheduledVE(request);

    }

    public GetVEAvailabilityResponse getVEAvailability(GetVEAvailabilityRequest request) {

		return veScheduler.getVEAvailability(request);

    }
     
    public GetVEUnavailabilityResponse getVEUnavailability(GetVEUnavailabilityRequest request) {

		return veScheduler.getVEUnavailability(request);

    }
     
    public GetVEInsScheduleResponse getVEInsSchedule(GetVEInsScheduleRequest request) {

		return veScheduler.getVEInsSchedule(request);

    }
    
    public GetVEInsCurScheduleResponse getVEInsCurSchedule(GetVEInsCurScheduleRequest request) {

		return veScheduler.getVEInsCurSchedule(request);

    }
    
    public GetVEInsScheduleBySchIdResponse getVEInsScheduleBySchId(GetVEInsScheduleBySchIdRequest request) {

		return veScheduler.getVEInsScheduleBySchId(request);

    }
    
    public GetConfigurationResponse getConfiguration() {
    	
    	return veScheduler.getConfiguration();
    	
    }
    
    public SetConfigurationResponse setConfiguration(SetConfigurationRequest request) {
    	
    	return veScheduler.setConfiguration(request);
    
    }

    public GetHostResponse getHost(GetHostRequest request) {
    	
    	return veScheduler.getHost(request);
    	
    }
	
    public GetHostUsingNameResponse getHostUsingName(GetHostUsingNameRequest request) {
    	
    	return veScheduler.getHostUsingName(request);
    	
    }
	
    public GetHostListResponse getHostList(GetHostListRequest request) {
    	
    	return veScheduler.getHostList(request);
    	
    }
	
    public SetHostResponse setHost(SetHostRequest request) {
    	
    	return veScheduler.setHost(request);
    	
    }
	
    public DelHostResponse delHost(DelHostRequest request) {
    	
    	return veScheduler.delHost(request);
    	
    }
	
    public AddHostResponse addHost(AddHostRequest request) {
    	
    	return veScheduler.addHost(request);
    	
    }
	
    public GetStorageResponse getStorage(GetStorageRequest request) {
    	
    	return veScheduler.getStorage(request);
    	
    }
	
    public GetStorageListResponse getStorageList(GetStorageListRequest request) {
    	
    	return veScheduler.getStorageList(request);
    	
    }
	
    public SetStorageResponse setStorage(SetStorageRequest request) {
    	
    	return veScheduler.setStorage(request);
    	
    }
	
    public DelStorageResponse delStorage(DelStorageRequest request) {
    	
    	return veScheduler.delStorage(request);
    	
    }
	
    public AddStorageResponse addStorage(AddStorageRequest request) {
    	
    	return veScheduler.addStorage(request);
    	
    }
	
    public GetHostStorageResponse getHostStorage(GetHostStorageRequest request) {
    	
    	return veScheduler.getHostStorage(request);
    	
    }
	
    public GetHostStorageListResponse getHostStorageList(GetHostStorageListRequest request) {
    	
    	return veScheduler.getHostStorageList(request);
    	
    }
	
    public SetHostStorageResponse setHostStorage(SetHostStorageRequest request) {
    	
    	return veScheduler.setHostStorage(request);
    	
    }
	
    public DelHostStorageResponse delHostStorage(DelHostStorageRequest request) {
    	
    	return veScheduler.delHostStorage(request);
    	
    }
	
    public AddHostStorageResponse addHostStorage(AddHostStorageRequest request) {
    	
    	return veScheduler.addHostStorage(request);
    	
    }
	
	public ScheduleHostMaintenanceResponse scheduleHostMaintenance(
			ScheduleHostMaintenanceRequest request) {

		return veScheduler.scheduleHostMaintenance(request);

	}
        
    public CancelScheduledHostMaintenanceResponse cancelScheduledHostMaintenance(
    		CancelScheduledHostMaintenanceRequest request) {

		return veScheduler.cancelScheduledHostMaintenance(request);

    }
         
    public ModifyScheduledHostMaintenanceResponse modifyScheduledHostMaintenance(
    		ModifyScheduledHostMaintenanceRequest request) {

		return veScheduler.modifyScheduledHostMaintenance(request);

    }

    public GetHostMaintenanceAvailabilityResponse getHostMaintenanceAvailability(
    		GetHostMaintenanceAvailabilityRequest request) {

		return veScheduler.getHostMaintenanceAvailability(request);

    }
     
    public GetHostMaintenanceUnavailabilityResponse getHostMaintenanceUnavailability(
    		GetHostMaintenanceUnavailabilityRequest request) {

		return veScheduler.getHostMaintenanceUnavailability(request);

    }
     
    public GetHostMaintenanceScheduleResponse getHostMaintenanceSchedule(
    		GetHostMaintenanceScheduleRequest request) {

		return veScheduler.getHostMaintenanceSchedule(request);

    }
    
    @Override
	public void shutDown(ConfigurationContext arg0, AxisService arg1) {
		
		veScheduler.shutDown();
		
	}

	@Override
	public void startUp(ConfigurationContext arg0, AxisService arg1) {
		
		veScheduler.startUp();
		
	}
     
}
    