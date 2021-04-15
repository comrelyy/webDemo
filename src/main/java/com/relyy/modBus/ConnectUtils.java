package com.relyy.modBus;

import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterTCP;
import com.intelligt.modbus.jlibmodbus.msg.ModbusMessageFactory;
import com.intelligt.modbus.jlibmodbus.msg.ModbusRequestFactory;
import com.intelligt.modbus.jlibmodbus.msg.base.ModbusMessage;
import com.intelligt.modbus.jlibmodbus.msg.base.ModbusRequest;
import com.intelligt.modbus.jlibmodbus.net.ModbusConnection;
import com.intelligt.modbus.jlibmodbus.net.stream.base.ModbusInputStream;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;
import com.intelligt.modbus.jlibmodbus.utils.DataUtils;
import com.intelligt.modbus.jlibmodbus.utils.FrameEvent;
import com.intelligt.modbus.jlibmodbus.utils.FrameEventListener;
import com.intelligt.modbus.jlibmodbus.utils.ModbusFunctionCode;
import jdk.nashorn.internal.ir.CallNode;
import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.net.InetAddress;

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
