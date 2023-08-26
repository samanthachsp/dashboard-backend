package com.dashboard.common;

import java.util.List;

public class Tuple<K, V> {

    private K first;
    private V second;
  
    public Tuple(K first, V second){
        this.first = first;
        this.second = second;
    }
    public String sqlCombinations() {
    	List<String> list = (List<String>)first;
    	return list.size() == 1 ? new StringBuilder("(Like '%")
    			.append(list.get(0).toLowerCase())
    			.append("%' and Like '%")
    			.append(second.toString().toLowerCase()).append("%')")
    			.append(" or (Like '%")
    			.append(second.toString().toLowerCase())
    			.append("%' and Like '%")
    	    	.append(list.get(0).toLowerCase()).append("%')").toString() : null;
    }
}
