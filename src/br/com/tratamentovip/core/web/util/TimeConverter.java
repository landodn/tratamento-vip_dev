package br.com.tratamentovip.core.web.util;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("timeConverter")
public class TimeConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent ui, String arg){
		DateFormat df = new SimpleDateFormat("HH:mm");
		Time time = null;
		try{
			time = new Time(df.parse(arg).getTime());
		}catch(ParseException ex){
			ex.printStackTrace();
		}
		return time;
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent ui, Object obj){
		return obj.toString();
	}
}
