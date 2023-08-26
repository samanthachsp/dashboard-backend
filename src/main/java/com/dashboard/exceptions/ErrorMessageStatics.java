package com.dashboard.exceptions;

public class ErrorMessageStatics {

	public static final String FAILED_UPLOAD_MESSAGE = "You failed to upload [%s] because %s";
	public static final String FAILED_DELETE_MESSAGE = "You failed to delete [%s] because %s";
	public static final String SUCCESS_UPLOAD_MESSAGE = "You have successfully uploaded the file = [%s]";
	public static final String SUCCESS_DELETE_MESSAGE = "You have successfully deleted the file = [%s]";
	public static final String PLEASE_ENTER_HOTEL_NAME = " Please enter hotel name";
	public static final String INVALID_USER = "Invalid user name or password. Please try again...";
	public static final String INVALID_NOOF_PASSENGERS_EXCEPTION = "Invalid no of passengers. Please enter only numbers.";
	public static final String INVALID_NOOF_LUGGAGES_EXCEPTION = "Invalid no of luggages. Please enter only numbers.";
	public static final String INVALID_NOOF_DOORS_EXCEPTION = "Invalid no of doors. Please enter only numbers.";
	public static final String INVALID_CC_EXCEPTION = "Invalid engine capacity. Please enter only numbers.";
	public static final String INVALID_REFUNDABLE_DEPOSIT_EXCEPTION = "Invalid refundable deposit. Please enter only numbers.";
	public static final String INVALID_RENTAL_EXCEPTION = "Invalid rental per day. Please enter only numbers.";
	public static final String INVALID_FREE_MILAGE_EXCEPTION = "Invalid free milage. Please enter only numbers.";
	public static final String INVALID_PER_KM_EXCEPTION = "Invalid per km charge. Please enter only numbers.";
	public static final String INVALID_LISCENCE_EXCEPTION = "Invalid liscence no. Sample XXX-1234 or XX-1234. No spaces allowed.";
	public static final String INVALID_VEHICLE_TYPE_EXCEPTION = "Please select vehicle type.";
	public static final String INVALID_VEHICLE_MAKE_EXCEPTION = "Please select vehicle make.";
	public static final String INVALID_VEHICLE_MODEL_EXCEPTION = "Please select vehicle model.";
	public static final String INVALID_VEHICLE_TRANSMISSION_EXCEPTION = "Please select vehicle transmission.";
	public static final String INVALID_VEHICLE_COLOR_EXCEPTION = "Please select vehicle color.";
	public static final String INVALID_VEHICLE_FUEL_TYPE_EXCEPTION = "Please select fuel type.";
	
	public static final String USER_ALREDY_EXIST(String email, String phone) {
		return new StringBuilder("Partner already exist with the email : ").append(email).append(" or phone no: ")
				.append(phone).append(".").toString();
	}
    
}
