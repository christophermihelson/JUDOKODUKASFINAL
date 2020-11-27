package com.KODULEHT.Service;

import com.KODULEHT.Classes.MemberID;
import com.KODULEHT.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledTask {

    @Autowired
    Repository repository;

    @Scheduled(cron = "0 0 0 1 * ? *")
    public void automatedMonthlyPayments() {
    }

    public void manualMonthlyPayments() {

        List<MemberID> memberIDList = new ArrayList<>(repository.getAllMemberIDs());

        for (int i = 0; i < memberIDList.size(); i++) {
            if (!(memberIDList == null)){
            // siia loogika, et kõikidele kehtivatele memberitele lisaks uue Payment kuu
            }
        }
    }

}
