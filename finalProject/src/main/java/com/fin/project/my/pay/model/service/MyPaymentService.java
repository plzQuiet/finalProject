package com.fin.project.my.pay.model.service;

import java.util.Map;

public interface MyPaymentService {

	Map<String, Object> payment(int memberNo, int cp);

}
