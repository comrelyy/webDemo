package com.relyy.modBus;

import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterTCP;
import com.intelligt.modbus.jlibmodbus.msg.ModbusMessageFactory;
import com.intelligt.modbus.jlibmodbus.msg.ModbusRequestFactory;
import com.intelligt.modbus.jlibmodbus.msg.base.ModbusMessage;
import com.intelligt.modbus.jlibmodbus.msg.base.ModbusRequest;
import com.intelligt.modbus.jlibmodbus.net.ModbusConnection;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;
import com.intelligt.modbus.jlibmodbus.utils.ModbusFunctionCode;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/8/24
 */
public class ConnectUtils {

	public static void main(String[] args) throws Exception{
		TcpParameters tcpParameters = new TcpParameters("192.168.21.189", 30492, true);
		ModbusMaster modbusMasterTCP = ModbusMasterFactory.createModbusMasterTCP(tcpParameters);
		modbusMasterTCP.connect();
		ModbusMessage message = ModbusRequestFactory.getInstance().createMessage(ModbusFunctionCode.READ_HOLDING_REGISTERS.toInt());
	}
}
