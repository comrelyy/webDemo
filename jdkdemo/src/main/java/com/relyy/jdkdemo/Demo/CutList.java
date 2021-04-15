package com.relyy.jdkdemo.Demo;

import java.util.ArrayList;
import java.util.List;

public class CutList {

    public List<List<String>> cutBydiff(List<String> list, Integer firstPage, Integer remainPage){
        List<List<String>> missionList = new ArrayList<List<String>>();

        Integer listSize = list.size();

        for (int i=0 ; i < listSize; i++) {
            if (i == firstPage - 1) {
                missionList.add(list.subList(0, firstPage));
            } else if ((i > firstPage) && ((i-firstPage+1) % remainPage == 0)) {
                missionList.add(list.subList(i-remainPage+1,i+1));
            } else if(((i-firstPage+1) % remainPage != 0 ) && (i == listSize-1) ){
                missionList.add(list.subList(listSize - ((i-firstPage+1) % remainPage),listSize));
            }
        }

        return missionList;
    }

    public static void getUserInfoMap(List<String> ids){



        if (ids != null && !ids.isEmpty()) {
            int size = ids.size();
            int index = size % 20 == 0 ? (size / 20) : (size /20)+1;

            for (int i = 0; i < index ; i++) {
                List<String> list = null;
               if (i == index - 1){
                    System.out.println(ids.subList(20*i,size).toString());
                }else {
                    System.out.println(ids.subList(20*i,20*(i+1)).toString());
                }

            }
        }



    }

    public static void main(String[] args){
        List<String> list = new ArrayList<String>();

        list.add("aa");
        list.add("ab");
        list.add("ac");
        list.add("ad");
        list.add("ae");
        list.add("af");
        list.add("ag");
        list.add("ah");
        list.add("ai");
        list.add("aj");
        list.add("ak");
        list.add("al");
        list.add("am");
        list.add("an");
        list.add("ao");
        list.add("ap");
        list.add("aq");
        list.add("ar");
        list.add("as");
        list.add("at");
        list.add("au");
        list.add("av");
        list.add("aw");
        list.add("ax");
        list.add("ay");
        list.add("az");
        list.add("bz");
        list.add("cz");
        list.add("dz");
        list.add("ez");
        list.add("fz");
        list.add("gz");
        list.add("hz");
        list.add("iz");
        list.add("gz");
        list.add("kz");
        list.add("lz");
        list.add("mz");
        list.add("nz");
        list.add("oz");

        //CutList cutDemo = new CutList();
        getUserInfoMap(list);
       // List<List<String>> cutList = cutDemo.cutBydiff(list,6,7);
        //System.out.println(cutList);

       // System.out.println((7-6+1)%7);

    }
}
