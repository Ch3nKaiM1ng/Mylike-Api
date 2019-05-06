package com.mylike.utils;

import com.mylike.entity.Discuss;
import com.mylike.entity.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscussDTO {

    private Discuss discuss;
    private List<DiscussDTO> discussDTOS;


    public Discuss getDiscuss() {
        return discuss;
    }

    public void setDiscuss(Discuss discuss) {
        this.discuss = discuss;
    }

    public List<DiscussDTO> getDiscussDTOS() {
        return discussDTOS;
    }

    public void setDiscussDTOS(List<DiscussDTO> discussDTOS) {
        this.discussDTOS = discussDTOS;
    }

    public  List<DiscussDTO> convert(int parentId,List<Discuss> discusses) {

        Map<Integer, DiscussDTO> sortMap = new HashMap<>(discusses.size());
        List<DiscussDTO> result = new ArrayList<>();
        discusses.forEach(temp -> {

                    if (sortMap.containsKey(temp.getId())) {

                        sortMap.get(temp.getId()).setDiscuss(temp);
                    } else {

                        DiscussDTO dto = new DiscussDTO();
                        List<DiscussDTO> subList = new ArrayList<>();
                        dto.setDiscuss(temp);
                        dto.setDiscussDTOS(subList);
                        sortMap.put(temp.getId(), dto);
                    }

                    if (temp.getParentId() != parentId) {

                        DiscussDTO parent = sortMap.get(temp.getParentId());
                        if (parent == null) {
                            DiscussDTO dto = new DiscussDTO();
                            List<DiscussDTO> subList = new ArrayList<>();
                            dto.setDiscussDTOS(subList);
                            sortMap.put(temp.getParentId(), dto);
                        }else {
                            parent.getDiscussDTOS().add(sortMap.get(temp.getId()));
                        }
                    } else {
                        result.add(sortMap.get(temp.getId()));
                    }
                }
        );

        return result;
    }
}
