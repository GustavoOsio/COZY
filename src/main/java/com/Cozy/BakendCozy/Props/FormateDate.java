package com.Cozy.BakendCozy.Props;

import java.text.SimpleDateFormat;
import java.util.Date;


public class FormateDate {
	
	public String dateForman(Date currentDate ) {
	 
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      String formattedDate = dateFormat.format(currentDate);
      return formattedDate;

	}
}
