package com.relyy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

/**
 * springMvc拦截器
 *
 * @author cairuirui
 * @date 2017-12-22
 */
public class InterceptorDemo implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request = new ModifyParametersWarpper(request);
        System.out.println("进入拦截器---------------");
        String url = request.getRequestURL().toString();
        System.out.println("请求的链接------"+url);
        String uuid = request.getParameter("uuid");
        System.out.println("参数：uuid="+uuid);

        //boolean flag = true;
        if ("6".equals(uuid)){
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private class ModifyParametersWarpper extends HttpServletRequestWrapper{

        private Map<String,String[]> parameterMap;

        /**
         * Constructs a request object wrapping the given request.
         *
         * @param request
         * @throws IllegalArgumentException if the request is null
         */
        public ModifyParametersWarpper(HttpServletRequest request) {
            super(request);
            parameterMap = request.getParameterMap();
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

        private String modifyParameter(String value){

            return "private-"+value;
        }

    }
}
