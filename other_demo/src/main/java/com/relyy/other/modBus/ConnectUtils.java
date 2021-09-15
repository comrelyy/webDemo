package com.relyy.other.modBus;

import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/8/24
 */
@Slf4j
public class ConnectUtils {

	public static void main(String[] args) throws Exception{
//		TcpParameters tcpParameters = new TcpParameters();
//		tcpParameters.setHost(InetAddress.getByName("192.168.8.250"));
//		ModbusMaster master = ModbusMasterFactory.createModbusMasterTCP(tcpParameters);
		try{
//
//			Modbus.setAutoIncrementTransactionId(true);
//			Modbus.setLogLevel(Modbus.LogLevel.LEVEL_VERBOSE);
//			master.addListener(new FrameEventListener() {
//				@Override
//				public void frameSentEvent(FrameEvent event) {
//					log.info("frameSentEvent:{}",event);
//				}
//
//				@Override
//				public void frameReceivedEvent(FrameEvent event) {
//					log.info("frameReceivedEvent:{}",event);
//				}
//			});
//			int[] ints = master.readHoldingRegisters(1,0,16);
//			System.out.println(ints);
//			master.writeMultipleRegisters();
			int[] msg = {34048,0};
			//byte[] bytes = DataUtils.toByteArray(msg);
			System.out.println(Integer.toBinaryString(17664));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//master.disconnect();
		}


		//modbusMasterTCP.writeMultipleRegisters()
		//ModbusMessage message = ModbusRequestFactory.getInstance().createMessage(ModbusFunctionCode.READ_HOLDING_REGISTERS.toInt());
		//message

		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		//threadMXBean.findDeadlockedThreads()

	}
}
