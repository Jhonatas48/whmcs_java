package me.hwiggy.whmjava.payload.g;

import me.hwiggy.whmjava.payload.Payload;

public class GetUsersPayload extends Payload {

	public GetUsersPayload() {
        super ("GetUsers");
    }
	
	
    public GetUsersPayload withLimitNum(int limitNum) {
	      put("limitnum", limitNum);

	      return this;
    }
    
    public GetUsersPayload withLimitStart(int limitStart) {
        put("limitstart", limitStart);

        return this;
    }
    
    public GetUsersPayload sorting(String sorting) {
        put("sorting", sorting);

        return this;
    }
    
    public GetUsersPayload search(String search) {
    	put("search", search);

        return this;
    }
	
}
