package com.restapi.Challenges;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ChallengeService {
    private List<Challenge> challenges=new ArrayList<>();
    private Long nextId=2L;

    public ChallengeService(){
        Challenge challenge1=new Challenge(1L,"March","Learn Java Spring Boot");
        challenges.add(challenge1);
    }

    public List<Challenge> getAllChallenges(){
        return challenges;
    }
    public Boolean addChallenge(Challenge challenge){
        if(challenges!=null){
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        }
        else{
            return false;
        }
    }

    public Challenge getChallenge(String month){
        for(Challenge challenge:challenges){
            if(challenge.getMonth().equals(month)){
                return challenge;
            }
        }
        return null;
    }

    public boolean updateChallenge(Long id, Challenge updatedChallenge) {
        for(Challenge challenge:challenges){
            if(challenge.getId().equals(id)){
                challenge.setMonth(updatedChallenge.getMonth());
                challenge.setDescription(updatedChallenge.getDescription());
                return true;
            }

        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        boolean isChallengeDeleted=challenges.removeIf(challenge -> challenge.getId().equals(id));
        if(isChallengeDeleted){
            return true;
        }
        return false;
    }
}
