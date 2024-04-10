package com.astha.spring.DemoSpringApp.enterprise.example.business;

import com.astha.spring.DemoSpringApp.enterprise.example.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BusinessService{

    //without setter it will do field injection
    @Autowired
    private DataService dataService;


    //setter injection

    //@Autowired
//    public void setDataService(DataService dataService) {
//        System.out.println("Setter Injection");
//        this.dataService = dataService;
//    }

    public long calculateSum(){
      List<Integer> data=dataService.getData();
      return data.stream().reduce(Integer::sum).get();

    }
}
