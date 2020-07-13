package com.able.re.designMode.bridgepatten;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/6/22
 */
public class BridgePattenClient {

	public static void main(String[] args) {
		PickingJob pickingJob = new PickingJob();
		CarryAgvJobStateChange carryAgvJobStateChange = new CarryAgvJobStateChange(pickingJob);
		carryAgvJobStateChange.handle("job_complete");
	}
}
