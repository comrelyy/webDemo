package com.able.re.ThreadDemo.comsumerAndProducer;

import java.util.ArrayList;
import java.util.List;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-14
 */
public class Producer implements Runnable {
    private Storage storage;
    private static boolean flag = true;
    private static Integer page = 0;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try{
            List<UserVideoStatistics> list = null;
            while (page < 10){
                list = new ArrayList<>();
                for (int i = page*10000 ; i < (page+1)*10000; i++){
                    list.add(new UserVideoStatistics(1L+i,1L+i,1+i,1+i,"1,23,4,6,7,8,9,"+i));
                    System.out.println("生产了对象》》》》》》》》》》》"+(1L+i));
                }
                storage.push(list);
                page++;
            }
            System.out.println("对象生产已完成，共产生" + page * 10000 + "个对象");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
