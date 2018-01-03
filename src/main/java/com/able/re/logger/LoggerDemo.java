package com.able.re.logger;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;

/**
 * 日志配置测试
 *
 * @author cairuirui
 * @date 2017-11-28
 */
public class LoggerDemo {

    public static void main(String[] args) {

        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }
}
