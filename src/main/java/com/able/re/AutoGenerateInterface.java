package com.able.re;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-01-19
 */
public class AutoGenerateInterface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入控制器的名称：");
        String controllerName = scanner.nextLine();
        System.out.println("请输入方法名：");
        String methodName = scanner.nextLine();
        System.out.println("方法名为："+methodName);

        System.out.println("请输入入参名称以及类型，如下格式：String uuid（多个参数请用逗号隔开）");
        String requestParamStr = scanner.nextLine();
        String[] requestParam = requestParamStr.split(",");

        System.out.println("请输入返回参数名称(多个参数请用逗号隔开)：");
        String responseParamStr = scanner.nextLine();
        String[] responseParam = responseParamStr.split(",");

        try{
            generatCodeInFile(controllerName,methodName,requestParam,responseParam);
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    private static void generatCode(String controllerName, String methodName, String[] requestParam, String[] responseParam) {

        System.out.println("@ResponseBody");
        System.out.println("@RequestMapping(\"/"+methodName+"\")");
        StringBuffer sb = new StringBuffer();
        sb.append("public Json ");
        sb.append(methodName).append("(");
        for (int i = 0,len = requestParam.length; i< len; i++) {
            sb.append(requestParam[i]);
            if (i != len-1) {
              sb.append(",");
            }
        }
        sb.append("){");
        System.out.println(sb.toString());
        System.out.println("    Json json = new Json();");
        System.out.println();
        System.out.println("    Map<String,Object> rt = new HashMap<String,Object>();");

        //sb.setLength(0);
        for (String s : responseParam) {
            System.out.println("    rt.put(\""+s+"\","+s+");");
        }

        System.out.println();
        System.out.println("    json.setSuccessValue(rt);");
        System.out.println("    return json;");
        System.out.println("}");
    }

    private static void generatCodeInFile(String controllerName, String methodName,
                                          String[] requestParam, String[] responseParam)
            throws Exception{

        //File file = new File("D:\\codefile\\"+controllerName+"Controller.java");

        FileWriter writer = new FileWriter("D:\\ideaworkspace\\webDemo\\src\\main\\java\\com\\relyy\\controller\\"+controllerName+"Controller.java");
        BufferedWriter bw = new BufferedWriter(writer);
        StringBuffer sb = new StringBuffer();

        sb.append("@Controller");
        sb.append("\n@RequestMapping(\"/"+controllerName+"\")");
        sb.append("\nclass "+controllerName+"Controller{");
        sb.append("\n\n\n@ResponseBody");
        sb.append("\n@RequestMapping(\"/"+methodName+"\")");
        sb.append("\npublic Json ");
        sb.append(methodName).append("(");
        for (int i = 0,len = requestParam.length; i< len; i++) {
            sb.append(requestParam[i]);
            if (i != len-1) {
                sb.append(",");
            }
        }
        sb.append("){");

        sb.append("\n    Json json = new Json();");
        sb.append("\n");
        sb.append("\n   Map<String,Object> rt = new HashMap<String,Object>();");
        for (String s : responseParam) {
            sb.append("\n    rt.put(\""+s+"\","+s+");");
        }
        sb.append("\n");
        sb.append("\n    json.setSuccessValue(rt);");
        sb.append("\n    return json;");

        sb.append("\n   }");
        sb.append("\n}");


        bw.write(sb.toString());
        bw.close();
        writer.close();
    }
}
