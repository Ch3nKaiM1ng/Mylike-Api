package com.mylike.utils;

import com.alibaba.fastjson.JSON;
import com.mylike.entity.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortDTO {

    private Sort sort;
    private List<SortDTO> sortDTOs;


    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public List<SortDTO> getSortDTOs() {
        return sortDTOs;
    }

    public void setSortDTOs(List<SortDTO> sortDTOs) {
        this.sortDTOs = sortDTOs;
    }


    public  List<SortDTO> convert(Integer sSid,List<Sort> sorts) {

        Map<Integer, SortDTO> sortMap = new HashMap<>(sorts.size());
        List<SortDTO> result = new ArrayList<>();
        sorts.forEach(temp -> {

                    if (sortMap.containsKey(temp.getsId())) {

                        sortMap.get(temp.getsId()).setSort(temp);
                    } else {

                        SortDTO dto = new SortDTO();
                        List<SortDTO> subList = new ArrayList<>();
                        dto.setSort(temp);
                        dto.setSortDTOs(subList);
                        sortMap.put(temp.getsId(), dto);
                    }

                    if (temp.getsSid() != sSid) {

                        SortDTO parent = sortMap.get(temp.getsSid());
                        if (parent == null) {
                            SortDTO dto = new SortDTO();
                            List<SortDTO> subList = new ArrayList<>();
                            dto.setSortDTOs(subList);
                            sortMap.put(temp.getsSid(), dto);
                        }else {
                            parent.getSortDTOs().add(sortMap.get(temp.getsId()));
                        }
                    } else {
                        result.add(sortMap.get(temp.getsId()));
                    }
                }
        );

        return result;
    }
}
