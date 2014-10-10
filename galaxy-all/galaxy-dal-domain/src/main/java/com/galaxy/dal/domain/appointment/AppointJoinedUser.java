package com.galaxy.dal.domain.appointment;

import com.galaxy.dal.domain.BaseDomain;

public class AppointJoinedUser extends BaseDomain {
Long appointment_id;
Long joined_user_id;
String joined_user_sex;
String joined_user_name;
boolean autid;
public Long getAppointment_id() {
	return appointment_id;
}
public void setAppointment_id(Long appointment_id) {
	this.appointment_id = appointment_id;
}
public Long getJoined_user_id() {
	return joined_user_id;
}
public void setJoined_user_id(Long joined_user_id) {
	this.joined_user_id = joined_user_id;
}
public String getJoined_user_name() {
	return joined_user_name;
}
public void setJoined_user_name(String joined_user_name) {
	this.joined_user_name = joined_user_name;
}
public boolean isAutid() {
	return autid;
}
public void setAutid(boolean autid) {
	this.autid = autid;
}


}
