package com.mylike.service;

import com.mylike.entity.Complain;

public interface ComplainService {
    int install(Complain complain);

    Object selectComplain(Integer state);

    int updateState(Complain complain);
}
