package com.relyy.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * 测试过滤器
 *
 * @author cairuirui
 * @date 2017-12-20
 */
public class FilterDemo extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // 请求的uri
        String uri = request.getRequestURI();
        System.out.println(uri);
        System.out.println("原有参数"+request.getParameter("uuid"));
        ModifyParametersWarpper requestWarpper = new ModifyParametersWarpper(request);
        filterChain.doFilter(requestWarpper, response);


    }

    private class ModifyParametersWarpper extends HttpServletRequestWrapper {

       private Map<String , String[]> parameterMap = new HashMap<String, String[]>();;

        /**
         * Constructs a request object wrapping the given request.
         *
         * @param request
         * @throws IllegalArgumentException if the request is null
         */
        public ModifyParametersWarpper(HttpServletRequest request) {
            super(request);
            parameterMap.putAll(request.getParameterMap());
            parameterMap.put("flag",new String[]{"2"});
        }

        public ModifyParametersWarpper(HttpServletRequest request,Map<String , String[]> otherParameterMap){
            this(request);
            this.addAllParamater(otherParameterMap);
        }

        /**
         * @desc 获取所有参数名，返回所有参数名
         * @author: cairuirui
         * @date 2017-12-29
         * @return
         */
        @Override
        public Enumeration<String> getParameterNames(){
            Vector<String> vector = new Vector<String>(parameterMap.keySet());
            return vector.elements();
        }


        /**
         * @desc 获取指定参数的值 如果用重复的参数名，默认取第一个
         * @author: cairuirui
         * @create: 2017-12-29
         * @param name
         * @return
         */
        @Override
        public String getParameter(String name){
            String[] results = parameterMap.get(name);
            if (null == results || results.length <= 0) {
                return null;
            }else {
                System.out.println("参数"+name+"修改之前的值："+results[0]);
                return this.modifyParameter(results[0]);
            }
        }

        /**
         * @desc 获取所有指定参数名的所有值数组，如：checkBox的所有值
         * @author: cairuirui
         * @create: 2017-12-29
         * @param name
         * @return
         */
        @Override
        public String[] getParameterValues(String name){
            String[] results = parameterMap.get(name);
            if (null == results || results.length <= 0) {
                return null;
            }else {
                for (int i= 0, len = results.length; i<len;i++) {
                    System.out.println("参数" + name + "修改之前的值：" + results[0]);
                    results[i] = this.modifyParameter(results[i]);
                }
                return results;
            }
        }

        /**
         * 修改参数
         * @param value
         * @return
         */
        private String modifyParameter(String value){

            return 2+value;
        }

        /**
         * 添加多个参数
         * @param otherParameterMap
         */
        private void addAllParamater(Map<String , String[]> otherParameterMap){
            for (Map.Entry<String , String[]> entry : otherParameterMap.entrySet()){
                this.addParamater(entry.getKey(),entry.getValue());
            }
        }

        private void addParamater(String name, Object value){
            if(value != null) {
                if(value instanceof String[]) {
                    parameterMap.put(name , (String[])value);
                }else if(value instanceof String) {
                    parameterMap.put(name , new String[] {(String)value});
                }else {
                    parameterMap.put(name , new String[] {String.valueOf(value)});
                }
            }
        }

    }
}
